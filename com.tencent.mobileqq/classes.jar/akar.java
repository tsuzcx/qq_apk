import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class akar
  implements Runnable
{
  public akar(SwiftBrowserLongClickHandler paramSwiftBrowserLongClickHandler, String paramString) {}
  
  public void run()
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    localIntent.setData(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 2, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_AndroidAppActivity.getString(2131429984, new Object[] { this.jdField_a_of_type_JavaLangString }), 1).b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akar
 * JD-Core Version:    0.7.0.1
 */