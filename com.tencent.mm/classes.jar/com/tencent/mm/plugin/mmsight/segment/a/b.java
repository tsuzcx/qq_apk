package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.o.d;
import com.tencent.mm.plugin.o.j;
import com.tencent.mm.plugin.o.k;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  implements a
{
  boolean Xy;
  boolean isStart;
  boolean loop;
  int uQA;
  private int uQB;
  a.a uQC;
  a.d uQD;
  a.b uQE;
  a.c uQF;
  j uQy;
  int uQz;
  
  public b()
  {
    AppMethodBeat.i(107715);
    this.loop = false;
    this.isStart = false;
    this.Xy = false;
    this.uQA = 0;
    this.uQB = 0;
    this.uQy = new j(Looper.getMainLooper());
    Object localObject = this.uQy;
    if (((j)localObject).uIG != null)
    {
      localObject = ((j)localObject).uIG;
      if (((k)localObject).uIq != null) {
        ((k)localObject).uIq.uIm = false;
      }
    }
    this.uQy.setNeedResetExtractor(false);
    this.uQy.uIH = new d()
    {
      public final void X(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(107714);
        b.this.uQz = paramAnonymousInt3;
        if (b.this.uQD != null) {
          b.this.uQD.ak(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(107714);
      }
      
      public final void cfM()
      {
        AppMethodBeat.i(107713);
        ac.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", new Object[] { b.this.uQF });
        if (b.this.uQF != null)
        {
          b.this.uQF.dt(b.this.uQy);
          AppMethodBeat.o(107713);
          return;
        }
        if (b.this.isStart) {
          b.this.uQy.start();
        }
        AppMethodBeat.o(107713);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(107711);
        if (b.this.loop) {
          b.this.uQy.IE(b.this.uQA);
        }
        AppMethodBeat.o(107711);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(107712);
        if (b.this.uQC != null) {
          b.this.uQC.gk(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(107712);
      }
      
      public final void rB()
      {
        AppMethodBeat.i(107710);
        if (b.this.uQE != null) {
          b.this.uQE.ds(b.this.uQy);
        }
        if (b.this.isStart) {
          b.this.uQy.start();
        }
        b.this.Xy = true;
        AppMethodBeat.o(107710);
      }
    };
    AppMethodBeat.o(107715);
  }
  
  public final void a(a.a parama)
  {
    this.uQC = parama;
  }
  
  public final void a(a.b paramb)
  {
    this.uQE = paramb;
  }
  
  public final void a(a.c paramc)
  {
    this.uQF = paramc;
  }
  
  public final void a(a.d paramd)
  {
    this.uQD = paramd;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(107724);
    int i = this.uQy.ddd();
    AppMethodBeat.o(107724);
    return i;
  }
  
  public final int getDuration()
  {
    return (int)this.uQy.uIG.bjU;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107722);
    boolean bool = this.uQy.isPlaying();
    AppMethodBeat.o(107722);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(107721);
    this.uQy.pause();
    AppMethodBeat.o(107721);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(107718);
    this.uQy.cIc();
    AppMethodBeat.o(107718);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107725);
    this.uQy.release();
    AppMethodBeat.o(107725);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(107723);
    if (this.uQy != null)
    {
      ac.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", new Object[] { Integer.valueOf(paramInt) });
      this.uQy.IE(paramInt);
    }
    AppMethodBeat.o(107723);
  }
  
  public final void setAudioStreamType(int paramInt) {}
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(107717);
    this.uQy.setPath(paramString);
    AppMethodBeat.o(107717);
  }
  
  public final void setLoop(int paramInt1, int paramInt2)
  {
    this.uQA = paramInt1;
    this.uQB = paramInt2;
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.loop = paramBoolean;
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(107716);
    this.uQy.setSurface(paramSurface);
    AppMethodBeat.o(107716);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107719);
    if (this.Xy) {
      this.uQy.start();
    }
    this.isStart = true;
    AppMethodBeat.o(107719);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107720);
    this.uQy.stop();
    this.isStart = false;
    AppMethodBeat.o(107720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.b
 * JD-Core Version:    0.7.0.1
 */