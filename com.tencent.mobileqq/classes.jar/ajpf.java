import android.app.Activity;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ajpf
  implements acjr
{
  ajpf(ajpd paramajpd, String paramString) {}
  
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
    if ((ajpd.a(this.jdField_a_of_type_Ajpd).isFinishing()) || (this.jdField_a_of_type_Ajpd.b)) {
      return;
    }
    this.jdField_a_of_type_Ajpd.d();
    if (ajpd.a(this.jdField_a_of_type_Ajpd) != null) {
      ajpd.a(this.jdField_a_of_type_Ajpd).removeCallbacks(ajpd.a(this.jdField_a_of_type_Ajpd));
    }
    this.jdField_a_of_type_Ajpd.a(amtj.a(2131712702), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if ((ajpd.a(this.jdField_a_of_type_Ajpd).isFinishing()) || (this.jdField_a_of_type_Ajpd.b)) {
      return;
    }
    this.jdField_a_of_type_Ajpd.d();
    if (ajpd.a(this.jdField_a_of_type_Ajpd) != null) {
      ajpd.a(this.jdField_a_of_type_Ajpd).removeCallbacks(ajpd.a(this.jdField_a_of_type_Ajpd));
    }
    this.jdField_a_of_type_Ajpd.a(amtj.a(2131712706), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onSuccess");
    }
    if ((ajpd.a(this.jdField_a_of_type_Ajpd).isFinishing()) || (this.jdField_a_of_type_Ajpd.b)) {
      return;
    }
    if (ajpd.a(this.jdField_a_of_type_Ajpd) != null) {
      ajpd.a(this.jdField_a_of_type_Ajpd).removeCallbacks(ajpd.a(this.jdField_a_of_type_Ajpd));
    }
    ajpd.a(this.jdField_a_of_type_Ajpd);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpf
 * JD-Core Version:    0.7.0.1
 */