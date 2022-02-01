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
  int aeU;
  int lDk;
  int mScreenHeight;
  boolean wwA;
  AbsoluteLayout wwB;
  boolean wwC;
  boolean wwD;
  NotInterestMenu.c wwj;
  NotInterestMenu wwo;
  ViewGroup wwp;
  NotInterestMenu.b wwq;
  Animation wwr;
  Animation wws;
  private Animation wwt;
  private Animation wwu;
  int wwv;
  int www;
  int wwx;
  int wwy;
  int wwz;
  
  public b(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94952);
    this.wwq = new NotInterestMenu.b()
    {
      public final void drp()
      {
        AppMethodBeat.i(94945);
        b.this.drq();
        AppMethodBeat.o(94945);
      }
    };
    this.wwr = null;
    this.wws = null;
    this.wwt = null;
    this.wwu = null;
    this.lDk = 0;
    this.aeU = 0;
    this.wwv = 0;
    this.www = 0;
    this.wwx = 0;
    this.mScreenHeight = 0;
    this.wwy = 0;
    this.wwz = 0;
    this.wwA = false;
    this.wwB = null;
    this.wwC = false;
    this.wwD = false;
    this.wwp = paramViewGroup;
    this.wwr = AnimationUtils.loadAnimation(aj.getContext(), 2130772022);
    this.wwr.setFillAfter(true);
    this.wwr.setDuration(100L);
    this.wwr.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94946);
        if (b.this.wwo != null) {
          b.this.wwo.setVisibility(0);
        }
        b.this.wwC = false;
        b.this.wwA = true;
        AppMethodBeat.o(94946);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.wwC = true;
      }
    });
    this.wws = AnimationUtils.loadAnimation(aj.getContext(), 2130772025);
    this.wws.setFillAfter(true);
    this.wws.setDuration(100L);
    this.wws.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94947);
        if (b.this.wwo != null) {
          b.this.wwo.setVisibility(0);
        }
        b.this.wwC = false;
        b.this.wwA = true;
        AppMethodBeat.o(94947);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.wwC = true;
      }
    });
    this.wwt = AnimationUtils.loadAnimation(aj.getContext(), 2130772023);
    this.wwt.setFillAfter(true);
    this.wwt.setDuration(100L);
    this.wwt.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94949);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94948);
            b.this.drq();
            AppMethodBeat.o(94948);
          }
        });
        b.this.wwC = false;
        AppMethodBeat.o(94949);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.wwC = true;
      }
    });
    this.wwu = AnimationUtils.loadAnimation(aj.getContext(), 2130772024);
    this.wwu.setFillAfter(true);
    this.wwu.setDuration(100L);
    this.wwu.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94951);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94950);
            b.this.drq();
            AppMethodBeat.o(94950);
          }
        });
        b.this.wwC = false;
        AppMethodBeat.o(94951);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.wwC = true;
      }
    });
    AppMethodBeat.o(94952);
  }
  
  public final void drq()
  {
    AppMethodBeat.i(94953);
    if ((this.wwB != null) && (this.wwp != null) && (this.wwo != null))
    {
      this.wwB.removeView(this.wwo);
      this.wwp.removeView(this.wwB);
      this.wwB = null;
      this.wwo = null;
      this.wwA = false;
    }
    AppMethodBeat.o(94953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b
 * JD-Core Version:    0.7.0.1
 */