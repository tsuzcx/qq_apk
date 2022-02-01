package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.o.d;
import com.tencent.mm.plugin.o.j;
import com.tencent.mm.plugin.o.k;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  implements a
{
  boolean Zn;
  boolean isStart;
  boolean loop;
  j vTI;
  int vTJ;
  int vTK;
  private int vTL;
  a.a vTM;
  a.d vTN;
  a.b vTO;
  a.c vTP;
  
  public b()
  {
    AppMethodBeat.i(107715);
    this.loop = false;
    this.isStart = false;
    this.Zn = false;
    this.vTK = 0;
    this.vTL = 0;
    this.vTI = new j(Looper.getMainLooper());
    Object localObject = this.vTI;
    if (((j)localObject).vLM != null)
    {
      localObject = ((j)localObject).vLM;
      if (((k)localObject).vLw != null) {
        ((k)localObject).vLw.vLr = false;
      }
    }
    this.vTI.setNeedResetExtractor(false);
    this.vTI.vLN = new d()
    {
      public final void Z(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(107714);
        b.this.vTJ = paramAnonymousInt3;
        if (b.this.vTN != null) {
          b.this.vTN.ak(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(107714);
      }
      
      public final void ckp()
      {
        AppMethodBeat.i(107713);
        ad.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", new Object[] { b.this.vTP });
        if (b.this.vTP != null)
        {
          b.this.vTP.dw(b.this.vTI);
          AppMethodBeat.o(107713);
          return;
        }
        if (b.this.isStart) {
          b.this.vTI.start();
        }
        AppMethodBeat.o(107713);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(107711);
        if (b.this.loop) {
          b.this.vTI.Kb(b.this.vTK);
        }
        AppMethodBeat.o(107711);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(107712);
        if (b.this.vTM != null) {
          b.this.vTM.gB(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(107712);
      }
      
      public final void ta()
      {
        AppMethodBeat.i(107710);
        if (b.this.vTO != null) {
          b.this.vTO.dv(b.this.vTI);
        }
        if (b.this.isStart) {
          b.this.vTI.start();
        }
        b.this.Zn = true;
        AppMethodBeat.o(107710);
      }
    };
    AppMethodBeat.o(107715);
  }
  
  public final void a(a.a parama)
  {
    this.vTM = parama;
  }
  
  public final void a(a.b paramb)
  {
    this.vTO = paramb;
  }
  
  public final void a(a.c paramc)
  {
    this.vTP = paramc;
  }
  
  public final void a(a.d paramd)
  {
    this.vTN = paramd;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(107724);
    int i = this.vTI.dmz();
    AppMethodBeat.o(107724);
    return i;
  }
  
  public final int getDuration()
  {
    return (int)this.vTI.vLM.bup;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107722);
    boolean bool = this.vTI.isPlaying();
    AppMethodBeat.o(107722);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(107721);
    this.vTI.pause();
    AppMethodBeat.o(107721);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(107718);
    this.vTI.cQr();
    AppMethodBeat.o(107718);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107725);
    this.vTI.release();
    AppMethodBeat.o(107725);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(107723);
    if (this.vTI != null)
    {
      ad.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", new Object[] { Integer.valueOf(paramInt) });
      this.vTI.Kb(paramInt);
    }
    AppMethodBeat.o(107723);
  }
  
  public final void setAudioStreamType(int paramInt) {}
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(107717);
    this.vTI.setPath(paramString);
    AppMethodBeat.o(107717);
  }
  
  public final void setLoop(int paramInt1, int paramInt2)
  {
    this.vTK = paramInt1;
    this.vTL = paramInt2;
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.loop = paramBoolean;
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(107716);
    this.vTI.setSurface(paramSurface);
    AppMethodBeat.o(107716);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107719);
    if (this.Zn) {
      this.vTI.start();
    }
    this.isStart = true;
    AppMethodBeat.o(107719);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107720);
    this.vTI.stop();
    this.isStart = false;
    AppMethodBeat.o(107720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.b
 * JD-Core Version:    0.7.0.1
 */