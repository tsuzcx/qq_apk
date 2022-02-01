import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class ajzh
  implements admy
{
  ajzh(ajyt paramajyt, String paramString) {}
  
  public void onComplete()
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onComplete");
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    if ((ajyt.a(this.jdField_a_of_type_Ajyt).isFinishing()) || (this.jdField_a_of_type_Ajyt.b))
    {
      QLog.d("SDKEmotionSettingManager", 1, "check api, acitivty finish or timeout");
      return;
    }
    this.jdField_a_of_type_Ajyt.c();
    if (ajyt.a(this.jdField_a_of_type_Ajyt) != null) {
      ajyt.a(this.jdField_a_of_type_Ajyt).removeCallbacks(ajyt.a(this.jdField_a_of_type_Ajyt));
    }
    this.jdField_a_of_type_Ajyt.a(anzj.a(2131712482), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    if ((ajyt.a(this.jdField_a_of_type_Ajyt).isFinishing()) || (this.jdField_a_of_type_Ajyt.b)) {
      return;
    }
    this.jdField_a_of_type_Ajyt.c();
    if (ajyt.a(this.jdField_a_of_type_Ajyt) != null) {
      ajyt.a(this.jdField_a_of_type_Ajyt).removeCallbacks(ajyt.a(this.jdField_a_of_type_Ajyt));
    }
    this.jdField_a_of_type_Ajyt.a(anzj.a(2131712483), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onSuccess");
    if ((ajyt.a(this.jdField_a_of_type_Ajyt).isFinishing()) || (this.jdField_a_of_type_Ajyt.b)) {
      return;
    }
    if (ajyt.a(this.jdField_a_of_type_Ajyt) != null) {
      ajyt.a(this.jdField_a_of_type_Ajyt).removeCallbacks(ajyt.a(this.jdField_a_of_type_Ajyt));
    }
    ajyt.b(this.jdField_a_of_type_Ajyt);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onTrigger");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzh
 * JD-Core Version:    0.7.0.1
 */