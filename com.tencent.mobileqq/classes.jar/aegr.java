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
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;

public class aegr
  implements View.OnClickListener
{
  public aegr(ChatSettingForTroop paramChatSettingForTroop) {}
  
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
      localObject1 = (TroopManager)this.a.app.getManager(52);
      if (localObject1 == null) {
        break label1320;
      }
      localObject1 = ((TroopManager)localObject1).c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (localObject1 == null) {
        break label1315;
      }
      l1 = ((TroopInfo)localObject1).dwGroupClassExt;
    }
    for (;;)
    {
      Object localObject4 = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      long l3 = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
      Object localObject2;
      if (paramView.getTag(-1) == null)
      {
        localObject2 = String.valueOf(l2) + "-0";
        bdll.b(null, "dc00898", "", (String)localObject4, "0X800AFC4", "0X800AFC4", 0, 0, String.valueOf(l3), String.valueOf(l2), (String)localObject2, "");
        if (l2 == 0L)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("troop_uin", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          new SessionInfo();
          localObject4 = new SessionInfo();
          ((SessionInfo)localObject4).jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
          ((SessionInfo)localObject4).jdField_a_of_type_Int = 1;
          ((SessionInfo)localObject4).b = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
          ((Intent)localObject2).putExtra("session_info", (Parcelable)localObject4);
          ((Intent)localObject2).putExtra("fling_action_key", 2);
          ((Intent)localObject2).putExtra("fling_code_key", hashCode());
          ((Intent)localObject2).putExtra("reportfrom", 2);
          afez.a(this.a.getApplicationContext(), (Intent)localObject2, PublicFragmentActivity.class, TroopAppShortcutFragment.class);
          bdll.b(null, "dc00898", "", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0X800AFC6", "0X800AFC6", 0, 0, String.valueOf(l1), "", "", "");
          localObject2 = (bgqm)this.a.app.getManager(109);
          if (localObject2 != null) {
            ((bgqm)localObject2).a(true, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          }
        }
        if (!TextUtils.isEmpty(str)) {
          break label448;
        }
      }
      label448:
      while (ChatSettingForTroop.a(this.a, l2, (TroopInfo)localObject1))
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject2 = String.valueOf(l2) + "-" + paramView.getTag(-1).toString();
        break;
      }
      if ((l2 == 1101236949L) && (armu.c().mIsEnable) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
      {
        boolean bool = aojn.c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
        {
          localObject2 = this.a;
          localObject3 = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
          if (bool)
          {
            i = 15;
            label561:
            str = VipUtils.a(0, i).toString();
            localObject4 = anzj.a(2131700652);
            aegs localaegs = new aegs(this, bool);
            if (!bool) {
              break label657;
            }
            localObject1 = "0X800A57F";
            label599:
            if (!bool) {
              break label664;
            }
            i = 1;
            label606:
            VipUtils.a((Context)localObject2, (String)localObject3, str, (String)localObject4, localaegs, (String)localObject1, i, bool);
          }
        }
        for (;;)
        {
          bdll.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 3, 0, "", "", "", "");
          break;
          i = 8;
          break label561;
          label657:
          localObject1 = "0X8009E38";
          break label599;
          label664:
          i = 3;
          break label606;
          VipUtils.a(this.a, bool);
        }
      }
      int i = ((oidb_0xe83.AppInfo)localObject3).push_red_point.get();
      if (MiniAppLauncher.isMiniAppUrl(str))
      {
        localObject1 = bguq.a(str, l2, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.a.app, true);
        MiniAppLauncher.startMiniApp(this.a, (String)localObject1, 2010, bguq.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), null);
        bguq.a((oidb_0xe83.AppInfo)localObject3, "click", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        label775:
        if (i != 0)
        {
          ((oidb_0xe83.AppInfo)localObject3).push_red_point.set(0);
          ((TextView)paramView.findViewById(2131362839)).setVisibility(8);
          bgts.a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (int)l2);
        }
        bhju.a("Grp_app_new", "grpData_admin", "app_clk", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), String.valueOf(l2) });
        localObject1 = "";
        if (l2 != 0L) {
          break label1266;
        }
        localObject1 = "app_clk";
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          bhju.a("Grp_app_new", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        }
        if (l2 != 101889454L) {
          break;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("action", "click");
        ((Bundle)localObject1).putString("page", "group_page");
        ((Bundle)localObject1).putString("module", "studyroom_entry");
        ((Bundle)localObject1).putString("room_id", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        bdwp.a((Bundle)localObject1);
        break;
        if ((str.startsWith("http")) || (str.startsWith("https")))
        {
          localObject1 = new Intent(this.a, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", bguq.a(str, l2, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.a.app, true));
          ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
          ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.a.startActivity((Intent)localObject1);
          break label775;
        }
        if (!str.startsWith("mqqapi")) {
          break label775;
        }
        localObject2 = bguq.a(str, l2, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.a.app, true);
        localObject1 = localObject2;
        if (l2 == 1105981808L)
        {
          localObject1 = zmw.a(this.a.getIntent(), (String)localObject2, null);
          yup.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
        }
        localObject2 = new Intent(this.a, JumpActivity.class);
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        this.a.startActivity((Intent)localObject2);
        break label775;
        label1266:
        if (l2 == 1L) {
          localObject1 = "clk_file";
        } else if (l2 == 2L) {
          localObject1 = "clk_album";
        } else if (l2 == 1101236949L) {
          localObject1 = "clk_notice";
        }
      }
      label1315:
      l1 = 0L;
      continue;
      label1320:
      localObject1 = null;
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegr
 * JD-Core Version:    0.7.0.1
 */