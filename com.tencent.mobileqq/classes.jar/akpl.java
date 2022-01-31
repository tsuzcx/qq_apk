import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class akpl
  implements Runnable
{
  public akpl(SwiftBrowserScreenShotHandler paramSwiftBrowserScreenShotHandler, String paramString, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool3 = false;
    String str = ImageUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool3;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        bool2 = bool3;
        if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.h)) {
          bool2 = true;
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "doMultiShare download Finish!");
        QLog.d("SwiftBrowserScreenShotHandler", 2, "isGif:" + this.jdField_a_of_type_Boolean + ", imgUrl:" + this.jdField_a_of_type_JavaLangString);
        QLog.d("SwiftBrowserScreenShotHandler", 2, "isLastMultiShare:" + bool2 + ", mLastMultiShareUrl:" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.h);
        QLog.d("SwiftBrowserScreenShotHandler", 2, "isDialogShowing:" + bool1 + ", localPath:" + str);
      }
      if ((bool1) && (bool2))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.jdField_a_of_type_AndroidOsHandler.post(new akpm(this));
        if (TextUtils.isEmpty(str)) {
          break label304;
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.e = str;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.b = 3;
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.g(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.e);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.jdField_a_of_type_AndroidOsHandler.post(new akpn(this));
    return;
    label304:
    QRUtils.a(1, 2131438472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akpl
 * JD-Core Version:    0.7.0.1
 */