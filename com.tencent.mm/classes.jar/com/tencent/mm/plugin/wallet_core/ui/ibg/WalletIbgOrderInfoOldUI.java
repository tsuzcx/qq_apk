package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;

public class WalletIbgOrderInfoOldUI
  extends WalletOrderInfoOldUI
{
  public final void done()
  {
    AppMethodBeat.i(71447);
    Log.i("MicroMsg.WalletIbgOrderInfoOldUI", "hy: result is not set manly. set to OK");
    Iterator localIterator = this.Ihn.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!Util.isNullOrNil(str))
      {
        Log.d("MicroMsg.WalletIbgOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str });
        g.aAi();
        g.aAg().hqi.a(new com.tencent.mm.wallet_core.c.t(str), 0);
      }
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(71447);
  }
  
  public final Orders fSS()
  {
    return this.HFH;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71446);
    this.HFH = WalletIbgOrderInfoUI.HFH;
    super.onCreate(paramBundle);
    AppMethodBeat.o(71446);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoOldUI
 * JD-Core Version:    0.7.0.1
 */