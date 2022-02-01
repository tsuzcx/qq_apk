import android.os.Looper;
import com.tencent.ad.tangram.offline.AdOfflineAdapter;

public final class abzs
  implements AdOfflineAdapter
{
  public String getAppVersion()
  {
    return achs.a();
  }
  
  public String getVersionIfExists(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      acho.d("GdtOfflineAdapter", "getVersionIfExists error");
      return null;
    }
    return nuz.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzs
 * JD-Core Version:    0.7.0.1
 */