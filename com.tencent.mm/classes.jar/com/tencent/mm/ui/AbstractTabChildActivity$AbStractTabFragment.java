package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class AbstractTabChildActivity$AbStractTabFragment
  extends MMFragment
  implements p
{
  protected boolean adtA;
  protected boolean adtB = false;
  protected boolean adtC = false;
  protected boolean adtD;
  protected boolean adtE = false;
  private boolean adtx;
  private boolean adty;
  private boolean adtz;
  private Bundle savedInstanceState;
  
  private void jhz()
  {
    Log.i("MicroMsg.INIT", "checkNeedRecreate");
    if (this.adty)
    {
      jhn();
      this.adty = false;
    }
    for (;;)
    {
      this.adtE = true;
      return;
      if (this.adtx)
      {
        if (this.adtE) {
          jhs();
        }
        jhn();
        Log.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
        this.adtx = false;
      }
    }
  }
  
  protected int getLayoutId()
  {
    return 0;
  }
  
  public final void jhA()
  {
    Log.i("MicroMsg.INIT", "deliverOnTabResume %s", new Object[] { Boolean.valueOf(this.adtB) });
    if (!this.adtB) {
      return;
    }
    jhz();
    long l = System.currentTimeMillis();
    if (this.adtz)
    {
      this.adtz = false;
      jhv();
    }
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
  
  public abstract void jht();
  
  public abstract void jhu();
  
  public abstract void jhv();
  
  public final void jhw()
  {
    jhu();
    this.adtz = true;
  }
  
  public final void jhx() {}
  
  public final void jhy()
  {
    this.adtC = true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.adty = true;
    this.savedInstanceState = paramBundle;
  }
  
  public void onDestroy()
  {
    if (this.adtE) {
      jhs();
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
    Log.i("MicroMsg.INIT", "onResume");
    super.onResume();
    Log.i("MicroMsg.INIT", "resumeWithVerify %s", new Object[] { Boolean.valueOf(this.adtB) });
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
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
 * JD-Core Version:    0.7.0.1
 */