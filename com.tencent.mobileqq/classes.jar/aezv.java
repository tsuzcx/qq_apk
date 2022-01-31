import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopShortcutbarFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class aezv
  implements View.OnClickListener
{
  aezv(aezp paramaezp) {}
  
  public void onClick(View paramView)
  {
    if (aezp.a(this.a) == null) {}
    bcea localbcea;
    long l;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while (!(paramView instanceof bcea));
        localbcea = (bcea)paramView;
        paramView = localbcea.c();
        l = localbcea.a();
        if ((!TextUtils.isEmpty(paramView)) || (l == 101847770L)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("AppShortcutBarAIOHelper", 2, "OnClickListener. url is empty.");
      return;
      localTroopInfo = ((TroopManager)aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (localTroopInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarAIOHelper", 2, "OnClickListener. troopInfo is null.");
    return;
    if (l == 101847770L)
    {
      paramView = TroopMemberListActivity.a(aezp.a(this.a).jdField_a_of_type_AndroidContentContext, aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 19);
      paramView.putExtra("TROOP_INFO_MEMBER_NUM", localTroopInfo.wMemberNum);
      aezp.a(this.a).jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      azmj.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(localbcea.a()), aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((l == 1101236949L) && (aoql.c().mIsEnable) && (localTroopInfo.mIsFreezed == 1) && ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))))
    {
      bool = alzw.c(localTroopInfo.groupFreezeReason);
      if (localTroopInfo.isTroopOwner(aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        localObject1 = aezp.a(this.a).jdField_a_of_type_AndroidContentContext;
        localObject2 = aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
        if (bool)
        {
          i = 15;
          String str1 = VipUtils.a(0, i).toString();
          String str2 = alpo.a(2131702113);
          aezw localaezw = new aezw(this, bool);
          if (!bool) {
            break label474;
          }
          paramView = "0X800A57F";
          label396:
          if (!bool) {
            break label480;
          }
          i = 1;
          label403:
          VipUtils.a((Context)localObject1, (String)localObject2, str1, str2, localaezw, paramView, i, bool);
        }
      }
      for (;;)
      {
        azmj.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(localbcea.a()), aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, String.valueOf(localTroopInfo.dwGroupClassExt), "");
        return;
        i = 8;
        break;
        label474:
        paramView = "0X8009E38";
        break label396;
        label480:
        i = 3;
        break label403;
        VipUtils.a(aezp.a(this.a).jdField_a_of_type_AndroidContentContext, bool);
      }
    }
    int i = localbcea.b();
    if (i != 0) {
      bckr.a(aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopInfo.troopuin, (int)l);
    }
    if (MiniAppLauncher.isMiniAppUrl(paramView)) {
      MiniAppLauncher.startMiniApp(aezp.a(this.a).jdField_a_of_type_AndroidContentContext, paramView, 2010, bclo.a(localTroopInfo, aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), null);
    }
    do
    {
      for (;;)
      {
        azmj.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(localbcea.a()), aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, String.valueOf(localTroopInfo.dwGroupClassExt), "");
        return;
        if ((paramView.startsWith("http")) || (paramView.startsWith("https")))
        {
          localObject1 = new Intent(aezp.a(this.a).jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", this.a.a(paramView, l, i, localTroopInfo, true));
          ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
          ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
          aezp.a(this.a).jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        }
        else
        {
          if (!paramView.startsWith("mqqapi")) {
            break;
          }
          localObject1 = this.a.a(paramView, l, i, localTroopInfo, true);
          localObject2 = new Intent(aezp.a(this.a).jdField_a_of_type_AndroidContentContext, JumpActivity.class);
          paramView = (View)localObject1;
          if (l == 1105981808L) {
            paramView = xlh.a((Intent)localObject2, (String)localObject1, null);
          }
          ((Intent)localObject2).setData(Uri.parse(paramView));
          aezp.a(this.a).jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        }
      }
    } while (!paramView.startsWith("local"));
    if ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
    for (boolean bool = true;; bool = false)
    {
      paramView = new Intent();
      paramView.putExtra("leftViewText", aezp.a(this.a).jdField_a_of_type_AndroidContentContext.getString(2131696678));
      paramView.putExtra("trooptype", localTroopInfo.dwGroupClassExt);
      paramView.putExtra("troopuin", aezp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      paramView.putExtra("isManagerPage", bool);
      paramView.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      adky.a(aezp.a(this.a).jdField_a_of_type_AndroidContentContext, paramView, PublicFragmentActivity.class, TroopShortcutbarFragment.class);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezv
 * JD-Core Version:    0.7.0.1
 */