import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

final class alfu
  extends bead
{
  alfu(SharedPreferences paramSharedPreferences, int paramInt, alfs paramalfs) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkUpdateApolloWebViewConfig download file task.getStatus()->" + parambeae.a() + ", httpCode: " + parambeae.f);
    if (3 == parambeae.a())
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_apollo_webView_config_version", this.jdField_a_of_type_Int).commit();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig download version:" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Alfs != null) {
        alfs.a(this.jdField_a_of_type_Alfs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfu
 * JD-Core Version:    0.7.0.1
 */