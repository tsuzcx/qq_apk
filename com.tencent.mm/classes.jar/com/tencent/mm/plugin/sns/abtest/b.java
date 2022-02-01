package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
{
  private Animation PKA;
  private Animation PKB;
  int PKC;
  int PKD;
  int PKE;
  int PKF;
  int PKG;
  boolean PKH;
  AbsoluteLayout PKI;
  boolean PKJ;
  boolean PKK;
  NotInterestMenu.c PKq;
  NotInterestMenu PKv;
  ViewGroup PKw;
  NotInterestMenu.b PKx;
  Animation PKy;
  Animation PKz;
  int mActionBarHeight;
  int mScreenHeight;
  int mStatusBarHeight;
  
  public b(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94952);
    this.PKx = new NotInterestMenu.b()
    {
      public final void gZu()
      {
        AppMethodBeat.i(94945);
        b.this.gZv();
        AppMethodBeat.o(94945);
      }
    };
    this.PKy = null;
    this.PKz = null;
    this.PKA = null;
    this.PKB = null;
    this.mStatusBarHeight = 0;
    this.mActionBarHeight = 0;
    this.PKC = 0;
    this.PKD = 0;
    this.PKE = 0;
    this.mScreenHeight = 0;
    this.PKF = 0;
    this.PKG = 0;
    this.PKH = false;
    this.PKI = null;
    this.PKJ = false;
    this.PKK = false;
    this.PKw = paramViewGroup;
    this.PKy = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), b.a.dropdown_down);
    this.PKy.setFillAfter(true);
    this.PKy.setDuration(100L);
    this.PKy.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94946);
        if (b.this.PKv != null) {
          b.this.PKv.setVisibility(0);
        }
        b.this.PKJ = false;
        b.this.PKH = true;
        AppMethodBeat.o(94946);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.PKJ = true;
      }
    });
    this.PKz = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), b.a.dropup_up);
    this.PKz.setFillAfter(true);
    this.PKz.setDuration(100L);
    this.PKz.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94947);
        if (b.this.PKv != null) {
          b.this.PKv.setVisibility(0);
        }
        b.this.PKJ = false;
        b.this.PKH = true;
        AppMethodBeat.o(94947);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.PKJ = true;
      }
    });
    this.PKA = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), b.a.dropdown_up);
    this.PKA.setFillAfter(true);
    this.PKA.setDuration(100L);
    this.PKA.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94949);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94948);
            b.this.gZv();
            AppMethodBeat.o(94948);
          }
        });
        b.this.PKJ = false;
        AppMethodBeat.o(94949);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.PKJ = true;
      }
    });
    this.PKB = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), b.a.dropup_down);
    this.PKB.setFillAfter(true);
    this.PKB.setDuration(100L);
    this.PKB.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94951);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94950);
            b.this.gZv();
            AppMethodBeat.o(94950);
          }
        });
        b.this.PKJ = false;
        AppMethodBeat.o(94951);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.PKJ = true;
      }
    });
    AppMethodBeat.o(94952);
  }
  
  public final void gZv()
  {
    AppMethodBeat.i(94953);
    if ((this.PKI != null) && (this.PKw != null) && (this.PKv != null))
    {
      this.PKI.removeView(this.PKv);
      this.PKw.removeView(this.PKI);
      this.PKI = null;
      this.PKv = null;
      this.PKH = false;
    }
    AppMethodBeat.o(94953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b
 * JD-Core Version:    0.7.0.1
 */