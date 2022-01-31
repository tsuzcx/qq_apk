import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;
import com.tencent.mobileqq.webview.webso.WebSoUtils;

public class akri
  implements Runnable
{
  public akri(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState, String paramString, Handler paramHandler) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_JavaLangString = WebSoUtils.c(this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.f = true;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_Boolean = true;
    WebSoService.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akri
 * JD-Core Version:    0.7.0.1
 */