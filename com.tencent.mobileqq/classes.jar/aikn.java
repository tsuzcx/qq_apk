import android.app.Activity;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class aikn
  implements absf
{
  aikn(aikl paramaikl, String paramString) {}
  
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
    if ((aikl.a(this.jdField_a_of_type_Aikl).isFinishing()) || (this.jdField_a_of_type_Aikl.b)) {
      return;
    }
    this.jdField_a_of_type_Aikl.d();
    if (aikl.a(this.jdField_a_of_type_Aikl) != null) {
      aikl.a(this.jdField_a_of_type_Aikl).removeCallbacks(aikl.a(this.jdField_a_of_type_Aikl));
    }
    this.jdField_a_of_type_Aikl.a(alpo.a(2131713970), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if ((aikl.a(this.jdField_a_of_type_Aikl).isFinishing()) || (this.jdField_a_of_type_Aikl.b)) {
      return;
    }
    this.jdField_a_of_type_Aikl.d();
    if (aikl.a(this.jdField_a_of_type_Aikl) != null) {
      aikl.a(this.jdField_a_of_type_Aikl).removeCallbacks(aikl.a(this.jdField_a_of_type_Aikl));
    }
    this.jdField_a_of_type_Aikl.a(alpo.a(2131713974), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onSuccess");
    }
    if ((aikl.a(this.jdField_a_of_type_Aikl).isFinishing()) || (this.jdField_a_of_type_Aikl.b)) {
      return;
    }
    if (aikl.a(this.jdField_a_of_type_Aikl) != null) {
      aikl.a(this.jdField_a_of_type_Aikl).removeCallbacks(aikl.a(this.jdField_a_of_type_Aikl));
    }
    aikl.a(this.jdField_a_of_type_Aikl);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikn
 * JD-Core Version:    0.7.0.1
 */