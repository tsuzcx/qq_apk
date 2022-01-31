import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.GetApkNameCallback;

public class acpo
  implements UniformDownloadUtil.GetApkNameCallback
{
  public acpo(UniformDownloadMgr paramUniformDownloadMgr, String paramString) {}
  
  public void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new acpp(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acpo
 * JD-Core Version:    0.7.0.1
 */