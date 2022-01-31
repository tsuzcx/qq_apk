package com.tencent.mm.ui.chatting.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  implements d
{
  private static final HandlerThread vyn = new HandlerThread("ListDataLoader$Thread");
  private final Handler bqj;
  private boolean edT = false;
  private final Handler mMainHandler = new e.1(this, Looper.getMainLooper());
  private f vyo;
  private c vyp;
  
  public e(f paramf, c paramc)
  {
    this.vyo = paramf;
    this.vyp = paramc;
    if (!vyn.isAlive()) {
      vyn.start();
    }
    this.bqj = new Handler(vyn.getLooper());
  }
  
  public final void a(d.a parama, boolean paramBoolean, d.c paramc)
  {
    y.i("MicroMsg.ChattingLoader.ListDataLoader", "[load] mode:%s isBlock:%s thread:%s", new Object[] { parama, Boolean.valueOf(paramBoolean), Long.valueOf(Thread.currentThread().getId()) });
    this.edT = false;
    parama = new a(parama, paramBoolean, paramc);
    if (paramBoolean)
    {
      parama.run();
      return;
    }
    this.bqj.post(parama);
  }
  
  public final void cancel()
  {
    y.i("MicroMsg.ChattingLoader.ListDataLoader", "[cancel]");
    this.edT = true;
    this.bqj.removeCallbacksAndMessages(null);
    this.mMainHandler.removeCallbacksAndMessages(null);
  }
  
  private final class a
    implements Runnable
  {
    boolean bZB;
    d.a vyj;
    d.c vyr;
    
    a(d.a parama, boolean paramBoolean, d.c paramc)
    {
      this.vyj = parama;
      this.bZB = paramBoolean;
      this.vyr = paramc;
    }
    
    public final void run()
    {
      long l = System.currentTimeMillis();
      d.d locald = new d.d(this.vyj);
      com.tencent.mm.ui.chatting.k.e locale = this.vyr.b(locald);
      e.b(e.this).a(this.vyj, locale, locald, new e.a.1(this, locald));
      y.d("MicroMsg.ChattingLoader.ListDataLoader", "[LoadTask.run] cost:%dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.e
 * JD-Core Version:    0.7.0.1
 */