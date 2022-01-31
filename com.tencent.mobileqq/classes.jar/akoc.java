import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class akoc
  implements Runnable
{
  public akoc(SwiftBrowserCookieMonster paramSwiftBrowserCookieMonster, AppRuntime paramAppRuntime, Intent paramIntent) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      ??? = BaseApplicationImpl.getApplication().getRuntime();
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.b.get() == 2)
      {
        if (??? != null)
        {
          long l = System.currentTimeMillis();
          BrowserAppInterface.a(((AppRuntime)???).getAccount());
          if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserCookieMonster", 2, "SwiftBrowserCookieMonster: removeLastUinCookies,cost=" + (System.currentTimeMillis() - l));
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.c();
        if (QLog.isColorLevel()) {
          QLog.i("SwiftBrowserCookieMonster", 2, "start set all cookies " + Util.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.l, new String[0]));
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.a(this.jdField_a_of_type_AndroidContentIntent, (AppRuntime)???), true);
        if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.b.compareAndSet(2, 3)) {}
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.b.notifyAll();
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.a > 0L)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.g();
          QLog.e("SwiftBrowserCookieMonster", 1, "set cookie error :" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.a);
          Util.b("Web_qqbrowser_check_and_set_cookies");
          new Handler(Looper.getMainLooper()).post(new akod(this));
          return;
          ??? = this.jdField_a_of_type_MqqAppAppRuntime;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "set cookie success: now start post handle callback");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akoc
 * JD-Core Version:    0.7.0.1
 */