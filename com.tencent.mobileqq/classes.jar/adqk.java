import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.GetApkNameCallback;

public final class adqk
  implements UniformDownloadUtil.GetApkNameCallback
{
  public adqk(String paramString) {}
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new adql(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adqk
 * JD-Core Version:    0.7.0.1
 */