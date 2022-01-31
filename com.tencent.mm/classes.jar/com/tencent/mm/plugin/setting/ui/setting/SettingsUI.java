package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.a.ek;
import com.tencent.mm.h.a.ek.a;
import com.tencent.mm.h.a.jf;
import com.tencent.mm.kernel.j;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.network.aa;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.pluginsdk.f.e.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.ui.s;
import com.tencent.mm.y.a.a;
import java.util.ArrayList;
import java.util.Set;

@j
public class SettingsUI
  extends MMPreference
  implements m.b
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private com.tencent.mm.ah.f eBv = null;
  private am etU = null;
  private am fjC;
  private com.tencent.mm.ui.widget.a.d fnI;
  private View lPf;
  private ProgressDialog nTd = null;
  private am nTe;
  private com.tencent.mm.ah.f nTf = null;
  private com.tencent.mm.ah.f nWA = null;
  private PersonalPreference nWu = null;
  private com.tencent.mm.ah.f nWv = null;
  private a.a nWw = new SettingsUI.1(this);
  private Dialog nWx = null;
  private com.tencent.mm.ui.widget.a.c nWy;
  private CheckBox nWz;
  
  private void byR()
  {
    int j = 0;
    IconPreference localIconPreference = (IconPreference)this.dnn.add("settings_about_micromsg");
    boolean bool1 = bk.a(Boolean.valueOf(com.tencent.mm.y.c.BS().bb(262145, 266243)), false);
    boolean bool2 = com.tencent.mm.y.c.BS().bc(262157, 266262);
    if (com.tencent.mm.sdk.platformtools.e.uen)
    {
      localIconPreference.dD("", -1);
      localIconPreference.Gt(8);
      bool1 = com.tencent.mm.y.c.BS().bc(262158, 266265);
      localIconPreference = (IconPreference)this.dnn.add("settings_about_system");
      if (!bool1) {
        break label197;
      }
      i = 0;
      label102:
      localIconPreference.Gv(i);
      com.tencent.mm.plugin.y.a.bov();
      if (!com.tencent.mm.aw.c.iW(com.tencent.mm.aw.b.evf)) {
        break label203;
      }
    }
    label197:
    label203:
    for (int i = j;; i = 8)
    {
      localIconPreference.Gv(i);
      return;
      if (bool1)
      {
        localIconPreference.Gt(0);
        localIconPreference.dD(getString(a.i.app_new), a.e.new_tips_bg);
        break;
      }
      if (bool2)
      {
        localIconPreference.Gv(0);
        break;
      }
      localIconPreference.Gv(8);
      localIconPreference.dD("", -1);
      localIconPreference.Gt(8);
      break;
      i = 8;
      break label102;
    }
  }
  
  private void bzA()
  {
    Object localObject1 = com.tencent.mm.kernel.g.Dk();
    Object localObject2 = new SettingsUI.20(this);
    this.nTf = ((com.tencent.mm.ah.f)localObject2);
    ((com.tencent.mm.ah.p)localObject1).a(255, (com.tencent.mm.ah.f)localObject2);
    localObject1 = new r(2);
    ((r)localObject1).ezR = 1;
    com.tencent.mm.kernel.g.Dk().a((com.tencent.mm.ah.m)localObject1, 0);
    this.nTe = new am(Looper.getMainLooper(), new SettingsUI.21(this, (r)localObject1), false);
    this.nTe.S(3000L, 3000L);
    localObject2 = this.mController.uMN;
    getString(a.i.app_tip);
    this.nTd = com.tencent.mm.ui.base.h.b((Context)localObject2, getString(a.i.wx_exit_processing_txt), false, new SettingsUI.22(this, (r)localObject1));
  }
  
  private void bzp()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "oneliang logout mm");
    com.tencent.mm.plugin.setting.b.eUS.tq();
    com.tencent.mm.kernel.g.DP().Dz().b(this);
    Object localObject = new jf();
    ((jf)localObject).bRC.status = 0;
    ((jf)localObject).bRC.aQw = 0;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    localObject = new com.tencent.mm.h.a.y();
    ((com.tencent.mm.h.a.y)localObject).bFX.bFY = true;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    ag.Zn("show_whatsnew");
    com.tencent.mm.kernel.l.k(this, true);
    ae.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
    localObject = new Intent();
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("Intro_Switch", true);
    com.tencent.mm.plugin.setting.b.eUR.q((Intent)localObject, this.mController.uMN);
    w.E(this, null);
    finish();
  }
  
  private void bzt()
  {
    IconPreference localIconPreference = (IconPreference)this.dnn.add("settings_account_info");
    if (localIconPreference == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
      return;
    }
    localIconPreference.Gy(8);
    if (com.tencent.mm.y.c.BS().a(ac.a.uyT, 266257))
    {
      localIconPreference.Gv(0);
      label56:
      if (bk.getInt(com.tencent.mm.m.g.AA().getValue("VoiceprintEntry"), 0) != 1) {
        break label162;
      }
      if (!((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uow, Boolean.valueOf(true))).booleanValue()) {
        break label164;
      }
      if ((com.tencent.mm.kernel.g.DP().Dz().getInt(40, 0) & 0x20000) == 0)
      {
        localIconPreference.dD(getString(a.i.app_new), a.e.new_tips_bg);
        localIconPreference.Gt(0);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "show voiceprint dot");
      }
    }
    for (;;)
    {
      this.dnn.notifyDataSetChanged();
      return;
      localIconPreference.Gv(8);
      break label56;
      label162:
      break;
      label164:
      localIconPreference.Gt(8);
      localIconPreference.dD("", -1);
    }
  }
  
  private void bzu()
  {
    IconPreference localIconPreference = (IconPreference)this.dnn.add("settings_about_privacy");
    if (localIconPreference != null)
    {
      if (((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uvs, Integer.valueOf(0))).intValue() > ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uvt, Integer.valueOf(0))).intValue()) {
        localIconPreference.Gv(0);
      }
    }
    else {
      return;
    }
    localIconPreference.Gv(8);
  }
  
  private void bzv()
  {
    l.a locala = com.tencent.mm.plugin.account.friend.a.l.WP();
    SwitchKeyValuePreference localSwitchKeyValuePreference = (SwitchKeyValuePreference)this.dnn.add("settings_bind_mobile");
    boolean bool;
    if (localSwitchKeyValuePreference != null)
    {
      if ((locala != l.a.ffT) && (locala != l.a.ffU)) {
        break label78;
      }
      bool = true;
      localSwitchKeyValuePreference.bIU = bool;
      localSwitchKeyValuePreference.aZ();
      if ((locala != l.a.ffT) && (locala != l.a.ffU)) {
        break label83;
      }
    }
    label78:
    label83:
    for (int i = a.i.settings_plugins_enable;; i = a.i.settings_plugins_disable)
    {
      localSwitchKeyValuePreference.setSummary(i);
      return;
      bool = false;
      break;
    }
  }
  
  private void bzw()
  {
    Intent localIntent = new Intent(this, SettingsSwitchAccountUI.class);
    localIntent.putExtra("key_scene", 0);
    startActivity(localIntent);
  }
  
  private boolean bzx()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(11545, new Object[] { Integer.valueOf(1) });
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    if (this.nWx != null)
    {
      this.nWx.show();
      return true;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
    this.nWx = com.tencent.mm.ui.base.h.a(this, getString(a.i.settings_logout_warning_tip), "", getString(a.i.settings_logout), getString(a.i.settings_logout_option_cancel), new SettingsUI.2(this), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(11545, new Object[] { Integer.valueOf(2) });
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
        if (SettingsUI.g(SettingsUI.this) != null) {
          SettingsUI.g(SettingsUI.this).dismiss();
        }
      }
    });
    return true;
  }
  
  private boolean bzy()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(11545, new Object[] { Integer.valueOf(4) });
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
    if (this.lPf == null)
    {
      this.lPf = View.inflate(this.mController.uMN, a.g.settings_close, null);
      this.nWz = ((CheckBox)this.lPf.findViewById(a.f.settings_notify_dialog_cb));
      this.nWz.setChecked(true);
    }
    if (this.nWy == null)
    {
      this.nWy = com.tencent.mm.ui.base.h.a(this.mController.uMN, null, this.lPf, getString(a.i.logout_menu_exit), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new SettingsUI.5
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          com.tencent.mm.modelstat.c.Rn().commitNow();
          if ((SettingsUI.i(SettingsUI.this) != null) && (SettingsUI.i(SettingsUI.this).isChecked()))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "push notify mode exit");
            com.tencent.mm.plugin.report.service.h.nFQ.a(99L, 143L, 1L, false);
            com.tencent.mm.plugin.report.service.h.nFQ.f(11545, new Object[] { Integer.valueOf(6) });
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
            aa.Un().edit().putBoolean("is_in_notify_mode", true).commit();
            SettingsUI.j(SettingsUI.this);
            return;
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "normally exit");
          com.tencent.mm.plugin.report.service.h.nFQ.a(99L, 144L, 1L, false);
          com.tencent.mm.plugin.report.service.h.nFQ.f(11545, new Object[] { Integer.valueOf(7) });
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
          if ((com.tencent.mm.kernel.g.Dk() != null) && (com.tencent.mm.kernel.g.Dk().edx != null)) {
            com.tencent.mm.kernel.g.Dk().edx.bP(false);
          }
          SettingsUI.k(SettingsUI.this);
        }
      }, new SettingsUI.5(this));
      return true;
    }
    this.nWy.show();
    return true;
  }
  
  private void bzz()
  {
    Object localObject = com.tencent.mm.kernel.g.Dk();
    SettingsUI.19 local19 = new SettingsUI.19(this);
    this.nWv = local19;
    ((com.tencent.mm.ah.p)localObject).a(282, local19);
    localObject = new com.tencent.mm.modelsimple.p();
    com.tencent.mm.kernel.g.Dk().a((com.tencent.mm.ah.m)localObject, 0);
  }
  
  private void iG(boolean paramBoolean)
  {
    ag.Zn("welcome_page_show");
    if (paramBoolean) {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().ws();
    }
    for (;;)
    {
      com.tencent.mm.h.a.y localy = new com.tencent.mm.h.a.y();
      localy.bFX.bFY = false;
      com.tencent.mm.sdk.b.a.udP.m(localy);
      com.tencent.mm.plugin.setting.b.eUS.tn();
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().wp();
      finish();
      if (com.tencent.mm.pluginsdk.f.e.rVK != null) {
        com.tencent.mm.pluginsdk.f.e.rVK.i(this.mController.uMN, paramBoolean);
      }
      return;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().k(-1, null);
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    int i = bk.e(paramObject, 0);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    if ((paramm != com.tencent.mm.kernel.g.DP().Dz()) || (i <= 0)) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
    }
    do
    {
      return;
      if (4 == i)
      {
        com.tencent.mm.kernel.g.DP().Dz().get(2, null);
        com.tencent.mm.kernel.g.DP().Dz().get(4, null);
      }
      if (6 == i)
      {
        bzv();
        return;
      }
    } while (64 != i);
    bzt();
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", paramf + " item has been clicked!");
    if ("settings_welab".equals(paramf))
    {
      paramf = new Intent();
      paramPreference = new ArrayList();
      paramPreference.add("labs_browse");
      paramf.putStringArrayListExtra("key_exclude_apps", paramPreference);
      ((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.c.class)).w(this, paramf);
      return true;
    }
    if ("settings_account_info".equals(paramf))
    {
      if ((bk.getInt(com.tencent.mm.m.g.AA().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.DP().Dz().getInt(40, 0) & 0x20000) == 0))
      {
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uow, Boolean.valueOf(false));
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "unset setting account info dot show");
      }
      com.tencent.mm.y.c.BS().b(ac.a.uyT, 266257);
      Y(SettingsAccountInfoUI.class);
      return true;
    }
    if ("settings_account".equals(paramf))
    {
      this.mController.uMN.startActivity(new Intent(this, SettingsPersonalInfoUI.class));
      return true;
    }
    if (paramf.equals("settings_bind_mobile"))
    {
      paramf = new Intent(this, BindMContactIntroUI.class);
      paramf.putExtra("key_upload_scene", 4);
      MMWizardActivity.C(this, paramf);
      return true;
    }
    if (paramf.equals("settings_about_privacy"))
    {
      int i = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uvs, Integer.valueOf(0))).intValue();
      if (i > ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uvt, Integer.valueOf(0))).intValue()) {
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uvt, Integer.valueOf(i));
      }
      startActivity(new Intent(this, SettingsPrivacyUI.class));
      return true;
    }
    if (paramf.equals("settings_about_system"))
    {
      com.tencent.mm.y.c.BS().bd(262158, 266265);
      startActivity(new Intent(this, SettingsAboutSystemUI.class));
      return true;
    }
    if (paramf.equals("settings_about_micromsg"))
    {
      com.tencent.mm.y.c.BS().bd(262145, 266243);
      com.tencent.mm.y.c.BS().bd(262157, 266262);
      this.mController.uMN.startActivity(new Intent(this, SettingsAboutMicroMsgUI.class));
      new ah().postDelayed(new SettingsUI.29(this), 100L);
      return true;
    }
    if (paramf.equals("settings_about_device"))
    {
      paramf = new Intent();
      com.tencent.mm.br.d.b(this.mController.uMN, "exdevice", ".ui.ExdeviceManageDeviceUI", paramf);
      return true;
    }
    if (paramf.equals("settings_logout"))
    {
      if (com.tencent.mm.at.b.Pf())
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "oversea user logout");
        com.tencent.mm.ui.base.h.a(this.mController.uMN, true, getResources().getString(a.i.settings_logout_warning_tip), "", getResources().getString(a.i.settings_logout), getString(a.i.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            SettingsUI.h(SettingsUI.this);
          }
        }, null);
        return true;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(11545, new Object[] { Integer.valueOf(8) });
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
      if (bv.dXJ.Ii().size() > 1) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(10), bv.dXJ.Ij() });
      }
      for (;;)
      {
        this.fnI.cfU();
        return true;
        com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(10), bv.dXJ.Ij() });
      }
    }
    if (paramf.equals("settings_exit")) {
      return bzy();
    }
    if (paramf.equals("settings_logout_option")) {
      return bzx();
    }
    if (paramf.equals("settings_notification_preference"))
    {
      startActivity(new Intent(this, SettingsNotificationUI.class));
      return true;
    }
    if (paramf.equals("settings_chatting"))
    {
      Y(SettingsChattingUI.class);
      return true;
    }
    if (paramf.equals("settings_active_time"))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(11351, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      Y(SettingsActiveTimeUI.class);
      return true;
    }
    if (paramf.equals("settings_feedback")) {
      if ((!com.tencent.mm.sdk.platformtools.e.uen) && (x.cqJ().equals("zh_CN")))
      {
        paramf = getString(a.i.wechat_faq_url);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SettingsUI", "using faq webpage");
        paramPreference = new Intent();
        paramPreference.putExtra("showShare", false);
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("show_feedback", false);
        paramPreference.putExtra("KShowFixToolsBtn", true);
        com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", paramPreference);
      }
    }
    label1171:
    label1178:
    do
    {
      for (;;)
      {
        return false;
        if (x.cqJ().equals("zh_HK"))
        {
          paramf = getString(a.i.wechat_faq_url_cht);
          break;
        }
        if (x.cqJ().equals("zh_TW"))
        {
          paramf = getString(a.i.wechat_faq_url_cht_tw);
          break;
        }
        paramf = getString(a.i.wechat_faq_url_en);
        break;
        if (!paramf.equals("settings_hardcoder"))
        {
          if (!paramf.equals("settings_switch_account")) {
            break label1178;
          }
          if (bv.dXJ.Ii().size() > 1) {
            com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(6), bv.dXJ.Ij() });
          }
          for (;;)
          {
            if (!com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.uyo, true)) {
              break label1171;
            }
            com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyo, Boolean.valueOf(false));
            com.tencent.mm.ui.base.h.a(this, getString(a.i.settings_switch_account_alert_tip), getString(a.i.settings_switch_account_alert_title), getString(a.i.app_i_known), false, new SettingsUI.28(this));
            break;
            com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(6), bv.dXJ.Ij() });
          }
          bzw();
        }
      }
    } while (!paramf.equals("settings_redesign"));
    startActivity(new Intent(this, SettingRedesign.class));
    return true;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_title);
    this.dnn = this.vdd;
    setBackBtn(new SettingsUI.23(this));
    this.fnI = new com.tencent.mm.ui.widget.a.d(this, 1, false);
    this.fnI.phH = new SettingsUI.24(this);
    this.fnI.wmU = new SettingsUI.25(this);
    this.fnI.phI = new SettingsUI.26(this);
    new SettingsUI.27(this);
    bzv();
    byR();
    bzu();
    if (!com.tencent.mm.sdk.platformtools.d.REDESIGN_ENTRANCE) {
      this.dnn.bJ("settings_redesign", true);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.SettingsUI", "settings handle");
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (paramInt2 != -1);
            bzp();
            return;
            paramIntent = com.tencent.mm.pluginsdk.ui.tools.l.f(getApplicationContext(), paramIntent, com.tencent.mm.plugin.n.c.FG());
          } while (paramIntent == null);
          localObject = new Intent();
          ((Intent)localObject).putExtra("CropImageMode", 1);
          ((Intent)localObject).putExtra("CropImage_OutputPath", paramIntent);
          ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
          com.tencent.mm.plugin.setting.b.eUR.a(this.mController.uMN, (Intent)localObject, 4);
          return;
        } while (paramIntent == null);
        localObject = com.tencent.mm.pluginsdk.ui.tools.l.f(getApplicationContext(), paramIntent, com.tencent.mm.plugin.n.c.FG());
      } while (localObject == null);
      Intent localIntent = new Intent();
      localIntent.putExtra("CropImageMode", 1);
      o.JQ();
      localIntent.putExtra("CropImage_OutputPath", com.tencent.mm.ag.d.A(q.Gj(), true));
      localIntent.putExtra("CropImage_ImgPath", (String)localObject);
      com.tencent.mm.plugin.setting.b.eUR.a(this, paramIntent, localIntent, com.tencent.mm.plugin.n.c.FG(), 4, null);
      return;
    } while (paramIntent == null);
    Object localObject = paramIntent.getStringExtra("CropImage_OutputPath");
    if (localObject == null) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SettingsUI", "crop picture failed");
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      new com.tencent.mm.ag.m(this.mController.uMN, (String)localObject).b(1, null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.DP().Dz().a(this);
    com.tencent.mm.y.c.BS().a(this.nWw);
    if ((bk.getInt(com.tencent.mm.m.g.AA().getValue("VoiceprintEntry"), 0) == 1) && ((com.tencent.mm.kernel.g.DP().Dz().getInt(40, 0) & 0x20000) == 0))
    {
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uou, Boolean.valueOf(false));
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsUI", "unset more tab dot");
    }
  }
  
  protected void onDestroy()
  {
    if (com.tencent.mm.kernel.g.DK())
    {
      com.tencent.mm.kernel.g.DP().Dz().b(this);
      com.tencent.mm.y.c.BS().b(this.nWw);
    }
    if (this.eBv != null) {
      com.tencent.mm.kernel.g.Dk().b(281, this.eBv);
    }
    if (this.nTf != null) {
      com.tencent.mm.kernel.g.Dk().b(255, this.nTf);
    }
    if (this.nWA != null) {
      com.tencent.mm.kernel.g.Dk().b(281, this.nWA);
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.DS().R(new SettingsUI.12(this));
  }
  
  public void onResume()
  {
    Object localObject1 = (PersonalPreference)this.dnn.add("settings_account");
    if (localObject1 != null)
    {
      localObject2 = q.Gj();
      ((PersonalPreference)localObject1).ebo = null;
      ((PersonalPreference)localObject1).nSb = -1;
      ((PersonalPreference)localObject1).nSc = ((String)localObject2);
      if (((PersonalPreference)localObject1).kix != null) {
        a.b.a(((PersonalPreference)localObject1).kix, ((PersonalPreference)localObject1).nSc);
      }
    }
    localObject1 = new ek();
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    if (!((ek)localObject1).bKW.bJy)
    {
      localObject1 = this.dnn.add("settings_about_device");
      this.dnn.c((Preference)localObject1);
    }
    bzt();
    bzv();
    byR();
    bzu();
    localObject1 = (IconPreference)this.dnn.add("settings_welab");
    Object localObject2 = (com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.c.class);
    if (((com.tencent.mm.plugin.welab.a.a.c)localObject2).chh())
    {
      ((IconPreference)localObject1).Gt(0);
      ((IconPreference)localObject1).dD(getString(a.i.app_new), a.e.new_tips_bg);
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).chi()) {
        break label261;
      }
      if (!((com.tencent.mm.plugin.welab.a.a.c)localObject2).chg()) {
        break label250;
      }
      ((IconPreference)localObject1).fv(0, a.h.welab_icon_light);
    }
    for (;;)
    {
      localObject1 = this.dnn.add("settings_hardcoder");
      this.dnn.c((Preference)localObject1);
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.SettingsUI", "on resume");
      super.onResume();
      return;
      ((IconPreference)localObject1).Gt(8);
      break;
      label250:
      ((IconPreference)localObject1).fv(0, a.h.welab_icon_grey);
      continue;
      label261:
      ((IconPreference)localObject1).fv(8, -1);
    }
  }
  
  public final int xj()
  {
    return a.k.settings_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI
 * JD-Core Version:    0.7.0.1
 */