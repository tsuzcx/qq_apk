import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.GetApkNameCallback;

public final class adid
  implements UniformDownloadUtil.GetApkNameCallback
{
  public adid(String paramString) {}
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new adie(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adid
 * JD-Core Version:    0.7.0.1
 */