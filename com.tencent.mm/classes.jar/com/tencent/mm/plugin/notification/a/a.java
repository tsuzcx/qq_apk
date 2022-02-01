package com.tencent.mm.plugin.notification.a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.f;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;

public final class a
  implements n.b
{
  private final int DELAY_TIME;
  private final String TAG;
  private ao mHandler;
  public boolean vpS;
  
  public a()
  {
    AppMethodBeat.i(26721);
    this.TAG = "MicroMsg.NotificationObserver";
    this.DELAY_TIME = 50;
    this.vpS = false;
    this.mHandler = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(final Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26720);
        super.handleMessage(paramAnonymousMessage);
        paramAnonymousMessage = paramAnonymousMessage.getData().getString("com.tencent.mm.notification.observer");
        az.agU().m(new Runnable()
        {
          public final void run()
          {
            final int i = 0;
            AppMethodBeat.i(26719);
            if (!g.agP().afY())
            {
              ac.w("MicroMsg.NotificationObserver", "account not init.");
              AppMethodBeat.o(26719);
              return;
            }
            final int j = f.ZV();
            az.ayM();
            ai localai = c.awB().aNt(paramAnonymousMessage);
            final boolean bool;
            if (localai == null)
            {
              bool = false;
              if (!bool) {
                break label94;
              }
            }
            for (;;)
            {
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(26718);
                  az.getNotification().kq(j);
                  if (!bool) {
                    az.getNotification().y(a.1.1.this.vpU, i);
                  }
                  ac.i("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) });
                  com.tencent.mm.sdk.g.b.c(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(26717);
                      az.getNotification().p(a.1.1.1.this.vpW, a.1.1.this.vpU);
                      if (a.this.vpS)
                      {
                        a.this.vpS = false;
                        az.getNotification().cy(false);
                      }
                      AppMethodBeat.o(26717);
                    }
                  }, "NotificationObserver");
                  AppMethodBeat.o(26718);
                }
              });
              AppMethodBeat.o(26719);
              return;
              bool = localai.Nw();
              break;
              label94:
              i = f.sO(paramAnonymousMessage);
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
    ac.i("MicroMsg.NotificationObserver", "event: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((!(paramObject instanceof String)) || (bs.isNullOrNil((String)paramObject)))
    {
      ac.d("MicroMsg.NotificationObserver", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(26722);
      return;
    }
    if (!az.ayF()) {
      az.ayM();
    }
    for (paramInt = (int)c.awB().aNr((String)paramObject).fLJ;; paramInt = 0)
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