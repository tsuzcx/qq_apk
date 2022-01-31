import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class aipk
  implements abwu
{
  aipk(QQAppInterface paramQQAppInterface, String paramString1, Activity paramActivity, String paramString2, String paramString3, String paramString4, Intent paramIntent) {}
  
  public void onComplete()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onComplete");
    }
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    }
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, this.jdField_a_of_type_JavaLangString, "2", "", "");
    aipi.a(this.jdField_a_of_type_AndroidAppActivity, alud.a(2131713987), this.b, this.c, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onSuccess");
    }
    if (aipi.a(this.d))
    {
      paramJSONObject = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("open_id");
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramJSONObject)))
      {
        OpenID localOpenID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString);
        if (localOpenID == null) {}
        while (paramJSONObject.equals(localOpenID.openID)) {
          try
          {
            long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            long l2 = System.currentTimeMillis();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1, paramJSONObject, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), new aipl(this, l2));
            return;
          }
          catch (Exception paramJSONObject)
          {
            QLog.e("SdkDynamicAvatarSettingHelper", 1, "checkOpenidDiff exception=", paramJSONObject);
            return;
          }
        }
        aipi.b(this.jdField_a_of_type_AndroidAppActivity);
        return;
      }
      QLog.e("SdkDynamicAvatarSettingHelper", 1, "checkOpenid, openId null");
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, this.jdField_a_of_type_JavaLangString, "3", "", "");
    aipi.a(this.jdField_a_of_type_AndroidAppActivity, alud.a(2131713991), this.b, this.c, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onTrigger(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipk
 * JD-Core Version:    0.7.0.1
 */