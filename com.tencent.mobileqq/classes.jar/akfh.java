import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.qphone.base.util.QLog;

public class akfh
  implements Runnable
{
  public akfh(SnapshotService paramSnapshotService, akfo paramakfo, akfm paramakfm) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "start once debug, webview id =" + akfo.a(this.jdField_a_of_type_Akfo) + ", seq=" + this.jdField_a_of_type_Akfm.a);
    }
    this.jdField_a_of_type_Akfo.a.a.invalidate();
    if (this.jdField_a_of_type_Akfo.a.a.getX5WebViewExtension() != null) {
      this.jdField_a_of_type_Akfo.a.a.loadUrl("javascript:window.scrollTo(0, 0);");
    }
    for (;;)
    {
      SnapshotService.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService, this.jdField_a_of_type_Akfm, this.jdField_a_of_type_Akfo);
      return;
      this.jdField_a_of_type_Akfo.a.a.pageUp(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfh
 * JD-Core Version:    0.7.0.1
 */