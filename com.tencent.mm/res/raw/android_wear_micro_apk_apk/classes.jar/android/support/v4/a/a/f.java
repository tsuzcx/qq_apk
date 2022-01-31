package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

class f
{
  public void a(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    if ((paramDrawable instanceof n)) {
      ((n)paramDrawable).setTintList(paramColorStateList);
    }
  }
  
  public void a(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    if ((paramDrawable instanceof n)) {
      ((n)paramDrawable).setTintMode(paramMode);
    }
  }
  
  public boolean a(Drawable paramDrawable)
  {
    return false;
  }
  
  public boolean a(Drawable paramDrawable, int paramInt)
  {
    return false;
  }
  
  public Drawable b(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (!(paramDrawable instanceof n)) {
      localObject = new g(paramDrawable);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.a.a.f
 * JD-Core Version:    0.7.0.1
 */