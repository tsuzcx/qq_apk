import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;

class aegk
  implements TroopMemberApiClient.Callback
{
  aegk(aegj paramaegj, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isSuccess", false))
    {
      int i = paramBundle.getInt("appid");
      Object localObject = paramBundle.getString("openId");
      if ((i != this.jdField_a_of_type_Aegj.jdField_a_of_type_JavaLangInteger.intValue()) || (!((String)localObject).equals(this.jdField_a_of_type_Aegj.jdField_a_of_type_JavaLangString))) {
        break label120;
      }
      paramBundle = paramBundle.getString("uin");
      if (!TextUtils.isEmpty(paramBundle))
      {
        localObject = new Intent(this.jdField_a_of_type_Aegj.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(), FriendProfileCardActivity.class);
        ((Intent)localObject).putExtra("troopUin", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("memberUin", paramBundle);
        this.jdField_a_of_type_Aegj.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a().startActivity((Intent)localObject);
      }
    }
    label120:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("UiApiPlugin", 2, "appId != appID || !openId.equals(openID)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegk
 * JD-Core Version:    0.7.0.1
 */