package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.o.d;
import com.tencent.mm.plugin.o.j;
import com.tencent.mm.plugin.o.k;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  implements a
{
  boolean Zn;
  boolean isStart;
  boolean loop;
  j wfM;
  int wfN;
  int wfO;
  private int wfP;
  a.a wfQ;
  a.d wfR;
  a.b wfS;
  a.c wfT;
  
  public b()
  {
    AppMethodBeat.i(107715);
    this.loop = false;
    this.isStart = false;
    this.Zn = false;
    this.wfO = 0;
    this.wfP = 0;
    this.wfM = new j(Looper.getMainLooper());
    Object localObject = this.wfM;
    if (((j)localObject).vXQ != null)
    {
      localObject = ((j)localObject).vXQ;
      if (((k)localObject).vXA != null) {
        ((k)localObject).vXA.vXv = false;
      }
    }
    this.wfM.setNeedResetExtractor(false);
    this.wfM.vXR = new d()
    {
      public final void Z(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(107714);
        b.this.wfN = paramAnonymousInt3;
        if (b.this.wfR != null) {
          b.this.wfR.ak(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(107714);
      }
      
      public final void clF()
      {
        AppMethodBeat.i(107713);
        ae.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", new Object[] { b.this.wfT });
        if (b.this.wfT != null)
        {
          b.this.wfT.dx(b.this.wfM);
          AppMethodBeat.o(107713);
          return;
        }
        if (b.this.isStart) {
          b.this.wfM.start();
        }
        AppMethodBeat.o(107713);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(107711);
        if (b.this.loop) {
          b.this.wfM.KB(b.this.wfO);
        }
        AppMethodBeat.o(107711);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(107712);
        if (b.this.wfQ != null) {
          b.this.wfQ.gB(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(107712);
      }
      
      public final void ta()
      {
        AppMethodBeat.i(107710);
        if (b.this.wfS != null) {
          b.this.wfS.dw(b.this.wfM);
        }
        if (b.this.isStart) {
          b.this.wfM.start();
        }
        b.this.Zn = true;
        AppMethodBeat.o(107710);
      }
    };
    AppMethodBeat.o(107715);
  }
  
  public final void a(a.a parama)
  {
    this.wfQ = parama;
  }
  
  public final void a(a.b paramb)
  {
    this.wfS = paramb;
  }
  
  public final void a(a.c paramc)
  {
    this.wfT = paramc;
  }
  
  public final void a(a.d paramd)
  {
    this.wfR = paramd;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(107724);
    int i = this.wfM.dpx();
    AppMethodBeat.o(107724);
    return i;
  }
  
  public final int getDuration()
  {
    return (int)this.wfM.vXQ.bup;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107722);
    boolean bool = this.wfM.isPlaying();
    AppMethodBeat.o(107722);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(107721);
    this.wfM.pause();
    AppMethodBeat.o(107721);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(107718);
    this.wfM.cSW();
    AppMethodBeat.o(107718);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107725);
    this.wfM.release();
    AppMethodBeat.o(107725);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(107723);
    if (this.wfM != null)
    {
      ae.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", new Object[] { Integer.valueOf(paramInt) });
      this.wfM.KB(paramInt);
    }
    AppMethodBeat.o(107723);
  }
  
  public final void setAudioStreamType(int paramInt) {}
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(107717);
    this.wfM.setPath(paramString);
    AppMethodBeat.o(107717);
  }
  
  public final void setLoop(int paramInt1, int paramInt2)
  {
    this.wfO = paramInt1;
    this.wfP = paramInt2;
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.loop = paramBoolean;
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(107716);
    this.wfM.setSurface(paramSurface);
    AppMethodBeat.o(107716);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107719);
    if (this.Zn) {
      this.wfM.start();
    }
    this.isStart = true;
    AppMethodBeat.o(107719);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107720);
    this.wfM.stop();
    this.isStart = false;
    AppMethodBeat.o(107720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.b
 * JD-Core Version:    0.7.0.1
 */