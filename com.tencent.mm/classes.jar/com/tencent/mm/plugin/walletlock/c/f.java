package com.tencent.mm.plugin.walletlock.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xh.a;
import com.tencent.mm.g.a.yl;
import com.tencent.mm.g.a.yl.a;
import com.tencent.mm.plugin.walletlock.gesture.a.a;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

public final class f
{
  public com.tencent.mm.sdk.b.c DvV;
  public com.tencent.mm.sdk.b.c DvW;
  private com.tencent.mm.sdk.b.c DvX;
  public com.tencent.mm.sdk.b.c DvY;
  
  public f()
  {
    AppMethodBeat.i(129916);
    this.DvV = new c();
    this.DvW = new com.tencent.mm.sdk.b.c() {};
    this.DvX = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(yl paramAnonymousyl)
      {
        AppMethodBeat.i(129912);
        ad.v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", new Object[] { Integer.valueOf(paramAnonymousyl.dNn.dNp), Boolean.valueOf(i.Dwe.eKi()), Boolean.valueOf(i.Dwe.eKj()) });
        switch (paramAnonymousyl.dNn.dNp)
        {
        }
        for (;;)
        {
          paramAnonymousyl.dNn.activity = null;
          AppMethodBeat.o(129912);
          return false;
          long l1;
          long l2;
          if (!(paramAnonymousyl.dNn.activity instanceof GestureGuardLogicUI))
          {
            if (!i.Dwe.eKi())
            {
              l1 = d.eJw();
              l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
              if ((l1 == -1L) || (l2 >= a.DuC) || ((com.tencent.mm.plugin.walletlock.gesture.a.b.eJF()) && (com.tencent.mm.plugin.walletlock.gesture.a.b.eJE())))
              {
                ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                paramAnonymousyl.dNo.data = Integer.valueOf(17);
              }
              else
              {
                ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                paramAnonymousyl.dNo.data = Integer.valueOf(16);
                i.Dwe.e(new WeakReference(paramAnonymousyl.dNn.activity));
              }
            }
            else
            {
              ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
              paramAnonymousyl.dNo.data = Integer.valueOf(16);
              i.Dwe.e(new WeakReference(paramAnonymousyl.dNn.activity));
              i.Dwe.uK(false);
            }
          }
          else
          {
            ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
            paramAnonymousyl.dNo.data = Integer.valueOf(16);
            continue;
            if (!(paramAnonymousyl.dNn.activity instanceof GestureGuardLogicUI))
            {
              if (i.Dwe.eKi())
              {
                ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                i.Dwe.uK(false);
                i.Dwe.uL(false);
                paramAnonymousyl.dNo.data = Integer.valueOf(16);
              }
              else if (i.Dwe.eKj())
              {
                ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                i.Dwe.uK(false);
                i.Dwe.uL(false);
                paramAnonymousyl.dNo.data = Integer.valueOf(18);
              }
              else
              {
                l1 = d.eJw();
                l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
                if (((l1 == -1L) || (l2 >= a.DuC) || (com.tencent.mm.plugin.walletlock.gesture.a.b.eJF())) && (com.tencent.mm.plugin.walletlock.gesture.a.b.eJE())) {
                  ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                }
                for (paramAnonymousyl.dNo.data = Integer.valueOf(17);; paramAnonymousyl.dNo.data = Integer.valueOf(16))
                {
                  i.Dwe.e(new WeakReference(paramAnonymousyl.dNn.activity));
                  break;
                  ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                }
              }
            }
            else
            {
              ad.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
              paramAnonymousyl.dNo.data = Integer.valueOf(16);
              continue;
              i.Dwe.eKk();
              continue;
              paramAnonymousyl.dNo.data = Boolean.valueOf(e.eJE());
              continue;
              paramAnonymousyl.dNo.data = Boolean.valueOf(com.tencent.mm.plugin.walletlock.gesture.a.b.eJF());
            }
          }
        }
      }
    };
    this.DvY = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(xh paramAnonymousxh)
      {
        AppMethodBeat.i(129914);
        paramAnonymousxh = paramAnonymousxh.dLE.dLF;
        g localg = g.Dwa;
        g.eJv();
        boolean bool = e.b(paramAnonymousxh);
        if (bool)
        {
          ad.i("MicroMsg.WalletLockInitTask", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", new Object[] { Integer.valueOf(paramAnonymousxh.Hcl.getILen()), Boolean.valueOf(bool), Integer.valueOf(paramAnonymousxh.Hcm), Integer.valueOf(paramAnonymousxh.Hck) });
          d.a(paramAnonymousxh);
        }
        for (;;)
        {
          bool = e.eJE();
          ad.i("MicroMsg.WalletLockInitTask", "alvinluo after update gesture server info, isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.walletlock.gesture.a.b.uG(bool);
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).init();
          AppMethodBeat.o(129914);
          return false;
          ad.w("MicroMsg.WalletLockInitTask", "UserInfoExt.PatternLockInfo is null or invalid.");
        }
      }
    };
    AppMethodBeat.o(129916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.f
 * JD-Core Version:    0.7.0.1
 */