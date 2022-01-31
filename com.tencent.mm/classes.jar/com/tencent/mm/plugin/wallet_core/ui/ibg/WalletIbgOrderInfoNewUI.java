package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.r;
import java.util.Iterator;
import java.util.Set;

public class WalletIbgOrderInfoNewUI
  extends WalletOrderInfoNewUI
{
  private Orders tVr;
  
  public final Orders cVH()
  {
    return this.tVr;
  }
  
  public final void cVu() {}
  
  public final void done()
  {
    AppMethodBeat.i(47845);
    ab.i("MicroMsg.WalletIbgOrderInfoNewUI", "hy: result is not set manly. set to OK");
    Iterator localIterator = this.uqP.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bo.isNullOrNil(str))
      {
        ab.d("MicroMsg.WalletIbgOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str });
        g.RM();
        g.RK().eHt.a(new r(str), 0);
      }
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(47845);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47844);
    this.tVr = WalletIbgOrderInfoUI.tVr;
    super.onCreate(paramBundle);
    paramBundle = new iz();
    paramBundle.cyt.requestCode = 25;
    paramBundle.cyt.bpE = -1;
    paramBundle.cyt.cyu = new Intent();
    a.ymk.l(paramBundle);
    AppMethodBeat.o(47844);
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