package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.t;
import java.util.Iterator;
import java.util.Set;

public class WalletIbgOrderInfoNewUI
  extends WalletOrderInfoNewUI
{
  private Orders BhZ;
  
  public final void done()
  {
    AppMethodBeat.i(71445);
    ac.i("MicroMsg.WalletIbgOrderInfoNewUI", "hy: result is not set manly. set to OK");
    Iterator localIterator = this.BGg.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bs.isNullOrNil(str))
      {
        ac.d("MicroMsg.WalletIbgOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str });
        g.agS();
        g.agQ().ghe.a(new t(str), 0);
      }
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(71445);
  }
  
  public final void etl() {}
  
  public final Orders etz()
  {
    return this.BhZ;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71444);
    this.BhZ = WalletIbgOrderInfoUI.BhZ;
    super.onCreate(paramBundle);
    paramBundle = new kf();
    paramBundle.dlK.requestCode = 25;
    paramBundle.dlK.bPH = -1;
    paramBundle.dlK.dlL = new Intent();
    a.GpY.l(paramBundle);
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