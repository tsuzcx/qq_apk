package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

public abstract class b
{
  protected f wCa;
  public g wCb = new g();
  protected com.tencent.mm.ay.f wzr;
  
  public final void Me(final int paramInt)
  {
    if (this.wCa != null) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137403);
          if (b.this.dwJ()) {
            b.this.wCa.M(b.this.wzr);
          }
          AppMethodBeat.o(137403);
        }
      });
    }
  }
  
  public final void N(com.tencent.mm.ay.f paramf)
  {
    this.wzr = paramf;
  }
  
  public final void a(f paramf)
  {
    this.wCa = paramf;
  }
  
  public abstract void atY(String paramString);
  
  public abstract boolean dwJ();
  
  public abstract int dwK();
  
  public abstract String dwL();
  
  public abstract int getDuration();
  
  public abstract boolean isPlaying();
  
  public final void onStart()
  {
    if (this.wCa != null) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137402);
          ae.i("MicroMsg.Music.BasePlayer", "onStart %b", new Object[] { Boolean.valueOf(b.this.isPlaying()) });
          b.this.wCa.n(b.this.wzr);
          AppMethodBeat.o(137402);
        }
      });
    }
  }
  
  public abstract void pause();
  
  public void pl(final boolean paramBoolean)
  {
    if (this.wCa != null) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137401);
          ae.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.wCa.d(b.this.wzr, paramBoolean);
          AppMethodBeat.o(137401);
        }
      });
    }
  }
  
  public abstract void play();
  
  public void pm(final boolean paramBoolean)
  {
    if (this.wCa != null) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137404);
          ae.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.wCa.c(b.this.wzr, paramBoolean);
          AppMethodBeat.o(137404);
        }
      });
    }
  }
  
  public abstract void seek(long paramLong);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.b
 * JD-Core Version:    0.7.0.1
 */