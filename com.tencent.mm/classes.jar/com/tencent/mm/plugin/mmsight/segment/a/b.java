package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.d;
import com.tencent.mm.plugin.n.j;
import com.tencent.mm.plugin.n.k;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  implements a
{
  boolean ZA;
  boolean isStart;
  boolean loop;
  j zAm;
  int zAn;
  int zAo;
  private int zAp;
  a.a zAq;
  a.d zAr;
  a.b zAs;
  a.c zAt;
  
  public b()
  {
    AppMethodBeat.i(107715);
    this.loop = false;
    this.isStart = false;
    this.ZA = false;
    this.zAo = 0;
    this.zAp = 0;
    this.zAm = new j(Looper.getMainLooper());
    Object localObject = this.zAm;
    if (((j)localObject).zrS != null)
    {
      localObject = ((j)localObject).zrS;
      if (((k)localObject).zrC != null) {
        ((k)localObject).zrC.zrx = false;
      }
    }
    this.zAm.setNeedResetExtractor(false);
    this.zAm.zrT = new d()
    {
      public final void aa(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(107714);
        b.this.zAn = paramAnonymousInt3;
        if (b.this.zAr != null) {
          b.this.zAr.ap(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(107714);
      }
      
      public final void cJH()
      {
        AppMethodBeat.i(107713);
        Log.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", new Object[] { b.this.zAt });
        if (b.this.zAt != null)
        {
          b.this.zAt.dE(b.this.zAm);
          AppMethodBeat.o(107713);
          return;
        }
        if (b.this.isStart) {
          b.this.zAm.start();
        }
        AppMethodBeat.o(107713);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(107711);
        if (b.this.loop) {
          b.this.zAm.QC(b.this.zAo);
        }
        AppMethodBeat.o(107711);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(107712);
        if (b.this.zAq != null) {
          b.this.zAq.hc(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(107712);
      }
      
      public final void tf()
      {
        AppMethodBeat.i(107710);
        if (b.this.zAs != null) {
          b.this.zAs.dD(b.this.zAm);
        }
        if (b.this.isStart) {
          b.this.zAm.start();
        }
        b.this.ZA = true;
        AppMethodBeat.o(107710);
      }
    };
    AppMethodBeat.o(107715);
  }
  
  public final void a(a.a parama)
  {
    this.zAq = parama;
  }
  
  public final void a(a.b paramb)
  {
    this.zAs = paramb;
  }
  
  public final void a(a.c paramc)
  {
    this.zAt = paramc;
  }
  
  public final void a(a.d paramd)
  {
    this.zAr = paramd;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(107724);
    int i = this.zAm.ejm();
    AppMethodBeat.o(107724);
    return i;
  }
  
  public final int getDuration()
  {
    return (int)this.zAm.zrS.durationMs;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107722);
    boolean bool = this.zAm.isPlaying();
    AppMethodBeat.o(107722);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(107721);
    this.zAm.pause();
    AppMethodBeat.o(107721);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(107718);
    this.zAm.prepare();
    AppMethodBeat.o(107718);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107725);
    this.zAm.release();
    AppMethodBeat.o(107725);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(107723);
    if (this.zAm != null)
    {
      Log.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", new Object[] { Integer.valueOf(paramInt) });
      this.zAm.QC(paramInt);
    }
    AppMethodBeat.o(107723);
  }
  
  public final void setAudioStreamType(int paramInt) {}
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(107717);
    this.zAm.setPath(paramString);
    AppMethodBeat.o(107717);
  }
  
  public final void setLoop(int paramInt1, int paramInt2)
  {
    this.zAo = paramInt1;
    this.zAp = paramInt2;
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.loop = paramBoolean;
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(107716);
    this.zAm.setSurface(paramSurface);
    AppMethodBeat.o(107716);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107719);
    if (this.ZA) {
      this.zAm.start();
    }
    this.isStart = true;
    AppMethodBeat.o(107719);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107720);
    this.zAm.stop();
    this.isStart = false;
    AppMethodBeat.o(107720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.b
 * JD-Core Version:    0.7.0.1
 */