package com.tencent.mm.plugin.sns.ad.f.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends View
{
  protected int Hx;
  protected AnimatorSet wV;
  protected Paint zbK;
  protected RectF zbL;
  protected ValueAnimator.AnimatorUpdateListener zbM;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(197720);
    this.zbM = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(197719);
        try
        {
          b.this.Hx = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          b.this.invalidate();
          AppMethodBeat.o(197719);
          return;
        }
        catch (Exception paramAnonymousValueAnimator)
        {
          AppMethodBeat.o(197719);
        }
      }
    };
    this.zbK = new Paint();
    this.zbK.setColor(Color.parseColor("#FFEDEDED"));
    this.zbK.setAntiAlias(true);
    this.zbK.setDither(true);
    this.zbK.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(197720);
  }
  
  public final void ar(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(197721);
    clear();
    int i = paramInt3 / 2;
    this.zbL = new RectF(i, i, paramInt2 * 2 - i, paramInt2 * 2 - i);
    this.zbK.setStrokeWidth(paramInt3);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 362 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(this.zbM);
    this.wV = new AnimatorSet();
    this.wV.playSequentially(new Animator[] { localValueAnimator });
    this.wV.start();
    AppMethodBeat.o(197721);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(197722);
    if (this.wV != null) {
      this.wV.cancel();
    }
    this.Hx = 0;
    invalidate();
    AppMethodBeat.o(197722);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(197723);
    if (this.zbL != null) {
      paramCanvas.drawArc(this.zbL, -90.0F, this.Hx, false, this.zbK);
    }
    AppMethodBeat.o(197723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.a.b
 * JD-Core Version:    0.7.0.1
 */