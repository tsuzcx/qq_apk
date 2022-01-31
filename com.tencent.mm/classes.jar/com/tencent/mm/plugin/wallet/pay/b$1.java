package com.tencent.mm.plugin.wallet.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(45862);
    Iterator localIterator = b.a(this.tVh).iterator();
    while (localIterator.hasNext())
    {
      WalletBaseUI localWalletBaseUI = (WalletBaseUI)((WeakReference)localIterator.next()).get();
      if ((localWalletBaseUI != null) && (!localWalletBaseUI.hasFinish()))
      {
        ab.i("MicroMsg.PayProcess", "do finish activity: %s", new Object[] { localWalletBaseUI });
        localWalletBaseUI.finish();
      }
    }
    b.a(this.tVh).clear();
    AppMethodBeat.o(45862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.1
 * JD-Core Version:    0.7.0.1
 */