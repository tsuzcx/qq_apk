package com.tencent.mm.plugin.walletlock.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.abd;
import com.tencent.mm.f.a.abd.a;
import com.tencent.mm.plugin.walletlock.gesture.a.a;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class f$2
  extends IListener<abd>
{
  f$2(f paramf)
  {
    AppMethodBeat.i(161152);
    this.__eventId = abd.class.getName().hashCode();
    AppMethodBeat.o(161152);
  }
  
  private static boolean a(abd paramabd)
  {
    AppMethodBeat.i(129912);
    Log.v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", new Object[] { Integer.valueOf(paramabd.gaP.gaR), Boolean.valueOf(i.Prd.gOf()), Boolean.valueOf(i.Prd.gOg()) });
    switch (paramabd.gaP.gaR)
    {
    }
    for (;;)
    {
      paramabd.gaP.activity = null;
      AppMethodBeat.o(129912);
      return false;
      long l1;
      long l2;
      if (!(paramabd.gaP.activity instanceof GestureGuardLogicUI))
      {
        if (!i.Prd.gOf())
        {
          l1 = d.gNt();
          l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
          if ((l1 == -1L) || (l2 >= a.PpB) || ((b.gNC()) && (b.gNB())))
          {
            Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
            paramabd.gaQ.bnW = Integer.valueOf(17);
          }
          else
          {
            Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
            paramabd.gaQ.bnW = Integer.valueOf(16);
            i.Prd.i(new WeakReference(paramabd.gaP.activity));
          }
        }
        else
        {
          Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
          paramabd.gaQ.bnW = Integer.valueOf(16);
          i.Prd.i(new WeakReference(paramabd.gaP.activity));
          i.Prd.CC(false);
        }
      }
      else
      {
        Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
        paramabd.gaQ.bnW = Integer.valueOf(16);
        continue;
        if (!(paramabd.gaP.activity instanceof GestureGuardLogicUI))
        {
          if (i.Prd.gOf())
          {
            Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
            i.Prd.CC(false);
            i.Prd.CD(false);
            paramabd.gaQ.bnW = Integer.valueOf(16);
          }
          else if (i.Prd.gOg())
          {
            Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
            i.Prd.CC(false);
            i.Prd.CD(false);
            paramabd.gaQ.bnW = Integer.valueOf(18);
          }
          else
          {
            l1 = d.gNt();
            l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
            if (((l1 == -1L) || (l2 >= a.PpB) || (b.gNC())) && (b.gNB())) {
              Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
            }
            for (paramabd.gaQ.bnW = Integer.valueOf(17);; paramabd.gaQ.bnW = Integer.valueOf(16))
            {
              i.Prd.i(new WeakReference(paramabd.gaP.activity));
              break;
              Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
            }
          }
        }
        else
        {
          Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
          paramabd.gaQ.bnW = Integer.valueOf(16);
          continue;
          i.Prd.gOh();
          continue;
          paramabd.gaQ.bnW = Boolean.valueOf(e.gNB());
          continue;
          paramabd.gaQ.bnW = Boolean.valueOf(b.gNC());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.f.2
 * JD-Core Version:    0.7.0.1
 */