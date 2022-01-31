import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.VipUtils;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.AppInfo;

public class aclo
  implements View.OnClickListener
{
  public aclo(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject3;
    if ((localObject1 instanceof oidb_0xaf4.AppInfo))
    {
      localObject3 = (oidb_0xaf4.AppInfo)localObject1;
      localObject1 = ((oidb_0xaf4.AppInfo)localObject3).url.get();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label40;
      }
    }
    label40:
    label808:
    for (;;)
    {
      return;
      long l = ((oidb_0xaf4.AppInfo)localObject3).appid.get();
      Object localObject2;
      if ((l == 1101236949L) && (aoql.c().mIsEnable) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
      {
        boolean bool = alzw.c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
        {
          localObject1 = this.a;
          localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
          if (bool)
          {
            i = 15;
            localObject3 = VipUtils.a(0, i).toString();
            String str = alpo.a(2131702113);
            aclp localaclp = new aclp(this, bool);
            if (!bool) {
              break label239;
            }
            paramView = "0X800A57F";
            label184:
            if (!bool) {
              break label245;
            }
            i = 1;
            label191:
            VipUtils.a((Context)localObject1, (String)localObject2, (String)localObject3, str, localaclp, paramView, i, bool);
          }
        }
        for (;;)
        {
          azmj.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 3, 0, "", "", "", "");
          return;
          i = 8;
          break;
          label239:
          paramView = "0X8009E38";
          break label184;
          label245:
          i = 3;
          break label191;
          VipUtils.a(this.a, bool);
        }
      }
      int i = ((oidb_0xaf4.AppInfo)localObject3).push_red_point.get();
      if (MiniAppLauncher.isMiniAppUrl((String)localObject1))
      {
        localObject1 = bclo.a((String)localObject1, l, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.a.app, true);
        MiniAppLauncher.startMiniApp(this.a, (String)localObject1, 2010, bclo.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), null);
        bclo.a((oidb_0xaf4.AppInfo)localObject3, "click", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (i != 0)
        {
          ((oidb_0xaf4.AppInfo)localObject3).push_red_point.set(0);
          ((TextView)paramView.findViewById(2131362711)).setVisibility(8);
          bckr.a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (int)l);
        }
        bdaj.a("Grp_app_new", "grpData_admin", "app_clk", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), String.valueOf(l) });
        if (l != 0L) {
          break label761;
        }
        paramView = "app_clk";
        MiniProgramLpReportDC04239.reportByQQqunInfo("qun", "qun_info", "click_more", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramView)) {
          break label808;
        }
        bdaj.a("Grp_app_new", "grpData_admin", paramView, 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        return;
        if ((((String)localObject1).startsWith("http")) || (((String)localObject1).startsWith("https")))
        {
          localObject2 = new Intent(this.a, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", bclo.a((String)localObject1, l, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.a.app, true));
          ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
          ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.a.startActivity((Intent)localObject2);
          break;
        }
        if (!((String)localObject1).startsWith("mqqapi")) {
          break;
        }
        localObject2 = bclo.a((String)localObject1, l, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.a.app, true);
        localObject1 = localObject2;
        if (l == 1105981808L)
        {
          localObject1 = xlh.a(this.a.getIntent(), (String)localObject2, null);
          wta.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
        }
        localObject2 = new Intent(this.a, JumpActivity.class);
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        this.a.startActivity((Intent)localObject2);
        break;
        label761:
        if (l == 1L) {
          paramView = "clk_file";
        } else if (l == 2L) {
          paramView = "clk_album";
        } else if (l == 1101236949L) {
          paramView = "clk_notice";
        } else {
          paramView = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclo
 * JD-Core Version:    0.7.0.1
 */