package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class h
  extends Drawable.ConstantState
{
  int gi;
  Drawable.ConstantState gj;
  ColorStateList gk = null;
  PorterDuff.Mode gl = g.gb;
  
  h(h paramh)
  {
    if (paramh != null)
    {
      this.gi = paramh.gi;
      this.gj = paramh.gj;
      this.gk = paramh.gk;
      this.gl = paramh.gl;
    }
  }
  
  public int getChangingConfigurations()
  {
    int j = this.gi;
    if (this.gj != null) {}
    for (int i = this.gj.getChangingConfigurations();; i = 0) {
      return i | j;
    }
  }
  
  public Drawable newDrawable()
  {
    return newDrawable(null);
  }
  
  public abstract Drawable newDrawable(Resources paramResources);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.a.a.h
 * JD-Core Version:    0.7.0.1
 */