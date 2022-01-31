import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

final class ajjt
  extends bbwt
{
  ajjt(SharedPreferences paramSharedPreferences, int paramInt, ajjr paramajjr) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkUpdateApolloWebViewConfig download file task.getStatus()->" + parambbwu.a() + ", httpCode: " + parambbwu.f);
    if (3 == parambbwu.a())
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_apollo_webView_config_version", this.jdField_a_of_type_Int).commit();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig download version:" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Ajjr != null) {
        ajjr.a(this.jdField_a_of_type_Ajjr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajjt
 * JD-Core Version:    0.7.0.1
 */