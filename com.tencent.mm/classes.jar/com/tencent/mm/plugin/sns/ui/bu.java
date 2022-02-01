package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.sns.h.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.ui.d.c;

public final class bu
{
  int CHZ;
  c DQs;
  FrameLayout DQt;
  AbsoluteLayout DQu;
  protected Animation DQv;
  protected Animation DQw;
  boolean DQx;
  private com.tencent.mm.plugin.sns.h.b Eni;
  Context mContext;
  boolean onr;
  
  public bu(Context paramContext, c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(99761);
    this.DQu = null;
    this.DQx = false;
    this.onr = false;
    this.CHZ = -1;
    this.mContext = paramContext;
    this.DQs = paramc;
    this.DQt = paramFrameLayout;
    this.DQv = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.DQv = AnimationUtils.loadAnimation(paramContext, 2130772028);
    this.DQw = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.DQw = AnimationUtils.loadAnimation(paramContext, 2130772029);
    AppMethodBeat.o(99761);
  }
  
  public final boolean fka()
  {
    AppMethodBeat.i(99763);
    if ((this.Eni != null) && (aj.faG().fco())) {
      this.Eni.fcl();
    }
    if (this.DQu != null)
    {
      this.DQt.removeView(this.DQu);
      this.DQu = null;
      AppMethodBeat.o(99763);
      return true;
    }
    this.DQx = false;
    AppMethodBeat.o(99763);
    return false;
  }
  
  final void fw(final View paramView)
  {
    AppMethodBeat.i(99762);
    this.DQx = true;
    paramView.startAnimation(this.DQw);
    this.DQw.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(99760);
        if (paramView != null)
        {
          paramView.clearAnimation();
          paramView.setVisibility(8);
          bu.this.fka();
        }
        bu.this.DQx = false;
        AppMethodBeat.o(99760);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        bu.this.DQx = true;
      }
    });
    AppMethodBeat.o(99762);
  }
  
  final class a
  {
    View Atk = null;
    
    public a(View paramView)
    {
      this.Atk = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bu
 * JD-Core Version:    0.7.0.1
 */