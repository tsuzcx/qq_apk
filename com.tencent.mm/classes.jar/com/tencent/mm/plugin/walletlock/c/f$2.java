package com.tencent.mm.plugin.walletlock.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.g.a.xr.a;
import com.tencent.mm.plugin.walletlock.gesture.a.a;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

final class f$2
  extends c<xr>
{
  f$2(f paramf)
  {
    AppMethodBeat.i(161152);
    this.__eventId = xr.class.getName().hashCode();
    AppMethodBeat.o(161152);
  }
  
  private static boolean a(xr paramxr)
  {
    AppMethodBeat.i(129912);
    ac.v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", new Object[] { Integer.valueOf(paramxr.dBa.dBc), Boolean.valueOf(i.BVK.ewc()), Boolean.valueOf(i.BVK.ewd()) });
    switch (paramxr.dBa.dBc)
    {
    }
    for (;;)
    {
      paramxr.dBa.activity = null;
      AppMethodBeat.o(129912);
      return false;
      long l1;
      long l2;
      if (!(paramxr.dBa.activity instanceof GestureGuardLogicUI))
      {
        if (!i.BVK.ewc())
        {
          l1 = d.evq();
          l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
          if ((l1 == -1L) || (l2 >= a.BUi) || ((b.evz()) && (b.evy())))
          {
            ac.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
            paramxr.dBb.data = Integer.valueOf(17);
          }
          else
          {
            ac.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
            paramxr.dBb.data = Integer.valueOf(16);
            i.BVK.d(new WeakReference(paramxr.dBa.activity));
          }
        }
        else
        {
          ac.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
          paramxr.dBb.data = Integer.valueOf(16);
          i.BVK.d(new WeakReference(paramxr.dBa.activity));
          i.BVK.ua(false);
        }
      }
      else
      {
        ac.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
        paramxr.dBb.data = Integer.valueOf(16);
        continue;
        if (!(paramxr.dBa.activity instanceof GestureGuardLogicUI))
        {
          if (i.BVK.ewc())
          {
            ac.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
            i.BVK.ua(false);
            i.BVK.ub(false);
            paramxr.dBb.data = Integer.valueOf(16);
          }
          else if (i.BVK.ewd())
          {
            ac.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
            i.BVK.ua(false);
            i.BVK.ub(false);
            paramxr.dBb.data = Integer.valueOf(18);
          }
          else
          {
            l1 = d.evq();
            l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
            if (((l1 == -1L) || (l2 >= a.BUi) || (b.evz())) && (b.evy())) {
              ac.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
            }
            for (paramxr.dBb.data = Integer.valueOf(17);; paramxr.dBb.data = Integer.valueOf(16))
            {
              i.BVK.d(new WeakReference(paramxr.dBa.activity));
              break;
              ac.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
            }
          }
        }
        else
        {
          ac.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
          paramxr.dBb.data = Integer.valueOf(16);
          continue;
          i.BVK.ewe();
          continue;
          paramxr.dBb.data = Boolean.valueOf(e.evy());
          continue;
          paramxr.dBb.data = Boolean.valueOf(b.evz());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.f.2
 * JD-Core Version:    0.7.0.1
 */