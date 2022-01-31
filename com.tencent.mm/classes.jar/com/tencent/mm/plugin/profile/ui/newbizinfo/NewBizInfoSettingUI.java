package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.de;
import com.tencent.mm.h.a.de.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.protocal.c.aww;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.statusbar.DrawStatusBarPreference;

public class NewBizInfoSettingUI
  extends DrawStatusBarPreference
{
  private boolean dnJ;
  private com.tencent.mm.ui.base.preference.f dnn;
  private ad dnp;
  private d.b eeW;
  private int fhj;
  private boolean isDeleteCancel = false;
  private com.tencent.mm.ai.d mVy;
  com.tencent.mm.ui.widget.a.c mWU = null;
  private p tipDialog = null;
  
  private void a(com.tencent.mm.ai.d paramd, boolean paramBoolean)
  {
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.dnn.add("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.dnn.add("contact_info_locate");
    aww localaww = new aww();
    localaww.ffv = paramd.field_brandFlag;
    localaww.hPY = this.dnp.field_username;
    if (wa(this.fhj))
    {
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new i.a(58, localaww));
    }
    for (;;)
    {
      z.My().c(paramd, new String[0]);
      localCheckBoxPreference1.rHo = paramd.Lq();
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.rHo = paramd.Lr();
      }
      if (paramBoolean)
      {
        initView();
        this.dnn.notifyDataSetChanged();
      }
      return;
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new i.a(47, localaww));
    }
  }
  
  private void bsy()
  {
    if ((this.dnp != null) && (com.tencent.mm.n.a.gR(this.dnp.field_type)) && (!com.tencent.mm.model.s.hx(this.dnp.field_username)) && (!com.tencent.mm.model.s.ic(this.dnp.field_username))) {
      this.dnn.bJ("contact_is_mute", false);
    }
    for (;;)
    {
      this.dnn.bJ("contact_info_verifyuser_weibo", true);
      this.dnn.bJ("contact_info_subscribe_bizinfo", true);
      this.dnn.bJ("contact_info_template_recv", true);
      this.dnn.bJ("contact_info_locate", true);
      return;
      this.dnn.bJ("contact_is_mute", true);
      if ((this.dnp != null) && (!com.tencent.mm.n.a.gR(this.dnp.field_type)) && (wa(this.fhj))) {
        this.dnn.bJ("contact_info_expose_btn", false);
      } else {
        this.dnn.bJ("contact_info_expose_btn", true);
      }
    }
  }
  
  private static boolean wa(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramPreference = paramPreference.mKey;
    y.i("MicroMsg.mmui.MMPreference", paramPreference + " item has been clicked!");
    Object localObject;
    if ("contact_info_locate".endsWith(paramPreference))
    {
      localObject = this.mVy;
      if (localObject != null) {}
    }
    label109:
    boolean bool;
    label138:
    label317:
    label337:
    label373:
    do
    {
      return true;
      if (!((com.tencent.mm.ai.d)localObject).Lr()) {
        break label633;
      }
      ((com.tencent.mm.ai.d)localObject).field_brandFlag &= 0xFFFFFFFB;
      a((com.tencent.mm.ai.d)localObject, false);
      if (!((CheckBoxPreference)paramf.add("contact_info_locate")).isChecked()) {
        break label692;
      }
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cg(this.dnp.field_username, 905);
      if ("contact_info_expose_btn".equals(paramPreference))
      {
        if ((this.dnp != null) && (!bk.bl(this.dnp.field_username))) {
          break label708;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cg(this.dnp.field_username, 908);
      }
      if ("contact_info_add_shortcut_btn".equals(paramPreference))
      {
        y.d("MicroMsg.mmui.MMPreference", "dealAddShortcut, username = " + this.dnp.field_username);
        b.U(this, this.dnp.field_username);
        ai.l(new NewBizInfoSettingUI.7(this), 1000L);
      }
      if ("contact_info_clear_msg".equals(paramPreference))
      {
        getString(R.l.fmt_delcontactmsg_confirm, new Object[] { this.dnp.Bq() });
        com.tencent.mm.ui.base.h.a(this, getString(R.l.contact_info_biz_clear_msg_tips), "", getString(R.l.contact_info_biz_clear_msg), getString(R.l.app_cancel), new NewBizInfoSettingUI.4(this), null);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cg(this.dnp.field_username, 909);
      }
      if ("contact_is_mute".endsWith(paramPreference))
      {
        if (this.dnJ) {
          break label771;
        }
        bool = true;
        this.dnJ = bool;
        if (!this.dnJ) {
          break label777;
        }
        com.tencent.mm.model.s.o(this.dnp);
        bool = this.dnJ;
        if (this.dnp != null)
        {
          if ((!bool) || (com.tencent.mm.ai.f.eW(this.dnp.field_username))) {
            break label787;
          }
          setTitleMuteIconVisibility(0);
          localObject = (CheckBoxPreference)this.dnn.add("contact_is_mute");
          if (localObject != null) {
            ((CheckBoxPreference)localObject).rHo = bool;
          }
        }
      }
      if ("contact_info_template_recv".equals(paramPreference))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("enterprise_biz_name", this.mVy.field_username);
        com.tencent.mm.br.d.b(this, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject);
      }
      if (!"contact_info_subscribe_bizinfo".endsWith(paramPreference)) {
        break;
      }
      paramPreference = this.mVy;
    } while (paramPreference == null);
    label537:
    int i;
    if (paramPreference.Lq())
    {
      paramPreference.field_brandFlag |= 0x1;
      if ((this.eeW == null) && (paramPreference != null)) {
        this.eeW = paramPreference.bS(false);
      }
      if ((this.eeW != null) && (this.eeW.LK()) && (com.tencent.mm.br.d.SP("brandservice")))
      {
        paramf.bJ("contact_info_template_recv", false);
        localObject = com.tencent.mm.plugin.report.service.h.nFQ;
        String str = paramPreference.field_username;
        if (!paramPreference.Lq()) {
          break label831;
        }
        i = 3;
        label557:
        ((com.tencent.mm.plugin.report.service.h)localObject).f(13307, new Object[] { str, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0) });
        a(paramPreference, false);
        if (!((CheckBoxPreference)paramf.add("contact_info_subscribe_bizinfo")).isChecked()) {
          break label836;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cg(this.dnp.field_username, 901);
      }
    }
    for (;;)
    {
      return false;
      label633:
      this.mWU = com.tencent.mm.ui.base.h.a(this, getString(R.l.chatting_biz_report_location_confirm, new Object[] { this.dnp.Bq() }), getString(R.l.app_tip), new NewBizInfoSettingUI.2(this, (com.tencent.mm.ai.d)localObject), new NewBizInfoSettingUI.3(this, (com.tencent.mm.ai.d)localObject));
      break;
      label692:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cg(this.dnp.field_username, 907);
      break label109;
      label708:
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[] { this.dnp.field_username }));
      ((Intent)localObject).putExtra("showShare", false);
      com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      break label138;
      label771:
      bool = false;
      break label317;
      label777:
      com.tencent.mm.model.s.p(this.dnp);
      break label337;
      label787:
      setTitleMuteIconVisibility(8);
      break label373;
      paramf.bJ("contact_info_template_recv", true);
      break label537;
      paramPreference.field_brandFlag &= 0xFFFFFFFE;
      paramf.bJ("contact_info_template_recv", true);
      break label537;
      label831:
      i = 4;
      break label557;
      label836:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cg(this.dnp.field_username, 902);
    }
  }
  
  protected final void initView()
  {
    if (this.mVy != null) {
      this.eeW = this.mVy.bS(false);
    }
    if (this.mVy != null)
    {
      this.dnn.bJ("contact_is_mute", true);
      this.dnJ = false;
    }
    y.d("MicroMsg.mmui.MMPreference", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(getIntent().getBooleanExtra("KIsHardDevice", false)) });
    boolean bool;
    Object localObject;
    if ((getIntent() != null) && (getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      y.d("MicroMsg.mmui.MMPreference", "Hard device biz...");
      if (getIntent() == null)
      {
        bool = false;
        y.d("MicroMsg.mmui.MMPreference", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.n.a.gR(this.dnp.field_type)), Boolean.valueOf(bool) });
        if ((!com.tencent.mm.n.a.gR(this.dnp.field_type)) || (!bool)) {
          break label467;
        }
        if (this.mVy == null) {
          break label430;
        }
        ((CheckBoxPreference)this.dnn.add("contact_info_subscribe_bizinfo")).rHo = this.mVy.Lq();
        localObject = (CheckBoxPreference)this.dnn.add("contact_info_locate");
        if (!this.mVy.bS(false).Lu()) {
          break label378;
        }
        ((CheckBoxPreference)localObject).rHo = this.mVy.Lr();
        label233:
        if (!this.mVy.Lq()) {
          break label417;
        }
        if ((this.eeW == null) && (this.mVy != null)) {
          this.eeW = this.mVy.bS(false);
        }
        if ((this.eeW == null) || (!this.eeW.LK()) || (!com.tencent.mm.br.d.SP("brandservice"))) {
          break label404;
        }
        this.dnn.bJ("contact_info_template_recv", false);
      }
    }
    label378:
    do
    {
      do
      {
        do
        {
          return;
          localObject = getIntent().getStringExtra("device_id");
          String str = getIntent().getStringExtra("device_type");
          de localde = new de();
          localde.bJr.bwK = ((String)localObject);
          localde.bJr.bJp = str;
          com.tencent.mm.sdk.b.a.udP.m(localde);
          bool = localde.bJs.bJt;
          break;
          this.dnn.bJ("contact_info_locate", true);
          ((CheckBoxPreference)localObject).rHo = this.mVy.Lr();
          break label233;
          this.dnn.bJ("contact_info_template_recv", true);
          return;
          this.dnn.bJ("contact_info_template_recv", true);
          return;
          this.dnn.bJ("contact_info_subscribe_bizinfo", true);
          this.dnn.bJ("contact_info_locate", true);
          this.dnn.bJ("contact_info_template_recv", true);
          return;
          y.w("MicroMsg.mmui.MMPreference", "%s is not my hard biz contact", new Object[] { this.dnp.field_username });
          bsy();
        } while (!wa(this.fhj));
        if (this.mVy == null)
        {
          y.e("MicroMsg.mmui.MMPreference", "bizinfo is null in temp session");
          return;
        }
        ((CheckBoxPreference)this.dnn.add("contact_info_subscribe_bizinfo")).rHo = this.mVy.Lq();
        this.dnn.bJ("contact_info_subscribe_bizinfo", false);
        return;
        if (!com.tencent.mm.n.a.gR(this.dnp.field_type)) {
          break label769;
        }
      } while (this.mVy == null);
      ((CheckBoxPreference)this.dnn.add("contact_info_subscribe_bizinfo")).rHo = this.mVy.Lq();
      if (this.mVy.Lq())
      {
        if ((this.eeW == null) && (this.mVy != null)) {
          this.eeW = this.mVy.bS(false);
        }
        if ((this.eeW != null) && (this.eeW.LK()) && (com.tencent.mm.br.d.SP("brandservice"))) {
          this.dnn.bJ("contact_info_template_recv", false);
        }
      }
      for (;;)
      {
        localObject = (CheckBoxPreference)this.dnn.add("contact_info_locate");
        if (!this.mVy.bS(false).Lu()) {
          break;
        }
        ((CheckBoxPreference)localObject).rHo = this.mVy.Lr();
        return;
        this.dnn.bJ("contact_info_template_recv", true);
        continue;
        this.dnn.bJ("contact_info_template_recv", true);
      }
      this.dnn.bJ("contact_info_locate", true);
      ((CheckBoxPreference)localObject).rHo = this.mVy.Lr();
      return;
      y.w("MicroMsg.mmui.MMPreference", "%s is not my contact", new Object[] { this.dnp.field_username });
      bsy();
    } while (!wa(this.fhj));
    label404:
    label417:
    label430:
    label467:
    if (this.mVy == null)
    {
      y.e("MicroMsg.mmui.MMPreference", "bizinfo is null in temp session");
      return;
    }
    label769:
    ((CheckBoxPreference)this.dnn.add("contact_info_subscribe_bizinfo")).rHo = this.mVy.Lq();
    this.dnn.bJ("contact_info_subscribe_bizinfo", false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    ta(a.mZx);
    if (Build.VERSION.SDK_INT >= 21) {
      com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, getWindow().getStatusBarColor(), com.tencent.mm.ui.statusbar.d.c(getWindow()));
    }
    setMMTitle(R.l.contact_info_biz_setting);
    oX(-16777216);
    com.tencent.mm.ui.s.czy();
    czo();
    mS(false);
    setBackBtn(new NewBizInfoSettingUI.1(this), R.k.actionbar_icon_dark_back);
    paramBundle = bk.pm(getIntent().getStringExtra("Contact_User"));
    au.Hx();
    this.dnp = com.tencent.mm.model.c.Fw().abl(paramBundle);
    this.mVy = com.tencent.mm.ai.f.kX(paramBundle);
    boolean bool1;
    if (this.dnp != null)
    {
      bool1 = true;
      if (this.mVy == null) {
        break label206;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.mmui.MMPreference", "user:%s contact:%b, bizInfo:%b", new Object[] { paramBundle, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.fhj = getIntent().getIntExtra("Contact_Scene", 9);
      initView();
      return;
      bool1 = false;
      break;
      label206:
      bool2 = false;
    }
  }
  
  public final int xj()
  {
    return R.o.newbizinfo_setting_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI
 * JD-Core Version:    0.7.0.1
 */