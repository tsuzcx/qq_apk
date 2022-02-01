import android.app.Activity;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class akrh
  implements admy
{
  akrh(akrf paramakrf, String paramString) {}
  
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
    if ((akrf.a(this.jdField_a_of_type_Akrf).isFinishing()) || (this.jdField_a_of_type_Akrf.b)) {
      return;
    }
    this.jdField_a_of_type_Akrf.d();
    if (akrf.a(this.jdField_a_of_type_Akrf) != null) {
      akrf.a(this.jdField_a_of_type_Akrf).removeCallbacks(akrf.a(this.jdField_a_of_type_Akrf));
    }
    this.jdField_a_of_type_Akrf.a(anzj.a(2131712470), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if ((akrf.a(this.jdField_a_of_type_Akrf).isFinishing()) || (this.jdField_a_of_type_Akrf.b)) {
      return;
    }
    this.jdField_a_of_type_Akrf.d();
    if (akrf.a(this.jdField_a_of_type_Akrf) != null) {
      akrf.a(this.jdField_a_of_type_Akrf).removeCallbacks(akrf.a(this.jdField_a_of_type_Akrf));
    }
    this.jdField_a_of_type_Akrf.a(anzj.a(2131712474), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onSuccess");
    }
    if ((akrf.a(this.jdField_a_of_type_Akrf).isFinishing()) || (this.jdField_a_of_type_Akrf.b)) {
      return;
    }
    if (akrf.a(this.jdField_a_of_type_Akrf) != null) {
      akrf.a(this.jdField_a_of_type_Akrf).removeCallbacks(akrf.a(this.jdField_a_of_type_Akrf));
    }
    akrf.a(this.jdField_a_of_type_Akrf);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrh
 * JD-Core Version:    0.7.0.1
 */