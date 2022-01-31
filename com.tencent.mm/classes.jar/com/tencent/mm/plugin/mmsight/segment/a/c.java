package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;

public final class c
  implements a
{
  private am etU;
  int mnM;
  int mnN;
  private a mnT;
  private HandlerThread mnU = e.ds("check auto job", 10);
  a.c mnV = null;
  private a.c mnW = new c.1(this);
  private am.a mnX = new c.2(this);
  public c.a mnu;
  boolean released;
  
  public c()
  {
    int i = CaptureMMProxy.getInstance().getInt(ac.a.utY, -1);
    if (i == 1)
    {
      y.i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
      this.mnT = new d();
    }
    for (;;)
    {
      this.mnU.start();
      this.etU = new am(this.mnU.getLooper(), this.mnX, true);
      return;
      if (i == 2)
      {
        y.i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
        this.mnT = new b();
      }
      else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer())
      {
        y.i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
        this.mnT = new b();
      }
      else
      {
        y.i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
        this.mnT = new d();
      }
    }
  }
  
  public final void a(a.a parama)
  {
    this.mnT.a(parama);
  }
  
  public final void a(a.b paramb)
  {
    this.mnT.a(paramb);
  }
  
  public final void a(a.c paramc)
  {
    this.mnT.a(paramc);
  }
  
  public final void a(a.d paramd)
  {
    this.mnT.a(paramd);
  }
  
  public final int getCurrentPosition()
  {
    return this.mnT.getCurrentPosition();
  }
  
  public final int getDuration()
  {
    if (this.mnT != null) {
      return this.mnT.getDuration();
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    return this.mnT.isPlaying();
  }
  
  public final void pause()
  {
    this.mnT.pause();
    this.etU.stopTimer();
  }
  
  public final void prepareAsync()
  {
    this.mnT.prepareAsync();
  }
  
  public final void release()
  {
    this.released = true;
    this.mnT.release();
    if (this.etU != null) {
      this.etU.stopTimer();
    }
    if (this.mnU != null) {
      this.mnU.quit();
    }
  }
  
  public final void seekTo(int paramInt)
  {
    this.mnT.seekTo(paramInt);
  }
  
  public final void setAudioStreamType(int paramInt)
  {
    this.mnT.setAudioStreamType(paramInt);
  }
  
  public final void setDataSource(String paramString)
  {
    this.mnT.setDataSource(paramString);
  }
  
  public final void setLoop(int paramInt1, int paramInt2)
  {
    this.mnM = paramInt1;
    this.mnN = paramInt2;
    if (this.mnT != null) {
      this.mnT.setLoop(this.mnM, this.mnN);
    }
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.mnT.setLooping(paramBoolean);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    this.mnT.setSurface(paramSurface);
  }
  
  public final void start()
  {
    this.mnT.start();
    this.etU.S(30L, 30L);
  }
  
  public final void stop()
  {
    this.mnT.stop();
    this.etU.stopTimer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.c
 * JD-Core Version:    0.7.0.1
 */