package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public abstract class b
{
  protected com.tencent.mm.az.f wjM;
  protected f wmr;
  public g wms = new g();
  
  public final void Lz(final int paramInt)
  {
    if (this.wmr != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137403);
          if (b.this.dtu()) {
            b.this.wmr.M(b.this.wjM);
          }
          AppMethodBeat.o(137403);
        }
      });
    }
  }
  
  public final void N(com.tencent.mm.az.f paramf)
  {
    this.wjM = paramf;
  }
  
  public final void a(f paramf)
  {
    this.wmr = paramf;
  }
  
  public abstract void asL(String paramString);
  
  public abstract boolean dtu();
  
  public abstract int dtv();
  
  public abstract String dtw();
  
  public abstract int getDuration();
  
  public abstract boolean isPlaying();
  
  public final void onStart()
  {
    if (this.wmr != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137402);
          ad.i("MicroMsg.Music.BasePlayer", "onStart %b", new Object[] { Boolean.valueOf(b.this.isPlaying()) });
          b.this.wmr.n(b.this.wjM);
          AppMethodBeat.o(137402);
        }
      });
    }
  }
  
  public abstract void pause();
  
  public void pd(final boolean paramBoolean)
  {
    if (this.wmr != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137401);
          ad.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.wmr.d(b.this.wjM, paramBoolean);
          AppMethodBeat.o(137401);
        }
      });
    }
  }
  
  public void pe(final boolean paramBoolean)
  {
    if (this.wmr != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137404);
          ad.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.wmr.c(b.this.wjM, paramBoolean);
          AppMethodBeat.o(137404);
        }
      });
    }
  }
  
  public abstract void play();
  
  public abstract void seek(long paramLong);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.b
 * JD-Core Version:    0.7.0.1
 */