package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.o;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.yy;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.a.ad;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.plugin.wallet.wecoin.a.e;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.u;
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
import com.tencent.mm.ui.base.preference.SummaryTextPreference;

public class SettingsPersonalInfoUI
  extends MMPreference
  implements i, MStorageEx.IOnStorageChange
{
  private j JiT;
  private boolean mRn;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void fGd()
  {
    AppMethodBeat.i(74313);
    Preference localPreference = this.screen.byG("settings_username");
    String str1 = z.bda();
    String str2 = z.bcZ();
    if (Util.isNullOrNil(str1)) {
      if (as.bvU(str2))
      {
        localPreference.aF(getString(b.i.settings_notset));
        if ((!as.bvV(z.bcZ())) && (com.tencent.mm.n.h.axc().getInt("EnableModAlias", 0) == 0)) {
          localPreference.auO(8);
        }
      }
    }
    for (;;)
    {
      if (WeChatBrands.Business.Entries.MeAvatarWeChatId.restricted()) {
        localPreference.auO(8);
      }
      AppMethodBeat.o(74313);
      return;
      localPreference.aF(str2);
      break;
      localPreference.aF(str1);
      if (com.tencent.mm.n.h.axc().getInt("EnableModAlias", 0) == 0) {
        localPreference.auO(8);
      }
    }
  }
  
  private void fGu()
  {
    AppMethodBeat.i(74314);
    HeadImgNewPreference localHeadImgNewPreference = (HeadImgNewPreference)this.screen.byG("settings_change_avatar");
    localHeadImgNewPreference.byF(z.bcZ());
    localHeadImgNewPreference.Fms = new SettingsPersonalInfoUI.2(this);
    AppMethodBeat.o(74314);
  }
  
  private void fGv()
  {
    AppMethodBeat.i(263289);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, SettingsModifyPatSuffixUI.class);
    ((Intent)localObject).putExtras(getIntent());
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goToSetPatSuffix", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goToSetPatSuffix", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(263289);
  }
  
  private void xS(boolean paramBoolean)
  {
    AppMethodBeat.i(263291);
    if (!((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderSwitchApi().edN()) {}
    for (int i = 1; (i != 0) && (paramBoolean); i = 0)
    {
      this.screen.dz("settings_finder_recent_like", false);
      AppMethodBeat.o(263291);
      return;
    }
    this.screen.dz("settings_finder_recent_like", true);
    AppMethodBeat.o(263291);
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_personal_info_new;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74310);
    setMMTitle(b.i.settings_personal_info);
    com.tencent.mm.kernel.h.aHG().aHp().add(this);
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
            yy localyy = new yy();
            localyy.fYl.fYn = true;
            EventCenter.instance.publish(localyy);
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
      paramIntent = u.g(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.bbW());
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
      com.tencent.mm.plugin.setting.c.mIG.a(this, (Intent)localObject, 4);
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
      com.tencent.mm.am.q.bhz();
      ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.am.f.O(z.bcZ() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      ((Intent)localObject).putExtra("CropImage_from_scene", 3);
      com.tencent.mm.plugin.setting.c.mIG.a(this, paramIntent, (Intent)localObject, com.tencent.mm.plugin.image.d.bbW(), 4, null);
      AppMethodBeat.o(74315);
      return;
    }
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74306);
        yy localyy = new yy();
        localyy.fYl.fYn = true;
        EventCenter.instance.publish(localyy);
        AppMethodBeat.o(74306);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(74315);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = z.bcZ();
    com.tencent.mm.am.q.bhz();
    localObject = com.tencent.mm.am.f.TJ((String)localObject);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
      AppMethodBeat.o(74315);
      return;
    }
    Log.i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new com.tencent.mm.vfs.q(paramIntent).length()) });
    new o(getContext(), paramIntent).G(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74307);
        Log.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.h.aHB()), z.bcZ() });
        if (com.tencent.mm.kernel.h.aHB())
        {
          if (this.val$bitmap != null)
          {
            com.tencent.mm.am.q.bhz();
            str = com.tencent.mm.am.f.O(z.bcZ() + ".last", true);
            PreviewHdHeadImg.e(this.val$bitmap, str);
          }
          String str = com.tencent.mm.am.d.Tz(z.bcZ());
          bg.ltv.RF(str);
        }
        SettingsPersonalInfoUI.a(SettingsPersonalInfoUI.this);
        if (SettingsPersonalInfoUI.b(SettingsPersonalInfoUI.this)) {
          com.tencent.mm.plugin.report.service.h.IzE.a(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(4) });
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
      fGv();
    }
    initView();
    if (getIntent().getBooleanExtra("intent_set_avatar", false))
    {
      this.mRn = getIntent().getBooleanExtra("KEnterFromBanner", false);
      com.tencent.mm.plugin.account.sdk.a.mIH.r(this);
    }
    com.tencent.mm.kernel.h.aGY().a(1191, this);
    AppMethodBeat.o(74308);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74309);
    Log.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
    if (com.tencent.mm.kernel.h.aHB()) {
      com.tencent.mm.kernel.h.aHG().aHp().remove(this);
    }
    if (this.JiT != null) {
      com.tencent.mm.kernel.h.aGY().a(this.JiT);
    }
    com.tencent.mm.kernel.h.aGY().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(74309);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74316);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.h.aHG().aHp()) || (i <= 0))
    {
      Log.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(74316);
      return;
    }
    fGd();
    AppMethodBeat.o(74316);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74312);
    paramf = paramPreference.mKey;
    Log.d("MicroMsg.SettingsPersonalInfoUI", "key = ".concat(String.valueOf(paramf)));
    if (paramf.equals("settings_change_avatar"))
    {
      boolean bool = com.tencent.mm.plugin.account.sdk.a.mIH.r(this);
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
      if ((Util.isNullOrNil(z.bda())) && (as.bvV(z.bcZ())) && (com.tencent.mm.n.h.axc().getInt("EnableModAlias", 0) == 0))
      {
        startActivity(SettingsCreateAliasUI.class);
        AppMethodBeat.o(74312);
        return true;
      }
      if (com.tencent.mm.n.h.axc().getInt("EnableModAlias", 0) != 0)
      {
        paramf = new Intent(this, SettingsAliasUI.class);
        paramf.putExtra("WizardRootClass", SettingsPersonalInfoUI.class.getCanonicalName());
        MMWizardActivity.aH(this, paramf);
      }
      AppMethodBeat.o(74312);
      return true;
    }
    if (paramf.equals("settings_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsModifyNameUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74312);
      return true;
    }
    if (paramf.equals("settings_qrcode"))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11264, new Object[] { Integer.valueOf(2) });
      paramf = getContext();
      paramPreference = new Intent(this, SelfQRCodeUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.sf(0));
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
          paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.sf(0));
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
            com.tencent.mm.by.c.c(getContext(), "address", ".ui.WalletSelectAddrUI", paramf);
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
            com.tencent.mm.plugin.report.service.h.IzE.a(14199, new Object[] { Integer.valueOf(1) });
            paramf = new Intent();
            paramf.putExtra("launch_from_webview", false);
            com.tencent.mm.by.c.c(getContext(), "address", ".ui.InvoiceListUI", paramf);
            AppMethodBeat.o(74312);
            return true;
          }
          if (paramf.equals("settings_pat"))
          {
            fGv();
          }
          else
          {
            if (!paramf.equals("settings_wecoin")) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(21650, new Object[] { Integer.valueOf(0) });
            paramf = new Intent();
            paramf.putExtra("launch_from_webview", false);
            com.tencent.mm.by.c.c(getContext(), "wallet", ".wecoin.ui.WeCoinRechargeView", paramf);
          }
        }
      }
    } while (!paramf.equals("settings_finder_recent_like"));
    paramf = (String)com.tencent.mm.kernel.h.aHG().aHp().b(4, null);
    if (Util.isNullOrNil(paramf)) {
      paramf = "";
    }
    for (;;)
    {
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().c(this, z.bcZ(), paramf, 92);
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74311);
    fGd();
    fGu();
    Object localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().b(4, null);
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      this.screen.byG("settings_name").aF(com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject));
    }
    localObject = this.screen.byG("settings_pat");
    boolean bool1;
    label171:
    label215:
    label248:
    final SummaryTextPreference localSummaryTextPreference;
    label329:
    long l;
    if ((((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).isPatEnable()) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXu, 1) != 0))
    {
      this.screen.dz("settings_pat", false);
      ((Preference)localObject).aF(com.tencent.mm.pluginsdk.ui.span.l.c(this, (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VDu, null)));
      if ((!Util.isOverseasUser(this)) && (!WeChatBrands.Business.Entries.MeAvatarAddress.banned())) {
        break label509;
      }
      bool1 = true;
      this.screen.dz("settings_address", bool1);
      if (!((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM()) {
        break label514;
      }
      this.screen.dz("settings_finder_recent_like", true);
      if ((!WeChatBrands.Business.Entries.MeAvatarInvoiceTitle.banned()) && (Util.nullAsFalse(Boolean.valueOf(com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vpj, false))))) {
        break label547;
      }
      bool1 = true;
      this.screen.dz("settings_invoice", bool1);
      if (bool1)
      {
        this.JiT = new j();
        com.tencent.mm.kernel.h.aGY().a(this.JiT, 0);
      }
      bool1 = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
      boolean bool2 = ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).dxX();
      if ((!bool1) && (bool2)) {
        break label552;
      }
      bool1 = true;
      localSummaryTextPreference = (SummaryTextPreference)this.screen.byG("settings_wecoin");
      this.screen.dz("settings_wecoin", bool1);
      if (!bool1)
      {
        l = ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).gIg().longValue();
        Log.i("MicroMsg.SettingsPersonalInfoUI", "updateWeCoinEntry balance catch: %s", new Object[] { Long.valueOf(l) });
        if (l <= 0L) {
          break label557;
        }
      }
    }
    label514:
    label547:
    label552:
    label557:
    for (localObject = l + " " + getString(b.i.settings_weconin_unit_text);; localObject = "")
    {
      localSummaryTextPreference.WsZ = "fonts/WeChatSansSS-Regular.ttf";
      localSummaryTextPreference.aF((CharSequence)localObject);
      ((com.tencent.mm.plugin.wallet.wecoin.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.wallet.wecoin.a.c.class)).a(new e()
      {
        public final void p(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString) {}
      });
      super.onResume();
      AppMethodBeat.o(74311);
      return;
      this.screen.dz("settings_pat", true);
      break;
      label509:
      bool1 = false;
      break label171;
      xS(((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderSwitchApi().b(new SettingsPersonalInfoUI.6(this)));
      break label215;
      bool1 = false;
      break label248;
      bool1 = false;
      break label329;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    boolean bool = false;
    AppMethodBeat.i(74317);
    if ((WeChatBrands.Business.Entries.MeAvatarInvoiceTitle.banned()) || (!Util.nullAsFalse(Boolean.valueOf(com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vpj, false))))) {
      bool = true;
    }
    this.screen.dz("settings_invoice", bool);
    AppMethodBeat.o(74317);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */