package com.tencent.mm.plugin.walletlock.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.g.a.ym.a;
import com.tencent.mm.g.a.zw;
import com.tencent.mm.g.a.zw.a;
import com.tencent.mm.plugin.walletlock.gesture.a.a;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class f
{
  public IListener IwP;
  public IListener IwQ;
  private IListener IwR;
  public IListener IwS;
  
  public f()
  {
    AppMethodBeat.i(129916);
    this.IwP = new c();
    this.IwQ = new IListener() {};
    this.IwR = new IListener()
    {
      private static boolean a(zw paramAnonymouszw)
      {
        AppMethodBeat.i(129912);
        Log.v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", new Object[] { Integer.valueOf(paramAnonymouszw.egz.egB), Boolean.valueOf(i.IwY.fVz()), Boolean.valueOf(i.IwY.fVA()) });
        switch (paramAnonymouszw.egz.egB)
        {
        }
        for (;;)
        {
          paramAnonymouszw.egz.activity = null;
          AppMethodBeat.o(129912);
          return false;
          long l1;
          long l2;
          if (!(paramAnonymouszw.egz.activity instanceof GestureGuardLogicUI))
          {
            if (!i.IwY.fVz())
            {
              l1 = d.fUN();
              l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
              if ((l1 == -1L) || (l2 >= a.Ivw) || ((com.tencent.mm.plugin.walletlock.gesture.a.b.fUW()) && (com.tencent.mm.plugin.walletlock.gesture.a.b.fUV())))
              {
                Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                paramAnonymouszw.egA.data = Integer.valueOf(17);
              }
              else
              {
                Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                paramAnonymouszw.egA.data = Integer.valueOf(16);
                i.IwY.j(new WeakReference(paramAnonymouszw.egz.activity));
              }
            }
            else
            {
              Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
              paramAnonymouszw.egA.data = Integer.valueOf(16);
              i.IwY.j(new WeakReference(paramAnonymouszw.egz.activity));
              i.IwY.yH(false);
            }
          }
          else
          {
            Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
            paramAnonymouszw.egA.data = Integer.valueOf(16);
            continue;
            if (!(paramAnonymouszw.egz.activity instanceof GestureGuardLogicUI))
            {
              if (i.IwY.fVz())
              {
                Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                i.IwY.yH(false);
                i.IwY.yI(false);
                paramAnonymouszw.egA.data = Integer.valueOf(16);
              }
              else if (i.IwY.fVA())
              {
                Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                i.IwY.yH(false);
                i.IwY.yI(false);
                paramAnonymouszw.egA.data = Integer.valueOf(18);
              }
              else
              {
                l1 = d.fUN();
                l2 = (SystemClock.elapsedRealtime() - l1) / 1000L;
                if (((l1 == -1L) || (l2 >= a.Ivw) || (com.tencent.mm.plugin.walletlock.gesture.a.b.fUW())) && (com.tencent.mm.plugin.walletlock.gesture.a.b.fUV())) {
                  Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                }
                for (paramAnonymouszw.egA.data = Integer.valueOf(17);; paramAnonymouszw.egA.data = Integer.valueOf(16))
                {
                  i.IwY.j(new WeakReference(paramAnonymouszw.egz.activity));
                  break;
                  Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                }
              }
            }
            else
            {
              Log.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
              paramAnonymouszw.egA.data = Integer.valueOf(16);
              continue;
              i.IwY.fVB();
              continue;
              paramAnonymouszw.egA.data = Boolean.valueOf(e.fUV());
              continue;
              paramAnonymouszw.egA.data = Boolean.valueOf(com.tencent.mm.plugin.walletlock.gesture.a.b.fUW());
            }
          }
        }
      }
    };
    this.IwS = new IListener()
    {
      private static boolean a(ym paramAnonymousym)
      {
        AppMethodBeat.i(129914);
        paramAnonymousym = paramAnonymousym.eeL.eeM;
        g localg = g.IwU;
        g.fUM();
        boolean bool = e.b(paramAnonymousym);
        if (bool)
        {
          Log.i("MicroMsg.WalletLockInitTask", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", new Object[] { Integer.valueOf(paramAnonymousym.MEK.getILen()), Boolean.valueOf(bool), Integer.valueOf(paramAnonymousym.MEL), Integer.valueOf(paramAnonymousym.MEJ) });
          d.a(paramAnonymousym);
        }
        for (;;)
        {
          bool = e.fUV();
          Log.i("MicroMsg.WalletLockInitTask", "alvinluo after update gesture server info, isUserSetGesturePwd: %b", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.walletlock.gesture.a.b.yD(bool);
          ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).init();
          AppMethodBeat.o(129914);
          return false;
          Log.w("MicroMsg.WalletLockInitTask", "UserInfoExt.PatternLockInfo is null or invalid.");
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