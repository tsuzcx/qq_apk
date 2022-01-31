import android.app.Activity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class adxn
  extends DownloadListener
{
  public adxn(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (paramDownloadTask.a == 0)
    {
      paramDownloadTask = new File(AbsDownloader.d(this.jdField_a_of_type_JavaLangString));
      if (paramDownloadTask.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "shareImageToAIO->downloadFile success: " + this.jdField_a_of_type_JavaLangString);
        }
        localActivity.runOnUiThread(new adxo(this, paramDownloadTask));
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "shareImageToAIO->downloadFile failed: " + this.jdField_a_of_type_JavaLangString);
    }
    localActivity.runOnUiThread(new adxp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxn
 * JD-Core Version:    0.7.0.1
 */