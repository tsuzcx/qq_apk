package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.i.a.ac;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.af.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.vfs.o;

public class SettingsPersonalInfoUI
  extends MMPreference
  implements i, MStorageEx.IOnStorageChange
{
  private j Ddp;
  private boolean jZU;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void eSZ()
  {
    AppMethodBeat.i(74313);
    Preference localPreference = this.screen.bmg("settings_username");
    String str1 = z.aTZ();
    String str2 = z.aTY();
    if (Util.isNullOrNil(str1)) {
      if (as.bjx(str2))
      {
        localPreference.setSummary(getString(2131765520));
        if ((!as.bjy(z.aTY())) && (com.tencent.mm.n.h.aqJ().getInt("EnableModAlias", 0) == 0)) {
          localPreference.alO(8);
        }
      }
    }
    for (;;)
    {
      if (WeChatBrands.Business.Entries.MeAvatarWeChatId.restricted()) {
        localPreference.alO(8);
      }
      AppMethodBeat.o(74313);
      return;
      localPreference.setSummary(str2);
      break;
      localPreference.setSummary(str1);
      if (com.tencent.mm.n.h.aqJ().getInt("EnableModAlias", 0) == 0) {
        localPreference.alO(8);
      }
    }
  }
  
  private void eTq()
  {
    AppMethodBeat.i(74314);
    HeadImgNewPreference localHeadImgNewPreference = (HeadImgNewPreference)this.screen.bmg("settings_change_avatar");
    localHeadImgNewPreference.bmf(z.aTY());
    localHeadImgNewPreference.zHh = new SettingsPersonalInfoUI.2(this);
    AppMethodBeat.o(74314);
  }
  
  private void eTr()
  {
    AppMethodBeat.i(256588);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, SettingsModifyPatSuffixUI.class);
    ((Intent)localObject).putExtras(getIntent());
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goToSetPatSuffix", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goToSetPatSuffix", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(256588);
  }
  
  private void uu(boolean paramBoolean)
  {
    AppMethodBeat.i(256589);
    if (!((aj)g.ah(aj.class)).getFinderSwitchApi().dCr()) {}
    for (int i = 1; (i != 0) && (paramBoolean); i = 0)
    {
      this.screen.jdMethod_do("settings_finder_recent_like", false);
      AppMethodBeat.o(256589);
      return;
    }
    this.screen.jdMethod_do("settings_finder_recent_like", true);
    AppMethodBeat.o(256589);
  }
  
  public int getResourceId()
  {
    return 2132017279;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74310);
    setMMTitle(2131765526);
    g.aAh().azQ().add(this);
    this.screen = getPreferenceScreen();
    setBackBtn(new SettingsPersonalInfoUI.1(this));
    AppMethodBeat.o(74310);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74315);
    Log.i("MicroMsg.SettingsPersonalInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 3) || (paramInt1 == 2) || (paramInt1 == 4)) {
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74305);
            xr localxr = new xr();
            localxr.edW.edY = true;
            EventCenter.instance.publish(localxr);
            AppMethodBeat.o(74305);
          }
        });
      }
      AppMethodBeat.o(74315);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(74315);
      return;
    case 3: 
      paramIntent = s.h(getApplicationContext(), paramIntent, d.aSY());
      if (paramIntent == null)
      {
        AppMethodBeat.o(74315);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramIntent);
      ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
      ((Intent)localObject).putExtra("CropImage_from_scene", 3);
      com.tencent.mm.plugin.setting.c.jRt.a(this, (Intent)localObject, 4);
      AppMethodBeat.o(74315);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(74315);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_Filter", true);
      p.aYn();
      ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.aj.e.M(z.aTY() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      ((Intent)localObject).putExtra("CropImage_from_scene", 3);
      com.tencent.mm.plugin.setting.c.jRt.a(this, paramIntent, (Intent)localObject, d.aSY(), 4, null);
      AppMethodBeat.o(74315);
      return;
    }
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74306);
        xr localxr = new xr();
        localxr.edW.edY = true;
        EventCenter.instance.publish(localxr);
        AppMethodBeat.o(74306);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(74315);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = z.aTY();
    p.aYn();
    localObject = com.tencent.mm.aj.e.Mo((String)localObject);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
      AppMethodBeat.o(74315);
      return;
    }
    Log.i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new o(paramIntent).length()) });
    new n(getContext(), paramIntent).G(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74307);
        Log.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(g.aAc()), z.aTY() });
        if (g.aAc())
        {
          if (this.val$bitmap != null)
          {
            p.aYn();
            str = com.tencent.mm.aj.e.M(z.aTY() + ".last", true);
            PreviewHdHeadImg.e(this.val$bitmap, str);
          }
          String str = com.tencent.mm.aj.c.Me(z.aTY());
          bf.iDu.Km(str);
        }
        SettingsPersonalInfoUI.a(SettingsPersonalInfoUI.this);
        if (SettingsPersonalInfoUI.b(SettingsPersonalInfoUI.this)) {
          com.tencent.mm.plugin.report.service.h.CyF.a(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(4) });
        }
        AppMethodBeat.o(74307);
      }
    });
    AppMethodBeat.o(74315);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74308);
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("jumptoPat", false)) {
      eTr();
    }
    initView();
    if (getIntent().getBooleanExtra("intent_set_avatar", false))
    {
      this.jZU = getIntent().getBooleanExtra("KEnterFromBanner", false);
      com.tencent.mm.plugin.account.a.a.jRu.s(this);
    }
    g.azz().a(1191, this);
    AppMethodBeat.o(74308);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74309);
    Log.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
    if (g.aAc()) {
      g.aAh().azQ().remove(this);
    }
    if (this.Ddp != null) {
      g.azz().a(this.Ddp);
    }
    g.azz().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(74309);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74316);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != g.aAh().azQ()) || (i <= 0))
    {
      Log.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(74316);
      return;
    }
    eSZ();
    AppMethodBeat.o(74316);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74312);
    paramf = paramPreference.mKey;
    Log.d("MicroMsg.SettingsPersonalInfoUI", "key = ".concat(String.valueOf(paramf)));
    if (paramf.equals("settings_change_avatar"))
    {
      boolean bool = com.tencent.mm.plugin.account.a.a.jRu.s(this);
      AppMethodBeat.o(74312);
      return bool;
    }
    if (paramf.equals("settings_username"))
    {
      if (WeChatBrands.Business.Entries.MeAvatarWeChatId.restricted())
      {
        AppMethodBeat.o(74312);
        return true;
      }
      if ((Util.isNullOrNil(z.aTZ())) && (as.bjy(z.aTY())) && (com.tencent.mm.n.h.aqJ().getInt("EnableModAlias", 0) == 0))
      {
        startActivity(SettingsCreateAliasUI.class);
        AppMethodBeat.o(74312);
        return true;
      }
      if (com.tencent.mm.n.h.aqJ().getInt("EnableModAlias", 0) != 0)
      {
        paramf = new Intent(this, SettingsAliasUI.class);
        paramf.putExtra("WizardRootClass", SettingsPersonalInfoUI.class.getCanonicalName());
        MMWizardActivity.ay(this, paramf);
      }
      AppMethodBeat.o(74312);
      return true;
    }
    if (paramf.equals("settings_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsModifyNameUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74312);
      return true;
    }
    if (paramf.equals("settings_qrcode"))
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11264, new Object[] { Integer.valueOf(2) });
      paramf = getContext();
      paramPreference = new Intent(this, SelfQRCodeUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(74312);
        return false;
        if (paramf.equals("settings_more_info"))
        {
          paramf = new Intent(this, SettingsPersonalMoreUI.class);
          paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          if (paramf.equals("settings_address"))
          {
            if (!WeChatBrands.Business.Entries.MeAvatarAddress.checkAvailable(getContext()))
            {
              AppMethodBeat.o(74312);
              return true;
            }
            paramf = new Intent();
            paramf.putExtra("launch_from_webview", false);
            com.tencent.mm.br.c.c(getContext(), "address", ".ui.WalletSelectAddrUI", paramf);
            AppMethodBeat.o(74312);
            return true;
          }
          if (paramf.equals("settings_invoice"))
          {
            if (!WeChatBrands.Business.Entries.MeAvatarInvoiceTitle.checkAvailable(getContext()))
            {
              AppMethodBeat.o(74312);
              return true;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(14199, new Object[] { Integer.valueOf(1) });
            paramf = new Intent();
            paramf.putExtra("launch_from_webview", false);
            com.tencent.mm.br.c.c(getContext(), "address", ".ui.InvoiceListUI", paramf);
            AppMethodBeat.o(74312);
            return true;
          }
          if (paramf.equals("settings_pat"))
          {
            eTr();
          }
          else
          {
            if (!paramf.equals("settings_wecoin")) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(21650, new Object[] { Integer.valueOf(0) });
            paramf = new Intent();
            paramf.putExtra("launch_from_webview", false);
            com.tencent.mm.br.c.c(getContext(), "wallet", ".wecoin.ui.WeCoinRechargeView", paramf);
          }
        }
      }
    } while (!paramf.equals("settings_finder_recent_like"));
    paramf = (String)g.aAh().azQ().get(4, null);
    if (Util.isNullOrNil(paramf)) {
      paramf = "";
    }
    for (;;)
    {
      ((aj)g.ah(aj.class)).getFinderUtilApi().b(this, z.aTY(), paramf, 92);
      break;
    }
  }
  
  public void onResume()
  {
    boolean bool2 = true;
    AppMethodBeat.i(74311);
    eSZ();
    eTq();
    Object localObject = (String)g.aAh().azQ().get(4, null);
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      this.screen.bmg("settings_name").setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject));
    }
    localObject = this.screen.bmg("settings_pat");
    if ((((PluginPatMsg)g.ah(PluginPatMsg.class)).isPatEnable()) && (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smz, 1) != 0))
    {
      this.screen.jdMethod_do("settings_pat", false);
      ((Preference)localObject).setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, (String)g.aAh().azQ().get(ar.a.Oob, null)));
      if ((!Util.isOverseasUser(this)) && (!WeChatBrands.Business.Entries.MeAvatarAddress.banned())) {
        break label379;
      }
      bool1 = true;
      label173:
      this.screen.jdMethod_do("settings_address", bool1);
      if (!((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) {
        break label384;
      }
      this.screen.jdMethod_do("settings_finder_recent_like", true);
      label217:
      bool1 = ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
      boolean bool3 = ((com.tencent.mm.plugin.wallet.wecoin.a.c)g.af(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).dfq();
      localObject = this.screen;
      if ((!bool1) && (bool3)) {
        break label417;
      }
      bool1 = true;
      label263:
      ((com.tencent.mm.ui.base.preference.f)localObject).jdMethod_do("settings_wecoin", bool1);
      bool1 = bool2;
      if (!WeChatBrands.Business.Entries.MeAvatarInvoiceTitle.banned()) {
        if (Util.nullAsFalse(Boolean.valueOf(g.aAh().azQ().getBoolean(ar.a.Obg, false)))) {
          break label422;
        }
      }
    }
    label384:
    label417:
    label422:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.screen.jdMethod_do("settings_invoice", bool1);
      if (bool1)
      {
        this.Ddp = new j();
        g.azz().a(this.Ddp, 0);
      }
      super.onResume();
      AppMethodBeat.o(74311);
      return;
      this.screen.jdMethod_do("settings_pat", true);
      break;
      label379:
      bool1 = false;
      break label173;
      uu(((aj)g.ah(aj.class)).getFinderSwitchApi().a(new af.a() {}));
      break label217;
      bool1 = false;
      break label263;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool = false;
    AppMethodBeat.i(74317);
    if ((WeChatBrands.Business.Entries.MeAvatarInvoiceTitle.banned()) || (!Util.nullAsFalse(Boolean.valueOf(g.aAh().azQ().getBoolean(ar.a.Obg, false))))) {
      bool = true;
    }
    this.screen.jdMethod_do("settings_invoice", bool);
    AppMethodBeat.o(74317);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */