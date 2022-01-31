import android.app.Activity;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class akoz
  implements Runnable
{
  public akoz(SwiftBrowserLongClickHandler paramSwiftBrowserLongClickHandler) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, 2131430002, 1).b(this.a.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akoz
 * JD-Core Version:    0.7.0.1
 */