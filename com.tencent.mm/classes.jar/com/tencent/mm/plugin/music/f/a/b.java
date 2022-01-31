package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.sdk.platformtools.al;

public abstract class b
{
  protected e oYB;
  protected f paW;
  public g paX = new g();
  
  public final void Av(final int paramInt)
  {
    if (this.paW != null) {
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137651);
          if (b.this.bWb()) {
            b.this.paW.I(b.this.oYB);
          }
          AppMethodBeat.o(137651);
        }
      });
    }
  }
  
  public final void J(e parame)
  {
    this.oYB = parame;
  }
  
  public abstract void VE(String paramString);
  
  public final void a(f paramf)
  {
    this.paW = paramf;
  }
  
  public abstract boolean bWb();
  
  public abstract int bWc();
  
  public abstract String bWd();
  
  public abstract int getDuration();
  
  public abstract boolean isPlaying();
  
  public void jP(boolean paramBoolean)
  {
    if (this.paW != null) {
      al.d(new b.1(this, paramBoolean));
    }
  }
  
  public void jQ(boolean paramBoolean)
  {
    if (this.paW != null) {
      al.d(new b.4(this, paramBoolean));
    }
  }
  
  public final void onStart()
  {
    if (this.paW != null) {
      al.d(new b.2(this));
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