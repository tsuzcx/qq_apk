package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.i;
import com.tencent.mm.plugin.n.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  implements a
{
  boolean Pz;
  boolean fqY;
  boolean isStart;
  i oMS;
  int oMT;
  int oMU;
  private int oMV;
  a.a oMW;
  a.d oMX;
  a.b oMY;
  a.c oMZ;
  
  public b()
  {
    AppMethodBeat.i(3713);
    this.fqY = false;
    this.isStart = false;
    this.Pz = false;
    this.oMU = 0;
    this.oMV = 0;
    this.oMS = new i(Looper.getMainLooper());
    Object localObject = this.oMS;
    if (((i)localObject).oFd != null)
    {
      localObject = ((i)localObject).oFd;
      if (((j)localObject).oEN != null) {
        ((j)localObject).oEN.oEJ = false;
      }
    }
    this.oMS.setNeedResetExtractor(false);
    this.oMS.oFe = new b.1(this);
    AppMethodBeat.o(3713);
  }
  
  public final void a(a.a parama)
  {
    this.oMW = parama;
  }
  
  public final void a(a.b paramb)
  {
    this.oMY = paramb;
  }
  
  public final void a(a.c paramc)
  {
    this.oMZ = paramc;
  }
  
  public final void a(a.d paramd)
  {
    this.oMX = paramd;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(3722);
    int i = this.oMS.bQz();
    AppMethodBeat.o(3722);
    return i;
  }
  
  public final int getDuration()
  {
    return (int)this.oMS.oFd.aNP;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(3720);
    boolean bool = this.oMS.isPlaying();
    AppMethodBeat.o(3720);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(3719);
    this.oMS.pause();
    AppMethodBeat.o(3719);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(3716);
    this.oMS.prepare();
    AppMethodBeat.o(3716);
  }
  
  public final void release()
  {
    AppMethodBeat.i(3723);
    this.oMS.release();
    AppMethodBeat.o(3723);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(3721);
    if (this.oMS != null)
    {
      ab.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", new Object[] { Integer.valueOf(paramInt) });
      this.oMS.zi(paramInt);
    }
    AppMethodBeat.o(3721);
  }
  
  public final void setAudioStreamType(int paramInt) {}
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(3715);
    this.oMS.setPath(paramString);
    AppMethodBeat.o(3715);
  }
  
  public final void setLoop(int paramInt1, int paramInt2)
  {
    this.oMU = paramInt1;
    this.oMV = paramInt2;
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.fqY = paramBoolean;
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(3714);
    this.oMS.setSurface(paramSurface);
    AppMethodBeat.o(3714);
  }
  
  public final void start()
  {
    AppMethodBeat.i(3717);
    if (this.Pz) {
      this.oMS.start();
    }
    this.isStart = true;
    AppMethodBeat.o(3717);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(3718);
    this.oMS.oFd.stop();
    this.isStart = false;
    AppMethodBeat.o(3718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.b
 * JD-Core Version:    0.7.0.1
 */