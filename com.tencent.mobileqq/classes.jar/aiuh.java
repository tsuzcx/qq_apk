import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class aiuh
  implements acjr
{
  aiuh(aitt paramaitt, String paramString) {}
  
  public void onComplete()
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onComplete");
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    if ((aitt.a(this.jdField_a_of_type_Aitt).isFinishing()) || (this.jdField_a_of_type_Aitt.b))
    {
      QLog.d("SDKEmotionSettingManager", 1, "check api, acitivty finish or timeout");
      return;
    }
    this.jdField_a_of_type_Aitt.c();
    if (aitt.a(this.jdField_a_of_type_Aitt) != null) {
      aitt.a(this.jdField_a_of_type_Aitt).removeCallbacks(aitt.a(this.jdField_a_of_type_Aitt));
    }
    this.jdField_a_of_type_Aitt.a(amtj.a(2131712714), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    if ((aitt.a(this.jdField_a_of_type_Aitt).isFinishing()) || (this.jdField_a_of_type_Aitt.b)) {
      return;
    }
    this.jdField_a_of_type_Aitt.c();
    if (aitt.a(this.jdField_a_of_type_Aitt) != null) {
      aitt.a(this.jdField_a_of_type_Aitt).removeCallbacks(aitt.a(this.jdField_a_of_type_Aitt));
    }
    this.jdField_a_of_type_Aitt.a(amtj.a(2131712715), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onSuccess");
    if ((aitt.a(this.jdField_a_of_type_Aitt).isFinishing()) || (this.jdField_a_of_type_Aitt.b)) {
      return;
    }
    if (aitt.a(this.jdField_a_of_type_Aitt) != null) {
      aitt.a(this.jdField_a_of_type_Aitt).removeCallbacks(aitt.a(this.jdField_a_of_type_Aitt));
    }
    aitt.b(this.jdField_a_of_type_Aitt);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onTrigger");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiuh
 * JD-Core Version:    0.7.0.1
 */