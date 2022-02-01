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
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.ui.d.c;

public final class br
{
  private com.tencent.mm.plugin.sns.h.b AeL;
  Context mContext;
  boolean ncj;
  c zGs;
  FrameLayout zGt;
  AbsoluteLayout zGu;
  protected Animation zGv;
  protected Animation zGw;
  boolean zGx;
  int zpn;
  
  public br(Context paramContext, c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(99761);
    this.zGu = null;
    this.zGx = false;
    this.ncj = false;
    this.zpn = -1;
    this.mContext = paramContext;
    this.zGs = paramc;
    this.zGt = paramFrameLayout;
    this.zGv = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.zGv = AnimationUtils.loadAnimation(paramContext, 2130772022);
    this.zGw = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.zGw = AnimationUtils.loadAnimation(paramContext, 2130772023);
    AppMethodBeat.o(99761);
  }
  
  public final boolean ehy()
  {
    AppMethodBeat.i(99763);
    if ((this.AeL != null) && (ah.dXw().dZa())) {
      this.AeL.dYX();
    }
    if (this.zGu != null)
    {
      this.zGt.removeView(this.zGu);
      this.zGu = null;
      AppMethodBeat.o(99763);
      return true;
    }
    this.zGx = false;
    AppMethodBeat.o(99763);
    return false;
  }
  
  final void fh(final View paramView)
  {
    AppMethodBeat.i(99762);
    this.zGx = true;
    paramView.startAnimation(this.zGw);
    this.zGw.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(99760);
        if (paramView != null)
        {
          paramView.clearAnimation();
          paramView.setVisibility(8);
          br.this.ehy();
        }
        br.this.zGx = false;
        AppMethodBeat.o(99760);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        br.this.zGx = true;
      }
    });
    AppMethodBeat.o(99762);
  }
  
  final class a
  {
    View zom = null;
    
    public a(View paramView)
    {
      this.zom = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.br
 * JD-Core Version:    0.7.0.1
 */