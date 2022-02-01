import android.text.TextUtils;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState.WebSo3;

class aath
{
  private WebSoService.WebSoState.WebSo3 jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3;
  private String jdField_a_of_type_JavaLangString;
  
  private void a(aatf paramaatf, String paramString, WebSoService.WebSoState.WebSo3 paramWebSo3)
  {
    if ((paramWebSo3 != null) && (!TextUtils.isEmpty(paramString))) {
      bijv.a("callJs");
    }
    try
    {
      paramaatf.callJs(paramString, new String[] { this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.a() });
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    catch (Exception paramaatf)
    {
      for (;;)
      {
        paramaatf.printStackTrace();
      }
    }
  }
  
  public WebSoService.WebSoState.WebSo3 a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3;
  }
  
  public void a()
  {
    bijv.a("clearJsCallback");
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3 = null;
  }
  
  public void a(aatf paramaatf, WebSoService.WebSoState.WebSo3 paramWebSo3)
  {
    bijv.a("setUpWebso3");
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3 = paramWebSo3;
    a(paramaatf, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3);
  }
  
  public void a(aatf paramaatf, String paramString)
  {
    bijv.a("registerGetData");
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramaatf, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aath
 * JD-Core Version:    0.7.0.1
 */