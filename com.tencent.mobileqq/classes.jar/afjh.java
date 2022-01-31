import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class afjh
  implements zrt
{
  afjh(afiu paramafiu, String paramString) {}
  
  public void onComplete()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "check api, onComplete");
    }
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    }
    if ((afiu.a(this.jdField_a_of_type_Afiu).isFinishing()) || (this.jdField_a_of_type_Afiu.b)) {
      return;
    }
    this.jdField_a_of_type_Afiu.c();
    if (afiu.a(this.jdField_a_of_type_Afiu) != null) {
      afiu.a(this.jdField_a_of_type_Afiu).removeCallbacks(afiu.a(this.jdField_a_of_type_Afiu));
    }
    this.jdField_a_of_type_Afiu.a(ajjy.a(2131647812), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if ((afiu.a(this.jdField_a_of_type_Afiu).isFinishing()) || (this.jdField_a_of_type_Afiu.b)) {
      return;
    }
    this.jdField_a_of_type_Afiu.c();
    if (afiu.a(this.jdField_a_of_type_Afiu) != null) {
      afiu.a(this.jdField_a_of_type_Afiu).removeCallbacks(afiu.a(this.jdField_a_of_type_Afiu));
    }
    this.jdField_a_of_type_Afiu.a(ajjy.a(2131647813), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "check api, onSuccess");
    }
    if ((afiu.a(this.jdField_a_of_type_Afiu).isFinishing()) || (this.jdField_a_of_type_Afiu.b)) {
      return;
    }
    if (afiu.a(this.jdField_a_of_type_Afiu) != null) {
      afiu.a(this.jdField_a_of_type_Afiu).removeCallbacks(afiu.a(this.jdField_a_of_type_Afiu));
    }
    afiu.b(this.jdField_a_of_type_Afiu);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afjh
 * JD-Core Version:    0.7.0.1
 */