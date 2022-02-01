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
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;

public final class bo
{
  boolean lUw;
  Context mContext;
  AbsoluteLayout wMA;
  protected Animation wMB;
  protected Animation wMC;
  boolean wMD;
  com.tencent.mm.plugin.sns.ui.d.b wMy;
  FrameLayout wMz;
  int wxW;
  private com.tencent.mm.plugin.sns.i.b xjA;
  
  public bo(Context paramContext, com.tencent.mm.plugin.sns.ui.d.b paramb, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(99761);
    this.wMA = null;
    this.wMD = false;
    this.lUw = false;
    this.wxW = -1;
    this.mContext = paramContext;
    this.wMy = paramb;
    this.wMz = paramFrameLayout;
    this.wMB = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.wMB = AnimationUtils.loadAnimation(paramContext, 2130772022);
    this.wMC = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.wMC = AnimationUtils.loadAnimation(paramContext, 2130772023);
    AppMethodBeat.o(99761);
  }
  
  public final boolean dDa()
  {
    AppMethodBeat.i(99763);
    if ((this.xjA != null) && (af.dtm().duM())) {
      this.xjA.duJ();
    }
    if (this.wMA != null)
    {
      this.wMz.removeView(this.wMA);
      this.wMA = null;
      AppMethodBeat.o(99763);
      return true;
    }
    this.wMD = false;
    AppMethodBeat.o(99763);
    return false;
  }
  
  final void eG(final View paramView)
  {
    AppMethodBeat.i(99762);
    this.wMD = true;
    paramView.startAnimation(this.wMC);
    this.wMC.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(99760);
        if (paramView != null)
        {
          paramView.clearAnimation();
          paramView.setVisibility(8);
          bo.this.dDa();
        }
        bo.this.wMD = false;
        AppMethodBeat.o(99760);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        bo.this.wMD = true;
      }
    });
    AppMethodBeat.o(99762);
  }
  
  final class a
  {
    View wwV = null;
    
    public a(View paramView)
    {
      this.wwV = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bo
 * JD-Core Version:    0.7.0.1
 */