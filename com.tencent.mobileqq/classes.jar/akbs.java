import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class akbs
  implements Runnable
{
  public akbs(SwiftBrowserStatistics paramSwiftBrowserStatistics, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    if (!PushReportController.a)
    {
      boolean bool = QQUtils.a(BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserStatistics", 1, new Object[] { "reportPushEvent isScreenLock=", Boolean.valueOf(bool), ",isBackground=", Boolean.valueOf(this.jdField_a_of_type_MqqAppAppRuntime.isBackground_Stop) });
      }
      if ((bool) || (this.jdField_a_of_type_MqqAppAppRuntime.isBackground_Stop)) {
        SwiftBrowserStatistics.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akbs
 * JD-Core Version:    0.7.0.1
 */