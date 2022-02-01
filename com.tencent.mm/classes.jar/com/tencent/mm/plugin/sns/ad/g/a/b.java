package com.tencent.mm.plugin.sns.ad.g.a;

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
  protected Paint zsn;
  protected RectF zso;
  protected ValueAnimator.AnimatorUpdateListener zsp;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(219192);
    this.zsp = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(219191);
        try
        {
          b.this.Hx = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          b.this.invalidate();
          AppMethodBeat.o(219191);
          return;
        }
        catch (Exception paramAnonymousValueAnimator)
        {
          AppMethodBeat.o(219191);
        }
      }
    };
    this.zsn = new Paint();
    this.zsn.setColor(Color.parseColor("#FFEDEDED"));
    this.zsn.setAntiAlias(true);
    this.zsn.setDither(true);
    this.zsn.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(219192);
  }
  
  public final void as(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(219193);
    clear();
    int i = paramInt3 / 2;
    this.zso = new RectF(i, i, paramInt2 * 2 - i, paramInt2 * 2 - i);
    this.zsn.setStrokeWidth(paramInt3);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 362 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(this.zsp);
    this.wV = new AnimatorSet();
    this.wV.playSequentially(new Animator[] { localValueAnimator });
    this.wV.start();
    AppMethodBeat.o(219193);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(219194);
    if (this.wV != null) {
      this.wV.cancel();
    }
    this.Hx = 0;
    invalidate();
    AppMethodBeat.o(219194);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(219195);
    if (this.zso != null) {
      paramCanvas.drawArc(this.zso, -90.0F, this.Hx, false, this.zsn);
    }
    AppMethodBeat.o(219195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.a.b
 * JD-Core Version:    0.7.0.1
 */