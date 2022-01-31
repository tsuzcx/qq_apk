import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class acke
  implements BusinessObserver
{
  public acke(ChatSettingActivity paramChatSettingActivity, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          Object localObject = new WebSsoBody.WebSsoResponseBody();
          ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
          paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
          localObject = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
          if (paramInt != 0)
          {
            paramBundle = ((JSONObject)localObject).optString("msg");
            if ((!TextUtils.isEmpty(paramBundle)) && (QLog.isColorLevel()))
            {
              QLog.d(ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity) + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + ChatSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity) + ", op:" + this.jdField_a_of_type_JavaLangString + ", errMsg:" + paramBundle);
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, 1, paramBundle, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.getTitleBarHeight());
            }
          }
          else
          {
            paramBundle = ((JSONObject)localObject).getJSONObject("result");
            if (((JSONObject)localObject).optInt("retcode") == 0)
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_Boolean) {
                break label648;
              }
              paramBoolean = true;
              ((ChatSettingActivity)localObject).jdField_a_of_type_Boolean = paramBoolean;
              ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_Boolean)
              {
                ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, false);
                ((atvt)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.app.getManager(16)).a(0, 1, ChatSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
                ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity).setOnCheckedChangeListener(null);
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_JavaLangString, 2, "sendOperateFollowUser, mIsShield=" + ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity) + ", mIsFollowed=" + this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_Boolean);
                }
                ChatSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
                ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity).setOnCheckedChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
              }
              localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
              ChatSettingActivity localChatSettingActivity = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
              if (!this.jdField_a_of_type_JavaLangString.equals("1")) {
                break label653;
              }
              paramInt = 2131694691;
              label390:
              QQToast.a((Context)localObject, 2, localChatSettingActivity.getString(paramInt), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.getTitleBarHeight());
              if (!QLog.isColorLevel()) {
                return;
              }
              QLog.d(ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity) + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + ChatSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity) + ", op:" + this.jdField_a_of_type_JavaLangString + ", result:" + paramBundle.toString());
              return;
            }
          }
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.d(ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity), 2, "sendOperateFollowUser, Exception");
        }
      }
    }
    else
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
      if (!this.jdField_a_of_type_JavaLangString.equals("1")) {
        break label659;
      }
    }
    label648:
    label653:
    label659:
    for (paramInt = 2131694690;; paramInt = 2131694703)
    {
      paramBundle = paramBundle.getString(paramInt);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, 1, paramBundle, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.getTitleBarHeight());
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d(ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity) + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + ChatSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity) + ", op:" + this.jdField_a_of_type_JavaLangString + ", re:" + paramBundle);
      return;
      paramBoolean = false;
      break;
      paramInt = 2131694704;
      break label390;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acke
 * JD-Core Version:    0.7.0.1
 */