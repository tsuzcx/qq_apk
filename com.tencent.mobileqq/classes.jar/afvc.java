import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class afvc
  implements aabi
{
  afvc(afup paramafup, String paramString) {}
  
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
    if ((afup.a(this.jdField_a_of_type_Afup).isFinishing()) || (this.jdField_a_of_type_Afup.b)) {
      return;
    }
    this.jdField_a_of_type_Afup.c();
    if (afup.a(this.jdField_a_of_type_Afup) != null) {
      afup.a(this.jdField_a_of_type_Afup).removeCallbacks(afup.a(this.jdField_a_of_type_Afup));
    }
    this.jdField_a_of_type_Afup.a(ajya.a(2131713610), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if ((afup.a(this.jdField_a_of_type_Afup).isFinishing()) || (this.jdField_a_of_type_Afup.b)) {
      return;
    }
    this.jdField_a_of_type_Afup.c();
    if (afup.a(this.jdField_a_of_type_Afup) != null) {
      afup.a(this.jdField_a_of_type_Afup).removeCallbacks(afup.a(this.jdField_a_of_type_Afup));
    }
    this.jdField_a_of_type_Afup.a(ajya.a(2131713611), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "check api, onSuccess");
    }
    if ((afup.a(this.jdField_a_of_type_Afup).isFinishing()) || (this.jdField_a_of_type_Afup.b)) {
      return;
    }
    if (afup.a(this.jdField_a_of_type_Afup) != null) {
      afup.a(this.jdField_a_of_type_Afup).removeCallbacks(afup.a(this.jdField_a_of_type_Afup));
    }
    afup.b(this.jdField_a_of_type_Afup);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvc
 * JD-Core Version:    0.7.0.1
 */