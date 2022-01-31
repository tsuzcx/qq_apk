package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.r;
import java.util.Iterator;
import java.util.Set;

public class WalletIbgOrderInfoOldUI
  extends WalletOrderInfoOldUI
{
  public final Orders cVH()
  {
    return this.tVr;
  }
  
  public final void done()
  {
    AppMethodBeat.i(47847);
    ab.i("MicroMsg.WalletIbgOrderInfoOldUI", "hy: result is not set manly. set to OK");
    Iterator localIterator = this.uqP.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bo.isNullOrNil(str))
      {
        ab.d("MicroMsg.WalletIbgOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str });
        g.RM();
        g.RK().eHt.a(new r(str), 0);
      }
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(47847);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47846);
    this.tVr = WalletIbgOrderInfoUI.tVr;
    super.onCreate(paramBundle);
    AppMethodBeat.o(47846);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoOldUI
 * JD-Core Version:    0.7.0.1
 */