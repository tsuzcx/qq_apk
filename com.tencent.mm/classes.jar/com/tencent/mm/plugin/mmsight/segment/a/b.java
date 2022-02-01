package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.u.d;
import com.tencent.mm.plugin.u.j;
import com.tencent.mm.plugin.u.k;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  implements a
{
  j LaQ;
  int LaR;
  int LaS;
  private int LaT;
  a.a LaU;
  a.d LaV;
  a.b LaW;
  a.c LaX;
  boolean hS;
  boolean isStart;
  boolean loop;
  
  public b()
  {
    AppMethodBeat.i(107715);
    this.loop = false;
    this.isStart = false;
    this.hS = false;
    this.LaS = 0;
    this.LaT = 0;
    this.LaQ = new j(Looper.getMainLooper());
    Object localObject = this.LaQ;
    if (((j)localObject).KTe != null)
    {
      localObject = ((j)localObject).KTe;
      if (((k)localObject).KSM != null) {
        ((k)localObject).KSM.KSH = false;
      }
    }
    this.LaQ.setNeedResetExtractor(false);
    this.LaQ.KTf = new d()
    {
      public final void Qz()
      {
        AppMethodBeat.i(107710);
        if (b.this.LaW != null) {
          b.this.LaW.fX(b.this.LaQ);
        }
        if (b.this.isStart) {
          b.this.LaQ.start();
        }
        b.this.hS = true;
        AppMethodBeat.o(107710);
      }
      
      public final void as(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(107714);
        b.this.LaR = paramAnonymousInt3;
        if (b.this.LaV != null) {
          b.this.LaV.aS(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(107714);
      }
      
      public final void dEH()
      {
        AppMethodBeat.i(107713);
        Log.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", new Object[] { b.this.LaX });
        if (b.this.LaX != null)
        {
          b.this.LaX.fY(b.this.LaQ);
          AppMethodBeat.o(107713);
          return;
        }
        if (b.this.isStart) {
          b.this.LaQ.start();
        }
        AppMethodBeat.o(107713);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(107711);
        if (b.this.loop) {
          b.this.LaQ.aaS(b.this.LaS);
        }
        AppMethodBeat.o(107711);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(107712);
        if (b.this.LaU != null) {
          b.this.LaU.jL(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(107712);
      }
    };
    AppMethodBeat.o(107715);
  }
  
  public final void a(a.a parama)
  {
    this.LaU = parama;
  }
  
  public final void a(a.b paramb)
  {
    this.LaW = paramb;
  }
  
  public final void a(a.c paramc)
  {
    this.LaX = paramc;
  }
  
  public final void a(a.d paramd)
  {
    this.LaV = paramd;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(107724);
    int i = this.LaQ.gbM();
    AppMethodBeat.o(107724);
    return i;
  }
  
  public final int getDuration()
  {
    return (int)this.LaQ.KTe.durationMs;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107722);
    boolean bool = this.LaQ.isPlaying();
    AppMethodBeat.o(107722);
    return bool;
  }
  
  public final void jM(int paramInt1, int paramInt2)
  {
    this.LaS = paramInt1;
    this.LaT = paramInt2;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(107721);
    this.LaQ.pause();
    AppMethodBeat.o(107721);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(107718);
    this.LaQ.prepare();
    AppMethodBeat.o(107718);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107725);
    this.LaQ.release();
    AppMethodBeat.o(107725);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(107723);
    if (this.LaQ != null)
    {
      Log.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", new Object[] { Integer.valueOf(paramInt) });
      this.LaQ.aaS(paramInt);
    }
    AppMethodBeat.o(107723);
  }
  
  public final void setAudioStreamType(int paramInt) {}
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(107717);
    this.LaQ.setPath(paramString);
    AppMethodBeat.o(107717);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.loop = paramBoolean;
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(107716);
    this.LaQ.setSurface(paramSurface);
    AppMethodBeat.o(107716);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107719);
    if (this.hS) {
      this.LaQ.start();
    }
    this.isStart = true;
    AppMethodBeat.o(107719);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107720);
    this.LaQ.stop();
    this.isStart = false;
    AppMethodBeat.o(107720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.b
 * JD-Core Version:    0.7.0.1
 */