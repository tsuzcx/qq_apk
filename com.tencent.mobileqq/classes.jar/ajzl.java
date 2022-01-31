import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.qphone.base.util.QLog;

public class ajzl
  implements View.OnLongClickListener
{
  public ajzl(WebViewFragment paramWebViewFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting.a("web_view_long_click", true))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebLog_WebViewFragment", 1, "disable long click on current url!");
      }
      return true;
    }
    if (!this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting.a("image_long_click", false))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebLog_WebViewFragment", 1, "disable image long click on current url!");
      }
      return false;
    }
    SwiftBrowserLongClickHandler localSwiftBrowserLongClickHandler = (SwiftBrowserLongClickHandler)this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(8);
    if ((localSwiftBrowserLongClickHandler != null) && (localSwiftBrowserLongClickHandler.a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajzl
 * JD-Core Version:    0.7.0.1
 */