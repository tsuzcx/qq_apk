import android.content.Context;
import java.lang.reflect.Method;
import mqq.app.IActivityDispatchCallback;

public abstract class aaff
  implements IActivityDispatchCallback
{
  public static aaff a;
  
  public static void a()
  {
    try
    {
      Method localMethod = Class.forName("com.tencent.mobileqq.screendetect.ScreenShotDetector").getMethod("getInstance", new Class[0]);
      localMethod.setAccessible(true);
      a = (aaff)localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(Context paramContext)
  {
    aaff localaaff = a;
    if (localaaff != null) {
      localaaff.c(paramContext);
    }
  }
  
  public static void b(Context paramContext)
  {
    aaff localaaff = a;
    if (localaaff != null) {
      localaaff.d(paramContext);
    }
  }
  
  public abstract void c(Context paramContext);
  
  public abstract void d(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aaff
 * JD-Core Version:    0.7.0.1
 */