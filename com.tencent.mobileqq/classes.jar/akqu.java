import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;

class akqu
  implements Runnable
{
  akqu(akqt paramakqt, int paramInt) {}
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_Int == 202)
    {
      localObject = new String[2];
      localObject[0] = "https://qc.vip.qq.com/";
      localObject[1] = "http://m.gamecenter.qq.com";
      int j = localObject.length;
      while (i < j)
      {
        String str = localObject[i];
        SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = SwiftBrowserCookieMonster.a(str);
        if (localSwiftBrowserCookieMonster != null) {
          localSwiftBrowserCookieMonster.a(str, null, null, null);
        }
        i += 1;
      }
    }
    Object localObject = SwiftBrowserCookieMonster.a("http://zb.vip.qq.com/");
    if (localObject != null) {
      ((SwiftBrowserCookieMonster)localObject).a("http://zb.vip.qq.com/", null, null, null);
    }
    this.jdField_a_of_type_Akqt.jdField_a_of_type_AndroidOsBundle.putBoolean("_should_set_cookie_", true);
    this.jdField_a_of_type_Akqt.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftWebAccelerator.a(this.jdField_a_of_type_Akqt.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akqu
 * JD-Core Version:    0.7.0.1
 */