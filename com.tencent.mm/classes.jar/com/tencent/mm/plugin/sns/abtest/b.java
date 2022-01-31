package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
{
  int XO;
  int iPy;
  int mScreenHeight;
  NotInterestMenu.c qXL;
  NotInterestMenu qXQ;
  ViewGroup qXR;
  NotInterestMenu.b qXS;
  Animation qXT;
  Animation qXU;
  private Animation qXV;
  private Animation qXW;
  int qXX;
  int qXY;
  int qXZ;
  int qYa;
  int qYb;
  boolean qYc;
  AbsoluteLayout qYd;
  boolean qYe;
  boolean qYf;
  
  public b(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(35677);
    this.qXS = new b.1(this);
    this.qXT = null;
    this.qXU = null;
    this.qXV = null;
    this.qXW = null;
    this.iPy = 0;
    this.XO = 0;
    this.qXX = 0;
    this.qXY = 0;
    this.qXZ = 0;
    this.mScreenHeight = 0;
    this.qYa = 0;
    this.qYb = 0;
    this.qYc = false;
    this.qYd = null;
    this.qYe = false;
    this.qYf = false;
    this.qXR = paramViewGroup;
    this.qXT = AnimationUtils.loadAnimation(ah.getContext(), 2131034161);
    this.qXT.setFillAfter(true);
    this.qXT.setDuration(100L);
    this.qXT.setAnimationListener(new b.2(this));
    this.qXU = AnimationUtils.loadAnimation(ah.getContext(), 2131034164);
    this.qXU.setFillAfter(true);
    this.qXU.setDuration(100L);
    this.qXU.setAnimationListener(new b.3(this));
    this.qXV = AnimationUtils.loadAnimation(ah.getContext(), 2131034162);
    this.qXV.setFillAfter(true);
    this.qXV.setDuration(100L);
    this.qXV.setAnimationListener(new b.4(this));
    this.qXW = AnimationUtils.loadAnimation(ah.getContext(), 2131034163);
    this.qXW.setFillAfter(true);
    this.qXW.setDuration(100L);
    this.qXW.setAnimationListener(new b.5(this));
    AppMethodBeat.o(35677);
  }
  
  public final void cnA()
  {
    AppMethodBeat.i(35678);
    if ((this.qYd != null) && (this.qXR != null) && (this.qXQ != null))
    {
      this.qYd.removeView(this.qXQ);
      this.qXR.removeView(this.qYd);
      this.qYd = null;
      this.qXQ = null;
      this.qYc = false;
    }
    AppMethodBeat.o(35678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b
 * JD-Core Version:    0.7.0.1
 */