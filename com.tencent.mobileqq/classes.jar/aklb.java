import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class aklb
  implements adaa
{
  aklb(QQAppInterface paramQQAppInterface, String paramString1, Activity paramActivity, String paramString2, String paramString3, String paramString4, Intent paramIntent) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onComplete");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, new Object[] { "check api, onPermission, code=", Integer.valueOf(paramInt) });
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, this.jdField_a_of_type_JavaLangString, "2", "", "");
    akkz.a(this.jdField_a_of_type_AndroidAppActivity, anvx.a(2131713054), this.b, this.c, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, new Object[] { "check api, onFailure, code=", Integer.valueOf(paramInt), ", msg=", paramString });
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onSuccess");
    }
    if (akkz.a(this.d))
    {
      paramJSONObject = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("open_id");
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramJSONObject)))
      {
        OpenID localOpenID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(this.jdField_a_of_type_JavaLangString);
        if (localOpenID == null) {}
        while (paramJSONObject.equals(localOpenID.openID)) {
          try
          {
            long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            long l2 = System.currentTimeMillis();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(l1, paramJSONObject, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), new aklc(this, l2));
            return;
          }
          catch (Exception paramJSONObject)
          {
            QLog.e("SdkDynamicAvatarSettingHelper", 1, "checkOpenidDiff exception=", paramJSONObject);
            return;
          }
        }
        akkz.b(this.jdField_a_of_type_AndroidAppActivity);
        return;
      }
      QLog.e("SdkDynamicAvatarSettingHelper", 1, "checkOpenid, openId null");
      return;
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, this.jdField_a_of_type_JavaLangString, "3", "", "");
    akkz.a(this.jdField_a_of_type_AndroidAppActivity, anvx.a(2131713058), this.b, this.c, this.jdField_a_of_type_JavaLangString);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "check api, onTrigger");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aklb
 * JD-Core Version:    0.7.0.1
 */