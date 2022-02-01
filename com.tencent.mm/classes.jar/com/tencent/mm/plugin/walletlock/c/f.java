package com.tencent.mm.plugin.walletlock.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xl;
import com.tencent.mm.g.a.xl.a;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.g.a.yr.a;
import com.tencent.mm.plugin.walletlock.gesture.a.a;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

public final class f
{
  public com.tencent.mm.sdk.b.c DNA;
  public com.tencent.mm.sdk.b.c DNB;
  private com.tencent.mm.sdk.b.c DNC;
  public com.tencent.mm.sdk.b.c DND;
  
  public f()
  {
    AppMethodBeat.i(129916);
    this.DNA = new c();
    this.DNB = new com.tencent.mm.sdk.b.c() {};
    this.DNC = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(yr paramAnonymousyr)
      {
        AppMethodBeat.i(129912);
        ae.v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", new Object[] { Integer.valueOf(paramAnonymousyr.dOD.dOF), Boolean.valueOf(i.DNJ.eNQ()), Boolean.valueOf(i.DNJ.eNR()) });
        switch (paramAnonymousyr.dOD.dOF)
        {
        }
        for (;;)
        {
          paramAnonymousyr.dOD.activity = null;
          AppMethodBeat.o(129912);
          return false;
          long l1;
          long l2;
          if (!(paramAnonymousyr.dOD.activity instanceof GestureGuardLogicUI))
          {
            if (!i.DNJ.eNQ())
            {
              l1 = d.eNe();
              l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
              if ((l1 == -1L) || (l2 >= a.DMh) || ((com.tencent.mm.plugin.walletlock.gesture.a.b.eNn()) && (com.tencent.mm.plugin.walletlock.gesture.a.b.eNm())))
              {
                ae.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                paramAnonymousyr.dOE.data = Integer.valueOf(17);
              }
              else
              {
                ae.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                paramAnonymousyr.dOE.data = Integer.valueOf(16);
                i.DNJ.i(new WeakReference(paramAnonymousyr.dOD.activity));
              }
            }
            else
            {
              ae.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
              paramAnonymousyr.dOE.data = Integer.valueOf(16);
              i.DNJ.i(new WeakReference(paramAnonymousyr.dOD.activity));
              i.DNJ.uS(false);
            }
          }
          else
          {
            ae.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
            paramAnonymousyr.dOE.data = Integer.valueOf(16);
            continue;
            if (!(paramAnonymousyr.dOD.activity instanceof GestureGuardLogicUI))
            {
              if (i.DNJ.eNQ())
              {
                ae.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                i.DNJ.uS(false);
                i.DNJ.uT(false);
                paramAnonymousyr.dOE.data = Integer.valueOf(16);
              }
              else if (i.DNJ.eNR())
              {
                ae.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                i.DNJ.uS(false);
                i.DNJ.uT(false);
                paramAnonymousyr.dOE.data = Integer.valueOf(18);
              }
              else
              {
                l1 = d.eNe();
                l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
                if (((l1 == -1L) || (l2 >= a.DMh) || (com.tencent.mm.plugin.walletlock.gesture.a.b.eNn())) && (com.tencent.mm.plugin.walletlock.gesture.a.b.eNm())) {
                  ae.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                }
                for (paramAnonymousyr.dOE.data = Integer.valueOf(17);; paramAnonymousyr.dOE.data = Integer.valueOf(16))
                {
                  i.DNJ.i(new WeakReference(paramAnonymousyr.dOD.activity));
                  break;
                  ae.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                }
              }
            }
            else
            {
              ae.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
              paramAnonymousyr.dOE.data = Integer.valueOf(16);
              continue;
              i.DNJ.eNS();
              continue;
              paramAnonymousyr.dOE.data = Boolean.valueOf(e.eNm());
              continue;
              paramAnonymousyr.dOE.data = Boolean.valueOf(com.tencent.mm.plugin.walletlock.gesture.a.b.eNn());
            }
          }
        }
      }
    };
    this.DND = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(xl paramAnonymousxl)
      {
        AppMethodBeat.i(129914);
        paramAnonymousxl = paramAnonymousxl.dMT.dMU;
        g localg = g.DNF;
        g.eNd();
        boolean bool = e.b(paramAnonymousxl);
        if (bool)
        {
          ae.i("MicroMsg.WalletLockInitTask", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", new Object[] { Integer.valueOf(paramAnonymousxl.HvL.getILen()), Boolean.valueOf(bool), Integer.valueOf(paramAnonymousxl.HvM), Integer.valueOf(paramAnonymousxl.HvK) });
          d.a(paramAnonymousxl);
        }
        for (;;)
        {
          bool = e.eNm();
          ae.i("MicroMsg.WalletLockInitTask", "alvinluo after update gesture server info, isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.walletlock.gesture.a.b.uO(bool);
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).init();
          AppMethodBeat.o(129914);
          return false;
          ae.w("MicroMsg.WalletLockInitTask", "UserInfoExt.PatternLockInfo is null or invalid.");
        }
      }
    };
    AppMethodBeat.o(129916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.f
 * JD-Core Version:    0.7.0.1
 */