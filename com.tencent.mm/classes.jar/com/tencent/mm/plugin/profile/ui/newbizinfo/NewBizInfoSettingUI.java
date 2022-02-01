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
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.dv.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.List;

public class NewBizInfoSettingUI
  extends MMPreference
{
  private static final String Bff;
  private com.tencent.mm.api.c Bdk;
  d Bfe;
  private long BjU;
  private long BjV;
  private ISubscribeMsgService BjW;
  private as contact;
  private c.b dhv;
  private boolean guh;
  private dvm iOA;
  private SubscribeMsgRequestResult iQF;
  private boolean isDeleteCancel;
  private int kgm;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private com.tencent.mm.ui.base.q tipDialog;
  
  static
  {
    AppMethodBeat.i(231962);
    Bff = "https://" + WeChatHosts.domainString(2131761726) + "/mp/infringement?username=%s&from=1#wechat_redirect";
    AppMethodBeat.o(231962);
  }
  
  public NewBizInfoSettingUI()
  {
    AppMethodBeat.i(27567);
    this.sp = null;
    com.tencent.mm.msgsubscription.api.b localb = com.tencent.mm.msgsubscription.api.b.jza;
    this.BjW = com.tencent.mm.msgsubscription.api.b.Ru("name_biz");
    this.Bfe = null;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    AppMethodBeat.o(27567);
  }
  
  private static boolean UL(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private void a(com.tencent.mm.api.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(27572);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.bmg("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.bmg("contact_info_locate");
    cpe localcpe = new cpe();
    localcpe.kem = paramc.field_brandFlag;
    localcpe.UserName = this.contact.field_username;
    if (UL(this.kgm))
    {
      bg.aVF();
      com.tencent.mm.model.c.aSM().d(new k.a(58, localcpe));
    }
    for (;;)
    {
      ag.bah().update(paramc, new String[0]);
      localCheckBoxPreference1.setChecked(paramc.Ux());
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.setChecked(paramc.Uy());
      }
      if (paramBoolean)
      {
        initView();
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(27572);
      return;
      bg.aVF();
      com.tencent.mm.model.c.aSM().d(new k.a(47, localcpe));
    }
  }
  
  private void eEq()
  {
    AppMethodBeat.i(27571);
    if ((this.contact != null) && (com.tencent.mm.contact.c.oR(this.contact.field_type)) && (!ab.Jf(this.contact.field_username)) && (!ab.JM(this.contact.field_username))) {
      if ((this.Bdk != null) && (this.Bdk.UC())) {
        this.screen.jdMethod_do("contact_is_mute", false);
      }
    }
    for (;;)
    {
      this.screen.jdMethod_do("contact_info_verifyuser_weibo", true);
      this.screen.jdMethod_do("contact_info_subscribe_bizinfo", true);
      this.screen.jdMethod_do("contact_info_template_recv", true);
      this.screen.jdMethod_do("contact_info_locate", true);
      AppMethodBeat.o(27571);
      return;
      this.screen.jdMethod_do("contact_is_mute", true);
      continue;
      this.screen.jdMethod_do("contact_is_mute", true);
    }
  }
  
  private void sG(boolean paramBoolean)
  {
    AppMethodBeat.i(27573);
    CheckBoxPreference localCheckBoxPreference;
    if (this.contact != null)
    {
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      localCheckBoxPreference = (CheckBoxPreference)this.screen.bmg("contact_is_mute");
      if ((!paramBoolean) || (this.Bdk == null) || (!this.Bdk.UC())) {
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
  
  private void sN(boolean paramBoolean)
  {
    AppMethodBeat.i(27576);
    if (this.contact == null)
    {
      AppMethodBeat.o(27576);
      return;
    }
    dws localdws;
    String str;
    if ((this.Bdk != null) && (this.Bdk.UC()))
    {
      localdws = new dws();
      if (!this.contact.Zx()) {
        break label111;
      }
      i = 1;
      localdws.MWN = i;
      localdws.Scene = getIntent().getIntExtra("key_start_biz_profile_setting_from_scene", 0);
      ag.bat();
      str = this.contact.field_username;
      if (!paramBoolean) {
        break label116;
      }
    }
    label111:
    label116:
    for (int i = 15;; i = 16)
    {
      com.tencent.mm.al.l.a(str, localdws, i);
      AppMethodBeat.o(27576);
      return;
      i = 0;
      break;
    }
  }
  
  public int getResourceId()
  {
    return 2132017242;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27570);
    if (this.Bdk != null) {
      this.dhv = this.Bdk.cG(false);
    }
    boolean bool;
    label226:
    Object localObject;
    if (this.Bdk != null) {
      if (this.Bdk.UC())
      {
        this.screen.jdMethod_do("contact_is_mute", false);
        this.screen.jdMethod_do("contact_info_subscribe_msg", true);
        if ((this.contact != null) && (com.tencent.mm.contact.c.oR(this.contact.field_type)) && (this.Bdk != null) && (this.Bdk.UC()) && (this.BjW != null)) {
          this.BjW.a(this.Bdk.field_username, new com.tencent.mm.msgsubscription.api.a()
          {
            public final void a(String paramAnonymousString, SubscribeMsgRequestResult paramAnonymousSubscribeMsgRequestResult)
            {
              boolean bool1 = true;
              AppMethodBeat.i(231958);
              boolean bool2 = paramAnonymousSubscribeMsgRequestResult.jyp;
              Log.i("MicroMsg.NewBizInfoSettingUI", "alvinluo initSubscribeMsgEntry getSubscribeMsgList onSuccess size: %d, showEntry: %b", new Object[] { Integer.valueOf(paramAnonymousSubscribeMsgRequestResult.jyk.size()), Boolean.valueOf(paramAnonymousSubscribeMsgRequestResult.jyp) });
              paramAnonymousString = NewBizInfoSettingUI.a(NewBizInfoSettingUI.this);
              if (!bool2) {}
              for (;;)
              {
                paramAnonymousString.jdMethod_do("contact_info_subscribe_msg", bool1);
                NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, paramAnonymousSubscribeMsgRequestResult);
                AppMethodBeat.o(231958);
                return;
                bool1 = false;
              }
            }
            
            public final void i(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
            {
              AppMethodBeat.i(231959);
              Log.e("MicroMsg.NewBizInfoSettingUI", "alvinluo initSubscribeMsgEntry getSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).jdMethod_do("contact_info_subscribe_msg", true);
              AppMethodBeat.o(231959);
            }
          });
        }
        this.guh = this.contact.Zx();
        sG(this.guh);
        Log.d("MicroMsg.NewBizInfoSettingUI", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(getIntent().getBooleanExtra("KIsHardDevice", false)) });
        if ((getIntent() == null) || (!getIntent().getBooleanExtra("KIsHardDevice", false))) {
          break label771;
        }
        Log.d("MicroMsg.NewBizInfoSettingUI", "Hard device biz...");
        if (getIntent() != null) {
          break label467;
        }
        bool = false;
        Log.d("MicroMsg.NewBizInfoSettingUI", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.contact.c.oR(this.contact.field_type)), Boolean.valueOf(bool) });
        if ((!com.tencent.mm.contact.c.oR(this.contact.field_type)) || (!bool)) {
          break label667;
        }
        if (this.Bdk == null) {
          break label606;
        }
        ((CheckBoxPreference)this.screen.bmg("contact_info_subscribe_bizinfo")).setChecked(this.Bdk.Ux());
        localObject = (CheckBoxPreference)this.screen.bmg("contact_info_locate");
        if (!this.Bdk.cG(false).UB()) {
          break label537;
        }
        ((CheckBoxPreference)localObject).setChecked(this.Bdk.Uy());
      }
    }
    for (;;)
    {
      if (this.Bdk.Ux())
      {
        if ((this.dhv == null) && (this.Bdk != null)) {
          this.dhv = this.Bdk.cG(false);
        }
        if ((this.dhv != null) && (this.dhv.UR()) && (com.tencent.mm.br.c.aZU("brandservice")))
        {
          this.screen.jdMethod_do("contact_info_template_recv", false);
          AppMethodBeat.o(27570);
          return;
          this.screen.jdMethod_do("contact_is_mute", true);
          break;
          this.screen.jdMethod_do("contact_is_mute", true);
          break;
          label467:
          localObject = getIntent().getStringExtra("device_id");
          String str = getIntent().getStringExtra("device_type");
          dv localdv = new dv();
          localdv.dGR.dGL = ((String)localObject);
          localdv.dGR.dGP = str;
          EventCenter.instance.publish(localdv);
          bool = localdv.dGS.dGT;
          break label226;
          label537:
          this.screen.jdMethod_do("contact_info_locate", true);
          ((CheckBoxPreference)localObject).setChecked(this.Bdk.Uy());
          continue;
        }
        this.screen.jdMethod_do("contact_info_template_recv", true);
        AppMethodBeat.o(27570);
        return;
      }
    }
    this.screen.jdMethod_do("contact_info_template_recv", true);
    AppMethodBeat.o(27570);
    return;
    label606:
    this.screen.jdMethod_do("contact_info_subscribe_bizinfo", true);
    this.screen.jdMethod_do("contact_info_locate", true);
    this.screen.jdMethod_do("contact_info_template_recv", true);
    this.screen.jdMethod_do("contact_info_subscribe_msg", true);
    AppMethodBeat.o(27570);
    return;
    label667:
    Log.w("MicroMsg.NewBizInfoSettingUI", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
    eEq();
    if (UL(this.kgm))
    {
      if (this.Bdk == null)
      {
        Log.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
        AppMethodBeat.o(27570);
        return;
      }
      ((CheckBoxPreference)this.screen.bmg("contact_info_subscribe_bizinfo")).setChecked(this.Bdk.Ux());
      this.screen.jdMethod_do("contact_info_subscribe_bizinfo", false);
    }
    AppMethodBeat.o(27570);
    return;
    label771:
    if (com.tencent.mm.contact.c.oR(this.contact.field_type))
    {
      if (this.Bdk != null)
      {
        ((CheckBoxPreference)this.screen.bmg("contact_info_subscribe_bizinfo")).setChecked(this.Bdk.Ux());
        if (this.Bdk.Ux())
        {
          if ((this.dhv == null) && (this.Bdk != null)) {
            this.dhv = this.Bdk.cG(false);
          }
          if ((this.dhv != null) && (this.dhv.UR()) && (com.tencent.mm.br.c.aZU("brandservice"))) {
            this.screen.jdMethod_do("contact_info_template_recv", false);
          }
        }
        for (;;)
        {
          localObject = (CheckBoxPreference)this.screen.bmg("contact_info_locate");
          if (!this.Bdk.cG(false).UB()) {
            break;
          }
          ((CheckBoxPreference)localObject).setChecked(this.Bdk.Uy());
          AppMethodBeat.o(27570);
          return;
          this.screen.jdMethod_do("contact_info_template_recv", true);
          continue;
          this.screen.jdMethod_do("contact_info_template_recv", true);
        }
        this.screen.jdMethod_do("contact_info_locate", true);
        ((CheckBoxPreference)localObject).setChecked(this.Bdk.Uy());
        AppMethodBeat.o(27570);
      }
    }
    else
    {
      Log.w("MicroMsg.NewBizInfoSettingUI", "%s is not my contact", new Object[] { this.contact.field_username });
      eEq();
      if (UL(this.kgm))
      {
        if (this.Bdk == null)
        {
          Log.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
          AppMethodBeat.o(27570);
          return;
        }
        ((CheckBoxPreference)this.screen.bmg("contact_info_subscribe_bizinfo")).setChecked(this.Bdk.Ux());
        this.screen.jdMethod_do("contact_info_subscribe_bizinfo", false);
      }
    }
    AppMethodBeat.o(27570);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27575);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.NewBizInfoSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 1001) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("key_need_update", false);
      paramIntent = (ISubscribeMsgService.Companion.SubscribeMsgListWrapper)paramIntent.getParcelableExtra("key_biz_data");
      if ((bool) && (paramIntent != null) && (this.Bdk != null) && (this.BjW != null))
      {
        com.tencent.mm.msgsubscription.api.c localc = new com.tencent.mm.msgsubscription.api.c();
        localc.setUsername(Util.nullAs(this.Bdk.field_username, ""));
        localc.jyV.addAll(paramIntent.jyV);
        localc.jzb = paramIntent.jyW;
        localc.jze = new com.tencent.mm.msgsubscription.api.a()
        {
          public final void a(String paramAnonymousString, SubscribeMsgRequestResult paramAnonymousSubscribeMsgRequestResult)
          {
            AppMethodBeat.i(27561);
            Log.i("MicroMsg.NewBizInfoSettingUI", "alvinluo updateSubscribeMsgList success");
            NewBizInfoSettingUI.b(NewBizInfoSettingUI.this, paramAnonymousSubscribeMsgRequestResult);
            AppMethodBeat.o(27561);
          }
          
          public final void i(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
          {
            AppMethodBeat.i(27562);
            Log.e("MicroMsg.NewBizInfoSettingUI", "alvinluo updateSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(27562);
          }
        };
        this.BjW.a(localc);
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
    this.BjV = (System.currentTimeMillis() / 1000L);
    setMMTitle(2131757851);
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
    paramBundle = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
    bg.aVF();
    this.contact = com.tencent.mm.model.c.aSN().Kn(paramBundle);
    this.Bdk = com.tencent.mm.al.g.fJ(paramBundle);
    if (this.contact != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.Bdk != null) {
        bool2 = true;
      }
      Log.i("MicroMsg.NewBizInfoSettingUI", "user:%s contact:%b, bizInfo:%b", new Object[] { paramBundle, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.kgm = getIntent().getIntExtra("Contact_Scene", 9);
      this.BjU = getIntent().getLongExtra("key_profile_enter_timestamp", 0L);
      initView();
      sN(true);
      AppMethodBeat.o(27568);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27569);
    super.onDestroy();
    sN(false);
    AppMethodBeat.o(27569);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(27574);
    paramPreference = paramPreference.mKey;
    Log.i("MicroMsg.NewBizInfoSettingUI", paramPreference + " item has been clicked!");
    Object localObject;
    label127:
    boolean bool;
    if ("contact_info_locate".endsWith(paramPreference))
    {
      localObject = this.Bdk;
      if (localObject == null)
      {
        AppMethodBeat.o(27574);
        return true;
      }
      if (((com.tencent.mm.api.c)localObject).Uy())
      {
        ((com.tencent.mm.api.c)localObject).field_brandFlag &= 0xFFFFFFFB;
        a((com.tencent.mm.api.c)localObject, false);
        if (!((CheckBoxPreference)paramf.bmg("contact_info_locate")).isChecked()) {
          break label715;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(this.contact.field_username, 905, this.BjU);
      }
    }
    else
    {
      if ("contact_info_add_shortcut_btn".equals(paramPreference))
      {
        Log.d("MicroMsg.NewBizInfoSettingUI", "dealAddShortcut, username = " + this.contact.field_username);
        com.tencent.mm.plugin.base.model.b.ai(this, this.contact.field_username);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27566);
            if (NewBizInfoSettingUI.this.isFinishing())
            {
              AppMethodBeat.o(27566);
              return;
            }
            com.tencent.mm.plugin.base.model.b.ah(NewBizInfoSettingUI.this, NewBizInfoSettingUI.b(NewBizInfoSettingUI.this).field_username);
            com.tencent.mm.plugin.base.model.b.K(NewBizInfoSettingUI.this);
            AppMethodBeat.o(27566);
          }
        }, 1000L);
      }
      if ("contact_info_clear_msg".equals(paramPreference))
      {
        if ((this.Bdk != null) && (this.Bdk.UC()))
        {
          this.iOA = new dvm();
          this.iOA.MWC = 0;
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(this.contact.field_username);
          if (localObject != null) {
            this.iOA.MWA = ((bb)localObject).field_unReadCount;
          }
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx(this.contact.field_username);
          if (localObject != null)
          {
            this.iOA.MWB = ((ca)localObject).getType();
            if (this.iOA.MWA > 0) {
              this.iOA.MWz = ((int)(System.currentTimeMillis() - ((eo)localObject).field_createTime) / 1000);
            }
          }
        }
        com.tencent.mm.ui.base.h.c(this, getString(2131757825), "", getString(2131757824), getString(2131755761), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27560);
            NewBizInfoSettingUI.d(NewBizInfoSettingUI.this);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(NewBizInfoSettingUI.b(NewBizInfoSettingUI.this).field_username, 910, NewBizInfoSettingUI.c(NewBizInfoSettingUI.this));
            NewBizInfoSettingUI.e(NewBizInfoSettingUI.this);
            AppMethodBeat.o(27560);
          }
        }, null);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(this.contact.field_username, 909, this.BjU);
      }
      if ("contact_is_mute".endsWith(paramPreference))
      {
        if (this.guh) {
          break label735;
        }
        bool = true;
        label434:
        this.guh = bool;
        if (!this.guh) {
          break label741;
        }
        ab.z(this.contact);
      }
    }
    for (;;)
    {
      sG(this.guh);
      if ("contact_info_template_recv".equals(paramPreference))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("enterprise_biz_name", this.Bdk.field_username);
        com.tencent.mm.br.c.b(this, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject);
      }
      if (("contact_info_subscribe_msg".equals(paramPreference)) && (this.iQF != null))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_biz_username", this.Bdk.field_username);
        ((Intent)localObject).putExtra("key_biz_presenter_class", com.tencent.mm.al.b.a.class.getName());
        ((Intent)localObject).putExtra("key_biz_nickname", aa.getDisplayName(this.Bdk.field_username));
        ((Intent)localObject).putExtra("key_biz_data", this.iQF);
        ((Intent)localObject).putExtra("key_need_update", false);
        ((Intent)localObject).putExtra("key_enter_scene", 1);
        com.tencent.mm.br.c.c(this, "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", (Intent)localObject, 1001);
      }
      if (!"contact_info_subscribe_bizinfo".endsWith(paramPreference)) {
        break label950;
      }
      paramPreference = this.Bdk;
      if (paramPreference != null) {
        break label751;
      }
      AppMethodBeat.o(27574);
      return true;
      this.Bfe = com.tencent.mm.ui.base.h.a(this, getString(2131757343, new Object[] { this.contact.arJ() }), getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27558);
          this.dob.field_hadAlert = 1;
          this.dob.field_brandFlag |= 0x4;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, this.dob, true);
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(NewBizInfoSettingUI.b(NewBizInfoSettingUI.this).field_username, 906, NewBizInfoSettingUI.c(NewBizInfoSettingUI.this));
          AppMethodBeat.o(27558);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27559);
          this.dob.field_hadAlert = 1;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, this.dob, false);
          AppMethodBeat.o(27559);
        }
      });
      break;
      label715:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(this.contact.field_username, 907, this.BjU);
      break label127;
      label735:
      bool = false;
      break label434;
      label741:
      ab.A(this.contact);
    }
    label751:
    int i;
    if (paramPreference.Ux())
    {
      paramPreference.field_brandFlag |= 0x1;
      if ((this.dhv == null) && (paramPreference != null)) {
        this.dhv = paramPreference.cG(false);
      }
      if ((this.dhv != null) && (this.dhv.UR()) && (com.tencent.mm.br.c.aZU("brandservice")))
      {
        paramf.jdMethod_do("contact_info_template_recv", false);
        long l = System.currentTimeMillis() / 1000L;
        localObject = com.tencent.mm.plugin.brandservice.ui.timeline.a.pqG;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.r(paramPreference.field_username, l, this.BjV);
        label852:
        localObject = com.tencent.mm.plugin.report.service.h.CyF;
        String str = paramPreference.field_username;
        if (!paramPreference.Ux()) {
          break label997;
        }
        i = 3;
        label872:
        ((com.tencent.mm.plugin.report.service.h)localObject).a(13307, new Object[] { str, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0) });
        a(paramPreference, false);
        if (!((CheckBoxPreference)paramf.bmg("contact_info_subscribe_bizinfo")).isChecked()) {
          break label1002;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(this.contact.field_username, 901, this.BjU);
      }
    }
    for (;;)
    {
      label950:
      AppMethodBeat.o(27574);
      return false;
      paramf.jdMethod_do("contact_info_template_recv", true);
      break;
      paramPreference.field_brandFlag &= 0xFFFFFFFE;
      paramf.jdMethod_do("contact_info_template_recv", true);
      break label852;
      label997:
      i = 4;
      break label872;
      label1002:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(this.contact.field_username, 902, this.BjU);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI
 * JD-Core Version:    0.7.0.1
 */