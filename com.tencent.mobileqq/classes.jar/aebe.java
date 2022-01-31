import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class aebe
  extends BaseChatPie
{
  private alcm a;
  private bafb c;
  private String g;
  private String h;
  
  public aebe(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    paramSessionInfo = awbi.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    paramQQAppInterface.a().b(paramSessionInfo, paramQQAppInterface.getCurrentAccountUin());
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
  
  private void bm()
  {
    if (this.c != null)
    {
      this.c.dismiss();
      this.c = null;
    }
    bn();
    if ((BaseActivity.sTopActivity instanceof ArkFullScreenAppActivity)) {
      ((ArkFullScreenAppActivity)BaseActivity.sTopActivity).finish();
    }
    ap();
    if (this.jdField_a_of_type_Alcm != null)
    {
      this.jdField_a_of_type_Alcm.c();
      this.jdField_a_of_type_Alcm = null;
    }
  }
  
  private void bn()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, i);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(str, i);
    adai.a(2);
  }
  
  private void bo()
  {
    long l = NetConnInfoCenter.getServerTime();
    akeu localakeu = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localakeu.a(ajed.aK, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    localakeu.a(localRecentUser);
    localakeu.b(localRecentUser);
  }
  
  private void f(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public void G()
  {
    ArkAppCenter.a(new ArkDebugChatPie.2(this));
    super.G();
  }
  
  public void K()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().clearFlags(128);
    super.K();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "ArkDebugChatPie";
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().addFlags(128);
    algs.a(2, null);
    ArkAppCenter.b(true);
    ArkAppCenter.a(new ArkDebugChatPie.1(this));
    return super.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aebe
 * JD-Core Version:    0.7.0.1
 */