package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.i.b;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.ui.listener.c;

public final class as
{
  boolean Flq;
  c QBf;
  FrameLayout QBg;
  AbsoluteLayout QBh;
  protected Animation QBi;
  protected Animation QBj;
  boolean QBk;
  private b QZY;
  Context mContext;
  int vpn;
  
  public as(Context paramContext, c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(98144);
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
    AppMethodBeat.o(98144);
  }
  
  public final boolean hib()
  {
    AppMethodBeat.i(98147);
    if ((this.QZY != null) && (al.hgt().hie())) {
      this.QZY.hib();
    }
    if (this.QBh != null)
    {
      this.QBg.removeView(this.QBh);
      this.QBh = null;
      AppMethodBeat.o(98147);
      return true;
    }
    this.QBk = false;
    AppMethodBeat.o(98147);
    return false;
  }
  
  final void jH(final View paramView)
  {
    AppMethodBeat.i(98146);
    this.QBk = true;
    paramView.startAnimation(this.QBj);
    this.QBj.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(98143);
        if (paramView != null)
        {
          paramView.clearAnimation();
          paramView.setVisibility(8);
          as.this.hib();
        }
        as.this.QBk = false;
        AppMethodBeat.o(98143);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        as.this.QBk = true;
      }
    });
    AppMethodBeat.o(98146);
  }
  
  final class a
  {
    View MdP = null;
    String QBA;
    
    public a(String paramString, View paramView)
    {
      this.QBA = paramString;
      this.MdP = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as
 * JD-Core Version:    0.7.0.1
 */