package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public abstract class b
{
  protected com.tencent.mm.az.f tVI;
  protected f tYj;
  public g tYk = new g();
  
  public final void HY(final int paramInt)
  {
    if (this.tYj != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137403);
          if (b.this.cVC()) {
            b.this.tYj.L(b.this.tVI);
          }
          AppMethodBeat.o(137403);
        }
      });
    }
  }
  
  public final void M(com.tencent.mm.az.f paramf)
  {
    this.tVI = paramf;
  }
  
  public final void a(f paramf)
  {
    this.tYj = paramf;
  }
  
  public abstract void aiR(String paramString);
  
  public abstract boolean cVC();
  
  public abstract int cVD();
  
  public abstract String cVE();
  
  public abstract int getDuration();
  
  public abstract boolean isPlaying();
  
  public void nK(final boolean paramBoolean)
  {
    if (this.tYj != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137401);
          ad.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.tYj.d(b.this.tVI, paramBoolean);
          AppMethodBeat.o(137401);
        }
      });
    }
  }
  
  public void nL(final boolean paramBoolean)
  {
    if (this.tYj != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137404);
          ad.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.tYj.c(b.this.tVI, paramBoolean);
          AppMethodBeat.o(137404);
        }
      });
    }
  }
  
  public final void onStart()
  {
    if (this.tYj != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137402);
          ad.i("MicroMsg.Music.BasePlayer", "onStart %b", new Object[] { Boolean.valueOf(b.this.isPlaying()) });
          b.this.tYj.n(b.this.tVI);
          AppMethodBeat.o(137402);
        }
      });
    }
  }
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void seek(long paramLong);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.b
 * JD-Core Version:    0.7.0.1
 */