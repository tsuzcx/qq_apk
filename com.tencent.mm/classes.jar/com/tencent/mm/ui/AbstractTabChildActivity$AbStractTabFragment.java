package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class AbstractTabChildActivity$AbStractTabFragment
  extends MMFragment
  implements o
{
  private boolean VPs;
  private boolean VPt;
  private boolean VPu;
  protected boolean VPv;
  protected boolean VPw = false;
  protected boolean VPx = false;
  protected boolean VPy;
  protected boolean VPz = false;
  private Bundle savedInstanceState;
  
  private void hFn()
  {
    Log.i("MicroMsg.INIT", "checkNeedRecreate");
    if (this.VPt)
    {
      hFb();
      this.VPt = false;
    }
    for (;;)
    {
      this.VPz = true;
      return;
      if (this.VPs)
      {
        if (this.VPz) {
          hFg();
        }
        hFb();
        Log.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
        this.VPs = false;
      }
    }
  }
  
  protected int getLayoutId()
  {
    return 0;
  }
  
  protected abstract void hFb();
  
  protected abstract void hFc();
  
  protected abstract void hFd();
  
  protected abstract void hFe();
  
  protected abstract void hFf();
  
  protected abstract void hFg();
  
  public abstract void hFh();
  
  public abstract void hFi();
  
  public abstract void hFj();
  
  public final void hFk()
  {
    hFi();
    this.VPu = true;
  }
  
  public final void hFl() {}
  
  public final void hFm()
  {
    this.VPx = true;
  }
  
  public final void hFo()
  {
    Log.i("MicroMsg.INIT", "deliverOnTabResume %s", new Object[] { Boolean.valueOf(this.VPw) });
    if (!this.VPw) {
      return;
    }
    hFn();
    long l = System.currentTimeMillis();
    if (this.VPu)
    {
      this.VPu = false;
      hFj();
    }
    hFc();
    Log.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
    this.VPv = true;
    this.VPw = false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.VPt = true;
    this.savedInstanceState = paramBundle;
  }
  
  public void onDestroy()
  {
    if (this.VPz) {
      hFg();
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
    Log.i("MicroMsg.INIT", "onPause");
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
    Log.i("MicroMsg.INIT", "onResume");
    super.onResume();
    Log.i("MicroMsg.INIT", "resumeWithVerify %s", new Object[] { Boolean.valueOf(this.VPw) });
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
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
 * JD-Core Version:    0.7.0.1
 */