package com.tencent.mm.plugin.sns.ui.a;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;

public final class c
{
  public ValueAnimator lOL;
  private Context pla;
  public int plb;
  public int plc;
  public int pld;
  public int ple;
  public a plf;
  View view;
  
  public c(Activity paramActivity, View paramView)
  {
    this.pla = paramActivity;
    this.view = paramView;
    this.lOL = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.lOL.addUpdateListener(new c.1(this));
    this.lOL.addListener(new c.2(this));
    this.lOL.setDuration(400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.c
 * JD-Core Version:    0.7.0.1
 */