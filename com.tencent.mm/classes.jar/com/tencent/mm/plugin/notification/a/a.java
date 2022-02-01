package com.tencent.mm.plugin.notification.a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;

public final class a
  implements n.b
{
  private final int DELAY_TIME;
  private final String TAG;
  private ap mHandler;
  public boolean wvk;
  
  public a()
  {
    AppMethodBeat.i(26721);
    this.TAG = "MicroMsg.NotificationObserver";
    this.DELAY_TIME = 50;
    this.wvk = false;
    this.mHandler = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(final Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26720);
        super.handleMessage(paramAnonymousMessage);
        paramAnonymousMessage = paramAnonymousMessage.getData().getString("com.tencent.mm.notification.observer");
        ba.ajF().n(new Runnable()
        {
          public final void run()
          {
            final int i = 0;
            AppMethodBeat.i(26719);
            if (!g.ajA().aiK())
            {
              ad.w("MicroMsg.NotificationObserver", "account not init.");
              AppMethodBeat.o(26719);
              return;
            }
            final int j = f.acx();
            ba.aBQ();
            am localam = c.azp().Bf(paramAnonymousMessage);
            final boolean bool;
            if (localam == null)
            {
              bool = false;
              if (!bool) {
                break label94;
              }
            }
            for (;;)
            {
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(26718);
                  ba.getNotification().kN(j);
                  if (!bool) {
                    ba.getNotification().A(a.1.1.this.wvm, i);
                  }
                  ad.i("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) });
                  com.tencent.mm.sdk.g.b.c(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(26717);
                      ba.getNotification().p(a.1.1.1.this.wvo, a.1.1.this.wvm);
                      if (a.this.wvk)
                      {
                        a.this.wvk = false;
                        ba.getNotification().cA(false);
                      }
                      AppMethodBeat.o(26717);
                    }
                  }, "NotificationObserver");
                  AppMethodBeat.o(26718);
                }
              });
              AppMethodBeat.o(26719);
              return;
              bool = localam.Pf();
              break;
              label94:
              i = f.vD(paramAnonymousMessage);
            }
          }
        }, 500L);
        AppMethodBeat.o(26720);
      }
    };
    AppMethodBeat.o(26721);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(26722);
    ad.i("MicroMsg.NotificationObserver", "event: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((!(paramObject instanceof String)) || (bt.isNullOrNil((String)paramObject)))
    {
      ad.d("MicroMsg.NotificationObserver", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(26722);
      return;
    }
    if (!ba.aBJ()) {
      ba.aBQ();
    }
    for (paramInt = (int)c.azp().aTj((String)paramObject).gfj;; paramInt = 0)
    {
      this.mHandler.removeMessages(paramInt);
      paramn = Message.obtain();
      Bundle localBundle = new Bundle();
      localBundle.putString("com.tencent.mm.notification.observer", (String)paramObject);
      paramn.setData(localBundle);
      paramn.what = paramInt;
      this.mHandler.sendMessageDelayed(paramn, 50L);
      AppMethodBeat.o(26722);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.a.a
 * JD-Core Version:    0.7.0.1
 */