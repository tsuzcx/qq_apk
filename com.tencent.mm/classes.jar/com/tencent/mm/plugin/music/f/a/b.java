package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class b
{
  protected com.tencent.mm.bb.f FPX;
  protected f FTo;
  public g FTp = new g();
  
  public final void R(com.tencent.mm.bb.f paramf)
  {
    this.FPX = paramf;
  }
  
  public final void Zw(final int paramInt)
  {
    if (this.FTo != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137403);
          if (b.this.ffl()) {
            b.this.FTo.Q(b.this.FPX);
          }
          AppMethodBeat.o(137403);
        }
      });
    }
  }
  
  public final void a(f paramf)
  {
    this.FTo = paramf;
  }
  
  public abstract void aSo(String paramString);
  
  public abstract String aeE();
  
  public abstract boolean ffl();
  
  public abstract int ffm();
  
  public abstract int getDuration();
  
  public abstract boolean isPlaying();
  
  public final void onStart()
  {
    if (this.FTo != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137402);
          Log.i("MicroMsg.Music.BasePlayer", "onStart %b", new Object[] { Boolean.valueOf(b.this.isPlaying()) });
          b.this.FTo.n(b.this.FPX);
          AppMethodBeat.o(137402);
        }
      });
    }
  }
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void seek(long paramLong);
  
  public abstract void stop();
  
  public void vt(final boolean paramBoolean)
  {
    if (this.FTo != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137401);
          Log.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.FTo.d(b.this.FPX, paramBoolean);
          AppMethodBeat.o(137401);
        }
      });
    }
  }
  
  public void vu(final boolean paramBoolean)
  {
    if (this.FTo != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137404);
          Log.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.FTo.c(b.this.FPX, paramBoolean);
          AppMethodBeat.o(137404);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.b
 * JD-Core Version:    0.7.0.1
 */