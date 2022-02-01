package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.d.g;

@com.tencent.mm.ui.base.a(3)
public class WalletOpenECardProxyUI
  extends WalletECardBaseUI
{
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71793);
    ad.i("MicroMsg.WalletOpenECardProxyUI", "activity result, request:%s, result: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        setResult(0);
        paramIntent = getProcess();
        if (paramIntent != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_process_result_code", 0);
          paramIntent.b(this, 0, localBundle);
          AppMethodBeat.o(71793);
          return;
        }
        finish();
        AppMethodBeat.o(71793);
        return;
      }
      finish();
      AppMethodBeat.o(71793);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(71793);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71792);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    paramBundle = getProcess();
    if (paramBundle != null)
    {
      int i = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.AvM, 0);
      boolean bool = getInput().getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.Awe, false);
      ad.i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, isReuseExistCard: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (bool)
      {
        getNetController().q(new Object[] { Integer.valueOf(2), Integer.valueOf(i), Boolean.TRUE });
        AppMethodBeat.o(71792);
        return;
      }
      String str = getInput().getString(com.tencent.mm.plugin.wallet_ecard.a.a.AvN);
      bool = getInput().getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.AvP, false);
      ad.i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, token==null:%s, isTokenInvalid: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bt.isNullOrNil(str)), Boolean.valueOf(bool) });
      if (!bt.isNullOrNil(str))
      {
        getNetController().q(new Object[] { Integer.valueOf(1), Integer.valueOf(i), str });
        AppMethodBeat.o(71792);
        return;
      }
      paramBundle.a(getContext(), 0, getInput());
      AppMethodBeat.o(71792);
      return;
    }
    ad.w("MicroMsg.WalletOpenECardProxyUI", "no process!!!");
    finish();
    AppMethodBeat.o(71792);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(71794);
    int i = paramIntent.getIntExtra("key_process_result_code", -1);
    boolean bool = paramIntent.getBooleanExtra("key_process_is_end", false);
    ad.i("MicroMsg.WalletOpenECardProxyUI", "new intent, resultCode: %d, isEnd: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if (i == -1)
    {
      if (paramIntent.getBooleanExtra("key_goto_lqt_detail", false))
      {
        ad.i("MicroMsg.WalletOpenECardProxyUI", "jump to detail");
        paramIntent = new Intent();
        paramIntent.putExtra("key_account_type", 2);
        com.tencent.mm.bs.d.b(this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramIntent);
      }
      setResult(-1);
    }
    for (;;)
    {
      paramIntent = getProcess();
      if (!bool) {
        break;
      }
      finish();
      AppMethodBeat.o(71794);
      return;
      setResult(0);
    }
    if (paramIntent != null) {
      paramIntent.bq(getContext());
    }
    AppMethodBeat.o(71794);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI
 * JD-Core Version:    0.7.0.1
 */