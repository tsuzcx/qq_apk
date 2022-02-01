import android.os.Looper;
import com.tencent.ad.tangram.offline.AdOfflineAdapter;

public final class acjq
  implements AdOfflineAdapter
{
  public String getAppVersion()
  {
    return acrb.a();
  }
  
  public String getVersionIfExists(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      acqy.d("GdtOfflineAdapter", "getVersionIfExists error");
      return null;
    }
    return nko.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjq
 * JD-Core Version:    0.7.0.1
 */