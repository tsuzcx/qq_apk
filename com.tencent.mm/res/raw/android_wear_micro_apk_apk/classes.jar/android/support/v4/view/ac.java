package android.support.v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

@Deprecated
public final class ac
{
  private static Method kT;
  
  static
  {
    if (Build.VERSION.SDK_INT == 25) {}
    try
    {
      kT = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
      return;
    }
    catch (Exception localException)
    {
      Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
    }
  }
  
  @Deprecated
  public static int a(ViewConfiguration paramViewConfiguration)
  {
    return paramViewConfiguration.getScaledPagingTouchSlop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.ac
 * JD-Core Version:    0.7.0.1
 */