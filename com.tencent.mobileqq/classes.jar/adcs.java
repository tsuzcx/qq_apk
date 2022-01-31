import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

class adcs
  implements wxt
{
  adcs(adcr paramadcr) {}
  
  public void a(Bundle paramBundle)
  {
    boolean bool;
    if (paramBundle.getInt("type") == 73)
    {
      bool = paramBundle.getBoolean("isSuccess");
      if ((!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (!this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.i)) {}
    }
    else
    {
      return;
    }
    if (Boolean.valueOf(bool).booleanValue())
    {
      bcql.a(BaseApplicationImpl.getApplication(), 2, 2131720410, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b());
      return;
    }
    bcql.a(BaseApplicationImpl.getApplication(), 1, 2131720407, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adcs
 * JD-Core Version:    0.7.0.1
 */