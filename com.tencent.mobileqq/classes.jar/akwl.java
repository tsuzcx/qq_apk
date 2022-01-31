import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ActionSheet;
import java.io.File;

public class akwl
  implements Runnable
{
  public akwl(SwiftBrowserLongClickHandler paramSwiftBrowserLongClickHandler, String paramString) {}
  
  public void run()
  {
    Object localObject = new Bundle();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie(this.jdField_a_of_type_JavaLangString);
    if (str != null)
    {
      ((Bundle)localObject).putString("Cookie", str);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserLongClickHandler", 2, "Get cookie: " + Util.c(str, new String[0]) + " from " + Util.b(this.jdField_a_of_type_JavaLangString, new String[0]));
      }
    }
    localObject = ImageUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, (Bundle)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_b_of_type_JavaLangString = ((String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserLongClickHandler", 2, "saveImage filepath = " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_b_of_type_JavaLangString);
    }
    if (localObject == null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new akwm(this));
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.b((String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new akwn(this));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.a((String)localObject);
        return;
      }
    } while ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.a(new File((String)localObject)).booleanValue()) || (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new akwo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akwl
 * JD-Core Version:    0.7.0.1
 */