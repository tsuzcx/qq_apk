package com.tencent.mm.ui.chatting.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  implements d
{
  f GFg;
  c GFh;
  private AtomicBoolean gUH;
  final Handler mMainHandler;
  private final ap pYe;
  
  public e(f paramf, c paramc)
  {
    AppMethodBeat.i(36429);
    this.gUH = new AtomicBoolean(false);
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(36426);
        d.d locald = (d.d)paramAnonymousMessage.obj;
        if (locald.gUH.get())
        {
          ad.w("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] cancel update!!!");
          AppMethodBeat.o(36426);
          return;
        }
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(36426);
          return;
          boolean bool = e.this.GFg.b(locald.GFc);
          if (bool)
          {
            locald.GFf = e.this.GFh.hJ(locald.GFd);
            e.this.GFg.a(locald);
          }
          ad.i("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] UPDATE!!! isAvailableUpdate=%s result:%s", new Object[] { Boolean.valueOf(bool), locald.toString() });
        }
      }
    };
    this.GFg = paramf;
    this.GFh = paramc;
    this.pYe = new ap("ListDataLoader$");
    AppMethodBeat.o(36429);
  }
  
  public final void a(d.a parama, boolean paramBoolean, d.c paramc)
  {
    AppMethodBeat.i(36430);
    ad.i("MicroMsg.ChattingLoader.ListDataLoader", "[load] mode:%s isBlock:%s thread:%s", new Object[] { parama, Boolean.valueOf(paramBoolean), Long.valueOf(Thread.currentThread().getId()) });
    parama = new a(parama, paramBoolean, paramc, this.gUH);
    if (paramBoolean)
    {
      parama.run();
      AppMethodBeat.o(36430);
      return;
    }
    this.pYe.post(parama);
    AppMethodBeat.o(36430);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(36431);
    try
    {
      ad.i("MicroMsg.ChattingLoader.ListDataLoader", "[cancel]");
      this.gUH.set(true);
      this.gUH = new AtomicBoolean(false);
      this.pYe.removeCallbacksAndMessages(null);
      this.mMainHandler.removeCallbacksAndMessages(null);
      return;
    }
    finally
    {
      AppMethodBeat.o(36431);
    }
  }
  
  final class a
    implements Runnable
  {
    d.a GFc;
    d.c GFj;
    boolean dyJ;
    AtomicBoolean gUH;
    
    a(d.a parama, boolean paramBoolean, d.c paramc, AtomicBoolean paramAtomicBoolean)
    {
      this.GFc = parama;
      this.dyJ = paramBoolean;
      this.GFj = paramc;
      this.gUH = paramAtomicBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(36428);
      long l = System.currentTimeMillis();
      try
      {
        final d.d locald = new d.d(this.GFc, this.gUH);
        com.tencent.mm.ui.chatting.m.e locale = this.GFj.b(locald);
        e.this.GFh.a(this.GFc, locale, locald, new d.b()
        {
          public final void next()
          {
            AppMethodBeat.i(36427);
            e.a.this.GFj.c(locald);
            e.a locala = e.a.this;
            d.d locald = locald;
            synchronized (locala.GFi)
            {
              if (locala.gUH.get())
              {
                ad.w("MicroMsg.ChattingLoader.ListDataLoader", "has cancel!");
                AppMethodBeat.o(36427);
                return;
              }
              Message localMessage = new Message();
              localMessage.what = 1;
              localMessage.obj = locald;
              if ((locala.dyJ) && (Looper.myLooper() == Looper.getMainLooper()))
              {
                locala.GFi.mMainHandler.handleMessage(localMessage);
                AppMethodBeat.o(36427);
                return;
              }
              locala.GFi.mMainHandler.sendMessage(localMessage);
            }
          }
        });
        ad.d("MicroMsg.ChattingLoader.ListDataLoader", "[LoadTask.run] cost:%dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(36428);
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ChattingLoader.ListDataLoader", localArrayIndexOutOfBoundsException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.e
 * JD-Core Version:    0.7.0.1
 */