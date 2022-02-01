package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;

public abstract class AbstractTabChildPreference
  extends MMPreferenceFragment
  implements m
{
  private boolean FFA;
  private boolean FFB;
  private boolean FFC;
  private boolean FFD;
  protected boolean FFE = false;
  protected boolean FFF = false;
  protected boolean FFG;
  private Bundle xtt;
  
  private void ePg()
  {
    if (this.FFB)
    {
      eOU();
      this.FFB = false;
    }
    while (!this.FFA) {
      return;
    }
    eOZ();
    eOU();
    ad.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
    this.FFA = false;
  }
  
  protected abstract void eOU();
  
  protected abstract void eOV();
  
  protected abstract void eOW();
  
  protected abstract void eOX();
  
  protected abstract void eOY();
  
  protected abstract void eOZ();
  
  public final void ePd()
  {
    ePb();
    this.FFC = true;
  }
  
  public final void ePf()
  {
    this.FFF = true;
  }
  
  public final void ePh()
  {
    if (!this.FFE) {
      return;
    }
    ePg();
    long l = System.currentTimeMillis();
    if (this.FFC)
    {
      ePc();
      this.FFC = false;
    }
    eTF();
    eOV();
    ad.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
    this.FFD = true;
    this.FFE = false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.xtt = paramBundle;
    this.FFB = true;
  }
  
  public void onDestroy()
  {
    eOZ();
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
    this.FFG = true;
    if (this.FFG)
    {
      if (!this.FFD) {
        this.FFG = false;
      }
    }
    else {
      return;
    }
    long l = System.currentTimeMillis();
    eOX();
    ad.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - l));
    this.FFD = false;
    this.FFG = false;
  }
  
  public void onResume()
  {
    super.onResume();
    ePe();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.FMe)) {}
    do
    {
      return;
      this.FFE = true;
    } while (!this.FFF);
    ePh();
    this.FFF = false;
  }
  
  public void onStart()
  {
    super.onStart();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.FMe)) {
      return;
    }
    eOW();
  }
  
  public void onStop()
  {
    super.onStop();
    eOY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildPreference
 * JD-Core Version:    0.7.0.1
 */