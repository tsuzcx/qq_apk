import android.content.Context;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import java.lang.ref.WeakReference;

public final class acft
{
  private static volatile acft a;
  
  public static acft a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new acft();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    AdIPCManager.INSTANCE.init(paramContext, new WeakReference(acim.a().a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acft
 * JD-Core Version:    0.7.0.1
 */