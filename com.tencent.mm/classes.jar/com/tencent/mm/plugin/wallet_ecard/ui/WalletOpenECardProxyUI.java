package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c;
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
    AppMethodBeat.i(48158);
    ab.i("MicroMsg.WalletOpenECardProxyUI", "activity result, request:%s, result: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
          paramIntent.l(this, localBundle);
          AppMethodBeat.o(48158);
          return;
        }
        finish();
        AppMethodBeat.o(48158);
        return;
      }
      finish();
      AppMethodBeat.o(48158);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(48158);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48157);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    paramBundle = getProcess();
    if (paramBundle != null)
    {
      int i = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.uyJ, 0);
      boolean bool = getInput().getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.uzb, false);
      ab.i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, isReuseExistCard: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (bool)
      {
        getNetController().p(new Object[] { Integer.valueOf(2), Integer.valueOf(i), Boolean.TRUE });
        AppMethodBeat.o(48157);
        return;
      }
      String str = getInput().getString(com.tencent.mm.plugin.wallet_ecard.a.a.uyK);
      bool = getInput().getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.uyM, false);
      ab.i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, token==null:%s, isTokenInvalid: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bo.isNullOrNil(str)), Boolean.valueOf(bool) });
      if (!bo.isNullOrNil(str))
      {
        getNetController().p(new Object[] { Integer.valueOf(1), Integer.valueOf(i), str });
        AppMethodBeat.o(48157);
        return;
      }
      paramBundle.a(getContext(), 0, getInput());
      AppMethodBeat.o(48157);
      return;
    }
    ab.w("MicroMsg.WalletOpenECardProxyUI", "no process!!!");
    finish();
    AppMethodBeat.o(48157);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48159);
    int i = paramIntent.getIntExtra("key_process_result_code", -1);
    boolean bool = paramIntent.getBooleanExtra("key_process_is_end", false);
    ab.i("MicroMsg.WalletOpenECardProxyUI", "new intent, resultCode: %d, isEnd: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
    if (i == -1)
    {
      if (paramIntent.getBooleanExtra("key_goto_lqt_detail", false))
      {
        ab.i("MicroMsg.WalletOpenECardProxyUI", "jump to detail");
        paramIntent = new Intent();
        paramIntent.putExtra("key_account_type", 2);
        d.b(this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramIntent);
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
      AppMethodBeat.o(48159);
      return;
      setResult(0);
    }
    if (paramIntent != null) {
      paramIntent.aO(getContext());
    }
    AppMethodBeat.o(48159);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI
 * JD-Core Version:    0.7.0.1
 */