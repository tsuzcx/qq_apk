package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;

public final class b
{
  int ahF;
  int mKJ;
  int mScreenHeight;
  NotInterestMenu.b zmA;
  Animation zmB;
  Animation zmC;
  private Animation zmD;
  private Animation zmE;
  int zmF;
  int zmG;
  int zmH;
  int zmI;
  int zmJ;
  boolean zmK;
  AbsoluteLayout zmL;
  boolean zmM;
  boolean zmN;
  NotInterestMenu.c zmt;
  NotInterestMenu zmy;
  ViewGroup zmz;
  
  public b(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94952);
    this.zmA = new NotInterestMenu.b()
    {
      public final void dUx()
      {
        AppMethodBeat.i(94945);
        b.this.dUy();
        AppMethodBeat.o(94945);
      }
    };
    this.zmB = null;
    this.zmC = null;
    this.zmD = null;
    this.zmE = null;
    this.mKJ = 0;
    this.ahF = 0;
    this.zmF = 0;
    this.zmG = 0;
    this.zmH = 0;
    this.mScreenHeight = 0;
    this.zmI = 0;
    this.zmJ = 0;
    this.zmK = false;
    this.zmL = null;
    this.zmM = false;
    this.zmN = false;
    this.zmz = paramViewGroup;
    this.zmB = AnimationUtils.loadAnimation(ak.getContext(), 2130772022);
    this.zmB.setFillAfter(true);
    this.zmB.setDuration(100L);
    this.zmB.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94946);
        if (b.this.zmy != null) {
          b.this.zmy.setVisibility(0);
        }
        b.this.zmM = false;
        b.this.zmK = true;
        AppMethodBeat.o(94946);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.zmM = true;
      }
    });
    this.zmC = AnimationUtils.loadAnimation(ak.getContext(), 2130772025);
    this.zmC.setFillAfter(true);
    this.zmC.setDuration(100L);
    this.zmC.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94947);
        if (b.this.zmy != null) {
          b.this.zmy.setVisibility(0);
        }
        b.this.zmM = false;
        b.this.zmK = true;
        AppMethodBeat.o(94947);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.zmM = true;
      }
    });
    this.zmD = AnimationUtils.loadAnimation(ak.getContext(), 2130772023);
    this.zmD.setFillAfter(true);
    this.zmD.setDuration(100L);
    this.zmD.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94949);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94948);
            b.this.dUy();
            AppMethodBeat.o(94948);
          }
        });
        b.this.zmM = false;
        AppMethodBeat.o(94949);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.zmM = true;
      }
    });
    this.zmE = AnimationUtils.loadAnimation(ak.getContext(), 2130772024);
    this.zmE.setFillAfter(true);
    this.zmE.setDuration(100L);
    this.zmE.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94951);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94950);
            b.this.dUy();
            AppMethodBeat.o(94950);
          }
        });
        b.this.zmM = false;
        AppMethodBeat.o(94951);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.zmM = true;
      }
    });
    AppMethodBeat.o(94952);
  }
  
  public final void dUy()
  {
    AppMethodBeat.i(94953);
    if ((this.zmL != null) && (this.zmz != null) && (this.zmy != null))
    {
      this.zmL.removeView(this.zmy);
      this.zmz.removeView(this.zmL);
      this.zmL = null;
      this.zmy = null;
      this.zmK = false;
    }
    AppMethodBeat.o(94953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b
 * JD-Core Version:    0.7.0.1
 */