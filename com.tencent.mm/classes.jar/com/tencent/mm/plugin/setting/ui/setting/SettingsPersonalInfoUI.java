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
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPersonalInfoUI
  extends MMPreference
  implements com.tencent.mm.ak.g, n.b
{
  private boolean iFP;
  private f screen;
  private com.tencent.mm.plugin.setting.model.h xtD;
  
  private void dBY()
  {
    AppMethodBeat.i(74313);
    Preference localPreference = this.screen.aPN("settings_username");
    String str1 = u.axx();
    String str2 = u.axw();
    if (bs.isNullOrNil(str1))
    {
      if (ai.aNf(str2)) {
        localPreference.setSummary(getString(2131763339));
      }
      while ((!ai.aNg(u.axw())) && (com.tencent.mm.m.g.ZY().getInt("EnableModAlias", 0) == 0))
      {
        localPreference.aam(8);
        AppMethodBeat.o(74313);
        return;
        localPreference.setSummary(str2);
      }
    }
    localPreference.setSummary(str1);
    if (com.tencent.mm.m.g.ZY().getInt("EnableModAlias", 0) == 0) {
      localPreference.aam(8);
    }
    AppMethodBeat.o(74313);
  }
  
  private void dCp()
  {
    AppMethodBeat.i(74314);
    HeadImgNewPreference localHeadImgNewPreference = (HeadImgNewPreference)this.screen.aPN("settings_change_avatar");
    localHeadImgNewPreference.aPM(u.axw());
    localHeadImgNewPreference.uWS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74304);
        Object localObject = new Intent(SettingsPersonalInfoUI.this, PreviewHdHeadImg.class);
        paramAnonymousView = SettingsPersonalInfoUI.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(74304);
      }
    };
    AppMethodBeat.o(74314);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(74316);
    int i = bs.l(paramObject, 0);
    ac.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.agR().agA()) || (i <= 0))
    {
      ac.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(74316);
      return;
    }
    dBY();
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
    com.tencent.mm.kernel.g.agR().agA().a(this);
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
    ac.i("MicroMsg.SettingsPersonalInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 3) || (paramInt1 == 2) || (paramInt1 == 4)) {
        new ao(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74305);
            vu localvu = new vu();
            localvu.dyG.dyI = true;
            com.tencent.mm.sdk.b.a.GpY.l(localvu);
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
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.awL());
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
      b.iyx.a(this, (Intent)localObject, 4);
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
      p.aBh();
      ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.aj.e.K(u.axw() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      ((Intent)localObject).putExtra("CropImage_from_scene", 3);
      b.iyx.a(this, paramIntent, (Intent)localObject, com.tencent.mm.plugin.image.d.awL(), 4, null);
      AppMethodBeat.o(74315);
      return;
    }
    new ao(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74306);
        vu localvu = new vu();
        localvu.dyG.dyI = true;
        com.tencent.mm.sdk.b.a.GpY.l(localvu);
        AppMethodBeat.o(74306);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(74315);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = u.axw();
    p.aBh();
    localObject = com.tencent.mm.aj.e.Ac((String)localObject);
    if (paramIntent == null)
    {
      ac.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
      AppMethodBeat.o(74315);
      return;
    }
    ac.i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new com.tencent.mm.vfs.e(paramIntent).length()) });
    new com.tencent.mm.aj.n(getContext(), paramIntent).F(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74307);
        ac.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.agM()), u.axw() });
        if (com.tencent.mm.kernel.g.agM())
        {
          if (this.val$bitmap != null)
          {
            p.aBh();
            str = com.tencent.mm.aj.e.K(u.axw() + ".last", true);
            PreviewHdHeadImg.e(this.val$bitmap, str);
          }
          String str = c.zT(u.axw());
          ay.hnA.yg(str);
        }
        SettingsPersonalInfoUI.a(SettingsPersonalInfoUI.this);
        if (SettingsPersonalInfoUI.b(SettingsPersonalInfoUI.this)) {
          com.tencent.mm.plugin.report.service.h.wUl.f(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(4) });
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
      this.iFP = getIntent().getBooleanExtra("KEnterFromBanner", false);
      com.tencent.mm.plugin.account.a.a.iyy.s(this);
    }
    com.tencent.mm.kernel.g.agi().a(1191, this);
    AppMethodBeat.o(74308);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74309);
    ac.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
    if (com.tencent.mm.kernel.g.agM()) {
      com.tencent.mm.kernel.g.agR().agA().b(this);
    }
    if (this.xtD != null) {
      com.tencent.mm.kernel.g.agi().a(this.xtD);
    }
    com.tencent.mm.kernel.g.agi().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(74309);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74312);
    paramf = paramPreference.mKey;
    ac.d("MicroMsg.SettingsPersonalInfoUI", "key = ".concat(String.valueOf(paramf)));
    if (paramf.equals("settings_change_avatar"))
    {
      boolean bool = com.tencent.mm.plugin.account.a.a.iyy.s(this);
      AppMethodBeat.o(74312);
      return bool;
    }
    if (paramf.equals("settings_username"))
    {
      if ((bs.isNullOrNil(u.axx())) && (ai.aNg(u.axw())) && (com.tencent.mm.m.g.ZY().getInt("EnableModAlias", 0) == 0))
      {
        startActivity(SettingsCreateAliasUI.class);
        AppMethodBeat.o(74312);
        return true;
      }
      if (com.tencent.mm.m.g.ZY().getInt("EnableModAlias", 0) != 0)
      {
        paramf = new Intent(this, SettingsAliasUI.class);
        paramf.putExtra("WizardRootClass", SettingsPersonalInfoUI.class.getCanonicalName());
        MMWizardActivity.aj(this, paramf);
      }
      AppMethodBeat.o(74312);
      return true;
    }
    if (paramf.equals("settings_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsModifyNameUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74312);
      return true;
    }
    if (paramf.equals("settings_qrcode"))
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(11264, new Object[] { Integer.valueOf(2) });
      paramf = getContext();
      paramPreference = new Intent(this, SelfQRCodeUI.class);
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().ba(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.lR(0));
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
        paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      if (paramf.equals("settings_address"))
      {
        paramf = new Intent();
        paramf.putExtra("launch_from_webview", false);
        com.tencent.mm.br.d.c(getContext(), "address", ".ui.WalletSelectAddrUI", paramf);
        AppMethodBeat.o(74312);
        return true;
      }
    } while (!paramf.equals("settings_invoice"));
    com.tencent.mm.plugin.report.service.h.wUl.f(14199, new Object[] { Integer.valueOf(1) });
    paramf = new Intent();
    paramf.putExtra("launch_from_webview", false);
    com.tencent.mm.br.d.c(getContext(), "address", ".ui.InvoiceListUI", paramf);
    AppMethodBeat.o(74312);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74311);
    dBY();
    dCp();
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(4, null);
    if ((str != null) && (str.length() > 0)) {
      this.screen.aPN("settings_name").setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, str));
    }
    boolean bool = bs.ja(this);
    this.screen.cK("settings_address", bool);
    if (!bs.l(Boolean.valueOf(com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GMd, false))))
    {
      this.screen.cK("settings_invoice", true);
      this.xtD = new com.tencent.mm.plugin.setting.model.h();
      com.tencent.mm.kernel.g.agi().a(this.xtD, 0);
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(74311);
      return;
      this.screen.cK("settings_invoice", false);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(74317);
    if (!bs.l(Boolean.valueOf(com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GMd, false))))
    {
      this.screen.cK("settings_invoice", true);
      AppMethodBeat.o(74317);
      return;
    }
    this.screen.cK("settings_invoice", false);
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