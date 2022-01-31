import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class afeh
  implements UniformDownloader.IUniformDownloaderListener
{
  public afeh(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle) {}
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i("NearbyProfileDisplayPanel", 1, "onDownloadSucess() called with: filePath = [" + paramString + "], fileSize = [" + paramLong + "], extData = [" + paramBundle + "]");
    paramBundle = BaseApplicationImpl.getContext().getSharedPreferences("now_down_apk", 4);
    paramBundle.edit().putInt("state", 1);
    paramBundle.edit().putString("filePath", paramString);
  }
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void c(int paramInt, Bundle paramBundle) {}
  
  public void d(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afeh
 * JD-Core Version:    0.7.0.1
 */