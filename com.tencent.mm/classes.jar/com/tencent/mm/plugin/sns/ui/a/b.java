package com.tencent.mm.plugin.sns.ui.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

public final class b
{
  public ValueAnimator lOL;
  private Context pla;
  public int plb;
  public int plc;
  public int pld;
  public int ple;
  public a plf;
  View view;
  
  public b(Activity paramActivity, View paramView)
  {
    this.pla = paramActivity;
    this.view = paramView;
    this.lOL = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.lOL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        b.this.view.setAlpha(1.0F - f);
        if (f != 1.0F)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)b.this.view.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(b.this.plb * f));
          paramAnonymousValueAnimator.topMargin = ((int)(b.this.plc * f));
          ViewGroup localViewGroup = (ViewGroup)b.this.view.getParent();
          paramAnonymousValueAnimator.rightMargin = ((int)(localViewGroup.getWidth() * f - b.this.pld * f - paramAnonymousValueAnimator.leftMargin));
          paramAnonymousValueAnimator.bottomMargin = ((int)(localViewGroup.getHeight() * f - b.this.ple * f - paramAnonymousValueAnimator.topMargin));
          b.this.view.setLayoutParams(paramAnonymousValueAnimator);
        }
        if (b.this.plf != null) {
          b.this.plf.aE(f);
        }
      }
    });
    this.lOL.addListener(new b.2(this));
    this.lOL.setDuration(400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b
 * JD-Core Version:    0.7.0.1
 */