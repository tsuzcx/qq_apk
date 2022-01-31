package com.tencent.mm.ui.chatting.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicBoolean;

final class e$a
  implements Runnable
{
  boolean cHT;
  d.a zOE;
  AtomicBoolean zOJ;
  d.c zON;
  
  e$a(e parame, d.a parama, boolean paramBoolean, d.c paramc, AtomicBoolean paramAtomicBoolean)
  {
    this.zOE = parama;
    this.cHT = paramBoolean;
    this.zON = paramc;
    this.zOJ = paramAtomicBoolean;
  }
  
  public final void run()
  {
    AppMethodBeat.i(32487);
    long l = System.currentTimeMillis();
    try
    {
      final d.d locald = new d.d(this.zOE);
      com.tencent.mm.ui.chatting.l.e locale = this.zON.b(locald);
      e.b(this.zOM).a(this.zOE, locale, locald, new d.b()
      {
        public final void next()
        {
          AppMethodBeat.i(32486);
          e.a.this.zON.c(locald);
          e.a locala = e.a.this;
          d.d locald = locald;
          if (locala.zOJ.get())
          {
            ab.w("MicroMsg.ChattingLoader.ListDataLoader", "has cancel!");
            AppMethodBeat.o(32486);
            return;
          }
          Message localMessage = new Message();
          localMessage.what = 1;
          localMessage.obj = locald;
          if ((locala.cHT) && (Looper.myLooper() == Looper.getMainLooper()))
          {
            e.d(locala.zOM).handleMessage(localMessage);
            AppMethodBeat.o(32486);
            return;
          }
          e.d(locala.zOM).sendMessage(localMessage);
          AppMethodBeat.o(32486);
        }
      });
      ab.d("MicroMsg.ChattingLoader.ListDataLoader", "[LoadTask.run] cost:%dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(32487);
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ChattingLoader.ListDataLoader", localArrayIndexOutOfBoundsException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.e.a
 * JD-Core Version:    0.7.0.1
 */