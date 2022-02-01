import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.2;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class ahdr
  extends BaseChatPie
{
  private aotj jdField_a_of_type_Aotj;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String b;
  private String c;
  
  public ahdr(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    b();
    if ((BaseActivity.sTopActivity instanceof ArkFullScreenAppActivity)) {
      ((ArkFullScreenAppActivity)BaseActivity.sTopActivity).finish();
    }
    hidePanel();
    if (this.jdField_a_of_type_Aotj != null)
    {
      this.jdField_a_of_type_Aotj.c();
      this.jdField_a_of_type_Aotj = null;
    }
  }
  
  private void a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    paramSessionInfo = bbli.a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, paramSessionInfo.curType, paramArkAppMessage);
    paramQQAppInterface.getMessageFacade().addSendMessage(paramSessionInfo);
    return true;
  }
  
  private void b()
  {
    String str = this.sessionInfo.curFriendUin;
    int i = this.sessionInfo.curType;
    this.app.getMessageFacade().clearHistory(str, i);
    this.app.getMessageFacade().onCurrentMessageDeleted(str, i);
    afvh.a(2);
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
  
  private void c()
  {
    long l = NetConnInfoCenter.getServerTime();
    anuz localanuz = this.app.getProxyManager().a();
    RecentUser localRecentUser = (RecentUser)localanuz.findRecentUserByUin(AppConstants.ARK_DEBUG_UIN, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    localanuz.saveRecentUser(localRecentUser);
    localanuz.updateCache(localRecentUser);
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    this.mActivity.getWindow().addFlags(128);
    aoxo.a(2, null);
    ArkAppCenter.b(true);
    ArkAppCenter.a(new ArkDebugChatPie.1(this));
    return super.doOnCreate(paramBoolean);
  }
  
  public void doOnDestroy()
  {
    ArkAppCenter.a(new ArkDebugChatPie.2(this));
    super.doOnDestroy();
  }
  
  public void doOnStop()
  {
    this.mActivity.getWindow().clearFlags(128);
    super.doOnStop();
  }
  
  public void setTag()
  {
    this.tag = "ArkDebugChatPie";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdr
 * JD-Core Version:    0.7.0.1
 */