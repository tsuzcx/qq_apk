import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.webso.HttpResponsePackage;
import com.tencent.mobileqq.webview.webso.SHA1Util;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import mqq.app.AppRuntime;

public class akyw
  implements Runnable
{
  public akyw(WebSoService paramWebSoService, HttpResponsePackage paramHttpResponsePackage, Uri paramUri, String paramString, WebSoService.WebSoState paramWebSoState) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHttpResponsePackage != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHttpResponsePackage.d != null)
      {
        WebSoUtils.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHttpResponsePackage.d.getBytes(), WebSoUtils.b(this.jdField_a_of_type_AndroidNetUri));
        localObject1 = SHA1Util.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHttpResponsePackage.d);
      }
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidNetUri != null))
    {
      localObject2 = WebSoService.a().edit();
      String str1 = String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      String str2 = WebSoUtils.a(this.jdField_a_of_type_AndroidNetUri);
      ((SharedPreferences.Editor)localObject2).putString("eTag_" + str1 + str2, this.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject2).putString("htmlSha1_" + str1 + str2, (String)localObject1);
      if (Build.VERSION.SDK_INT >= 9) {
        break label217;
      }
      ((SharedPreferences.Editor)localObject2).commit();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.a.d = ((int)(System.currentTimeMillis() - l));
      return;
      label217:
      ((SharedPreferences.Editor)localObject2).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akyw
 * JD-Core Version:    0.7.0.1
 */