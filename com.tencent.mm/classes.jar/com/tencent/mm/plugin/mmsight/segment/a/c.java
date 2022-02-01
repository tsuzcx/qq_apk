package com.tencent.mm.plugin.mmsight.segment.a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.at.a;

public final class c
  implements a
{
  public a LaA;
  int LaS;
  int LaT;
  private a LaZ;
  a.c Lba;
  private a.c Lbb;
  private MTimerHandler.CallBack Lbc;
  private MTimerHandler oNL;
  boolean released;
  
  public c()
  {
    AppMethodBeat.i(107728);
    this.Lba = null;
    this.Lbb = new a.c()
    {
      public final void fY(Object paramAnonymousObject)
      {
        AppMethodBeat.i(107726);
        if (c.this.Lba != null) {
          c.this.Lba.fY(paramAnonymousObject);
        }
        AppMethodBeat.o(107726);
      }
    };
    this.Lbc = new MTimerHandler.CallBack()
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
          if (c.this.LaA != null) {
            c.this.LaA.abh(i);
          }
          Log.d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(c.this.LaS), Integer.valueOf(c.this.LaT), Integer.valueOf(c.this.getDuration()) });
          int j = c.this.LaT;
          if (i < j)
          {
            AppMethodBeat.o(107727);
            return true;
          }
          Log.i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", new Object[] { Integer.valueOf(c.this.LaT) });
          c.this.seekTo(c.this.LaS);
          AppMethodBeat.o(107727);
          return false;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          Log.e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", new Object[] { localIllegalStateException.getMessage() });
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
    int i = CaptureMMProxy.getInstance().getInt(at.a.acOE, -1);
    if (i == 1)
    {
      Log.i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
      this.LaZ = new d();
    }
    for (;;)
    {
      this.oNL = new MTimerHandler("check auto job", this.Lbc, true);
      AppMethodBeat.o(107728);
      return;
      if (i == 2)
      {
        Log.i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
        this.LaZ = new b();
      }
      else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer())
      {
        Log.i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
        this.LaZ = new b();
      }
      else
      {
        Log.i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
        this.LaZ = new d();
      }
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(107744);
    this.LaZ.a(parama);
    AppMethodBeat.o(107744);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(107746);
    this.LaZ.a(paramb);
    AppMethodBeat.o(107746);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(107735);
    this.LaZ.a(paramc);
    AppMethodBeat.o(107735);
  }
  
  public final void a(a.d paramd)
  {
    AppMethodBeat.i(107745);
    this.LaZ.a(paramd);
    AppMethodBeat.o(107745);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(107737);
    int i = this.LaZ.getCurrentPosition();
    AppMethodBeat.o(107737);
    return i;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(107738);
    if (this.LaZ != null)
    {
      int i = this.LaZ.getDuration();
      AppMethodBeat.o(107738);
      return i;
    }
    AppMethodBeat.o(107738);
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107740);
    boolean bool = this.LaZ.isPlaying();
    AppMethodBeat.o(107740);
    return bool;
  }
  
  public final void jM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107729);
    this.LaS = paramInt1;
    this.LaT = paramInt2;
    if (this.LaZ != null) {
      this.LaZ.jM(this.LaS, this.LaT);
    }
    AppMethodBeat.o(107729);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(107733);
    this.LaZ.pause();
    this.oNL.stopTimer();
    AppMethodBeat.o(107733);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(107742);
    this.LaZ.prepareAsync();
    AppMethodBeat.o(107742);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107731);
    this.released = true;
    this.LaZ.release();
    if (this.oNL != null)
    {
      this.oNL.stopTimer();
      this.oNL.quit();
    }
    AppMethodBeat.o(107731);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(107741);
    this.LaZ.seekTo(paramInt);
    AppMethodBeat.o(107741);
  }
  
  public final void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(107736);
    this.LaZ.setAudioStreamType(paramInt);
    AppMethodBeat.o(107736);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(107730);
    this.LaZ.setDataSource(paramString);
    AppMethodBeat.o(107730);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(107743);
    this.LaZ.setLooping(paramBoolean);
    AppMethodBeat.o(107743);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(107739);
    this.LaZ.setSurface(paramSurface);
    AppMethodBeat.o(107739);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107732);
    this.LaZ.start();
    this.oNL.startTimer(30L);
    AppMethodBeat.o(107732);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107734);
    this.LaZ.stop();
    this.oNL.stopTimer();
    AppMethodBeat.o(107734);
  }
  
  public static abstract interface a
  {
    public abstract void abh(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.c
 * JD-Core Version:    0.7.0.1
 */