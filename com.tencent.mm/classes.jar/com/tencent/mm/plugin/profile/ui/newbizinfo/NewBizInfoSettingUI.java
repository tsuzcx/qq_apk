package com.tencent.mm.plugin.profile.ui.newbizinfo;

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
import com.tencent.mm.an.af;
import com.tencent.mm.an.g;
import com.tencent.mm.an.l;
import com.tencent.mm.an.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.autogen.a.em;
import com.tencent.mm.autogen.a.em.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br.a;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.doz;
import com.tencent.mm.protocal.protobuf.ezh;
import com.tencent.mm.protocal.protobuf.fas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NewBizInfoSettingUI
  extends MMPreference
{
  private static final String MXg;
  com.tencent.mm.api.c MVg;
  e MXf;
  private long NbX;
  private long NbY;
  private ISubscribeMsgService NbZ;
  ArrayList<NewBizInfoSettingUI.a> Nca;
  au contact;
  private c.b hcC;
  private boolean isDeleteCancel;
  private boolean lAj;
  private ezh oww;
  private SubscribeMsgRequestResult oyD;
  private int pUt;
  com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private w tipDialog;
  
  static
  {
    AppMethodBeat.i(305901);
    MXg = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/infringement?username=%s&from=1#wechat_redirect";
    AppMethodBeat.o(305901);
  }
  
  public NewBizInfoSettingUI()
  {
    AppMethodBeat.i(27567);
    this.sp = null;
    com.tencent.mm.msgsubscription.api.b localb = com.tencent.mm.msgsubscription.api.b.piw;
    this.NbZ = com.tencent.mm.msgsubscription.api.b.QW("name_biz");
    this.Nca = new ArrayList();
    this.MXf = null;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    AppMethodBeat.o(27567);
  }
  
  private void AC(boolean paramBoolean)
  {
    AppMethodBeat.i(27576);
    if (this.contact == null)
    {
      AppMethodBeat.o(27576);
      return;
    }
    fas localfas;
    String str;
    if ((this.MVg != null) && (this.MVg.aAM()))
    {
      localfas = new fas();
      if (!this.contact.aGe()) {
        break label110;
      }
      i = 1;
      localfas.abAN = i;
      localfas.IJG = getIntent().getIntExtra("key_start_biz_profile_setting_from_scene", 0);
      af.bHs();
      str = this.contact.field_username;
      if (!paramBoolean) {
        break label115;
      }
    }
    label110:
    label115:
    for (int i = 15;; i = 16)
    {
      l.a(str, localfas, i);
      AppMethodBeat.o(27576);
      return;
      i = 0;
      break;
    }
  }
  
  private void Au(boolean paramBoolean)
  {
    AppMethodBeat.i(27573);
    CheckBoxPreference localCheckBoxPreference;
    if (this.contact != null)
    {
      if (this.sp == null) {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      }
      localCheckBoxPreference = (CheckBoxPreference)this.screen.bAi("contact_is_mute");
      if ((!paramBoolean) || (this.MVg == null) || (!this.MVg.aAM())) {
        break label144;
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
      label144:
      setTitleMuteIconVisibility(8);
      if (localCheckBoxPreference != null) {
        this.sp.edit().putBoolean("contact_is_mute", false).commit();
      }
    }
  }
  
  private void a(com.tencent.mm.api.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(27572);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.screen.bAi("contact_info_subscribe_bizinfo");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.screen.bAi("contact_info_locate");
    doz localdoz = new doz();
    localdoz.pSt = paramc.field_brandFlag;
    localdoz.UserName = this.contact.field_username;
    if (afM(this.pUt))
    {
      bh.bCz();
      com.tencent.mm.model.c.bzz().d(new k.a(58, localdoz));
    }
    for (;;)
    {
      af.bHf().update(paramc, new String[0]);
      localCheckBoxPreference1.setChecked(paramc.aAH());
      if (localCheckBoxPreference2 != null) {
        localCheckBoxPreference2.setChecked(paramc.aAI());
      }
      if (paramBoolean)
      {
        initView();
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(27572);
      return;
      bh.bCz();
      com.tencent.mm.model.c.bzz().d(new k.a(47, localdoz));
    }
  }
  
  private static boolean afM(int paramInt)
  {
    return (paramInt == 81) || (paramInt == 92) || (paramInt == 93) || (paramInt == 94);
  }
  
  private void gBy()
  {
    AppMethodBeat.i(27571);
    if ((this.contact != null) && (d.rs(this.contact.field_type)) && (!au.bwc(this.contact.field_username)) && (!ab.Jd(this.contact.field_username))) {
      if ((this.MVg != null) && (this.MVg.aAM())) {
        this.screen.eh("contact_is_mute", false);
      }
    }
    for (;;)
    {
      this.screen.eh("contact_info_verifyuser_weibo", true);
      this.screen.eh("contact_info_subscribe_bizinfo", true);
      this.screen.eh("contact_info_template_recv", true);
      this.screen.eh("contact_info_locate", true);
      AppMethodBeat.o(27571);
      return;
      this.screen.eh("contact_is_mute", true);
      continue;
      this.screen.eh("contact_is_mute", true);
    }
  }
  
  public int getResourceId()
  {
    return R.o.hbl;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(305905);
    HashSet localHashSet = new HashSet();
    localHashSet.add(a.class);
    AppMethodBeat.o(305905);
    return localHashSet;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27570);
    if (this.MVg != null) {
      this.hcC = this.MVg.dO(false);
    }
    boolean bool;
    label225:
    Object localObject;
    if (this.MVg != null) {
      if (this.MVg.aAM())
      {
        this.screen.eh("contact_is_mute", false);
        this.screen.eh("contact_info_subscribe_msg", true);
        if ((this.contact != null) && (d.rs(this.contact.field_type)) && (this.MVg != null) && (this.MVg.aAM()) && (this.NbZ != null)) {
          this.NbZ.a(this.MVg.field_username, new com.tencent.mm.msgsubscription.api.a()
          {
            public final void a(String paramAnonymousString, SubscribeMsgRequestResult paramAnonymousSubscribeMsgRequestResult)
            {
              boolean bool1 = true;
              AppMethodBeat.i(305706);
              boolean bool2 = paramAnonymousSubscribeMsgRequestResult.phH;
              Log.i("MicroMsg.NewBizInfoSettingUI", "alvinluo initSubscribeMsgEntry getSubscribeMsgList onSuccess size: %d, showEntry: %b", new Object[] { Integer.valueOf(paramAnonymousSubscribeMsgRequestResult.phC.size()), Boolean.valueOf(paramAnonymousSubscribeMsgRequestResult.phH) });
              paramAnonymousString = NewBizInfoSettingUI.a(NewBizInfoSettingUI.this);
              if (!bool2) {}
              for (;;)
              {
                paramAnonymousString.eh("contact_info_subscribe_msg", bool1);
                NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, paramAnonymousSubscribeMsgRequestResult);
                AppMethodBeat.o(305706);
                return;
                bool1 = false;
              }
            }
            
            public final void j(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
            {
              AppMethodBeat.i(305708);
              Log.e("MicroMsg.NewBizInfoSettingUI", "alvinluo initSubscribeMsgEntry getSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              NewBizInfoSettingUI.a(NewBizInfoSettingUI.this).eh("contact_info_subscribe_msg", true);
              AppMethodBeat.o(305708);
            }
          });
        }
        this.lAj = this.contact.aGe();
        Au(this.lAj);
        Log.d("MicroMsg.NewBizInfoSettingUI", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(getIntent().getBooleanExtra("KIsHardDevice", false)) });
        if ((getIntent() == null) || (!getIntent().getBooleanExtra("KIsHardDevice", false))) {
          break label765;
        }
        Log.d("MicroMsg.NewBizInfoSettingUI", "Hard device biz...");
        if (getIntent() != null) {
          break label464;
        }
        bool = false;
        Log.d("MicroMsg.NewBizInfoSettingUI", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[] { Boolean.valueOf(d.rs(this.contact.field_type)), Boolean.valueOf(bool) });
        if ((!d.rs(this.contact.field_type)) || (!bool)) {
          break label661;
        }
        if (this.MVg == null) {
          break label600;
        }
        ((CheckBoxPreference)this.screen.bAi("contact_info_subscribe_bizinfo")).setChecked(this.MVg.aAH());
        localObject = (CheckBoxPreference)this.screen.bAi("contact_info_locate");
        if (!this.MVg.dO(false).aAL()) {
          break label531;
        }
        ((CheckBoxPreference)localObject).setChecked(this.MVg.aAI());
      }
    }
    for (;;)
    {
      if (this.MVg.aAH())
      {
        if ((this.hcC == null) && (this.MVg != null)) {
          this.hcC = this.MVg.dO(false);
        }
        if ((this.hcC != null) && (this.hcC.aBb()) && (com.tencent.mm.br.c.blq("brandservice")))
        {
          this.screen.eh("contact_info_template_recv", false);
          AppMethodBeat.o(27570);
          return;
          this.screen.eh("contact_is_mute", true);
          break;
          this.screen.eh("contact_is_mute", true);
          break;
          label464:
          localObject = getIntent().getStringExtra("device_id");
          String str = getIntent().getStringExtra("device_type");
          em localem = new em();
          localem.hEt.hEl = ((String)localObject);
          localem.hEt.hEr = str;
          localem.publish();
          bool = localem.hEu.hEv;
          break label225;
          label531:
          this.screen.eh("contact_info_locate", true);
          ((CheckBoxPreference)localObject).setChecked(this.MVg.aAI());
          continue;
        }
        this.screen.eh("contact_info_template_recv", true);
        AppMethodBeat.o(27570);
        return;
      }
    }
    this.screen.eh("contact_info_template_recv", true);
    AppMethodBeat.o(27570);
    return;
    label600:
    this.screen.eh("contact_info_subscribe_bizinfo", true);
    this.screen.eh("contact_info_locate", true);
    this.screen.eh("contact_info_template_recv", true);
    this.screen.eh("contact_info_subscribe_msg", true);
    AppMethodBeat.o(27570);
    return;
    label661:
    Log.w("MicroMsg.NewBizInfoSettingUI", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
    gBy();
    if (afM(this.pUt))
    {
      if (this.MVg == null)
      {
        Log.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
        AppMethodBeat.o(27570);
        return;
      }
      ((CheckBoxPreference)this.screen.bAi("contact_info_subscribe_bizinfo")).setChecked(this.MVg.aAH());
      this.screen.eh("contact_info_subscribe_bizinfo", false);
    }
    AppMethodBeat.o(27570);
    return;
    label765:
    if (d.rs(this.contact.field_type))
    {
      if (this.MVg != null)
      {
        ((CheckBoxPreference)this.screen.bAi("contact_info_subscribe_bizinfo")).setChecked(this.MVg.aAH());
        if (this.MVg.aAH())
        {
          if ((this.hcC == null) && (this.MVg != null)) {
            this.hcC = this.MVg.dO(false);
          }
          if ((this.hcC != null) && (this.hcC.aBb()) && (com.tencent.mm.br.c.blq("brandservice"))) {
            this.screen.eh("contact_info_template_recv", false);
          }
        }
        for (;;)
        {
          localObject = (CheckBoxPreference)this.screen.bAi("contact_info_locate");
          if (!this.MVg.dO(false).aAL()) {
            break;
          }
          ((CheckBoxPreference)localObject).setChecked(this.MVg.aAI());
          AppMethodBeat.o(27570);
          return;
          this.screen.eh("contact_info_template_recv", true);
          continue;
          this.screen.eh("contact_info_template_recv", true);
        }
        this.screen.eh("contact_info_locate", true);
        ((CheckBoxPreference)localObject).setChecked(this.MVg.aAI());
        AppMethodBeat.o(27570);
      }
    }
    else
    {
      Log.w("MicroMsg.NewBizInfoSettingUI", "%s is not my contact", new Object[] { this.contact.field_username });
      gBy();
      if (afM(this.pUt))
      {
        if (this.MVg == null)
        {
          Log.e("MicroMsg.NewBizInfoSettingUI", "bizinfo is null in temp session");
          AppMethodBeat.o(27570);
          return;
        }
        ((CheckBoxPreference)this.screen.bAi("contact_info_subscribe_bizinfo")).setChecked(this.MVg.aAH());
        this.screen.eh("contact_info_subscribe_bizinfo", false);
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
      if ((bool) && (paramIntent != null) && (this.MVg != null) && (this.NbZ != null))
      {
        com.tencent.mm.msgsubscription.api.c localc = new com.tencent.mm.msgsubscription.api.c();
        localc.setUsername(Util.nullAs(this.MVg.field_username, ""));
        localc.pis.addAll(paramIntent.pis);
        localc.piy = paramIntent.pit;
        localc.piB = new com.tencent.mm.msgsubscription.api.a()
        {
          public final void a(String paramAnonymousString, SubscribeMsgRequestResult paramAnonymousSubscribeMsgRequestResult)
          {
            AppMethodBeat.i(27561);
            Log.i("MicroMsg.NewBizInfoSettingUI", "alvinluo updateSubscribeMsgList success");
            NewBizInfoSettingUI.b(NewBizInfoSettingUI.this, paramAnonymousSubscribeMsgRequestResult);
            AppMethodBeat.o(27561);
          }
          
          public final void j(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
          {
            AppMethodBeat.i(27562);
            Log.e("MicroMsg.NewBizInfoSettingUI", "alvinluo updateSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(27562);
          }
        };
        this.NbZ.a(localc);
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
    this.NbY = (System.currentTimeMillis() / 1000L);
    setMMTitle(R.l.gBc);
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
    bh.bCz();
    this.contact = com.tencent.mm.model.c.bzA().JE(paramBundle);
    this.MVg = g.hU(paramBundle);
    if (this.contact != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.MVg != null) {
        bool2 = true;
      }
      Log.i("MicroMsg.NewBizInfoSettingUI", "user:%s contact:%b, bizInfo:%b", new Object[] { paramBundle, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.pUt = getIntent().getIntExtra("Contact_Scene", 9);
      this.NbX = getIntent().getLongExtra("key_profile_enter_timestamp", 0L);
      initView();
      AC(true);
      AppMethodBeat.o(27568);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27569);
    super.onDestroy();
    this.Nca.clear();
    AC(false);
    AppMethodBeat.o(27569);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, final Preference paramPreference)
  {
    AppMethodBeat.i(27574);
    Object localObject1 = paramPreference.mKey;
    Log.i("MicroMsg.NewBizInfoSettingUI", (String)localObject1 + " item has been clicked!");
    Object localObject2 = this.Nca.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((NewBizInfoSettingUI.a)((Iterator)localObject2).next()).a(paramPreference);
    }
    label166:
    boolean bool;
    if ("contact_info_locate".endsWith((String)localObject1))
    {
      paramPreference = this.MVg;
      if (paramPreference == null)
      {
        AppMethodBeat.o(27574);
        return true;
      }
      if (paramPreference.aAI())
      {
        paramPreference.field_brandFlag &= 0xFFFFFFFB;
        a(paramPreference, false);
        if (!((CheckBoxPreference)paramf.bAi("contact_info_locate")).isChecked()) {
          break label743;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(this.contact.field_username, 905, this.NbX, getIntent());
      }
    }
    else
    {
      if ("contact_info_add_shortcut_btn".equals(localObject1))
      {
        Log.d("MicroMsg.NewBizInfoSettingUI", "dealAddShortcut, username = " + this.contact.field_username);
        com.tencent.mm.plugin.base.model.b.aj(this, this.contact.field_username);
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
            com.tencent.mm.plugin.base.model.b.ai(NewBizInfoSettingUI.this, NewBizInfoSettingUI.b(NewBizInfoSettingUI.this).field_username);
            com.tencent.mm.plugin.base.model.b.T(NewBizInfoSettingUI.this);
            AppMethodBeat.o(27566);
          }
        }, 1000L);
      }
      if ("contact_info_clear_msg".equals(localObject1))
      {
        if ((this.MVg != null) && (this.MVg.aAM()))
        {
          this.oww = new ezh();
          this.oww.abAw = 0;
          paramPreference = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM(this.contact.field_username);
          if (paramPreference != null) {
            this.oww.abAu = paramPreference.field_unReadCount;
          }
          paramPreference = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG(this.contact.field_username);
          if (paramPreference != null)
          {
            this.oww.abAv = paramPreference.getType();
            if (this.oww.abAu > 0) {
              this.oww.abAt = ((int)(System.currentTimeMillis() - paramPreference.getCreateTime()) / 1000);
            }
          }
        }
        k.b(this, getString(R.l.gAL), "", getString(R.l.gAJ), getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(27560);
            NewBizInfoSettingUI.d(NewBizInfoSettingUI.this);
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(NewBizInfoSettingUI.b(NewBizInfoSettingUI.this).field_username, 910, NewBizInfoSettingUI.c(NewBizInfoSettingUI.this), NewBizInfoSettingUI.this.getIntent());
            NewBizInfoSettingUI.e(NewBizInfoSettingUI.this);
            AppMethodBeat.o(27560);
          }
        }, null);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(this.contact.field_username, 909, this.NbX, getIntent());
      }
      if ("contact_is_mute".endsWith((String)localObject1))
      {
        if (this.lAj) {
          break label767;
        }
        bool = true;
        label472:
        this.lAj = bool;
        if (!this.lAj) {
          break label773;
        }
        ab.G(this.contact);
      }
    }
    for (;;)
    {
      Au(this.lAj);
      if ("contact_info_template_recv".equals(localObject1))
      {
        paramPreference = new Intent();
        paramPreference.putExtra("enterprise_biz_name", this.MVg.field_username);
        com.tencent.mm.br.c.b(this, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", paramPreference);
      }
      if (("contact_info_subscribe_msg".equals(localObject1)) && (this.oyD != null))
      {
        paramPreference = new Intent();
        paramPreference.putExtra("key_biz_username", this.MVg.field_username);
        paramPreference.putExtra("key_biz_presenter_class", com.tencent.mm.an.b.a.class.getName());
        paramPreference.putExtra("key_biz_nickname", aa.getDisplayName(this.MVg.field_username));
        paramPreference.putExtra("key_biz_data", this.oyD);
        paramPreference.putExtra("key_need_update", false);
        paramPreference.putExtra("key_enter_scene", 1);
        com.tencent.mm.br.c.d(this, "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", paramPreference, 1001);
      }
      if (!"contact_info_subscribe_bizinfo".endsWith((String)localObject1)) {
        break label986;
      }
      paramPreference = this.MVg;
      if (paramPreference != null) {
        break label783;
      }
      AppMethodBeat.o(27574);
      return true;
      this.MXf = k.a(this, getString(R.l.gwX, new Object[] { this.contact.aSV() }), getString(R.l.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27558);
          paramPreference.field_hadAlert = 1;
          paramPreference.field_brandFlag |= 0x4;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, paramPreference, true);
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(NewBizInfoSettingUI.b(NewBizInfoSettingUI.this).field_username, 906, NewBizInfoSettingUI.c(NewBizInfoSettingUI.this), NewBizInfoSettingUI.this.getIntent());
          AppMethodBeat.o(27558);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(27559);
          paramPreference.field_hadAlert = 1;
          NewBizInfoSettingUI.a(NewBizInfoSettingUI.this, paramPreference, false);
          AppMethodBeat.o(27559);
        }
      });
      break;
      label743:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(this.contact.field_username, 907, this.NbX, getIntent());
      break label166;
      label767:
      bool = false;
      break label472;
      label773:
      ab.H(this.contact);
    }
    label783:
    label884:
    int i;
    if (paramPreference.aAH())
    {
      paramPreference.field_brandFlag |= 0x1;
      if ((this.hcC == null) && (paramPreference != null)) {
        this.hcC = paramPreference.dO(false);
      }
      if ((this.hcC != null) && (this.hcC.aBb()) && (com.tencent.mm.br.c.blq("brandservice")))
      {
        paramf.eh("contact_info_template_recv", false);
        long l = System.currentTimeMillis() / 1000L;
        localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.vFk;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.v(paramPreference.field_username, l, this.NbY);
        localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
        localObject2 = paramPreference.field_username;
        if (!paramPreference.aAH()) {
          break label1033;
        }
        i = 3;
        label904:
        ((com.tencent.mm.plugin.report.service.h)localObject1).b(13307, new Object[] { localObject2, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0) });
        a(paramPreference, false);
        if (!((CheckBoxPreference)paramf.bAi("contact_info_subscribe_bizinfo")).isChecked()) {
          break label1038;
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(this.contact.field_username, 901, this.NbX, getIntent());
      }
    }
    for (;;)
    {
      label986:
      AppMethodBeat.o(27574);
      return false;
      paramf.eh("contact_info_template_recv", true);
      break;
      paramPreference.field_brandFlag &= 0xFFFFFFFE;
      paramf.eh("contact_info_template_recv", true);
      break label884;
      label1033:
      i = 4;
      break label904;
      label1038:
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(this.contact.field_username, 902, this.NbX, getIntent());
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