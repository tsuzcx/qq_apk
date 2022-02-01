package com.tencent.mm.ui.chatting.h;

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
  f JVp;
  c JVq;
  private AtomicBoolean hNy;
  final Handler mMainHandler;
  private final ap rqK;
  
  public e(f paramf, c paramc)
  {
    AppMethodBeat.i(36429);
    this.hNy = new AtomicBoolean(false);
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(36426);
        d.d locald = (d.d)paramAnonymousMessage.obj;
        if (locald.hNy.get())
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
          boolean bool = e.this.JVp.b(locald.JVl);
          if (bool)
          {
            locald.JVo = e.this.JVq.ii(locald.JVm);
            e.this.JVp.a(locald);
          }
          ad.i("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] UPDATE!!! isAvailableUpdate=%s result:%s", new Object[] { Boolean.valueOf(bool), locald.toString() });
        }
      }
    };
    this.JVp = paramf;
    this.JVq = paramc;
    this.rqK = new ap("ListDataLoader$");
    AppMethodBeat.o(36429);
  }
  
  public final void a(d.a parama, boolean paramBoolean, d.c paramc)
  {
    AppMethodBeat.i(36430);
    ad.i("MicroMsg.ChattingLoader.ListDataLoader", "[load] mode:%s isBlock:%s thread:%s", new Object[] { parama, Boolean.valueOf(paramBoolean), Long.valueOf(Thread.currentThread().getId()) });
    parama = new a(parama, paramBoolean, paramc, this.hNy);
    if (paramBoolean)
    {
      parama.run();
      AppMethodBeat.o(36430);
      return;
    }
    this.rqK.post(parama);
    AppMethodBeat.o(36430);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(36431);
    try
    {
      ad.i("MicroMsg.ChattingLoader.ListDataLoader", "[cancel]");
      this.hNy.set(true);
      this.hNy = new AtomicBoolean(false);
      this.rqK.removeCallbacksAndMessages(null);
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
    d.a JVl;
    d.c JVs;
    boolean dIH;
    AtomicBoolean hNy;
    
    a(d.a parama, boolean paramBoolean, d.c paramc, AtomicBoolean paramAtomicBoolean)
    {
      this.JVl = parama;
      this.dIH = paramBoolean;
      this.JVs = paramc;
      this.hNy = paramAtomicBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(36428);
      long l = System.currentTimeMillis();
      try
      {
        final d.d locald = new d.d(this.JVl, this.hNy);
        com.tencent.mm.ui.chatting.n.e locale = this.JVs.b(locald);
        e.this.JVq.a(this.JVl, locale, locald, new d.b()
        {
          public final void next()
          {
            AppMethodBeat.i(36427);
            e.a.this.JVs.c(locald);
            e.a locala = e.a.this;
            d.d locald = locald;
            synchronized (locala.JVr)
            {
              if (locala.hNy.get())
              {
                ad.w("MicroMsg.ChattingLoader.ListDataLoader", "has cancel!");
                AppMethodBeat.o(36427);
                return;
              }
              Message localMessage = new Message();
              localMessage.what = 1;
              localMessage.obj = locald;
              if ((locala.dIH) && (Looper.myLooper() == Looper.getMainLooper()))
              {
                locala.JVr.mMainHandler.handleMessage(localMessage);
                AppMethodBeat.o(36427);
                return;
              }
              locala.JVr.mMainHandler.sendMessage(localMessage);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.e
 * JD-Core Version:    0.7.0.1
 */