import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class ajpw
  implements adaa
{
  ajpw(ajpi paramajpi, String paramString) {}
  
  public void a()
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onComplete");
  }
  
  public void a(int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    if ((ajpi.a(this.jdField_a_of_type_Ajpi).isFinishing()) || (this.jdField_a_of_type_Ajpi.b)) {
      return;
    }
    this.jdField_a_of_type_Ajpi.c();
    if (ajpi.a(this.jdField_a_of_type_Ajpi) != null) {
      ajpi.a(this.jdField_a_of_type_Ajpi).removeCallbacks(ajpi.a(this.jdField_a_of_type_Ajpi));
    }
    this.jdField_a_of_type_Ajpi.a(anvx.a(2131713062), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    if ((ajpi.a(this.jdField_a_of_type_Ajpi).isFinishing()) || (this.jdField_a_of_type_Ajpi.b))
    {
      QLog.d("SDKEmotionSettingManager", 1, "check api, acitivty finish or timeout");
      return;
    }
    this.jdField_a_of_type_Ajpi.c();
    if (ajpi.a(this.jdField_a_of_type_Ajpi) != null) {
      ajpi.a(this.jdField_a_of_type_Ajpi).removeCallbacks(ajpi.a(this.jdField_a_of_type_Ajpi));
    }
    this.jdField_a_of_type_Ajpi.a(anvx.a(2131713061), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onSuccess");
    if ((ajpi.a(this.jdField_a_of_type_Ajpi).isFinishing()) || (this.jdField_a_of_type_Ajpi.b)) {
      return;
    }
    if (ajpi.a(this.jdField_a_of_type_Ajpi) != null) {
      ajpi.a(this.jdField_a_of_type_Ajpi).removeCallbacks(ajpi.a(this.jdField_a_of_type_Ajpi));
    }
    ajpi.b(this.jdField_a_of_type_Ajpi);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    QLog.d("SDKEmotionSettingManager", 1, "check api, onTrigger");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpw
 * JD-Core Version:    0.7.0.1
 */