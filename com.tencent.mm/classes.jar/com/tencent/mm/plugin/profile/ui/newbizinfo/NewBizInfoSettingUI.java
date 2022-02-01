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
import com.tencent.mm.al.ag;
import com.tencent.mm.al.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.ds.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.x;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.storage.e;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.dci;
import com.tencent.mm.protocal.protobuf.ddo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoSettingUI
  extends MMPreference
{
  private c.b cRb;
  private an contact;
  private boolean fOX;
  private dci hTl;
  private SubscribeMsgRequestResult hVs;
  private e iEb;
  private boolean isDeleteCancel;
  private int jij;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private p tipDialog;
  private com.tencent.mm.api.c xfE;
  com.tencent.mm.ui.widget.a.d xhr;
  private long xlT;
  private long xlU;
  
  public NewBizInfoSettingUI()
  {
    AppMethodBeat.i(27567);
    this.sp = null;
    this.iEb = new e(com.tencent.mm.al.b.b.hVA);
    this.xhr = null;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    AppMethodBeat.o(27567);
  }
  
  private static boolean Ny(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private void a(com.tencent.mm.api.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(27572);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.aXe("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.aXe("contact_info_locate");
    cac localcac = new cac();
    localcac.jgj = paramc.field_brandFlag;
    localcac.nIJ = this.contact.field_username;
    if (Ny(this.jij))
    {
      bc.aCg();
      com.tencent.mm.model.c.azE().d(new k.a(58, localcac));
    }
    for (;;)
    {
      ag.aGp().update(paramc, new String[0]);
      localCheckBoxPreference1.setChecked(paramc.Kn());
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.setChecked(paramc.Ko());
      }
      if (paramBoolean)
      {
        initView();
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(27572);
      return;
      bc.aCg();
      com.tencent.mm.model.c.azE().d(new k.a(47, localcac));
    }
  }
  
  private void dDX()
  {
    AppMethodBeat.i(27571);
    if ((this.contact != null) && (com.tencent.mm.contact.c.lO(this.contact.field_type)) && (!x.AA(this.contact.field_username)) && (!x.Bh(this.contact.field_username))) {
      if ((this.xfE != null) && (this.xfE.Ks())) {
        this.screen.cT("contact_is_mute", false);
      }
    }
    for (;;)
    {
      this.screen.cT("contact_info_verifyuser_weibo", true);
      this.screen.cT("contact_info_subscribe_bizinfo", true);
      this.screen.cT("contact_info_template_recv", true);
      this.screen.cT("contact_info_locate", true);
      AppMethodBeat.o(27571);
      return;
      this.screen.cT("contact_is_mute", true);
      continue;
      this.screen.cT("contact_is_mute", true);
    }
  }
  
  private void pE(boolean paramBoolean)
  {
    AppMethodBeat.i(27576);
    if (this.contact == null)
    {
      AppMethodBeat.o(27576);
      return;
    }
    ddo localddo;
    String str;
    if ((this.xfE != null) && (this.xfE.Ks()))
    {
      localddo = new ddo();
      if (!this.contact.Pd()) {
        break label111;
      }
      i = 1;
      localddo.HLe = i;
      localddo.Scene = getIntent().getIntExtra("key_start_biz_profile_setting_from_scene", 0);
      ag.aGA();
      str = this.contact.field_username;
      if (!paramBoolean) {
        break label116;
      }
    }
    label111:
    label116:
    for (int i = 15;; i = 16)
    {
      com.tencent.mm.al.l.a(str, localddo, i);
      AppMethodBeat.o(27576);
      return;
      i = 0;
      break;
    }
  }
  
  private void py(boolean paramBoolean)
  {
    AppMethodBeat.i(27573);
    CheckBoxPreference localCheckBoxPreference;
    if (this.contact != null)
    {
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      localCheckBoxPreference = (CheckBoxPreference)this.screen.aXe("contact_is_mute");
      if ((!paramBoolean) || (this.xfE == null) || (!this.xfE.Ks())) {
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
        localCheckBoxPreference.setChecked(paramBoolean);
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
  
  public int getResourceId()
  {
    return 2131951698;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27570);
    if (this.xfE != null) {
      this.cRb = this.xfE.bX(false);
    }
    boolean bool;
    label144:
    Object localObject;
    if (this.xfE != null) {
      if (this.xfE.Ks())
      {
        this.screen.cT("contact_is_mute", false);
        this.fOX = this.contact.Pd();
        py(this.fOX);
        ae.d("MicroMsg.NewBizInfoSettingUI", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(getIntent().getBooleanExtra("KIsHardDevice", false)) });
        if ((getIntent() == null) || (!getIntent().getBooleanExtra("KIsHardDevice", false))) {
          break label689;
        }
        ae.d("MicroMsg.NewBizInfoSettingUI", "Hard device biz...");
        if (getIntent() != null) {
          break label385;
        }
        bool = false;
        ae.d("MicroMsg.NewBizInfoSettingUI", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.contact.c.lO(this.contact.field_type)), Boolean.valueOf(bool) });
        if ((!com.tencent.mm.contact.c.lO(this.contact.field_type)) || (!bool)) {
          break label585;
        }
        if (this.xfE == null) {
          break label524;
        }
        ((CheckBoxPreference)this.screen.aXe("contact_info_subscribe_bizinfo")).setChecked(this.xfE.Kn());
        localObject = (CheckBoxPreference)this.screen.aXe("contact_info_locate");
        if (!this.xfE.bX(false).Kr()) {
          break label455;
        }
        ((CheckBoxPreference)localObject).setChecked(this.xfE.Ko());
      }
    }
    for (;;)
    {
      if (this.xfE.Kn())
      {
        if ((this.cRb == null) && (this.xfE != null)) {
          this.cRb = this.xfE.bX(false);
        }
        if ((this.cRb != null) && (this.cRb.KH()) && (com.tencent.mm.br.d.aJN("brandservice")))
        {
          this.screen.cT("contact_info_template_recv", false);
          AppMethodBeat.o(27570);
          return;
          this.screen.cT("contact_is_mute", true);
          break;
          this.screen.cT("contact_is_mute", true);
          break;
          label385:
          localObject = getIntent().getStringExtra("device_id");
          String str = getIntent().getStringExtra("device_type");
          ds localds = new ds();
          localds.dpD.cVh = ((String)localObject);
          localds.dpD.dpB = str;
          com.tencent.mm.sdk.b.a.IvT.l(localds);
          bool = localds.dpE.dpF;
          break label144;
          label455:
          this.screen.cT("contact_info_locate", true);
          ((CheckBoxPreference)localObject).setChecked(this.xfE.Ko());
          continue;
        }
        this.screen.cT("contact_info_template_recv", true);
        AppMethodBeat.o(27570);
        return;
      }
    }
    this.screen.cT("contact_info_template_recv", true);
    AppMethodBeat.o(27570);
    return;
    label524:
    this.screen.cT("contact_info_subscribe_bizinfo", true);
    this.screen.cT("contact_info_locate", true);
    this.screen.cT("contact_info_template_recv", true);
    this.screen.cT("contact_info_subscribe_msg", true);
    AppMethodBeat.o(27570);
    return;
    label585:
    ae.w("MicroMsg.NewBizInfoSettingUI", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
    dDX();
    if (Ny(this.jij))
    {
      if (this.xfE == null)
      {
        ae.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
        AppMethodBeat.o(27570);
        return;
      }
      ((CheckBoxPreference)this.screen.aXe("contact_info_subscribe_bizinfo")).setChecked(this.xfE.Kn());
      this.screen.cT("contact_info_subscribe_bizinfo", false);
    }
    AppMethodBeat.o(27570);
    return;
    label689:
    if (com.tencent.mm.contact.c.lO(this.contact.field_type))
    {
      if (this.xfE != null)
      {
        ((CheckBoxPreference)this.screen.aXe("contact_info_subscribe_bizinfo")).setChecked(this.xfE.Kn());
        if (this.xfE.Kn())
        {
          if ((this.cRb == null) && (this.xfE != null)) {
            this.cRb = this.xfE.bX(false);
          }
          if ((this.cRb != null) && (this.cRb.KH()) && (com.tencent.mm.br.d.aJN("brandservice"))) {
            this.screen.cT("contact_info_template_recv", false);
          }
        }
        for (;;)
        {
          localObject = (CheckBoxPreference)this.screen.aXe("contact_info_locate");
          if (!this.xfE.bX(false).Kr()) {
            break;
          }
          ((CheckBoxPreference)localObject).setChecked(this.xfE.Ko());
          AppMethodBeat.o(27570);
          return;
          this.screen.cT("contact_info_template_recv", true);
          continue;
          this.screen.cT("contact_info_template_recv", true);
        }
        this.screen.cT("contact_info_locate", true);
        ((CheckBoxPreference)localObject).setChecked(this.xfE.Ko());
        AppMethodBeat.o(27570);
      }
    }
    else
    {
      ae.w("MicroMsg.NewBizInfoSettingUI", "%s is not my contact", new Object[] { this.contact.field_username });
      dDX();
      if (Ny(this.jij))
      {
        if (this.xfE == null)
        {
          ae.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
          AppMethodBeat.o(27570);
          return;
        }
        ((CheckBoxPreference)this.screen.aXe("contact_info_subscribe_bizinfo")).setChecked(this.xfE.Kn());
        this.screen.cT("contact_info_subscribe_bizinfo", false);
      }
    }
    AppMethodBeat.o(27570);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27575);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.i("MicroMsg.NewBizInfoSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 1001) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("key_need_update", false);
      paramIntent = (IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper)paramIntent.getParcelableExtra("key_biz_data");
      if ((bool) && (paramIntent != null) && (this.xfE != null)) {
        this.iEb.a(this.xfE.field_username, paramIntent.iEE, paramIntent.iED, false, new e.b()
        {
          public final void a(String paramAnonymousString, SubscribeMsgRequestResult paramAnonymousSubscribeMsgRequestResult)
          {
            AppMethodBeat.i(27561);
            ae.i("MicroMsg.NewBizInfoSettingUI", "alvinluo updateSubscribeMsgList success");
            NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, paramAnonymousSubscribeMsgRequestResult);
            AppMethodBeat.o(27561);
          }
          
          public final void i(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
          {
            AppMethodBeat.i(27562);
            ae.e("MicroMsg.NewBizInfoSettingUI", "alvinluo updateSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
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
    this.xlU = (System.currentTimeMillis() / 1000L);
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
    paramBundle = bu.nullAsNil(getIntent().getStringExtra("Contact_User"));
    bc.aCg();
    this.contact = com.tencent.mm.model.c.azF().BH(paramBundle);
    this.xfE = com.tencent.mm.al.g.eX(paramBundle);
    if (this.contact != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.xfE != null) {
        bool2 = true;
      }
      ae.i("MicroMsg.NewBizInfoSettingUI", "user:%s contact:%b, bizInfo:%b", new Object[] { paramBundle, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.jij = getIntent().getIntExtra("Contact_Scene", 9);
      this.xlT = getIntent().getLongExtra("key_profile_enter_timestamp", 0L);
      initView();
      pE(true);
      AppMethodBeat.o(27568);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27569);
    super.onDestroy();
    pE(false);
    AppMethodBeat.o(27569);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(27574);
    paramPreference = paramPreference.mKey;
    ae.i("MicroMsg.NewBizInfoSettingUI", paramPreference + " item has been clicked!");
    Object localObject;
    label127:
    boolean bool;
    if ("contact_info_locate".endsWith(paramPreference))
    {
      localObject = this.xfE;
      if (localObject == null)
      {
        AppMethodBeat.o(27574);
        return true;
      }
      if (((com.tencent.mm.api.c)localObject).Ko())
      {
        ((com.tencent.mm.api.c)localObject).field_brandFlag &= 0xFFFFFFFB;
        a((com.tencent.mm.api.c)localObject, false);
        if (!((CheckBoxPreference)paramf.aXe("contact_info_locate")).isChecked()) {
          break label593;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(this.contact.field_username, 905, this.xlT);
      }
    }
    else
    {
      if ("contact_info_add_shortcut_btn".equals(paramPreference))
      {
        ae.d("MicroMsg.NewBizInfoSettingUI", "dealAddShortcut, username = " + this.contact.field_username);
        com.tencent.mm.plugin.base.model.b.aa(this, this.contact.field_username);
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27566);
            if (NewBizInfoSettingUI.this.isFinishing())
            {
              AppMethodBeat.o(27566);
              return;
            }
            com.tencent.mm.plugin.base.model.b.Z(NewBizInfoSettingUI.this, NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).field_username);
            com.tencent.mm.plugin.base.model.b.K(NewBizInfoSettingUI.this);
            AppMethodBeat.o(27566);
          }
        }, 1000L);
      }
      if ("contact_info_clear_msg".equals(paramPreference))
      {
        if ((this.xfE != null) && (this.xfE.Ks()))
        {
          this.hTl = new dci();
          this.hTl.HKT = 0;
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVa(this.contact.field_username);
          if (localObject != null) {
            this.hTl.HKR = ((ba)localObject).field_unReadCount;
          }
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arc(this.contact.field_username);
          if (localObject != null)
          {
            this.hTl.HKS = ((bv)localObject).getType();
            if (this.hTl.HKR > 0) {
              this.hTl.HKQ = ((int)(System.currentTimeMillis() - ((ei)localObject).field_createTime) / 1000);
            }
          }
        }
        h.e(this, getString(2131757598), "", getString(2131757597), getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27560);
            NewBizInfoSettingUI.c(NewBizInfoSettingUI.this);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).field_username, 910, NewBizInfoSettingUI.b(NewBizInfoSettingUI.this));
            NewBizInfoSettingUI.d(NewBizInfoSettingUI.this);
            AppMethodBeat.o(27560);
          }
        }, null);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(this.contact.field_username, 909, this.xlT);
      }
      if ("contact_is_mute".endsWith(paramPreference))
      {
        if (this.fOX) {
          break label613;
        }
        bool = true;
        label434:
        this.fOX = bool;
        if (!this.fOX) {
          break label619;
        }
        x.z(this.contact);
      }
    }
    for (;;)
    {
      py(this.fOX);
      if ("contact_info_template_recv".equals(paramPreference))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("enterprise_biz_name", this.xfE.field_username);
        com.tencent.mm.br.d.b(this, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject);
      }
      if (!"contact_info_subscribe_bizinfo".endsWith(paramPreference)) {
        break label828;
      }
      paramPreference = this.xfE;
      if (paramPreference != null) {
        break label629;
      }
      AppMethodBeat.o(27574);
      return true;
      this.xhr = h.a(this, getString(2131757139, new Object[] { this.contact.adG() }), getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27558);
          this.cXA.field_hadAlert = 1;
          this.cXA.field_brandFlag |= 0x4;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, this.cXA, true);
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).field_username, 906, NewBizInfoSettingUI.b(NewBizInfoSettingUI.this));
          AppMethodBeat.o(27558);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27559);
          this.cXA.field_hadAlert = 1;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, this.cXA, false);
          AppMethodBeat.o(27559);
        }
      });
      break;
      label593:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(this.contact.field_username, 907, this.xlT);
      break label127;
      label613:
      bool = false;
      break label434;
      label619:
      x.A(this.contact);
    }
    label629:
    int i;
    if (paramPreference.Kn())
    {
      paramPreference.field_brandFlag |= 0x1;
      if ((this.cRb == null) && (paramPreference != null)) {
        this.cRb = paramPreference.bX(false);
      }
      if ((this.cRb != null) && (this.cRb.KH()) && (com.tencent.mm.br.d.aJN("brandservice")))
      {
        paramf.cT("contact_info_template_recv", false);
        long l = System.currentTimeMillis() / 1000L;
        localObject = com.tencent.mm.plugin.brandservice.ui.timeline.a.ofK;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.r(paramPreference.field_username, l, this.xlU);
        label730:
        localObject = com.tencent.mm.plugin.report.service.g.yxI;
        String str = paramPreference.field_username;
        if (!paramPreference.Kn()) {
          break label875;
        }
        i = 3;
        label750:
        ((com.tencent.mm.plugin.report.service.g)localObject).f(13307, new Object[] { str, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0) });
        a(paramPreference, false);
        if (!((CheckBoxPreference)paramf.aXe("contact_info_subscribe_bizinfo")).isChecked()) {
          break label880;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(this.contact.field_username, 901, this.xlT);
      }
    }
    for (;;)
    {
      label828:
      AppMethodBeat.o(27574);
      return false;
      paramf.cT("contact_info_template_recv", true);
      break;
      paramPreference.field_brandFlag &= 0xFFFFFFFE;
      paramf.cT("contact_info_template_recv", true);
      break label730;
      label875:
      i = 4;
      break label750;
      label880:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(this.contact.field_username, 902, this.xlT);
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