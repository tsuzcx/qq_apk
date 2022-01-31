package com.tencent.mm.plugin.wallet.loan;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletLoanCheckPwdUI
  extends WalletCheckPwdUI
{
  public int getForceOrientation()
  {
    return 1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45837);
    super.onCreate(paramBundle);
    if (getProcess() != null) {
      setBackBtn(new WalletLoanCheckPwdUI.1(this));
    }
    AppMethodBeat.o(45837);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45838);
    if (((paramm instanceof v)) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      AppMethodBeat.o(45838);
      return false;
    }
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    AppMethodBeat.o(45838);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.loan.WalletLoanCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */