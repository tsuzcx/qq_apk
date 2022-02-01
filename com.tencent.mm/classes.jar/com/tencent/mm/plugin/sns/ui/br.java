package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.h.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.ui.d.c;

public final class br
{
  Context mContext;
  boolean mXd;
  int yYM;
  private b zNE;
  c zpd;
  FrameLayout zpe;
  AbsoluteLayout zpf;
  protected Animation zpg;
  protected Animation zph;
  boolean zpi;
  
  public br(Context paramContext, c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(99761);
    this.zpf = null;
    this.zpi = false;
    this.mXd = false;
    this.yYM = -1;
    this.mContext = paramContext;
    this.zpd = paramc;
    this.zpe = paramFrameLayout;
    this.zpg = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.zpg = AnimationUtils.loadAnimation(paramContext, 2130772022);
    this.zph = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.zph = AnimationUtils.loadAnimation(paramContext, 2130772023);
    AppMethodBeat.o(99761);
  }
  
  public final boolean edR()
  {
    AppMethodBeat.i(99763);
    if ((this.zNE != null) && (ag.dTW().dVz())) {
      this.zNE.dVw();
    }
    if (this.zpf != null)
    {
      this.zpe.removeView(this.zpf);
      this.zpf = null;
      AppMethodBeat.o(99763);
      return true;
    }
    this.zpi = false;
    AppMethodBeat.o(99763);
    return false;
  }
  
  final void fi(View paramView)
  {
    AppMethodBeat.i(99762);
    this.zpi = true;
    paramView.startAnimation(this.zph);
    this.zph.setAnimationListener(new br.4(this, paramView));
    AppMethodBeat.o(99762);
  }
  
  final class a
  {
    View yXL = null;
    
    public a(View paramView)
    {
      this.yXL = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.br
 * JD-Core Version:    0.7.0.1
 */