package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;

public abstract class AbstractTabChildPreference
  extends MMPreferenceFragment
  implements o
{
  private boolean VPs;
  private boolean VPt;
  private boolean VPu;
  private boolean VPv;
  protected boolean VPw = false;
  protected boolean VPx = false;
  protected boolean VPy;
  private Bundle savedInstanceState;
  
  private void hFn()
  {
    if (this.VPt)
    {
      hFb();
      this.VPt = false;
    }
    while (!this.VPs) {
      return;
    }
    hFg();
    hFb();
    Log.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
    this.VPs = false;
  }
  
  protected abstract void hFb();
  
  protected abstract void hFc();
  
  protected abstract void hFd();
  
  protected abstract void hFe();
  
  protected abstract void hFf();
  
  protected abstract void hFg();
  
  public final void hFk()
  {
    hFi();
    this.VPu = true;
  }
  
  public final void hFm()
  {
    this.VPx = true;
  }
  
  public final void hFo()
  {
    if (!this.VPw) {
      return;
    }
    hFn();
    long l = System.currentTimeMillis();
    if (this.VPu)
    {
      hFj();
      this.VPu = false;
    }
    hKS();
    hFc();
    Log.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
    this.VPv = true;
    this.VPw = false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.savedInstanceState = paramBundle;
    this.VPt = true;
  }
  
  public void onDestroy()
  {
    hFg();
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
    this.VPy = true;
    if (this.VPy)
    {
      if (!this.VPv) {
        this.VPy = false;
      }
    }
    else {
      return;
    }
    long l = System.currentTimeMillis();
    hFe();
    Log.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - l));
    this.VPv = false;
    this.VPy = false;
  }
  
  public void onResume()
  {
    super.onResume();
    hFl();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.VXn)) {}
    do
    {
      return;
      this.VPw = true;
    } while (!this.VPx);
    hFo();
    this.VPx = false;
  }
  
  public void onStart()
  {
    super.onStart();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.VXn)) {
      return;
    }
    hFd();
  }
  
  public void onStop()
  {
    super.onStop();
    hFf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildPreference
 * JD-Core Version:    0.7.0.1
 */