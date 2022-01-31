package android.support.v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

public final class e
{
  private static Field jM;
  private static boolean jN;
  static final g jO = new g();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      jO = new f();
      return;
    }
  }
  
  static void a(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    if (!jN) {}
    try
    {
      Field localField = LayoutInflater.class.getDeclaredField("mFactory2");
      jM = localField;
      localField.setAccessible(true);
      jN = true;
      if (jM == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          jM.set(paramLayoutInflater, paramFactory2);
          return;
        }
        catch (IllegalAccessException paramFactory2)
        {
          Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + paramLayoutInflater + "; inflation may have unexpected results.", paramFactory2);
        }
        localNoSuchFieldException = localNoSuchFieldException;
        Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", localNoSuchFieldException);
      }
    }
  }
  
  public static void b(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    jO.b(paramLayoutInflater, paramFactory2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.e
 * JD-Core Version:    0.7.0.1
 */