package com.tencent.mm.plugin.wallet.loan;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;

@com.tencent.mm.ui.base.a(3)
public class WalletLoanCheckPwdUI
  extends WalletCheckPwdUI
{
  public int getForceOrientation()
  {
    return 1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69181);
    super.onCreate(paramBundle);
    if (getProcess() != null) {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69180);
          com.tencent.mm.wallet_core.a.t(WalletLoanCheckPwdUI.this, 0);
          AppMethodBeat.o(69180);
          return true;
        }
      });
    }
    AppMethodBeat.o(69181);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69182);
    if (((paramn instanceof x)) && ((paramInt1 != 0) || (paramInt2 != 0)))
    {
      AppMethodBeat.o(69182);
      return false;
    }
    boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    AppMethodBeat.o(69182);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.loan.WalletLoanCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */