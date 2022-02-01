package android.support.wearable.view;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

@TargetApi(20)
final class v
  extends Drawable
  implements Drawable.Callback
{
  private int Dq;
  private ColorFilter Dr;
  private boolean Ds = true;
  private boolean Dt = true;
  private int Du;
  private PorterDuff.Mode Dv;
  private float FA = 1.0F;
  private int FB;
  private int FC;
  private float FD;
  private float FE;
  private int Ft = 2;
  private int Fu = 2;
  private float Fv = 1.0F;
  private float Fw = 1.0F;
  private int Fx;
  private int Fy;
  private final Rect Fz = new Rect();
  private Drawable ie;
  private int pH = 255;
  
  public v()
  {
    this((byte)0);
  }
  
  private v(byte paramByte)
  {
    setDrawable(null);
  }
  
  private static float a(float paramFloat, int paramInt)
  {
    float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    do
    {
      return f;
      f = paramFloat;
    } while (paramFloat <= paramInt);
    return paramInt;
  }
  
  private void b(Rect paramRect)
  {
    if (this.ie != null)
    {
      int i = this.ie.getIntrinsicWidth();
      int j = this.ie.getIntrinsicHeight();
      if ((i != -1) && (j != -1)) {
        this.ie.setBounds(paramRect.left, paramRect.top, i + paramRect.left, j + paramRect.top);
      }
    }
    else
    {
      return;
    }
    this.ie.setBounds(paramRect);
  }
  
  private void fC()
  {
    if (this.ie == null) {}
    while ((this.Fz.width() == 0) || (this.Fz.height() == 0)) {
      return;
    }
    this.FB = this.ie.getIntrinsicWidth();
    this.FC = this.ie.getIntrinsicHeight();
    if ((this.FB == -1) || (this.FC == -1))
    {
      this.FB = this.Fz.width();
      this.FC = this.Fz.height();
      this.FA = 1.0F;
      this.FD = 0.0F;
      this.FE = 0.0F;
      this.Fx = 0;
      this.Fy = 0;
      return;
    }
    this.FD = (this.Fz.width() * 0.2F);
    this.FE = (this.Fz.height() * 0.2F);
    float f1 = this.Fz.width() + this.Ft * this.FD;
    float f2 = this.Fz.height() + this.Fu * this.FE;
    this.FA = Math.max(f1 / this.FB, f2 / this.FC);
    float f3 = this.FB * this.FA;
    float f4 = this.FC;
    float f5 = this.FA;
    if (f3 > f1)
    {
      this.Fx = ((int)((f3 - f1) / 2.0F));
      this.Fy = 0;
      return;
    }
    this.Fy = ((int)((f4 * f5 - f2) / 2.0F));
    this.Fx = 0;
  }
  
  public final void X(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.max(0, paramInt1 - 1);
    paramInt2 = Math.max(0, paramInt2 - 1);
    if ((paramInt1 != this.Ft) || (paramInt2 != this.Fu))
    {
      this.Ft = paramInt1;
      this.Fu = paramInt2;
      this.Fv = a(this.Fv, this.Ft);
      this.Fw = a(this.Fw, this.Fu);
      fC();
      invalidateSelf();
    }
  }
  
  public final void clearColorFilter()
  {
    if (this.Dv != null)
    {
      this.Dv = null;
      if (this.ie != null) {
        this.ie.clearColorFilter();
      }
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.ie != null)
    {
      paramCanvas.save();
      paramCanvas.clipRect(getBounds());
      float f1 = this.Fx;
      float f2 = this.Fv;
      float f3 = this.FD;
      float f4 = this.Fy;
      float f5 = this.Fw;
      float f6 = this.FE;
      paramCanvas.translate(-(f1 + f2 * f3), -(f4 + f5 * f6));
      paramCanvas.scale(this.FA, this.FA);
      this.ie.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public final void e(float paramFloat1, float paramFloat2)
  {
    if ((this.Fv != paramFloat1) || (this.Fw != paramFloat2))
    {
      this.Fv = a(paramFloat1, this.Ft);
      this.Fw = a(paramFloat2, this.Fu);
      invalidateSelf();
    }
  }
  
  public final int getAlpha()
  {
    return this.pH;
  }
  
  public final int getChangingConfigurations()
  {
    return this.Dq;
  }
  
  public final int getOpacity()
  {
    if (this.ie != null) {
      return this.ie.getOpacity();
    }
    return 0;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable == this.ie) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public final boolean isStateful()
  {
    if (this.ie != null) {
      return this.ie.isStateful();
    }
    return false;
  }
  
  public final void jumpToCurrentState()
  {
    if (this.ie != null) {
      this.ie.jumpToCurrentState();
    }
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    this.Fz.set(paramRect);
    b(paramRect);
    fC();
    invalidateSelf();
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    if (this.ie != null) {
      return this.ie.setLevel(paramInt);
    }
    return false;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.ie != null) {
      return this.ie.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.ie) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.pH != paramInt)
    {
      this.pH = paramInt;
      if (this.ie != null) {
        this.ie.setAlpha(paramInt);
      }
    }
  }
  
  public final void setChangingConfigurations(int paramInt)
  {
    if (this.Dq != paramInt)
    {
      this.Dq = paramInt;
      if (this.ie != null) {
        this.ie.setChangingConfigurations(paramInt);
      }
    }
  }
  
  public final void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    if ((this.Du != paramInt) || (this.Dv != paramMode))
    {
      this.Du = paramInt;
      this.Dv = paramMode;
      if (this.ie != null) {
        this.ie.setColorFilter(paramInt, paramMode);
      }
    }
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.Dr != paramColorFilter)
    {
      this.Dr = paramColorFilter;
      if (this.ie != null) {
        this.ie.setColorFilter(paramColorFilter);
      }
    }
  }
  
  public final void setDither(boolean paramBoolean)
  {
    if (this.Dt != paramBoolean)
    {
      this.Dt = paramBoolean;
      if (this.ie != null) {
        this.ie.setDither(paramBoolean);
      }
    }
  }
  
  public final void setDrawable(Drawable paramDrawable)
  {
    if (this.ie == paramDrawable) {}
    do
    {
      return;
      if (this.ie != null) {
        this.ie.setCallback(null);
      }
      this.ie = paramDrawable;
    } while (this.ie == null);
    this.ie.setAlpha(getAlpha());
    b(getBounds());
    this.ie.setCallback(this);
    if (this.Dr != null) {
      this.ie.setColorFilter(this.Dr);
    }
    if (this.Dv != null) {
      this.ie.setColorFilter(this.Du, this.Dv);
    }
    this.ie.setDither(this.Dt);
    this.ie.setFilterBitmap(this.Ds);
    this.ie.setState(getState());
    fC();
    invalidateSelf();
  }
  
  public final void setFilterBitmap(boolean paramBoolean)
  {
    if (this.Ds != paramBoolean)
    {
      this.Ds = paramBoolean;
      if (this.ie != null) {
        this.ie.setFilterBitmap(paramBoolean);
      }
    }
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if ((paramDrawable == this.ie) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.v
 * JD-Core Version:    0.7.0.1
 */