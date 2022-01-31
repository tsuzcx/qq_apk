package com.tencent.mm.plugin.wallet.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletJsApiAdapterUI
  extends WalletBaseUI
{
  protected boolean nzO = false;
  protected String packageName = "";
  protected String qqr = "";
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.WalletJsApiAdapterUI", "onSceneEnd errType %s errCode %s errMsg %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.a))
      {
        f.Xf(((com.tencent.mm.plugin.wallet_core.c.a)paramm).bUH());
        paramString = new Intent();
        paramString.putExtra("intent_finish_self", true);
        d.b(this, this.packageName, this.qqr, paramString, 1);
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      setResult(-1);
      finish();
    }
  }
  
  public void onBackPressed()
  {
    if (!this.nzO)
    {
      y.d("MicroMsg.WalletJsApiAdapterUI", "back press not lock");
      finish();
      return;
    }
    y.d("MicroMsg.WalletJsApiAdapterUI", "back press but lock");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    vN(8);
    this.packageName = getIntent().getStringExtra("intent_jump_package");
    this.qqr = getIntent().getStringExtra("intent_jump_ui");
    kh(580);
    if (getIntent() == null)
    {
      y.d("MicroMsg.WalletJsApiAdapterUI", "func[doCheckPayNetscene] intent null");
      setResult(0);
      finish();
      return;
    }
    paramBundle = new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 3, "openWCPayCardList", getIntent().getIntExtra("pay_channel", 0));
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
    y.v("MicroMsg.WalletJsApiAdapterUI", "onNewIntent");
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
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.WalletJsApiAdapterUI
 * JD-Core Version:    0.7.0.1
 */