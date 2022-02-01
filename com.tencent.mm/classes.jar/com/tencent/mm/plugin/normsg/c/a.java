package com.tencent.mm.plugin.normsg.c;

import android.os.Message;
import com.tencent.e.f.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.normsg.c.a.a.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.UUID;

public final class a
{
  private static final j<a> MtV;
  private long MtW;
  private MMHandler handler;
  
  static
  {
    AppMethodBeat.i(261926);
    MtV = new j() {};
    AppMethodBeat.o(261926);
  }
  
  public a()
  {
    AppMethodBeat.i(261893);
    this.MtW = 0L;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(261905);
        int i;
        try
        {
          i = paramAnonymousMessage.what;
          switch (i)
          {
          default: 
            AppMethodBeat.o(261905);
            return;
          }
        }
        finally
        {
          Log.i("MicroMsg.FLST", "handle msg %d error: %s", new Object[] { Integer.valueOf(paramAnonymousMessage.what), localObject1.toString() });
          AppMethodBeat.o(261905);
          return;
        }
        int m = paramAnonymousMessage.arg1;
        long l = ((Long)paramAnonymousMessage.obj).longValue();
        if (paramAnonymousMessage.arg2 > 0)
        {
          i = 1;
          Log.i("MicroMsg.FLST", "handle msg %d ", new Object[] { Integer.valueOf(1) });
          if (i == 0) {
            break label202;
          }
          if (a.a(a.this) != 0L) {
            break label176;
          }
          a.a(a.this, l);
        }
        label176:
        label202:
        while (a.a(a.this) == l) {
          for (;;)
          {
            if (com.tencent.mm.n.a.q(MMApplicationContext.getContext(), false)) {
              break label221;
            }
            a.b(a.this, l);
            AppMethodBeat.o(261905);
            return;
            i = 0;
            break;
            if (a.a(a.this) == l) {
              break label215;
            }
            a.a(a.this, l);
          }
        }
        label269:
        label453:
        label459:
        label463:
        for (;;)
        {
          label215:
          AppMethodBeat.o(261905);
          return;
          label221:
          Object localObject2 = "FinderLive_" + l + "_" + UUID.randomUUID().toString();
          int j;
          if (!BuildInfo.IS_FLAVOR_RED) {
            if (BuildInfo.DEBUG)
            {
              break label453;
              localObject2 = new b((String)localObject2, i);
              if (!((b)localObject2).gtT()) {
                continue;
              }
              com.tencent.mm.plugin.normsg.c.a.a.gtR().a(m, (b)localObject2);
              j = ((b)localObject2).Muq;
              if (BuildInfo.IS_FLAVOR_RED) {
                break label459;
              }
              if (!BuildInfo.DEBUG) {
                break label368;
              }
              break label459;
            }
          }
          for (;;)
          {
            if (i <= 0) {
              break label463;
            }
            a.a(a.this, m, l, i);
            break label215;
            j = ((c)h.ax(c.class)).a(c.a.ztm, 0);
            i = j;
            if (j > 0) {
              break label269;
            }
            i = 0;
            break label269;
            label368:
            int k = ((c)h.ax(c.class)).a(c.a.ztn, 0);
            i = k;
            if (k <= j)
            {
              i = j;
              continue;
              ((Long)paramAnonymousMessage.obj).longValue();
              Log.i("MicroMsg.FLST", "handle msg %d ", new Object[] { Integer.valueOf(1) });
              a.b(a.this).removeMessages(1);
              a.a(a.this, 0L);
              break;
              i = 100;
              break label269;
              i = 60000;
            }
          }
        }
      }
    };
    AppMethodBeat.o(261893);
  }
  
  public static a gtP()
  {
    AppMethodBeat.i(261899);
    a locala = (a)MtV.get();
    AppMethodBeat.o(261899);
    return locala;
  }
  
  public final void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(261929);
    int i = 0;
    if (paramBoolean) {
      i = 1;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = i;
    localMessage.obj = Long.valueOf(paramLong);
    this.handler.sendMessageDelayed(localMessage, paramInt2);
    AppMethodBeat.o(261929);
  }
  
  public final void sT(long paramLong)
  {
    AppMethodBeat.i(261932);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = Long.valueOf(paramLong);
    this.handler.sendMessageAtFrontOfQueue(localMessage);
    AppMethodBeat.o(261932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a
 * JD-Core Version:    0.7.0.1
 */