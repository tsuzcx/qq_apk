package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pwd.c;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletResetPwdAdapterUI
  extends WalletBaseUI
{
  protected String eaX = null;
  protected boolean qle = false;
  protected com.tencent.mm.plugin.wallet.a qlf = null;
  protected String uae = "";
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(46387);
    if (!this.qle)
    {
      ab.d("MicroMsg.WalletResetPwdAdapterUI", "back press not lock");
      finish();
      AppMethodBeat.o(46387);
      return;
    }
    ab.d("MicroMsg.WalletResetPwdAdapterUI", "back press but lock");
    AppMethodBeat.o(46387);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46384);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    this.uae = getIntent().getStringExtra("reset_pwd_token");
    ab.i("MicroMsg.WalletResetPwdAdapterUI", "token_by_resetPwd %s", new Object[] { this.uae });
    addSceneEndListener(580);
    if (getIntent() == null)
    {
      ab.d("MicroMsg.WalletResetPwdAdapterUI", "func[doCheckPayNetscene] intent null");
      setResult(0);
      finish();
      AppMethodBeat.o(46384);
      return;
    }
    paramBundle = new d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 13, "setWCPayPassword", getIntent().getIntExtra("pay_channel", 0));
    paramBundle.setProcessName("RemittanceProcess");
    doSceneForceProgress(paramBundle);
    AppMethodBeat.o(46384);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(46386);
    removeSceneEndListener(580);
    super.onDestroy();
    AppMethodBeat.o(46386);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(46385);
    ab.v("MicroMsg.WalletResetPwdAdapterUI", "onNewIntent");
    int i = paramIntent.getIntExtra("RESET_PWD_USER_ACTION", 0);
    if (i == 1)
    {
      setResult(-1);
      finish();
      AppMethodBeat.o(46385);
      return;
    }
    if (i == 2)
    {
      setResult(-1000);
      finish();
      AppMethodBeat.o(46385);
      return;
    }
    setResult(0);
    finish();
    AppMethodBeat.o(46385);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46388);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof d))
      {
        g.ana(((d)paramm).cSW());
        paramString = new Bundle();
        paramString.putString("kreq_token", this.uae);
        com.tencent.mm.wallet_core.a.a(this, c.class, paramString, null);
        AppMethodBeat.o(46388);
        return true;
      }
    }
    else
    {
      setResult(-1000);
      h.bO(this, paramString);
      finish();
      AppMethodBeat.o(46388);
      return true;
    }
    AppMethodBeat.o(46388);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI
 * JD-Core Version:    0.7.0.1
 */