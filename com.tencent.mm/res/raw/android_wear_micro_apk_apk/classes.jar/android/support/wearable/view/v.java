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
  private int BB;
  private ColorFilter BC;
  private boolean BD = true;
  private boolean BE = true;
  private int BF;
  private PorterDuff.Mode BG;
  private int DE = 2;
  private int DF = 2;
  private float DG = 1.0F;
  private float DH = 1.0F;
  private int DI;
  private int DJ;
  private final Rect DK = new Rect();
  private float DL = 1.0F;
  private int DM;
  private int DN;
  private float DO;
  private float DP;
  private Drawable gh;
  private int nT = 255;
  
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
  
  private void a(Rect paramRect)
  {
    if (this.gh != null)
    {
      int i = this.gh.getIntrinsicWidth();
      int j = this.gh.getIntrinsicHeight();
      if ((i != -1) && (j != -1)) {
        this.gh.setBounds(paramRect.left, paramRect.top, i + paramRect.left, j + paramRect.top);
      }
    }
    else
    {
      return;
    }
    this.gh.setBounds(paramRect);
  }
  
  private void ft()
  {
    if (this.gh == null) {}
    while ((this.DK.width() == 0) || (this.DK.height() == 0)) {
      return;
    }
    this.DM = this.gh.getIntrinsicWidth();
    this.DN = this.gh.getIntrinsicHeight();
    if ((this.DM == -1) || (this.DN == -1))
    {
      this.DM = this.DK.width();
      this.DN = this.DK.height();
      this.DL = 1.0F;
      this.DO = 0.0F;
      this.DP = 0.0F;
      this.DI = 0;
      this.DJ = 0;
      return;
    }
    this.DO = (this.DK.width() * 0.2F);
    this.DP = (this.DK.height() * 0.2F);
    float f1 = this.DK.width() + this.DE * this.DO;
    float f2 = this.DK.height() + this.DF * this.DP;
    this.DL = Math.max(f1 / this.DM, f2 / this.DN);
    float f3 = this.DM * this.DL;
    float f4 = this.DN;
    float f5 = this.DL;
    if (f3 > f1)
    {
      this.DI = ((int)((f3 - f1) / 2.0F));
      this.DJ = 0;
      return;
    }
    this.DJ = ((int)((f4 * f5 - f2) / 2.0F));
    this.DI = 0;
  }
  
  public final void V(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.max(0, paramInt1 - 1);
    paramInt2 = Math.max(0, paramInt2 - 1);
    if ((paramInt1 != this.DE) || (paramInt2 != this.DF))
    {
      this.DE = paramInt1;
      this.DF = paramInt2;
      this.DG = a(this.DG, this.DE);
      this.DH = a(this.DH, this.DF);
      ft();
      invalidateSelf();
    }
  }
  
  public final void clearColorFilter()
  {
    if (this.BG != null)
    {
      this.BG = null;
      if (this.gh != null) {
        this.gh.clearColorFilter();
      }
    }
  }
  
  public final void d(float paramFloat1, float paramFloat2)
  {
    if ((this.DG != paramFloat1) || (this.DH != paramFloat2))
    {
      this.DG = a(paramFloat1, this.DE);
      this.DH = a(paramFloat2, this.DF);
      invalidateSelf();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.gh != null)
    {
      paramCanvas.save();
      paramCanvas.clipRect(getBounds());
      float f1 = this.DI;
      float f2 = this.DG;
      float f3 = this.DO;
      float f4 = this.DJ;
      float f5 = this.DH;
      float f6 = this.DP;
      paramCanvas.translate(-(f1 + f2 * f3), -(f4 + f5 * f6));
      paramCanvas.scale(this.DL, this.DL);
      this.gh.draw(paramCanvas);
      paramCanvas.restore();
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
  
  public final int getOpacity()
  {
    if (this.gh != null) {
      return this.gh.getOpacity();
    }
    return 0;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable == this.gh) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public final boolean isStateful()
  {
    if (this.gh != null) {
      return this.gh.isStateful();
    }
    return false;
  }
  
  public final void jumpToCurrentState()
  {
    if (this.gh != null) {
      this.gh.jumpToCurrentState();
    }
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    this.DK.set(paramRect);
    a(paramRect);
    ft();
    invalidateSelf();
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    if (this.gh != null) {
      return this.gh.setLevel(paramInt);
    }
    return false;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.gh != null) {
      return this.gh.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.gh) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.nT != paramInt)
    {
      this.nT = paramInt;
      if (this.gh != null) {
        this.gh.setAlpha(paramInt);
      }
    }
  }
  
  public final void setChangingConfigurations(int paramInt)
  {
    if (this.BB != paramInt)
    {
      this.BB = paramInt;
      if (this.gh != null) {
        this.gh.setChangingConfigurations(paramInt);
      }
    }
  }
  
  public final void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    if ((this.BF != paramInt) || (this.BG != paramMode))
    {
      this.BF = paramInt;
      this.BG = paramMode;
      if (this.gh != null) {
        this.gh.setColorFilter(paramInt, paramMode);
      }
    }
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.BC != paramColorFilter)
    {
      this.BC = paramColorFilter;
      if (this.gh != null) {
        this.gh.setColorFilter(paramColorFilter);
      }
    }
  }
  
  public final void setDither(boolean paramBoolean)
  {
    if (this.BE != paramBoolean)
    {
      this.BE = paramBoolean;
      if (this.gh != null) {
        this.gh.setDither(paramBoolean);
      }
    }
  }
  
  public final void setDrawable(Drawable paramDrawable)
  {
    if (this.gh == paramDrawable) {}
    do
    {
      return;
      if (this.gh != null) {
        this.gh.setCallback(null);
      }
      this.gh = paramDrawable;
    } while (this.gh == null);
    this.gh.setAlpha(getAlpha());
    a(getBounds());
    this.gh.setCallback(this);
    if (this.BC != null) {
      this.gh.setColorFilter(this.BC);
    }
    if (this.BG != null) {
      this.gh.setColorFilter(this.BF, this.BG);
    }
    this.gh.setDither(this.BE);
    this.gh.setFilterBitmap(this.BD);
    this.gh.setState(getState());
    ft();
    invalidateSelf();
  }
  
  public final void setFilterBitmap(boolean paramBoolean)
  {
    if (this.BD != paramBoolean)
    {
      this.BD = paramBoolean;
      if (this.gh != null) {
        this.gh.setFilterBitmap(paramBoolean);
      }
    }
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if ((paramDrawable == this.gh) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.v
 * JD-Core Version:    0.7.0.1
 */