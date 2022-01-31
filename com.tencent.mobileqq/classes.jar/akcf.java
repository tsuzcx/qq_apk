import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils.OfflineData;
import com.tencent.smtt.sdk.QbSdk;

public class akcf
  implements Runnable
{
  public akcf(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler, String paramString) {}
  
  public void run()
  {
    if (QbSdk.getTbsVersion(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) >= 43810)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (SwiftOfflineDataUtils.a(this.jdField_a_of_type_JavaLangString))
      {
        SwiftOfflineDataUtils.OfflineData localOfflineData = SwiftOfflineDataUtils.a(this.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localOfflineData != null) {
          localObject1 = localOfflineData.b;
        }
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a, this.jdField_a_of_type_JavaLangString, (String)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akcf
 * JD-Core Version:    0.7.0.1
 */