import android.app.Activity;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class akfw
  implements adea
{
  akfw(akfu paramakfu, String paramString) {}
  
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
    if ((akfu.a(this.jdField_a_of_type_Akfu).isFinishing()) || (this.jdField_a_of_type_Akfu.b)) {
      return;
    }
    this.jdField_a_of_type_Akfu.d();
    if (akfu.a(this.jdField_a_of_type_Akfu) != null) {
      akfu.a(this.jdField_a_of_type_Akfu).removeCallbacks(akfu.a(this.jdField_a_of_type_Akfu));
    }
    this.jdField_a_of_type_Akfu.a(anni.a(2131712361), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if ((akfu.a(this.jdField_a_of_type_Akfu).isFinishing()) || (this.jdField_a_of_type_Akfu.b)) {
      return;
    }
    this.jdField_a_of_type_Akfu.d();
    if (akfu.a(this.jdField_a_of_type_Akfu) != null) {
      akfu.a(this.jdField_a_of_type_Akfu).removeCallbacks(akfu.a(this.jdField_a_of_type_Akfu));
    }
    this.jdField_a_of_type_Akfu.a(anni.a(2131712365), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onSuccess");
    }
    if ((akfu.a(this.jdField_a_of_type_Akfu).isFinishing()) || (this.jdField_a_of_type_Akfu.b)) {
      return;
    }
    if (akfu.a(this.jdField_a_of_type_Akfu) != null) {
      akfu.a(this.jdField_a_of_type_Akfu).removeCallbacks(akfu.a(this.jdField_a_of_type_Akfu));
    }
    akfu.a(this.jdField_a_of_type_Akfu);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfw
 * JD-Core Version:    0.7.0.1
 */