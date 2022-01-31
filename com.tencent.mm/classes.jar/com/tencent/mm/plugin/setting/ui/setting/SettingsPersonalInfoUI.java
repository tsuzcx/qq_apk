package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.av;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.widget.HeadImgNewPreference;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.File;

public class SettingsPersonalInfoUI
  extends MMPreference
  implements com.tencent.mm.ai.f, n.b
{
  private boolean gsE;
  private com.tencent.mm.plugin.setting.model.g qJq;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void ckf()
  {
    AppMethodBeat.i(127375);
    Preference localPreference = this.screen.atx("settings_username");
    String str1 = r.Zo();
    String str2 = r.Zn();
    if (bo.isNullOrNil(str1))
    {
      if (ad.ari(str2)) {
        localPreference.setSummary(getString(2131303357));
      }
      while (!ad.arj(r.Zn()))
      {
        localPreference.OW(8);
        AppMethodBeat.o(127375);
        return;
        localPreference.setSummary(str2);
      }
    }
    localPreference.setSummary(str1);
    localPreference.OW(8);
    AppMethodBeat.o(127375);
  }
  
  private void ckt()
  {
    AppMethodBeat.i(127376);
    HeadImgNewPreference localHeadImgNewPreference = (HeadImgNewPreference)this.screen.atx("settings_change_avatar");
    localHeadImgNewPreference.YZ(r.Zn());
    localHeadImgNewPreference.qMg = new SettingsPersonalInfoUI.2(this);
    AppMethodBeat.o(127376);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(127378);
    int i = bo.f(paramObject, 0);
    ab.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.RL().Ru()) || (i <= 0))
    {
      ab.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(127378);
      return;
    }
    ckf();
    AppMethodBeat.o(127378);
  }
  
  public int getResourceId()
  {
    return 2131165290;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127372);
    setMMTitle(2131303363);
    com.tencent.mm.kernel.g.RL().Ru().a(this);
    this.screen = getPreferenceScreen();
    setBackBtn(new SettingsPersonalInfoUI.1(this));
    AppMethodBeat.o(127372);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(127377);
    ab.i("MicroMsg.SettingsPersonalInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 3) || (paramInt1 == 2) || (paramInt1 == 4)) {
        new ak(Looper.getMainLooper()).post(new SettingsPersonalInfoUI.3(this));
      }
      AppMethodBeat.o(127377);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(127377);
      return;
    case 3: 
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.n.h(getApplicationContext(), paramIntent, c.YK());
      if (paramIntent == null)
      {
        AppMethodBeat.o(127377);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramIntent);
      ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
      com.tencent.mm.plugin.setting.b.gmO.a(this, (Intent)localObject, 4);
      AppMethodBeat.o(127377);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(127377);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_Filter", true);
      o.acQ();
      ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.ah.d.E(r.Zn() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      com.tencent.mm.plugin.setting.b.gmO.a(this, paramIntent, (Intent)localObject, c.YK(), 4, null);
      AppMethodBeat.o(127377);
      return;
    }
    new ak(Looper.getMainLooper()).post(new SettingsPersonalInfoUI.4(this));
    if (paramIntent == null)
    {
      AppMethodBeat.o(127377);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = r.Zn();
    o.acQ();
    localObject = com.tencent.mm.ah.d.rb((String)localObject);
    if (paramIntent == null)
    {
      ab.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
      AppMethodBeat.o(127377);
      return;
    }
    ab.i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new File(paramIntent).length()) });
    new com.tencent.mm.ah.m(getContext(), paramIntent).v(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(127369);
        ab.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.RG()), r.Zn() });
        if (com.tencent.mm.kernel.g.RG())
        {
          if (this.val$bitmap != null)
          {
            o.acQ();
            str = com.tencent.mm.ah.d.E(r.Zn() + ".last", true);
            PreviewHdHeadImg.e(this.val$bitmap, str);
          }
          String str = com.tencent.mm.ah.b.qS(r.Zn());
          av.flM.po(str);
        }
        SettingsPersonalInfoUI.a(SettingsPersonalInfoUI.this);
        if (SettingsPersonalInfoUI.b(SettingsPersonalInfoUI.this)) {
          h.qsU.e(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(4) });
        }
        AppMethodBeat.o(127369);
      }
    });
    AppMethodBeat.o(127377);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127370);
    super.onCreate(paramBundle);
    initView();
    if (getIntent().getBooleanExtra("intent_set_avatar", false))
    {
      this.gsE = getIntent().getBooleanExtra("KEnterFromBanner", false);
      a.gmP.n(this);
    }
    com.tencent.mm.kernel.g.Rc().a(1191, this);
    AppMethodBeat.o(127370);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127371);
    ab.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
    if (com.tencent.mm.kernel.g.RG()) {
      com.tencent.mm.kernel.g.RL().Ru().b(this);
    }
    if (this.qJq != null) {
      com.tencent.mm.kernel.g.Rc().a(this.qJq);
    }
    com.tencent.mm.kernel.g.Rc().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(127371);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127374);
    paramf = paramPreference.mKey;
    ab.d("MicroMsg.SettingsPersonalInfoUI", "key = ".concat(String.valueOf(paramf)));
    if (paramf.equals("settings_change_avatar"))
    {
      boolean bool = a.gmP.n(this);
      AppMethodBeat.o(127374);
      return bool;
    }
    if (paramf.equals("settings_username"))
    {
      if ((bo.isNullOrNil(r.Zo())) && (ad.arj(r.Zn()))) {
        startActivity(SettingsAliasUI.class);
      }
      AppMethodBeat.o(127374);
      return true;
    }
    if (paramf.equals("settings_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsModifyNameUI.class);
      startActivity(paramf);
      AppMethodBeat.o(127374);
      return true;
    }
    if (paramf.equals("settings_qrcode"))
    {
      h.qsU.e(11264, new Object[] { Integer.valueOf(2) });
      getContext().startActivity(new Intent(this, SelfQRCodeUI.class));
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(127374);
        return false;
        if (!paramf.equals("settings_more_info")) {
          break;
        }
        startActivity(new Intent(this, SettingsPersonalMoreUI.class));
      }
      if (paramf.equals("settings_address"))
      {
        paramf = new Intent();
        paramf.putExtra("launch_from_webview", false);
        com.tencent.mm.bq.d.c(getContext(), "address", ".ui.WalletSelectAddrUI", paramf);
        AppMethodBeat.o(127374);
        return true;
      }
    } while (!paramf.equals("settings_invoice"));
    h.qsU.e(14199, new Object[] { Integer.valueOf(1) });
    paramf = new Intent();
    paramf.putExtra("launch_from_webview", false);
    com.tencent.mm.bq.d.c(getContext(), "address", ".ui.InvoiceListUI", paramf);
    AppMethodBeat.o(127374);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127373);
    ckf();
    ckt();
    String str = (String)com.tencent.mm.kernel.g.RL().Ru().get(4, null);
    if ((str != null) && (str.length() > 0)) {
      this.screen.atx("settings_name").setSummary(j.b(this, str));
    }
    boolean bool = bo.hl(this);
    this.screen.cl("settings_address", bool);
    if (!bo.e(Boolean.valueOf(com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yFF, false))))
    {
      this.screen.cl("settings_invoice", true);
      this.qJq = new com.tencent.mm.plugin.setting.model.g();
      com.tencent.mm.kernel.g.Rc().a(this.qJq, 0);
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(127373);
      return;
      this.screen.cl("settings_invoice", false);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(127379);
    if (!bo.e(Boolean.valueOf(com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yFF, false))))
    {
      this.screen.cl("settings_invoice", true);
      AppMethodBeat.o(127379);
      return;
    }
    this.screen.cl("settings_invoice", false);
    AppMethodBeat.o(127379);
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