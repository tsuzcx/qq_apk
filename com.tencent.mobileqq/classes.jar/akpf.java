import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import java.util.concurrent.atomic.AtomicInteger;

public class akpf
  implements Runnable
{
  public akpf(SwiftBrowserOfflineHandler paramSwiftBrowserOfflineHandler, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler.b();
    long l = System.currentTimeMillis();
    if (SwiftBrowserOfflineHandler.c.get() == 3) {}
    for (boolean bool = HtmlOffline.a(BaseApplicationImpl.getApplication().getApplicationContext(), this.jdField_a_of_type_JavaLangString, new akpg(this, l));; bool = false)
    {
      if (!bool) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler.a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akpf
 * JD-Core Version:    0.7.0.1
 */