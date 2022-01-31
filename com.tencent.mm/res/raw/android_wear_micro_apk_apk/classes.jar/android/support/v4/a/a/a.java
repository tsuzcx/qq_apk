package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public final class a
{
  static final f fY = new f();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      fY = new e();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      fY = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      fY = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      fY = new b();
      return;
    }
  }
  
  public static void a(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    fY.a(paramDrawable, paramColorStateList);
  }
  
  public static void a(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    fY.a(paramDrawable, paramMode);
  }
  
  public static boolean a(Drawable paramDrawable)
  {
    return fY.a(paramDrawable);
  }
  
  public static boolean a(Drawable paramDrawable, int paramInt)
  {
    return fY.a(paramDrawable, paramInt);
  }
  
  public static Drawable b(Drawable paramDrawable)
  {
    return fY.b(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.a.a.a
 * JD-Core Version:    0.7.0.1
 */