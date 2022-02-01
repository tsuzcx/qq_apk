package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class b
{
  protected com.tencent.mm.ay.f AiZ;
  protected f Amh;
  public g Ami = new g();
  
  public final void R(com.tencent.mm.ay.f paramf)
  {
    this.AiZ = paramf;
  }
  
  public final void Tb(final int paramInt)
  {
    if (this.Amh != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137403);
          if (b.this.euR()) {
            b.this.Amh.Q(b.this.AiZ);
          }
          AppMethodBeat.o(137403);
        }
      });
    }
  }
  
  public abstract String ZV();
  
  public final void a(f paramf)
  {
    this.Amh = paramf;
  }
  
  public abstract void aHY(String paramString);
  
  public abstract boolean euR();
  
  public abstract int euS();
  
  public abstract int getDuration();
  
  public abstract boolean isPlaying();
  
  public final void onStart()
  {
    if (this.Amh != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137402);
          Log.i("MicroMsg.Music.BasePlayer", "onStart %b", new Object[] { Boolean.valueOf(b.this.isPlaying()) });
          b.this.Amh.n(b.this.AiZ);
          AppMethodBeat.o(137402);
        }
      });
    }
  }
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void seek(long paramLong);
  
  public void sn(final boolean paramBoolean)
  {
    if (this.Amh != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137401);
          Log.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.Amh.d(b.this.AiZ, paramBoolean);
          AppMethodBeat.o(137401);
        }
      });
    }
  }
  
  public void so(final boolean paramBoolean)
  {
    if (this.Amh != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137404);
          Log.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.Amh.c(b.this.AiZ, paramBoolean);
          AppMethodBeat.o(137404);
        }
      });
    }
  }
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.b
 * JD-Core Version:    0.7.0.1
 */