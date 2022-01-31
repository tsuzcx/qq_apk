package com.tencent.mm.plugin.walletlock.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.h.b.a.aa;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.a.f;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.a.i;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c;

public class WalletLockSettingUI
  extends MMPreference
{
  private f dnn;
  private int drX = 0;
  private c eQV;
  private int fzn = -1;
  private IconPreference qRj;
  private IconPreference qRk;
  private IconPreference qRl;
  private IconPreference qRm;
  private boolean qRn = false;
  private boolean qRo = true;
  private boolean qRp = true;
  private boolean qRq = true;
  
  private void AY(String paramString)
  {
    this.eQV = com.tencent.mm.ui.base.h.a(this, paramString, "", new WalletLockSettingUI.4(this));
    this.eQV.setCanceledOnTouchOutside(false);
    this.eQV.show();
  }
  
  private void a(Preference paramPreference, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramPreference instanceof IconPreference))
    {
      paramPreference = (IconPreference)paramPreference;
      paramPreference.fw(com.tencent.mm.cb.a.fromDPToPix(this, 20), com.tencent.mm.cb.a.fromDPToPix(this, 20));
      if (!paramBoolean1) {
        break label59;
      }
      if (!paramBoolean2) {
        break label49;
      }
      paramPreference.Gw(a.f.radio_on);
    }
    for (;;)
    {
      paramPreference.Gx(0);
      return;
      label49:
      paramPreference.Gw(a.f.radio_default_on);
    }
    label59:
    paramPreference.Gw(a.f.radio_off);
    paramPreference.Gx(0);
  }
  
  private void bYI()
  {
    bYJ();
    y.i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.walletlock.c.g.qQZ.bYw()) });
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.qQZ;
    if (!com.tencent.mm.plugin.walletlock.c.g.bYA())
    {
      y.w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
      this.dnn.bJ("wallet_lock_fingerprint", true);
      localg = com.tencent.mm.plugin.walletlock.c.g.qQZ;
      y.i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.c.g.bYc()) });
      if ((com.tencent.mm.plugin.walletlock.c.g.qQZ.bYw() != 2) && (com.tencent.mm.plugin.walletlock.c.g.qQZ.bYw() != 3)) {
        break label317;
      }
      a(this.qRk, false, true);
      this.dnn.bJ("wallet_lock_modify_gesture", true);
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.walletlock.c.g.qQZ.bYw() != 0) {
        break label384;
      }
      if (this.qRo) {
        a(this.qRl, true, true);
      }
      return;
      boolean bool = m.ei(this.mController.uMN);
      localg = com.tencent.mm.plugin.walletlock.c.g.qQZ;
      if (com.tencent.mm.plugin.walletlock.c.g.bXQ())
      {
        if (!bool)
        {
          this.dnn.bJ("wallet_lock_fingerprint", false);
          this.qRj.setDesc(getString(a.g.wallet_lock_device_not_support_fingerprint));
          this.qRj.cBu();
          a(this.qRj, true, false);
          this.qRj.setEnabled(false);
          this.qRj.vcH = true;
          this.qRp = false;
          break;
        }
        if (!this.qRo) {
          break;
        }
        this.dnn.bJ("wallet_lock_fingerprint", false);
        a(this.qRj, true, true);
        break;
      }
      if (!bool)
      {
        this.dnn.bJ("wallet_lock_fingerprint", true);
        break;
      }
      this.dnn.bJ("wallet_lock_fingerprint", false);
      a(this.qRj, false, true);
      break;
      label317:
      if (com.tencent.mm.plugin.walletlock.c.g.qQZ.bYw() == 1)
      {
        if (this.qRo)
        {
          a(this.qRk, true, true);
          this.dnn.bJ("wallet_lock_modify_gesture", false);
        }
      }
      else
      {
        a(this.qRk, false, true);
        this.dnn.bJ("wallet_lock_modify_gesture", true);
      }
    }
    label384:
    a(this.qRl, false, true);
  }
  
  private void bYJ()
  {
    if ((this.qRj != null) && (this.qRp)) {
      a(this.qRj, false, this.qRp);
    }
    if ((this.qRm != null) && (this.qRq)) {
      a(this.qRm, false, this.qRq);
    }
    if (this.qRk != null) {
      a(this.qRk, false, true);
    }
    if (this.qRl != null) {
      a(this.qRl, false, true);
    }
  }
  
  private void bYK()
  {
    this.eQV = com.tencent.mm.ui.base.h.a(this, getString(a.g.wallet_lock_no_fingerprint_tips), "", new WalletLockSettingUI.2(this));
    this.eQV.setCanceledOnTouchOutside(false);
  }
  
  private void g(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  private void t(int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt2);
    localIntent.putExtra("key_err_msg", paramString);
    g(paramInt1, localIntent);
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    if ("wallet_lock_fingerprint".equals(paramPreference.mKey))
    {
      bYJ();
      a(paramPreference, true, true);
      if ((this.qRp) && ((!this.qRo) || (com.tencent.mm.plugin.walletlock.c.g.qQZ.bYw() != 2)))
      {
        if (com.tencent.soter.core.a.hH(this)) {
          break label60;
        }
        bYK();
      }
      for (;;)
      {
        return true;
        label60:
        if ((!this.qRo) || (com.tencent.mm.plugin.walletlock.c.g.qQZ.bYw() != 2))
        {
          y.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
          ((b)com.tencent.mm.kernel.g.r(b.class)).b(this, 2, 1);
        }
      }
    }
    if ("wallet_lock_faceid".equals(paramPreference.mKey))
    {
      bYJ();
      a(paramPreference, true, true);
      if ((this.qRq) && ((!this.qRo) || (com.tencent.mm.plugin.walletlock.c.g.qQZ.bYw() != 3)))
      {
        if (com.tencent.soter.core.a.hI(this)) {
          break label166;
        }
        bYK();
      }
      for (;;)
      {
        return true;
        label166:
        if ((!this.qRo) || (com.tencent.mm.plugin.walletlock.c.g.qQZ.bYw() == 3))
        {
          y.i("MicroMsg.WalletLockSettingUI", "request open faceid lock");
          ((b)com.tencent.mm.kernel.g.r(b.class)).b(this, 3, 4);
        }
      }
    }
    if ("wallet_lock_gesture".equals(paramPreference.mKey))
    {
      bYJ();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.qQZ.bYw() != 1)
      {
        y.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
        ((b)com.tencent.mm.kernel.g.r(b.class)).b(this, 1, 2);
      }
      return true;
    }
    if ("wallet_lock_close".equals(paramPreference.mKey))
    {
      bYJ();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.qQZ.bYw() != 0)
      {
        y.i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
        ((b)com.tencent.mm.kernel.g.r(b.class)).h(this, 3);
        paramf = new aa();
        paramf.ckr = 14L;
        paramf.cks = 1L;
        paramf.QX();
      }
      return true;
    }
    if ("wallet_lock_modify_gesture".equals(paramPreference.mKey))
    {
      ((b)com.tencent.mm.kernel.g.r(b.class)).P(this);
      return true;
    }
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.WalletLockSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null) {
      y.e("MicroMsg.WalletLockSettingUI", "alvinluo data is null");
    }
    int i;
    label126:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              i = paramIntent.getIntExtra("key_err_code", -1);
              y.i("MicroMsg.WalletLockSettingUI", "alvinluo wallet lock setting onActivityResult errCode: %d", new Object[] { Integer.valueOf(i) });
              if (paramInt1 != 1) {
                break label126;
              }
              y.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock onActivityResult");
              if (i != 0) {
                break;
              }
            } while (!this.qRn);
            g(paramInt2, paramIntent);
            return;
          } while (i == 4);
          y.i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
          AY(getString(a.g.wallet_lock_fingerprint_open_failed));
          return;
          if (paramInt1 != 2) {
            break;
          }
          y.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
          if (i == 0)
          {
            if (this.qRn) {
              g(paramInt2, paramIntent);
            }
            e.post(new WalletLockSettingUI.3(this), "WalletLockRemoveAuthKey");
            return;
          }
        } while (i == 4);
        y.i("MicroMsg.WalletLockSettingUI", "alvinluo open gesture lock failed");
        AY(getString(a.g.wallet_lock_gesture_open_failed));
        return;
      } while (paramInt1 != 3);
      if (i == 0)
      {
        ((b)com.tencent.mm.kernel.g.r(b.class)).AZ(0);
        paramIntent = com.tencent.mm.plugin.walletlock.c.g.qQZ;
        com.tencent.mm.plugin.walletlock.c.g.bXT();
        bYI();
        Toast.makeText(this, getString(a.g.wallet_lock_close_all_success), 0).show();
        com.tencent.mm.plugin.walletlock.c.h.bYC();
        if (this.qRn) {
          t(-1, 0, "close wallet lock ok");
        }
        e.post(new WalletLockSettingUI.5(this), "WalletLockRemoveAuthKey");
        paramIntent = new aa();
        paramIntent.ckr = 14L;
        paramIntent.cks = 2L;
        paramIntent.QX();
        return;
      }
    } while (i == 4);
    AY(getString(a.g.wallet_lock_close_error));
  }
  
  public void onBackPressed()
  {
    y.i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
    if (this.qRn)
    {
      t(0, 4, "user cancel setting wallet lock");
      return;
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        if (WalletLockSettingUI.a(WalletLockSettingUI.this)) {
          WalletLockSettingUI.a(WalletLockSettingUI.this, "user cancel setting wallet lock");
        }
        for (;;)
        {
          return false;
          WalletLockSettingUI.this.finish();
        }
      }
    });
    setMMTitle(a.g.wallet_lock_page_title);
    this.dnn = this.vdd;
    this.dnn = this.vdd;
    this.qRj = ((IconPreference)this.dnn.add("wallet_lock_fingerprint"));
    this.qRk = ((IconPreference)this.dnn.add("wallet_lock_gesture"));
    this.qRl = ((IconPreference)this.dnn.add("wallet_lock_close"));
    this.qRm = ((IconPreference)this.dnn.add("wallet_lock_faceid"));
    this.dnn.bJ("wallet_lock_faceid", true);
    this.drX = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    this.fzn = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
    if (this.fzn == 1)
    {
      this.qRn = true;
      this.qRo = false;
    }
    paramBundle = new aa();
    paramBundle.ckr = 13L;
    paramBundle.cks = 1L;
    paramBundle.ckt = this.drX;
    paramBundle.QX();
    y.i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", new Object[] { Boolean.valueOf(this.qRn), Boolean.valueOf(this.qRo) });
  }
  
  protected void onPause()
  {
    super.onPause();
    if ((this.eQV != null) && (this.eQV.isShowing())) {
      this.eQV.dismiss();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    bYI();
  }
  
  public final int xj()
  {
    return a.i.wallet_lock_setting_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI
 * JD-Core Version:    0.7.0.1
 */