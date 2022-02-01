import android.content.Context;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import java.lang.ref.WeakReference;

public final class abpz
{
  private static volatile abpz a;
  
  public static abpz a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new abpz();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    AdIPCManager.INSTANCE.init(paramContext, new WeakReference(absn.a().a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpz
 * JD-Core Version:    0.7.0.1
 */