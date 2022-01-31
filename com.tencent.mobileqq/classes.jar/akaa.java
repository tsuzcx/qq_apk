import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.webview.swift.component.SwiftPreloadCookieManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class akaa
  implements Runnable
{
  public akaa(List paramList, SwiftPreloadCookieManager paramSwiftPreloadCookieManager) {}
  
  public void run()
  {
    Set localSet = AuthorizeConfig.a().a("pskey");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!localSet.contains(str))
      {
        if (QLog.isColorLevel()) {
          QLog.i("SwiftBrowserCookieMonster", 2, str + " doesn't need pskey any more,so delete! ");
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftPreloadCookieManager.b(str, "p_skey");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akaa
 * JD-Core Version:    0.7.0.1
 */