import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class acoi
  implements UniformDownloader.IUniformDownloaderListener
{
  public acoi(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadStart progress = " + paramInt);
    }
    this.a.runOnUiThread(new acok(this));
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadFailed errCode = " + paramInt);
    }
    this.a.runOnUiThread(new acoo(this));
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadSucess ");
    }
    this.a.runOnUiThread(new acoj(this));
    ReportController.b(null, "dc00898", "", "", "0X8008FFA", "0X8008FFA", 1, 0, "", "", "", "");
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadProgress progress = " + paramInt);
    }
    this.a.runOnUiThread(new acom(this, paramInt));
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadPause progress = " + paramInt);
    }
    this.a.runOnUiThread(new acon(this));
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadResume progress = " + paramInt);
    }
    this.a.runOnUiThread(new acol(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acoi
 * JD-Core Version:    0.7.0.1
 */