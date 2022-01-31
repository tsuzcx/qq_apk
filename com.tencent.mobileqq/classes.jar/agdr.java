import android.app.Activity;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class agdr
  implements zrt
{
  agdr(agdp paramagdp, String paramString) {}
  
  public void onComplete()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onComplete");
    }
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    }
    if ((agdp.a(this.jdField_a_of_type_Agdp).isFinishing()) || (this.jdField_a_of_type_Agdp.b)) {
      return;
    }
    this.jdField_a_of_type_Agdp.d();
    if (agdp.a(this.jdField_a_of_type_Agdp) != null) {
      agdp.a(this.jdField_a_of_type_Agdp).removeCallbacks(agdp.a(this.jdField_a_of_type_Agdp));
    }
    this.jdField_a_of_type_Agdp.a(ajjy.a(2131647800), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    if ((agdp.a(this.jdField_a_of_type_Agdp).isFinishing()) || (this.jdField_a_of_type_Agdp.b)) {
      return;
    }
    this.jdField_a_of_type_Agdp.d();
    if (agdp.a(this.jdField_a_of_type_Agdp) != null) {
      agdp.a(this.jdField_a_of_type_Agdp).removeCallbacks(agdp.a(this.jdField_a_of_type_Agdp));
    }
    this.jdField_a_of_type_Agdp.a(ajjy.a(2131647804), this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onSuccess");
    }
    if ((agdp.a(this.jdField_a_of_type_Agdp).isFinishing()) || (this.jdField_a_of_type_Agdp.b)) {
      return;
    }
    if (agdp.a(this.jdField_a_of_type_Agdp) != null) {
      agdp.a(this.jdField_a_of_type_Agdp).removeCallbacks(agdp.a(this.jdField_a_of_type_Agdp));
    }
    agdp.a(this.jdField_a_of_type_Agdp);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKAvatarSettingManager", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agdr
 * JD-Core Version:    0.7.0.1
 */