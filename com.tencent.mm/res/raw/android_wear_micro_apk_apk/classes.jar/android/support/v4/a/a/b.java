package android.support.v4.a.a;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

class b
  extends f
{
  private static Method fZ;
  private static boolean ga;
  
  public boolean a(Drawable paramDrawable, int paramInt)
  {
    if (!ga) {}
    try
    {
      Method localMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[] { Integer.TYPE });
      fZ = localMethod;
      localMethod.setAccessible(true);
      ga = true;
      if (fZ == null) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          fZ.invoke(paramDrawable, new Object[] { Integer.valueOf(paramInt) });
          return true;
        }
        catch (Exception paramDrawable)
        {
          Log.i("DrawableCompatApi17", "Failed to invoke setLayoutDirection(int) via reflection", paramDrawable);
          fZ = null;
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.i("DrawableCompatApi17", "Failed to retrieve setLayoutDirection(int) method", localNoSuchMethodException);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.a.a.b
 * JD-Core Version:    0.7.0.1
 */