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
import com.tencent.mm.plugin.sns.h.g;
import com.tencent.mm.plugin.sns.model.af;

public final class bo
{
  Context mContext;
  boolean mwy;
  int xJx;
  com.tencent.mm.plugin.sns.ui.d.b xZe;
  FrameLayout xZf;
  AbsoluteLayout xZg;
  protected Animation xZh;
  protected Animation xZi;
  boolean xZj;
  private com.tencent.mm.plugin.sns.h.b yws;
  
  public bo(Context paramContext, com.tencent.mm.plugin.sns.ui.d.b paramb, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(99761);
    this.xZg = null;
    this.xZj = false;
    this.mwy = false;
    this.xJx = -1;
    this.mContext = paramContext;
    this.xZe = paramb;
    this.xZf = paramFrameLayout;
    this.xZh = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.xZh = AnimationUtils.loadAnimation(paramContext, 2130772022);
    this.xZi = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.xZi = AnimationUtils.loadAnimation(paramContext, 2130772023);
    AppMethodBeat.o(99761);
  }
  
  public final boolean dRx()
  {
    AppMethodBeat.i(99763);
    if ((this.yws != null) && (af.dHJ().dJm())) {
      this.yws.dJj();
    }
    if (this.xZg != null)
    {
      this.xZf.removeView(this.xZg);
      this.xZg = null;
      AppMethodBeat.o(99763);
      return true;
    }
    this.xZj = false;
    AppMethodBeat.o(99763);
    return false;
  }
  
  final void eT(final View paramView)
  {
    AppMethodBeat.i(99762);
    this.xZj = true;
    paramView.startAnimation(this.xZi);
    this.xZi.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(99760);
        if (paramView != null)
        {
          paramView.clearAnimation();
          paramView.setVisibility(8);
          bo.this.dRx();
        }
        bo.this.xZj = false;
        AppMethodBeat.o(99760);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        bo.this.xZj = true;
      }
    });
    AppMethodBeat.o(99762);
  }
  
  final class a
  {
    View xIw = null;
    
    public a(View paramView)
    {
      this.xIw = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bo
 * JD-Core Version:    0.7.0.1
 */