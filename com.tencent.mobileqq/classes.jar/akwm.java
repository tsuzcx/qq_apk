import android.app.Activity;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class akwm
  implements Runnable
{
  akwm(akwl paramakwl) {}
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    QQToast.a(this.a.a.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, 2131430004, 1).b(this.a.a.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akwm
 * JD-Core Version:    0.7.0.1
 */