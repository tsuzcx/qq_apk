import android.content.Context;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import java.lang.ref.WeakReference;

public final class acpm
{
  private static volatile acpm a;
  
  public static acpm a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new acpm();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    AdIPCManager.INSTANCE.init(paramContext, new WeakReference(acsb.a().a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpm
 * JD-Core Version:    0.7.0.1
 */