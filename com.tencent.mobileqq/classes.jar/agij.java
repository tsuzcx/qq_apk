import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public class agij
  implements agin
{
  private BaseChatPie a;
  
  public agij(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public static boolean a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass)
  {
    Intent localIntent1 = paramActivity.getIntent();
    if (!localIntent1.getBooleanExtra("back_for_hidden_chat", false)) {
      return false;
    }
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("back_for_hidden_chat", true);
    localIntent2.setFlags(603979776);
    localIntent1.putExtra("should_restore_from_kill", false);
    PublicFragmentActivity.a(paramActivity, localIntent1, paramClass, -1);
    paramActivity.overridePendingTransition(2130771988, 2130771989);
    return true;
  }
  
  public static boolean a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramInt == 1) && (b(paramString, paramQQAppInterface))) {}
    while ((paramInt == 0) && (a(paramString, paramQQAppInterface))) {
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    ExtensionInfo localExtensionInfo = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(String.valueOf(paramString));
    paramQQAppInterface = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramQQAppInterface = new ExtensionInfo();
      paramQQAppInterface.uin = String.valueOf(paramString);
    }
    return paramQQAppInterface.hiddenChatSwitch == 1;
  }
  
  public static boolean b(Activity paramActivity, Class<?> paramClass)
  {
    if (!paramActivity.getIntent().getBooleanExtra("back_for_hidden_chat", false)) {
      return false;
    }
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("back_for_hidden_chat", true);
    paramClass.setFlags(603979776);
    paramActivity.startActivity(paramClass);
    paramActivity.overridePendingTransition(2130771988, 2130771989);
    return true;
  }
  
  public static boolean b(String paramString, QQAppInterface paramQQAppInterface)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    paramQQAppInterface = localTroopInfo;
    if (localTroopInfo == null)
    {
      paramQQAppInterface = new TroopInfo();
      paramQQAppInterface.troopuin = paramString;
    }
    return TroopInfo.isCmdUinFlagEx2Open(paramQQAppInterface.cmdUinFlagEx2, 512);
  }
  
  public static boolean c(Activity paramActivity, Class<?> paramClass)
  {
    if (!paramActivity.getIntent().getBooleanExtra("back_for_hidden_chat", false)) {
      return false;
    }
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.setFlags(603979776);
    paramClass.putExtra("tab_index", MainFragment.b);
    paramClass.putExtra("fragment_id", 1);
    paramActivity.startActivity(paramClass);
    paramActivity.overridePendingTransition(2130771988, 2130771989);
    return true;
  }
  
  public void a()
  {
    if (a(this.a.sessionInfo.curFriendUin, this.a.sessionInfo.curType, this.a.app)) {
      bdla.b(null, "dc00898", "", "", "0X800A34F", "0X800A34F", 0, 0, "0", "0", "", "");
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 9)
    {
      if (a(this.a.sessionInfo.curFriendUin, this.a.sessionInfo.curType, this.a.app)) {
        bdla.b(null, "dc00898", "", "", "0X800A34E", "0X800A34E", this.a.mActivity.getIntent().getIntExtra("hidden_aio_msg_source", 999), 0, "0", "0", "", "");
      }
      ayzg.a("aio opened");
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (a(this.a.sessionInfo.curFriendUin, this.a.sessionInfo.curType, this.a.app)) {
      paramIntent.putExtra("hidden_aio_msg_source", 3);
    }
  }
  
  public boolean a()
  {
    boolean bool = a(this.a.sessionInfo.curFriendUin, this.a.sessionInfo.curType, this.a.app);
    if (bool)
    {
      Intent localIntent = this.a.mActivity.getIntent();
      if (localIntent.getIntExtra("entrance", 0) == 2) {
        localIntent.putExtra("FromType", 2);
      }
      localIntent.putExtra("back_for_hidden_chat", true);
      a(this.a.mActivity, HiddenChatFragment.class);
      localIntent.removeExtra("back_for_hidden_chat");
    }
    return bool;
  }
  
  public boolean a(QQMessageFacade.Message paramMessage)
  {
    if (a(this.a.sessionInfo.curFriendUin, this.a.sessionInfo.curType, this.a.app)) {
      return true;
    }
    return a(paramMessage.frienduin, paramMessage.istroop, this.a.app);
  }
  
  public int[] a()
  {
    return new int[] { 9 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agij
 * JD-Core Version:    0.7.0.1
 */