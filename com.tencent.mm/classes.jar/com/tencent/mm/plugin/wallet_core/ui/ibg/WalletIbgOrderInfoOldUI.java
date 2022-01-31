package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.os.Bundle;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;

public class WalletIbgOrderInfoOldUI
  extends WalletOrderInfoOldUI
{
  protected final Orders bWG()
  {
    return this.qmc;
  }
  
  public final void done()
  {
    y.i("MicroMsg.WalletIbgOrderInfoOldUI", "hy: result is not set manly. set to OK");
    Iterator localIterator = this.qDU.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bk.bl(str))
      {
        y.d("MicroMsg.WalletIbgOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str });
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoOldUI
 * JD-Core Version:    0.7.0.1
 */