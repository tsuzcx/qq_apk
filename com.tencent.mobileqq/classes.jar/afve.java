import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class afve
  implements aabm
{
  afve(afur paramafur, String paramString) {}
  
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
    if ((afur.a(this.jdField_a_of_type_Afur).isFinishing()) || (this.jdField_a_of_type_Afur.b)) {
      return;
    }
    this.jdField_a_of_type_Afur.c();
    if (afur.a(this.jdField_a_of_type_Afur) != null) {
      afur.a(this.jdField_a_of_type_Afur).removeCallbacks(afur.a(this.jdField_a_of_type_Afur));
    }
    this.jdField_a_of_type_Afur.a(ajyc.a(2131713599), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if ((afur.a(this.jdField_a_of_type_Afur).isFinishing()) || (this.jdField_a_of_type_Afur.b)) {
      return;
    }
    this.jdField_a_of_type_Afur.c();
    if (afur.a(this.jdField_a_of_type_Afur) != null) {
      afur.a(this.jdField_a_of_type_Afur).removeCallbacks(afur.a(this.jdField_a_of_type_Afur));
    }
    this.jdField_a_of_type_Afur.a(ajyc.a(2131713600), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "check api, onSuccess");
    }
    if ((afur.a(this.jdField_a_of_type_Afur).isFinishing()) || (this.jdField_a_of_type_Afur.b)) {
      return;
    }
    if (afur.a(this.jdField_a_of_type_Afur) != null) {
      afur.a(this.jdField_a_of_type_Afur).removeCallbacks(afur.a(this.jdField_a_of_type_Afur));
    }
    afur.b(this.jdField_a_of_type_Afur);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afve
 * JD-Core Version:    0.7.0.1
 */