package com.tencent.mm.plugin.notification.a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.n.g;
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
  private final int GzF;
  public boolean GzG;
  private final String TAG;
  private MMHandler mHandler;
  
  public a()
  {
    AppMethodBeat.i(26721);
    this.TAG = "MicroMsg.NotificationObserver";
    this.GzF = 50;
    this.GzG = false;
    this.mHandler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(final Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26720);
        super.handleMessage(paramAnonymousMessage);
        paramAnonymousMessage = paramAnonymousMessage.getData().getString("com.tencent.mm.notification.observer");
        bh.aHJ().postToWorkerDelayed(new Runnable()
        {
          public final void run()
          {
            final int i = 0;
            AppMethodBeat.i(26719);
            if (!h.aHE().aGM())
            {
              Log.w("MicroMsg.NotificationObserver", "account not init.");
              AppMethodBeat.o(26719);
              return;
            }
            final int j = g.awZ();
            bh.beI();
            as localas = c.bbL().RG(paramAnonymousMessage);
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
                  bh.getNotification().qg(j);
                  if (!bool) {
                    bh.getNotification().U(a.1.1.this.GzI, i);
                  }
                  Log.i("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) });
                  ThreadPool.post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(26717);
                      bh.getNotification().s(a.1.1.1.this.GzK, a.1.1.this.GzI);
                      if (a.a(a.this))
                      {
                        a.b(a.this);
                        bh.getNotification().dJ(false);
                      }
                      AppMethodBeat.o(26717);
                    }
                  }, "NotificationObserver");
                  AppMethodBeat.o(26718);
                }
              });
              AppMethodBeat.o(26719);
              return;
              bool = localas.aeg();
              break;
              label94:
              i = g.Lh(paramAnonymousMessage);
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
    int i = 0;
    AppMethodBeat.i(26722);
    Log.i("MicroMsg.NotificationObserver", "event: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((!(paramObject instanceof String)) || (Util.isNullOrNil((String)paramObject)))
    {
      Log.d("MicroMsg.NotificationObserver", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(26722);
      return;
    }
    paramInt = i;
    if (!bh.beB())
    {
      bh.beI();
      paramInt = (int)c.bbL().bwg((String)paramObject).jxt;
      bh.beI();
      c.bbL().aHy((String)paramObject);
    }
    this.mHandler.removeMessages(paramInt);
    paramMStorageEx = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("com.tencent.mm.notification.observer", (String)paramObject);
    paramMStorageEx.setData(localBundle);
    paramMStorageEx.what = paramInt;
    this.mHandler.sendMessageDelayed(paramMStorageEx, 50L);
    AppMethodBeat.o(26722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.a.a
 * JD-Core Version:    0.7.0.1
 */