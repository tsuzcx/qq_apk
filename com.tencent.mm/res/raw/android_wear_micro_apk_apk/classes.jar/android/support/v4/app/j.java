package android.support.v4.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class j
{
  private static Method cd;
  private static boolean ce;
  private static Method cf;
  private static boolean cg;
  
  public static IBinder a(Bundle paramBundle, String paramString)
  {
    if (!ce) {}
    try
    {
      Method localMethod = Bundle.class.getMethod("getIBinder", new Class[] { String.class });
      cd = localMethod;
      localMethod.setAccessible(true);
      ce = true;
      if (cd == null) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          paramBundle = (IBinder)cd.invoke(paramBundle, new Object[] { paramString });
          return paramBundle;
        }
        catch (IllegalAccessException paramBundle)
        {
          Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", paramBundle);
          cd = null;
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
    if (!cg) {}
    try
    {
      Method localMethod = Bundle.class.getMethod("putIBinder", new Class[] { String.class, IBinder.class });
      cf = localMethod;
      localMethod.setAccessible(true);
      cg = true;
      if (cf == null) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          cf.invoke(paramBundle, new Object[] { paramString, paramIBinder });
          return;
        }
        catch (IllegalAccessException paramBundle)
        {
          Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", paramBundle);
          cf = null;
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
 * Qualified Name:     android.support.v4.app.j
 * JD-Core Version:    0.7.0.1
 */