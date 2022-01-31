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
  private static final Interpolator nr = new LinearInterpolator();
  private static final Interpolator ns = new a();
  private static final int[] nt = { -16777216 };
  private Animator bE;
  private final d nu;
  private float nv;
  private Resources nw;
  private float nx;
  private boolean ny;
  
  public c(final Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException();
    }
    this.nw = ((Context)paramContext).getResources();
    this.nu = new d();
    paramContext = this.nu;
    paramContext.nI = nt;
    paramContext.H(0);
    this.nu.setStrokeWidth(2.5F);
    invalidateSelf();
    paramContext = this.nu;
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
    localValueAnimator.setInterpolator(nr);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        c.a(c.this, 1.0F, paramContext, true);
        paramContext.bZ();
        d locald = paramContext;
        locald.H(locald.bX());
        if (c.a(c.this))
        {
          c.b(c.this);
          paramAnonymousAnimator.cancel();
          paramAnonymousAnimator.setDuration(1332L);
          paramAnonymousAnimator.start();
          paramContext.k(false);
          return;
        }
        c.a(c.this, c.c(c.this) + 1.0F);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        c.a(c.this, 0.0F);
      }
    });
    this.bE = localValueAnimator;
  }
  
  private static void a(float paramFloat, d paramd)
  {
    if (paramFloat > 0.75F)
    {
      paramFloat = (paramFloat - 0.75F) / 0.25F;
      int n = paramd.bY();
      int i = paramd.nI[paramd.bX()];
      int j = n >> 24 & 0xFF;
      int k = n >> 16 & 0xFF;
      int m = n >> 8 & 0xFF;
      n &= 0xFF;
      int i1 = (int)(((i >> 24 & 0xFF) - j) * paramFloat);
      int i2 = (int)(((i >> 16 & 0xFF) - k) * paramFloat);
      int i3 = (int)(((i >> 8 & 0xFF) - m) * paramFloat);
      paramd.gc = ((int)(paramFloat * ((i & 0xFF) - n)) + n | j + i1 << 24 | k + i2 << 16 | i3 + m << 8);
      return;
    }
    paramd.gc = paramd.bY();
  }
  
  public final void bW()
  {
    d locald = this.nu;
    float f = this.nw.getDisplayMetrics().density;
    locald.setStrokeWidth(2.5F * f);
    locald.nQ = (7.5F * f);
    locald.H(0);
    locald.nR = ((int)(10.0F * f));
    locald.nS = ((int)(f * 5.0F));
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.nv, localRect.exactCenterX(), localRect.exactCenterY());
    d locald = this.nu;
    RectF localRectF = locald.nB;
    float f1 = locald.nQ + locald.nH / 2.0F;
    if (locald.nQ <= 0.0F) {
      f1 = Math.min(localRect.width(), localRect.height()) / 2.0F - Math.max(locald.nR * locald.nP / 2.0F, locald.nH / 2.0F);
    }
    localRectF.set(localRect.centerX() - f1, localRect.centerY() - f1, localRect.centerX() + f1, f1 + localRect.centerY());
    f1 = (locald.nF + locald.nv) * 360.0F;
    float f2 = (locald.nG + locald.nv) * 360.0F - f1;
    locald.nC.setColor(locald.gc);
    locald.nC.setAlpha(locald.nT);
    float f3 = locald.nH / 2.0F;
    localRectF.inset(f3, f3);
    paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, locald.nE);
    localRectF.inset(-f3, -f3);
    paramCanvas.drawArc(localRectF, f1, f2, false, locald.nC);
    if (locald.nN)
    {
      if (locald.nO != null) {
        break label522;
      }
      locald.nO = new Path();
      locald.nO.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      f3 = Math.min(localRectF.width(), localRectF.height()) / 2.0F;
      float f4 = locald.nR * locald.nP / 2.0F;
      locald.nO.moveTo(0.0F, 0.0F);
      locald.nO.lineTo(locald.nR * locald.nP, 0.0F);
      locald.nO.lineTo(locald.nR * locald.nP / 2.0F, locald.nS * locald.nP);
      locald.nO.offset(f3 + localRectF.centerX() - f4, localRectF.centerY() + locald.nH / 2.0F);
      locald.nO.close();
      locald.nD.setColor(locald.gc);
      locald.nD.setAlpha(locald.nT);
      paramCanvas.save();
      paramCanvas.rotate(f1 + f2, localRectF.centerX(), localRectF.centerY());
      paramCanvas.drawPath(locald.nO, locald.nD);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
      label522:
      locald.nO.reset();
    }
  }
  
  public final void e(float paramFloat)
  {
    d locald = this.nu;
    if (paramFloat != locald.nP) {
      locald.nP = paramFloat;
    }
    invalidateSelf();
  }
  
  public final void f(float paramFloat)
  {
    this.nu.nF = 0.0F;
    this.nu.nG = paramFloat;
    invalidateSelf();
  }
  
  public final void g(float paramFloat)
  {
    this.nu.nv = paramFloat;
    invalidateSelf();
  }
  
  public final int getAlpha()
  {
    return this.nu.nT;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean isRunning()
  {
    return this.bE.isRunning();
  }
  
  public final void j(boolean paramBoolean)
  {
    this.nu.k(paramBoolean);
    invalidateSelf();
  }
  
  public final void setAlpha(int paramInt)
  {
    this.nu.nT = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.nu.nC.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public final void start()
  {
    this.bE.cancel();
    this.nu.bZ();
    if (this.nu.nG != this.nu.nF)
    {
      this.ny = true;
      this.bE.setDuration(666L);
      this.bE.start();
      return;
    }
    this.nu.H(0);
    this.nu.ca();
    this.bE.setDuration(1332L);
    this.bE.start();
  }
  
  public final void stop()
  {
    this.bE.cancel();
    this.nv = 0.0F;
    this.nu.k(false);
    this.nu.H(0);
    this.nu.ca();
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.c
 * JD-Core Version:    0.7.0.1
 */