import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.qphone.base.util.QLog;

public class ajjp
  implements Runnable
{
  public ajjp(SnapshotService paramSnapshotService, ajjw paramajjw, ajju paramajju) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "start once debug, webview id =" + ajjw.a(this.jdField_a_of_type_Ajjw) + ", seq=" + this.jdField_a_of_type_Ajju.a);
    }
    this.jdField_a_of_type_Ajjw.a.a.invalidate();
    if (this.jdField_a_of_type_Ajjw.a.a.getX5WebViewExtension() != null) {
      this.jdField_a_of_type_Ajjw.a.a.loadUrl("javascript:window.scrollTo(0, 0);");
    }
    for (;;)
    {
      SnapshotService.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService, this.jdField_a_of_type_Ajju, this.jdField_a_of_type_Ajjw);
      return;
      this.jdField_a_of_type_Ajjw.a.a.pageUp(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajjp
 * JD-Core Version:    0.7.0.1
 */