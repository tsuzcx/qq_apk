package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.le;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;

public class WalletIbgOrderInfoNewUI
  extends WalletOrderInfoNewUI
{
  private Orders HFH;
  
  public final void done()
  {
    AppMethodBeat.i(71445);
    Log.i("MicroMsg.WalletIbgOrderInfoNewUI", "hy: result is not set manly. set to OK");
    Iterator localIterator = this.Ihn.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!Util.isNullOrNil(str))
      {
        Log.d("MicroMsg.WalletIbgOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str });
        g.aAi();
        g.aAg().hqi.a(new com.tencent.mm.wallet_core.c.t(str), 0);
      }
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(71445);
  }
  
  public final void fSE() {}
  
  public final Orders fSS()
  {
    return this.HFH;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71444);
    this.HFH = WalletIbgOrderInfoUI.HFH;
    super.onCreate(paramBundle);
    paramBundle = new le();
    paramBundle.dQr.requestCode = 25;
    paramBundle.dQr.resultCode = -1;
    paramBundle.dQr.dQs = new Intent();
    EventCenter.instance.publish(paramBundle);
    AppMethodBeat.o(71444);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoNewUI
 * JD-Core Version:    0.7.0.1
 */