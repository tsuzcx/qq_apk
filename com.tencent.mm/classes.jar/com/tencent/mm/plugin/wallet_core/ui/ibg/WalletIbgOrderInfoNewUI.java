package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.t;
import java.util.Iterator;
import java.util.Set;

public class WalletIbgOrderInfoNewUI
  extends WalletOrderInfoNewUI
{
  private Orders CZT;
  
  public final void done()
  {
    AppMethodBeat.i(71445);
    ae.i("MicroMsg.WalletIbgOrderInfoNewUI", "hy: result is not set manly. set to OK");
    Iterator localIterator = this.Dyc.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bu.isNullOrNil(str))
      {
        ae.d("MicroMsg.WalletIbgOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str });
        g.ajS();
        g.ajQ().gDv.a(new t(str), 0);
      }
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(71445);
  }
  
  public final void eKZ() {}
  
  public final Orders eLn()
  {
    return this.CZT;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71444);
    this.CZT = WalletIbgOrderInfoUI.CZT;
    super.onCreate(paramBundle);
    paramBundle = new ko();
    paramBundle.dyC.requestCode = 25;
    paramBundle.dyC.bZU = -1;
    paramBundle.dyC.dyD = new Intent();
    a.IvT.l(paramBundle);
    AppMethodBeat.o(71444);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoNewUI
 * JD-Core Version:    0.7.0.1
 */