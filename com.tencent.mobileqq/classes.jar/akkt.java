import android.app.Activity;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class akkt
  implements adaa
{
  akkt(akkr paramakkr, String paramString) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onComplete");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if ((akkr.a(this.jdField_a_of_type_Akkr).isFinishing()) || (this.jdField_a_of_type_Akkr.b)) {
      return;
    }
    this.jdField_a_of_type_Akkr.d();
    if (akkr.a(this.jdField_a_of_type_Akkr) != null) {
      akkr.a(this.jdField_a_of_type_Akkr).removeCallbacks(akkr.a(this.jdField_a_of_type_Akkr));
    }
    this.jdField_a_of_type_Akkr.a(anvx.a(2131713053), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    }
    if ((akkr.a(this.jdField_a_of_type_Akkr).isFinishing()) || (this.jdField_a_of_type_Akkr.b)) {
      return;
    }
    this.jdField_a_of_type_Akkr.d();
    if (akkr.a(this.jdField_a_of_type_Akkr) != null) {
      akkr.a(this.jdField_a_of_type_Akkr).removeCallbacks(akkr.a(this.jdField_a_of_type_Akkr));
    }
    this.jdField_a_of_type_Akkr.a(anvx.a(2131713049), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onSuccess");
    }
    if ((akkr.a(this.jdField_a_of_type_Akkr).isFinishing()) || (this.jdField_a_of_type_Akkr.b)) {
      return;
    }
    if (akkr.a(this.jdField_a_of_type_Akkr) != null) {
      akkr.a(this.jdField_a_of_type_Akkr).removeCallbacks(akkr.a(this.jdField_a_of_type_Akkr));
    }
    akkr.a(this.jdField_a_of_type_Akkr);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkt
 * JD-Core Version:    0.7.0.1
 */