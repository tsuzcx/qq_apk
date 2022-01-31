import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;

public class akoz
{
  public String a;
  
  public akoz(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(akxc paramakxc, Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = akji.a(paramQQAppInterface);
    if ((paramakxc == null) || (paramContext == null) || (paramQQAppInterface == null) || (i == 1)) {}
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
    akwt.a(paramakxc, paramString, 3, 0);
    localSharedPreferences.edit().putBoolean(paramContext, false).commit();
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "Guide_bubbles_show", 0, 0, new String[] { "", "", "", this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoz
 * JD-Core Version:    0.7.0.1
 */