package com.tencent.mm.plugin.notification.a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class a
  implements MStorageEx.IOnStorageChange
{
  private final int AGw;
  public boolean AGx;
  private final String TAG;
  private MMHandler mHandler;
  
  public a()
  {
    AppMethodBeat.i(26721);
    this.TAG = "MicroMsg.NotificationObserver";
    this.AGw = 50;
    this.AGx = false;
    this.mHandler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(final Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26720);
        super.handleMessage(paramAnonymousMessage);
        paramAnonymousMessage = paramAnonymousMessage.getData().getString("com.tencent.mm.notification.observer");
        bg.aAk().postToWorkerDelayed(new Runnable()
        {
          public final void run()
          {
            final int i = 0;
            AppMethodBeat.i(26719);
            if (!com.tencent.mm.kernel.g.aAf().azp())
            {
              Log.w("MicroMsg.NotificationObserver", "account not init.");
              AppMethodBeat.o(26719);
              return;
            }
            final int j = com.tencent.mm.n.g.aqG();
            bg.aVF();
            as localas = com.tencent.mm.model.c.aSN().Kn(paramAnonymousMessage);
            final boolean bool;
            if (localas == null)
            {
              bool = false;
              if (!bool) {
                break label94;
              }
            }
            for (;;)
            {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(26718);
                  bg.getNotification().nR(j);
                  if (!bool) {
                    bg.getNotification().C(a.1.1.this.AGz, i);
                  }
                  Log.i("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) });
                  ThreadPool.post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(26717);
                      bg.getNotification().r(a.1.1.1.this.AGB, a.1.1.this.AGz);
                      if (a.a(a.this))
                      {
                        a.b(a.this);
                        bg.getNotification().dj(false);
                      }
                      AppMethodBeat.o(26717);
                    }
                  }, "NotificationObserver");
                  AppMethodBeat.o(26718);
                }
              });
              AppMethodBeat.o(26719);
              return;
              bool = localas.Zx();
              break;
              label94:
              i = com.tencent.mm.n.g.Eo(paramAnonymousMessage);
            }
          }
        }, 500L);
        AppMethodBeat.o(26720);
      }
    };
    AppMethodBeat.o(26721);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(26722);
    Log.i("MicroMsg.NotificationObserver", "event: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((!(paramObject instanceof String)) || (Util.isNullOrNil((String)paramObject)))
    {
      Log.d("MicroMsg.NotificationObserver", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(26722);
      return;
    }
    if (!bg.aVy()) {
      bg.aVF();
    }
    for (paramInt = (int)com.tencent.mm.model.c.aSN().bjJ((String)paramObject).gMZ;; paramInt = 0)
    {
      this.mHandler.removeMessages(paramInt);
      paramMStorageEx = Message.obtain();
      Bundle localBundle = new Bundle();
      localBundle.putString("com.tencent.mm.notification.observer", (String)paramObject);
      paramMStorageEx.setData(localBundle);
      paramMStorageEx.what = paramInt;
      this.mHandler.sendMessageDelayed(paramMStorageEx, 50L);
      AppMethodBeat.o(26722);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.a.a
 * JD-Core Version:    0.7.0.1
 */