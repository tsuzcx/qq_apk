package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.do.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.w;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.cwb;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoSettingUI
  extends MMPreference
{
  private c.b cFm;
  private ai contact;
  private boolean ftN;
  private SubscribeMsgRequestResult hAf;
  private cwb hxY;
  private int iMg;
  private com.tencent.mm.msgsubscription.storage.e ihO;
  private boolean isDeleteCancel;
  private long nyF;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private com.tencent.mm.ui.base.p tipDialog;
  private com.tencent.mm.api.c vIG;
  com.tencent.mm.ui.widget.a.d vKr;
  
  public NewBizInfoSettingUI()
  {
    AppMethodBeat.i(27567);
    this.sp = null;
    this.ihO = new com.tencent.mm.msgsubscription.storage.e(com.tencent.mm.al.b.b.hAn);
    this.vKr = null;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    AppMethodBeat.o(27567);
  }
  
  private static boolean Lq(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private void a(com.tencent.mm.api.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(27572);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.aPN("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.aPN("contact_info_locate");
    but localbut = new but();
    localbut.iKh = paramc.field_brandFlag;
    localbut.ncR = this.contact.field_username;
    if (Lq(this.iMg))
    {
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awA().c(new j.a(58, localbut));
    }
    for (;;)
    {
      af.aCW().update(paramc, new String[0]);
      localCheckBoxPreference1.mF = paramc.IF();
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.mF = paramc.IG();
      }
      if (paramBoolean)
      {
        initView();
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(27572);
      return;
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awA().c(new j.a(47, localbut));
    }
  }
  
  private void dqd()
  {
    AppMethodBeat.i(27571);
    if ((this.contact != null) && (com.tencent.mm.n.b.ln(this.contact.field_type)) && (!w.wT(this.contact.field_username)) && (!w.xz(this.contact.field_username))) {
      if ((this.vIG != null) && (this.vIG.IK())) {
        this.screen.cK("contact_is_mute", false);
      }
    }
    for (;;)
    {
      this.screen.cK("contact_info_verifyuser_weibo", true);
      this.screen.cK("contact_info_subscribe_bizinfo", true);
      this.screen.cK("contact_info_template_recv", true);
      this.screen.cK("contact_info_locate", true);
      AppMethodBeat.o(27571);
      return;
      this.screen.cK("contact_is_mute", true);
      continue;
      this.screen.cK("contact_is_mute", true);
    }
  }
  
  private void oR(boolean paramBoolean)
  {
    AppMethodBeat.i(27573);
    CheckBoxPreference localCheckBoxPreference;
    if (this.contact != null)
    {
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      localCheckBoxPreference = (CheckBoxPreference)this.screen.aPN("contact_is_mute");
      if ((!paramBoolean) || (this.vIG == null) || (!this.vIG.IK())) {
        break label147;
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
        localCheckBoxPreference.mF = paramBoolean;
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(27573);
      return;
      label147:
      setTitleMuteIconVisibility(8);
      if (localCheckBoxPreference != null) {
        this.sp.edit().putBoolean("contact_is_mute", false).commit();
      }
    }
  }
  
  private void oX(boolean paramBoolean)
  {
    AppMethodBeat.i(27576);
    if (this.contact == null)
    {
      AppMethodBeat.o(27576);
      return;
    }
    cxh localcxh;
    String str;
    if ((this.vIG != null) && (this.vIG.IK()))
    {
      localcxh = new cxh();
      if (!this.contact.Nw()) {
        break label111;
      }
      i = 1;
      localcxh.FGU = i;
      localcxh.Scene = getIntent().getIntExtra("key_start_biz_profile_setting_from_scene", 0);
      af.aDh();
      str = this.contact.field_username;
      if (!paramBoolean) {
        break label116;
      }
    }
    label111:
    label116:
    for (int i = 15;; i = 16)
    {
      com.tencent.mm.al.k.a(str, localcxh, i);
      AppMethodBeat.o(27576);
      return;
      i = 0;
      break;
    }
  }
  
  public int getResourceId()
  {
    return 2131951698;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27570);
    if (this.vIG != null) {
      this.cFm = this.vIG.bV(false);
    }
    boolean bool;
    label144:
    Object localObject;
    if (this.vIG != null) {
      if (this.vIG.IK())
      {
        this.screen.cK("contact_is_mute", false);
        this.ftN = this.contact.Nw();
        oR(this.ftN);
        ac.d("MicroMsg.NewBizInfoSettingUI", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(getIntent().getBooleanExtra("KIsHardDevice", false)) });
        if ((getIntent() == null) || (!getIntent().getBooleanExtra("KIsHardDevice", false))) {
          break label689;
        }
        ac.d("MicroMsg.NewBizInfoSettingUI", "Hard device biz...");
        if (getIntent() != null) {
          break label385;
        }
        bool = false;
        ac.d("MicroMsg.NewBizInfoSettingUI", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.n.b.ln(this.contact.field_type)), Boolean.valueOf(bool) });
        if ((!com.tencent.mm.n.b.ln(this.contact.field_type)) || (!bool)) {
          break label585;
        }
        if (this.vIG == null) {
          break label524;
        }
        ((CheckBoxPreference)this.screen.aPN("contact_info_subscribe_bizinfo")).mF = this.vIG.IF();
        localObject = (CheckBoxPreference)this.screen.aPN("contact_info_locate");
        if (!this.vIG.bV(false).IJ()) {
          break label455;
        }
        ((CheckBoxPreference)localObject).mF = this.vIG.IG();
      }
    }
    for (;;)
    {
      if (this.vIG.IF())
      {
        if ((this.cFm == null) && (this.vIG != null)) {
          this.cFm = this.vIG.bV(false);
        }
        if ((this.cFm != null) && (this.cFm.IZ()) && (com.tencent.mm.br.d.aCT("brandservice")))
        {
          this.screen.cK("contact_info_template_recv", false);
          AppMethodBeat.o(27570);
          return;
          this.screen.cK("contact_is_mute", true);
          break;
          this.screen.cK("contact_is_mute", true);
          break;
          label385:
          localObject = getIntent().getStringExtra("device_id");
          String str = getIntent().getStringExtra("device_type");
          do localdo = new do();
          localdo.ddc.cIZ = ((String)localObject);
          localdo.ddc.dda = str;
          a.GpY.l(localdo);
          bool = localdo.ddd.dde;
          break label144;
          label455:
          this.screen.cK("contact_info_locate", true);
          ((CheckBoxPreference)localObject).mF = this.vIG.IG();
          continue;
        }
        this.screen.cK("contact_info_template_recv", true);
        AppMethodBeat.o(27570);
        return;
      }
    }
    this.screen.cK("contact_info_template_recv", true);
    AppMethodBeat.o(27570);
    return;
    label524:
    this.screen.cK("contact_info_subscribe_bizinfo", true);
    this.screen.cK("contact_info_locate", true);
    this.screen.cK("contact_info_template_recv", true);
    this.screen.cK("contact_info_subscribe_msg", true);
    AppMethodBeat.o(27570);
    return;
    label585:
    ac.w("MicroMsg.NewBizInfoSettingUI", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
    dqd();
    if (Lq(this.iMg))
    {
      if (this.vIG == null)
      {
        ac.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
        AppMethodBeat.o(27570);
        return;
      }
      ((CheckBoxPreference)this.screen.aPN("contact_info_subscribe_bizinfo")).mF = this.vIG.IF();
      this.screen.cK("contact_info_subscribe_bizinfo", false);
    }
    AppMethodBeat.o(27570);
    return;
    label689:
    if (com.tencent.mm.n.b.ln(this.contact.field_type))
    {
      if (this.vIG != null)
      {
        ((CheckBoxPreference)this.screen.aPN("contact_info_subscribe_bizinfo")).mF = this.vIG.IF();
        if (this.vIG.IF())
        {
          if ((this.cFm == null) && (this.vIG != null)) {
            this.cFm = this.vIG.bV(false);
          }
          if ((this.cFm != null) && (this.cFm.IZ()) && (com.tencent.mm.br.d.aCT("brandservice"))) {
            this.screen.cK("contact_info_template_recv", false);
          }
        }
        for (;;)
        {
          localObject = (CheckBoxPreference)this.screen.aPN("contact_info_locate");
          if (!this.vIG.bV(false).IJ()) {
            break;
          }
          ((CheckBoxPreference)localObject).mF = this.vIG.IG();
          AppMethodBeat.o(27570);
          return;
          this.screen.cK("contact_info_template_recv", true);
          continue;
          this.screen.cK("contact_info_template_recv", true);
        }
        this.screen.cK("contact_info_locate", true);
        ((CheckBoxPreference)localObject).mF = this.vIG.IG();
        AppMethodBeat.o(27570);
      }
    }
    else
    {
      ac.w("MicroMsg.NewBizInfoSettingUI", "%s is not my contact", new Object[] { this.contact.field_username });
      dqd();
      if (Lq(this.iMg))
      {
        if (this.vIG == null)
        {
          ac.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
          AppMethodBeat.o(27570);
          return;
        }
        ((CheckBoxPreference)this.screen.aPN("contact_info_subscribe_bizinfo")).mF = this.vIG.IF();
        this.screen.cK("contact_info_subscribe_bizinfo", false);
      }
    }
    AppMethodBeat.o(27570);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27575);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.NewBizInfoSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 1001) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("key_need_update", false);
      paramIntent = (IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)paramIntent.getParcelableExtra("key_biz_data");
      if ((bool) && (paramIntent != null) && (this.vIG != null)) {
        this.ihO.a(this.vIG.field_username, paramIntent.iir, paramIntent.iiq, false, new e.b()
        {
          public final void a(String paramAnonymousString, SubscribeMsgRequestResult paramAnonymousSubscribeMsgRequestResult)
          {
            AppMethodBeat.i(27561);
            ac.i("MicroMsg.NewBizInfoSettingUI", "alvinluo updateSubscribeMsgList success");
            NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, paramAnonymousSubscribeMsgRequestResult);
            AppMethodBeat.o(27561);
          }
          
          public final void i(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
          {
            AppMethodBeat.i(27562);
            ac.e("MicroMsg.NewBizInfoSettingUI", "alvinluo updateSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(27562);
          }
        });
      }
    }
    AppMethodBeat.o(27575);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    AppMethodBeat.i(27568);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.nyF = (System.currentTimeMillis() / 1000L);
    setMMTitle(2131757623);
    setTitleDividerVis(false);
    hideActionbarLine();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27557);
        NewBizInfoSettingUI.this.finish();
        AppMethodBeat.o(27557);
        return true;
      }
    });
    paramBundle = bs.nullAsNil(getIntent().getStringExtra("Contact_User"));
    com.tencent.mm.model.az.ayM();
    this.contact = com.tencent.mm.model.c.awB().aNt(paramBundle);
    this.vIG = com.tencent.mm.al.f.dX(paramBundle);
    if (this.contact != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.vIG != null) {
        bool2 = true;
      }
      ac.i("MicroMsg.NewBizInfoSettingUI", "user:%s contact:%b, bizInfo:%b", new Object[] { paramBundle, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.iMg = getIntent().getIntExtra("Contact_Scene", 9);
      initView();
      oX(true);
      AppMethodBeat.o(27568);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27569);
    super.onDestroy();
    oX(false);
    AppMethodBeat.o(27569);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(27574);
    paramPreference = paramPreference.mKey;
    ac.i("MicroMsg.NewBizInfoSettingUI", paramPreference + " item has been clicked!");
    Object localObject;
    label123:
    boolean bool;
    if ("contact_info_locate".endsWith(paramPreference))
    {
      localObject = this.vIG;
      if (localObject == null)
      {
        AppMethodBeat.o(27574);
        return true;
      }
      if (((com.tencent.mm.api.c)localObject).IG())
      {
        ((com.tencent.mm.api.c)localObject).field_brandFlag &= 0xFFFFFFFB;
        a((com.tencent.mm.api.c)localObject, false);
        if (!((CheckBoxPreference)paramf.aPN("contact_info_locate")).isChecked()) {
          break label585;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bS(this.contact.field_username, 905);
      }
    }
    else
    {
      if ("contact_info_add_shortcut_btn".equals(paramPreference))
      {
        ac.d("MicroMsg.NewBizInfoSettingUI", "dealAddShortcut, username = " + this.contact.field_username);
        com.tencent.mm.plugin.base.model.b.Z(this, this.contact.field_username);
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27566);
            if (NewBizInfoSettingUI.this.isFinishing())
            {
              AppMethodBeat.o(27566);
              return;
            }
            com.tencent.mm.plugin.base.model.b.Y(NewBizInfoSettingUI.this, NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).field_username);
            com.tencent.mm.plugin.base.model.b.J(NewBizInfoSettingUI.this);
            AppMethodBeat.o(27566);
          }
        }, 1000L);
      }
      if ("contact_info_clear_msg".equals(paramPreference))
      {
        if ((this.vIG != null) && (this.vIG.IK()))
        {
          this.hxY = new cwb();
          this.hxY.FGI = 0;
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNI(this.contact.field_username);
          if (localObject != null) {
            this.hxY.FGG = ((com.tencent.mm.g.c.az)localObject).field_unReadCount;
          }
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alk(this.contact.field_username);
          if (localObject != null)
          {
            this.hxY.FGH = ((bo)localObject).getType();
            if (this.hxY.FGG > 0) {
              this.hxY.FGF = ((int)(System.currentTimeMillis() - ((dy)localObject).field_createTime) / 1000);
            }
          }
        }
        com.tencent.mm.ui.base.h.d(this, getString(2131757598), "", getString(2131757597), getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27560);
            NewBizInfoSettingUI.b(NewBizInfoSettingUI.this);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bS(NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).field_username, 910);
            NewBizInfoSettingUI.c(NewBizInfoSettingUI.this);
            AppMethodBeat.o(27560);
          }
        }, null);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bS(this.contact.field_username, 909);
      }
      if ("contact_is_mute".endsWith(paramPreference))
      {
        if (this.ftN) {
          break label601;
        }
        bool = true;
        label426:
        this.ftN = bool;
        if (!this.ftN) {
          break label607;
        }
        w.s(this.contact);
      }
    }
    for (;;)
    {
      oR(this.ftN);
      if ("contact_info_template_recv".equals(paramPreference))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("enterprise_biz_name", this.vIG.field_username);
        com.tencent.mm.br.d.b(this, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject);
      }
      if (!"contact_info_subscribe_bizinfo".endsWith(paramPreference)) {
        break label814;
      }
      paramPreference = this.vIG;
      if (paramPreference != null) {
        break label617;
      }
      AppMethodBeat.o(27574);
      return true;
      this.vKr = com.tencent.mm.ui.base.h.a(this, getString(2131757139, new Object[] { this.contact.aaS() }), getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27558);
          this.cLq.field_hadAlert = 1;
          this.cLq.field_brandFlag |= 0x4;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, this.cLq, true);
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bS(NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).field_username, 906);
          AppMethodBeat.o(27558);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27559);
          this.cLq.field_hadAlert = 1;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, this.cLq, false);
          AppMethodBeat.o(27559);
        }
      });
      break;
      label585:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bS(this.contact.field_username, 907);
      break label123;
      label601:
      bool = false;
      break label426;
      label607:
      w.t(this.contact);
    }
    label617:
    int i;
    if (paramPreference.IF())
    {
      paramPreference.field_brandFlag |= 0x1;
      if ((this.cFm == null) && (paramPreference != null)) {
        this.cFm = paramPreference.bV(false);
      }
      if ((this.cFm != null) && (this.cFm.IZ()) && (com.tencent.mm.br.d.aCT("brandservice")))
      {
        paramf.cK("contact_info_template_recv", false);
        long l = System.currentTimeMillis() / 1000L;
        localObject = com.tencent.mm.plugin.brandservice.ui.timeline.b.nyW;
        com.tencent.mm.plugin.brandservice.ui.timeline.b.a(paramPreference.field_username, l, 0, this.nyF, 0);
        label720:
        localObject = com.tencent.mm.plugin.report.service.h.wUl;
        String str = paramPreference.field_username;
        if (!paramPreference.IF()) {
          break label861;
        }
        i = 3;
        label740:
        ((com.tencent.mm.plugin.report.service.h)localObject).f(13307, new Object[] { str, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0) });
        a(paramPreference, false);
        if (!((CheckBoxPreference)paramf.aPN("contact_info_subscribe_bizinfo")).isChecked()) {
          break label866;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bS(this.contact.field_username, 901);
      }
    }
    for (;;)
    {
      label814:
      AppMethodBeat.o(27574);
      return false;
      paramf.cK("contact_info_template_recv", true);
      break;
      paramPreference.field_brandFlag &= 0xFFFFFFFE;
      paramf.cK("contact_info_template_recv", true);
      break label720;
      label861:
      i = 4;
      break label740;
      label866:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bS(this.contact.field_username, 902);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI
 * JD-Core Version:    0.7.0.1
 */