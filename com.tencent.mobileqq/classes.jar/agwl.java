import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class agwl
  extends BroadcastReceiver
{
  public agwl(TroopChatPie paramTroopChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction())) && ("onHomeworkTroopIdentityChanged".equals(paramIntent.getStringExtra("event"))))
    {
      paramContext = paramIntent.getStringExtra("data");
      if (!TextUtils.isEmpty(paramContext)) {
        break label41;
      }
    }
    for (;;)
    {
      return;
      try
      {
        label41:
        Object localObject = new JSONObject(paramContext);
        paramContext = ((JSONObject)localObject).optString("groupCode");
        if (TextUtils.equals(paramContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          paramIntent = ((JSONObject)localObject).optString("content");
          String str1 = ((JSONObject)localObject).optString("source");
          int i = ((JSONObject)localObject).optInt("rankId", 333);
          String str2 = ((JSONObject)localObject).optString("nickName");
          String str3 = ((JSONObject)localObject).optString("uin");
          String str4 = ((JSONObject)localObject).optString("course");
          localObject = ((JSONObject)localObject).optString("name");
          if ((!"join".equals(str1)) && (TextUtils.equals(str3, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
          {
            ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str3, str2, i, str4, (String)localObject);
            if (this.a.jdField_a_of_type_Agzw != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "mHomeworkTroopIdentityChangedReceiver dismissTipsBar.");
              }
              this.a.jdField_a_of_type_Agzw.a(TroopChatPie.a(this.a), false);
            }
            if (TroopChatPie.a(this.a) != null) {
              TroopChatPie.a(this.a).a(i);
            }
          }
          if (QLog.isColorLevel())
          {
            QLog.d("zivonchen", 2, new Object[] { "mHomeworkTroopIdentityChangedReceiver troopUin = ", paramContext, ", content = ", paramIntent, ", source = ", str1, ", rankId = ", Integer.valueOf(i), ", nickName = ", str2, "uin = ", str3 });
            return;
          }
        }
      }
      catch (JSONException paramContext) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwl
 * JD-Core Version:    0.7.0.1
 */