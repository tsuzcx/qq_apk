import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class akpg
  implements AsyncCallBack
{
  akpg(akpf paramakpf, long paramLong) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Akpf.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("SwiftBrowserOfflineHandler", 2, "now offline bid has checked, bid " + this.jdField_a_of_type_Akpf.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler.jdField_a_of_type_JavaLangString + ", loadMode: " + this.jdField_a_of_type_Akpf.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", cost: " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (paramInt != 0)
    {
      OfflinePlugin.c(this.jdField_a_of_type_Akpf.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler.jdField_a_of_type_JavaLangString);
      OfflineWebResManager.a(this.jdField_a_of_type_Akpf.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Akpf.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akpg
 * JD-Core Version:    0.7.0.1
 */