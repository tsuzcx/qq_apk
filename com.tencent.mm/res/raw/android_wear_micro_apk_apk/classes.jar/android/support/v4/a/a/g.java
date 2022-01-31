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

class g
  extends Drawable
  implements Drawable.Callback, n
{
  static final PorterDuff.Mode gb = PorterDuff.Mode.SRC_IN;
  private int gc;
  private PorterDuff.Mode gd;
  private boolean ge;
  h gf;
  private boolean gg;
  Drawable gh;
  
  g(Drawable paramDrawable)
  {
    this.gf = aD();
    c(paramDrawable);
  }
  
  g(h paramh, Resources paramResources)
  {
    this.gf = paramh;
    if ((this.gf != null) && (this.gf.gj != null)) {
      c(this.gf.gj.newDrawable(paramResources));
    }
  }
  
  private boolean a(int[] paramArrayOfInt)
  {
    if (!aE()) {}
    PorterDuff.Mode localMode;
    int i;
    do
    {
      return false;
      ColorStateList localColorStateList = this.gf.gk;
      localMode = this.gf.gl;
      if ((localColorStateList == null) || (localMode == null)) {
        break;
      }
      i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
    } while ((this.ge) && (i == this.gc) && (localMode == this.gd));
    setColorFilter(i, localMode);
    this.gc = i;
    this.gd = localMode;
    this.ge = true;
    return true;
    this.ge = false;
    clearColorFilter();
    return false;
  }
  
  private void c(Drawable paramDrawable)
  {
    if (this.gh != null) {
      this.gh.setCallback(null);
    }
    this.gh = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      setVisible(paramDrawable.isVisible(), true);
      setState(paramDrawable.getState());
      setLevel(paramDrawable.getLevel());
      setBounds(paramDrawable.getBounds());
      if (this.gf != null) {
        this.gf.gj = paramDrawable.getConstantState();
      }
    }
    invalidateSelf();
  }
  
  h aD()
  {
    return new i(this.gf);
  }
  
  protected boolean aE()
  {
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.gh.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    int j = super.getChangingConfigurations();
    if (this.gf != null) {}
    for (int i = this.gf.getChangingConfigurations();; i = 0) {
      return i | j | this.gh.getChangingConfigurations();
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.gf != null)
    {
      if (this.gf.gj != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.gf.gi = getChangingConfigurations();
        return this.gf;
      }
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.gh.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return this.gh.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.gh.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.gh.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.gh.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return this.gh.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.gh.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    return this.gh.getState();
  }
  
  public Region getTransparentRegion()
  {
    return this.gh.getTransparentRegion();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    if ((aE()) && (this.gf != null)) {}
    for (ColorStateList localColorStateList = this.gf.gk; ((localColorStateList != null) && (localColorStateList.isStateful())) || (this.gh.isStateful()); localColorStateList = null) {
      return true;
    }
    return false;
  }
  
  public void jumpToCurrentState()
  {
    this.gh.jumpToCurrentState();
  }
  
  public Drawable mutate()
  {
    h localh;
    if ((!this.gg) && (super.mutate() == this))
    {
      this.gf = aD();
      if (this.gh != null) {
        this.gh.mutate();
      }
      if (this.gf != null)
      {
        localh = this.gf;
        if (this.gh == null) {
          break label77;
        }
      }
    }
    label77:
    for (Drawable.ConstantState localConstantState = this.gh.getConstantState();; localConstantState = null)
    {
      localh.gj = localConstantState;
      this.gg = true;
      return this;
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.gh != null) {
      this.gh.setBounds(paramRect);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return this.gh.setLevel(paramInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.gh.setAlpha(paramInt);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    this.gh.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.gh.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.gh.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.gh.setFilterBitmap(paramBoolean);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    boolean bool = this.gh.setState(paramArrayOfInt);
    return (a(paramArrayOfInt)) || (bool);
  }
  
  public void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.gf.gk = paramColorStateList;
    a(getState());
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.gf.gl = paramMode;
    a(getState());
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (super.setVisible(paramBoolean1, paramBoolean2)) || (this.gh.setVisible(paramBoolean1, paramBoolean2));
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.a.a.g
 * JD-Core Version:    0.7.0.1
 */