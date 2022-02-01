package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.t;
import java.util.Iterator;
import java.util.Set;

public class WalletIbgOrderInfoNewUI
  extends WalletOrderInfoNewUI
{
  private Orders CIn;
  
  public final void done()
  {
    AppMethodBeat.i(71445);
    ad.i("MicroMsg.WalletIbgOrderInfoNewUI", "hy: result is not set manly. set to OK");
    Iterator localIterator = this.Dgy.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bt.isNullOrNil(str))
      {
        ad.d("MicroMsg.WalletIbgOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str });
        g.ajD();
        g.ajB().gAO.a(new t(str), 0);
      }
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(71445);
  }
  
  public final Orders eHF()
  {
    return this.CIn;
  }
  
  public final void eHr() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71444);
    this.CIn = WalletIbgOrderInfoUI.CIn;
    super.onCreate(paramBundle);
    paramBundle = new kn();
    paramBundle.dxx.requestCode = 25;
    paramBundle.dxx.bZU = -1;
    paramBundle.dxx.dxy = new Intent();
    a.IbL.l(paramBundle);
    AppMethodBeat.o(71444);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoNewUI
 * JD-Core Version:    0.7.0.1
 */