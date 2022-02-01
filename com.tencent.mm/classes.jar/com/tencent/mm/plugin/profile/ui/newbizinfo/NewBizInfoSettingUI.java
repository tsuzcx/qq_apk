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
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.g;
import com.tencent.mm.ao.l;
import com.tencent.mm.ao.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.f.a.ec;
import com.tencent.mm.f.a.ec.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.protocal.protobuf.egs;
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
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.List;

public class NewBizInfoSettingUI
  extends MMPreference
{
  private static final String GZd;
  private com.tencent.mm.api.c GXj;
  com.tencent.mm.ui.widget.a.d GZc;
  private long Hen;
  private long Heo;
  private ISubscribeMsgService Hep;
  private as contact;
  private c.b eZc;
  private boolean iYs;
  private boolean isDeleteCancel;
  private efo lEQ;
  private SubscribeMsgRequestResult lGV;
  private int mXL;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private s tipDialog;
  
  static
  {
    AppMethodBeat.i(247567);
    GZd = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/infringement?username=%s&from=1#wechat_redirect";
    AppMethodBeat.o(247567);
  }
  
  public NewBizInfoSettingUI()
  {
    AppMethodBeat.i(27567);
    this.sp = null;
    com.tencent.mm.msgsubscription.api.b localb = com.tencent.mm.msgsubscription.api.b.moG;
    this.Hep = com.tencent.mm.msgsubscription.api.b.YR("name_biz");
    this.GZc = null;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    AppMethodBeat.o(27567);
  }
  
  private void a(com.tencent.mm.api.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(27572);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.byG("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.byG("contact_info_locate");
    cxu localcxu = new cxu();
    localcxu.mVM = paramc.field_brandFlag;
    localcxu.UserName = this.contact.field_username;
    if (abs(this.mXL))
    {
      bh.beI();
      com.tencent.mm.model.c.bbK().d(new k.a(58, localcxu));
    }
    for (;;)
    {
      af.bjv().update(paramc, new String[0]);
      localCheckBoxPreference1.setChecked(paramc.YP());
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.setChecked(paramc.YQ());
      }
      if (paramBoolean)
      {
        initView();
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(27572);
      return;
      bh.beI();
      com.tencent.mm.model.c.bbK().d(new k.a(47, localcxu));
    }
  }
  
  private static boolean abs(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private void fqi()
  {
    AppMethodBeat.i(27571);
    if ((this.contact != null) && (com.tencent.mm.contact.d.rk(this.contact.field_type)) && (!ab.Qy(this.contact.field_username)) && (!ab.Rf(this.contact.field_username))) {
      if ((this.GXj != null) && (this.GXj.YU())) {
        this.screen.dz("contact_is_mute", false);
      }
    }
    for (;;)
    {
      this.screen.dz("contact_info_verifyuser_weibo", true);
      this.screen.dz("contact_info_subscribe_bizinfo", true);
      this.screen.dz("contact_info_template_recv", true);
      this.screen.dz("contact_info_locate", true);
      AppMethodBeat.o(27571);
      return;
      this.screen.dz("contact_is_mute", true);
      continue;
      this.screen.dz("contact_is_mute", true);
    }
  }
  
  private void vX(boolean paramBoolean)
  {
    AppMethodBeat.i(27573);
    CheckBoxPreference localCheckBoxPreference;
    if (this.contact != null)
    {
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      localCheckBoxPreference = (CheckBoxPreference)this.screen.byG("contact_is_mute");
      if ((!paramBoolean) || (this.GXj == null) || (!this.GXj.YU())) {
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
  
  private void wf(boolean paramBoolean)
  {
    AppMethodBeat.i(27576);
    if (this.contact == null)
    {
      AppMethodBeat.o(27576);
      return;
    }
    egs localegs;
    String str;
    if ((this.GXj != null) && (this.GXj.YU()))
    {
      localegs = new egs();
      if (!this.contact.aeg()) {
        break label111;
      }
      i = 1;
      localegs.Uji = i;
      localegs.CPw = getIntent().getIntExtra("key_start_biz_profile_setting_from_scene", 0);
      af.bjH();
      str = this.contact.field_username;
      if (!paramBoolean) {
        break label116;
      }
    }
    label111:
    label116:
    for (int i = 15;; i = 16)
    {
      l.a(str, localegs, i);
      AppMethodBeat.o(27576);
      return;
      i = 0;
      break;
    }
  }
  
  public int getResourceId()
  {
    return R.o.eXK;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27570);
    if (this.GXj != null) {
      this.eZc = this.GXj.dc(false);
    }
    boolean bool;
    label226:
    Object localObject;
    if (this.GXj != null) {
      if (this.GXj.YU())
      {
        this.screen.dz("contact_is_mute", false);
        this.screen.dz("contact_info_subscribe_msg", true);
        if ((this.contact != null) && (com.tencent.mm.contact.d.rk(this.contact.field_type)) && (this.GXj != null) && (this.GXj.YU()) && (this.Hep != null)) {
          this.Hep.a(this.GXj.field_username, new com.tencent.mm.msgsubscription.api.a()
          {
            public final void a(String paramAnonymousString, SubscribeMsgRequestResult paramAnonymousSubscribeMsgRequestResult)
            {
              boolean bool1 = true;
              AppMethodBeat.i(269341);
              boolean bool2 = paramAnonymousSubscribeMsgRequestResult.mnT;
              Log.i("MicroMsg.NewBizInfoSettingUI", "alvinluo initSubscribeMsgEntry getSubscribeMsgList onSuccess size: %d, showEntry: %b", new Object[] { Integer.valueOf(paramAnonymousSubscribeMsgRequestResult.mnO.size()), Boolean.valueOf(paramAnonymousSubscribeMsgRequestResult.mnT) });
              paramAnonymousString = NewBizInfoSettingUI.a(NewBizInfoSettingUI.this);
              if (!bool2) {}
              for (;;)
              {
                paramAnonymousString.dz("contact_info_subscribe_msg", bool1);
                NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, paramAnonymousSubscribeMsgRequestResult);
                AppMethodBeat.o(269341);
                return;
                bool1 = false;
              }
            }
            
            public final void i(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
            {
              AppMethodBeat.i(269342);
              Log.e("MicroMsg.NewBizInfoSettingUI", "alvinluo initSubscribeMsgEntry getSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).dz("contact_info_subscribe_msg", true);
              AppMethodBeat.o(269342);
            }
          });
        }
        this.iYs = this.contact.aeg();
        vX(this.iYs);
        Log.d("MicroMsg.NewBizInfoSettingUI", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(getIntent().getBooleanExtra("KIsHardDevice", false)) });
        if ((getIntent() == null) || (!getIntent().getBooleanExtra("KIsHardDevice", false))) {
          break label771;
        }
        Log.d("MicroMsg.NewBizInfoSettingUI", "Hard device biz...");
        if (getIntent() != null) {
          break label467;
        }
        bool = false;
        Log.d("MicroMsg.NewBizInfoSettingUI", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.contact.d.rk(this.contact.field_type)), Boolean.valueOf(bool) });
        if ((!com.tencent.mm.contact.d.rk(this.contact.field_type)) || (!bool)) {
          break label667;
        }
        if (this.GXj == null) {
          break label606;
        }
        ((CheckBoxPreference)this.screen.byG("contact_info_subscribe_bizinfo")).setChecked(this.GXj.YP());
        localObject = (CheckBoxPreference)this.screen.byG("contact_info_locate");
        if (!this.GXj.dc(false).YT()) {
          break label537;
        }
        ((CheckBoxPreference)localObject).setChecked(this.GXj.YQ());
      }
    }
    for (;;)
    {
      if (this.GXj.YP())
      {
        if ((this.eZc == null) && (this.GXj != null)) {
          this.eZc = this.GXj.dc(false);
        }
        if ((this.eZc != null) && (this.eZc.Zj()) && (com.tencent.mm.by.c.blP("brandservice")))
        {
          this.screen.dz("contact_info_template_recv", false);
          AppMethodBeat.o(27570);
          return;
          this.screen.dz("contact_is_mute", true);
          break;
          this.screen.dz("contact_is_mute", true);
          break;
          label467:
          localObject = getIntent().getStringExtra("device_id");
          String str = getIntent().getStringExtra("device_type");
          ec localec = new ec();
          localec.fzH.fzB = ((String)localObject);
          localec.fzH.fzF = str;
          EventCenter.instance.publish(localec);
          bool = localec.fzI.fzJ;
          break label226;
          label537:
          this.screen.dz("contact_info_locate", true);
          ((CheckBoxPreference)localObject).setChecked(this.GXj.YQ());
          continue;
        }
        this.screen.dz("contact_info_template_recv", true);
        AppMethodBeat.o(27570);
        return;
      }
    }
    this.screen.dz("contact_info_template_recv", true);
    AppMethodBeat.o(27570);
    return;
    label606:
    this.screen.dz("contact_info_subscribe_bizinfo", true);
    this.screen.dz("contact_info_locate", true);
    this.screen.dz("contact_info_template_recv", true);
    this.screen.dz("contact_info_subscribe_msg", true);
    AppMethodBeat.o(27570);
    return;
    label667:
    Log.w("MicroMsg.NewBizInfoSettingUI", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
    fqi();
    if (abs(this.mXL))
    {
      if (this.GXj == null)
      {
        Log.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
        AppMethodBeat.o(27570);
        return;
      }
      ((CheckBoxPreference)this.screen.byG("contact_info_subscribe_bizinfo")).setChecked(this.GXj.YP());
      this.screen.dz("contact_info_subscribe_bizinfo", false);
    }
    AppMethodBeat.o(27570);
    return;
    label771:
    if (com.tencent.mm.contact.d.rk(this.contact.field_type))
    {
      if (this.GXj != null)
      {
        ((CheckBoxPreference)this.screen.byG("contact_info_subscribe_bizinfo")).setChecked(this.GXj.YP());
        if (this.GXj.YP())
        {
          if ((this.eZc == null) && (this.GXj != null)) {
            this.eZc = this.GXj.dc(false);
          }
          if ((this.eZc != null) && (this.eZc.Zj()) && (com.tencent.mm.by.c.blP("brandservice"))) {
            this.screen.dz("contact_info_template_recv", false);
          }
        }
        for (;;)
        {
          localObject = (CheckBoxPreference)this.screen.byG("contact_info_locate");
          if (!this.GXj.dc(false).YT()) {
            break;
          }
          ((CheckBoxPreference)localObject).setChecked(this.GXj.YQ());
          AppMethodBeat.o(27570);
          return;
          this.screen.dz("contact_info_template_recv", true);
          continue;
          this.screen.dz("contact_info_template_recv", true);
        }
        this.screen.dz("contact_info_locate", true);
        ((CheckBoxPreference)localObject).setChecked(this.GXj.YQ());
        AppMethodBeat.o(27570);
      }
    }
    else
    {
      Log.w("MicroMsg.NewBizInfoSettingUI", "%s is not my contact", new Object[] { this.contact.field_username });
      fqi();
      if (abs(this.mXL))
      {
        if (this.GXj == null)
        {
          Log.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
          AppMethodBeat.o(27570);
          return;
        }
        ((CheckBoxPreference)this.screen.byG("contact_info_subscribe_bizinfo")).setChecked(this.GXj.YP());
        this.screen.dz("contact_info_subscribe_bizinfo", false);
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
      if ((bool) && (paramIntent != null) && (this.GXj != null) && (this.Hep != null))
      {
        com.tencent.mm.msgsubscription.api.c localc = new com.tencent.mm.msgsubscription.api.c();
        localc.setUsername(Util.nullAs(this.GXj.field_username, ""));
        localc.moB.addAll(paramIntent.moB);
        localc.moH = paramIntent.moC;
        localc.moK = new com.tencent.mm.msgsubscription.api.a()
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
        this.Hep.a(localc);
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
    this.Heo = (System.currentTimeMillis() / 1000L);
    setMMTitle(R.l.eyk);
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
    bh.beI();
    this.contact = com.tencent.mm.model.c.bbL().RG(paramBundle);
    this.GXj = g.gu(paramBundle);
    if (this.contact != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.GXj != null) {
        bool2 = true;
      }
      Log.i("MicroMsg.NewBizInfoSettingUI", "user:%s contact:%b, bizInfo:%b", new Object[] { paramBundle, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.mXL = getIntent().getIntExtra("Contact_Scene", 9);
      this.Hen = getIntent().getLongExtra("key_profile_enter_timestamp", 0L);
      initView();
      wf(true);
      AppMethodBeat.o(27568);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27569);
    super.onDestroy();
    wf(false);
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
      localObject = this.GXj;
      if (localObject == null)
      {
        AppMethodBeat.o(27574);
        return true;
      }
      if (((com.tencent.mm.api.c)localObject).YQ())
      {
        ((com.tencent.mm.api.c)localObject).field_brandFlag &= 0xFFFFFFFB;
        a((com.tencent.mm.api.c)localObject, false);
        if (!((CheckBoxPreference)paramf.byG("contact_info_locate")).isChecked()) {
          break label715;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(this.contact.field_username, 905, this.Hen);
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
            com.tencent.mm.plugin.base.model.b.L(NewBizInfoSettingUI.this);
            AppMethodBeat.o(27566);
          }
        }, 1000L);
      }
      if ("contact_info_clear_msg".equals(paramPreference))
      {
        if ((this.GXj != null) && (this.GXj.YU()))
        {
          this.lEQ = new efo();
          this.lEQ.UiX = 0;
          localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx(this.contact.field_username);
          if (localObject != null) {
            this.lEQ.UiV = ((bb)localObject).field_unReadCount;
          }
          localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH(this.contact.field_username);
          if (localObject != null)
          {
            this.lEQ.UiW = ((ca)localObject).getType();
            if (this.lEQ.UiV > 0) {
              this.lEQ.UiU = ((int)(System.currentTimeMillis() - ((et)localObject).field_createTime) / 1000);
            }
          }
        }
        com.tencent.mm.ui.base.h.c(this, getString(R.l.exW), "", getString(R.l.exV), getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27560);
            NewBizInfoSettingUI.d(NewBizInfoSettingUI.this);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(NewBizInfoSettingUI.b(NewBizInfoSettingUI.this).field_username, 910, NewBizInfoSettingUI.c(NewBizInfoSettingUI.this));
            NewBizInfoSettingUI.e(NewBizInfoSettingUI.this);
            AppMethodBeat.o(27560);
          }
        }, null);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(this.contact.field_username, 909, this.Hen);
      }
      if ("contact_is_mute".endsWith(paramPreference))
      {
        if (this.iYs) {
          break label735;
        }
        bool = true;
        label434:
        this.iYs = bool;
        if (!this.iYs) {
          break label741;
        }
        ab.F(this.contact);
      }
    }
    for (;;)
    {
      vX(this.iYs);
      if ("contact_info_template_recv".equals(paramPreference))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("enterprise_biz_name", this.GXj.field_username);
        com.tencent.mm.by.c.b(this, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", (Intent)localObject);
      }
      if (("contact_info_subscribe_msg".equals(paramPreference)) && (this.lGV != null))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_biz_username", this.GXj.field_username);
        ((Intent)localObject).putExtra("key_biz_presenter_class", com.tencent.mm.ao.b.a.class.getName());
        ((Intent)localObject).putExtra("key_biz_nickname", aa.PJ(this.GXj.field_username));
        ((Intent)localObject).putExtra("key_biz_data", this.lGV);
        ((Intent)localObject).putExtra("key_need_update", false);
        ((Intent)localObject).putExtra("key_enter_scene", 1);
        com.tencent.mm.by.c.d(this, "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", (Intent)localObject, 1001);
      }
      if (!"contact_info_subscribe_bizinfo".endsWith(paramPreference)) {
        break label950;
      }
      paramPreference = this.GXj;
      if (paramPreference != null) {
        break label751;
      }
      AppMethodBeat.o(27574);
      return true;
      this.GZc = com.tencent.mm.ui.base.h.a(this, getString(R.l.euy, new Object[] { this.contact.ays() }), getString(R.l.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27558);
          this.fgG.field_hadAlert = 1;
          this.fgG.field_brandFlag |= 0x4;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, this.fgG, true);
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(NewBizInfoSettingUI.b(NewBizInfoSettingUI.this).field_username, 906, NewBizInfoSettingUI.c(NewBizInfoSettingUI.this));
          AppMethodBeat.o(27558);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27559);
          this.fgG.field_hadAlert = 1;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, this.fgG, false);
          AppMethodBeat.o(27559);
        }
      });
      break;
      label715:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(this.contact.field_username, 907, this.Hen);
      break label127;
      label735:
      bool = false;
      break label434;
      label741:
      ab.G(this.contact);
    }
    label751:
    int i;
    if (paramPreference.YP())
    {
      paramPreference.field_brandFlag |= 0x1;
      if ((this.eZc == null) && (paramPreference != null)) {
        this.eZc = paramPreference.dc(false);
      }
      if ((this.eZc != null) && (this.eZc.Zj()) && (com.tencent.mm.by.c.blP("brandservice")))
      {
        paramf.dz("contact_info_template_recv", false);
        long l = System.currentTimeMillis() / 1000L;
        localObject = com.tencent.mm.plugin.brandservice.ui.timeline.a.szF;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.r(paramPreference.field_username, l, this.Heo);
        label852:
        localObject = com.tencent.mm.plugin.report.service.h.IzE;
        String str = paramPreference.field_username;
        if (!paramPreference.YP()) {
          break label997;
        }
        i = 3;
        label872:
        ((com.tencent.mm.plugin.report.service.h)localObject).a(13307, new Object[] { str, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0) });
        a(paramPreference, false);
        if (!((CheckBoxPreference)paramf.byG("contact_info_subscribe_bizinfo")).isChecked()) {
          break label1002;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(this.contact.field_username, 901, this.Hen);
      }
    }
    for (;;)
    {
      label950:
      AppMethodBeat.o(27574);
      return false;
      paramf.dz("contact_info_template_recv", true);
      break;
      paramPreference.field_brandFlag &= 0xFFFFFFFE;
      paramf.dz("contact_info_template_recv", true);
      break label852;
      label997:
      i = 4;
      break label872;
      label1002:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(this.contact.field_username, 902, this.Hen);
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