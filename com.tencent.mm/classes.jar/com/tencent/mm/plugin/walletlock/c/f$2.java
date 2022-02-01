package com.tencent.mm.plugin.walletlock.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.a.xg.a;
import com.tencent.mm.plugin.walletlock.gesture.a.a;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class f$2
  extends c<xg>
{
  f$2(f paramf)
  {
    AppMethodBeat.i(161152);
    this.__eventId = xg.class.getName().hashCode();
    AppMethodBeat.o(161152);
  }
  
  private static boolean a(xg paramxg)
  {
    AppMethodBeat.i(129912);
    ad.v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", new Object[] { Integer.valueOf(paramxg.dDo.dDq), Boolean.valueOf(i.ADp.egI()), Boolean.valueOf(i.ADp.egJ()) });
    switch (paramxg.dDo.dDq)
    {
    }
    for (;;)
    {
      paramxg.dDo.activity = null;
      AppMethodBeat.o(129912);
      return false;
      long l1;
      long l2;
      if (!(paramxg.dDo.activity instanceof GestureGuardLogicUI))
      {
        if (!i.ADp.egI())
        {
          l1 = d.efW();
          l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
          if ((l1 == -1L) || (l2 >= a.ABN) || ((b.egf()) && (b.ege())))
          {
            ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
            paramxg.dDp.data = Integer.valueOf(17);
          }
          else
          {
            ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
            paramxg.dDp.data = Integer.valueOf(16);
            i.ADp.d(new WeakReference(paramxg.dDo.activity));
          }
        }
        else
        {
          ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
          paramxg.dDp.data = Integer.valueOf(16);
          i.ADp.d(new WeakReference(paramxg.dDo.activity));
          i.ADp.sZ(false);
        }
      }
      else
      {
        ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
        paramxg.dDp.data = Integer.valueOf(16);
        continue;
        if (!(paramxg.dDo.activity instanceof GestureGuardLogicUI))
        {
          if (i.ADp.egI())
          {
            ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
            i.ADp.sZ(false);
            i.ADp.ta(false);
            paramxg.dDp.data = Integer.valueOf(16);
          }
          else if (i.ADp.egJ())
          {
            ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
            i.ADp.sZ(false);
            i.ADp.ta(false);
            paramxg.dDp.data = Integer.valueOf(18);
          }
          else
          {
            l1 = d.efW();
            l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
            if (((l1 == -1L) || (l2 >= a.ABN) || (b.egf())) && (b.ege())) {
              ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
            }
            for (paramxg.dDp.data = Integer.valueOf(17);; paramxg.dDp.data = Integer.valueOf(16))
            {
              i.ADp.d(new WeakReference(paramxg.dDo.activity));
              break;
              ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
            }
          }
        }
        else
        {
          ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
          paramxg.dDp.data = Integer.valueOf(16);
          continue;
          i.ADp.egK();
          continue;
          paramxg.dDp.data = Boolean.valueOf(e.ege());
          continue;
          paramxg.dDp.data = Boolean.valueOf(b.egf());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.f.2
 * JD-Core Version:    0.7.0.1
 */