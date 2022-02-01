package com.tencent.mm.ui.chatting.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  implements d
{
  f KrH;
  c KrI;
  private AtomicBoolean hQr;
  final Handler mMainHandler;
  private final aq ryZ;
  
  public e(f paramf, c paramc)
  {
    AppMethodBeat.i(36429);
    this.hQr = new AtomicBoolean(false);
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(36426);
        d.d locald = (d.d)paramAnonymousMessage.obj;
        if (locald.hQr.get())
        {
          ae.w("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] cancel update!!!");
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
          boolean bool = e.this.KrH.b(locald.KrD);
          if (bool)
          {
            locald.KrG = e.this.KrI.is(locald.KrE);
            e.this.KrH.a(locald);
          }
          ae.i("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] UPDATE!!! isAvailableUpdate=%s result:%s", new Object[] { Boolean.valueOf(bool), locald.toString() });
        }
      }
    };
    this.KrH = paramf;
    this.KrI = paramc;
    this.ryZ = new aq("ListDataLoader$");
    AppMethodBeat.o(36429);
  }
  
  public final void a(d.a parama, boolean paramBoolean, d.c paramc)
  {
    AppMethodBeat.i(36430);
    ae.i("MicroMsg.ChattingLoader.ListDataLoader", "[load] mode:%s isBlock:%s thread:%s", new Object[] { parama, Boolean.valueOf(paramBoolean), Long.valueOf(Thread.currentThread().getId()) });
    parama = new a(parama, paramBoolean, paramc, this.hQr);
    if (paramBoolean)
    {
      parama.run();
      AppMethodBeat.o(36430);
      return;
    }
    this.ryZ.post(parama);
    AppMethodBeat.o(36430);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(36431);
    try
    {
      ae.i("MicroMsg.ChattingLoader.ListDataLoader", "[cancel]");
      this.hQr.set(true);
      this.hQr = new AtomicBoolean(false);
      this.ryZ.removeCallbacksAndMessages(null);
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
    d.a KrD;
    d.c KrK;
    boolean dJV;
    AtomicBoolean hQr;
    
    a(d.a parama, boolean paramBoolean, d.c paramc, AtomicBoolean paramAtomicBoolean)
    {
      this.KrD = parama;
      this.dJV = paramBoolean;
      this.KrK = paramc;
      this.hQr = paramAtomicBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(36428);
      long l = System.currentTimeMillis();
      try
      {
        final d.d locald = new d.d(this.KrD, this.hQr);
        com.tencent.mm.ui.chatting.n.e locale = this.KrK.b(locald);
        e.this.KrI.a(this.KrD, locale, locald, new d.b()
        {
          public final void next()
          {
            AppMethodBeat.i(36427);
            e.a.this.KrK.c(locald);
            e.a locala = e.a.this;
            d.d locald = locald;
            synchronized (locala.KrJ)
            {
              if (locala.hQr.get())
              {
                ae.w("MicroMsg.ChattingLoader.ListDataLoader", "has cancel!");
                AppMethodBeat.o(36427);
                return;
              }
              Message localMessage = new Message();
              localMessage.what = 1;
              localMessage.obj = locald;
              if ((locala.dJV) && (Looper.myLooper() == Looper.getMainLooper()))
              {
                locala.KrJ.mMainHandler.handleMessage(localMessage);
                AppMethodBeat.o(36427);
                return;
              }
              locala.KrJ.mMainHandler.sendMessage(localMessage);
            }
          }
        });
        ae.d("MicroMsg.ChattingLoader.ListDataLoader", "[LoadTask.run] cost:%dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(36428);
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.ChattingLoader.ListDataLoader", localArrayIndexOutOfBoundsException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.e
 * JD-Core Version:    0.7.0.1
 */