import android.os.Looper;
import com.tencent.ad.tangram.offline.AdOfflineAdapter;

public final class abkc
  implements AdOfflineAdapter
{
  public String getAppVersion()
  {
    return abrp.a();
  }
  
  public String getVersionIfExists(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      abrl.d("GdtOfflineAdapter", "getVersionIfExists error");
      return null;
    }
    return nny.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abkc
 * JD-Core Version:    0.7.0.1
 */