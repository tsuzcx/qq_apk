package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.base.preference.i;

public abstract class a
  extends i
  implements o
{
  private Bundle oUg;
  private boolean uGi;
  private boolean uGj;
  private boolean uGk;
  private boolean uGl;
  protected boolean uGm = false;
  protected boolean uGn = false;
  protected boolean uGo;
  
  protected abstract void cxD();
  
  protected abstract void cxE();
  
  protected abstract void cxF();
  
  protected abstract void cxG();
  
  protected abstract void cxH();
  
  protected abstract void cxI();
  
  public final void cxM()
  {
    cxK();
    this.uGk = true;
  }
  
  public final void cxO()
  {
    this.uGn = true;
  }
  
  public final void cxP()
  {
    if (!this.uGm) {
      return;
    }
    if (this.uGj)
    {
      cxD();
      this.uGj = false;
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if (this.uGk)
      {
        cxL();
        this.uGk = false;
      }
      if (!this.vdv)
      {
        int i = xj();
        if (i != -1)
        {
          this.vdd.addPreferencesFromResource(i);
          this.vdv = true;
        }
      }
      cxE();
      y.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
      this.uGl = true;
      this.uGm = false;
      return;
      if (this.uGi)
      {
        cxI();
        cxD();
        y.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
        this.uGi = false;
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.oUg = paramBundle;
    this.uGj = true;
  }
  
  public void onDestroy()
  {
    cxI();
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
    this.uGo = true;
    if (this.uGo)
    {
      if (!this.uGl) {
        this.uGo = false;
      }
    }
    else {
      return;
    }
    long l = System.currentTimeMillis();
    cxG();
    y.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - l));
    this.uGl = false;
    this.uGo = false;
  }
  
  public void onResume()
  {
    super.onResume();
    cxN();
    LauncherUI localLauncherUI = LauncherUI.cyX();
    if ((localLauncherUI == null) || (!localLauncherUI.uKT)) {}
    do
    {
      return;
      this.uGm = true;
    } while (!this.uGn);
    cxP();
    this.uGn = false;
  }
  
  public void onStart()
  {
    super.onStart();
    LauncherUI localLauncherUI = LauncherUI.cyX();
    if ((localLauncherUI == null) || (!localLauncherUI.uKT)) {
      return;
    }
    cxF();
  }
  
  public void onStop()
  {
    super.onStop();
    cxH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.a
 * JD-Core Version:    0.7.0.1
 */