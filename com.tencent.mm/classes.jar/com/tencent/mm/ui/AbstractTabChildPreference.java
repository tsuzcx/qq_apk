package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;

public abstract class AbstractTabChildPreference
  extends MMPreferenceFragment
  implements m
{
  private Bundle AoM;
  private boolean JmB;
  private boolean JmC;
  private boolean JmD;
  private boolean JmE;
  protected boolean JmF = false;
  protected boolean JmG = false;
  protected boolean JmH;
  
  private void fyS()
  {
    if (this.JmC)
    {
      fyG();
      this.JmC = false;
    }
    while (!this.JmB) {
      return;
    }
    fyL();
    fyG();
    ae.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
    this.JmB = false;
  }
  
  protected abstract void fyG();
  
  protected abstract void fyH();
  
  protected abstract void fyI();
  
  protected abstract void fyJ();
  
  protected abstract void fyK();
  
  protected abstract void fyL();
  
  public final void fyP()
  {
    fyN();
    this.JmD = true;
  }
  
  public final void fyR()
  {
    this.JmG = true;
  }
  
  public final void fyT()
  {
    if (!this.JmF) {
      return;
    }
    fyS();
    long l = System.currentTimeMillis();
    if (this.JmD)
    {
      fyO();
      this.JmD = false;
    }
    fDI();
    fyH();
    ae.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
    this.JmE = true;
    this.JmF = false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.AoM = paramBundle;
    this.JmC = true;
  }
  
  public void onDestroy()
  {
    fyL();
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
    this.JmH = true;
    if (this.JmH)
    {
      if (!this.JmE) {
        this.JmH = false;
      }
    }
    else {
      return;
    }
    long l = System.currentTimeMillis();
    fyJ();
    ae.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - l));
    this.JmE = false;
    this.JmH = false;
  }
  
  public void onResume()
  {
    super.onResume();
    fyQ();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.JtB)) {}
    do
    {
      return;
      this.JmF = true;
    } while (!this.JmG);
    fyT();
    this.JmG = false;
  }
  
  public void onStart()
  {
    super.onStart();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.JtB)) {
      return;
    }
    fyI();
  }
  
  public void onStop()
  {
    super.onStop();
    fyK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildPreference
 * JD-Core Version:    0.7.0.1
 */