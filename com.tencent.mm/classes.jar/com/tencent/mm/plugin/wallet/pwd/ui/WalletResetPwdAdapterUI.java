package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wallet.pwd.c;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletResetPwdAdapterUI
  extends WalletBaseUI
{
  protected boolean Iog = false;
  protected com.tencent.mm.plugin.wallet.a Ioh = null;
  protected String OCM = "";
  protected String iSn = null;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(69784);
    if (!this.Iog)
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
    this.OCM = getIntent().getStringExtra("reset_pwd_token");
    Log.i("MicroMsg.WalletResetPwdAdapterUI", "token_by_resetPwd %s", new Object[] { this.OCM });
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69785);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof d))
      {
        e.bsi(((d)paramq).gIv());
        paramString = new Bundle();
        paramString.putString("kreq_token", this.OCM);
        paramq = ((d)paramq).gIw();
        if (paramq != null)
        {
          paramString.putString("key_pwd_title", paramq.title);
          paramString.putString("key_pwd_desc", paramq.TRA);
        }
        com.tencent.mm.wallet_core.a.a(this, c.class, paramString, null);
        AppMethodBeat.o(69785);
        return true;
      }
    }
    else
    {
      setResult(-1000);
      h.cO(this, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI
 * JD-Core Version:    0.7.0.1
 */