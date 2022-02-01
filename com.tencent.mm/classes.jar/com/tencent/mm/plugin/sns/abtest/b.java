package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;

public final class b
{
  int ahF;
  int mFF;
  int mScreenHeight;
  boolean yWA;
  AbsoluteLayout yWB;
  boolean yWC;
  boolean yWD;
  NotInterestMenu.c yWj;
  NotInterestMenu yWo;
  ViewGroup yWp;
  NotInterestMenu.b yWq;
  Animation yWr;
  Animation yWs;
  private Animation yWt;
  private Animation yWu;
  int yWv;
  int yWw;
  int yWx;
  int yWy;
  int yWz;
  
  public b(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94952);
    this.yWq = new NotInterestMenu.b()
    {
      public final void dRa()
      {
        AppMethodBeat.i(94945);
        b.this.dRb();
        AppMethodBeat.o(94945);
      }
    };
    this.yWr = null;
    this.yWs = null;
    this.yWt = null;
    this.yWu = null;
    this.mFF = 0;
    this.ahF = 0;
    this.yWv = 0;
    this.yWw = 0;
    this.yWx = 0;
    this.mScreenHeight = 0;
    this.yWy = 0;
    this.yWz = 0;
    this.yWA = false;
    this.yWB = null;
    this.yWC = false;
    this.yWD = false;
    this.yWp = paramViewGroup;
    this.yWr = AnimationUtils.loadAnimation(aj.getContext(), 2130772022);
    this.yWr.setFillAfter(true);
    this.yWr.setDuration(100L);
    this.yWr.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94946);
        if (b.this.yWo != null) {
          b.this.yWo.setVisibility(0);
        }
        b.this.yWC = false;
        b.this.yWA = true;
        AppMethodBeat.o(94946);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.yWC = true;
      }
    });
    this.yWs = AnimationUtils.loadAnimation(aj.getContext(), 2130772025);
    this.yWs.setFillAfter(true);
    this.yWs.setDuration(100L);
    this.yWs.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94947);
        if (b.this.yWo != null) {
          b.this.yWo.setVisibility(0);
        }
        b.this.yWC = false;
        b.this.yWA = true;
        AppMethodBeat.o(94947);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.yWC = true;
      }
    });
    this.yWt = AnimationUtils.loadAnimation(aj.getContext(), 2130772023);
    this.yWt.setFillAfter(true);
    this.yWt.setDuration(100L);
    this.yWt.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94949);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94948);
            b.this.dRb();
            AppMethodBeat.o(94948);
          }
        });
        b.this.yWC = false;
        AppMethodBeat.o(94949);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.yWC = true;
      }
    });
    this.yWu = AnimationUtils.loadAnimation(aj.getContext(), 2130772024);
    this.yWu.setFillAfter(true);
    this.yWu.setDuration(100L);
    this.yWu.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94951);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94950);
            b.this.dRb();
            AppMethodBeat.o(94950);
          }
        });
        b.this.yWC = false;
        AppMethodBeat.o(94951);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.yWC = true;
      }
    });
    AppMethodBeat.o(94952);
  }
  
  public final void dRb()
  {
    AppMethodBeat.i(94953);
    if ((this.yWB != null) && (this.yWp != null) && (this.yWo != null))
    {
      this.yWB.removeView(this.yWo);
      this.yWp.removeView(this.yWB);
      this.yWB = null;
      this.yWo = null;
      this.yWA = false;
    }
    AppMethodBeat.o(94953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b
 * JD-Core Version:    0.7.0.1
 */