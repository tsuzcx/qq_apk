package android.support.wearable.view;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.animation.LinearInterpolator;

@TargetApi(20)
final class s
  extends Drawable
{
  private static Property<s, Integer> Dt = new Property(Integer.class, "level") {};
  private static final TimeInterpolator Du = q.Dq;
  private int AX;
  private float AY;
  private final RectF Dv = new RectF();
  private final ObjectAnimator Dw;
  private final Paint nC = new Paint();
  
  public s()
  {
    this.nC.setAntiAlias(true);
    this.nC.setStyle(Paint.Style.STROKE);
    this.Dw = ObjectAnimator.ofInt(this, Dt, new int[] { 0, 10000 });
    this.Dw.setRepeatCount(-1);
    this.Dw.setRepeatMode(1);
    this.Dw.setDuration(6000L);
    this.Dw.setInterpolator(new LinearInterpolator());
  }
  
  private static float c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 != paramFloat2) {
      return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
    }
    return 0.0F;
  }
  
  public final void aW(int paramInt)
  {
    this.AX = paramInt;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    float f2 = 0.0F;
    paramCanvas.save();
    this.Dv.set(getBounds());
    this.Dv.inset(this.AY / 2.0F, this.AY / 2.0F);
    this.nC.setStrokeWidth(this.AY);
    this.nC.setColor(this.AX);
    int j = getLevel();
    float f3 = (j - j / 2000 * 2000) / 2000.0F;
    int i;
    label120:
    float f4;
    RectF localRectF;
    if (f3 < 0.5F)
    {
      i = 1;
      if (i == 0) {
        break label203;
      }
      f1 = Du.getInterpolation(c(0.0F, 0.5F, f3)) * 306.0F;
      f4 = Math.max(1.0F, f1);
      paramCanvas.rotate(j * 1.0E-004F * 2.0F * 360.0F - 90.0F + 54.0F * f3, this.Dv.centerX(), this.Dv.centerY());
      localRectF = this.Dv;
      if (i == 0) {
        break label228;
      }
    }
    label203:
    label228:
    for (float f1 = f2;; f1 = 306.0F - f4)
    {
      paramCanvas.drawArc(localRectF, f1, f4, false, this.nC);
      paramCanvas.restore();
      return;
      i = 0;
      break;
      f1 = (1.0F - Du.getInterpolation(c(0.5F, 1.0F, f3))) * 306.0F;
      break label120;
    }
  }
  
  public final void fq()
  {
    this.Dw.start();
  }
  
  public final void fr()
  {
    this.Dw.cancel();
  }
  
  public final int getOpacity()
  {
    return -1;
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    return true;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  public final void x(float paramFloat)
  {
    this.AY = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.s
 * JD-Core Version:    0.7.0.1
 */