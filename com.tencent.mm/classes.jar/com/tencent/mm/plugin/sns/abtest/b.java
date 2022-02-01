package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
{
  int DrA;
  int DrB;
  boolean DrC;
  AbsoluteLayout DrD;
  boolean DrE;
  boolean DrF;
  NotInterestMenu.c Drl;
  NotInterestMenu Drq;
  ViewGroup Drr;
  NotInterestMenu.b Drs;
  Animation Drt;
  Animation Dru;
  private Animation Drv;
  private Animation Drw;
  int Drx;
  int Dry;
  int Drz;
  int mActionBarHeight;
  int mScreenHeight;
  int mStatusBarHeight;
  
  public b(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94952);
    this.Drs = new NotInterestMenu.b()
    {
      public final void eWx()
      {
        AppMethodBeat.i(94945);
        b.this.eWy();
        AppMethodBeat.o(94945);
      }
    };
    this.Drt = null;
    this.Dru = null;
    this.Drv = null;
    this.Drw = null;
    this.mStatusBarHeight = 0;
    this.mActionBarHeight = 0;
    this.Drx = 0;
    this.Dry = 0;
    this.Drz = 0;
    this.mScreenHeight = 0;
    this.DrA = 0;
    this.DrB = 0;
    this.DrC = false;
    this.DrD = null;
    this.DrE = false;
    this.DrF = false;
    this.Drr = paramViewGroup;
    this.Drt = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130772028);
    this.Drt.setFillAfter(true);
    this.Drt.setDuration(100L);
    this.Drt.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94946);
        if (b.this.Drq != null) {
          b.this.Drq.setVisibility(0);
        }
        b.this.DrE = false;
        b.this.DrC = true;
        AppMethodBeat.o(94946);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.DrE = true;
      }
    });
    this.Dru = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130772031);
    this.Dru.setFillAfter(true);
    this.Dru.setDuration(100L);
    this.Dru.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94947);
        if (b.this.Drq != null) {
          b.this.Drq.setVisibility(0);
        }
        b.this.DrE = false;
        b.this.DrC = true;
        AppMethodBeat.o(94947);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.DrE = true;
      }
    });
    this.Drv = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130772029);
    this.Drv.setFillAfter(true);
    this.Drv.setDuration(100L);
    this.Drv.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94949);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94948);
            b.this.eWy();
            AppMethodBeat.o(94948);
          }
        });
        b.this.DrE = false;
        AppMethodBeat.o(94949);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.DrE = true;
      }
    });
    this.Drw = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130772030);
    this.Drw.setFillAfter(true);
    this.Drw.setDuration(100L);
    this.Drw.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94951);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94950);
            b.this.eWy();
            AppMethodBeat.o(94950);
          }
        });
        b.this.DrE = false;
        AppMethodBeat.o(94951);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.DrE = true;
      }
    });
    AppMethodBeat.o(94952);
  }
  
  public final void eWy()
  {
    AppMethodBeat.i(94953);
    if ((this.DrD != null) && (this.Drr != null) && (this.Drq != null))
    {
      this.DrD.removeView(this.Drq);
      this.Drr.removeView(this.DrD);
      this.DrD = null;
      this.Drq = null;
      this.DrC = false;
    }
    AppMethodBeat.o(94953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b
 * JD-Core Version:    0.7.0.1
 */