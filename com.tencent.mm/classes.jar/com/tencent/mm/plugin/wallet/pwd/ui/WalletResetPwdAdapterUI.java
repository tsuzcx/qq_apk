package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet.pwd.b;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletResetPwdAdapterUI
  extends WalletBaseUI
{
  protected com.tencent.mm.plugin.wallet.a OlA = null;
  protected boolean Olz = false;
  protected String Vsa = "";
  protected String luk = null;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(69784);
    if (!this.Olz)
    {
      Log.d("MicroMsg.WalletResetPwdAdapterUI", "back press not lock");
      finish();
      AppMethodBeat.o(69784);
      return;
    }
    Log.d("MicroMsg.WalletResetPwdAdapterUI", "back press but lock");
    AppMethodBeat.o(69784);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69781);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    this.Vsa = getIntent().getStringExtra("reset_pwd_token");
    Log.i("MicroMsg.WalletResetPwdAdapterUI", "token_by_resetPwd %s", new Object[] { this.Vsa });
    addSceneEndListener(580);
    if (getIntent() == null)
    {
      Log.d("MicroMsg.WalletResetPwdAdapterUI", "func[doCheckPayNetscene] intent null");
      setResult(0);
      finish();
      AppMethodBeat.o(69781);
      return;
    }
    paramBundle = new d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 13, "setWCPayPassword", getIntent().getIntExtra("pay_channel", 0));
    paramBundle.setProcessName("RemittanceProcess");
    doSceneForceProgress(paramBundle);
    AppMethodBeat.o(69781);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69783);
    removeSceneEndListener(580);
    super.onDestroy();
    AppMethodBeat.o(69783);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(69782);
    Log.v("MicroMsg.WalletResetPwdAdapterUI", "onNewIntent");
    int i = paramIntent.getIntExtra("RESET_PWD_USER_ACTION", 0);
    if (i == 1)
    {
      setResult(-1);
      finish();
      AppMethodBeat.o(69782);
      return;
    }
    if (i == 2)
    {
      setResult(-1000);
      finish();
      AppMethodBeat.o(69782);
      return;
    }
    setResult(0);
    finish();
    AppMethodBeat.o(69782);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(69785);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof d))
      {
        e.brZ(((d)paramp).ihJ());
        paramString = new Bundle();
        paramString.putString("kreq_token", this.Vsa);
        paramp = ((d)paramp).ihK();
        if (paramp != null)
        {
          paramString.putString("key_pwd_title", paramp.title);
          paramString.putString("key_pwd_desc", paramp.abhZ);
        }
        com.tencent.mm.wallet_core.a.a(this, b.class, paramString, null);
        AppMethodBeat.o(69785);
        return true;
      }
    }
    else
    {
      setResult(-1000);
      k.cZ(this, paramString);
      finish();
      AppMethodBeat.o(69785);
      return true;
    }
    AppMethodBeat.o(69785);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI
 * JD-Core Version:    0.7.0.1
 */