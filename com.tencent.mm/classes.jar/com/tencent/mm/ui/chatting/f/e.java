package com.tencent.mm.ui.chatting.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  implements d
{
  private static final HandlerThread zOI;
  private final Handler bQn;
  private final Handler mMainHandler;
  private AtomicBoolean zOJ;
  private f zOK;
  private c zOL;
  
  static
  {
    AppMethodBeat.i(32491);
    zOI = new HandlerThread("ListDataLoader$Thread");
    AppMethodBeat.o(32491);
  }
  
  public e(f paramf, c paramc)
  {
    AppMethodBeat.i(32488);
    this.zOJ = new AtomicBoolean(false);
    this.mMainHandler = new e.1(this, Looper.getMainLooper());
    this.zOK = paramf;
    this.zOL = paramc;
    if (!zOI.isAlive()) {
      zOI.start();
    }
    this.bQn = new Handler(zOI.getLooper());
    AppMethodBeat.o(32488);
  }
  
  public final void a(d.a parama, boolean paramBoolean, d.c paramc)
  {
    AppMethodBeat.i(32489);
    ab.i("MicroMsg.ChattingLoader.ListDataLoader", "[load] mode:%s isBlock:%s thread:%s", new Object[] { parama, Boolean.valueOf(paramBoolean), Long.valueOf(Thread.currentThread().getId()) });
    parama = new e.a(this, parama, paramBoolean, paramc, this.zOJ);
    if (paramBoolean)
    {
      parama.run();
      AppMethodBeat.o(32489);
      return;
    }
    this.bQn.post(parama);
    AppMethodBeat.o(32489);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32490);
    ab.i("MicroMsg.ChattingLoader.ListDataLoader", "[cancel]");
    this.zOJ.set(true);
    this.zOJ = new AtomicBoolean(false);
    this.bQn.removeCallbacksAndMessages(null);
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(32490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.e
 * JD-Core Version:    0.7.0.1
 */