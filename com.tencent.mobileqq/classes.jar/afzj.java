import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;

class afzj
  implements aaea
{
  afzj(afzi paramafzi) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool;
    if (paramBundle.getInt("type") == 73)
    {
      bool = paramBundle.getBoolean("isSuccess");
      if ((!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (!this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.isDestroyed)) {}
    }
    else
    {
      return;
    }
    if (Boolean.valueOf(bool).booleanValue())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2, 2131719470, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getTitleBarHeight());
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131719467, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzj
 * JD-Core Version:    0.7.0.1
 */