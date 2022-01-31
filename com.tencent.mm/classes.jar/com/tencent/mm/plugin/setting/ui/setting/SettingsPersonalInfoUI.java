package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.setting.ui.widget.HeadImgNewPreference;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import java.io.File;

public class SettingsPersonalInfoUI
  extends MMPreference
  implements com.tencent.mm.ah.f, m.b
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private boolean faM;
  private com.tencent.mm.plugin.setting.model.g nVk;
  
  private void awW()
  {
    HeadImgNewPreference localHeadImgNewPreference = (HeadImgNewPreference)this.dnn.add("settings_change_avatar");
    String str = q.Gj();
    localHeadImgNewPreference.nXV = null;
    if (localHeadImgNewPreference.hic != null)
    {
      a.b.a(localHeadImgNewPreference.hic, str);
      if (str != null) {
        break label69;
      }
    }
    label69:
    for (localHeadImgNewPreference.nXX = false;; localHeadImgNewPreference.nXX = true)
    {
      localHeadImgNewPreference.nXW = new SettingsPersonalInfoUI.2(this);
      return;
      localHeadImgNewPreference.nXV = str;
      break;
    }
  }
  
  private void byV()
  {
    Preference localPreference = this.dnn.add("settings_username");
    String str1 = q.Gk();
    String str2 = q.Gj();
    if (bk.bl(str1))
    {
      if (ad.aaX(str2))
      {
        localPreference.setSummary(getString(a.i.settings_notset));
        return;
      }
      localPreference.setSummary(str2);
      return;
    }
    localPreference.setSummary(str1);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    int i = bk.e(paramObject, 0);
    y.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    if ((paramm != com.tencent.mm.kernel.g.DP().Dz()) || (i <= 0))
    {
      y.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
      return;
    }
    byV();
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool2 = true;
    paramf = paramPreference.mKey;
    y.d("MicroMsg.SettingsPersonalInfoUI", "key = " + paramf);
    boolean bool1;
    if (paramf.equals("settings_change_avatar")) {
      bool1 = a.eUS.m(this);
    }
    do
    {
      do
      {
        return bool1;
        if (!paramf.equals("settings_username")) {
          break;
        }
        bool1 = bool2;
      } while (!bk.bl(q.Gk()));
      bool1 = bool2;
    } while (!ad.aaY(q.Gj()));
    Y(SettingsAliasUI.class);
    return true;
    if (paramf.equals("settings_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsModifyNameUI.class);
      startActivity(paramf);
      return true;
    }
    if (paramf.equals("settings_qrcode"))
    {
      h.nFQ.f(11264, new Object[] { Integer.valueOf(2) });
      this.mController.uMN.startActivity(new Intent(this, SelfQRCodeUI.class));
    }
    do
    {
      for (;;)
      {
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
        com.tencent.mm.br.d.c(this.mController.uMN, "address", ".ui.WalletSelectAddrUI", paramf);
        return true;
      }
    } while (!paramf.equals("settings_invoice"));
    h.nFQ.f(14199, new Object[] { Integer.valueOf(1) });
    paramf = new Intent();
    paramf.putExtra("launch_from_webview", false);
    com.tencent.mm.br.d.c(this.mController.uMN, "address", ".ui.InvoiceListUI", paramf);
    return true;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_personal_info);
    com.tencent.mm.kernel.g.DP().Dz().a(this);
    this.dnn = this.vdd;
    setBackBtn(new SettingsPersonalInfoUI.1(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.SettingsPersonalInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1) {
      if ((paramInt1 == 3) || (paramInt1 == 2) || (paramInt1 == 4)) {
        new ah(Looper.getMainLooper()).post(new SettingsPersonalInfoUI.3(this));
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt1)
          {
          default: 
            return;
          }
        } while (paramIntent == null);
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImageMode", 1);
        ((Intent)localObject).putExtra("CropImage_Filter", true);
        o.JQ();
        ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.ag.d.A(q.Gj() + ".crop", true));
        ((Intent)localObject).putExtra("CropImage_ImgPath", null);
        b.eUR.a(this, paramIntent, (Intent)localObject, c.FG(), 4, null);
        return;
        paramIntent = com.tencent.mm.pluginsdk.ui.tools.l.f(getApplicationContext(), paramIntent, c.FG());
      } while (paramIntent == null);
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_OutputPath", paramIntent);
      ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
      b.eUR.a(this, (Intent)localObject, 4);
      return;
      new ah(Looper.getMainLooper()).post(new SettingsPersonalInfoUI.4(this));
    } while (paramIntent == null);
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = q.Gj();
    o.JQ();
    localObject = com.tencent.mm.ag.d.kh((String)localObject);
    if (paramIntent == null)
    {
      y.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
      return;
    }
    y.i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", new Object[] { paramIntent, Long.valueOf(new File(paramIntent).length()) });
    new com.tencent.mm.ag.m(this.mController.uMN, paramIntent).b(1, new SettingsPersonalInfoUI.5(this, (Bitmap)localObject));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    if (getIntent().getBooleanExtra("intent_set_avatar", false))
    {
      this.faM = getIntent().getBooleanExtra("KEnterFromBanner", false);
      a.eUS.m(this);
    }
    com.tencent.mm.kernel.g.Dk().a(1191, this);
  }
  
  public void onDestroy()
  {
    y.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
    if (com.tencent.mm.kernel.g.DK()) {
      com.tencent.mm.kernel.g.DP().Dz().b(this);
    }
    if (this.nVk != null) {
      com.tencent.mm.kernel.g.Dk().c(this.nVk);
    }
    com.tencent.mm.kernel.g.Dk().b(1191, this);
    super.onDestroy();
  }
  
  public void onResume()
  {
    byV();
    awW();
    String str = (String)com.tencent.mm.kernel.g.DP().Dz().get(4, null);
    if ((str != null) && (str.length() > 0)) {
      this.dnn.add("settings_name").setSummary(j.b(this, str));
    }
    boolean bool = bk.fV(this);
    this.dnn.bJ("settings_address", bool);
    if (!bk.d(Boolean.valueOf(com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.uvy, false))))
    {
      this.dnn.bJ("settings_invoice", true);
      this.nVk = new com.tencent.mm.plugin.setting.model.g();
      com.tencent.mm.kernel.g.Dk().a(this.nVk, 0);
    }
    for (;;)
    {
      super.onResume();
      return;
      this.dnn.bJ("settings_invoice", false);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if (!bk.d(Boolean.valueOf(com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.uvy, false))))
    {
      this.dnn.bJ("settings_invoice", true);
      return;
    }
    this.dnn.bJ("settings_invoice", false);
  }
  
  public final int xj()
  {
    return a.k.settings_pref_personal_info_new;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */