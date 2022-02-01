package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;

public final class b
{
  int afO;
  int mScreenHeight;
  int mfe;
  NotInterestMenu xHE;
  ViewGroup xHF;
  NotInterestMenu.b xHG;
  Animation xHH;
  Animation xHI;
  private Animation xHJ;
  private Animation xHK;
  int xHL;
  int xHM;
  int xHN;
  int xHO;
  int xHP;
  boolean xHQ;
  AbsoluteLayout xHR;
  boolean xHS;
  boolean xHT;
  NotInterestMenu.c xHz;
  
  public b(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94952);
    this.xHG = new NotInterestMenu.b()
    {
      public final void dFy()
      {
        AppMethodBeat.i(94945);
        b.this.dFz();
        AppMethodBeat.o(94945);
      }
    };
    this.xHH = null;
    this.xHI = null;
    this.xHJ = null;
    this.xHK = null;
    this.mfe = 0;
    this.afO = 0;
    this.xHL = 0;
    this.xHM = 0;
    this.xHN = 0;
    this.mScreenHeight = 0;
    this.xHO = 0;
    this.xHP = 0;
    this.xHQ = false;
    this.xHR = null;
    this.xHS = false;
    this.xHT = false;
    this.xHF = paramViewGroup;
    this.xHH = AnimationUtils.loadAnimation(ai.getContext(), 2130772022);
    this.xHH.setFillAfter(true);
    this.xHH.setDuration(100L);
    this.xHH.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94946);
        if (b.this.xHE != null) {
          b.this.xHE.setVisibility(0);
        }
        b.this.xHS = false;
        b.this.xHQ = true;
        AppMethodBeat.o(94946);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.xHS = true;
      }
    });
    this.xHI = AnimationUtils.loadAnimation(ai.getContext(), 2130772025);
    this.xHI.setFillAfter(true);
    this.xHI.setDuration(100L);
    this.xHI.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94947);
        if (b.this.xHE != null) {
          b.this.xHE.setVisibility(0);
        }
        b.this.xHS = false;
        b.this.xHQ = true;
        AppMethodBeat.o(94947);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.xHS = true;
      }
    });
    this.xHJ = AnimationUtils.loadAnimation(ai.getContext(), 2130772023);
    this.xHJ.setFillAfter(true);
    this.xHJ.setDuration(100L);
    this.xHJ.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94949);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94948);
            b.this.dFz();
            AppMethodBeat.o(94948);
          }
        });
        b.this.xHS = false;
        AppMethodBeat.o(94949);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.xHS = true;
      }
    });
    this.xHK = AnimationUtils.loadAnimation(ai.getContext(), 2130772024);
    this.xHK.setFillAfter(true);
    this.xHK.setDuration(100L);
    this.xHK.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94951);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94950);
            b.this.dFz();
            AppMethodBeat.o(94950);
          }
        });
        b.this.xHS = false;
        AppMethodBeat.o(94951);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.xHS = true;
      }
    });
    AppMethodBeat.o(94952);
  }
  
  public final void dFz()
  {
    AppMethodBeat.i(94953);
    if ((this.xHR != null) && (this.xHF != null) && (this.xHE != null))
    {
      this.xHR.removeView(this.xHE);
      this.xHF.removeView(this.xHR);
      this.xHR = null;
      this.xHE = null;
      this.xHQ = false;
    }
    AppMethodBeat.o(94953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b
 * JD-Core Version:    0.7.0.1
 */