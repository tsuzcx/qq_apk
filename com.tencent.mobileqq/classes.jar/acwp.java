import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class acwp
  implements UniformDownloader.IUniformDownloaderListener
{
  public acwp(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadStart progress = " + paramInt);
    }
    this.a.runOnUiThread(new acwr(this));
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadFailed errCode = " + paramInt);
    }
    this.a.runOnUiThread(new acwv(this));
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadSucess ");
    }
    this.a.runOnUiThread(new acwq(this));
    ReportController.b(null, "dc00898", "", "", "0X8008FFA", "0X8008FFA", 1, 0, "", "", "", "");
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadProgress progress = " + paramInt);
    }
    this.a.runOnUiThread(new acwt(this, paramInt));
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadPause progress = " + paramInt);
    }
    this.a.runOnUiThread(new acwu(this));
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadResume progress = " + paramInt);
    }
    this.a.runOnUiThread(new acws(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acwp
 * JD-Core Version:    0.7.0.1
 */