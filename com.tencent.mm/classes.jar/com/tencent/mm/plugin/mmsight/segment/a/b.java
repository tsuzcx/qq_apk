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
  j Ffh;
  int Ffi;
  int Ffj;
  private int Ffk;
  a.a Ffl;
  a.d Ffm;
  a.b Ffn;
  a.c Ffo;
  boolean gX;
  boolean isStart;
  boolean loop;
  
  public b()
  {
    AppMethodBeat.i(107715);
    this.loop = false;
    this.isStart = false;
    this.gX = false;
    this.Ffj = 0;
    this.Ffk = 0;
    this.Ffh = new j(Looper.getMainLooper());
    Object localObject = this.Ffh;
    if (((j)localObject).EXt != null)
    {
      localObject = ((j)localObject).EXt;
      if (((k)localObject).EXa != null) {
        ((k)localObject).EXa.EWV = false;
      }
    }
    this.Ffh.setNeedResetExtractor(false);
    this.Ffh.EXu = new d()
    {
      public final void ab(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(107714);
        b.this.Ffi = paramAnonymousInt3;
        if (b.this.Ffm != null) {
          b.this.Ffm.au(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(107714);
      }
      
      public final void cYp()
      {
        AppMethodBeat.i(107713);
        Log.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", new Object[] { b.this.Ffo });
        if (b.this.Ffo != null)
        {
          b.this.Ffo.dH(b.this.Ffh);
          AppMethodBeat.o(107713);
          return;
        }
        if (b.this.isStart) {
          b.this.Ffh.start();
        }
        AppMethodBeat.o(107713);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(107711);
        if (b.this.loop) {
          b.this.Ffh.WQ(b.this.Ffj);
        }
        AppMethodBeat.o(107711);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(107712);
        if (b.this.Ffl != null) {
          b.this.Ffl.ig(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(107712);
      }
      
      public final void qX()
      {
        AppMethodBeat.i(107710);
        if (b.this.Ffn != null) {
          b.this.Ffn.dG(b.this.Ffh);
        }
        if (b.this.isStart) {
          b.this.Ffh.start();
        }
        b.this.gX = true;
        AppMethodBeat.o(107710);
      }
    };
    AppMethodBeat.o(107715);
  }
  
  public final void a(a.a parama)
  {
    this.Ffl = parama;
  }
  
  public final void a(a.b paramb)
  {
    this.Ffn = paramb;
  }
  
  public final void a(a.c paramc)
  {
    this.Ffo = paramc;
  }
  
  public final void a(a.d paramd)
  {
    this.Ffm = paramd;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(107724);
    int i = this.Ffh.eST();
    AppMethodBeat.o(107724);
    return i;
  }
  
  public final int getDuration()
  {
    return (int)this.Ffh.EXt.durationMs;
  }
  
  public final void ih(int paramInt1, int paramInt2)
  {
    this.Ffj = paramInt1;
    this.Ffk = paramInt2;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107722);
    boolean bool = this.Ffh.isPlaying();
    AppMethodBeat.o(107722);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(107721);
    this.Ffh.pause();
    AppMethodBeat.o(107721);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(107718);
    this.Ffh.prepare();
    AppMethodBeat.o(107718);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107725);
    this.Ffh.release();
    AppMethodBeat.o(107725);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(107723);
    if (this.Ffh != null)
    {
      Log.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", new Object[] { Integer.valueOf(paramInt) });
      this.Ffh.WQ(paramInt);
    }
    AppMethodBeat.o(107723);
  }
  
  public final void setAudioStreamType(int paramInt) {}
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(107717);
    this.Ffh.setPath(paramString);
    AppMethodBeat.o(107717);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.loop = paramBoolean;
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(107716);
    this.Ffh.setSurface(paramSurface);
    AppMethodBeat.o(107716);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107719);
    if (this.gX) {
      this.Ffh.start();
    }
    this.isStart = true;
    AppMethodBeat.o(107719);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107720);
    this.Ffh.stop();
    this.isStart = false;
    AppMethodBeat.o(107720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.b
 * JD-Core Version:    0.7.0.1
 */