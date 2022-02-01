import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aipv
{
  public static String a = "BlessJsApiUtils";
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString1.trim())))
    {
      QQToast.a(paramActivity, 2131690632, 1).a();
      return;
    }
    Intent localIntent = new Intent(paramActivity, BlessSelectMemberActivity.class);
    localIntent.putExtra("param_type", 9003);
    localIntent.putExtra("param_entrance", 15);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramActivity.getString(2131690638));
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131691037));
    localIntent.putExtra("param_exit_animation", 1);
    localIntent.putExtra("param_blesstype", 1);
    localIntent.putExtra("param_blessword_content", paramString1);
    localIntent.putExtra("param_web_callback", paramString2);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130771992, 2130771993);
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "startBlessPtvActivity , supportVideo:" + paramString1 + ", supportPhoto:" + paramString2 + ", cameraMode:" + paramString3 + ", unfoldDDStr:" + paramString5 + ", dDCategoryName:" + paramString6 + ", dDItemID:" + paramString7 + ", callback:" + paramString9);
    }
    boolean bool1 = "1".equals(paramString1);
    boolean bool2 = "1".equals(paramString2);
    if ("1".equals(paramString3)) {}
    boolean bool3;
    boolean bool4;
    boolean bool5;
    for (int i = 2;; i = 1)
    {
      bool3 = "1".equals(paramString4);
      bool4 = "1".equals(paramString8);
      bool5 = "1".equals(paramString5);
      if (bbhm.a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "supportMediaCodec = false");
      }
      QQToast.a(paramActivity, paramActivity.getString(2131690636), 0).a();
      return false;
    }
    paramString1 = bmuz.a(bool1, bool2, i, true, bool3, bool5, paramString6, paramString7, bool4, bmuz.b, "", "", null, "", 107);
    paramString2 = new Intent(paramActivity, StoryTransitionActivity.class);
    paramString2.putExtras(paramString1);
    paramString2.putExtra("jump_action", 7);
    paramActivity.startActivity(paramString2);
    return true;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    boolean bool = VideoEnvironment.supportShortVideoRecord(paramAppInterface);
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(a, 2, "isMobileSupportPTV false");
    }
    return bool;
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    boolean bool = bdee.a();
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(a, 2, "isSupportFilterSo false");
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
        if (bnky.a(bnkt.b) == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(a, 2, "PtvFilterSoLoad getFilterSoState is false");
      return false;
    } while (!bbhm.a());
    if (ShortVideoUtils.isVideoSoLibLoaded()) {}
    for (;;)
    {
      return bool;
      ShortVideoUtils.loadShortVideoSo(paramAppInterface);
      if (!ShortVideoUtils.isVideoSoLibLoaded()) {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipv
 * JD-Core Version:    0.7.0.1
 */