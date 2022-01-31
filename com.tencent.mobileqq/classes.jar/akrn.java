import android.net.Uri;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.CallBack;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;

public class akrn
  implements Runnable
{
  public akrn(WebSoService paramWebSoService, String paramString1, String paramString2, String paramString3, Uri paramUri, WebSoService.WebSoState paramWebSoState, boolean paramBoolean, WebSoService.CallBack paramCallBack) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService.a(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$CallBack == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$CallBack.a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akrn
 * JD-Core Version:    0.7.0.1
 */