package com.tencent.mm.plugin.mmsight.segment.a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.storage.ah.a;

public final class c
  implements a
{
  private au hNn;
  boolean released;
  int uQA;
  int uQB;
  private a uQH;
  a.c uQI;
  private a.c uQJ;
  private au.a uQK;
  public a uQj;
  
  public c()
  {
    AppMethodBeat.i(107728);
    this.uQI = null;
    this.uQJ = new a.c()
    {
      public final void dt(Object paramAnonymousObject)
      {
        AppMethodBeat.i(107726);
        if (c.this.uQI != null) {
          c.this.uQI.dt(paramAnonymousObject);
        }
        AppMethodBeat.o(107726);
      }
    };
    this.uQK = new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(107727);
        if (c.this.released)
        {
          AppMethodBeat.o(107727);
          return false;
        }
        try
        {
          boolean bool = c.this.isPlaying();
          if (!bool)
          {
            AppMethodBeat.o(107727);
            return true;
          }
          int i = c.this.getCurrentPosition();
          if (c.this.uQj != null) {
            c.this.uQj.IU(i);
          }
          ac.d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(c.this.uQA), Integer.valueOf(c.this.uQB), Integer.valueOf(c.this.getDuration()) });
          int j = c.this.uQB;
          if (i < j)
          {
            AppMethodBeat.o(107727);
            return true;
          }
          ac.i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", new Object[] { Integer.valueOf(c.this.uQB) });
          c.this.seekTo(c.this.uQA);
          AppMethodBeat.o(107727);
          return false;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          ac.e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", new Object[] { localIllegalStateException.getMessage() });
          if (!c.this.released)
          {
            AppMethodBeat.o(107727);
            return true;
          }
          AppMethodBeat.o(107727);
        }
        return false;
      }
    };
    int i = CaptureMMProxy.getInstance().getInt(ah.a.GKr, -1);
    if (i == 1)
    {
      ac.i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
      this.uQH = new d();
    }
    for (;;)
    {
      this.hNn = new au("check auto job", this.uQK, true);
      AppMethodBeat.o(107728);
      return;
      if (i == 2)
      {
        ac.i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
        this.uQH = new b();
      }
      else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer())
      {
        ac.i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
        this.uQH = new b();
      }
      else
      {
        ac.i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
        this.uQH = new d();
      }
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(107744);
    this.uQH.a(parama);
    AppMethodBeat.o(107744);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(107746);
    this.uQH.a(paramb);
    AppMethodBeat.o(107746);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(107735);
    this.uQH.a(paramc);
    AppMethodBeat.o(107735);
  }
  
  public final void a(a.d paramd)
  {
    AppMethodBeat.i(107745);
    this.uQH.a(paramd);
    AppMethodBeat.o(107745);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(107737);
    int i = this.uQH.getCurrentPosition();
    AppMethodBeat.o(107737);
    return i;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(107738);
    if (this.uQH != null)
    {
      int i = this.uQH.getDuration();
      AppMethodBeat.o(107738);
      return i;
    }
    AppMethodBeat.o(107738);
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107740);
    boolean bool = this.uQH.isPlaying();
    AppMethodBeat.o(107740);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(107733);
    this.uQH.pause();
    this.hNn.stopTimer();
    AppMethodBeat.o(107733);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(107742);
    this.uQH.prepareAsync();
    AppMethodBeat.o(107742);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107731);
    this.released = true;
    this.uQH.release();
    if (this.hNn != null)
    {
      this.hNn.stopTimer();
      this.hNn.quit();
    }
    AppMethodBeat.o(107731);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(107741);
    this.uQH.seekTo(paramInt);
    AppMethodBeat.o(107741);
  }
  
  public final void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(107736);
    this.uQH.setAudioStreamType(paramInt);
    AppMethodBeat.o(107736);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(107730);
    this.uQH.setDataSource(paramString);
    AppMethodBeat.o(107730);
  }
  
  public final void setLoop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107729);
    this.uQA = paramInt1;
    this.uQB = paramInt2;
    if (this.uQH != null) {
      this.uQH.setLoop(this.uQA, this.uQB);
    }
    AppMethodBeat.o(107729);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(107743);
    this.uQH.setLooping(paramBoolean);
    AppMethodBeat.o(107743);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(107739);
    this.uQH.setSurface(paramSurface);
    AppMethodBeat.o(107739);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107732);
    this.uQH.start();
    this.hNn.au(30L, 30L);
    AppMethodBeat.o(107732);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107734);
    this.uQH.stop();
    this.hNn.stopTimer();
    AppMethodBeat.o(107734);
  }
  
  public static abstract interface a
  {
    public abstract void IU(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.c
 * JD-Core Version:    0.7.0.1
 */