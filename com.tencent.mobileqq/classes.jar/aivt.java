import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

final class aivt
  extends batl
{
  aivt(SharedPreferences paramSharedPreferences, int paramInt, aivr paramaivr) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkUpdateApolloWebViewConfig download file task.getStatus()->" + parambatm.a() + ", httpCode: " + parambatm.f);
    if (3 == parambatm.a())
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_apollo_webView_config_version", this.jdField_a_of_type_Int).commit();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig download version:" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Aivr != null) {
        aivr.a(this.jdField_a_of_type_Aivr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aivt
 * JD-Core Version:    0.7.0.1
 */