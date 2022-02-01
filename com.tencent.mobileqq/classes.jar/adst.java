import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;

public class adst
  implements View.OnClickListener
{
  public adst(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject3;
    String str;
    long l2;
    long l1;
    if ((localObject1 instanceof oidb_0xe83.AppInfo))
    {
      localObject3 = (oidb_0xe83.AppInfo)localObject1;
      str = ((oidb_0xe83.AppInfo)localObject3).url.get();
      l2 = ((oidb_0xe83.AppInfo)localObject3).appid.get();
      localObject1 = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject1 == null) {
        break label1325;
      }
      localObject1 = ((TroopManager)localObject1).c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (localObject1 == null) {
        break label1320;
      }
      l1 = ((TroopInfo)localObject1).dwGroupClassExt;
    }
    for (;;)
    {
      Object localObject4 = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      long l3 = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt;
      Object localObject2;
      if (paramView.getTag(-1) == null)
      {
        localObject2 = String.valueOf(l2) + "-0";
        bdla.b(null, "dc00898", "", (String)localObject4, "0X800AFC4", "0X800AFC4", 0, 0, String.valueOf(l3), String.valueOf(l2), (String)localObject2, "");
        if (l2 == 0L)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("troop_uin", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          new SessionInfo();
          localObject4 = new SessionInfo();
          ((SessionInfo)localObject4).curFriendUin = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
          ((SessionInfo)localObject4).curType = 1;
          ((SessionInfo)localObject4).troopUin = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
          ((Intent)localObject2).putExtra("session_info", (Parcelable)localObject4);
          ((Intent)localObject2).putExtra("fling_action_key", 2);
          ((Intent)localObject2).putExtra("fling_code_key", hashCode());
          ((Intent)localObject2).putExtra("reportfrom", 2);
          aeow.a(this.a.getApplicationContext(), (Intent)localObject2, PublicFragmentActivity.class, TroopAppShortcutFragment.class);
          bdla.b(null, "dc00898", "", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0X800AFC6", "0X800AFC6", 0, 0, String.valueOf(l1), "", "", "");
          localObject2 = (bgig)this.a.app.getManager(QQManagerFactory.TROOP_APP_MGR);
          if (localObject2 != null) {
            ((bgig)localObject2).a(true, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          }
        }
        if (!TextUtils.isEmpty(str)) {
          break label450;
        }
      }
      label450:
      while (ChatSettingForTroop.a(this.a, l2, (TroopInfo)localObject1))
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject2 = String.valueOf(l2) + "-" + paramView.getTag(-1).toString();
        break;
      }
      if ((l2 == 1101236949L) && (arjy.c().mIsEnable) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
      {
        boolean bool = aofp.c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
        {
          localObject2 = this.a;
          localObject3 = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
          if (bool)
          {
            i = 15;
            label563:
            str = VipUtils.a(0, i).toString();
            localObject4 = anvx.a(2131701238);
            adsu localadsu = new adsu(this, bool);
            if (!bool) {
              break label661;
            }
            localObject1 = "0X800A57F";
            label601:
            if (!bool) {
              break label669;
            }
            i = 1;
            label608:
            VipUtils.a((Context)localObject2, (String)localObject3, str, (String)localObject4, localadsu, (String)localObject1, i, bool);
          }
        }
        for (;;)
        {
          bdla.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 3, 0, "", "", "", "");
          break;
          i = 8;
          break label563;
          label661:
          localObject1 = "0X8009E38";
          break label601;
          label669:
          i = 3;
          break label608;
          VipUtils.a(this.a, bool);
        }
      }
      int i = ((oidb_0xe83.AppInfo)localObject3).push_red_point.get();
      if (MiniAppLauncher.isMiniAppUrl(str))
      {
        localObject1 = TroopUtils.replaceSpecialTag(str, l2, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.a.app, true);
        MiniAppLauncher.startMiniApp(this.a, (String)localObject1, 2010, TroopUtils.createEntryModel(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), null);
        TroopUtils.reportQunMiniApp((oidb_0xe83.AppInfo)localObject3, "click", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        label780:
        if (i != 0)
        {
          ((oidb_0xe83.AppInfo)localObject3).push_red_point.set(0);
          ((TextView)paramView.findViewById(2131362866)).setVisibility(8);
          bglm.a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (int)l2);
        }
        bhbu.a("Grp_app_new", "grpData_admin", "app_clk", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), String.valueOf(l2) });
        localObject1 = "";
        if (l2 != 0L) {
          break label1271;
        }
        localObject1 = "app_clk";
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          bhbu.a("Grp_app_new", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        }
        if (l2 != 101889454L) {
          break;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("action", "click");
        ((Bundle)localObject1).putString("page", "group_page");
        ((Bundle)localObject1).putString("module", "studyroom_entry");
        ((Bundle)localObject1).putString("room_id", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        bdxf.a((Bundle)localObject1);
        break;
        if ((str.startsWith("http")) || (str.startsWith("https")))
        {
          localObject1 = new Intent(this.a, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", TroopUtils.replaceSpecialTag(str, l2, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.a.app, true));
          ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
          ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.a.startActivity((Intent)localObject1);
          break label780;
        }
        if (!str.startsWith("mqqapi")) {
          break label780;
        }
        localObject2 = TroopUtils.replaceSpecialTag(str, l2, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.a.app, true);
        localObject1 = localObject2;
        if (l2 == 1105981808L)
        {
          localObject1 = zcl.a(this.a.getIntent(), (String)localObject2, null);
          ykv.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
        }
        localObject2 = new Intent(this.a, JumpActivity.class);
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        this.a.startActivity((Intent)localObject2);
        break label780;
        label1271:
        if (l2 == 1L) {
          localObject1 = "clk_file";
        } else if (l2 == 2L) {
          localObject1 = "clk_album";
        } else if (l2 == 1101236949L) {
          localObject1 = "clk_notice";
        }
      }
      label1320:
      l1 = 0L;
      continue;
      label1325:
      localObject1 = null;
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adst
 * JD-Core Version:    0.7.0.1
 */