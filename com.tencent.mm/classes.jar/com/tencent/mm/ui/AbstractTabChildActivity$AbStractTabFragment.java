package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class AbstractTabChildActivity$AbStractTabFragment
  extends MMFragment
  implements m
{
  private Bundle AoM;
  private boolean JmB;
  private boolean JmC;
  private boolean JmD;
  protected boolean JmE;
  protected boolean JmF = false;
  protected boolean JmG = false;
  protected boolean JmH;
  protected boolean JmI = false;
  
  private void fyS()
  {
    if (this.JmC)
    {
      fyG();
      this.JmC = false;
    }
    for (;;)
    {
      this.JmI = true;
      return;
      if (this.JmB)
      {
        if (this.JmI) {
          fyL();
        }
        fyG();
        ae.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
        this.JmB = false;
      }
    }
  }
  
  protected abstract void fyG();
  
  protected abstract void fyH();
  
  protected abstract void fyI();
  
  protected abstract void fyJ();
  
  protected abstract void fyK();
  
  protected abstract void fyL();
  
  public abstract void fyM();
  
  public abstract void fyN();
  
  public abstract void fyO();
  
  public final void fyP()
  {
    fyN();
    this.JmD = true;
  }
  
  public final void fyQ() {}
  
  public final void fyR()
  {
    this.JmG = true;
  }
  
  public final void fyT()
  {
    if (!this.JmF) {
      return;
    }
    fyS();
    long l = System.currentTimeMillis();
    if (this.JmD)
    {
      this.JmD = false;
      fyO();
    }
    fyH();
    ae.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
    this.JmE = true;
    this.JmF = false;
  }
  
  protected int getLayoutId()
  {
    return 0;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.JmC = true;
    this.AoM = paramBundle;
  }
  
  public void onDestroy()
  {
    if (this.JmI) {
      fyL();
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
    this.JmH = true;
    if (this.JmH)
    {
      if (!this.JmE) {
        this.JmH = false;
      }
    }
    else {
      return;
    }
    long l = System.currentTimeMillis();
    fyJ();
    ae.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - l));
    this.JmE = false;
    this.JmH = false;
  }
  
  public void onResume()
  {
    super.onResume();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.JtB)) {}
    do
    {
      return;
      this.JmF = true;
    } while (!this.JmG);
    fyT();
    this.JmG = false;
  }
  
  public void onStart()
  {
    super.onStart();
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if ((localLauncherUI == null) || (!localLauncherUI.JtB)) {
      return;
    }
    fyI();
  }
  
  public void onStop()
  {
    super.onStop();
    fyK();
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