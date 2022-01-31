import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

final class ajjv
  extends bbwf
{
  ajjv(SharedPreferences paramSharedPreferences, int paramInt, ajjt paramajjt) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkUpdateApolloWebViewConfig download file task.getStatus()->" + parambbwg.a() + ", httpCode: " + parambbwg.f);
    if (3 == parambbwg.a())
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_apollo_webView_config_version", this.jdField_a_of_type_Int).commit();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig download version:" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Ajjt != null) {
        ajjt.a(this.jdField_a_of_type_Ajjt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajjv
 * JD-Core Version:    0.7.0.1
 */