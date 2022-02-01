package com.tencent.mm.plugin.mmsight.segment.a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.am.a;

public final class c
  implements a
{
  private aw ijv;
  boolean released;
  int wfO;
  int wfP;
  private a wfV;
  a.c wfW;
  private a.c wfX;
  private aw.a wfY;
  public a wfx;
  
  public c()
  {
    AppMethodBeat.i(107728);
    this.wfW = null;
    this.wfX = new a.c()
    {
      public final void dx(Object paramAnonymousObject)
      {
        AppMethodBeat.i(107726);
        if (c.this.wfW != null) {
          c.this.wfW.dx(paramAnonymousObject);
        }
        AppMethodBeat.o(107726);
      }
    };
    this.wfY = new aw.a()
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
          if (c.this.wfx != null) {
            c.this.wfx.KR(i);
          }
          ae.d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(c.this.wfO), Integer.valueOf(c.this.wfP), Integer.valueOf(c.this.getDuration()) });
          int j = c.this.wfP;
          if (i < j)
          {
            AppMethodBeat.o(107727);
            return true;
          }
          ae.i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", new Object[] { Integer.valueOf(c.this.wfP) });
          c.this.seekTo(c.this.wfO);
          AppMethodBeat.o(107727);
          return false;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          ae.e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", new Object[] { localIllegalStateException.getMessage() });
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
    int i = CaptureMMProxy.getInstance().getInt(am.a.IRh, -1);
    if (i == 1)
    {
      ae.i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
      this.wfV = new d();
    }
    for (;;)
    {
      this.ijv = new aw("check auto job", this.wfY, true);
      AppMethodBeat.o(107728);
      return;
      if (i == 2)
      {
        ae.i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
        this.wfV = new b();
      }
      else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer())
      {
        ae.i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
        this.wfV = new b();
      }
      else
      {
        ae.i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
        this.wfV = new d();
      }
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(107744);
    this.wfV.a(parama);
    AppMethodBeat.o(107744);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(107746);
    this.wfV.a(paramb);
    AppMethodBeat.o(107746);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(107735);
    this.wfV.a(paramc);
    AppMethodBeat.o(107735);
  }
  
  public final void a(a.d paramd)
  {
    AppMethodBeat.i(107745);
    this.wfV.a(paramd);
    AppMethodBeat.o(107745);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(107737);
    int i = this.wfV.getCurrentPosition();
    AppMethodBeat.o(107737);
    return i;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(107738);
    if (this.wfV != null)
    {
      int i = this.wfV.getDuration();
      AppMethodBeat.o(107738);
      return i;
    }
    AppMethodBeat.o(107738);
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107740);
    boolean bool = this.wfV.isPlaying();
    AppMethodBeat.o(107740);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(107733);
    this.wfV.pause();
    this.ijv.stopTimer();
    AppMethodBeat.o(107733);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(107742);
    this.wfV.prepareAsync();
    AppMethodBeat.o(107742);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107731);
    this.released = true;
    this.wfV.release();
    if (this.ijv != null)
    {
      this.ijv.stopTimer();
      this.ijv.quit();
    }
    AppMethodBeat.o(107731);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(107741);
    this.wfV.seekTo(paramInt);
    AppMethodBeat.o(107741);
  }
  
  public final void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(107736);
    this.wfV.setAudioStreamType(paramInt);
    AppMethodBeat.o(107736);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(107730);
    this.wfV.setDataSource(paramString);
    AppMethodBeat.o(107730);
  }
  
  public final void setLoop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107729);
    this.wfO = paramInt1;
    this.wfP = paramInt2;
    if (this.wfV != null) {
      this.wfV.setLoop(this.wfO, this.wfP);
    }
    AppMethodBeat.o(107729);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(107743);
    this.wfV.setLooping(paramBoolean);
    AppMethodBeat.o(107743);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(107739);
    this.wfV.setSurface(paramSurface);
    AppMethodBeat.o(107739);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107732);
    this.wfV.start();
    this.ijv.ay(30L, 30L);
    AppMethodBeat.o(107732);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107734);
    this.wfV.stop();
    this.ijv.stopTimer();
    AppMethodBeat.o(107734);
  }
  
  public static abstract interface a
  {
    public abstract void KR(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.c
 * JD-Core Version:    0.7.0.1
 */