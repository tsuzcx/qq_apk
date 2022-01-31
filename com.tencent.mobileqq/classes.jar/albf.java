import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

final class albf
  extends bdvu
{
  albf(SharedPreferences paramSharedPreferences, int paramInt, albd paramalbd) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkUpdateApolloWebViewConfig download file task.getStatus()->" + parambdvv.a() + ", httpCode: " + parambdvv.f);
    if (3 == parambdvv.a())
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_apollo_webView_config_version", this.jdField_a_of_type_Int).commit();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig download version:" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Albd != null) {
        albd.a(this.jdField_a_of_type_Albd);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albf
 * JD-Core Version:    0.7.0.1
 */