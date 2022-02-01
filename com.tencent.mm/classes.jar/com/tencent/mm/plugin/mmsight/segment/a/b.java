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
  boolean WD;
  boolean isStart;
  boolean loop;
  j tIc;
  int tId;
  int tIe;
  private int tIf;
  a.a tIg;
  a.d tIh;
  a.b tIi;
  a.c tIj;
  
  public b()
  {
    AppMethodBeat.i(107715);
    this.loop = false;
    this.isStart = false;
    this.WD = false;
    this.tIe = 0;
    this.tIf = 0;
    this.tIc = new j(Looper.getMainLooper());
    Object localObject = this.tIc;
    if (((j)localObject).tAk != null)
    {
      localObject = ((j)localObject).tAk;
      if (((k)localObject).tzT != null) {
        ((k)localObject).tzT.tzP = false;
      }
    }
    this.tIc.setNeedResetExtractor(false);
    this.tIc.tAl = new d()
    {
      public final void W(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(107714);
        b.this.tId = paramAnonymousInt3;
        if (b.this.tIh != null) {
          b.this.tIh.ai(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(107714);
      }
      
      public final void bYy()
      {
        AppMethodBeat.i(107713);
        ad.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", new Object[] { b.this.tIj });
        if (b.this.tIj != null)
        {
          b.this.tIj.ds(b.this.tIc);
          AppMethodBeat.o(107713);
          return;
        }
        if (b.this.isStart) {
          b.this.tIc.start();
        }
        AppMethodBeat.o(107713);
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(107711);
        if (b.this.loop) {
          b.this.tIc.GI(b.this.tIe);
        }
        AppMethodBeat.o(107711);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(107712);
        if (b.this.tIg != null) {
          b.this.tIg.gd(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(107712);
      }
      
      public final void rq()
      {
        AppMethodBeat.i(107710);
        if (b.this.tIi != null) {
          b.this.tIi.dr(b.this.tIc);
        }
        if (b.this.isStart) {
          b.this.tIc.start();
        }
        b.this.WD = true;
        AppMethodBeat.o(107710);
      }
    };
    AppMethodBeat.o(107715);
  }
  
  public final void a(a.a parama)
  {
    this.tIg = parama;
  }
  
  public final void a(a.b paramb)
  {
    this.tIi = paramb;
  }
  
  public final void a(a.c paramc)
  {
    this.tIj = paramc;
  }
  
  public final void a(a.d paramd)
  {
    this.tIh = paramd;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(107724);
    int i = this.tIc.cPu();
    AppMethodBeat.o(107724);
    return i;
  }
  
  public final int getDuration()
  {
    return (int)this.tIc.tAk.bjp;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107722);
    boolean bool = this.tIc.isPlaying();
    AppMethodBeat.o(107722);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(107721);
    this.tIc.pause();
    AppMethodBeat.o(107721);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(107718);
    this.tIc.cuQ();
    AppMethodBeat.o(107718);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107725);
    this.tIc.release();
    AppMethodBeat.o(107725);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(107723);
    if (this.tIc != null)
    {
      ad.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", new Object[] { Integer.valueOf(paramInt) });
      this.tIc.GI(paramInt);
    }
    AppMethodBeat.o(107723);
  }
  
  public final void setAudioStreamType(int paramInt) {}
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(107717);
    this.tIc.setPath(paramString);
    AppMethodBeat.o(107717);
  }
  
  public final void setLoop(int paramInt1, int paramInt2)
  {
    this.tIe = paramInt1;
    this.tIf = paramInt2;
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.loop = paramBoolean;
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(107716);
    this.tIc.setSurface(paramSurface);
    AppMethodBeat.o(107716);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107719);
    if (this.WD) {
      this.tIc.start();
    }
    this.isStart = true;
    AppMethodBeat.o(107719);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107720);
    this.tIc.stop();
    this.isStart = false;
    AppMethodBeat.o(107720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.b
 * JD-Core Version:    0.7.0.1
 */