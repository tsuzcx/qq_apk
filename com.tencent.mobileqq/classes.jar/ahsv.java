import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class ahsv
  implements absf
{
  ahsv(ahsh paramahsh, String paramString) {}
  
  public void onComplete()
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onComplete");
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    if ((ahsh.a(this.jdField_a_of_type_Ahsh).isFinishing()) || (this.jdField_a_of_type_Ahsh.b))
    {
      QLog.d("SDKEmotionSettingManager", 1, "check api, acitivty finish or timeout");
      return;
    }
    this.jdField_a_of_type_Ahsh.c();
    if (ahsh.a(this.jdField_a_of_type_Ahsh) != null) {
      ahsh.a(this.jdField_a_of_type_Ahsh).removeCallbacks(ahsh.a(this.jdField_a_of_type_Ahsh));
    }
    this.jdField_a_of_type_Ahsh.a(alpo.a(2131713982), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    if ((ahsh.a(this.jdField_a_of_type_Ahsh).isFinishing()) || (this.jdField_a_of_type_Ahsh.b)) {
      return;
    }
    this.jdField_a_of_type_Ahsh.c();
    if (ahsh.a(this.jdField_a_of_type_Ahsh) != null) {
      ahsh.a(this.jdField_a_of_type_Ahsh).removeCallbacks(ahsh.a(this.jdField_a_of_type_Ahsh));
    }
    this.jdField_a_of_type_Ahsh.a(alpo.a(2131713983), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onSuccess");
    if ((ahsh.a(this.jdField_a_of_type_Ahsh).isFinishing()) || (this.jdField_a_of_type_Ahsh.b)) {
      return;
    }
    if (ahsh.a(this.jdField_a_of_type_Ahsh) != null) {
      ahsh.a(this.jdField_a_of_type_Ahsh).removeCallbacks(ahsh.a(this.jdField_a_of_type_Ahsh));
    }
    ahsh.b(this.jdField_a_of_type_Ahsh);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onTrigger");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsv
 * JD-Core Version:    0.7.0.1
 */