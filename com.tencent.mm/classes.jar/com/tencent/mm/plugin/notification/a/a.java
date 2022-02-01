package com.tencent.mm.plugin.notification.a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;

public final class a
  implements n.b
{
  private final int DELAY_TIME;
  private final String TAG;
  private aq mHandler;
  public boolean wKV;
  
  public a()
  {
    AppMethodBeat.i(26721);
    this.TAG = "MicroMsg.NotificationObserver";
    this.DELAY_TIME = 50;
    this.wKV = false;
    this.mHandler = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(final Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26720);
        super.handleMessage(paramAnonymousMessage);
        paramAnonymousMessage = paramAnonymousMessage.getData().getString("com.tencent.mm.notification.observer");
        bc.ajU().n(new Runnable()
        {
          public final void run()
          {
            final int i = 0;
            AppMethodBeat.i(26719);
            if (!g.ajP().aiZ())
            {
              ae.w("MicroMsg.NotificationObserver", "account not init.");
              AppMethodBeat.o(26719);
              return;
            }
            final int j = f.acI();
            bc.aCg();
            an localan = com.tencent.mm.model.c.azF().BH(paramAnonymousMessage);
            final boolean bool;
            if (localan == null)
            {
              bool = false;
              if (!bool) {
                break label94;
              }
            }
            for (;;)
            {
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(26718);
                  bc.getNotification().kP(j);
                  if (!bool) {
                    bc.getNotification().B(a.1.1.this.wKX, i);
                  }
                  ae.i("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) });
                  b.c(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(26717);
                      bc.getNotification().p(a.1.1.1.this.wKZ, a.1.1.this.wKX);
                      if (a.this.wKV)
                      {
                        a.this.wKV = false;
                        bc.getNotification().cA(false);
                      }
                      AppMethodBeat.o(26717);
                    }
                  }, "NotificationObserver");
                  AppMethodBeat.o(26718);
                }
              });
              AppMethodBeat.o(26719);
              return;
              bool = localan.Pd();
              break;
              label94:
              i = f.vZ(paramAnonymousMessage);
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
    ae.i("MicroMsg.NotificationObserver", "event: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((!(paramObject instanceof String)) || (bu.isNullOrNil((String)paramObject)))
    {
      ae.d("MicroMsg.NotificationObserver", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(26722);
      return;
    }
    if (!bc.aBZ()) {
      bc.aCg();
    }
    for (paramInt = (int)com.tencent.mm.model.c.azF().aUK((String)paramObject).ght;; paramInt = 0)
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