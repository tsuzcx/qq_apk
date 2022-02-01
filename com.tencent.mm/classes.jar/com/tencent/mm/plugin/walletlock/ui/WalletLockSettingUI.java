package com.tencent.mm.plugin.walletlock.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ada;
import com.tencent.mm.autogen.mmdata.rpt.rn;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.soter.model.j;
import com.tencent.mm.plugin.walletlock.a.f;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.a.i;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.model.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.widget.a.e;

public class WalletLockSettingUI
  extends MMPreference
{
  private IconPreference WhW;
  private IconPreference WhX;
  private IconPreference WhY;
  private IconPreference WhZ;
  private boolean Wia;
  private boolean Wib;
  private boolean Wic;
  private boolean Wid;
  private int lCR;
  private int mScene;
  private e pjp;
  private com.tencent.mm.ui.base.preference.f screen;
  private IListener<ada> walletLockListener;
  
  public WalletLockSettingUI()
  {
    AppMethodBeat.i(266840);
    this.mScene = -1;
    this.lCR = 0;
    this.Wia = false;
    this.Wib = true;
    this.Wic = true;
    this.Wid = true;
    this.walletLockListener = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(266840);
  }
  
  private void U(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(129954);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt2);
    localIntent.putExtra("key_err_msg", paramString);
    t(paramInt1, localIntent);
    AppMethodBeat.o(129954);
  }
  
  private void a(Preference paramPreference, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(129961);
    if ((paramPreference instanceof IconPreference))
    {
      paramPreference = (IconPreference)paramPreference;
      paramPreference.oo(com.tencent.mm.cd.a.fromDPToPix(this, 20), com.tencent.mm.cd.a.fromDPToPix(this, 20));
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          paramPreference.aBg(a.f.radio_on);
        }
        for (;;)
        {
          paramPreference.aBh(0);
          AppMethodBeat.o(129961);
          return;
          paramPreference.aBg(a.f.radio_default_on);
        }
      }
      paramPreference.aBg(a.f.radio_off);
      paramPreference.aBh(0);
    }
    AppMethodBeat.o(129961);
  }
  
  private void aoP(String paramString)
  {
    AppMethodBeat.i(129965);
    this.pjp = k.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    this.pjp.setCanceledOnTouchOutside(false);
    this.pjp.show();
    AppMethodBeat.o(129965);
  }
  
  private void inA()
  {
    AppMethodBeat.i(129958);
    com.tencent.mm.plugin.walletlock.model.f localf = com.tencent.mm.plugin.walletlock.model.f.WhM;
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.model.f.imQ()) });
    if ((com.tencent.mm.plugin.walletlock.model.f.WhM.inm() == 2) || (com.tencent.mm.plugin.walletlock.model.f.WhM.inm() == 3))
    {
      a(this.WhX, false, true);
      this.screen.eh("wallet_lock_modify_gesture", true);
      this.WhX.setContentDescription(getString(a.g.WfE) + getString(a.g.Wfs));
      AppMethodBeat.o(129958);
      return;
    }
    if (com.tencent.mm.plugin.walletlock.model.f.WhM.inm() == 1)
    {
      if (this.Wib)
      {
        a(this.WhX, true, true);
        this.screen.eh("wallet_lock_modify_gesture", false);
        this.WhX.setContentDescription(getString(a.g.WfD) + getString(a.g.Wfs));
        AppMethodBeat.o(129958);
      }
    }
    else
    {
      a(this.WhX, false, true);
      this.screen.eh("wallet_lock_modify_gesture", true);
      this.WhX.setContentDescription(getString(a.g.WfE) + getString(a.g.Wfs));
    }
    AppMethodBeat.o(129958);
  }
  
  private void inB()
  {
    AppMethodBeat.i(129959);
    if (com.tencent.mm.plugin.walletlock.model.f.WhM.inm() == 0)
    {
      if (this.Wib)
      {
        a(this.WhY, true, true);
        AppMethodBeat.o(129959);
      }
    }
    else {
      a(this.WhY, false, true);
    }
    AppMethodBeat.o(129959);
  }
  
  private void inC()
  {
    AppMethodBeat.i(129960);
    if ((this.WhW != null) && (this.Wic)) {
      a(this.WhW, false, this.Wic);
    }
    if ((this.WhZ != null) && (this.Wid)) {
      a(this.WhZ, false, this.Wid);
    }
    if (this.WhX != null) {
      a(this.WhX, false, true);
    }
    if (this.WhY != null) {
      a(this.WhY, false, true);
    }
    AppMethodBeat.o(129960);
  }
  
  private void inD()
  {
    AppMethodBeat.i(129963);
    this.pjp = k.d(this, getString(a.g.Wfu), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(266841);
        WalletLockSettingUI.b(WalletLockSettingUI.this);
        AppMethodBeat.o(266841);
      }
    });
    this.pjp.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(129963);
  }
  
  private void iny()
  {
    AppMethodBeat.i(129956);
    inC();
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.walletlock.model.f.WhM.inm()) });
    inz();
    inA();
    inB();
    AppMethodBeat.o(129956);
  }
  
  private void inz()
  {
    AppMethodBeat.i(129957);
    com.tencent.mm.plugin.walletlock.model.f localf = com.tencent.mm.plugin.walletlock.model.f.WhM;
    if (!com.tencent.mm.plugin.walletlock.model.f.inq())
    {
      Log.w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
      this.screen.eh("wallet_lock_fingerprint", true);
      AppMethodBeat.o(129957);
      return;
    }
    boolean bool = j.jW(getContext());
    localf = com.tencent.mm.plugin.walletlock.model.f.WhM;
    if (com.tencent.mm.plugin.walletlock.model.f.imE())
    {
      if (!bool)
      {
        this.screen.eh("wallet_lock_fingerprint", false);
        this.WhW.setDesc(getString(a.g.Wff));
        this.WhW.jnl();
        a(this.WhW, true, false);
        this.WhW.setEnabled(false);
        this.WhW.adYM = true;
        this.Wic = false;
        AppMethodBeat.o(129957);
        return;
      }
      if (this.Wib)
      {
        this.screen.eh("wallet_lock_fingerprint", false);
        a(this.WhW, true, true);
        this.WhW.setContentDescription(getString(a.g.WfD) + getString(a.g.Wfl));
        AppMethodBeat.o(129957);
      }
    }
    else
    {
      if (!bool)
      {
        this.screen.eh("wallet_lock_fingerprint", true);
        AppMethodBeat.o(129957);
        return;
      }
      this.screen.eh("wallet_lock_fingerprint", false);
      a(this.WhW, false, true);
      this.WhW.setContentDescription(getString(a.g.WfE) + getString(a.g.Wfl));
    }
    AppMethodBeat.o(129957);
  }
  
  private void t(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(129955);
    setResult(paramInt, paramIntent);
    finish();
    AppMethodBeat.o(129955);
  }
  
  public int getResourceId()
  {
    return a.i.WfN;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(129964);
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      Log.e("MicroMsg.WalletLockSettingUI", "alvinluo data is null");
      AppMethodBeat.o(129964);
      return;
    }
    int i = paramIntent.getIntExtra("key_err_code", -1);
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo wallet lock setting onActivityResult errCode: %d", new Object[] { Integer.valueOf(i) });
    if (paramInt1 == 1)
    {
      Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock onActivityResult");
      if (i == 0)
      {
        if (this.Wia)
        {
          t(paramInt2, paramIntent);
          AppMethodBeat.o(129964);
        }
      }
      else if (i != 4)
      {
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
        aoP(getString(a.g.Wfh));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 2)
    {
      Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
      if (i == 0)
      {
        if (this.Wia) {
          t(paramInt2, paramIntent);
        }
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(266844);
            try
            {
              com.tencent.soter.a.a.aHj(3);
              AppMethodBeat.o(266844);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.WalletLockSettingUI", "Remove AK after open gesture lock failed! " + localException.getMessage());
              AppMethodBeat.o(266844);
            }
          }
        }, "WalletLockRemoveAuthKey");
        AppMethodBeat.o(129964);
        return;
      }
      if (i != 4)
      {
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo open gesture lock failed");
        aoP(getString(a.g.Wfr));
        AppMethodBeat.o(129964);
      }
    }
    else if (paramInt1 == 3)
    {
      if (i == 0)
      {
        ((b)h.ax(b.class)).asE(0);
        paramIntent = com.tencent.mm.plugin.walletlock.model.f.WhM;
        com.tencent.mm.plugin.walletlock.model.f.imH();
        iny();
        Toast.makeText(this, getString(a.g.Wfd), 0).show();
        g.ins();
        if (this.Wia) {
          U(-1, 0, "close wallet lock ok");
        }
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(266839);
            try
            {
              com.tencent.soter.a.a.aHj(3);
              AppMethodBeat.o(266839);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.WalletLockSettingUI", "Remove AK after close wallet lock failed! " + localException.getMessage());
              AppMethodBeat.o(266839);
            }
          }
        }, "WalletLockRemoveAuthKey");
        paramIntent = new rn();
        paramIntent.iPe = 14L;
        paramIntent.jvX = 2L;
        paramIntent.bMH();
        AppMethodBeat.o(129964);
        return;
      }
      if (i != 4) {
        aoP(getString(a.g.Wfe));
      }
    }
    AppMethodBeat.o(129964);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(129953);
    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
    if (this.Wia)
    {
      U(0, 4, "user cancel setting wallet lock");
      AppMethodBeat.o(129953);
      return;
    }
    finish();
    AppMethodBeat.o(129953);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(129950);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(266842);
        if (WalletLockSettingUI.a(WalletLockSettingUI.this)) {
          WalletLockSettingUI.a(WalletLockSettingUI.this, "user cancel setting wallet lock");
        }
        for (;;)
        {
          AppMethodBeat.o(266842);
          return false;
          WalletLockSettingUI.this.finish();
        }
      }
    });
    setMMTitle(a.g.Wfz);
    this.screen = getPreferenceScreen();
    this.screen = getPreferenceScreen();
    this.WhW = ((IconPreference)this.screen.bAi("wallet_lock_fingerprint"));
    this.WhX = ((IconPreference)this.screen.bAi("wallet_lock_gesture"));
    this.WhY = ((IconPreference)this.screen.bAi("wallet_lock_close"));
    this.WhZ = ((IconPreference)this.screen.bAi("wallet_lock_faceid"));
    this.WhW.aBi(0);
    this.WhX.aBi(0);
    this.WhY.aBi(0);
    this.WhZ.aBi(0);
    this.WhW.aBq(8);
    this.WhX.aBq(8);
    this.WhY.aBq(8);
    this.WhZ.aBq(8);
    this.screen.eh("wallet_lock_faceid", true);
    paramBundle = (PreferenceTitleCategory)this.screen.bAi("wallet_lock_title");
    boolean bool = ((c)h.ax(c.class)).a(c.a.yXe, false);
    Log.i("MicroMsg.WalletLockSettingUI", " cn wallet open new name ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      paramBundle.setTitle(getString(a.g.Wfy));
      this.lCR = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
      this.mScene = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
      if (this.mScene != 1) {
        break label408;
      }
      this.Wia = true;
      this.Wib = false;
    }
    for (;;)
    {
      paramBundle = new rn();
      paramBundle.iPe = 13L;
      paramBundle.jvX = 1L;
      paramBundle.jvY = this.lCR;
      paramBundle.bMH();
      Log.i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", new Object[] { Boolean.valueOf(this.Wia), Boolean.valueOf(this.Wib) });
      AppMethodBeat.o(129950);
      return;
      paramBundle.setTitle(getString(a.g.Wfx));
      break;
      label408:
      if (this.mScene == 2) {
        this.walletLockListener.alive();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(266851);
    super.onDestroy();
    if (this.mScene == 2) {
      this.walletLockListener.dead();
    }
    AppMethodBeat.o(266851);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(129952);
    super.onPause();
    if ((this.pjp != null) && (this.pjp.isShowing())) {
      this.pjp.dismiss();
    }
    AppMethodBeat.o(129952);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(129962);
    if ("wallet_lock_fingerprint".equals(paramPreference.mKey))
    {
      inC();
      a(paramPreference, true, true);
      if ((this.Wic) && ((!this.Wib) || (com.tencent.mm.plugin.walletlock.model.f.WhM.inm() != 2)))
      {
        if (com.tencent.soter.core.a.oo(this)) {
          break label73;
        }
        inD();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label73:
        if ((!this.Wib) || (com.tencent.mm.plugin.walletlock.model.f.WhM.inm() != 2))
        {
          Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
          ((b)h.ax(b.class)).c(this, 2, 1);
        }
      }
    }
    if ("wallet_lock_faceid".equals(paramPreference.mKey))
    {
      inC();
      a(paramPreference, true, true);
      if ((this.Wid) && ((!this.Wib) || (com.tencent.mm.plugin.walletlock.model.f.WhM.inm() != 3)))
      {
        if (com.tencent.soter.core.a.bI(this, 2)) {
          break label186;
        }
        inD();
      }
      for (;;)
      {
        AppMethodBeat.o(129962);
        return true;
        label186:
        if ((!this.Wib) || (com.tencent.mm.plugin.walletlock.model.f.WhM.inm() == 3))
        {
          Log.i("MicroMsg.WalletLockSettingUI", "request open faceid lock");
          ((b)h.ax(b.class)).c(this, 3, 4);
        }
      }
    }
    if ("wallet_lock_gesture".equals(paramPreference.mKey))
    {
      inC();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.model.f.WhM.inm() != 1)
      {
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
        ((b)h.ax(b.class)).c(this, 1, 2);
      }
      AppMethodBeat.o(129962);
      return true;
    }
    if ("wallet_lock_close".equals(paramPreference.mKey))
    {
      inC();
      a(paramPreference, true, true);
      if (com.tencent.mm.plugin.walletlock.model.f.WhM.inm() != 0)
      {
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
        ((b)h.ax(b.class)).p(this, 3);
        paramf = new rn();
        paramf.iPe = 14L;
        paramf.jvX = 1L;
        paramf.bMH();
      }
      AppMethodBeat.o(129962);
      return true;
    }
    if ("wallet_lock_modify_gesture".equals(paramPreference.mKey))
    {
      ((b)h.ax(b.class)).bA(this);
      AppMethodBeat.o(129962);
      return true;
    }
    AppMethodBeat.o(129962);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(129951);
    super.onResume();
    iny();
    AppMethodBeat.o(129951);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI
 * JD-Core Version:    0.7.0.1
 */