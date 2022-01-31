package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.pwd.c;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletResetPwdAdapterUI
  extends WalletBaseUI
{
  protected String djD = null;
  protected boolean nzO = false;
  protected com.tencent.mm.plugin.wallet.a nzP = null;
  protected String qpI = "";
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.a))
      {
        f.Xf(((com.tencent.mm.plugin.wallet_core.c.a)paramm).bUH());
        paramString = new Bundle();
        paramString.putString("kreq_token", this.qpI);
        com.tencent.mm.wallet_core.a.a(this, c.class, paramString, null);
        return true;
      }
    }
    else
    {
      setResult(-1000);
      h.bC(this, paramString);
      finish();
      return true;
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    if (!this.nzO)
    {
      y.d("MicroMsg.WalletResetPwdAdapterUI", "back press not lock");
      finish();
      return;
    }
    y.d("MicroMsg.WalletResetPwdAdapterUI", "back press but lock");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vN(8);
    this.qpI = getIntent().getStringExtra("reset_pwd_token");
    y.i("MicroMsg.WalletResetPwdAdapterUI", "token_by_resetPwd %s", new Object[] { this.qpI });
    kh(580);
    if (getIntent() == null)
    {
      y.d("MicroMsg.WalletResetPwdAdapterUI", "func[doCheckPayNetscene] intent null");
      setResult(0);
      finish();
      return;
    }
    paramBundle = new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 13, "setWCPayPassword", getIntent().getIntExtra("pay_channel", 0));
    paramBundle.dIA = "RemittanceProcess";
    a(paramBundle, true, false);
  }
  
  public void onDestroy()
  {
    ki(580);
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.v("MicroMsg.WalletResetPwdAdapterUI", "onNewIntent");
    int i = paramIntent.getIntExtra("RESET_PWD_USER_ACTION", 0);
    if (i == 1)
    {
      setResult(-1);
      finish();
      return;
    }
    if (i == 2)
    {
      setResult(-1000);
      finish();
      return;
    }
    setResult(0);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI
 * JD-Core Version:    0.7.0.1
 */