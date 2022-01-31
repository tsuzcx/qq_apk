import android.app.Activity;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class aipc
  implements abwu
{
  aipc(aipa paramaipa, String paramString) {}
  
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
    if ((aipa.a(this.jdField_a_of_type_Aipa).isFinishing()) || (this.jdField_a_of_type_Aipa.b)) {
      return;
    }
    this.jdField_a_of_type_Aipa.d();
    if (aipa.a(this.jdField_a_of_type_Aipa) != null) {
      aipa.a(this.jdField_a_of_type_Aipa).removeCallbacks(aipa.a(this.jdField_a_of_type_Aipa));
    }
    this.jdField_a_of_type_Aipa.a(alud.a(2131713982), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if ((aipa.a(this.jdField_a_of_type_Aipa).isFinishing()) || (this.jdField_a_of_type_Aipa.b)) {
      return;
    }
    this.jdField_a_of_type_Aipa.d();
    if (aipa.a(this.jdField_a_of_type_Aipa) != null) {
      aipa.a(this.jdField_a_of_type_Aipa).removeCallbacks(aipa.a(this.jdField_a_of_type_Aipa));
    }
    this.jdField_a_of_type_Aipa.a(alud.a(2131713986), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onSuccess");
    }
    if ((aipa.a(this.jdField_a_of_type_Aipa).isFinishing()) || (this.jdField_a_of_type_Aipa.b)) {
      return;
    }
    if (aipa.a(this.jdField_a_of_type_Aipa) != null) {
      aipa.a(this.jdField_a_of_type_Aipa).removeCallbacks(aipa.a(this.jdField_a_of_type_Aipa));
    }
    aipa.a(this.jdField_a_of_type_Aipa);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipc
 * JD-Core Version:    0.7.0.1
 */