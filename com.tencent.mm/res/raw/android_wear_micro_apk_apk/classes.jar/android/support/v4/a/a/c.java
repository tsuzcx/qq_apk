package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class c
  extends Drawable
  implements Drawable.Callback, b
{
  static final PorterDuff.Mode hX = PorterDuff.Mode.SRC_IN;
  private int hY;
  private PorterDuff.Mode hZ;
  private boolean ia;
  d ib;
  private boolean ic;
  Drawable ie;
  
  c(Drawable paramDrawable)
  {
    this.ib = aT();
    b(paramDrawable);
  }
  
  c(d paramd, Resources paramResources)
  {
    this.ib = paramd;
    if ((this.ib != null) && (this.ib.ig != null)) {
      b(this.ib.ig.newDrawable(paramResources));
    }
  }
  
  private boolean a(int[] paramArrayOfInt)
  {
    if (!aU()) {}
    PorterDuff.Mode localMode;
    int i;
    do
    {
      return false;
      ColorStateList localColorStateList = this.ib.ih;
      localMode = this.ib.ii;
      if ((localColorStateList == null) || (localMode == null)) {
        break;
      }
      i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
    } while ((this.ia) && (i == this.hY) && (localMode == this.hZ));
    setColorFilter(i, localMode);
    this.hY = i;
    this.hZ = localMode;
    this.ia = true;
    return true;
    this.ia = false;
    clearColorFilter();
    return false;
  }
  
  private void b(Drawable paramDrawable)
  {
    if (this.ie != null) {
      this.ie.setCallback(null);
    }
    this.ie = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      setVisible(paramDrawable.isVisible(), true);
      setState(paramDrawable.getState());
      setLevel(paramDrawable.getLevel());
      setBounds(paramDrawable.getBounds());
      if (this.ib != null) {
        this.ib.ig = paramDrawable.getConstantState();
      }
    }
    invalidateSelf();
  }
  
  d aT()
  {
    return new e(this.ib);
  }
  
  protected boolean aU()
  {
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.ie.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    int j = super.getChangingConfigurations();
    if (this.ib != null) {}
    for (int i = this.ib.getChangingConfigurations();; i = 0) {
      return i | j | this.ie.getChangingConfigurations();
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.ib != null)
    {
      if (this.ib.ig != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.ib.jdField_if = getChangingConfigurations();
        return this.ib;
      }
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.ie.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return this.ie.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.ie.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.ie.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.ie.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return this.ie.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.ie.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    return this.ie.getState();
  }
  
  public Region getTransparentRegion()
  {
    return this.ie.getTransparentRegion();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    if ((aU()) && (this.ib != null)) {}
    for (ColorStateList localColorStateList = this.ib.ih; ((localColorStateList != null) && (localColorStateList.isStateful())) || (this.ie.isStateful()); localColorStateList = null) {
      return true;
    }
    return false;
  }
  
  public void jumpToCurrentState()
  {
    this.ie.jumpToCurrentState();
  }
  
  public Drawable mutate()
  {
    d locald;
    if ((!this.ic) && (super.mutate() == this))
    {
      this.ib = aT();
      if (this.ie != null) {
        this.ie.mutate();
      }
      if (this.ib != null)
      {
        locald = this.ib;
        if (this.ie == null) {
          break label77;
        }
      }
    }
    label77:
    for (Drawable.ConstantState localConstantState = this.ie.getConstantState();; localConstantState = null)
    {
      locald.ig = localConstantState;
      this.ic = true;
      return this;
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.ie != null) {
      this.ie.setBounds(paramRect);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return this.ie.setLevel(paramInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.ie.setAlpha(paramInt);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    this.ie.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.ie.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.ie.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.ie.setFilterBitmap(paramBoolean);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    boolean bool = this.ie.setState(paramArrayOfInt);
    return (a(paramArrayOfInt)) || (bool);
  }
  
  public void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.ib.ih = paramColorStateList;
    a(getState());
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.ib.ii = paramMode;
    a(getState());
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (super.setVisible(paramBoolean1, paramBoolean2)) || (this.ie.setVisible(paramBoolean1, paramBoolean2));
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.a.a.c
 * JD-Core Version:    0.7.0.1
 */