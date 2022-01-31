package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.h.a.is;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;

public class WalletIbgOrderInfoNewUI
  extends WalletOrderInfoNewUI
{
  private Orders qmc;
  
  protected final Orders bWG()
  {
    return this.qmc;
  }
  
  protected final void bWx() {}
  
  public final void done()
  {
    y.i("MicroMsg.WalletIbgOrderInfoNewUI", "hy: result is not set manly. set to OK");
    Iterator localIterator = this.qDU.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bk.bl(str))
      {
        y.d("MicroMsg.WalletIbgOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str });
        g.DQ();
        g.DO().dJT.a(new com.tencent.mm.wallet_core.c.p(str), 0);
      }
    }
    setResult(-1);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.qmc = WalletIbgOrderInfoUI.qmc;
    super.onCreate(paramBundle);
    paramBundle = new is();
    paramBundle.bQT.bQU = 25;
    paramBundle.bQT.aYY = -1;
    paramBundle.bQT.bQV = new Intent();
    a.udP.m(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoNewUI
 * JD-Core Version:    0.7.0.1
 */