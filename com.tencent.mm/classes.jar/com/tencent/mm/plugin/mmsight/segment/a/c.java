package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.ac.a;

public final class c
  implements a
{
  private ap fJH;
  public c.a oMC;
  int oMU;
  int oMV;
  private a oNb;
  private HandlerThread oNc;
  a.c oNd;
  private a.c oNe;
  private ap.a oNf;
  boolean released;
  
  public c()
  {
    AppMethodBeat.i(3726);
    this.oNc = com.tencent.mm.sdk.g.d.ey("check auto job", 10);
    this.oNd = null;
    this.oNe = new c.1(this);
    this.oNf = new c.2(this);
    int i = CaptureMMProxy.getInstance().getInt(ac.a.yEb, -1);
    if (i == 1)
    {
      ab.i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
      this.oNb = new d();
    }
    for (;;)
    {
      this.oNc.start();
      this.fJH = new ap(this.oNc.getLooper(), this.oNf, true);
      AppMethodBeat.o(3726);
      return;
      if (i == 2)
      {
        ab.i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
        this.oNb = new b();
      }
      else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer())
      {
        ab.i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
        this.oNb = new b();
      }
      else
      {
        ab.i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
        this.oNb = new d();
      }
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(3742);
    this.oNb.a(parama);
    AppMethodBeat.o(3742);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(3744);
    this.oNb.a(paramb);
    AppMethodBeat.o(3744);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(3733);
    this.oNb.a(paramc);
    AppMethodBeat.o(3733);
  }
  
  public final void a(a.d paramd)
  {
    AppMethodBeat.i(3743);
    this.oNb.a(paramd);
    AppMethodBeat.o(3743);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(3735);
    int i = this.oNb.getCurrentPosition();
    AppMethodBeat.o(3735);
    return i;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(3736);
    if (this.oNb != null)
    {
      int i = this.oNb.getDuration();
      AppMethodBeat.o(3736);
      return i;
    }
    AppMethodBeat.o(3736);
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(3738);
    boolean bool = this.oNb.isPlaying();
    AppMethodBeat.o(3738);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(3731);
    this.oNb.pause();
    this.fJH.stopTimer();
    AppMethodBeat.o(3731);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(3740);
    this.oNb.prepareAsync();
    AppMethodBeat.o(3740);
  }
  
  public final void release()
  {
    AppMethodBeat.i(3729);
    this.released = true;
    this.oNb.release();
    if (this.fJH != null) {
      this.fJH.stopTimer();
    }
    if (this.oNc != null) {
      this.oNc.quit();
    }
    AppMethodBeat.o(3729);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(3739);
    this.oNb.seekTo(paramInt);
    AppMethodBeat.o(3739);
  }
  
  public final void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(3734);
    this.oNb.setAudioStreamType(paramInt);
    AppMethodBeat.o(3734);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(3728);
    this.oNb.setDataSource(paramString);
    AppMethodBeat.o(3728);
  }
  
  public final void setLoop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3727);
    this.oMU = paramInt1;
    this.oMV = paramInt2;
    if (this.oNb != null) {
      this.oNb.setLoop(this.oMU, this.oMV);
    }
    AppMethodBeat.o(3727);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(3741);
    this.oNb.setLooping(paramBoolean);
    AppMethodBeat.o(3741);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(3737);
    this.oNb.setSurface(paramSurface);
    AppMethodBeat.o(3737);
  }
  
  public final void start()
  {
    AppMethodBeat.i(3730);
    this.oNb.start();
    this.fJH.ag(30L, 30L);
    AppMethodBeat.o(3730);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(3732);
    this.oNb.stop();
    this.fJH.stopTimer();
    AppMethodBeat.o(3732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.c
 * JD-Core Version:    0.7.0.1
 */