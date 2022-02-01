import android.os.Looper;
import com.tencent.ad.tangram.offline.AdOfflineAdapter;

public final class acnu
  implements AdOfflineAdapter
{
  public String getAppVersion()
  {
    return acvf.a();
  }
  
  public String getVersionIfExists(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      acvc.d("GdtOfflineAdapter", "getVersionIfExists error");
      return null;
    }
    return nmj.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnu
 * JD-Core Version:    0.7.0.1
 */