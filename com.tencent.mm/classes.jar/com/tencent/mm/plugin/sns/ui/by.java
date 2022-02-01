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
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.ui.listener.c;

public final class by
{
  boolean Flq;
  c QBf;
  FrameLayout QBg;
  AbsoluteLayout QBh;
  protected Animation QBi;
  protected Animation QBj;
  boolean QBk;
  private com.tencent.mm.plugin.sns.i.b QZY;
  Context mContext;
  int vpn;
  
  public by(Context paramContext, c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(99761);
    this.QBh = null;
    this.QBk = false;
    this.Flq = false;
    this.vpn = -1;
    this.mContext = paramContext;
    this.QBf = paramc;
    this.QBg = paramFrameLayout;
    this.QBi = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.QBi = AnimationUtils.loadAnimation(paramContext, b.a.dropdown_down);
    this.QBj = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.QBj = AnimationUtils.loadAnimation(paramContext, b.a.dropdown_up);
    AppMethodBeat.o(99761);
  }
  
  public final boolean hqH()
  {
    AppMethodBeat.i(99763);
    if ((this.QZY != null) && (al.hgt().hie())) {
      this.QZY.hib();
    }
    if (this.QBh != null)
    {
      this.QBg.removeView(this.QBh);
      this.QBh = null;
      AppMethodBeat.o(99763);
      return true;
    }
    this.QBk = false;
    AppMethodBeat.o(99763);
    return false;
  }
  
  final void jH(final View paramView)
  {
    AppMethodBeat.i(99762);
    this.QBk = true;
    paramView.startAnimation(this.QBj);
    this.QBj.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(99760);
        if (paramView != null)
        {
          paramView.clearAnimation();
          paramView.setVisibility(8);
          by.this.hqH();
        }
        by.this.QBk = false;
        AppMethodBeat.o(99760);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        by.this.QBk = true;
      }
    });
    AppMethodBeat.o(99762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.by
 * JD-Core Version:    0.7.0.1
 */