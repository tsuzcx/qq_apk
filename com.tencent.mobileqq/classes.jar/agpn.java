import android.app.Activity;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class agpn
  implements aabi
{
  agpn(agpl paramagpl, String paramString) {}
  
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
    if ((agpl.a(this.jdField_a_of_type_Agpl).isFinishing()) || (this.jdField_a_of_type_Agpl.b)) {
      return;
    }
    this.jdField_a_of_type_Agpl.d();
    if (agpl.a(this.jdField_a_of_type_Agpl) != null) {
      agpl.a(this.jdField_a_of_type_Agpl).removeCallbacks(agpl.a(this.jdField_a_of_type_Agpl));
    }
    this.jdField_a_of_type_Agpl.a(ajya.a(2131713598), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if ((agpl.a(this.jdField_a_of_type_Agpl).isFinishing()) || (this.jdField_a_of_type_Agpl.b)) {
      return;
    }
    this.jdField_a_of_type_Agpl.d();
    if (agpl.a(this.jdField_a_of_type_Agpl) != null) {
      agpl.a(this.jdField_a_of_type_Agpl).removeCallbacks(agpl.a(this.jdField_a_of_type_Agpl));
    }
    this.jdField_a_of_type_Agpl.a(ajya.a(2131713602), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onSuccess");
    }
    if ((agpl.a(this.jdField_a_of_type_Agpl).isFinishing()) || (this.jdField_a_of_type_Agpl.b)) {
      return;
    }
    if (agpl.a(this.jdField_a_of_type_Agpl) != null) {
      agpl.a(this.jdField_a_of_type_Agpl).removeCallbacks(agpl.a(this.jdField_a_of_type_Agpl));
    }
    agpl.a(this.jdField_a_of_type_Agpl);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agpn
 * JD-Core Version:    0.7.0.1
 */