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
import com.tencent.mm.g.a.vk;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPersonalInfoUI
  extends MMPreference
  implements com.tencent.mm.al.g, n.b
{
  private boolean ifG;
  private f screen;
  private com.tencent.mm.plugin.setting.model.h wil;
  
  private void dnQ()
  {
    AppMethodBeat.i(74313);
    Preference localPreference = this.screen.aKk("settings_username");
    String str1 = u.aqH();
    String str2 = u.aqG();
    if (bt.isNullOrNil(str1))
    {
      if (af.aHK(str2)) {
        localPreference.setSummary(getString(2131763339));
      }
      while ((!af.aHL(u.aqG())) && (com.tencent.mm.m.g.Zd().getInt("EnableModAlias", 0) == 0))
      {
        localPreference.Yb(8);
        AppMethodBeat.o(74313);
        return;
        localPreference.setSummary(str2);
      }
    }
    localPreference.setSummary(str1);
    if (com.tencent.mm.m.g.Zd().getInt("EnableModAlias", 0) == 0) {
      localPreference.Yb(8);
    }
    AppMethodBeat.o(74313);
  }
  
  private void dof()
  {
    AppMethodBeat.i(74314);
    HeadImgNewPreference localHeadImgNewPreference = (HeadImgNewPreference)this.screen.aKk("settings_change_avatar");
    localHeadImgNewPreference.aKj(u.aqG());
    localHeadImgNewPreference.tOp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74304);
        Object localObject = new Intent(SettingsPersonalInfoUI.this, PreviewHdHeadImg.class);
        paramAnonymousView = SettingsPersonalInfoUI.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(74304);
      }
    };
    AppMethodBeat.o(74314);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(74316);
    int i = bt.i(paramObject, 0);
    ad.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.afB().afk()) || (i <= 0))
    {
      ad.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(74316);
      return;
    }
    dnQ();
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
    com.tencent.mm.kernel.g.afB().afk().a(this);
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
            vk localvk = new vk();
            localvk.dAU.dAW = true;
            com.tencent.mm.sdk.b.a.ESL.l(localvk);
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
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.apW());
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
      b.hYt.a(this, (Intent)localObject, 4);
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
      p.auq();
      ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.ak.e.J(u.aqG() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      ((Intent)localObject).putExtra("CropImage_from_scene", 3);
      b.hYt.a(this, paramIntent, (Intent)localObject, com.tencent.mm.plugin.image.d.apW(), 4, null);
      AppMethodBeat.o(74315);
      return;
    }
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74306);
        vk localvk = new vk();
        localvk.dAU.dAW = true;
        com.tencent.mm.sdk.b.a.ESL.l(localvk);
        AppMethodBeat.o(74306);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(74315);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = u.aqG();
    p.auq();
    localObject = com.tencent.mm.ak.e.vW((String)localObject);
    if (paramIntent == null)
    {
      ad.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
      AppMethodBeat.o(74315);
      return;
    }
    ad.i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new com.tencent.mm.vfs.e(paramIntent).length()) });
    new com.tencent.mm.ak.n(getContext(), paramIntent).D(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74307);
        ad.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.afw()), u.aqG() });
        if (com.tencent.mm.kernel.g.afw())
        {
          if (this.val$bitmap != null)
          {
            p.auq();
            str = com.tencent.mm.ak.e.J(u.aqG() + ".last", true);
            PreviewHdHeadImg.e(this.val$bitmap, str);
          }
          String str = c.vN(u.aqG());
          ay.gNa.ua(str);
        }
        SettingsPersonalInfoUI.a(SettingsPersonalInfoUI.this);
        if (SettingsPersonalInfoUI.b(SettingsPersonalInfoUI.this)) {
          com.tencent.mm.plugin.report.service.h.vKh.f(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(4) });
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
    initView();
    if (getIntent().getBooleanExtra("intent_set_avatar", false))
    {
      this.ifG = getIntent().getBooleanExtra("KEnterFromBanner", false);
      com.tencent.mm.plugin.account.a.a.hYu.s(this);
    }
    com.tencent.mm.kernel.g.aeS().a(1191, this);
    AppMethodBeat.o(74308);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74309);
    ad.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
    if (com.tencent.mm.kernel.g.afw()) {
      com.tencent.mm.kernel.g.afB().afk().b(this);
    }
    if (this.wil != null) {
      com.tencent.mm.kernel.g.aeS().a(this.wil);
    }
    com.tencent.mm.kernel.g.aeS().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(74309);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74312);
    paramf = paramPreference.mKey;
    ad.d("MicroMsg.SettingsPersonalInfoUI", "key = ".concat(String.valueOf(paramf)));
    if (paramf.equals("settings_change_avatar"))
    {
      boolean bool = com.tencent.mm.plugin.account.a.a.hYu.s(this);
      AppMethodBeat.o(74312);
      return bool;
    }
    if (paramf.equals("settings_username"))
    {
      if ((bt.isNullOrNil(u.aqH())) && (af.aHL(u.aqG())) && (com.tencent.mm.m.g.Zd().getInt("EnableModAlias", 0) == 0))
      {
        startActivity(SettingsCreateAliasUI.class);
        AppMethodBeat.o(74312);
        return true;
      }
      if (com.tencent.mm.m.g.Zd().getInt("EnableModAlias", 0) != 0)
      {
        paramf = new Intent(this, SettingsAliasUI.class);
        paramf.putExtra("WizardRootClass", SettingsPersonalInfoUI.class.getCanonicalName());
        MMWizardActivity.V(this, paramf);
      }
      AppMethodBeat.o(74312);
      return true;
    }
    if (paramf.equals("settings_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsModifyNameUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74312);
      return true;
    }
    if (paramf.equals("settings_qrcode"))
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(11264, new Object[] { Integer.valueOf(2) });
      paramf = getContext();
      paramPreference = new Intent(this, SelfQRCodeUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bd(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(74312);
        return false;
        if (!paramf.equals("settings_more_info")) {
          break;
        }
        paramf = new Intent(this, SettingsPersonalMoreUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      if (paramf.equals("settings_address"))
      {
        paramf = new Intent();
        paramf.putExtra("launch_from_webview", false);
        com.tencent.mm.bs.d.c(getContext(), "address", ".ui.WalletSelectAddrUI", paramf);
        AppMethodBeat.o(74312);
        return true;
      }
    } while (!paramf.equals("settings_invoice"));
    com.tencent.mm.plugin.report.service.h.vKh.f(14199, new Object[] { Integer.valueOf(1) });
    paramf = new Intent();
    paramf.putExtra("launch_from_webview", false);
    com.tencent.mm.bs.d.c(getContext(), "address", ".ui.InvoiceListUI", paramf);
    AppMethodBeat.o(74312);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74311);
    dnQ();
    dof();
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(4, null);
    if ((str != null) && (str.length() > 0)) {
      this.screen.aKk("settings_name").setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, str));
    }
    boolean bool = bt.iP(this);
    this.screen.cE("settings_address", bool);
    if (!bt.l(Boolean.valueOf(com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.Foo, false))))
    {
      this.screen.cE("settings_invoice", true);
      this.wil = new com.tencent.mm.plugin.setting.model.h();
      com.tencent.mm.kernel.g.aeS().a(this.wil, 0);
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(74311);
      return;
      this.screen.cE("settings_invoice", false);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(74317);
    if (!bt.l(Boolean.valueOf(com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.Foo, false))))
    {
      this.screen.cE("settings_invoice", true);
      AppMethodBeat.o(74317);
      return;
    }
    this.screen.cE("settings_invoice", false);
    AppMethodBeat.o(74317);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */