import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class aihb
  extends BaseChatPie
{
  private apzw a;
  private bhpc c;
  private String g;
  private String h;
  
  public aihb(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    paramSessionInfo = bcry.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    paramQQAppInterface.a().a(paramSessionInfo);
    return true;
  }
  
  private static void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        if (!paramJSONObject.has("forward")) {
          paramJSONObject.put("forward", 1);
        }
        if (!paramJSONObject.has("autosize"))
        {
          paramJSONObject.put("autosize", 1);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  private void bo()
  {
    if (this.c != null)
    {
      this.c.dismiss();
      this.c = null;
    }
    bp();
    if ((BaseActivity.sTopActivity instanceof ArkFullScreenAppActivity)) {
      ((ArkFullScreenAppActivity)BaseActivity.sTopActivity).finish();
    }
    ar();
    if (this.jdField_a_of_type_Apzw != null)
    {
      this.jdField_a_of_type_Apzw.c();
      this.jdField_a_of_type_Apzw = null;
    }
  }
  
  private void bp()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, i);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(str, i);
    agyv.a(2);
  }
  
  private void bq()
  {
    long l = NetConnInfoCenter.getServerTime();
    apaw localapaw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = (RecentUser)localapaw.findRecentUserByUin(antf.aL, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    localapaw.saveRecentUser(localRecentUser);
    localapaw.updateCache(localRecentUser);
  }
  
  private void g(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public void H()
  {
    ArkAppCenter.a(new ArkDebugChatPie.2(this));
    super.H();
  }
  
  public void L()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().clearFlags(128);
    super.L();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "ArkDebugChatPie";
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().addFlags(128);
    aqed.a(2, null);
    ArkAppCenter.b(true);
    ArkAppCenter.a(new ArkDebugChatPie.1(this));
    return super.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihb
 * JD-Core Version:    0.7.0.1
 */