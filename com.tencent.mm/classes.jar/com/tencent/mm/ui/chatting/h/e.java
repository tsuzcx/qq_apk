package com.tencent.mm.ui.chatting.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.chatting.o.g;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  implements d
{
  f WYC;
  c WYD;
  private AtomicBoolean lBG;
  final Handler mMainHandler;
  private final MMHandler wFc;
  
  public e(f paramf, c paramc)
  {
    AppMethodBeat.i(36429);
    this.lBG = new AtomicBoolean(false);
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(36426);
        d.d locald = (d.d)paramAnonymousMessage.obj;
        if (locald.lBG.get())
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
          boolean bool = e.this.WYC.b(locald.WYy);
          if (bool)
          {
            locald.WYB = e.this.WYD.kn(locald.WYz);
            e.this.WYC.a(locald);
          }
          Log.i("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] UPDATE!!! isAvailableUpdate=%s result:%s", new Object[] { Boolean.valueOf(bool), locald.toString() });
        }
      }
    };
    this.WYC = paramf;
    this.WYD = paramc;
    this.wFc = new MMHandler("ListDataLoader$");
    AppMethodBeat.o(36429);
  }
  
  public final void a(d.a parama, boolean paramBoolean, d.c paramc)
  {
    AppMethodBeat.i(36430);
    Log.i("MicroMsg.ChattingLoader.ListDataLoader", "[load] mode:%s isBlock:%s thread:%s", new Object[] { parama, Boolean.valueOf(paramBoolean), Long.valueOf(Thread.currentThread().getId()) });
    parama = new a(parama, paramBoolean, paramc, this.lBG);
    if (paramBoolean)
    {
      parama.run();
      AppMethodBeat.o(36430);
      return;
    }
    this.wFc.post(parama);
    AppMethodBeat.o(36430);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(36431);
    try
    {
      Log.i("MicroMsg.ChattingLoader.ListDataLoader", "[cancel]");
      this.lBG.set(true);
      this.lBG = new AtomicBoolean(false);
      this.wFc.removeCallbacksAndMessages(null);
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
    d.c WYF;
    d.a WYy;
    boolean fVK;
    AtomicBoolean lBG;
    
    a(d.a parama, boolean paramBoolean, d.c paramc, AtomicBoolean paramAtomicBoolean)
    {
      this.WYy = parama;
      this.fVK = paramBoolean;
      this.WYF = paramc;
      this.lBG = paramAtomicBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(36428);
      long l = System.currentTimeMillis();
      try
      {
        final d.d locald = new d.d(this.WYy, this.lBG);
        g localg = this.WYF.b(locald);
        e.this.WYD.a(this.WYy, localg, locald, new d.b()
        {
          public final void next()
          {
            AppMethodBeat.i(36427);
            e.a.this.WYF.c(locald);
            e.a locala = e.a.this;
            d.d locald = locald;
            synchronized (locala.WYE)
            {
              if (locala.lBG.get())
              {
                Log.w("MicroMsg.ChattingLoader.ListDataLoader", "has cancel!");
                AppMethodBeat.o(36427);
                return;
              }
              Message localMessage = new Message();
              localMessage.what = 1;
              localMessage.obj = locald;
              if ((locala.fVK) && (Looper.myLooper() == Looper.getMainLooper()))
              {
                locala.WYE.mMainHandler.handleMessage(localMessage);
                AppMethodBeat.o(36427);
                return;
              }
              locala.WYE.mMainHandler.sendMessage(localMessage);
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
 * Qualified Name:     com.tencent.mm.ui.chatting.h.e
 * JD-Core Version:    0.7.0.1
 */