import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class akcs
  extends QidianBusinessObserver
{
  public akcs(JumpAction paramJumpAction) {}
  
  protected void h(boolean paramBoolean, HashMap paramHashMap)
  {
    JumpAction.a(this.a).removeObserver(this.a.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    String str1;
    Intent localIntent;
    if ((paramBoolean) && (paramHashMap != null))
    {
      str1 = (String)paramHashMap.get("key_ext_uin");
      String str2 = (String)paramHashMap.get("key_sigt");
      String str3 = (String)paramHashMap.get("key_return_root");
      localIntent = new Intent();
      if ((!TextUtils.isEmpty(str3)) && (!str3.equals("NO"))) {
        break label245;
      }
      localIntent.setComponent(new ComponentName(this.a.jdField_a_of_type_AndroidContentContext, ChatActivity.class));
      localIntent.addFlags(67108864);
      int i = ((Integer)paramHashMap.get("key_aio_type")).intValue();
      if (str1 != null)
      {
        if (str2 != null) {
          localIntent.putExtra("sigt", HexUtil.a(str2));
        }
        if (i != 1) {
          break label316;
        }
        if (!((FriendsManager)JumpAction.a(this.a).getManager(50)).b(str1)) {
          break label279;
        }
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("uinname", ContactUtils.k(JumpAction.a(this.a), str1));
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "onAssignExt AIO_TYPE_EXT UIN_TYPE_FRIEND");
        }
      }
    }
    for (;;)
    {
      localIntent.putExtra("uin", str1);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      label245:
      localIntent.setComponent(new ComponentName(this.a.jdField_a_of_type_AndroidContentContext, SplashActivity.class));
      localIntent.putExtra("open_chatfragment", true);
      break;
      label279:
      localIntent.putExtra("uintype", 1025);
      localIntent.putExtra("from_wpa_for_crm", true);
      if (QLog.isColorLevel())
      {
        QLog.d("JumpAction", 2, "onAssignExt AIO_TYPE_EXT UIN_TYPE_BUSINESS_CRM_EXT_TMP");
        continue;
        label316:
        localIntent.putExtra("uintype", 1024);
        localIntent.putExtra("chat_subType", 1);
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "onAssignExt AIO_TYPE_MASTER");
        }
      }
    }
  }
  
  protected void i(boolean paramBoolean, HashMap paramHashMap)
  {
    JumpAction.a(this.a).removeObserver(this.a.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    String str2;
    Intent localIntent;
    if ((paramBoolean) && (paramHashMap != null))
    {
      int i = ((Integer)paramHashMap.get("key_aio_type")).intValue();
      String str1 = (String)paramHashMap.get("key_sigt");
      str2 = (String)paramHashMap.get("uin");
      paramHashMap = (String)paramHashMap.get("key_return_root");
      localIntent = new Intent();
      if ((!TextUtils.isEmpty(paramHashMap)) && (!paramHashMap.equals("NO"))) {
        break label242;
      }
      localIntent.setComponent(new ComponentName(this.a.jdField_a_of_type_AndroidContentContext, ChatActivity.class));
      localIntent.addFlags(67108864);
      if ((str1 != null) && (str2 != null)) {
        localIntent.putExtra("sigt", HexUtil.a(str1));
      }
      if (i != 1) {
        break label313;
      }
      if (!((FriendsManager)JumpAction.a(this.a).getManager(50)).b(str2)) {
        break label276;
      }
      localIntent.putExtra("uintype", 0);
      localIntent.putExtra("uinname", ContactUtils.k(JumpAction.a(this.a), str2));
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "onCorpUinWpaReport AIO_TYPE_EXT UIN_TYPE_FRIEND");
      }
    }
    for (;;)
    {
      localIntent.putExtra("uin", str2);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      label242:
      localIntent.setComponent(new ComponentName(this.a.jdField_a_of_type_AndroidContentContext, SplashActivity.class));
      localIntent.putExtra("open_chatfragment", true);
      break;
      label276:
      localIntent.putExtra("uintype", 1025);
      localIntent.putExtra("from_wpa_for_crm", true);
      if (QLog.isColorLevel())
      {
        QLog.d("JumpAction", 2, "onCorpUinWpaReport AIO_TYPE_EXT UIN_TYPE_BUSINESS_CRM_EXT_TMP");
        continue;
        label313:
        localIntent.putExtra("uintype", 1024);
        localIntent.putExtra("chat_subType", 1);
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "onCorpUinWpaReport AIO_TYPE_MASTER");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akcs
 * JD-Core Version:    0.7.0.1
 */