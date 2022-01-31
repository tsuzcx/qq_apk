import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class aeqc
{
  public static String a = "BlessJsApiUtils";
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString1.trim())))
    {
      bbmy.a(paramActivity, 2131624936, 1).a();
      return;
    }
    Intent localIntent = new Intent(paramActivity, BlessSelectMemberActivity.class);
    localIntent.putExtra("param_type", 9003);
    localIntent.putExtra("param_entrance", 15);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramActivity.getString(2131624953));
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131625463));
    localIntent.putExtra("param_exit_animation", 1);
    localIntent.putExtra("param_blesstype", 1);
    localIntent.putExtra("param_blessword_content", paramString1);
    localIntent.putExtra("param_web_callback", paramString2);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130771992, 2130771993);
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    boolean bool = VideoEnvironment.b(paramAppInterface);
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(a, 2, "isMobileSupportPTV fasle");
    }
    return bool;
  }
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "startBlessPtvActivity , supportVideo:" + paramString1 + ", supportPhoto:" + paramString2 + ", cameramode:" + paramString3 + ", unfoldDDStr:" + paramString5 + ", dDCategoryName:" + paramString6 + ", dDItemID:" + paramString7 + ", unfoldFilter:" + paramString9 + ", filterCategoryName:" + paramString10 + ", filterItemID:" + paramString11 + ", callback:" + paramString12);
    }
    boolean bool1 = "1".equals(paramString1);
    boolean bool2 = "1".equals(paramString2);
    if ("1".equals(paramString3)) {}
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    for (int i = 2;; i = 1)
    {
      bool3 = "1".equals(paramString4);
      bool4 = "1".equals(paramString8);
      bool5 = "1".equals(paramString5);
      bool6 = "1".equals(paramString9);
      if (autt.a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "supportMediaCodec = false");
      }
      bbmy.a(paramActivity, paramActivity.getString(2131624950), 0).a();
      return false;
    }
    paramAppInterface = bhew.a(bool1, bool2, i, true, bool3, bool5, paramString6, paramString7, bool4, bool6, paramString10, paramString11, bhew.e, "", "", null, "", "", "", "", null);
    paramString1 = new Intent(paramActivity, StoryTransitionActivity.class);
    paramString1.putExtras(paramAppInterface);
    paramString1.putExtra(bhew.p, true);
    paramString1.putExtra("jump_action", 7);
    paramActivity.startActivity(paramString1);
    return true;
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    boolean bool = awlw.c();
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(a, 2, "issupportFilterSo false");
    }
    return bool;
  }
  
  public static boolean c(AppInterface paramAppInterface)
  {
    boolean bool = true;
    if (paramAppInterface.getCurrentAccountUin() == null) {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "isAccLoginSuccess false.");
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
        } while (!a(paramAppInterface));
        if (awlw.a(BaseApplicationImpl.getContext()) == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(a, 2, "PtvFilterSoLoad getFilterSoState is false");
      return false;
    } while (!autt.a());
    if (ShortVideoUtils.a()) {}
    for (;;)
    {
      return bool;
      ShortVideoUtils.a(paramAppInterface);
      if (!ShortVideoUtils.a()) {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aeqc
 * JD-Core Version:    0.7.0.1
 */