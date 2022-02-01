import android.content.Context;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import java.lang.ref.WeakReference;

public final class actp
{
  private static volatile actp a;
  
  public static actp a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new actp();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    AdIPCManager.INSTANCE.init(paramContext, new WeakReference(acwf.a().a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actp
 * JD-Core Version:    0.7.0.1
 */