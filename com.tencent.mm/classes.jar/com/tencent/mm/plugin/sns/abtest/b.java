package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  int Xc = 0;
  int heA = 0;
  int mScreenHeight = 0;
  NotInterestMenu.c ojA;
  NotInterestMenu ojF;
  ViewGroup ojG;
  NotInterestMenu.b ojH = new b.1(this);
  Animation ojI = null;
  Animation ojJ = null;
  private Animation ojK = null;
  private Animation ojL = null;
  int ojM = 0;
  int ojN = 0;
  int ojO = 0;
  int ojP = 0;
  int ojQ = 0;
  boolean ojR = false;
  AbsoluteLayout ojS = null;
  boolean ojT = false;
  boolean ojU = false;
  
  public b(ViewGroup paramViewGroup)
  {
    this.ojG = paramViewGroup;
    this.ojI = AnimationUtils.loadAnimation(ae.getContext(), i.a.dropdown_down);
    this.ojI.setFillAfter(true);
    this.ojI.setDuration(100L);
    this.ojI.setAnimationListener(new b.2(this));
    this.ojJ = AnimationUtils.loadAnimation(ae.getContext(), i.a.dropup_up);
    this.ojJ.setFillAfter(true);
    this.ojJ.setDuration(100L);
    this.ojJ.setAnimationListener(new b.3(this));
    this.ojK = AnimationUtils.loadAnimation(ae.getContext(), i.a.dropdown_up);
    this.ojK.setFillAfter(true);
    this.ojK.setDuration(100L);
    this.ojK.setAnimationListener(new b.4(this));
    this.ojL = AnimationUtils.loadAnimation(ae.getContext(), i.a.dropup_down);
    this.ojL.setFillAfter(true);
    this.ojL.setDuration(100L);
    this.ojL.setAnimationListener(new b.5(this));
  }
  
  public final void bBZ()
  {
    if ((this.ojS != null) && (this.ojG != null) && (this.ojF != null))
    {
      this.ojS.removeView(this.ojF);
      this.ojG.removeView(this.ojS);
      this.ojS = null;
      this.ojF = null;
      this.ojR = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b
 * JD-Core Version:    0.7.0.1
 */