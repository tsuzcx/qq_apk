package android.support.v4.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.b.a;
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public final class c
  extends Drawable
  implements Animatable
{
  private static final Interpolator pf = new LinearInterpolator();
  private static final Interpolator pg = new a();
  private static final int[] ph = { -16777216 };
  private Animator dn;
  private final d pi;
  private float pj;
  private Resources pk;
  private float pl;
  private boolean pm;
  
  public c(final Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException();
    }
    this.pk = ((Context)paramContext).getResources();
    this.pi = new d();
    paramContext = this.pi;
    paramContext.pw = ph;
    paramContext.S(0);
    this.pi.setStrokeWidth(2.5F);
    invalidateSelf();
    paramContext = this.pi;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        c.a(c.this, f, paramContext);
        c.a(c.this, f, paramContext, false);
        c.this.invalidateSelf();
      }
    });
    localValueAnimator.setRepeatCount(-1);
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setInterpolator(pf);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        c.a(c.this, 1.0F, paramContext, true);
        paramContext.cd();
        d locald = paramContext;
        locald.S(locald.cb());
        if (c.a(c.this))
        {
          c.b(c.this);
          paramAnonymousAnimator.cancel();
          paramAnonymousAnimator.setDuration(1332L);
          paramAnonymousAnimator.start();
          paramContext.n(false);
          return;
        }
        c.a(c.this, c.c(c.this) + 1.0F);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        c.a(c.this, 0.0F);
      }
    });
    this.dn = localValueAnimator;
  }
  
  private static void a(float paramFloat, d paramd)
  {
    if (paramFloat > 0.75F)
    {
      paramFloat = (paramFloat - 0.75F) / 0.25F;
      int n = paramd.cc();
      int i = paramd.pw[paramd.cb()];
      int j = n >> 24 & 0xFF;
      int k = n >> 16 & 0xFF;
      int m = n >> 8 & 0xFF;
      n &= 0xFF;
      int i1 = (int)(((i >> 24 & 0xFF) - j) * paramFloat);
      int i2 = (int)(((i >> 16 & 0xFF) - k) * paramFloat);
      int i3 = (int)(((i >> 8 & 0xFF) - m) * paramFloat);
      paramd.hY = ((int)(paramFloat * ((i & 0xFF) - n)) + n | j + i1 << 24 | k + i2 << 16 | i3 + m << 8);
      return;
    }
    paramd.hY = paramd.cc();
  }
  
  public final void ca()
  {
    d locald = this.pi;
    float f = this.pk.getDisplayMetrics().density;
    locald.setStrokeWidth(2.5F * f);
    locald.pE = (7.5F * f);
    locald.S(0);
    locald.pF = ((int)(10.0F * f));
    locald.pG = ((int)(f * 5.0F));
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.pj, localRect.exactCenterX(), localRect.exactCenterY());
    d locald = this.pi;
    RectF localRectF = locald.pp;
    float f1 = locald.pE + locald.pv / 2.0F;
    if (locald.pE <= 0.0F) {
      f1 = Math.min(localRect.width(), localRect.height()) / 2.0F - Math.max(locald.pF * locald.pD / 2.0F, locald.pv / 2.0F);
    }
    localRectF.set(localRect.centerX() - f1, localRect.centerY() - f1, localRect.centerX() + f1, f1 + localRect.centerY());
    f1 = (locald.pt + locald.pj) * 360.0F;
    float f2 = (locald.pu + locald.pj) * 360.0F - f1;
    locald.pq.setColor(locald.hY);
    locald.pq.setAlpha(locald.pH);
    float f3 = locald.pv / 2.0F;
    localRectF.inset(f3, f3);
    paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, locald.ps);
    localRectF.inset(-f3, -f3);
    paramCanvas.drawArc(localRectF, f1, f2, false, locald.pq);
    if (locald.pB)
    {
      if (locald.pC != null) {
        break label522;
      }
      locald.pC = new Path();
      locald.pC.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      f3 = Math.min(localRectF.width(), localRectF.height()) / 2.0F;
      float f4 = locald.pF * locald.pD / 2.0F;
      locald.pC.moveTo(0.0F, 0.0F);
      locald.pC.lineTo(locald.pF * locald.pD, 0.0F);
      locald.pC.lineTo(locald.pF * locald.pD / 2.0F, locald.pG * locald.pD);
      locald.pC.offset(f3 + localRectF.centerX() - f4, localRectF.centerY() + locald.pv / 2.0F);
      locald.pC.close();
      locald.pr.setColor(locald.hY);
      locald.pr.setAlpha(locald.pH);
      paramCanvas.save();
      paramCanvas.rotate(f1 + f2, localRectF.centerX(), localRectF.centerY());
      paramCanvas.drawPath(locald.pC, locald.pr);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
      label522:
      locald.pC.reset();
    }
  }
  
  public final void f(float paramFloat)
  {
    d locald = this.pi;
    if (paramFloat != locald.pD) {
      locald.pD = paramFloat;
    }
    invalidateSelf();
  }
  
  public final void g(float paramFloat)
  {
    this.pi.pt = 0.0F;
    this.pi.pu = paramFloat;
    invalidateSelf();
  }
  
  public final int getAlpha()
  {
    return this.pi.pH;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void h(float paramFloat)
  {
    this.pi.pj = paramFloat;
    invalidateSelf();
  }
  
  public final boolean isRunning()
  {
    return this.dn.isRunning();
  }
  
  public final void m(boolean paramBoolean)
  {
    this.pi.n(paramBoolean);
    invalidateSelf();
  }
  
  public final void setAlpha(int paramInt)
  {
    this.pi.pH = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.pi.pq.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public final void start()
  {
    this.dn.cancel();
    this.pi.cd();
    if (this.pi.pu != this.pi.pt)
    {
      this.pm = true;
      this.dn.setDuration(666L);
      this.dn.start();
      return;
    }
    this.pi.S(0);
    this.pi.ce();
    this.dn.setDuration(1332L);
    this.dn.start();
  }
  
  public final void stop()
  {
    this.dn.cancel();
    this.pj = 0.0F;
    this.pi.n(false);
    this.pi.S(0);
    this.pi.ce();
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.c
 * JD-Core Version:    0.7.0.1
 */