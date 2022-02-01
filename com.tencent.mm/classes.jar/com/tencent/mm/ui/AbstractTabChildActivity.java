package com.tencent.mm.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class AbstractTabChildActivity
  extends AppCompatActivity
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract class AbStractTabFragment
    extends MMFragment
    implements m
  {
    private boolean FFA;
    private boolean FFB;
    private boolean FFC;
    protected boolean FFD;
    protected boolean FFE = false;
    protected boolean FFF = false;
    protected boolean FFG;
    protected boolean FFH = false;
    private Bundle xtt;
    
    private void ePg()
    {
      if (this.FFB)
      {
        eOU();
        this.FFB = false;
      }
      for (;;)
      {
        this.FFH = true;
        return;
        if (this.FFA)
        {
          if (this.FFH) {
            eOZ();
          }
          eOU();
          ad.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
          this.FFA = false;
        }
      }
    }
    
    protected abstract void eOU();
    
    protected abstract void eOV();
    
    protected abstract void eOW();
    
    protected abstract void eOX();
    
    protected abstract void eOY();
    
    protected abstract void eOZ();
    
    public abstract void ePa();
    
    public abstract void ePb();
    
    public abstract void ePc();
    
    public final void ePd()
    {
      ePb();
      this.FFC = true;
    }
    
    public final void ePe() {}
    
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
        this.FFC = false;
        ePc();
      }
      eOV();
      ad.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - l));
      this.FFD = true;
      this.FFE = false;
    }
    
    protected int getLayoutId()
    {
      return 0;
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      super.onActivityCreated(paramBundle);
      this.FFB = true;
      this.xtt = paramBundle;
    }
    
    public void onDestroy()
    {
      if (this.FFH) {
        eOZ();
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
    
    public boolean supportNavigationSwipeBack()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.AbstractTabChildActivity
 * JD-Core Version:    0.7.0.1
 */