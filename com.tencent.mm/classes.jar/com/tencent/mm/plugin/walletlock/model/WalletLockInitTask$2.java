package com.tencent.mm.plugin.walletlock.model;

import android.os.SystemClock;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ada;
import com.tencent.mm.autogen.a.ada.a;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.plugin.walletlock.gesture.a.g;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

class WalletLockInitTask$2
  extends IListener<ada>
{
  WalletLockInitTask$2(e parame, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(266831);
    this.__eventId = ada.class.getName().hashCode();
    AppMethodBeat.o(266831);
  }
  
  private static boolean callback(ada paramada)
  {
    AppMethodBeat.i(129912);
    Log.v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", new Object[] { Integer.valueOf(paramada.igZ.ihb), Boolean.valueOf(h.WhQ.inu()), Boolean.valueOf(h.WhQ.inv()) });
    switch (paramada.igZ.ihb)
    {
    }
    for (;;)
    {
      paramada.igZ.activity = null;
      AppMethodBeat.o(129912);
      return false;
      long l1;
      long l2;
      if (!(paramada.igZ.activity instanceof GestureGuardLogicUI))
      {
        if (!h.WhQ.inu())
        {
          l1 = f.imI();
          l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
          if ((l1 == -1L) || (l2 >= b.Wgm) || ((d.imR()) && (d.imQ())))
          {
            Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
            paramada.iha.cpt = Integer.valueOf(17);
          }
          else
          {
            Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
            paramada.iha.cpt = Integer.valueOf(16);
            h.WhQ.n(new WeakReference(paramada.igZ.activity));
          }
        }
        else
        {
          Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
          paramada.iha.cpt = Integer.valueOf(16);
          h.WhQ.n(new WeakReference(paramada.igZ.activity));
          h.WhQ.Ih(false);
        }
      }
      else
      {
        Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
        paramada.iha.cpt = Integer.valueOf(16);
        continue;
        if (!(paramada.igZ.activity instanceof GestureGuardLogicUI))
        {
          if (h.WhQ.inu())
          {
            Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
            h.WhQ.Ih(false);
            h.WhQ.Ii(false);
            paramada.iha.cpt = Integer.valueOf(16);
          }
          else if (h.WhQ.inv())
          {
            Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
            h.WhQ.Ih(false);
            h.WhQ.Ii(false);
            paramada.iha.cpt = Integer.valueOf(18);
          }
          else
          {
            l1 = f.imI();
            l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
            if (((l1 == -1L) || (l2 >= b.Wgm) || (d.imR())) && (d.imQ())) {
              Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
            }
            for (paramada.iha.cpt = Integer.valueOf(17);; paramada.iha.cpt = Integer.valueOf(16))
            {
              h.WhQ.n(new WeakReference(paramada.igZ.activity));
              break;
              Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
            }
          }
        }
        else
        {
          Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
          paramada.iha.cpt = Integer.valueOf(16);
          continue;
          h.WhQ.inw();
          continue;
          paramada.iha.cpt = Boolean.valueOf(g.imQ());
          continue;
          paramada.iha.cpt = Boolean.valueOf(d.imR());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.model.WalletLockInitTask.2
 * JD-Core Version:    0.7.0.1
 */