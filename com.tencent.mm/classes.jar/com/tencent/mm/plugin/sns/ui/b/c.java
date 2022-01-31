package com.tencent.mm.plugin.sns.ui.b;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public ValueAnimator omf;
  private Context seL;
  public int seM;
  public int seN;
  public int seO;
  public int seP;
  public a seQ;
  View view;
  
  public c(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(40009);
    this.seL = paramActivity;
    this.view = paramView;
    this.omf = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.omf.addUpdateListener(new c.1(this));
    this.omf.addListener(new c.2(this));
    this.omf.setDuration(400L);
    AppMethodBeat.o(40009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.c
 * JD-Core Version:    0.7.0.1
 */