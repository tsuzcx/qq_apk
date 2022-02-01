package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class AbstractTabChildActivity$AbStractTabFragment
  extends MMFragment
  implements m
{
  private boolean IRT;
  private boolean IRU;
  private boolean IRV;
  protected boolean IRW;
  protected boolean IRX = false;
  protected boolean IRY = false;
  protected boolean IRZ;
  protected boolean ISa = false;
  private Bundle zXB;
  
  private void fuR()
  {
    if (this.IRU)
    {
      fuF();
      this.IRU = false;
    }
    for (;;)
    {
      this.ISa = true;
      return;
      if (this.IRT)
      {
        if (this.ISa) {
          fuK();
        }
        fuF();
        ad.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
        this.IRT = false;
      }
    }
  }
  
  protected abstract void fuF();
  
  protected abstract void fuG();
  
  protected abstract void fuH();
  
  protected abstract void fuI();
  
  protected abstract void fuJ();
  
  protected abstract void fuK();
  
  public abstract void fuL();
  
  public abstract void fuM();
  
  public abstract void fuN();
  
  public final void fuO()
  {
    fuM();
    this.IRV = true;
  }
  
  public final void fuP() {}
  
  public final void fuQ()
  {
    this.IRY = true;
  }
  
  public final void fuS()
  {
    if (!this.IRX) {
      return;
    }
    fuR();
    long l = System.currentTimeMillis();
    if (this.IRV)
    {
      this.IRV = false;
      fuN();
    }
    fuG();
    ad.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
    this.IRW = true;
    this.IRX = false;
  }
  
  protected int getLayoutId()
  {
    return 0;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.IRU = true;
    this.zXB = paramBundle;
  }
  
  public void onDestroy()
  {
    if (this.ISa) {
      fuK();
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
    this.IRZ = true;
    if (this.IRZ)
    {
      if (!this.IRW) {
        this.IRZ = false;
      }
    }
    else {
      return;
    }
    long l = System.currentTimeMillis();
    fuI();
    ad.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - l));
    this.IRW = false;
    this.IRZ = false;
  }
  
  public void onResume()
  {
    super.onResume();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.IYT)) {}
    do
    {
      return;
      this.IRX = true;
    } while (!this.IRY);
    fuS();
    this.IRY = false;
  }
  
  public void onStart()
  {
    super.onStart();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.IYT)) {
      return;
    }
    fuH();
  }
  
  public void onStop()
  {
    super.onStop();
    fuJ();
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