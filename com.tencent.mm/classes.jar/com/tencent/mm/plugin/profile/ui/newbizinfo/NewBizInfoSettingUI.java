package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.dh.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.protocal.protobuf.cbg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoSettingUI
  extends MMPreference
{
  private ad contact;
  private boolean efg;
  private d.b fuY;
  private caf fwz;
  private int gyR;
  private boolean isDeleteCancel = false;
  private com.tencent.mm.aj.d pyd;
  com.tencent.mm.ui.widget.b.c pzP = null;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  private p tipDialog = null;
  
  private static boolean BE(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private void a(com.tencent.mm.aj.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(23925);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.atx("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.atx("contact_info_locate");
    bdm localbdm = new bdm();
    localbdm.gxd = paramd.field_brandFlag;
    localbdm.jJA = this.contact.field_username;
    if (BE(this.gyR))
    {
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new j.a(58, localbdm));
    }
    for (;;)
    {
      z.afi().update(paramd, new String[0]);
      localCheckBoxPreference1.vxW = paramd.adY();
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.vxW = paramd.adZ();
      }
      if (paramBoolean)
      {
        initView();
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(23925);
      return;
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new j.a(47, localbdm));
    }
  }
  
  private void cce()
  {
    AppMethodBeat.i(23923);
    if ((this.contact != null) && (com.tencent.mm.n.a.je(this.contact.field_type)) && (!t.og(this.contact.field_username)) && (!t.oL(this.contact.field_username))) {
      if ((this.pyd != null) && (this.pyd.aed())) {
        this.screen.cl("contact_is_mute", false);
      }
    }
    for (;;)
    {
      this.screen.cl("contact_info_verifyuser_weibo", true);
      this.screen.cl("contact_info_subscribe_bizinfo", true);
      this.screen.cl("contact_info_template_recv", true);
      this.screen.cl("contact_info_locate", true);
      AppMethodBeat.o(23923);
      return;
      this.screen.cl("contact_is_mute", true);
      continue;
      this.screen.cl("contact_is_mute", true);
      if ((this.contact != null) && (!com.tencent.mm.n.a.je(this.contact.field_type)) && (BE(this.gyR))) {
        this.screen.cl("contact_info_expose_btn", false);
      } else {
        this.screen.cl("contact_info_expose_btn", true);
      }
    }
  }
  
  private void kc(boolean paramBoolean)
  {
    AppMethodBeat.i(23926);
    CheckBoxPreference localCheckBoxPreference;
    if (this.contact != null)
    {
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      localCheckBoxPreference = (CheckBoxPreference)this.screen.atx("contact_is_mute");
      if ((!paramBoolean) || (this.pyd == null) || (!this.pyd.aed())) {
        break label145;
      }
      setTitleMuteIconVisibility(0);
      if (localCheckBoxPreference != null) {
        this.sp.edit().putBoolean("contact_is_mute", true).commit();
      }
    }
    for (;;)
    {
      if (localCheckBoxPreference != null)
      {
        localCheckBoxPreference.vxW = paramBoolean;
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(23926);
      return;
      label145:
      setTitleMuteIconVisibility(8);
      if (localCheckBoxPreference != null) {
        this.sp.edit().putBoolean("contact_is_mute", false).commit();
      }
    }
  }
  
  private void kh(boolean paramBoolean)
  {
    AppMethodBeat.i(23928);
    if (this.contact == null)
    {
      AppMethodBeat.o(23928);
      return;
    }
    cbg localcbg;
    String str;
    if ((this.pyd != null) && (this.pyd.aed()))
    {
      localcbg = new cbg();
      if (!this.contact.DP()) {
        break label111;
      }
      i = 1;
      localcbg.xLY = i;
      localcbg.Scene = getIntent().getIntExtra("key_start_biz_profile_setting_from_scene", 0);
      z.aft();
      str = this.contact.field_username;
      if (!paramBoolean) {
        break label116;
      }
    }
    label111:
    label116:
    for (int i = 15;; i = 16)
    {
      k.a(str, localcbg, i);
      AppMethodBeat.o(23928);
      return;
      i = 0;
      break;
    }
  }
  
  public int getResourceId()
  {
    return 2131165255;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23922);
    if (this.pyd != null) {
      this.fuY = this.pyd.cU(false);
    }
    boolean bool;
    label142:
    Object localObject;
    if (this.pyd != null) {
      if (this.pyd.aed())
      {
        this.screen.cl("contact_is_mute", false);
        this.efg = this.contact.DP();
        kc(this.efg);
        ab.d("MicroMsg.mmui.MMPreference", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(getIntent().getBooleanExtra("KIsHardDevice", false)) });
        if ((getIntent() == null) || (!getIntent().getBooleanExtra("KIsHardDevice", false))) {
          break label657;
        }
        ab.d("MicroMsg.mmui.MMPreference", "Hard device biz...");
        if (getIntent() != null) {
          break label377;
        }
        bool = false;
        ab.d("MicroMsg.mmui.MMPreference", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.n.a.je(this.contact.field_type)), Boolean.valueOf(bool) });
        if ((!com.tencent.mm.n.a.je(this.contact.field_type)) || (!bool)) {
          break label554;
        }
        if (this.pyd == null) {
          break label511;
        }
        ((CheckBoxPreference)this.screen.atx("contact_info_subscribe_bizinfo")).vxW = this.pyd.adY();
        localObject = (CheckBoxPreference)this.screen.atx("contact_info_locate");
        if (!this.pyd.cU(false).aec()) {
          break label447;
        }
        ((CheckBoxPreference)localObject).vxW = this.pyd.adZ();
      }
    }
    for (;;)
    {
      if (this.pyd.adY())
      {
        if ((this.fuY == null) && (this.pyd != null)) {
          this.fuY = this.pyd.cU(false);
        }
        if ((this.fuY != null) && (this.fuY.aes()) && (com.tencent.mm.bq.d.ahR("brandservice")))
        {
          this.screen.cl("contact_info_template_recv", false);
          AppMethodBeat.o(23922);
          return;
          this.screen.cl("contact_is_mute", true);
          break;
          this.screen.cl("contact_is_mute", true);
          break;
          label377:
          localObject = getIntent().getStringExtra("device_id");
          String str = getIntent().getStringExtra("device_type");
          dh localdh = new dh();
          localdh.cqL.bYu = ((String)localObject);
          localdh.cqL.cqJ = str;
          com.tencent.mm.sdk.b.a.ymk.l(localdh);
          bool = localdh.cqM.cqN;
          break label142;
          label447:
          this.screen.cl("contact_info_locate", true);
          ((CheckBoxPreference)localObject).vxW = this.pyd.adZ();
          continue;
        }
        this.screen.cl("contact_info_template_recv", true);
        AppMethodBeat.o(23922);
        return;
      }
    }
    this.screen.cl("contact_info_template_recv", true);
    AppMethodBeat.o(23922);
    return;
    label511:
    this.screen.cl("contact_info_subscribe_bizinfo", true);
    this.screen.cl("contact_info_locate", true);
    this.screen.cl("contact_info_template_recv", true);
    AppMethodBeat.o(23922);
    return;
    label554:
    ab.w("MicroMsg.mmui.MMPreference", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
    cce();
    if (BE(this.gyR))
    {
      if (this.pyd == null)
      {
        ab.e("MicroMsg.mmui.MMPreference", "bizinfo is null in temp session");
        AppMethodBeat.o(23922);
        return;
      }
      ((CheckBoxPreference)this.screen.atx("contact_info_subscribe_bizinfo")).vxW = this.pyd.adY();
      this.screen.cl("contact_info_subscribe_bizinfo", false);
    }
    AppMethodBeat.o(23922);
    return;
    label657:
    if (com.tencent.mm.n.a.je(this.contact.field_type))
    {
      if (this.pyd != null)
      {
        ((CheckBoxPreference)this.screen.atx("contact_info_subscribe_bizinfo")).vxW = this.pyd.adY();
        if (this.pyd.adY())
        {
          if ((this.fuY == null) && (this.pyd != null)) {
            this.fuY = this.pyd.cU(false);
          }
          if ((this.fuY != null) && (this.fuY.aes()) && (com.tencent.mm.bq.d.ahR("brandservice"))) {
            this.screen.cl("contact_info_template_recv", false);
          }
        }
        for (;;)
        {
          localObject = (CheckBoxPreference)this.screen.atx("contact_info_locate");
          if (!this.pyd.cU(false).aec()) {
            break;
          }
          ((CheckBoxPreference)localObject).vxW = this.pyd.adZ();
          AppMethodBeat.o(23922);
          return;
          this.screen.cl("contact_info_template_recv", true);
          continue;
          this.screen.cl("contact_info_template_recv", true);
        }
        this.screen.cl("contact_info_locate", true);
        ((CheckBoxPreference)localObject).vxW = this.pyd.adZ();
        AppMethodBeat.o(23922);
      }
    }
    else
    {
      ab.w("MicroMsg.mmui.MMPreference", "%s is not my contact", new Object[] { this.contact.field_username });
      cce();
      if (BE(this.gyR))
      {
        if (this.pyd == null)
        {
          ab.e("MicroMsg.mmui.MMPreference", "bizinfo is null in temp session");
          AppMethodBeat.o(23922);
          return;
        }
        ((CheckBoxPreference)this.screen.atx("contact_info_subscribe_bizinfo")).vxW = this.pyd.adY();
        this.screen.cl("contact_info_subscribe_bizinfo", false);
      }
    }
    AppMethodBeat.o(23922);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    AppMethodBeat.i(23920);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    setActionbarColor(a.pDd);
    setMMTitle(2131298564);
    setMMTitleColor(-16777216);
    setTitleDividerVis(false);
    hideActionbarLine();
    setIsDarkActionbarBg(false);
    setBackBtn(new NewBizInfoSettingUI.1(this), 2131230737);
    paramBundle = bo.nullAsNil(getIntent().getStringExtra("Contact_User"));
    aw.aaz();
    this.contact = com.tencent.mm.model.c.YA().arw(paramBundle);
    this.pyd = com.tencent.mm.aj.f.rS(paramBundle);
    if (this.contact != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.pyd != null) {
        bool2 = true;
      }
      ab.i("MicroMsg.mmui.MMPreference", "user:%s contact:%b, bizInfo:%b", new Object[] { paramBundle, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.gyR = getIntent().getIntExtra("Contact_Scene", 9);
      initView();
      kh(true);
      AppMethodBeat.o(23920);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23921);
    super.onDestroy();
    kh(false);
    AppMethodBeat.o(23921);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(23927);
    paramPreference = paramPreference.mKey;
    ab.i("MicroMsg.mmui.MMPreference", paramPreference + " item has been clicked!");
    Object localObject;
    label123:
    boolean bool;
    if ("contact_info_locate".endsWith(paramPreference))
    {
      localObject = this.pyd;
      if (localObject == null)
      {
        AppMethodBeat.o(23927);
        return true;
      }
      if (((com.tencent.mm.aj.d)localObject).adZ())
      {
        ((com.tencent.mm.aj.d)localObject).field_brandFlag &= 0xFFFFFFFB;
        a((com.tencent.mm.aj.d)localObject, false);
        if (!((CheckBoxPreference)paramf.atx("contact_info_locate")).isChecked()) {
          break label626;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(this.contact.field_username, 905);
      }
    }
    else
    {
      if ("contact_info_expose_btn".equals(paramPreference))
      {
        if ((this.contact != null) && (!bo.isNullOrNil(this.contact.field_username))) {
          break label642;
        }
        label153:
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(this.contact.field_username, 908);
      }
      if ("contact_info_add_shortcut_btn".equals(paramPreference))
      {
        ab.d("MicroMsg.mmui.MMPreference", "dealAddShortcut, username = " + this.contact.field_username);
        b.Z(this, this.contact.field_username);
        al.p(new NewBizInfoSettingUI.7(this), 1000L);
      }
      if ("contact_info_clear_msg".equals(paramPreference))
      {
        if ((this.pyd != null) && (this.pyd.aed()))
        {
          this.fwz = new caf();
          this.fwz.xLM = 0;
          localObject = ((j)g.E(j.class)).YF().arH(this.contact.field_username);
          if (localObject != null) {
            this.fwz.xLK = ((au)localObject).field_unReadCount;
          }
          localObject = ((j)g.E(j.class)).bPQ().Tm(this.contact.field_username);
          if (localObject != null)
          {
            this.fwz.xLL = ((bi)localObject).getType();
            if (this.fwz.xLK > 0) {
              this.fwz.xLJ = ((int)(System.currentTimeMillis() - ((dd)localObject).field_createTime) / 1000);
            }
          }
        }
        com.tencent.mm.ui.base.h.d(this, getString(2131298539), "", getString(2131298538), getString(2131296888), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(23915);
            NewBizInfoSettingUI.b(NewBizInfoSettingUI.this);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).field_username, 910);
            NewBizInfoSettingUI.c(NewBizInfoSettingUI.this);
            AppMethodBeat.o(23915);
          }
        }, null);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(this.contact.field_username, 909);
      }
      if ("contact_is_mute".endsWith(paramPreference))
      {
        if (this.efg) {
          break label705;
        }
        bool = true;
        label468:
        this.efg = bool;
        if (!this.efg) {
          break label711;
        }
        t.o(this.contact);
      }
    }
    for (;;)
    {
      kc(this.efg);
      if ("contact_info_template_recv".equals(paramPreference))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("enterprise_biz_name", this.pyd.field_username);
        com.tencent.mm.bq.d.b(this, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject);
      }
      if (!"contact_info_subscribe_bizinfo".endsWith(paramPreference)) {
        break label887;
      }
      paramPreference = this.pyd;
      if (paramPreference != null) {
        break label721;
      }
      AppMethodBeat.o(23927);
      return true;
      this.pzP = com.tencent.mm.ui.base.h.a(this, getString(2131298150, new Object[] { this.contact.Of() }), getString(2131297087), new NewBizInfoSettingUI.2(this, (com.tencent.mm.aj.d)localObject), new NewBizInfoSettingUI.3(this, (com.tencent.mm.aj.d)localObject));
      break;
      label626:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(this.contact.field_username, 907);
      break label123;
      label642:
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[] { this.contact.field_username }));
      ((Intent)localObject).putExtra("showShare", false);
      com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      break label153;
      label705:
      bool = false;
      break label468;
      label711:
      t.p(this.contact);
    }
    label721:
    int i;
    if (paramPreference.adY())
    {
      paramPreference.field_brandFlag |= 0x1;
      if ((this.fuY == null) && (paramPreference != null)) {
        this.fuY = paramPreference.cU(false);
      }
      if ((this.fuY != null) && (this.fuY.aes()) && (com.tencent.mm.bq.d.ahR("brandservice")))
      {
        paramf.cl("contact_info_template_recv", false);
        localObject = com.tencent.mm.plugin.report.service.h.qsU;
        String str = paramPreference.field_username;
        if (!paramPreference.adY()) {
          break label930;
        }
        i = 3;
        label813:
        ((com.tencent.mm.plugin.report.service.h)localObject).e(13307, new Object[] { str, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0) });
        a(paramPreference, false);
        if (!((CheckBoxPreference)paramf.atx("contact_info_subscribe_bizinfo")).isChecked()) {
          break label935;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(this.contact.field_username, 901);
      }
    }
    for (;;)
    {
      label887:
      AppMethodBeat.o(23927);
      return false;
      paramf.cl("contact_info_template_recv", true);
      break;
      paramPreference.field_brandFlag &= 0xFFFFFFFE;
      paramf.cl("contact_info_template_recv", true);
      break;
      label930:
      i = 4;
      break label813;
      label935:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(this.contact.field_username, 902);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI
 * JD-Core Version:    0.7.0.1
 */