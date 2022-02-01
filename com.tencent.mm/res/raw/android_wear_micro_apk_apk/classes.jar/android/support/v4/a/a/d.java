package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class d
  extends Drawable.ConstantState
{
  int jdField_if;
  Drawable.ConstantState ig;
  ColorStateList ih = null;
  PorterDuff.Mode ii = c.hX;
  
  d(d paramd)
  {
    if (paramd != null)
    {
      this.jdField_if = paramd.jdField_if;
      this.ig = paramd.ig;
      this.ih = paramd.ih;
      this.ii = paramd.ii;
    }
  }
  
  public int getChangingConfigurations()
  {
    int j = this.jdField_if;
    if (this.ig != null) {}
    for (int i = this.ig.getChangingConfigurations();; i = 0) {
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
 * Qualified Name:     android.support.v4.a.a.d
 * JD-Core Version:    0.7.0.1
 */