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
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.wr;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.setting.model.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsPersonalInfoUI
  extends MMPreference
  implements com.tencent.mm.ak.f, n.b
{
  private boolean jbR;
  private com.tencent.mm.ui.base.preference.f screen;
  private i yYz;
  
  private void dQY()
  {
    AppMethodBeat.i(74313);
    Preference localPreference = this.screen.aXe("settings_username");
    String str1 = v.aAD();
    String str2 = v.aAC();
    if (bu.isNullOrNil(str1))
    {
      if (an.aUy(str2)) {
        localPreference.setSummary(getString(2131763339));
      }
      while ((!an.aUz(v.aAC())) && (com.tencent.mm.n.g.acL().getInt("EnableModAlias", 0) == 0))
      {
        localPreference.ade(8);
        AppMethodBeat.o(74313);
        return;
        localPreference.setSummary(str2);
      }
    }
    localPreference.setSummary(str1);
    if (com.tencent.mm.n.g.acL().getInt("EnableModAlias", 0) == 0) {
      localPreference.ade(8);
    }
    AppMethodBeat.o(74313);
  }
  
  private void dRp()
  {
    AppMethodBeat.i(74314);
    HeadImgNewPreference localHeadImgNewPreference = (HeadImgNewPreference)this.screen.aXe("settings_change_avatar");
    localHeadImgNewPreference.aXd(v.aAC());
    localHeadImgNewPreference.wme = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74304);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = new Intent(SettingsPersonalInfoUI.this, PreviewHdHeadImg.class);
        paramAnonymousView = SettingsPersonalInfoUI.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74304);
      }
    };
    AppMethodBeat.o(74314);
  }
  
  private void dRq()
  {
    AppMethodBeat.i(190410);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, SettingsModifyPatSuffixUI.class);
    ((Intent)localObject).putExtras(getIntent());
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goToSetPatSuffix", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goToSetPatSuffix", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(190410);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(74316);
    int i = bu.m(paramObject, 0);
    ae.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.ajR().ajA()) || (i <= 0))
    {
      ae.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(74316);
      return;
    }
    dQY();
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
    com.tencent.mm.kernel.g.ajR().ajA().a(this);
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
    ae.i("MicroMsg.SettingsPersonalInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 3) || (paramInt1 == 2) || (paramInt1 == 4)) {
        new aq(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74305);
            wr localwr = new wr();
            localwr.dMh.dMj = true;
            com.tencent.mm.sdk.b.a.IvT.l(localwr);
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
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.i(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.azQ());
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
      com.tencent.mm.plugin.setting.c.iUz.a(this, (Intent)localObject, 4);
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
      p.aEA();
      ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.aj.e.K(v.aAC() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      ((Intent)localObject).putExtra("CropImage_from_scene", 3);
      com.tencent.mm.plugin.setting.c.iUz.a(this, paramIntent, (Intent)localObject, com.tencent.mm.plugin.image.d.azQ(), 4, null);
      AppMethodBeat.o(74315);
      return;
    }
    new aq(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74306);
        wr localwr = new wr();
        localwr.dMh.dMj = true;
        com.tencent.mm.sdk.b.a.IvT.l(localwr);
        AppMethodBeat.o(74306);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(74315);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = v.aAC();
    p.aEA();
    localObject = com.tencent.mm.aj.e.DD((String)localObject);
    if (paramIntent == null)
    {
      ae.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
      AppMethodBeat.o(74315);
      return;
    }
    ae.i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new com.tencent.mm.vfs.k(paramIntent).length()) });
    new com.tencent.mm.aj.n(getContext(), paramIntent).C(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74307);
        ae.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.ajM()), v.aAC() });
        if (com.tencent.mm.kernel.g.ajM())
        {
          if (this.val$bitmap != null)
          {
            p.aEA();
            str = com.tencent.mm.aj.e.K(v.aAC() + ".last", true);
            PreviewHdHeadImg.e(this.val$bitmap, str);
          }
          String str = com.tencent.mm.aj.c.Du(v.aAC());
          bb.hIK.BG(str);
        }
        SettingsPersonalInfoUI.a(SettingsPersonalInfoUI.this);
        if (SettingsPersonalInfoUI.b(SettingsPersonalInfoUI.this)) {
          com.tencent.mm.plugin.report.service.g.yxI.f(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(4) });
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
      dRq();
    }
    initView();
    if (getIntent().getBooleanExtra("intent_set_avatar", false))
    {
      this.jbR = getIntent().getBooleanExtra("KEnterFromBanner", false);
      com.tencent.mm.plugin.account.a.a.iUA.s(this);
    }
    com.tencent.mm.kernel.g.ajj().a(1191, this);
    AppMethodBeat.o(74308);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74309);
    ae.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
    if (com.tencent.mm.kernel.g.ajM()) {
      com.tencent.mm.kernel.g.ajR().ajA().b(this);
    }
    if (this.yYz != null) {
      com.tencent.mm.kernel.g.ajj().a(this.yYz);
    }
    com.tencent.mm.kernel.g.ajj().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(74309);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74312);
    paramf = paramPreference.mKey;
    ae.d("MicroMsg.SettingsPersonalInfoUI", "key = ".concat(String.valueOf(paramf)));
    if (paramf.equals("settings_change_avatar"))
    {
      boolean bool = com.tencent.mm.plugin.account.a.a.iUA.s(this);
      AppMethodBeat.o(74312);
      return bool;
    }
    if (paramf.equals("settings_username"))
    {
      if ((bu.isNullOrNil(v.aAD())) && (an.aUz(v.aAC())) && (com.tencent.mm.n.g.acL().getInt("EnableModAlias", 0) == 0))
      {
        startActivity(SettingsCreateAliasUI.class);
        AppMethodBeat.o(74312);
        return true;
      }
      if (com.tencent.mm.n.g.acL().getInt("EnableModAlias", 0) != 0)
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
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74312);
      return true;
    }
    if (paramf.equals("settings_qrcode"))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11264, new Object[] { Integer.valueOf(2) });
      paramf = getContext();
      paramPreference = new Intent(this, SelfQRCodeUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.mt(0));
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
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else
      {
        if (paramf.equals("settings_address"))
        {
          paramf = new Intent();
          paramf.putExtra("launch_from_webview", false);
          com.tencent.mm.br.d.c(getContext(), "address", ".ui.WalletSelectAddrUI", paramf);
          AppMethodBeat.o(74312);
          return true;
        }
        if (paramf.equals("settings_invoice"))
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(14199, new Object[] { Integer.valueOf(1) });
          paramf = new Intent();
          paramf.putExtra("launch_from_webview", false);
          com.tencent.mm.br.d.c(getContext(), "address", ".ui.InvoiceListUI", paramf);
          AppMethodBeat.o(74312);
          return true;
        }
        if (paramf.equals("settings_pat")) {
          dRq();
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74311);
    dQY();
    dRp();
    Object localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(4, null);
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      this.screen.aXe("settings_name").setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject));
    }
    localObject = this.screen.aXe("settings_pat");
    if ((((PluginPatMsg)com.tencent.mm.kernel.g.ad(PluginPatMsg.class)).isPatEnable()) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPq, 1) != 0))
    {
      this.screen.cT("settings_pat", false);
      ((Preference)localObject).setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.Jet, null)));
      boolean bool = bu.jq(this);
      this.screen.cT("settings_address", bool);
      if (bu.o(Boolean.valueOf(com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IST, false)))) {
        break label253;
      }
      this.screen.cT("settings_invoice", true);
      this.yYz = new i();
      com.tencent.mm.kernel.g.ajj().a(this.yYz, 0);
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(74311);
      return;
      this.screen.cT("settings_pat", true);
      break;
      label253:
      this.screen.cT("settings_invoice", false);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(74317);
    if (!bu.o(Boolean.valueOf(com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IST, false))))
    {
      this.screen.cT("settings_invoice", true);
      AppMethodBeat.o(74317);
      return;
    }
    this.screen.cT("settings_invoice", false);
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