package com.tencent.mm.plugin.walletlock.c;

import android.os.SystemClock;
import com.tencent.mm.h.a.tl;
import com.tencent.mm.h.a.tl.a;
import com.tencent.mm.plugin.walletlock.gesture.a.a;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class f$2
  extends c<tl>
{
  f$2(f paramf)
  {
    this.udX = tl.class.getName().hashCode();
  }
  
  private static boolean a(tl paramtl)
  {
    y.v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", new Object[] { Integer.valueOf(paramtl.cdG.cdI), Boolean.valueOf(i.qRd.bYE()), Boolean.valueOf(i.qRd.bYF()) });
    switch (paramtl.cdG.cdI)
    {
    }
    for (;;)
    {
      paramtl.cdG.activity = null;
      return false;
      long l1;
      long l2;
      if (!(paramtl.cdG.activity instanceof GestureGuardLogicUI))
      {
        if (!i.qRd.bYE())
        {
          l1 = d.bXU();
          l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
          if ((l1 == -1L) || (l2 >= a.qPz) || ((b.bYd()) && (b.bYc())))
          {
            y.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
            paramtl.cdH.data = Integer.valueOf(17);
          }
          else
          {
            y.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
            paramtl.cdH.data = Integer.valueOf(16);
            i.qRd.b(new WeakReference(paramtl.cdG.activity));
          }
        }
        else
        {
          y.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
          paramtl.cdH.data = Integer.valueOf(16);
          i.qRd.b(new WeakReference(paramtl.cdG.activity));
          i.qRd.kV(false);
        }
      }
      else
      {
        y.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
        paramtl.cdH.data = Integer.valueOf(16);
        continue;
        if (!(paramtl.cdG.activity instanceof GestureGuardLogicUI))
        {
          if (i.qRd.bYE())
          {
            y.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
            i.qRd.kV(false);
            i.qRd.kW(false);
            paramtl.cdH.data = Integer.valueOf(16);
          }
          else if (i.qRd.bYF())
          {
            y.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
            i.qRd.kV(false);
            i.qRd.kW(false);
            paramtl.cdH.data = Integer.valueOf(18);
          }
          else
          {
            l1 = d.bXU();
            l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
            if (((l1 == -1L) || (l2 >= a.qPz) || (b.bYd())) && (b.bYc())) {
              y.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
            }
            for (paramtl.cdH.data = Integer.valueOf(17);; paramtl.cdH.data = Integer.valueOf(16))
            {
              i.qRd.b(new WeakReference(paramtl.cdG.activity));
              break;
              y.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
            }
          }
        }
        else
        {
          y.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
          paramtl.cdH.data = Integer.valueOf(16);
          continue;
          i.qRd.bYG();
          continue;
          paramtl.cdH.data = Boolean.valueOf(e.bYc());
          continue;
          paramtl.cdH.data = Boolean.valueOf(b.bYd());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.f.2
 * JD-Core Version:    0.7.0.1
 */