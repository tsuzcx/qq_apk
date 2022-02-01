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
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.dn.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.w;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.cqu;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoSettingUI
  extends MMPreference
{
  private c.b cIf;
  private com.tencent.mm.storage.af contact;
  private boolean fqj;
  private cqu gXz;
  private SubscribeMsgRequestResult gZG;
  private com.tencent.mm.msgsubscription.storage.e hHm;
  private int ima;
  private boolean isDeleteCancel;
  private long mWg;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private com.tencent.mm.ui.base.p tipDialog;
  com.tencent.mm.ui.widget.a.d uBy;
  private com.tencent.mm.api.c uzN;
  
  public NewBizInfoSettingUI()
  {
    AppMethodBeat.i(27567);
    this.sp = null;
    this.hHm = new com.tencent.mm.msgsubscription.storage.e(com.tencent.mm.am.b.b.gZO);
    this.uBy = null;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    AppMethodBeat.o(27567);
  }
  
  private static boolean Jr(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private void a(com.tencent.mm.api.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(27572);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.aKk("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.aKk("contact_info_locate");
    bqc localbqc = new bqc();
    localbqc.ika = paramc.field_brandFlag;
    localbqc.mAQ = this.contact.field_username;
    if (Jr(this.ima))
    {
      az.arV();
      com.tencent.mm.model.c.apL().c(new j.a(58, localbqc));
    }
    for (;;)
    {
      com.tencent.mm.am.af.awe().update(paramc, new String[0]);
      localCheckBoxPreference1.lG = paramc.IW();
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.lG = paramc.IX();
      }
      if (paramBoolean)
      {
        initView();
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(27572);
      return;
      az.arV();
      com.tencent.mm.model.c.apL().c(new j.a(47, localbqc));
    }
  }
  
  private void dcv()
  {
    AppMethodBeat.i(27571);
    if ((this.contact != null) && (com.tencent.mm.n.b.ls(this.contact.field_type)) && (!w.sQ(this.contact.field_username)) && (!w.tw(this.contact.field_username))) {
      if ((this.uzN != null) && (this.uzN.Jb())) {
        this.screen.cE("contact_is_mute", false);
      }
    }
    for (;;)
    {
      this.screen.cE("contact_info_verifyuser_weibo", true);
      this.screen.cE("contact_info_subscribe_bizinfo", true);
      this.screen.cE("contact_info_template_recv", true);
      this.screen.cE("contact_info_locate", true);
      AppMethodBeat.o(27571);
      return;
      this.screen.cE("contact_is_mute", true);
      continue;
      this.screen.cE("contact_is_mute", true);
    }
  }
  
  private void nX(boolean paramBoolean)
  {
    AppMethodBeat.i(27573);
    CheckBoxPreference localCheckBoxPreference;
    if (this.contact != null)
    {
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      localCheckBoxPreference = (CheckBoxPreference)this.screen.aKk("contact_is_mute");
      if ((!paramBoolean) || (this.uzN == null) || (!this.uzN.Jb())) {
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
        localCheckBoxPreference.lG = paramBoolean;
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
  
  private void od(boolean paramBoolean)
  {
    AppMethodBeat.i(27576);
    if (this.contact == null)
    {
      AppMethodBeat.o(27576);
      return;
    }
    cry localcry;
    String str;
    if ((this.uzN != null) && (this.uzN.Jb()))
    {
      localcry = new cry();
      if (!this.contact.Ny()) {
        break label111;
      }
      i = 1;
      localcry.EjW = i;
      localcry.Scene = getIntent().getIntExtra("key_start_biz_profile_setting_from_scene", 0);
      com.tencent.mm.am.af.awp();
      str = this.contact.field_username;
      if (!paramBoolean) {
        break label116;
      }
    }
    label111:
    label116:
    for (int i = 15;; i = 16)
    {
      com.tencent.mm.am.k.a(str, localcry, i);
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
    if (this.uzN != null) {
      this.cIf = this.uzN.bU(false);
    }
    boolean bool;
    label144:
    Object localObject;
    if (this.uzN != null) {
      if (this.uzN.Jb())
      {
        this.screen.cE("contact_is_mute", false);
        this.fqj = this.contact.Ny();
        nX(this.fqj);
        ad.d("MicroMsg.NewBizInfoSettingUI", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(getIntent().getBooleanExtra("KIsHardDevice", false)) });
        if ((getIntent() == null) || (!getIntent().getBooleanExtra("KIsHardDevice", false))) {
          break label689;
        }
        ad.d("MicroMsg.NewBizInfoSettingUI", "Hard device biz...");
        if (getIntent() != null) {
          break label385;
        }
        bool = false;
        ad.d("MicroMsg.NewBizInfoSettingUI", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.n.b.ls(this.contact.field_type)), Boolean.valueOf(bool) });
        if ((!com.tencent.mm.n.b.ls(this.contact.field_type)) || (!bool)) {
          break label585;
        }
        if (this.uzN == null) {
          break label524;
        }
        ((CheckBoxPreference)this.screen.aKk("contact_info_subscribe_bizinfo")).lG = this.uzN.IW();
        localObject = (CheckBoxPreference)this.screen.aKk("contact_info_locate");
        if (!this.uzN.bU(false).Ja()) {
          break label455;
        }
        ((CheckBoxPreference)localObject).lG = this.uzN.IX();
      }
    }
    for (;;)
    {
      if (this.uzN.IW())
      {
        if ((this.cIf == null) && (this.uzN != null)) {
          this.cIf = this.uzN.bU(false);
        }
        if ((this.cIf != null) && (this.cIf.Jq()) && (com.tencent.mm.bs.d.axB("brandservice")))
        {
          this.screen.cE("contact_info_template_recv", false);
          AppMethodBeat.o(27570);
          return;
          this.screen.cE("contact_is_mute", true);
          break;
          this.screen.cE("contact_is_mute", true);
          break;
          label385:
          localObject = getIntent().getStringExtra("device_id");
          String str = getIntent().getStringExtra("device_type");
          dn localdn = new dn();
          localdn.dfH.cLR = ((String)localObject);
          localdn.dfH.dfF = str;
          a.ESL.l(localdn);
          bool = localdn.dfI.dfJ;
          break label144;
          label455:
          this.screen.cE("contact_info_locate", true);
          ((CheckBoxPreference)localObject).lG = this.uzN.IX();
          continue;
        }
        this.screen.cE("contact_info_template_recv", true);
        AppMethodBeat.o(27570);
        return;
      }
    }
    this.screen.cE("contact_info_template_recv", true);
    AppMethodBeat.o(27570);
    return;
    label524:
    this.screen.cE("contact_info_subscribe_bizinfo", true);
    this.screen.cE("contact_info_locate", true);
    this.screen.cE("contact_info_template_recv", true);
    this.screen.cE("contact_info_subscribe_msg", true);
    AppMethodBeat.o(27570);
    return;
    label585:
    ad.w("MicroMsg.NewBizInfoSettingUI", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
    dcv();
    if (Jr(this.ima))
    {
      if (this.uzN == null)
      {
        ad.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
        AppMethodBeat.o(27570);
        return;
      }
      ((CheckBoxPreference)this.screen.aKk("contact_info_subscribe_bizinfo")).lG = this.uzN.IW();
      this.screen.cE("contact_info_subscribe_bizinfo", false);
    }
    AppMethodBeat.o(27570);
    return;
    label689:
    if (com.tencent.mm.n.b.ls(this.contact.field_type))
    {
      if (this.uzN != null)
      {
        ((CheckBoxPreference)this.screen.aKk("contact_info_subscribe_bizinfo")).lG = this.uzN.IW();
        if (this.uzN.IW())
        {
          if ((this.cIf == null) && (this.uzN != null)) {
            this.cIf = this.uzN.bU(false);
          }
          if ((this.cIf != null) && (this.cIf.Jq()) && (com.tencent.mm.bs.d.axB("brandservice"))) {
            this.screen.cE("contact_info_template_recv", false);
          }
        }
        for (;;)
        {
          localObject = (CheckBoxPreference)this.screen.aKk("contact_info_locate");
          if (!this.uzN.bU(false).Ja()) {
            break;
          }
          ((CheckBoxPreference)localObject).lG = this.uzN.IX();
          AppMethodBeat.o(27570);
          return;
          this.screen.cE("contact_info_template_recv", true);
          continue;
          this.screen.cE("contact_info_template_recv", true);
        }
        this.screen.cE("contact_info_locate", true);
        ((CheckBoxPreference)localObject).lG = this.uzN.IX();
        AppMethodBeat.o(27570);
      }
    }
    else
    {
      ad.w("MicroMsg.NewBizInfoSettingUI", "%s is not my contact", new Object[] { this.contact.field_username });
      dcv();
      if (Jr(this.ima))
      {
        if (this.uzN == null)
        {
          ad.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
          AppMethodBeat.o(27570);
          return;
        }
        ((CheckBoxPreference)this.screen.aKk("contact_info_subscribe_bizinfo")).lG = this.uzN.IW();
        this.screen.cE("contact_info_subscribe_bizinfo", false);
      }
    }
    AppMethodBeat.o(27570);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27575);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.NewBizInfoSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 1001) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("key_need_update", false);
      paramIntent = (IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)paramIntent.getParcelableExtra("key_biz_data");
      if ((bool) && (paramIntent != null) && (this.uzN != null)) {
        this.hHm.a(this.uzN.field_username, paramIntent.hHP, paramIntent.hHO, false, new e.b()
        {
          public final void a(String paramAnonymousString, SubscribeMsgRequestResult paramAnonymousSubscribeMsgRequestResult)
          {
            AppMethodBeat.i(27561);
            ad.i("MicroMsg.NewBizInfoSettingUI", "alvinluo updateSubscribeMsgList success");
            NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, paramAnonymousSubscribeMsgRequestResult);
            AppMethodBeat.o(27561);
          }
          
          public final void i(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
          {
            AppMethodBeat.i(27562);
            ad.e("MicroMsg.NewBizInfoSettingUI", "alvinluo updateSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
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
    this.mWg = (System.currentTimeMillis() / 1000L);
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
    paramBundle = bt.nullAsNil(getIntent().getStringExtra("Contact_User"));
    az.arV();
    this.contact = com.tencent.mm.model.c.apM().aHY(paramBundle);
    this.uzN = com.tencent.mm.am.f.ei(paramBundle);
    if (this.contact != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.uzN != null) {
        bool2 = true;
      }
      ad.i("MicroMsg.NewBizInfoSettingUI", "user:%s contact:%b, bizInfo:%b", new Object[] { paramBundle, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.ima = getIntent().getIntExtra("Contact_Scene", 9);
      initView();
      od(true);
      AppMethodBeat.o(27568);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27569);
    super.onDestroy();
    od(false);
    AppMethodBeat.o(27569);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(27574);
    paramPreference = paramPreference.mKey;
    ad.i("MicroMsg.NewBizInfoSettingUI", paramPreference + " item has been clicked!");
    Object localObject;
    label123:
    boolean bool;
    if ("contact_info_locate".endsWith(paramPreference))
    {
      localObject = this.uzN;
      if (localObject == null)
      {
        AppMethodBeat.o(27574);
        return true;
      }
      if (((com.tencent.mm.api.c)localObject).IX())
      {
        ((com.tencent.mm.api.c)localObject).field_brandFlag &= 0xFFFFFFFB;
        a((com.tencent.mm.api.c)localObject, false);
        if (!((CheckBoxPreference)paramf.aKk("contact_info_locate")).isChecked()) {
          break label585;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bO(this.contact.field_username, 905);
      }
    }
    else
    {
      if ("contact_info_add_shortcut_btn".equals(paramPreference))
      {
        ad.d("MicroMsg.NewBizInfoSettingUI", "dealAddShortcut, username = " + this.contact.field_username);
        com.tencent.mm.plugin.base.model.b.Y(this, this.contact.field_username);
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27566);
            if (NewBizInfoSettingUI.this.isFinishing())
            {
              AppMethodBeat.o(27566);
              return;
            }
            com.tencent.mm.plugin.base.model.b.X(NewBizInfoSettingUI.this, NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).field_username);
            com.tencent.mm.plugin.base.model.b.J(NewBizInfoSettingUI.this);
            AppMethodBeat.o(27566);
          }
        }, 1000L);
      }
      if ("contact_info_clear_msg".equals(paramPreference))
      {
        if ((this.uzN != null) && (this.uzN.Jb()))
        {
          this.gXz = new cqu();
          this.gXz.EjK = 0;
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn(this.contact.field_username);
          if (localObject != null) {
            this.gXz.EjI = ((ay)localObject).field_unReadCount;
          }
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agq(this.contact.field_username);
          if (localObject != null)
          {
            this.gXz.EjJ = ((bl)localObject).getType();
            if (this.gXz.EjI > 0) {
              this.gXz.EjH = ((int)(System.currentTimeMillis() - ((du)localObject).field_createTime) / 1000);
            }
          }
        }
        com.tencent.mm.ui.base.h.d(this, getString(2131757598), "", getString(2131757597), getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27560);
            NewBizInfoSettingUI.b(NewBizInfoSettingUI.this);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bO(NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).field_username, 910);
            NewBizInfoSettingUI.c(NewBizInfoSettingUI.this);
            AppMethodBeat.o(27560);
          }
        }, null);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bO(this.contact.field_username, 909);
      }
      if ("contact_is_mute".endsWith(paramPreference))
      {
        if (this.fqj) {
          break label601;
        }
        bool = true;
        label426:
        this.fqj = bool;
        if (!this.fqj) {
          break label607;
        }
        w.s(this.contact);
      }
    }
    for (;;)
    {
      nX(this.fqj);
      if ("contact_info_template_recv".equals(paramPreference))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("enterprise_biz_name", this.uzN.field_username);
        com.tencent.mm.bs.d.b(this, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject);
      }
      if (!"contact_info_subscribe_bizinfo".endsWith(paramPreference)) {
        break label814;
      }
      paramPreference = this.uzN;
      if (paramPreference != null) {
        break label617;
      }
      AppMethodBeat.o(27574);
      return true;
      this.uBy = com.tencent.mm.ui.base.h.a(this, getString(2131757139, new Object[] { this.contact.ZX() }), getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27558);
          this.cNV.field_hadAlert = 1;
          this.cNV.field_brandFlag |= 0x4;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, this.cNV, true);
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bO(NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).field_username, 906);
          AppMethodBeat.o(27558);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27559);
          this.cNV.field_hadAlert = 1;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, this.cNV, false);
          AppMethodBeat.o(27559);
        }
      });
      break;
      label585:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bO(this.contact.field_username, 907);
      break label123;
      label601:
      bool = false;
      break label426;
      label607:
      w.t(this.contact);
    }
    label617:
    int i;
    if (paramPreference.IW())
    {
      paramPreference.field_brandFlag |= 0x1;
      if ((this.cIf == null) && (paramPreference != null)) {
        this.cIf = paramPreference.bU(false);
      }
      if ((this.cIf != null) && (this.cIf.Jq()) && (com.tencent.mm.bs.d.axB("brandservice")))
      {
        paramf.cE("contact_info_template_recv", false);
        long l = System.currentTimeMillis() / 1000L;
        localObject = com.tencent.mm.plugin.brandservice.ui.timeline.b.mWx;
        com.tencent.mm.plugin.brandservice.ui.timeline.b.a(paramPreference.field_username, l, 0, this.mWg, 0);
        label720:
        localObject = com.tencent.mm.plugin.report.service.h.vKh;
        String str = paramPreference.field_username;
        if (!paramPreference.IW()) {
          break label861;
        }
        i = 3;
        label740:
        ((com.tencent.mm.plugin.report.service.h)localObject).f(13307, new Object[] { str, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0) });
        a(paramPreference, false);
        if (!((CheckBoxPreference)paramf.aKk("contact_info_subscribe_bizinfo")).isChecked()) {
          break label866;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bO(this.contact.field_username, 901);
      }
    }
    for (;;)
    {
      label814:
      AppMethodBeat.o(27574);
      return false;
      paramf.cE("contact_info_template_recv", true);
      break;
      paramPreference.field_brandFlag &= 0xFFFFFFFE;
      paramf.cE("contact_info_template_recv", true);
      break label720;
      label861:
      i = 4;
      break label740;
      label866:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bO(this.contact.field_username, 902);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI
 * JD-Core Version:    0.7.0.1
 */