package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.t;
import java.util.Iterator;
import java.util.Set;

public class WalletIbgOrderInfoOldUI
  extends WalletOrderInfoOldUI
{
  public final void done()
  {
    AppMethodBeat.i(71447);
    ae.i("MicroMsg.WalletIbgOrderInfoOldUI", "hy: result is not set manly. set to OK");
    Iterator localIterator = this.Dyc.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bu.isNullOrNil(str))
      {
        ae.d("MicroMsg.WalletIbgOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str });
        g.ajS();
        g.ajQ().gDv.a(new t(str), 0);
      }
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(71447);
  }
  
  public final Orders eLn()
  {
    return this.CZT;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71446);
    this.CZT = WalletIbgOrderInfoUI.CZT;
    super.onCreate(paramBundle);
    AppMethodBeat.o(71446);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoOldUI
 * JD-Core Version:    0.7.0.1
 */