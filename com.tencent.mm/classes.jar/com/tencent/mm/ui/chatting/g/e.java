package com.tencent.mm.ui.chatting.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  implements d
{
  f Ifc;
  c Ifd;
  private AtomicBoolean hvg;
  final Handler mMainHandler;
  private final ao qGL;
  
  public e(f paramf, c paramc)
  {
    AppMethodBeat.i(36429);
    this.hvg = new AtomicBoolean(false);
    this.mMainHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(36426);
        d.d locald = (d.d)paramAnonymousMessage.obj;
        if (locald.hvg.get())
        {
          ac.w("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] cancel update!!!");
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
          boolean bool = e.this.Ifc.b(locald.IeY);
          if (bool)
          {
            locald.Ifb = e.this.Ifd.hW(locald.IeZ);
            e.this.Ifc.a(locald);
          }
          ac.i("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] UPDATE!!! isAvailableUpdate=%s result:%s", new Object[] { Boolean.valueOf(bool), locald.toString() });
        }
      }
    };
    this.Ifc = paramf;
    this.Ifd = paramc;
    this.qGL = new ao("ListDataLoader$");
    AppMethodBeat.o(36429);
  }
  
  public final void a(d.a parama, boolean paramBoolean, d.c paramc)
  {
    AppMethodBeat.i(36430);
    ac.i("MicroMsg.ChattingLoader.ListDataLoader", "[load] mode:%s isBlock:%s thread:%s", new Object[] { parama, Boolean.valueOf(paramBoolean), Long.valueOf(Thread.currentThread().getId()) });
    parama = new a(parama, paramBoolean, paramc, this.hvg);
    if (paramBoolean)
    {
      parama.run();
      AppMethodBeat.o(36430);
      return;
    }
    this.qGL.post(parama);
    AppMethodBeat.o(36430);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(36431);
    try
    {
      ac.i("MicroMsg.ChattingLoader.ListDataLoader", "[cancel]");
      this.hvg.set(true);
      this.hvg = new AtomicBoolean(false);
      this.qGL.removeCallbacksAndMessages(null);
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
    d.a IeY;
    d.c Iff;
    boolean dwv;
    AtomicBoolean hvg;
    
    a(d.a parama, boolean paramBoolean, d.c paramc, AtomicBoolean paramAtomicBoolean)
    {
      this.IeY = parama;
      this.dwv = paramBoolean;
      this.Iff = paramc;
      this.hvg = paramAtomicBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(36428);
      long l = System.currentTimeMillis();
      try
      {
        final d.d locald = new d.d(this.IeY, this.hvg);
        com.tencent.mm.ui.chatting.m.e locale = this.Iff.b(locald);
        e.this.Ifd.a(this.IeY, locale, locald, new d.b()
        {
          public final void next()
          {
            AppMethodBeat.i(36427);
            e.a.this.Iff.c(locald);
            e.a locala = e.a.this;
            d.d locald = locald;
            synchronized (locala.Ife)
            {
              if (locala.hvg.get())
              {
                ac.w("MicroMsg.ChattingLoader.ListDataLoader", "has cancel!");
                AppMethodBeat.o(36427);
                return;
              }
              Message localMessage = new Message();
              localMessage.what = 1;
              localMessage.obj = locald;
              if ((locala.dwv) && (Looper.myLooper() == Looper.getMainLooper()))
              {
                locala.Ife.mMainHandler.handleMessage(localMessage);
                AppMethodBeat.o(36427);
                return;
              }
              locala.Ife.mMainHandler.sendMessage(localMessage);
            }
          }
        });
        ac.d("MicroMsg.ChattingLoader.ListDataLoader", "[LoadTask.run] cost:%dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(36428);
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.ChattingLoader.ListDataLoader", localArrayIndexOutOfBoundsException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.e
 * JD-Core Version:    0.7.0.1
 */