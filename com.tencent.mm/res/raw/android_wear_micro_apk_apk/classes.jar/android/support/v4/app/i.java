package android.support.v4.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class i
{
  private static Method au;
  private static boolean av;
  private static Method aw;
  private static boolean ax;
  
  public static IBinder a(Bundle paramBundle, String paramString)
  {
    if (!av) {}
    try
    {
      Method localMethod = Bundle.class.getMethod("getIBinder", new Class[] { String.class });
      au = localMethod;
      localMethod.setAccessible(true);
      av = true;
      if (au == null) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          paramBundle = (IBinder)au.invoke(paramBundle, new Object[] { paramString });
          return paramBundle;
        }
        catch (IllegalAccessException paramBundle)
        {
          Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", paramBundle);
          au = null;
          return null;
        }
        catch (IllegalArgumentException paramBundle)
        {
          continue;
        }
        catch (InvocationTargetException paramBundle)
        {
          continue;
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", localNoSuchMethodException);
      }
    }
  }
  
  public static void a(Bundle paramBundle, String paramString, IBinder paramIBinder)
  {
    if (!ax) {}
    try
    {
      Method localMethod = Bundle.class.getMethod("putIBinder", new Class[] { String.class, IBinder.class });
      aw = localMethod;
      localMethod.setAccessible(true);
      ax = true;
      if (aw == null) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          aw.invoke(paramBundle, new Object[] { paramString, paramIBinder });
          return;
        }
        catch (IllegalAccessException paramBundle)
        {
          Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", paramBundle);
          aw = null;
          return;
        }
        catch (IllegalArgumentException paramBundle)
        {
          continue;
        }
        catch (InvocationTargetException paramBundle)
        {
          continue;
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", localNoSuchMethodException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.i
 * JD-Core Version:    0.7.0.1
 */