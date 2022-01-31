import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.qphone.base.util.QLog;

public class akqr
  implements Runnable
{
  public akqr(SwiftWebAccelerator paramSwiftWebAccelerator, long paramLong, Bundle paramBundle) {}
  
  public void run()
  {
    SwiftWebAccelerator.TbsAccelerator.b();
    SwiftBrowserStatistics.C = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.i("WebLog_SwiftWebAccelerator", 1, "initX5Environment on sub thread, cost " + SwiftBrowserStatistics.C + "ms.");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftWebAccelerator.a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akqr
 * JD-Core Version:    0.7.0.1
 */