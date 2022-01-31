import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.qphone.base.util.QLog;

public class akqs
  implements Runnable
{
  public akqs(SwiftWebAccelerator paramSwiftWebAccelerator, SwiftReuseTouchWebView paramSwiftReuseTouchWebView) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftReuseTouchWebView.destroy();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WebLog_SwiftWebAccelerator", 1, "doMainStep_WarnUpWebView error:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akqs
 * JD-Core Version:    0.7.0.1
 */