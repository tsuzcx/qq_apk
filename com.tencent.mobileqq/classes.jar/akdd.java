import android.text.TextUtils;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.CallBack;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;

public class akdd
  implements WebSoService.CallBack
{
  public akdd(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState, long paramLong) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_a_of_type_Int = 10004;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.e = false;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.b = paramString;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.f = false;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.d = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akdd
 * JD-Core Version:    0.7.0.1
 */