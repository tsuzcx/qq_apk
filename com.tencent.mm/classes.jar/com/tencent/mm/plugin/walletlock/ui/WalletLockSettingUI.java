package com.tencent.mm.plugin.walletlock.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.b.c;

public class WalletLockSettingUI
  extends MMPreference
{
  private int ejF = 0;
  private c giQ;
  private int mScene = -1;
  private f screen;
  private IconPreference uGr;
  private IconPreference uGs;
  private IconPreference uGt;
  private IconPreference uGu;
  private boolean uGv = false;
  private boolean uGw = true;
  private boolean uGx = true;
  private boolean uGy = true;
  
  private void La(String paramString)
  {
    AppMethodBeat.i(51763);
    this.giQ = com.tencent.mm.ui.base.h.a(this, paramString, "", new WalletLockSettingUI.4(this));
    this.giQ.setCanceledOnTouchOutside(false);
    this.giQ.show();
    AppMethodBeat.o(51763);
  }
  
  private void a(Preference paramPreference, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(51759);
    if ((paramPreference instanceof IconPreference))
    {
      paramPreference = (IconPreference)paramPreference;
      paramPreference.hC(com.tencent.mm.cb.a.fromDPToPix(this, 20), com.tencent.mm.cb.a.fromDPToPix(this, 20));
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          paramPreference.OO(2131231906);
        }
        for (;;)
        {
          paramPreference.OP(0);
          AppMethodBeat.o(51759);
          return;
          paramPreference.OO(2131231904);
        }
      }
      paramPreference.OO(2131231905);
      paramPreference.OP(0);
    }
    AppMethodBeat.o(51759);
  }
  
  private void cYs()
  {
    AppMethodBeat.i(51754);
    cYw();
    ab.i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.walletlock.c.g.uGh.cYg()) });
    cYt();
    cYu();
    cYv();
    AppMethodBeat.o(51754);
  }
  
  private void cYt()
  {
    AppMethodBeat.i(51755);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.uGh;
    if (!com.tencent.mm.plugin.walletlock.c.g.cYk())
    {
      ab.w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
      this.screen.cl("wallet_lock_fingerprint", true);
      AppMethodBeat.o(51755);
      return;
    }
    boolean bool = m.eZ(getContext());
    localg = com.tencent.mm.plugin.walletlock.c.g.uGh;
    if (com.tencent.mm.plugin.walletlock.c.g.cXy())
    {
      if (!bool)
      {
        this.screen.cl("wallet_lock_fingerprint", false);
        this.uGr.setDesc(getString(2131305152));
        this.uGr.dEJ();
        a(this.uGr, true, false);
        this.uGr.setEnabled(false);
        this.uGr.zrh = true;
        this.uGx = false;
        AppMethodBeat.o(51755);
        return;
      }
      if (this.uGw)
      {
        this.screen.cl("wallet_lock_fingerprint", false);
        a(this.uGr, true, true);
        AppMethodBeat.o(51755);
      }
    }
    else
    {
      if (!bool)
      {
        this.screen.cl("wallet_lock_fingerprint", true);
        AppMethodBeat.o(51755);
        return;
      }
      this.screen.cl("wallet_lock_fingerprint", false);
      a(this.uGr, false, true);
    }
    AppMethodBeat.o(51755);
  }
  
  private void cYu()
  {
    AppMethodBeat.i(51756);
    com.tencent.mm.plugin.walletlock.c.g localg = com.tencent.mm.plugin.walletlock.c.g.uGh;
    ab.i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.c.g.cXK()) });
    if ((com.tencent.mm.plugin.walletlock.c.g.uGh.cYg() == 2) || (com.tencent.mm.plugin.walletlock.c.g.uGh.cYg() == 3))
    {
      a(this.uGs, false, true);
      this.screen.cl("wallet_lock_modify_gesture", true);
      AppMethodBeat.o(51756);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.c.g.uGh.cYg() == 1)
    {
      if (this.uGw)
      {
        a(this.uGs, true, true);
        this.screen.cl("wallet_lock_modify_gesture", false);
        AppMethodBeat.o(51756);
      }
    }
    else
    {
      a(this.uGs, false, true);
      this.screen.cl("wallet_lock_modify_gesture", true);
    }
    AppMethodBeat.o(51756);
  }
  
  private void cYv()
  {
    AppMethodBeat.i(51757);
    if (com.tencent.mm.plugin.walletlock.c.g.uGh.cYg() == 0)
    {
      if (this.uGw)
      {
        a(this.uGt, true, true);
        AppMethodBeat.o(51757);
      }
    }
    else {
      a(this.uGt, false, true);
    }
    AppMethodBeat.o(51757);
  }
  
  private void cYw()
  {
    AppMethodBeat.i(51758);
    if ((this.uGr != null) && (this.uGx)) {
      a(this.uGr, false, this.uGx);
    }
    if ((this.uGu != null) && (this.uGy)) {
      a(this.uGu, false, this.uGy);
    }
    if (this.uGs != null) {
      a(this.uGs, false, true);
    }
    if (this.uGt != null) {
      a(this.uGt, false, true);
    }
    AppMethodBeat.o(51758);
  }
  
  private void cYx()
  {
    AppMethodBeat.i(51761);
    this.giQ = com.tencent.mm.ui.base.h.a(this, getString(2131305170), "", new WalletLockSettingUI.2(this));
    this.giQ.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(51761);
  }
  
  private void n(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(51753);
    setResult(paramInt, paramIntent);
    finish();
    AppMethodBeat.o(51753);
  }
  
  private void z(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(51752);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt2);
    localIntent.putExtra("key_err_msg", paramString);
    n(paramInt1, localIntent);
    AppMethodBeat.o(51752);
  }
  
  public int getResourceId()
  {
    return 2131165313;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(51762);
    ab.i("MicroMsg.WalletLockSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      ab.e("MicroMsg.WalletLockSettingUI", "alvinluo data is null");
      AppMethodBeat.o(51762);
      return;
    }
    int i = paramIntent.getIntExtra("key_err_code", -1);
    ab.i("MicroMsg.WalletLockSettingUI", "alvinluo wallet lock setting onActivityResult errCode: %d", new Object[] { Integer.valueOf(i) });
    if (paramInt1 == 1)
    {
      ab.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock onActivityResult");
      if (i == 0)
      {
        if (this.uGv)
        {
          n(paramInt2, paramIntent);
          AppMethodBeat.o(51762);
        }
      }
      else if (i != 4)
      {
        ab.i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
        La(getString(2131305155));
        AppMethodBeat.o(51762);
      }
    }
    else if (paramInt1 == 2)
    {
      ab.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
      if (i == 0)
      {
        if (this.uGv) {
          n(paramInt2, paramIntent);
        }
        d.post(new WalletLockSettingUI.3(this), "WalletLockRemoveAuthKey");
        AppMethodBeat.o(51762);
        return;
      }
      if (i != 4)
      {
        ab.i("MicroMsg.WalletLockSettingUI", "alvinluo open gesture lock failed");
        La(getString(2131305167));
        AppMethodBeat.o(51762);
      }
    }
    else if (paramInt1 == 3)
    {
      if (i == 0)
      {
        ((b)com.tencent.mm.kernel.g.E(b.class)).IL(0);
        paramIntent = com.tencent.mm.plugin.walletlock.c.g.uGh;
        com.tencent.mm.plugin.walletlock.c.g.cXB();
        cYs();
        Toast.makeText(this, getString(2131305149), 0).show();
        com.tencent.mm.plugin.walletlock.c.h.cYm();
        if (this.uGv) {
          z(-1, 0, "close wallet lock ok");
        }
        d.post(new WalletLockSettingUI.5(this), "WalletLockRemoveAuthKey");
        paramIntent = new bt();
        paramIntent.cRI = 14L;
        paramIntent.cYT = 2L;
        paramIntent.ake();
        AppMethodBeat.o(51762);
        return;
      }
      if (i != 4) {
        La(getString(2131305150));
      }
    }
    AppMethodBeat.o(51762);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(51751);
    ab.i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
    if (this.uGv)
    {
      z(0, 4, "user cancel setting wallet lock");
      AppMethodBeat.o(51751);
      return;
    }
    finish();
    AppMethodBeat.o(51751);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51748);
    super.onCreate(paramBundle);
    setBackBtn(new WalletLockSettingUI.1(this));
    setMMTitle(2131305174);
    this.screen = getPreferenceScreen();
    this.screen = getPreferenceScreen();
    this.uGr = ((IconPreference)this.screen.atx("wallet_lock_fingerprint"));
    this.uGs = ((IconPreference)this.screen.atx("wallet_lock_gesture"));
    this.uGt = ((IconPreference)this.screen.atx("wallet_lock_close"));
    this.uGu = ((IconPreference)this.screen.atx("wallet_lock_faceid"));
    this.uGr.OW(8);
    this.uGs.OW(8);
    this.uGt.OW(8);
    this.uGu.OW(8);
    this.screen.cl("wallet_lock_faceid", true);
    this.ejF = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
    this.mScene = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
    if (this.mScene == 1)
    {
      this.uGv = true;
      this.uGw = false;
    }
    paramBundle = new bt();
    paramBundle.cRI = 13L;
    paramBundle.cYT = 1L;
    paramBundle.cYU = this.ejF;
    paramBundle.ake();
    ab.i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", new Object[] { Boolean.valueOf(this.uGv), Boolean.valueOf(this.uGw) });
    AppMethodBeat.o(51748);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51750);
    super.onPause();
    if ((this.giQ != null) && (this.giQ.isShowing())) {
      this.giQ.dismiss();
    }
    AppMethodBeat.o(51750);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(51760);
    if ("wallet_lock_fingerprint".equals(paramPreference.mKey))
    {
      cYw();
      a(paramPreference, true, true);
      if ((this.uGx) && ((!this.uGw) || (com.tencent.mm.plugin.walletlock.c.g.uGh.cYg() != 2)))
      {
        if (com.tencent.soter.core.a.ji(this)) {
          break label72;
        }
        cYx();
      }
      for (;;)
      {
        AppMethodBeat.o(51760);
        return true;
        label72:
        if ((!this.uGw) || (com.tencent.mm.plugin.walletlock.c.g.uGh.cYg() != 2))
        {
          ab.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
          ((b)com.tencent.mm.kernel.g.E(b.class)).b(this, 2, 1);
        }
      }
    }
    if ("wallet_lock_faceid".equals(paramPreference.mKey))
    {
      cYw();
      a(paramPreference, true, true);
      if ((this.uGy) && ((!this.uGw) || (com.tencent.mm.plugin.walletlock.c.g.uGh.cYg() != 3)))
      {
        if (com.tencent.soter.core.a.jj(this)) {
          break label184;
        }
        cYx();
      }
      for (;;)
      {
        AppMethodBeat.o(51760);
        return true;
        label184:
        if ((!this.uGw) || (com.tencent.mm.plugin.walletlock.c.g.uGh.cYg() == 3))
        {
          ab.i("MicroMsg.WalletLockSettingUI", "request open faceid lock");
          ((b)com.tencent.mm.kernel.g.E(b.class)).b(this, 3, 4);
        }
      }
    }
    if ("wallet_lock_gesture".equals(paramPreference.mKey))
    {
      cYw();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.uGh.cYg() != 1)
      {
        ab.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
        ((b)com.tencent.mm.kernel.g.E(b.class)).b(this, 1, 2);
      }
      AppMethodBeat.o(51760);
      return true;
    }
    if ("wallet_lock_close".equals(paramPreference.mKey))
    {
      cYw();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.c.g.uGh.cYg() != 0)
      {
        ab.i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
        ((b)com.tencent.mm.kernel.g.E(b.class)).k(this, 3);
        paramf = new bt();
        paramf.cRI = 14L;
        paramf.cYT = 1L;
        paramf.ake();
      }
      AppMethodBeat.o(51760);
      return true;
    }
    if ("wallet_lock_modify_gesture".equals(paramPreference.mKey))
    {
      ((b)com.tencent.mm.kernel.g.E(b.class)).ak(this);
      AppMethodBeat.o(51760);
      return true;
    }
    AppMethodBeat.o(51760);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51749);
    super.onResume();
    cYs();
    AppMethodBeat.o(51749);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI
 * JD-Core Version:    0.7.0.1
 */