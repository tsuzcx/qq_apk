package android.support.v4.a.a;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;

public final class a
{
  private static Method hV;
  private static boolean hW;
  
  public static Drawable a(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    do
    {
      do
      {
        do
        {
          return paramDrawable;
          if (Build.VERSION.SDK_INT < 21) {
            break;
          }
        } while ((paramDrawable instanceof b));
        return new h(paramDrawable);
        if (Build.VERSION.SDK_INT < 19) {
          break;
        }
      } while ((paramDrawable instanceof b));
      return new f(paramDrawable);
    } while ((paramDrawable instanceof b));
    return new c(paramDrawable);
  }
  
  public static boolean a(Drawable paramDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramDrawable.setLayoutDirection(paramInt);
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (!hW) {}
      try
      {
        Method localMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[] { Integer.TYPE });
        hV = localMethod;
        localMethod.setAccessible(true);
        hW = true;
        if (hV != null) {
          try
          {
            hV.invoke(paramDrawable, new Object[] { Integer.valueOf(paramInt) });
            return true;
          }
          catch (Exception paramDrawable)
          {
            Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", paramDrawable);
            hV = null;
          }
        }
        return false;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;)
        {
          Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", localNoSuchMethodException);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.a.a.a
 * JD-Core Version:    0.7.0.1
 */