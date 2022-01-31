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
  private float AZ;
  private Drawable BA;
  private int BB;
  private ColorFilter BC;
  private boolean BD;
  private boolean BE;
  private int BF;
  private PorterDuff.Mode BG;
  private Drawable Bz;
  private int nT;
  
  private void g(Drawable paramDrawable)
  {
    paramDrawable.setCallback(this);
    paramDrawable.setState(getState());
    if (this.BC != null) {
      paramDrawable.setColorFilter(this.BC);
    }
    if (this.BG != null) {
      paramDrawable.setColorFilter(this.BF, this.BG);
    }
    paramDrawable.setDither(this.BE);
    paramDrawable.setFilterBitmap(this.BD);
    paramDrawable.setBounds(getBounds());
  }
  
  public final void clearColorFilter()
  {
    if (this.BG != null)
    {
      this.BG = null;
      if (this.Bz != null) {
        this.Bz.clearColorFilter();
      }
      if (this.BA != null) {
        this.BA.clearColorFilter();
      }
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if ((this.BA != null) && ((this.AZ < 1.0F) || (this.Bz == null)))
    {
      this.BA.setAlpha(255);
      this.BA.draw(paramCanvas);
    }
    if ((this.Bz != null) && (this.AZ > 0.0F))
    {
      this.Bz.setAlpha((int)(255.0F * this.AZ));
      this.Bz.draw(paramCanvas);
    }
  }
  
  public final void e(Drawable paramDrawable)
  {
    if (this.Bz != paramDrawable)
    {
      if (this.Bz != null) {
        this.Bz.setCallback(null);
      }
      this.Bz = paramDrawable;
      if (paramDrawable != null) {
        g(paramDrawable);
      }
      invalidateSelf();
    }
  }
  
  public final void f(Drawable paramDrawable)
  {
    if (this.BA != paramDrawable)
    {
      if (this.BA != null) {
        this.BA.setCallback(null);
      }
      this.BA = paramDrawable;
      g(paramDrawable);
      invalidateSelf();
    }
  }
  
  public final int getAlpha()
  {
    return this.nT;
  }
  
  public final int getChangingConfigurations()
  {
    return this.BB;
  }
  
  public final int getIntrinsicHeight()
  {
    int j = -1;
    int i;
    if (this.Bz == null)
    {
      i = -1;
      if (this.BA != null) {
        break label35;
      }
    }
    for (;;)
    {
      return Math.max(i, j);
      i = this.Bz.getIntrinsicHeight();
      break;
      label35:
      j = this.BA.getIntrinsicHeight();
    }
  }
  
  public final int getIntrinsicWidth()
  {
    int j = -1;
    int i;
    if (this.Bz == null)
    {
      i = -1;
      if (this.BA != null) {
        break label35;
      }
    }
    for (;;)
    {
      return Math.max(i, j);
      i = this.Bz.getIntrinsicWidth();
      break;
      label35:
      j = this.BA.getIntrinsicHeight();
    }
  }
  
  public final int getOpacity()
  {
    int j = 0;
    int i;
    if (this.Bz == null)
    {
      i = 0;
      if (this.BA != null) {
        break label35;
      }
    }
    for (;;)
    {
      return resolveOpacity(i, j);
      i = this.Bz.getOpacity();
      break;
      label35:
      j = this.BA.getOpacity();
    }
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    if (((paramDrawable == this.Bz) || (paramDrawable == this.BA)) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public final boolean isStateful()
  {
    return ((this.Bz != null) && (this.Bz.isStateful())) || ((this.BA != null) && (this.BA.isStateful()));
  }
  
  public final void jumpToCurrentState()
  {
    if (this.Bz != null) {
      this.Bz.jumpToCurrentState();
    }
    if (this.BA != null) {
      this.BA.jumpToCurrentState();
    }
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.BA != null) {
      this.BA.setBounds(paramRect);
    }
    if (this.Bz != null) {
      this.Bz.setBounds(paramRect);
    }
    invalidateSelf();
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    boolean bool1 = false;
    if (this.Bz != null) {
      bool1 = this.Bz.setLevel(paramInt) | false;
    }
    boolean bool2 = bool1;
    if (this.BA != null) {
      bool2 = bool1 | this.BA.setLevel(paramInt);
    }
    return bool2;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool1 = false;
    if (this.Bz != null) {
      bool1 = this.Bz.setState(paramArrayOfInt) | false;
    }
    boolean bool2 = bool1;
    if (this.BA != null) {
      bool2 = bool1 | this.BA.setState(paramArrayOfInt);
    }
    return bool2;
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (((paramDrawable == this.Bz) || (paramDrawable == this.BA)) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public final void setAlpha(int paramInt)
  {
    if (paramInt != this.nT)
    {
      this.nT = paramInt;
      invalidateSelf();
    }
  }
  
  public final void setChangingConfigurations(int paramInt)
  {
    if (this.BB != paramInt)
    {
      this.BB = paramInt;
      if (this.Bz != null) {
        this.Bz.setChangingConfigurations(paramInt);
      }
      if (this.BA != null) {
        this.BA.setChangingConfigurations(paramInt);
      }
    }
  }
  
  public final void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    if ((this.BF != paramInt) || (this.BG != paramMode))
    {
      this.BF = paramInt;
      this.BG = paramMode;
      if (this.Bz != null) {
        this.Bz.setColorFilter(paramInt, paramMode);
      }
      if (this.BA != null) {
        this.BA.setColorFilter(paramInt, paramMode);
      }
    }
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.BC != paramColorFilter)
    {
      this.BC = paramColorFilter;
      if (this.Bz != null) {
        this.Bz.setColorFilter(paramColorFilter);
      }
      if (this.BA != null) {
        this.BA.setColorFilter(paramColorFilter);
      }
    }
  }
  
  public final void setDither(boolean paramBoolean)
  {
    if (this.BE != paramBoolean)
    {
      this.BE = paramBoolean;
      if (this.Bz != null) {
        this.Bz.setDither(paramBoolean);
      }
      if (this.BA != null) {
        this.BA.setDither(paramBoolean);
      }
    }
  }
  
  public final void setFilterBitmap(boolean paramBoolean)
  {
    if (this.BD != paramBoolean)
    {
      this.BD = paramBoolean;
      if (this.Bz != null) {
        this.Bz.setFilterBitmap(paramBoolean);
      }
      if (this.BA != null) {
        this.BA.setFilterBitmap(paramBoolean);
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
      if (f != this.AZ)
      {
        this.AZ = f;
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
    if (((paramDrawable == this.Bz) || (paramDrawable == this.BA)) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.f
 * JD-Core Version:    0.7.0.1
 */