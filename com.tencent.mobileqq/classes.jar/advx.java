import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class advx
  implements UniformDownloader.IUniformDownloaderListener
{
  public advx(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle) {}
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i("NearbyHybridFragment", 2, "onDownloadSucess() called with: filePath = [" + paramString + "], fileSize = [" + paramLong + "], extData = [" + paramBundle + "]");
    paramBundle = BaseApplicationImpl.getContext().getSharedPreferences("now_down_apk", 4);
    paramBundle.edit().putInt("state", 1);
    paramBundle.edit().putString("filePath", paramString);
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    QLog.i("NearbyHybridFragment", 2, "onDownloadProgress() called with: progress = [" + paramInt + "], extData = [" + paramBundle + "]");
  }
  
  public void c(int paramInt, Bundle paramBundle) {}
  
  public void d(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advx
 * JD-Core Version:    0.7.0.1
 */