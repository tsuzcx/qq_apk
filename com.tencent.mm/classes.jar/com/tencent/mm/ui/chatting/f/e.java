package com.tencent.mm.ui.chatting.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.chatting.k.g;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  implements d
{
  private final MMHandler Abn;
  f aeIc;
  c aeId;
  final Handler mMainHandler;
  private AtomicBoolean otq;
  
  public e(f paramf, c paramc)
  {
    AppMethodBeat.i(36429);
    this.otq = new AtomicBoolean(false);
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(36426);
        d.d locald = (d.d)paramAnonymousMessage.obj;
        if (locald.otq.get())
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
          boolean bool = e.this.aeIc.b(locald.aeHY);
          if (bool)
          {
            locald.aeIb = e.this.aeId.nD(locald.aeHZ);
            e.this.aeIc.a(locald);
          }
          Log.i("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] UPDATE!!! isAvailableUpdate=%s result:%s", new Object[] { Boolean.valueOf(bool), locald.toString() });
        }
      }
    };
    this.aeIc = paramf;
    this.aeId = paramc;
    this.Abn = new MMHandler("ListDataLoader$");
    AppMethodBeat.o(36429);
  }
  
  public final void a(d.a parama, boolean paramBoolean, d.c paramc)
  {
    AppMethodBeat.i(36430);
    Log.i("MicroMsg.ChattingLoader.ListDataLoader", "[load] mode:%s isBlock:%s thread:%s", new Object[] { parama, Boolean.valueOf(paramBoolean), Long.valueOf(Thread.currentThread().getId()) });
    parama = new a(parama, paramBoolean, paramc, this.otq);
    if (paramBoolean)
    {
      parama.run();
      AppMethodBeat.o(36430);
      return;
    }
    this.Abn.post(parama);
    AppMethodBeat.o(36430);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(36431);
    try
    {
      Log.i("MicroMsg.ChattingLoader.ListDataLoader", "[cancel]");
      this.otq.set(true);
      this.otq = new AtomicBoolean(false);
      this.Abn.removeCallbacksAndMessages(null);
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
    d.a aeHY;
    d.c aeIf;
    boolean ibK;
    AtomicBoolean otq;
    
    a(d.a parama, boolean paramBoolean, d.c paramc, AtomicBoolean paramAtomicBoolean)
    {
      this.aeHY = parama;
      this.ibK = paramBoolean;
      this.aeIf = paramc;
      this.otq = paramAtomicBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(36428);
      long l = System.currentTimeMillis();
      try
      {
        final d.d locald = new d.d(this.aeHY, this.otq);
        g localg = this.aeIf.b(locald);
        e.this.aeId.a(this.aeHY, localg, locald, new d.b()
        {
          public final void next()
          {
            AppMethodBeat.i(36427);
            e.a.this.aeIf.c(locald);
            e.a locala = e.a.this;
            d.d locald = locald;
            synchronized (locala.aeIe)
            {
              if (locala.otq.get())
              {
                Log.w("MicroMsg.ChattingLoader.ListDataLoader", "has cancel!");
                AppMethodBeat.o(36427);
                return;
              }
              Message localMessage = new Message();
              localMessage.what = 1;
              localMessage.obj = locald;
              if ((locala.ibK) && (Looper.myLooper() == Looper.getMainLooper()))
              {
                locala.aeIe.mMainHandler.handleMessage(localMessage);
                AppMethodBeat.o(36427);
                return;
              }
              locala.aeIe.mMainHandler.sendMessage(localMessage);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.e
 * JD-Core Version:    0.7.0.1
 */