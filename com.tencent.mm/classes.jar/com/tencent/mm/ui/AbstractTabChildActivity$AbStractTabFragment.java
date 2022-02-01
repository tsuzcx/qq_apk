package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class AbstractTabChildActivity$AbStractTabFragment
  extends MMFragment
  implements m
{
  private boolean HeD;
  private boolean HeE;
  private boolean HeF;
  protected boolean HeG;
  protected boolean HeH = false;
  protected boolean HeI = false;
  protected boolean HeJ;
  protected boolean HeK = false;
  private Bundle yGj;
  
  private void feK()
  {
    if (this.HeE)
    {
      fey();
      this.HeE = false;
    }
    for (;;)
    {
      this.HeK = true;
      return;
      if (this.HeD)
      {
        if (this.HeK) {
          feD();
        }
        fey();
        ac.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
        this.HeD = false;
      }
    }
  }
  
  protected abstract void feA();
  
  protected abstract void feB();
  
  protected abstract void feC();
  
  protected abstract void feD();
  
  public abstract void feE();
  
  public abstract void feF();
  
  public abstract void feG();
  
  public final void feH()
  {
    feF();
    this.HeF = true;
  }
  
  public final void feI() {}
  
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
      this.HeF = false;
      feG();
    }
    fez();
    ac.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
    this.HeG = true;
    this.HeH = false;
  }
  
  protected abstract void fey();
  
  protected abstract void fez();
  
  protected int getLayoutId()
  {
    return 0;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.HeE = true;
    this.yGj = paramBundle;
  }
  
  public void onDestroy()
  {
    if (this.HeK) {
      feD();
    }
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
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
 * JD-Core Version:    0.7.0.1
 */