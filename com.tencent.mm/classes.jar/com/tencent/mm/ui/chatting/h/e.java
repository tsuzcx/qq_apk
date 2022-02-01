package com.tencent.mm.ui.chatting.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  implements d
{
  f PDP;
  c PDQ;
  private AtomicBoolean iLz;
  final Handler mMainHandler;
  private final MMHandler sZa;
  
  public e(f paramf, c paramc)
  {
    AppMethodBeat.i(36429);
    this.iLz = new AtomicBoolean(false);
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(36426);
        d.d locald = (d.d)paramAnonymousMessage.obj;
        if (locald.iLz.get())
        {
          Log.w("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] cancel update!!!");
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
          boolean bool = e.this.PDP.b(locald.PDL);
          if (bool)
          {
            locald.PDO = e.this.PDQ.jv(locald.PDM);
            e.this.PDP.a(locald);
          }
          Log.i("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] UPDATE!!! isAvailableUpdate=%s result:%s", new Object[] { Boolean.valueOf(bool), locald.toString() });
        }
      }
    };
    this.PDP = paramf;
    this.PDQ = paramc;
    this.sZa = new MMHandler("ListDataLoader$");
    AppMethodBeat.o(36429);
  }
  
  public final void a(d.a parama, boolean paramBoolean, d.c paramc)
  {
    AppMethodBeat.i(36430);
    Log.i("MicroMsg.ChattingLoader.ListDataLoader", "[load] mode:%s isBlock:%s thread:%s", new Object[] { parama, Boolean.valueOf(paramBoolean), Long.valueOf(Thread.currentThread().getId()) });
    parama = new a(parama, paramBoolean, paramc, this.iLz);
    if (paramBoolean)
    {
      parama.run();
      AppMethodBeat.o(36430);
      return;
    }
    this.sZa.post(parama);
    AppMethodBeat.o(36430);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(36431);
    try
    {
      Log.i("MicroMsg.ChattingLoader.ListDataLoader", "[cancel]");
      this.iLz.set(true);
      this.iLz = new AtomicBoolean(false);
      this.sZa.removeCallbacksAndMessages(null);
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
    d.a PDL;
    d.c PDS;
    boolean ebI;
    AtomicBoolean iLz;
    
    a(d.a parama, boolean paramBoolean, d.c paramc, AtomicBoolean paramAtomicBoolean)
    {
      this.PDL = parama;
      this.ebI = paramBoolean;
      this.PDS = paramc;
      this.iLz = paramAtomicBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(36428);
      long l = System.currentTimeMillis();
      try
      {
        final d.d locald = new d.d(this.PDL, this.iLz);
        com.tencent.mm.ui.chatting.n.f localf = this.PDS.b(locald);
        e.this.PDQ.a(this.PDL, localf, locald, new d.b()
        {
          public final void next()
          {
            AppMethodBeat.i(36427);
            e.a.this.PDS.c(locald);
            e.a locala = e.a.this;
            d.d locald = locald;
            synchronized (locala.PDR)
            {
              if (locala.iLz.get())
              {
                Log.w("MicroMsg.ChattingLoader.ListDataLoader", "has cancel!");
                AppMethodBeat.o(36427);
                return;
              }
              Message localMessage = new Message();
              localMessage.what = 1;
              localMessage.obj = locald;
              if ((locala.ebI) && (Looper.myLooper() == Looper.getMainLooper()))
              {
                locala.PDR.mMainHandler.handleMessage(localMessage);
                AppMethodBeat.o(36427);
                return;
              }
              locala.PDR.mMainHandler.sendMessage(localMessage);
            }
          }
        });
        Log.d("MicroMsg.ChattingLoader.ListDataLoader", "[LoadTask.run] cost:%dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(36428);
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ChattingLoader.ListDataLoader", localArrayIndexOutOfBoundsException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.e
 * JD-Core Version:    0.7.0.1
 */