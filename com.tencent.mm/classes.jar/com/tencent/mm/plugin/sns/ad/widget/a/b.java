package com.tencent.mm.plugin.sns.ad.widget.a;

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
  protected int IB;
  protected Paint JMJ;
  protected RectF JMK;
  protected ValueAnimator.AnimatorUpdateListener JML;
  protected AnimatorSet atV;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(218788);
    this.JML = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(224182);
        try
        {
          b.this.IB = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          b.this.invalidate();
          AppMethodBeat.o(224182);
          return;
        }
        catch (Exception paramAnonymousValueAnimator)
        {
          AppMethodBeat.o(224182);
        }
      }
    };
    this.JMJ = new Paint();
    this.JMJ.setColor(Color.parseColor("#FFEDEDED"));
    this.JMJ.setAntiAlias(true);
    this.JMJ.setDither(true);
    this.JMJ.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(218788);
  }
  
  public final void aB(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(218790);
    clear();
    int i = paramInt3 / 2;
    this.JMK = new RectF(i, i, paramInt2 * 2 - i, paramInt2 * 2 - i);
    this.JMJ.setStrokeWidth(paramInt3);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 362 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(this.JML);
    this.atV = new AnimatorSet();
    this.atV.playSequentially(new Animator[] { localValueAnimator });
    this.atV.start();
    AppMethodBeat.o(218790);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(218791);
    if (this.atV != null) {
      this.atV.cancel();
    }
    this.IB = 0;
    invalidate();
    AppMethodBeat.o(218791);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(218792);
    if (this.JMK != null) {
      paramCanvas.drawArc(this.JMK, -90.0F, this.IB, false, this.JMJ);
    }
    AppMethodBeat.o(218792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.b
 * JD-Core Version:    0.7.0.1
 */