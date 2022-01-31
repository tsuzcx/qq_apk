import android.app.Activity;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class agpp
  implements aabm
{
  agpp(agpn paramagpn, String paramString) {}
  
  public void onComplete()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onComplete");
    }
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    }
    if ((agpn.a(this.jdField_a_of_type_Agpn).isFinishing()) || (this.jdField_a_of_type_Agpn.b)) {
      return;
    }
    this.jdField_a_of_type_Agpn.d();
    if (agpn.a(this.jdField_a_of_type_Agpn) != null) {
      agpn.a(this.jdField_a_of_type_Agpn).removeCallbacks(agpn.a(this.jdField_a_of_type_Agpn));
    }
    this.jdField_a_of_type_Agpn.a(ajyc.a(2131713587), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if ((agpn.a(this.jdField_a_of_type_Agpn).isFinishing()) || (this.jdField_a_of_type_Agpn.b)) {
      return;
    }
    this.jdField_a_of_type_Agpn.d();
    if (agpn.a(this.jdField_a_of_type_Agpn) != null) {
      agpn.a(this.jdField_a_of_type_Agpn).removeCallbacks(agpn.a(this.jdField_a_of_type_Agpn));
    }
    this.jdField_a_of_type_Agpn.a(ajyc.a(2131713591), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onSuccess");
    }
    if ((agpn.a(this.jdField_a_of_type_Agpn).isFinishing()) || (this.jdField_a_of_type_Agpn.b)) {
      return;
    }
    if (agpn.a(this.jdField_a_of_type_Agpn) != null) {
      agpn.a(this.jdField_a_of_type_Agpn).removeCallbacks(agpn.a(this.jdField_a_of_type_Agpn));
    }
    agpn.a(this.jdField_a_of_type_Agpn);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agpp
 * JD-Core Version:    0.7.0.1
 */