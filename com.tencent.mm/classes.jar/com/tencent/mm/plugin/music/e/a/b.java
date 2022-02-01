package com.tencent.mm.plugin.music.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class b
{
  protected com.tencent.mm.aw.f LKT;
  protected f LOk;
  public g LOl = new g();
  
  public final void W(com.tencent.mm.aw.f paramf)
  {
    this.LKT = paramf;
  }
  
  public final void a(f paramf)
  {
    this.LOk = paramf;
  }
  
  public abstract String aGC();
  
  public abstract void aPi(String paramString);
  
  public final void adJ(final int paramInt)
  {
    if (this.LOk != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137403);
          if (b.this.gou()) {
            b.this.LOk.V(b.this.LKT);
          }
          AppMethodBeat.o(137403);
        }
      });
    }
  }
  
  public abstract int getDuration();
  
  public abstract boolean gou();
  
  public abstract int gov();
  
  public abstract boolean isPlaying();
  
  public final void onStart()
  {
    if (this.LOk != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137402);
          Log.i("MicroMsg.Music.BasePlayer", "onStart %b", new Object[] { Boolean.valueOf(b.this.isPlaying()) });
          b.this.LOk.p(b.this.LKT);
          AppMethodBeat.o(137402);
        }
      });
    }
  }
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void seek(long paramLong);
  
  public abstract void stop();
  
  public void zL(final boolean paramBoolean)
  {
    if (this.LOk != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137401);
          Log.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.LOk.d(b.this.LKT, paramBoolean);
          AppMethodBeat.o(137401);
        }
      });
    }
  }
  
  public void zM(final boolean paramBoolean)
  {
    if (this.LOk != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137404);
          Log.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.LOk.c(b.this.LKT, paramBoolean);
          AppMethodBeat.o(137404);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.a.b
 * JD-Core Version:    0.7.0.1
 */