import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.qphone.base.util.QLog;

public class ajxt
  implements Runnable
{
  public ajxt(SnapshotService paramSnapshotService, ajya paramajya, ajxy paramajxy) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "start once debug, webview id =" + ajya.a(this.jdField_a_of_type_Ajya) + ", seq=" + this.jdField_a_of_type_Ajxy.a);
    }
    this.jdField_a_of_type_Ajya.a.a.invalidate();
    if (this.jdField_a_of_type_Ajya.a.a.getX5WebViewExtension() != null) {
      this.jdField_a_of_type_Ajya.a.a.loadUrl("javascript:window.scrollTo(0, 0);");
    }
    for (;;)
    {
      SnapshotService.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService, this.jdField_a_of_type_Ajxy, this.jdField_a_of_type_Ajya);
      return;
      this.jdField_a_of_type_Ajya.a.a.pageUp(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxt
 * JD-Core Version:    0.7.0.1
 */