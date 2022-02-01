package android.support.wearable.view;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

@TargetApi(20)
public final class f
  extends Drawable
  implements Drawable.Callback
{
  private float CO;
  private Drawable Do;
  private Drawable Dp;
  private int Dq;
  private ColorFilter Dr;
  private boolean Ds;
  private boolean Dt;
  private int Du;
  private PorterDuff.Mode Dv;
  private int pH;
  
  private void f(Drawable paramDrawable)
  {
    paramDrawable.setCallback(this);
    paramDrawable.setState(getState());
    if (this.Dr != null) {
      paramDrawable.setColorFilter(this.Dr);
    }
    if (this.Dv != null) {
      paramDrawable.setColorFilter(this.Du, this.Dv);
    }
    paramDrawable.setDither(this.Dt);
    paramDrawable.setFilterBitmap(this.Ds);
    paramDrawable.setBounds(getBounds());
  }
  
  public final void clearColorFilter()
  {
    if (this.Dv != null)
    {
      this.Dv = null;
      if (this.Do != null) {
        this.Do.clearColorFilter();
      }
      if (this.Dp != null) {
        this.Dp.clearColorFilter();
      }
    }
  }
  
  public final void d(Drawable paramDrawable)
  {
    if (this.Do != paramDrawable)
    {
      if (this.Do != null) {
        this.Do.setCallback(null);
      }
      this.Do = paramDrawable;
      if (paramDrawable != null) {
        f(paramDrawable);
      }
      invalidateSelf();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if ((this.Dp != null) && ((this.CO < 1.0F) || (this.Do == null)))
    {
      this.Dp.setAlpha(255);
      this.Dp.draw(paramCanvas);
    }
    if ((this.Do != null) && (this.CO > 0.0F))
    {
      this.Do.setAlpha((int)(255.0F * this.CO));
      this.Do.draw(paramCanvas);
    }
  }
  
  public final void e(Drawable paramDrawable)
  {
    if (this.Dp != paramDrawable)
    {
      if (this.Dp != null) {
        this.Dp.setCallback(null);
      }
      this.Dp = paramDrawable;
      f(paramDrawable);
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
  
  public final int getIntrinsicHeight()
  {
    int j = -1;
    int i;
    if (this.Do == null)
    {
      i = -1;
      if (this.Dp != null) {
        break label35;
      }
    }
    for (;;)
    {
      return Math.max(i, j);
      i = this.Do.getIntrinsicHeight();
      break;
      label35:
      j = this.Dp.getIntrinsicHeight();
    }
  }
  
  public final int getIntrinsicWidth()
  {
    int j = -1;
    int i;
    if (this.Do == null)
    {
      i = -1;
      if (this.Dp != null) {
        break label35;
      }
    }
    for (;;)
    {
      return Math.max(i, j);
      i = this.Do.getIntrinsicWidth();
      break;
      label35:
      j = this.Dp.getIntrinsicHeight();
    }
  }
  
  public final int getOpacity()
  {
    int j = 0;
    int i;
    if (this.Do == null)
    {
      i = 0;
      if (this.Dp != null) {
        break label35;
      }
    }
    for (;;)
    {
      return resolveOpacity(i, j);
      i = this.Do.getOpacity();
      break;
      label35:
      j = this.Dp.getOpacity();
    }
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    if (((paramDrawable == this.Do) || (paramDrawable == this.Dp)) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public final boolean isStateful()
  {
    return ((this.Do != null) && (this.Do.isStateful())) || ((this.Dp != null) && (this.Dp.isStateful()));
  }
  
  public final void jumpToCurrentState()
  {
    if (this.Do != null) {
      this.Do.jumpToCurrentState();
    }
    if (this.Dp != null) {
      this.Dp.jumpToCurrentState();
    }
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.Dp != null) {
      this.Dp.setBounds(paramRect);
    }
    if (this.Do != null) {
      this.Do.setBounds(paramRect);
    }
    invalidateSelf();
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    boolean bool1 = false;
    if (this.Do != null) {
      bool1 = this.Do.setLevel(paramInt) | false;
    }
    boolean bool2 = bool1;
    if (this.Dp != null) {
      bool2 = bool1 | this.Dp.setLevel(paramInt);
    }
    return bool2;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool1 = false;
    if (this.Do != null) {
      bool1 = this.Do.setState(paramArrayOfInt) | false;
    }
    boolean bool2 = bool1;
    if (this.Dp != null) {
      bool2 = bool1 | this.Dp.setState(paramArrayOfInt);
    }
    return bool2;
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (((paramDrawable == this.Do) || (paramDrawable == this.Dp)) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public final void setAlpha(int paramInt)
  {
    if (paramInt != this.pH)
    {
      this.pH = paramInt;
      invalidateSelf();
    }
  }
  
  public final void setChangingConfigurations(int paramInt)
  {
    if (this.Dq != paramInt)
    {
      this.Dq = paramInt;
      if (this.Do != null) {
        this.Do.setChangingConfigurations(paramInt);
      }
      if (this.Dp != null) {
        this.Dp.setChangingConfigurations(paramInt);
      }
    }
  }
  
  public final void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    if ((this.Du != paramInt) || (this.Dv != paramMode))
    {
      this.Du = paramInt;
      this.Dv = paramMode;
      if (this.Do != null) {
        this.Do.setColorFilter(paramInt, paramMode);
      }
      if (this.Dp != null) {
        this.Dp.setColorFilter(paramInt, paramMode);
      }
    }
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.Dr != paramColorFilter)
    {
      this.Dr = paramColorFilter;
      if (this.Do != null) {
        this.Do.setColorFilter(paramColorFilter);
      }
      if (this.Dp != null) {
        this.Dp.setColorFilter(paramColorFilter);
      }
    }
  }
  
  public final void setDither(boolean paramBoolean)
  {
    if (this.Dt != paramBoolean)
    {
      this.Dt = paramBoolean;
      if (this.Do != null) {
        this.Do.setDither(paramBoolean);
      }
      if (this.Dp != null) {
        this.Dp.setDither(paramBoolean);
      }
    }
  }
  
  public final void setFilterBitmap(boolean paramBoolean)
  {
    if (this.Ds != paramBoolean)
    {
      this.Ds = paramBoolean;
      if (this.Do != null) {
        this.Do.setFilterBitmap(paramBoolean);
      }
      if (this.Dp != null) {
        this.Dp.setFilterBitmap(paramBoolean);
      }
    }
  }
  
  public final void setProgress(float paramFloat)
  {
    float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      if (f != this.CO)
      {
        this.CO = f;
        invalidateSelf();
      }
      return;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (((paramDrawable == this.Do) || (paramDrawable == this.Dp)) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.f
 * JD-Core Version:    0.7.0.1
 */