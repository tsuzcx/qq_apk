import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class akco
  implements Runnable
{
  public akco(SwiftWebAccelerator paramSwiftWebAccelerator, long paramLong) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers.run cost " + (l - this.jdField_a_of_type_Long) + "ms.");
    l = System.currentTimeMillis();
    if (!VipWebViewReportLog.a())
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
      VipWebViewReportLog.a(BaseApplicationImpl.sApplication.getApplicationContext(), localAppRuntime);
    }
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers:load http core data config, cost " + (System.currentTimeMillis() - l) + "ms.");
    l = System.currentTimeMillis();
    SwiftWebViewUtils.a();
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers:load cdn cache config, cost " + (System.currentTimeMillis() - l) + "ms.");
    l = System.currentTimeMillis();
    IndividuationUrlHelper.a(BaseApplicationImpl.sApplication.getRuntime());
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers:load Individuation url config, cost " + (System.currentTimeMillis() - l) + "ms.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akco
 * JD-Core Version:    0.7.0.1
 */