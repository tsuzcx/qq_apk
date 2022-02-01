package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
{
  NotInterestMenu.c JwQ;
  NotInterestMenu JwV;
  ViewGroup JwW;
  NotInterestMenu.b JwX;
  Animation JwY;
  Animation JwZ;
  private Animation Jxa;
  private Animation Jxb;
  int Jxc;
  int Jxd;
  int Jxe;
  int Jxf;
  int Jxg;
  boolean Jxh;
  AbsoluteLayout Jxi;
  boolean Jxj;
  boolean Jxk;
  int mActionBarHeight;
  int mScreenHeight;
  int mStatusBarHeight;
  
  public b(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(94952);
    this.JwX = new NotInterestMenu.b()
    {
      public final void fJA()
      {
        AppMethodBeat.i(94945);
        b.this.fJB();
        AppMethodBeat.o(94945);
      }
    };
    this.JwY = null;
    this.JwZ = null;
    this.Jxa = null;
    this.Jxb = null;
    this.mStatusBarHeight = 0;
    this.mActionBarHeight = 0;
    this.Jxc = 0;
    this.Jxd = 0;
    this.Jxe = 0;
    this.mScreenHeight = 0;
    this.Jxf = 0;
    this.Jxg = 0;
    this.Jxh = false;
    this.Jxi = null;
    this.Jxj = false;
    this.Jxk = false;
    this.JwW = paramViewGroup;
    this.JwY = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), i.a.dropdown_down);
    this.JwY.setFillAfter(true);
    this.JwY.setDuration(100L);
    this.JwY.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94946);
        if (b.this.JwV != null) {
          b.this.JwV.setVisibility(0);
        }
        b.this.Jxj = false;
        b.this.Jxh = true;
        AppMethodBeat.o(94946);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.Jxj = true;
      }
    });
    this.JwZ = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), i.a.dropup_up);
    this.JwZ.setFillAfter(true);
    this.JwZ.setDuration(100L);
    this.JwZ.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94947);
        if (b.this.JwV != null) {
          b.this.JwV.setVisibility(0);
        }
        b.this.Jxj = false;
        b.this.Jxh = true;
        AppMethodBeat.o(94947);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.Jxj = true;
      }
    });
    this.Jxa = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), i.a.dropdown_up);
    this.Jxa.setFillAfter(true);
    this.Jxa.setDuration(100L);
    this.Jxa.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94949);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94948);
            b.this.fJB();
            AppMethodBeat.o(94948);
          }
        });
        b.this.Jxj = false;
        AppMethodBeat.o(94949);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.Jxj = true;
      }
    });
    this.Jxb = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), i.a.dropup_down);
    this.Jxb.setFillAfter(true);
    this.Jxb.setDuration(100L);
    this.Jxb.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(94951);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94950);
            b.this.fJB();
            AppMethodBeat.o(94950);
          }
        });
        b.this.Jxj = false;
        AppMethodBeat.o(94951);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        b.this.Jxj = true;
      }
    });
    AppMethodBeat.o(94952);
  }
  
  public final void fJB()
  {
    AppMethodBeat.i(94953);
    if ((this.Jxi != null) && (this.JwW != null) && (this.JwV != null))
    {
      this.Jxi.removeView(this.JwV);
      this.JwW.removeView(this.Jxi);
      this.Jxi = null;
      this.JwV = null;
      this.Jxh = false;
    }
    AppMethodBeat.o(94953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b
 * JD-Core Version:    0.7.0.1
 */