package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.setting.model.h;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsPersonalInfoUI
  extends MMPreference
  implements com.tencent.mm.al.f, n.b
{
  private boolean iYY;
  private com.tencent.mm.ui.base.preference.f screen;
  private h yIp;
  
  private void dNB()
  {
    AppMethodBeat.i(74313);
    Preference localPreference = this.screen.aVD("settings_username");
    String str1 = u.aAn();
    String str2 = u.aAm();
    if (bt.isNullOrNil(str1))
    {
      if (am.aSX(str2)) {
        localPreference.setSummary(getString(2131763339));
      }
      while ((!am.aSY(u.aAm())) && (com.tencent.mm.n.g.acA().getInt("EnableModAlias", 0) == 0))
      {
        localPreference.acw(8);
        AppMethodBeat.o(74313);
        return;
        localPreference.setSummary(str2);
      }
    }
    localPreference.setSummary(str1);
    if (com.tencent.mm.n.g.acA().getInt("EnableModAlias", 0) == 0) {
      localPreference.acw(8);
    }
    AppMethodBeat.o(74313);
  }
  
  private void dNS()
  {
    AppMethodBeat.i(74314);
    HeadImgNewPreference localHeadImgNewPreference = (HeadImgNewPreference)this.screen.aVD("settings_change_avatar");
    localHeadImgNewPreference.aVC(u.aAm());
    localHeadImgNewPreference.waa = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74304);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = new Intent(SettingsPersonalInfoUI.this, PreviewHdHeadImg.class);
        paramAnonymousView = SettingsPersonalInfoUI.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74304);
      }
    };
    AppMethodBeat.o(74314);
  }
  
  private void dNT()
  {
    AppMethodBeat.i(221038);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, SettingsModifyPatSuffixUI.class);
    ((Intent)localObject).putExtras(getIntent());
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goToSetPatSuffix", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goToSetPatSuffix", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(221038);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(74316);
    int i = bt.m(paramObject, 0);
    ad.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.ajC().ajl()) || (i <= 0))
    {
      ad.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(74316);
      return;
    }
    dNB();
    AppMethodBeat.o(74316);
  }
  
  public int getResourceId()
  {
    return 2131951734;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74310);
    setMMTitle(2131763345);
    com.tencent.mm.kernel.g.ajC().ajl().a(this);
    this.screen = getPreferenceScreen();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74303);
        SettingsPersonalInfoUI.this.hideVKB();
        SettingsPersonalInfoUI.this.finish();
        AppMethodBeat.o(74303);
        return true;
      }
    });
    AppMethodBeat.o(74310);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74315);
    ad.i("MicroMsg.SettingsPersonalInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 3) || (paramInt1 == 2) || (paramInt1 == 4)) {
        new ap(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74305);
            wn localwn = new wn();
            localwn.dKS.dKU = true;
            com.tencent.mm.sdk.b.a.IbL.l(localwn);
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
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.i(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.azA());
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
      com.tencent.mm.plugin.setting.b.iRG.a(this, (Intent)localObject, 4);
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
      p.aEk();
      ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.ak.e.K(u.aAm() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      ((Intent)localObject).putExtra("CropImage_from_scene", 3);
      com.tencent.mm.plugin.setting.b.iRG.a(this, paramIntent, (Intent)localObject, com.tencent.mm.plugin.image.d.azA(), 4, null);
      AppMethodBeat.o(74315);
      return;
    }
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74306);
        wn localwn = new wn();
        localwn.dKS.dKU = true;
        com.tencent.mm.sdk.b.a.IbL.l(localwn);
        AppMethodBeat.o(74306);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(74315);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = u.aAm();
    p.aEk();
    localObject = com.tencent.mm.ak.e.Db((String)localObject);
    if (paramIntent == null)
    {
      ad.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
      AppMethodBeat.o(74315);
      return;
    }
    ad.i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new com.tencent.mm.vfs.e(paramIntent).length()) });
    new com.tencent.mm.ak.n(getContext(), paramIntent).E(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74307);
        ad.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.ajx()), u.aAm() });
        if (com.tencent.mm.kernel.g.ajx())
        {
          if (this.val$bitmap != null)
          {
            p.aEk();
            str = com.tencent.mm.ak.e.K(u.aAm() + ".last", true);
            PreviewHdHeadImg.e(this.val$bitmap, str);
          }
          String str = c.CS(u.aAm());
          az.hFS.Be(str);
        }
        SettingsPersonalInfoUI.a(SettingsPersonalInfoUI.this);
        if (SettingsPersonalInfoUI.b(SettingsPersonalInfoUI.this)) {
          com.tencent.mm.plugin.report.service.g.yhR.f(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(4) });
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
      dNT();
    }
    initView();
    if (getIntent().getBooleanExtra("intent_set_avatar", false))
    {
      this.iYY = getIntent().getBooleanExtra("KEnterFromBanner", false);
      com.tencent.mm.plugin.account.a.a.iRH.s(this);
    }
    com.tencent.mm.kernel.g.aiU().a(1191, this);
    AppMethodBeat.o(74308);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74309);
    ad.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
    if (com.tencent.mm.kernel.g.ajx()) {
      com.tencent.mm.kernel.g.ajC().ajl().b(this);
    }
    if (this.yIp != null) {
      com.tencent.mm.kernel.g.aiU().a(this.yIp);
    }
    com.tencent.mm.kernel.g.aiU().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(74309);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74312);
    paramf = paramPreference.mKey;
    ad.d("MicroMsg.SettingsPersonalInfoUI", "key = ".concat(String.valueOf(paramf)));
    if (paramf.equals("settings_change_avatar"))
    {
      boolean bool = com.tencent.mm.plugin.account.a.a.iRH.s(this);
      AppMethodBeat.o(74312);
      return bool;
    }
    if (paramf.equals("settings_username"))
    {
      if ((bt.isNullOrNil(u.aAn())) && (am.aSY(u.aAm())) && (com.tencent.mm.n.g.acA().getInt("EnableModAlias", 0) == 0))
      {
        startActivity(SettingsCreateAliasUI.class);
        AppMethodBeat.o(74312);
        return true;
      }
      if (com.tencent.mm.n.g.acA().getInt("EnableModAlias", 0) != 0)
      {
        paramf = new Intent(this, SettingsAliasUI.class);
        paramf.putExtra("WizardRootClass", SettingsPersonalInfoUI.class.getCanonicalName());
        MMWizardActivity.al(this, paramf);
      }
      AppMethodBeat.o(74312);
      return true;
    }
    if (paramf.equals("settings_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsModifyNameUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74312);
      return true;
    }
    if (paramf.equals("settings_qrcode"))
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11264, new Object[] { Integer.valueOf(2) });
      paramf = getContext();
      paramPreference = new Intent(this, SelfQRCodeUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(74312);
      return false;
      if (paramf.equals("settings_more_info"))
      {
        paramf = new Intent(this, SettingsPersonalMoreUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else
      {
        if (paramf.equals("settings_address"))
        {
          paramf = new Intent();
          paramf.putExtra("launch_from_webview", false);
          com.tencent.mm.bs.d.c(getContext(), "address", ".ui.WalletSelectAddrUI", paramf);
          AppMethodBeat.o(74312);
          return true;
        }
        if (paramf.equals("settings_invoice"))
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(14199, new Object[] { Integer.valueOf(1) });
          paramf = new Intent();
          paramf.putExtra("launch_from_webview", false);
          com.tencent.mm.bs.d.c(getContext(), "address", ".ui.InvoiceListUI", paramf);
          AppMethodBeat.o(74312);
          return true;
        }
        if (paramf.equals("settings_pat")) {
          dNT();
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74311);
    dNB();
    dNS();
    Object localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(4, null);
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      this.screen.aVD("settings_name").setSummary(k.c(this, (CharSequence)localObject));
    }
    localObject = this.screen.aVD("settings_pat");
    if ((((PluginPatMsg)com.tencent.mm.kernel.g.ad(PluginPatMsg.class)).isPatEnable()) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHK, 1) != 0))
    {
      this.screen.cP("settings_pat", false);
      ((Preference)localObject).setSummary(k.c(this, (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IJN, null)));
      boolean bool = bt.jk(this);
      this.screen.cP("settings_address", bool);
      if (bt.o(Boolean.valueOf(com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.Iyv, false)))) {
        break label253;
      }
      this.screen.cP("settings_invoice", true);
      this.yIp = new h();
      com.tencent.mm.kernel.g.aiU().a(this.yIp, 0);
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(74311);
      return;
      this.screen.cP("settings_pat", true);
      break;
      label253:
      this.screen.cP("settings_invoice", false);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(74317);
    if (!bt.o(Boolean.valueOf(com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.Iyv, false))))
    {
      this.screen.cP("settings_invoice", true);
      AppMethodBeat.o(74317);
      return;
    }
    this.screen.cP("settings_invoice", false);
    AppMethodBeat.o(74317);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */