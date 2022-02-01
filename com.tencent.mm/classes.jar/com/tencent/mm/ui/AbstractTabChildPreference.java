package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;

public abstract class AbstractTabChildPreference
  extends MMPreferenceFragment
  implements m
{
  private boolean IRT;
  private boolean IRU;
  private boolean IRV;
  private boolean IRW;
  protected boolean IRX = false;
  protected boolean IRY = false;
  protected boolean IRZ;
  private Bundle zXB;
  
  private void fuR()
  {
    if (this.IRU)
    {
      fuF();
      this.IRU = false;
    }
    while (!this.IRT) {
      return;
    }
    fuK();
    fuF();
    ad.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
    this.IRT = false;
  }
  
  protected abstract void fuF();
  
  protected abstract void fuG();
  
  protected abstract void fuH();
  
  protected abstract void fuI();
  
  protected abstract void fuJ();
  
  protected abstract void fuK();
  
  public final void fuO()
  {
    fuM();
    this.IRV = true;
  }
  
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
      fuN();
      this.IRV = false;
    }
    fzG();
    fuG();
    ad.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
    this.IRW = true;
    this.IRX = false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.zXB = paramBundle;
    this.IRU = true;
  }
  
  public void onDestroy()
  {
    fuK();
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
    fuP();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildPreference
 * JD-Core Version:    0.7.0.1
 */