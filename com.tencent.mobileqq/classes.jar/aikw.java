import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;

public class aikw
{
  public String a;
  
  public aikw(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(aisu paramaisu, Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = aifg.a(paramQQAppInterface);
    if ((paramaisu == null) || (paramContext == null) || (paramQQAppInterface == null) || (i == 1)) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      paramContext = "apollo_friend_profile_drawer_first" + paramQQAppInterface.getCurrentAccountUin();
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    } while (!localSharedPreferences.getBoolean(paramContext, true));
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileBubble", 2, "onBubbleShow first");
    }
    aisl.a(paramaisu, paramString, 3, 0);
    localSharedPreferences.edit().putBoolean(paramContext, false).commit();
    bajr.a(paramQQAppInterface, "cmshow", "Apollo", "Guide_bubbles_show", 0, 0, new String[] { "", "", "", this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aikw
 * JD-Core Version:    0.7.0.1
 */