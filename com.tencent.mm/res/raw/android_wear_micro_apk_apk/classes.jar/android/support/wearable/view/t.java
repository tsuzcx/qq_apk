package android.support.wearable.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;

final class t
  extends Drawable
{
  final RectF Fk = new RectF();
  final Paint Fq = new Paint();
  
  t(ProgressSpinner paramProgressSpinner)
  {
    this.Fq.setAntiAlias(true);
    this.Fq.setColor(-1);
    this.Fq.setStyle(Paint.Style.STROKE);
    this.Fq.setStrokeCap(Paint.Cap.ROUND);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    float f1 = getBounds().width() / 2;
    RectF localRectF;
    if (this.Fr.isInEditMode())
    {
      localRectF = new RectF(getBounds());
      localRectF.inset(10.0F, 10.0F);
      this.Fq.setColor(ProgressSpinner.b(this.Fr)[0]);
      this.Fq.setStrokeWidth(7.0F);
      paramCanvas.drawArc(localRectF, 0.0F, 270.0F, false, this.Fq);
      return;
    }
    float f2;
    float f3;
    int m;
    int k;
    int i;
    int j;
    if (ProgressSpinner.c(this.Fr) < 1.0F)
    {
      f2 = ProgressSpinner.d(this.Fr).getInterpolation(ProgressSpinner.d(0.2F, 0.8F, ProgressSpinner.c(this.Fr)));
      f3 = ProgressSpinner.d(this.Fr).getInterpolation(ProgressSpinner.d(0.4F, 1.0F, ProgressSpinner.c(this.Fr)));
      f2 = f2 * 0.7F * f1;
      f3 = 0.5F * f3 * f1;
      f1 = (f2 - f3) / 2.0F + (f1 - f2);
      f2 -= f3;
      this.Fk.set(getBounds());
      this.Fk.inset(f1, f1);
      this.Fq.setStrokeWidth(f2);
      m = (getLevel() + 10000 - ProgressSpinner.e(this.Fr)) % 10000;
      f1 = 360.0F;
      k = ProgressSpinner.b(this.Fr)[0];
      f3 = 0.0F;
      if (ProgressSpinner.c(this.Fr) >= 1.0F) {
        break label384;
      }
      f1 = 360.0F;
      i = 0;
      j = k;
    }
    for (;;)
    {
      this.Fq.setColor(j);
      if (f1 < 1.0F) {
        f1 = 1.0F;
      }
      for (;;)
      {
        if (f2 <= 0.1D) {
          break label601;
        }
        paramCanvas.rotate(m * 1.0E-004F * 2.0F * 360.0F - 90.0F + f3, this.Fk.centerX(), this.Fk.centerY());
        localRectF = this.Fk;
        if (i != 0) {}
        for (f2 = 0.0F;; f2 = 306.0F - f1)
        {
          paramCanvas.drawArc(localRectF, f2, f1, false, this.Fq);
          return;
          f1 = getBounds().width() / 5;
          f2 = getBounds().width() / 10;
          break;
          label384:
          i = ProgressSpinner.b(this.Fr).length;
          int n = 10000 / i;
          j = 0;
          for (;;)
          {
            if (j >= i) {
              break label603;
            }
            if (m <= (j + 1) * n)
            {
              f1 = (m - j * n) / n;
              if (f1 < 0.5F) {}
              for (i = 1;; i = 0)
              {
                f3 = 54.0F * f1;
                if (i == 0) {
                  break label532;
                }
                j = ProgressSpinner.a(this.Fr, f1, ProgressSpinner.b(this.Fr)[j], ProgressSpinner.b(this.Fr)[((j + 1) % ProgressSpinner.b(this.Fr).length)]);
                f1 = ProgressSpinner.d(this.Fr).getInterpolation(ProgressSpinner.e(0.0F, 0.5F, f1)) * 306.0F;
                break;
              }
              label532:
              j = ProgressSpinner.b(this.Fr)[((j + 1) % ProgressSpinner.b(this.Fr).length)];
              f1 = (1.0F - ProgressSpinner.d(this.Fr).getInterpolation(ProgressSpinner.e(0.5F, 1.0F, f1))) * 306.0F;
              break;
            }
            j += 1;
          }
        }
      }
      label601:
      break;
      label603:
      i = 0;
      j = k;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.t
 * JD-Core Version:    0.7.0.1
 */