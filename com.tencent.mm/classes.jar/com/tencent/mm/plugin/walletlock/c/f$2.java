package com.tencent.mm.plugin.walletlock.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.g.a.vg.a;
import com.tencent.mm.plugin.walletlock.gesture.a.a;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class f$2
  extends c<vg>
{
  f$2(f paramf)
  {
    AppMethodBeat.i(51708);
    this.__eventId = vg.class.getName().hashCode();
    AppMethodBeat.o(51708);
  }
  
  private static boolean a(vg paramvg)
  {
    AppMethodBeat.i(51709);
    ab.v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", new Object[] { Integer.valueOf(paramvg.cMq.cMs), Boolean.valueOf(i.uGl.cYo()), Boolean.valueOf(i.uGl.cYp()) });
    switch (paramvg.cMq.cMs)
    {
    }
    for (;;)
    {
      paramvg.cMq.activity = null;
      AppMethodBeat.o(51709);
      return false;
      long l1;
      long l2;
      if (!(paramvg.cMq.activity instanceof GestureGuardLogicUI))
      {
        if (!i.uGl.cYo())
        {
          l1 = d.cXC();
          l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
          if ((l1 == -1L) || (l2 >= a.uEH) || ((b.cXL()) && (b.cXK())))
          {
            ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
            paramvg.cMr.data = Integer.valueOf(17);
          }
          else
          {
            ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
            paramvg.cMr.data = Integer.valueOf(16);
            i.uGl.c(new WeakReference(paramvg.cMq.activity));
          }
        }
        else
        {
          ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
          paramvg.cMr.data = Integer.valueOf(16);
          i.uGl.c(new WeakReference(paramvg.cMq.activity));
          i.uGl.oe(false);
        }
      }
      else
      {
        ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
        paramvg.cMr.data = Integer.valueOf(16);
        continue;
        if (!(paramvg.cMq.activity instanceof GestureGuardLogicUI))
        {
          if (i.uGl.cYo())
          {
            ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
            i.uGl.oe(false);
            i.uGl.of(false);
            paramvg.cMr.data = Integer.valueOf(16);
          }
          else if (i.uGl.cYp())
          {
            ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
            i.uGl.oe(false);
            i.uGl.of(false);
            paramvg.cMr.data = Integer.valueOf(18);
          }
          else
          {
            l1 = d.cXC();
            l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
            if (((l1 == -1L) || (l2 >= a.uEH) || (b.cXL())) && (b.cXK())) {
              ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
            }
            for (paramvg.cMr.data = Integer.valueOf(17);; paramvg.cMr.data = Integer.valueOf(16))
            {
              i.uGl.c(new WeakReference(paramvg.cMq.activity));
              break;
              ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
            }
          }
        }
        else
        {
          ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
          paramvg.cMr.data = Integer.valueOf(16);
          continue;
          i.uGl.cYq();
          continue;
          paramvg.cMr.data = Boolean.valueOf(e.cXK());
          continue;
          paramvg.cMr.data = Boolean.valueOf(b.cXL());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.f.2
 * JD-Core Version:    0.7.0.1
 */