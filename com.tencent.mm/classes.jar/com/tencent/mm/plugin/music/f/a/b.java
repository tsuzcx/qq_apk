package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;

public abstract class b
{
  protected com.tencent.mm.ay.f veq;
  protected f vgW;
  public g vgX = new g();
  
  public final void JX(final int paramInt)
  {
    if (this.vgW != null) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137403);
          if (b.this.dji()) {
            b.this.vgW.M(b.this.veq);
          }
          AppMethodBeat.o(137403);
        }
      });
    }
  }
  
  public final void N(com.tencent.mm.ay.f paramf)
  {
    this.veq = paramf;
  }
  
  public final void a(f paramf)
  {
    this.vgW = paramf;
  }
  
  public abstract void anM(String paramString);
  
  public abstract boolean dji();
  
  public abstract int djj();
  
  public abstract String djk();
  
  public abstract int getDuration();
  
  public abstract boolean isPlaying();
  
  public void oE(final boolean paramBoolean)
  {
    if (this.vgW != null) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137401);
          ac.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.vgW.d(b.this.veq, paramBoolean);
          AppMethodBeat.o(137401);
        }
      });
    }
  }
  
  public void oF(final boolean paramBoolean)
  {
    if (this.vgW != null) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137404);
          ac.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          b.this.vgW.c(b.this.veq, paramBoolean);
          AppMethodBeat.o(137404);
        }
      });
    }
  }
  
  public final void onStart()
  {
    if (this.vgW != null) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137402);
          ac.i("MicroMsg.Music.BasePlayer", "onStart %b", new Object[] { Boolean.valueOf(b.this.isPlaying()) });
          b.this.vgW.n(b.this.veq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.b
 * JD-Core Version:    0.7.0.1
 */