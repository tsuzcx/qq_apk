package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;

public abstract class AbstractTabChildPreference
  extends MMPreferenceFragment
  implements n
{
  protected boolean OwA;
  private boolean Owu;
  private boolean Owv;
  private boolean Oww;
  private boolean Owx;
  protected boolean Owy = false;
  protected boolean Owz = false;
  private Bundle savedInstanceState;
  
  private void gGG()
  {
    if (this.Owv)
    {
      gGu();
      this.Owv = false;
    }
    while (!this.Owu) {
      return;
    }
    gGz();
    gGu();
    Log.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
    this.Owu = false;
  }
  
  public final void gGD()
  {
    gGB();
    this.Oww = true;
  }
  
  public final void gGF()
  {
    this.Owz = true;
  }
  
  public final void gGH()
  {
    if (!this.Owy) {
      return;
    }
    gGG();
    long l = System.currentTimeMillis();
    if (this.Oww)
    {
      gGC();
      this.Oww = false;
    }
    gLO();
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
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.savedInstanceState = paramBundle;
    this.Owv = true;
  }
  
  public void onDestroy()
  {
    gGz();
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
    super.onResume();
    gGE();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildPreference
 * JD-Core Version:    0.7.0.1
 */