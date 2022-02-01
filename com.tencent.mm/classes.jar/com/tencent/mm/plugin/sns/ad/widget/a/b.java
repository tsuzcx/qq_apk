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
  protected Paint DAX;
  protected RectF DAZ;
  protected ValueAnimator.AnimatorUpdateListener DBa;
  protected int HH;
  protected AnimatorSet xc;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(202446);
    this.DBa = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(202445);
        try
        {
          b.this.HH = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          b.this.invalidate();
          AppMethodBeat.o(202445);
          return;
        }
        catch (Exception paramAnonymousValueAnimator)
        {
          AppMethodBeat.o(202445);
        }
      }
    };
    this.DAX = new Paint();
    this.DAX.setColor(Color.parseColor("#FFEDEDED"));
    this.DAX.setAntiAlias(true);
    this.DAX.setDither(true);
    this.DAX.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(202446);
  }
  
  public final void ax(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202447);
    clear();
    int i = paramInt3 / 2;
    this.DAZ = new RectF(i, i, paramInt2 * 2 - i, paramInt2 * 2 - i);
    this.DAX.setStrokeWidth(paramInt3);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 362 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(this.DBa);
    this.xc = new AnimatorSet();
    this.xc.playSequentially(new Animator[] { localValueAnimator });
    this.xc.start();
    AppMethodBeat.o(202447);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(202448);
    if (this.xc != null) {
      this.xc.cancel();
    }
    this.HH = 0;
    invalidate();
    AppMethodBeat.o(202448);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(202449);
    if (this.DAZ != null) {
      paramCanvas.drawArc(this.DAZ, -90.0F, this.HH, false, this.DAX);
    }
    AppMethodBeat.o(202449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.b
 * JD-Core Version:    0.7.0.1
 */