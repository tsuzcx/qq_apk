package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.rg;
import com.tencent.mm.plugin.wallet.pwd.a.j;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

public class WalletLockCheckPwdUI
  extends WalletBaseUI
{
  private String CO;
  private TextView haW;
  private TextView irN;
  private r qjm;
  private EditHintPasswdView qpq;
  private int qpr = -1;
  
  private void AK(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt);
    setResult(-1, localIntent);
    finish();
  }
  
  private void u(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt);
    localIntent.putExtra("key_token", paramString1);
    localIntent.putExtra("key_type", paramString2);
    setResult(-1, localIntent);
    finish();
  }
  
  protected final boolean aSl()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof r))
    {
      paramm = (r)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ("next_action.switch_on_pattern".equals(getIntent().getStringExtra("next_action")))
        {
          y.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo start to open wallet lock after check pwd");
          paramString = new Intent();
          paramString.putExtra("action", "action.switch_on_pattern");
          paramString.putExtra("next_action", "next_action.switch_on_pattern");
          paramString.putExtra("token", paramm.token);
          paramString.putExtra("type", paramm.qqR);
          paramString.putExtra("key_wallet_lock_type", this.qpr);
          paramString.setPackage(ae.getPackageName());
          if (this.qpr == 2) {
            paramString.putExtra("key_pay_passwd", this.qpq.getText());
          }
          paramm = new rg();
          paramm.caO.caQ = paramString;
          paramm.caO.bMV = this;
          paramm.caO.bQU = 1;
          com.tencent.mm.sdk.b.a.udP.m(paramm);
          return true;
        }
        u(0, paramm.token, paramm.qqR);
        return true;
      }
      if ((paramInt1 == 1000) && (paramInt2 == 3))
      {
        u(-1, null, null);
        return true;
      }
    }
    else
    {
      if ((paramm instanceof j))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          AK(0);
          return true;
        }
        AK(-1);
        return true;
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.a))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label305;
        }
        AK(0);
      }
    }
    for (;;)
    {
      return false;
      label305:
      AK(-1);
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_check_pwd;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    if (paramIntent == null) {}
    for (;;)
    {
      y.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI onActivityResult requestCode: %d, resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      setResult(paramInt2, paramIntent);
      finish();
      return;
      bool = false;
    }
  }
  
  public void onBackPressed()
  {
    y.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo onBackPressed");
    AK(4);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    this.qpr = getIntent().getIntExtra("key_wallet_lock_type", -1);
    this.CO = getIntent().getStringExtra("action");
    y.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo wallet lock type: %d, action: %s", new Object[] { Integer.valueOf(this.qpr), this.CO });
    this.qpq = ((EditHintPasswdView)findViewById(a.f.input_et));
    this.haW = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.irN = ((TextView)findViewById(a.f.wallet_pwd_content));
    paramBundle = getIntent().getStringExtra("key_wallet_lock_input_new_fp_tips");
    if (this.qpr == 2)
    {
      this.haW.setText(a.i.wallet_wx_offline_start_fingerprint_lock);
      if ((this.CO.equals("action.touchlock_need_verify_paypwd")) && (!bk.bl(paramBundle))) {
        this.irN.setText(paramBundle);
      }
    }
    for (;;)
    {
      this.qpq.setOnInputValidListener(new WalletLockCheckPwdUI.3(this));
      e(this.qpq, 0, false);
      setBackBtn(new WalletLockCheckPwdUI.1(this));
      findViewById(a.f.close_button).setOnClickListener(new WalletLockCheckPwdUI.2(this));
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(getResources().getColor(a.c.white));
        if (Build.VERSION.SDK_INT >= 23) {
          paramBundle.getDecorView().setSystemUiVisibility(8192);
        }
      }
      this.mController.contentView.setFitsSystemWindows(true);
      return;
      if (this.qpr == 1) {
        this.haW.setText(a.i.wallet_wx_offline_start_gesture);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.qpq != null) {
      this.qpq.bvr();
    }
  }
  
  public final void st(int paramInt)
  {
    super.st(paramInt);
    this.qpq.bvr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */