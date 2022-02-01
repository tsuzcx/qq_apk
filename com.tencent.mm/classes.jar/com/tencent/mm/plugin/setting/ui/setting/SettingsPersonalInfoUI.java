package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.aar;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.o;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.findersdk.a.bv;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SummaryTextPreference;
import com.tencent.mm.vfs.u;

public class SettingsPersonalInfoUI
  extends MMPreference
  implements com.tencent.mm.am.h, MStorageEx.IOnStorageChange
{
  private com.tencent.mm.plugin.setting.model.l Pvm;
  private boolean pNU;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void CR(boolean paramBoolean)
  {
    AppMethodBeat.i(299233);
    if (!((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderSwitchApi().ffE()) {}
    for (int i = 1; (i != 0) && (paramBoolean); i = 0)
    {
      this.screen.eh("settings_finder_recent_like", false);
      AppMethodBeat.o(299233);
      return;
    }
    this.screen.eh("settings_finder_recent_like", true);
    AppMethodBeat.o(299233);
  }
  
  private void gVx()
  {
    AppMethodBeat.i(74313);
    Preference localPreference = this.screen.bAi("settings_username");
    String str1 = z.bAN();
    String str2 = z.bAM();
    if (Util.isNullOrNil(str1)) {
      if (au.bxb(str2))
      {
        localPreference.aS(getString(b.i.settings_notset));
        if ((!au.bxc(z.bAM())) && (com.tencent.mm.k.i.aRC().getInt("EnableModAlias", 0) == 0)) {
          localPreference.aBq(8);
        }
      }
    }
    for (;;)
    {
      if (WeChatBrands.Business.Entries.MeAvatarWeChatId.restricted()) {
        localPreference.aBq(8);
      }
      AppMethodBeat.o(74313);
      return;
      localPreference.aS(str2);
      break;
      localPreference.aS(str1);
      if (com.tencent.mm.k.i.aRC().getInt("EnableModAlias", 0) == 0) {
        localPreference.aBq(8);
      }
    }
  }
  
  private void gWb()
  {
    AppMethodBeat.i(74314);
    HeadImgNewPreference localHeadImgNewPreference = (HeadImgNewPreference)this.screen.bAi("settings_change_avatar");
    localHeadImgNewPreference.bAh(z.bAM());
    localHeadImgNewPreference.tyA = new SettingsPersonalInfoUI.2(this);
    AppMethodBeat.o(74314);
  }
  
  private void gWc()
  {
    AppMethodBeat.i(299225);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, SettingsModifyPatSuffixUI.class);
    ((Intent)localObject).putExtras(getIntent());
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goToSetPatSuffix", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goToSetPatSuffix", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(299225);
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_personal_info_new;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74310);
    setMMTitle(b.i.settings_personal_info);
    com.tencent.mm.kernel.h.baE().ban().add(this);
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
            AppMethodBeat.i(74306);
            aar localaar = new aar();
            localaar.iel.ien = true;
            localaar.publish();
            AppMethodBeat.o(74306);
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
      paramIntent = t.g(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.bzL());
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
      com.tencent.mm.plugin.setting.c.pFn.a(this, (Intent)localObject, 4);
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
      q.bFp();
      ((Intent)localObject).putExtra("CropImage_OutputPath", AvatarStorage.R(z.bAM() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      ((Intent)localObject).putExtra("CropImage_from_scene", 3);
      com.tencent.mm.plugin.setting.c.pFn.a(this, paramIntent, (Intent)localObject, com.tencent.mm.plugin.image.d.bzL(), null);
      AppMethodBeat.o(74315);
      return;
    }
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74307);
        aar localaar = new aar();
        localaar.iel.ien = true;
        localaar.publish();
        AppMethodBeat.o(74307);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(74315);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = z.bAM();
    q.bFp();
    localObject = AvatarStorage.LJ((String)localObject);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
      AppMethodBeat.o(74315);
      return;
    }
    Log.i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new u(paramIntent).length()) });
    new o(getContext(), paramIntent, false).L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(298871);
        Log.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.h.baz()), z.bAM() });
        if (com.tencent.mm.kernel.h.baz())
        {
          if (this.val$bitmap != null)
          {
            q.bFp();
            str = AvatarStorage.R(z.bAM() + ".last", true);
            PreviewHdHeadImg.h(this.val$bitmap, str);
          }
          String str = com.tencent.mm.modelavatar.d.Lz(z.bAM());
          bg.okT.JD(str);
        }
        SettingsPersonalInfoUI.a(SettingsPersonalInfoUI.this);
        if (SettingsPersonalInfoUI.b(SettingsPersonalInfoUI.this)) {
          com.tencent.mm.plugin.report.service.h.OAn.b(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(4) });
        }
        AppMethodBeat.o(298871);
      }
    });
    AppMethodBeat.o(74315);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74308);
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("jumptoPat", false)) {
      gWc();
    }
    initView();
    if (getIntent().getBooleanExtra("intent_set_avatar", false))
    {
      this.pNU = getIntent().getBooleanExtra("KEnterFromBanner", false);
      com.tencent.mm.plugin.account.sdk.a.pFo.t(this);
    }
    com.tencent.mm.kernel.h.aZW().a(1191, this);
    AppMethodBeat.o(74308);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74309);
    Log.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
    if (com.tencent.mm.kernel.h.baz()) {
      com.tencent.mm.kernel.h.baE().ban().remove(this);
    }
    if (this.Pvm != null) {
      com.tencent.mm.kernel.h.aZW().a(this.Pvm);
    }
    com.tencent.mm.kernel.h.aZW().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(74309);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74316);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.h.baE().ban()) || (i <= 0))
    {
      Log.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(74316);
      return;
    }
    gVx();
    AppMethodBeat.o(74316);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74312);
    paramf = paramPreference.mKey;
    Log.d("MicroMsg.SettingsPersonalInfoUI", "key = ".concat(String.valueOf(paramf)));
    if (paramf.equals("settings_change_avatar"))
    {
      boolean bool = com.tencent.mm.plugin.account.sdk.a.pFo.t(this);
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
      if ((Util.isNullOrNil(z.bAN())) && (au.bxc(z.bAM())) && (com.tencent.mm.k.i.aRC().getInt("EnableModAlias", 0) == 0))
      {
        startActivity(SettingsCreateAliasUI.class);
        AppMethodBeat.o(74312);
        return true;
      }
      if (com.tencent.mm.k.i.aRC().getInt("EnableModAlias", 0) != 0)
      {
        paramf = new Intent(this, SettingsAliasUI.class);
        paramf.putExtra("WizardRootClass", SettingsPersonalInfoUI.class.getCanonicalName());
        MMWizardActivity.aQ(this, paramf);
      }
      AppMethodBeat.o(74312);
      return true;
    }
    if (paramf.equals("settings_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsModifyNameUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74312);
      return true;
    }
    if (paramf.equals("settings_qrcode"))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11264, new Object[] { Integer.valueOf(2) });
      paramf = getContext();
      paramPreference = new Intent(this, SelfQRCodeUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
          paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
            com.tencent.mm.plugin.report.service.h.OAn.b(14199, new Object[] { Integer.valueOf(1) });
            paramf = new Intent();
            paramf.putExtra("launch_from_webview", false);
            com.tencent.mm.br.c.c(getContext(), "address", ".ui.InvoiceListUI", paramf);
            AppMethodBeat.o(74312);
            return true;
          }
          if (paramf.equals("settings_pat"))
          {
            gWc();
          }
          else
          {
            if (!paramf.equals("settings_wecoin")) {
              break;
            }
            if (!((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).ihl())
            {
              com.tencent.mm.plugin.setting.ui.b.a.a(this, true, new SettingsPersonalInfoUI.3(this));
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.OAn.b(21650, new Object[] { Integer.valueOf(0) });
              paramf = new Intent();
              paramf.putExtra("launch_from_webview", false);
              com.tencent.mm.br.c.c(getContext(), "wallet", ".wecoin.ui.WeCoinRechargeView", paramf);
            }
          }
        }
      }
    } while (!paramf.equals("settings_finder_recent_like"));
    paramf = (String)com.tencent.mm.kernel.h.baE().ban().d(4, null);
    if (Util.isNullOrNil(paramf)) {
      paramf = "";
    }
    for (;;)
    {
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().e(this, z.bAM(), paramf, 92);
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74311);
    gVx();
    gWb();
    Object localObject = (String)com.tencent.mm.kernel.h.baE().ban().d(4, null);
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      this.screen.bAi("settings_name").aS(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject));
    }
    localObject = this.screen.bAi("settings_pat");
    boolean bool;
    label150:
    label194:
    label227:
    final SummaryTextPreference localSummaryTextPreference;
    long l;
    if (((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).isPatEnable())
    {
      this.screen.eh("settings_pat", false);
      ((Preference)localObject).aS(com.tencent.mm.pluginsdk.ui.span.p.b(this, (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adgr, null)));
      if ((!Util.isOverseasUser(this)) && (!WeChatBrands.Business.Entries.MeAvatarAddress.banned())) {
        break label463;
      }
      bool = true;
      this.screen.eh("settings_address", bool);
      if (!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) {
        break label468;
      }
      this.screen.eh("settings_finder_recent_like", true);
      if ((!WeChatBrands.Business.Entries.MeAvatarInvoiceTitle.banned()) && (Util.nullAsFalse(Boolean.valueOf(com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acQL, false))))) {
        break label501;
      }
      bool = true;
      this.screen.eh("settings_invoice", bool);
      if (bool)
      {
        this.Pvm = new com.tencent.mm.plugin.setting.model.l();
        com.tencent.mm.kernel.h.aZW().a(this.Pvm, 0);
      }
      bool = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      localSummaryTextPreference = (SummaryTextPreference)this.screen.bAi("settings_wecoin");
      this.screen.eh("settings_wecoin", bool);
      if (!bool)
      {
        l = ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).ihk().longValue();
        Log.i("MicroMsg.SettingsPersonalInfoUI", "updateWeCoinEntry balance catch: %s", new Object[] { Long.valueOf(l) });
        if (l <= 0L) {
          break label506;
        }
      }
    }
    label463:
    label468:
    label501:
    label506:
    for (localObject = l + " " + getString(b.i.settings_weconin_unit_text);; localObject = "")
    {
      localSummaryTextPreference.aeas = "fonts/WeChatSansSS-Regular.ttf";
      localSummaryTextPreference.aS((CharSequence)localObject);
      ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).a(new com.tencent.mm.plugin.wallet.wecoin.a.i()
      {
        public final void s(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString) {}
      });
      super.onResume();
      AppMethodBeat.o(74311);
      return;
      this.screen.eh("settings_pat", true);
      break;
      bool = false;
      break label150;
      CR(((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderSwitchApi().c(new SettingsPersonalInfoUI.7(this)));
      break label194;
      bool = false;
      break label227;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    boolean bool = false;
    AppMethodBeat.i(74317);
    if ((WeChatBrands.Business.Entries.MeAvatarInvoiceTitle.banned()) || (!Util.nullAsFalse(Boolean.valueOf(com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acQL, false))))) {
      bool = true;
    }
    this.screen.eh("settings_invoice", bool);
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