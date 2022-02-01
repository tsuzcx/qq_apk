package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;

public abstract class AbstractTabChildPreference
  extends MMPreferenceFragment
  implements p
{
  private boolean adtA;
  protected boolean adtB = false;
  protected boolean adtC = false;
  protected boolean adtD;
  private boolean adtx;
  private boolean adty;
  private boolean adtz;
  private Bundle savedInstanceState;
  
  private void jhz()
  {
    if (this.adty)
    {
      jhn();
      this.adty = false;
    }
    while (!this.adtx) {
      return;
    }
    jhs();
    jhn();
    Log.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
    this.adtx = false;
  }
  
  public final void jhA()
  {
    if (!this.adtB) {
      return;
    }
    jhz();
    long l = System.currentTimeMillis();
    if (this.adtz)
    {
      jhv();
      this.adtz = false;
    }
    jnz();
    jho();
    Log.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
    this.adtA = true;
    this.adtB = false;
  }
  
  protected abstract void jhn();
  
  protected abstract void jho();
  
  protected abstract void jhp();
  
  protected abstract void jhq();
  
  protected abstract void jhr();
  
  protected abstract void jhs();
  
  public final void jhw()
  {
    jhu();
    this.adtz = true;
  }
  
  public final void jhy()
  {
    this.adtC = true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.savedInstanceState = paramBundle;
    this.adty = true;
  }
  
  public void onDestroy()
  {
    jhs();
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
    this.adtD = true;
    if (this.adtD)
    {
      if (!this.adtA) {
        this.adtD = false;
      }
    }
    else {
      return;
    }
    long l = System.currentTimeMillis();
    jhq();
    Log.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - l));
    this.adtA = false;
    this.adtD = false;
  }
  
  public void onResume()
  {
    super.onResume();
    jhx();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.adBJ)) {}
    do
    {
      return;
      this.adtB = true;
    } while (!this.adtC);
    jhA();
    this.adtC = false;
  }
  
  public void onStart()
  {
    super.onStart();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.adBJ)) {
      return;
    }
    jhp();
  }
  
  public void onStop()
  {
    super.onStop();
    jhr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildPreference
 * JD-Core Version:    0.7.0.1
 */