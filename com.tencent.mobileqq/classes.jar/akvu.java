import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.SetCookiesCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

class akvu
  implements Runnable
{
  akvu(akvt paramakvt) {}
  
  public void run()
  {
    Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (String)localIterator.next();
      Object localObject2 = (CopyOnWriteArrayList)this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject3);
      if (this.a.jdField_a_of_type_MqqAppAppRuntime == null) {}
      for (Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();; localObject1 = this.a.jdField_a_of_type_MqqAppAppRuntime)
      {
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.a((String)localObject3, (AppRuntime)localObject1);
        localObject2 = ((CopyOnWriteArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SwiftBrowserCookieMonster.SetCookiesCallback)((Iterator)localObject2).next();
          if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserCookieMonster", 2, "post callback onSetCookiesFinished " + Util.b((String)localObject1, new String[0]) + ", errorCode: " + this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.jdField_a_of_type_Long);
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.b) {
            QLog.i("SwiftBrowserCookieMonster", 1, "cookie is wrong, need do jump ptlogin! " + Util.b((String)localObject1, new String[0]));
          }
          ((SwiftBrowserCookieMonster.SetCookiesCallback)localObject3).a((String)localObject1, null, this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.jdField_a_of_type_Long);
        }
        break;
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.b) || (this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.jdField_a_of_type_Long > 0L))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.b();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akvu
 * JD-Core Version:    0.7.0.1
 */