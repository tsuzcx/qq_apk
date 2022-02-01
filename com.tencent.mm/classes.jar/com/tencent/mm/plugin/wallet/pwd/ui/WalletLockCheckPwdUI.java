package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.zv;
import com.tencent.mm.plugin.wallet.pwd.a.e;
import com.tencent.mm.plugin.wallet.pwd.a.r;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.a;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import java.util.HashSet;

public class WalletLockCheckPwdUI
  extends WalletBaseUI
{
  private EditHintPasswdView Vjw;
  private x Vjx;
  private int Vrl = -1;
  private String eb;
  private ScrollView pLK;
  private TextView sUt;
  private TextView wzp;
  
  private void W(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69721);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt);
    localIntent.putExtra("key_token", paramString1);
    localIntent.putExtra("key_type", paramString2);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(69721);
  }
  
  private void arY(int paramInt)
  {
    AppMethodBeat.i(69720);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(69720);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(69719);
    super.cleanUiData(paramInt);
    this.Vjw.gGd();
    AppMethodBeat.o(69719);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_check_pwd;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(69723);
    if (paramIntent == null) {}
    for (;;)
    {
      Log.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI onActivityResult requestCode: %d, resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      setResult(paramInt2, paramIntent);
      finish();
      AppMethodBeat.o(69723);
      return;
      bool = false;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(69718);
    Log.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo onBackPressed");
    arY(4);
    AppMethodBeat.o(69718);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69716);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.white));
    setMMTitle("");
    hideActionbarLine();
    this.Vrl = getIntent().getIntExtra("key_wallet_lock_type", -1);
    this.eb = getIntent().getStringExtra("action");
    Log.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo wallet lock type: %d, action: %s", new Object[] { Integer.valueOf(this.Vrl), this.eb });
    this.Vjw = ((EditHintPasswdView)findViewById(a.f.input_et));
    this.sUt = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.wzp = ((TextView)findViewById(a.f.wallet_pwd_content));
    this.pLK = ((ScrollView)findViewById(a.f.wcp_root_view));
    com.tencent.mm.wallet_core.ui.i.Q(this.sUt);
    paramBundle = getIntent().getStringExtra("key_wallet_lock_input_new_fp_tips");
    if (this.Vrl == 2)
    {
      this.sUt.setText(a.i.wallet_wx_offline_start_fingerprint_lock);
      if ((this.eb.equals("action.touchlock_need_verify_paypwd")) && (!Util.isNullOrNil(paramBundle))) {
        this.wzp.setText(paramBundle);
      }
    }
    for (;;)
    {
      this.Vjw.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          int i = 8;
          AppMethodBeat.i(315640);
          if (paramAnonymousBoolean)
          {
            if (WalletLockCheckPwdUI.b(WalletLockCheckPwdUI.this) == null)
            {
              AppMethodBeat.o(315640);
              return;
            }
            if (WalletLockCheckPwdUI.b(WalletLockCheckPwdUI.this).equals("action.close_wallet_lock"))
            {
              WalletLockCheckPwdUI.c(WalletLockCheckPwdUI.this);
              AppMethodBeat.o(315640);
              return;
            }
            if (WalletLockCheckPwdUI.b(WalletLockCheckPwdUI.this).equals("action.verify_paypwd"))
            {
              if (WalletLockCheckPwdUI.d(WalletLockCheckPwdUI.this) == 1) {
                i = 6;
              }
              for (;;)
              {
                WalletLockCheckPwdUI.a(WalletLockCheckPwdUI.this, new x(WalletLockCheckPwdUI.e(WalletLockCheckPwdUI.this).getText(), i, WalletLockCheckPwdUI.this.getPayReqKey()));
                WalletLockCheckPwdUI.this.doSceneForceProgress(WalletLockCheckPwdUI.f(WalletLockCheckPwdUI.this));
                AppMethodBeat.o(315640);
                return;
                if (WalletLockCheckPwdUI.d(WalletLockCheckPwdUI.this) != 2) {
                  i = -1;
                }
              }
            }
            if (WalletLockCheckPwdUI.b(WalletLockCheckPwdUI.this).equals("action.touchlock_verify_by_paypwd"))
            {
              r localr = new r(WalletLockCheckPwdUI.e(WalletLockCheckPwdUI.this).getText());
              WalletLockCheckPwdUI.this.doSceneForceProgress(localr);
              AppMethodBeat.o(315640);
              return;
            }
            if (WalletLockCheckPwdUI.b(WalletLockCheckPwdUI.this).equals("action.touchlock_need_verify_paypwd")) {
              if (WalletLockCheckPwdUI.d(WalletLockCheckPwdUI.this) != 2) {
                break label280;
              }
            }
          }
          for (;;)
          {
            WalletLockCheckPwdUI.a(WalletLockCheckPwdUI.this, new x(WalletLockCheckPwdUI.e(WalletLockCheckPwdUI.this).getText(), i, WalletLockCheckPwdUI.this.getPayReqKey()));
            WalletLockCheckPwdUI.this.doSceneForceProgress(WalletLockCheckPwdUI.f(WalletLockCheckPwdUI.this));
            AppMethodBeat.o(315640);
            return;
            label280:
            i = -1;
          }
        }
      });
      setTenpayKBStateListener(new a()
      {
        public final void onVisibleStateChange(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(315639);
          Log.d("MicroMsg.WalletLockCheckPwdUI", "kb visibility: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          WalletLockCheckPwdUI.g(WalletLockCheckPwdUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(315622);
              if (paramAnonymousBoolean)
              {
                WalletLockCheckPwdUI.g(WalletLockCheckPwdUI.this).fullScroll(130);
                AppMethodBeat.o(315622);
                return;
              }
              WalletLockCheckPwdUI.g(WalletLockCheckPwdUI.this).fullScroll(33);
              AppMethodBeat.o(315622);
            }
          });
          AppMethodBeat.o(315639);
        }
      });
      hideKeyboardPushDownBtn();
      setEditFocusListener(this.Vjw, 0, false);
      showTenpayKB();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69713);
          Log.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
          WalletLockCheckPwdUI.a(WalletLockCheckPwdUI.this);
          AppMethodBeat.o(69713);
          return true;
        }
      });
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(getResources().getColor(a.c.white));
        if (Build.VERSION.SDK_INT >= 23) {
          paramBundle.getDecorView().setSystemUiVisibility(8192);
        }
      }
      getContentView().setFitsSystemWindows(true);
      AppMethodBeat.o(69716);
      return;
      if (this.Vrl == 1) {
        this.sUt.setText(a.i.wallet_wx_offline_start_gesture);
      }
    }
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69717);
    super.onResume();
    if (this.Vjw != null) {
      this.Vjw.gGd();
    }
    AppMethodBeat.o(69717);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(69722);
    Log.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp instanceof x))
    {
      paramp = (x)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ("next_action.switch_on_pattern".equals(getIntent().getStringExtra("next_action")))
        {
          Log.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo start to open wallet lock after check pwd");
          paramString = new Intent();
          paramString.putExtra("action", "action.switch_on_pattern");
          paramString.putExtra("next_action", "next_action.switch_on_pattern");
          paramString.putExtra("token", paramp.token);
          paramString.putExtra("type", paramp.VxV);
          paramString.putExtra("key_wallet_lock_type", this.Vrl);
          paramString.setPackage(MMApplicationContext.getPackageName());
          if (this.Vrl == 2) {
            paramString.putExtra("key_pay_passwd", this.Vjw.getText());
          }
          paramp = new zv();
          paramp.idq.ids = paramString;
          paramp.idq.hHU = this;
          paramp.idq.hPm = 1;
          paramp.publish();
        }
        for (;;)
        {
          AppMethodBeat.o(69722);
          return true;
          W(0, paramp.token, paramp.VxV);
        }
      }
      if ((paramInt1 == 1000) && (paramInt2 == 3))
      {
        W(-1, null, null);
        AppMethodBeat.o(69722);
        return true;
      }
    }
    else
    {
      if ((paramp instanceof r))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          arY(0);
        }
        for (;;)
        {
          AppMethodBeat.o(69722);
          return true;
          arY(-1);
        }
      }
      if ((paramp instanceof e))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label344;
        }
        arY(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(69722);
      return false;
      label344:
      arY(-1);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(315668);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet_core.utils.i.class);
    AppMethodBeat.o(315668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */