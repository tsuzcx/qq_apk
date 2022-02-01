import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class ajny
  implements adea
{
  ajny(ajnk paramajnk, String paramString) {}
  
  public void onComplete()
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onComplete");
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    if ((ajnk.a(this.jdField_a_of_type_Ajnk).isFinishing()) || (this.jdField_a_of_type_Ajnk.b))
    {
      QLog.d("SDKEmotionSettingManager", 1, "check api, acitivty finish or timeout");
      return;
    }
    this.jdField_a_of_type_Ajnk.c();
    if (ajnk.a(this.jdField_a_of_type_Ajnk) != null) {
      ajnk.a(this.jdField_a_of_type_Ajnk).removeCallbacks(ajnk.a(this.jdField_a_of_type_Ajnk));
    }
    this.jdField_a_of_type_Ajnk.a(anni.a(2131712373), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    if ((ajnk.a(this.jdField_a_of_type_Ajnk).isFinishing()) || (this.jdField_a_of_type_Ajnk.b)) {
      return;
    }
    this.jdField_a_of_type_Ajnk.c();
    if (ajnk.a(this.jdField_a_of_type_Ajnk) != null) {
      ajnk.a(this.jdField_a_of_type_Ajnk).removeCallbacks(ajnk.a(this.jdField_a_of_type_Ajnk));
    }
    this.jdField_a_of_type_Ajnk.a(anni.a(2131712374), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onSuccess");
    if ((ajnk.a(this.jdField_a_of_type_Ajnk).isFinishing()) || (this.jdField_a_of_type_Ajnk.b)) {
      return;
    }
    if (ajnk.a(this.jdField_a_of_type_Ajnk) != null) {
      ajnk.a(this.jdField_a_of_type_Ajnk).removeCallbacks(ajnk.a(this.jdField_a_of_type_Ajnk));
    }
    ajnk.b(this.jdField_a_of_type_Ajnk);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onTrigger");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajny
 * JD-Core Version:    0.7.0.1
 */