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
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.ui.d.c;

public final class bx
{
  boolean AJP;
  int INC;
  private com.tencent.mm.plugin.sns.h.b KAr;
  FrameLayout KdA;
  AbsoluteLayout KdB;
  protected Animation KdC;
  protected Animation KdD;
  boolean KdE;
  c Kdz;
  Context mContext;
  
  public bx(Context paramContext, c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(99761);
    this.KdB = null;
    this.KdE = false;
    this.AJP = false;
    this.INC = -1;
    this.mContext = paramContext;
    this.Kdz = paramc;
    this.KdA = paramFrameLayout;
    this.KdC = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.KdC = AnimationUtils.loadAnimation(paramContext, i.a.dropdown_down);
    this.KdD = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.KdD = AnimationUtils.loadAnimation(paramContext, i.a.dropdown_up);
    AppMethodBeat.o(99761);
  }
  
  public final boolean fYj()
  {
    AppMethodBeat.i(99763);
    if ((this.KAr != null) && (aj.fOA().fQh())) {
      this.KAr.fQe();
    }
    if (this.KdB != null)
    {
      this.KdA.removeView(this.KdB);
      this.KdB = null;
      AppMethodBeat.o(99763);
      return true;
    }
    this.KdE = false;
    AppMethodBeat.o(99763);
    return false;
  }
  
  final void gD(final View paramView)
  {
    AppMethodBeat.i(99762);
    this.KdE = true;
    paramView.startAnimation(this.KdD);
    this.KdD.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(99760);
        if (paramView != null)
        {
          paramView.clearAnimation();
          paramView.setVisibility(8);
          bx.this.fYj();
        }
        bx.this.KdE = false;
        AppMethodBeat.o(99760);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        bx.this.KdE = true;
      }
    });
    AppMethodBeat.o(99762);
  }
  
  final class a
  {
    View GiP = null;
    
    public a(View paramView)
    {
      this.GiP = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bx
 * JD-Core Version:    0.7.0.1
 */