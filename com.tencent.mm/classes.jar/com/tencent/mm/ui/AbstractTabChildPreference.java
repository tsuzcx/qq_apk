package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;

public abstract class AbstractTabChildPreference
  extends MMPreferenceFragment
  implements m
{
  private Bundle rMc;
  private boolean yTf;
  private boolean yTg;
  private boolean yTh;
  private boolean yTi;
  protected boolean yTj = false;
  protected boolean yTk = false;
  protected boolean yTl;
  
  private void dAK()
  {
    if (this.yTg)
    {
      dAy();
      this.yTg = false;
    }
    while (!this.yTf) {
      return;
    }
    dAD();
    dAy();
    ab.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
    this.yTf = false;
  }
  
  protected abstract void dAA();
  
  protected abstract void dAB();
  
  protected abstract void dAC();
  
  protected abstract void dAD();
  
  public final void dAH()
  {
    dAF();
    this.yTh = true;
  }
  
  public final void dAJ()
  {
    this.yTk = true;
  }
  
  public final void dAL()
  {
    if (!this.yTj) {
      return;
    }
    dAK();
    long l = System.currentTimeMillis();
    if (this.yTh)
    {
      dAG();
      this.yTh = false;
    }
    dEP();
    dAz();
    ab.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
    this.yTi = true;
    this.yTj = false;
  }
  
  protected abstract void dAy();
  
  protected abstract void dAz();
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.rMc = paramBundle;
    this.yTg = true;
  }
  
  public void onDestroy()
  {
    dAD();
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
    this.yTl = true;
    if (this.yTl)
    {
      if (!this.yTi) {
        this.yTl = false;
      }
    }
    else {
      return;
    }
    long l = System.currentTimeMillis();
    dAB();
    ab.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - l));
    this.yTi = false;
    this.yTl = false;
  }
  
  public void onResume()
  {
    super.onResume();
    dAI();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.yYW)) {}
    do
    {
      return;
      this.yTj = true;
    } while (!this.yTk);
    dAL();
    this.yTk = false;
  }
  
  public void onStart()
  {
    super.onStart();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.yYW)) {
      return;
    }
    dAA();
  }
  
  public void onStop()
  {
    super.onStop();
    dAC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildPreference
 * JD-Core Version:    0.7.0.1
 */