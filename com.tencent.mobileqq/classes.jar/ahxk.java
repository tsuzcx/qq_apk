import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class ahxk
  implements abwu
{
  ahxk(ahww paramahww, String paramString) {}
  
  public void onComplete()
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onComplete");
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    if ((ahww.a(this.jdField_a_of_type_Ahww).isFinishing()) || (this.jdField_a_of_type_Ahww.b))
    {
      QLog.d("SDKEmotionSettingManager", 1, "check api, acitivty finish or timeout");
      return;
    }
    this.jdField_a_of_type_Ahww.c();
    if (ahww.a(this.jdField_a_of_type_Ahww) != null) {
      ahww.a(this.jdField_a_of_type_Ahww).removeCallbacks(ahww.a(this.jdField_a_of_type_Ahww));
    }
    this.jdField_a_of_type_Ahww.a(alud.a(2131713994), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    if ((ahww.a(this.jdField_a_of_type_Ahww).isFinishing()) || (this.jdField_a_of_type_Ahww.b)) {
      return;
    }
    this.jdField_a_of_type_Ahww.c();
    if (ahww.a(this.jdField_a_of_type_Ahww) != null) {
      ahww.a(this.jdField_a_of_type_Ahww).removeCallbacks(ahww.a(this.jdField_a_of_type_Ahww));
    }
    this.jdField_a_of_type_Ahww.a(alud.a(2131713995), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onSuccess");
    if ((ahww.a(this.jdField_a_of_type_Ahww).isFinishing()) || (this.jdField_a_of_type_Ahww.b)) {
      return;
    }
    if (ahww.a(this.jdField_a_of_type_Ahww) != null) {
      ahww.a(this.jdField_a_of_type_Ahww).removeCallbacks(ahww.a(this.jdField_a_of_type_Ahww));
    }
    ahww.b(this.jdField_a_of_type_Ahww);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onTrigger");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxk
 * JD-Core Version:    0.7.0.1
 */