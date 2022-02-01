package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;

public abstract class AbstractTabChildPreference
  extends MMPreferenceFragment
  implements m
{
  private boolean HeD;
  private boolean HeE;
  private boolean HeF;
  private boolean HeG;
  protected boolean HeH = false;
  protected boolean HeI = false;
  protected boolean HeJ;
  private Bundle yGj;
  
  private void feK()
  {
    if (this.HeE)
    {
      fey();
      this.HeE = false;
    }
    while (!this.HeD) {
      return;
    }
    feD();
    fey();
    ac.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
    this.HeD = false;
  }
  
  protected abstract void feA();
  
  protected abstract void feB();
  
  protected abstract void feC();
  
  protected abstract void feD();
  
  public final void feH()
  {
    feF();
    this.HeF = true;
  }
  
  public final void feJ()
  {
    this.HeI = true;
  }
  
  public final void feL()
  {
    if (!this.HeH) {
      return;
    }
    feK();
    long l = System.currentTimeMillis();
    if (this.HeF)
    {
      feG();
      this.HeF = false;
    }
    fjr();
    fez();
    ac.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
    this.HeG = true;
    this.HeH = false;
  }
  
  protected abstract void fey();
  
  protected abstract void fez();
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.yGj = paramBundle;
    this.HeE = true;
  }
  
  public void onDestroy()
  {
    feD();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0)) {
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.HeJ = true;
    if (this.HeJ)
    {
      if (!this.HeG) {
        this.HeJ = false;
      }
    }
    else {
      return;
    }
    long l = System.currentTimeMillis();
    feB();
    ac.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - l));
    this.HeG = false;
    this.HeJ = false;
  }
  
  public void onResume()
  {
    super.onResume();
    feI();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.Hlm)) {}
    do
    {
      return;
      this.HeH = true;
    } while (!this.HeI);
    feL();
    this.HeI = false;
  }
  
  public void onStart()
  {
    super.onStart();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.Hlm)) {
      return;
    }
    feA();
  }
  
  public void onStop()
  {
    super.onStop();
    feC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildPreference
 * JD-Core Version:    0.7.0.1
 */