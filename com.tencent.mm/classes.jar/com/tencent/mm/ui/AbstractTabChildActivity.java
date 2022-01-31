package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.y;

public abstract class AbstractTabChildActivity
  extends AppCompatActivity
{
  public static abstract class a
    extends x
    implements o
  {
    private Bundle oUg;
    private boolean uGi;
    private boolean uGj;
    private boolean uGk;
    protected boolean uGl;
    protected boolean uGm = false;
    protected boolean uGn = false;
    protected boolean uGo;
    protected boolean uGp = false;
    
    public abstract void cxD();
    
    public abstract void cxE();
    
    public abstract void cxF();
    
    public abstract void cxG();
    
    public abstract void cxH();
    
    public abstract void cxI();
    
    public abstract void cxJ();
    
    public abstract void cxK();
    
    public abstract void cxL();
    
    public final void cxM()
    {
      cxK();
      this.uGk = true;
    }
    
    public final void cxN() {}
    
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
        this.uGp = true;
        long l = System.currentTimeMillis();
        if (this.uGk)
        {
          this.uGk = false;
          cxL();
        }
        cxE();
        y.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
        this.uGl = true;
        this.uGm = false;
        return;
        if (this.uGi)
        {
          if (this.uGp) {
            cxI();
          }
          cxD();
          y.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
          this.uGi = false;
        }
      }
    }
    
    public int getLayoutId()
    {
      return 0;
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      super.onActivityCreated(paramBundle);
      this.uGj = true;
      this.oUg = paramBundle;
    }
    
    public void onDestroy()
    {
      if (this.uGp) {
        cxI();
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
    
    public boolean supportNavigationSwipeBack()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildActivity
 * JD-Core Version:    0.7.0.1
 */