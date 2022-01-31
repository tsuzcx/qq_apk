import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.GetApkNameCallback;

public class aczl
  implements UniformDownloadUtil.GetApkNameCallback
{
  public aczl(UniformDownloadMgr paramUniformDownloadMgr, String paramString) {}
  
  public void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new aczm(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aczl
 * JD-Core Version:    0.7.0.1
 */