import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.GetApkNameCallback;

public final class acyg
  implements UniformDownloadUtil.GetApkNameCallback
{
  public acyg(String paramString) {}
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new acyh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acyg
 * JD-Core Version:    0.7.0.1
 */