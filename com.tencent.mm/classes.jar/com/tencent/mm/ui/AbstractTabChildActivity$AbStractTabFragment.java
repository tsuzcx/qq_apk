package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class AbstractTabChildActivity$AbStractTabFragment
  extends MMFragment
  implements n
{
  protected boolean OwA;
  protected boolean OwB = false;
  private boolean Owu;
  private boolean Owv;
  private boolean Oww;
  protected boolean Owx;
  protected boolean Owy = false;
  protected boolean Owz = false;
  private Bundle savedInstanceState;
  
  private void gGG()
  {
    Log.i("MicroMsg.INIT", "checkNeedRecreate");
    if (this.Owv)
    {
      gGu();
      this.Owv = false;
    }
    for (;;)
    {
      this.OwB = true;
      return;
      if (this.Owu)
      {
        if (this.OwB) {
          gGz();
        }
        gGu();
        Log.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
        this.Owu = false;
      }
    }
  }
  
  public abstract void gGA();
  
  public abstract void gGB();
  
  public abstract void gGC();
  
  public final void gGD()
  {
    gGB();
    this.Oww = true;
  }
  
  public final void gGE() {}
  
  public final void gGF()
  {
    this.Owz = true;
  }
  
  public final void gGH()
  {
    Log.i("MicroMsg.INIT", "deliverOnTabResume %s", new Object[] { Boolean.valueOf(this.Owy) });
    if (!this.Owy) {
      return;
    }
    gGG();
    long l = System.currentTimeMillis();
    if (this.Oww)
    {
      this.Oww = false;
      gGC();
    }
    gGv();
    Log.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
    this.Owx = true;
    this.Owy = false;
  }
  
  protected abstract void gGu();
  
  protected abstract void gGv();
  
  protected abstract void gGw();
  
  protected abstract void gGx();
  
  protected abstract void gGy();
  
  protected abstract void gGz();
  
  protected int getLayoutId()
  {
    return 0;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.Owv = true;
    this.savedInstanceState = paramBundle;
  }
  
  public void onDestroy()
  {
    if (this.OwB) {
      gGz();
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
    this.OwA = true;
    if (this.OwA)
    {
      if (!this.Owx) {
        this.OwA = false;
      }
    }
    else {
      return;
    }
    long l = System.currentTimeMillis();
    gGx();
    Log.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - l));
    this.Owx = false;
    this.OwA = false;
  }
  
  public void onResume()
  {
    Log.i("MicroMsg.INIT", "onResume");
    super.onResume();
    Log.i("MicroMsg.INIT", "resumeWithVerify %s", new Object[] { Boolean.valueOf(this.Owy) });
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.ODU)) {}
    do
    {
      return;
      this.Owy = true;
    } while (!this.Owz);
    gGH();
    this.Owz = false;
  }
  
  public void onStart()
  {
    super.onStart();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.ODU)) {
      return;
    }
    gGw();
  }
  
  public void onStop()
  {
    super.onStop();
    gGy();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment
 * JD-Core Version:    0.7.0.1
 */