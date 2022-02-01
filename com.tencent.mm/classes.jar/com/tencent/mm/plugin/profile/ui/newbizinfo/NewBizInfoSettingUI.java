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
import com.tencent.mm.am.ag;
import com.tencent.mm.am.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.w;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.storage.e;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoSettingUI
  extends MMPreference
{
  private c.b cQr;
  private am contact;
  private boolean fMP;
  private dbo hQt;
  private SubscribeMsgRequestResult hSA;
  private e iBi;
  private boolean isDeleteCancel;
  private int jfq;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private p tipDialog;
  private com.tencent.mm.api.c wPN;
  com.tencent.mm.ui.widget.a.d wRA;
  private long wWc;
  private long wWd;
  
  public NewBizInfoSettingUI()
  {
    AppMethodBeat.i(27567);
    this.sp = null;
    this.iBi = new e(com.tencent.mm.am.b.b.hSI);
    this.wRA = null;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    AppMethodBeat.o(27567);
  }
  
  private static boolean MS(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private void a(com.tencent.mm.api.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(27572);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.aVD("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.aVD("contact_info_locate");
    bzi localbzi = new bzi();
    localbzi.jdq = paramc.field_brandFlag;
    localbzi.nDo = this.contact.field_username;
    if (MS(this.jfq))
    {
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azo().c(new k.a(58, localbzi));
    }
    for (;;)
    {
      ag.aFZ().update(paramc, new String[0]);
      localCheckBoxPreference1.oB = paramc.Kf();
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.oB = paramc.Kg();
      }
      if (paramBoolean)
      {
        initView();
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(27572);
      return;
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azo().c(new k.a(47, localbzi));
    }
  }
  
  private void dAG()
  {
    AppMethodBeat.i(27571);
    if ((this.contact != null) && (com.tencent.mm.o.b.lM(this.contact.field_type)) && (!w.zQ(this.contact.field_username)) && (!w.Ax(this.contact.field_username))) {
      if ((this.wPN != null) && (this.wPN.Kk())) {
        this.screen.cP("contact_is_mute", false);
      }
    }
    for (;;)
    {
      this.screen.cP("contact_info_verifyuser_weibo", true);
      this.screen.cP("contact_info_subscribe_bizinfo", true);
      this.screen.cP("contact_info_template_recv", true);
      this.screen.cP("contact_info_locate", true);
      AppMethodBeat.o(27571);
      return;
      this.screen.cP("contact_is_mute", true);
      continue;
      this.screen.cP("contact_is_mute", true);
    }
  }
  
  private void pq(boolean paramBoolean)
  {
    AppMethodBeat.i(27573);
    CheckBoxPreference localCheckBoxPreference;
    if (this.contact != null)
    {
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      localCheckBoxPreference = (CheckBoxPreference)this.screen.aVD("contact_is_mute");
      if ((!paramBoolean) || (this.wPN == null) || (!this.wPN.Kk())) {
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
        localCheckBoxPreference.oB = paramBoolean;
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
  
  private void pw(boolean paramBoolean)
  {
    AppMethodBeat.i(27576);
    if (this.contact == null)
    {
      AppMethodBeat.o(27576);
      return;
    }
    dcu localdcu;
    String str;
    if ((this.wPN != null) && (this.wPN.Kk()))
    {
      localdcu = new dcu();
      if (!this.contact.Pf()) {
        break label111;
      }
      i = 1;
      localdcu.HrC = i;
      localdcu.Scene = getIntent().getIntExtra("key_start_biz_profile_setting_from_scene", 0);
      ag.aGk();
      str = this.contact.field_username;
      if (!paramBoolean) {
        break label116;
      }
    }
    label111:
    label116:
    for (int i = 15;; i = 16)
    {
      com.tencent.mm.am.l.a(str, localdcu, i);
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
    if (this.wPN != null) {
      this.cQr = this.wPN.bX(false);
    }
    boolean bool;
    label144:
    Object localObject;
    if (this.wPN != null) {
      if (this.wPN.Kk())
      {
        this.screen.cP("contact_is_mute", false);
        this.fMP = this.contact.Pf();
        pq(this.fMP);
        ad.d("MicroMsg.NewBizInfoSettingUI", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(getIntent().getBooleanExtra("KIsHardDevice", false)) });
        if ((getIntent() == null) || (!getIntent().getBooleanExtra("KIsHardDevice", false))) {
          break label689;
        }
        ad.d("MicroMsg.NewBizInfoSettingUI", "Hard device biz...");
        if (getIntent() != null) {
          break label385;
        }
        bool = false;
        ad.d("MicroMsg.NewBizInfoSettingUI", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.o.b.lM(this.contact.field_type)), Boolean.valueOf(bool) });
        if ((!com.tencent.mm.o.b.lM(this.contact.field_type)) || (!bool)) {
          break label585;
        }
        if (this.wPN == null) {
          break label524;
        }
        ((CheckBoxPreference)this.screen.aVD("contact_info_subscribe_bizinfo")).oB = this.wPN.Kf();
        localObject = (CheckBoxPreference)this.screen.aVD("contact_info_locate");
        if (!this.wPN.bX(false).Kj()) {
          break label455;
        }
        ((CheckBoxPreference)localObject).oB = this.wPN.Kg();
      }
    }
    for (;;)
    {
      if (this.wPN.Kf())
      {
        if ((this.cQr == null) && (this.wPN != null)) {
          this.cQr = this.wPN.bX(false);
        }
        if ((this.cQr != null) && (this.cQr.Kz()) && (com.tencent.mm.bs.d.aIu("brandservice")))
        {
          this.screen.cP("contact_info_template_recv", false);
          AppMethodBeat.o(27570);
          return;
          this.screen.cP("contact_is_mute", true);
          break;
          this.screen.cP("contact_is_mute", true);
          break;
          label385:
          localObject = getIntent().getStringExtra("device_id");
          String str = getIntent().getStringExtra("device_type");
          dr localdr = new dr();
          localdr.doy.cUi = ((String)localObject);
          localdr.doy.dow = str;
          com.tencent.mm.sdk.b.a.IbL.l(localdr);
          bool = localdr.doz.doA;
          break label144;
          label455:
          this.screen.cP("contact_info_locate", true);
          ((CheckBoxPreference)localObject).oB = this.wPN.Kg();
          continue;
        }
        this.screen.cP("contact_info_template_recv", true);
        AppMethodBeat.o(27570);
        return;
      }
    }
    this.screen.cP("contact_info_template_recv", true);
    AppMethodBeat.o(27570);
    return;
    label524:
    this.screen.cP("contact_info_subscribe_bizinfo", true);
    this.screen.cP("contact_info_locate", true);
    this.screen.cP("contact_info_template_recv", true);
    this.screen.cP("contact_info_subscribe_msg", true);
    AppMethodBeat.o(27570);
    return;
    label585:
    ad.w("MicroMsg.NewBizInfoSettingUI", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
    dAG();
    if (MS(this.jfq))
    {
      if (this.wPN == null)
      {
        ad.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
        AppMethodBeat.o(27570);
        return;
      }
      ((CheckBoxPreference)this.screen.aVD("contact_info_subscribe_bizinfo")).oB = this.wPN.Kf();
      this.screen.cP("contact_info_subscribe_bizinfo", false);
    }
    AppMethodBeat.o(27570);
    return;
    label689:
    if (com.tencent.mm.o.b.lM(this.contact.field_type))
    {
      if (this.wPN != null)
      {
        ((CheckBoxPreference)this.screen.aVD("contact_info_subscribe_bizinfo")).oB = this.wPN.Kf();
        if (this.wPN.Kf())
        {
          if ((this.cQr == null) && (this.wPN != null)) {
            this.cQr = this.wPN.bX(false);
          }
          if ((this.cQr != null) && (this.cQr.Kz()) && (com.tencent.mm.bs.d.aIu("brandservice"))) {
            this.screen.cP("contact_info_template_recv", false);
          }
        }
        for (;;)
        {
          localObject = (CheckBoxPreference)this.screen.aVD("contact_info_locate");
          if (!this.wPN.bX(false).Kj()) {
            break;
          }
          ((CheckBoxPreference)localObject).oB = this.wPN.Kg();
          AppMethodBeat.o(27570);
          return;
          this.screen.cP("contact_info_template_recv", true);
          continue;
          this.screen.cP("contact_info_template_recv", true);
        }
        this.screen.cP("contact_info_locate", true);
        ((CheckBoxPreference)localObject).oB = this.wPN.Kg();
        AppMethodBeat.o(27570);
      }
    }
    else
    {
      ad.w("MicroMsg.NewBizInfoSettingUI", "%s is not my contact", new Object[] { this.contact.field_username });
      dAG();
      if (MS(this.jfq))
      {
        if (this.wPN == null)
        {
          ad.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
          AppMethodBeat.o(27570);
          return;
        }
        ((CheckBoxPreference)this.screen.aVD("contact_info_subscribe_bizinfo")).oB = this.wPN.Kf();
        this.screen.cP("contact_info_subscribe_bizinfo", false);
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
      if ((bool) && (paramIntent != null) && (this.wPN != null)) {
        this.iBi.a(this.wPN.field_username, paramIntent.iBL, paramIntent.iBK, false, new e.b()
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
    this.wWd = (System.currentTimeMillis() / 1000L);
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
    com.tencent.mm.model.ba.aBQ();
    this.contact = com.tencent.mm.model.c.azp().Bf(paramBundle);
    this.wPN = com.tencent.mm.am.g.eS(paramBundle);
    if (this.contact != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.wPN != null) {
        bool2 = true;
      }
      ad.i("MicroMsg.NewBizInfoSettingUI", "user:%s contact:%b, bizInfo:%b", new Object[] { paramBundle, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.jfq = getIntent().getIntExtra("Contact_Scene", 9);
      this.wWc = getIntent().getLongExtra("key_profile_enter_timestamp", 0L);
      initView();
      pw(true);
      AppMethodBeat.o(27568);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27569);
    super.onDestroy();
    pw(false);
    AppMethodBeat.o(27569);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(27574);
    paramPreference = paramPreference.mKey;
    ad.i("MicroMsg.NewBizInfoSettingUI", paramPreference + " item has been clicked!");
    Object localObject;
    label127:
    boolean bool;
    if ("contact_info_locate".endsWith(paramPreference))
    {
      localObject = this.wPN;
      if (localObject == null)
      {
        AppMethodBeat.o(27574);
        return true;
      }
      if (((com.tencent.mm.api.c)localObject).Kg())
      {
        ((com.tencent.mm.api.c)localObject).field_brandFlag &= 0xFFFFFFFB;
        a((com.tencent.mm.api.c)localObject, false);
        if (!((CheckBoxPreference)paramf.aVD("contact_info_locate")).isChecked()) {
          break label593;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(this.contact.field_username, 905, this.wWc);
      }
    }
    else
    {
      if ("contact_info_add_shortcut_btn".equals(paramPreference))
      {
        ad.d("MicroMsg.NewBizInfoSettingUI", "dealAddShortcut, username = " + this.contact.field_username);
        com.tencent.mm.plugin.base.model.b.Y(this, this.contact.field_username);
        aq.o(new Runnable()
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
        if ((this.wPN != null) && (this.wPN.Kk()))
        {
          this.hQt = new dbo();
          this.hQt.Hrr = 0;
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTz(this.contact.field_username);
          if (localObject != null) {
            this.hQt.Hrp = ((com.tencent.mm.g.c.ba)localObject).field_unReadCount;
          }
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().apX(this.contact.field_username);
          if (localObject != null)
          {
            this.hQt.Hrq = ((bu)localObject).getType();
            if (this.hQt.Hrp > 0) {
              this.hQt.Hro = ((int)(System.currentTimeMillis() - ((ei)localObject).field_createTime) / 1000);
            }
          }
        }
        h.e(this, getString(2131757598), "", getString(2131757597), getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27560);
            NewBizInfoSettingUI.c(NewBizInfoSettingUI.this);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).field_username, 910, NewBizInfoSettingUI.b(NewBizInfoSettingUI.this));
            NewBizInfoSettingUI.d(NewBizInfoSettingUI.this);
            AppMethodBeat.o(27560);
          }
        }, null);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(this.contact.field_username, 909, this.wWc);
      }
      if ("contact_is_mute".endsWith(paramPreference))
      {
        if (this.fMP) {
          break label613;
        }
        bool = true;
        label434:
        this.fMP = bool;
        if (!this.fMP) {
          break label619;
        }
        w.s(this.contact);
      }
    }
    for (;;)
    {
      pq(this.fMP);
      if ("contact_info_template_recv".equals(paramPreference))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("enterprise_biz_name", this.wPN.field_username);
        com.tencent.mm.bs.d.b(this, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject);
      }
      if (!"contact_info_subscribe_bizinfo".endsWith(paramPreference)) {
        break label828;
      }
      paramPreference = this.wPN;
      if (paramPreference != null) {
        break label629;
      }
      AppMethodBeat.o(27574);
      return true;
      this.wRA = h.a(this, getString(2131757139, new Object[] { this.contact.adv() }), getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27558);
          this.cWD.field_hadAlert = 1;
          this.cWD.field_brandFlag |= 0x4;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, this.cWD, true);
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).field_username, 906, NewBizInfoSettingUI.b(NewBizInfoSettingUI.this));
          AppMethodBeat.o(27558);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27559);
          this.cWD.field_hadAlert = 1;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, this.cWD, false);
          AppMethodBeat.o(27559);
        }
      });
      break;
      label593:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(this.contact.field_username, 907, this.wWc);
      break label127;
      label613:
      bool = false;
      break label434;
      label619:
      w.t(this.contact);
    }
    label629:
    int i;
    if (paramPreference.Kf())
    {
      paramPreference.field_brandFlag |= 0x1;
      if ((this.cQr == null) && (paramPreference != null)) {
        this.cQr = paramPreference.bX(false);
      }
      if ((this.cQr != null) && (this.cQr.Kz()) && (com.tencent.mm.bs.d.aIu("brandservice")))
      {
        paramf.cP("contact_info_template_recv", false);
        long l = System.currentTimeMillis() / 1000L;
        localObject = com.tencent.mm.plugin.brandservice.ui.timeline.a.oaa;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.r(paramPreference.field_username, l, this.wWd);
        label730:
        localObject = com.tencent.mm.plugin.report.service.g.yhR;
        String str = paramPreference.field_username;
        if (!paramPreference.Kf()) {
          break label875;
        }
        i = 3;
        label750:
        ((com.tencent.mm.plugin.report.service.g)localObject).f(13307, new Object[] { str, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0) });
        a(paramPreference, false);
        if (!((CheckBoxPreference)paramf.aVD("contact_info_subscribe_bizinfo")).isChecked()) {
          break label880;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(this.contact.field_username, 901, this.wWc);
      }
    }
    for (;;)
    {
      label828:
      AppMethodBeat.o(27574);
      return false;
      paramf.cP("contact_info_template_recv", true);
      break;
      paramPreference.field_brandFlag &= 0xFFFFFFFE;
      paramf.cP("contact_info_template_recv", true);
      break label730;
      label875:
      i = 4;
      break label750;
      label880:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(this.contact.field_username, 902, this.wWc);
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