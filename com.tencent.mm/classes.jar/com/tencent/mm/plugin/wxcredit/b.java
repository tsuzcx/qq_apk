package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b
  extends c
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48604);
    ab.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditChangeAmountProcess");
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    AppMethodBeat.o(48604);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(48608);
    if ((paramMMActivity instanceof WalletWXCreditChangeAmountUI))
    {
      paramMMActivity = new b.1(this, paramMMActivity, parami);
      AppMethodBeat.o(48608);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new b.2(this, paramMMActivity, parami);
      AppMethodBeat.o(48608);
      return paramMMActivity;
    }
    AppMethodBeat.o(48608);
    return null;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(48605);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      b(paramActivity, WalletWXCreditChangeAmountUI.class, paramBundle);
      AppMethodBeat.o(48605);
      return;
    }
    if ((paramActivity instanceof WalletWXCreditChangeAmountUI))
    {
      b(paramActivity, WalletWXCreditChangeAmountResultUI.class, paramBundle);
      AppMethodBeat.o(48605);
      return;
    }
    if ((paramActivity instanceof WalletWXCreditChangeAmountResultUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(48605);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48607);
    d(paramActivity, "wallet", ".bind.ui.WalletBankcardManageUI");
    AppMethodBeat.o(48607);
  }
  
  public final String bzC()
  {
    return "WXCreditChangeAmountProcess";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(48606);
    B(paramActivity);
    AppMethodBeat.o(48606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.b
 * JD-Core Version:    0.7.0.1
 */