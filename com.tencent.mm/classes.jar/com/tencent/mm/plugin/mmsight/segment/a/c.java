package com.tencent.mm.plugin.mmsight.segment.a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.ar.a;

public final class c
  implements a
{
  private MTimerHandler jer;
  boolean released;
  int zAo;
  int zAp;
  private a zAv;
  a.c zAw;
  private a.c zAx;
  private MTimerHandler.CallBack zAy;
  public a zzX;
  
  public c()
  {
    AppMethodBeat.i(107728);
    this.zAw = null;
    this.zAx = new a.c()
    {
      public final void dE(Object paramAnonymousObject)
      {
        AppMethodBeat.i(107726);
        if (c.this.zAw != null) {
          c.this.zAw.dE(paramAnonymousObject);
        }
        AppMethodBeat.o(107726);
      }
    };
    this.zAy = new MTimerHandler.CallBack()
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
          if (c.this.zzX != null) {
            c.this.zzX.QR(i);
          }
          Log.d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(c.this.zAo), Integer.valueOf(c.this.zAp), Integer.valueOf(c.this.getDuration()) });
          int j = c.this.zAp;
          if (i < j)
          {
            AppMethodBeat.o(107727);
            return true;
          }
          Log.i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", new Object[] { Integer.valueOf(c.this.zAp) });
          c.this.seekTo(c.this.zAo);
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
    int i = CaptureMMProxy.getInstance().getInt(ar.a.NZj, -1);
    if (i == 1)
    {
      Log.i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
      this.zAv = new d();
    }
    for (;;)
    {
      this.jer = new MTimerHandler("check auto job", this.zAy, true);
      AppMethodBeat.o(107728);
      return;
      if (i == 2)
      {
        Log.i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
        this.zAv = new b();
      }
      else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer())
      {
        Log.i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
        this.zAv = new b();
      }
      else
      {
        Log.i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
        this.zAv = new d();
      }
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(107744);
    this.zAv.a(parama);
    AppMethodBeat.o(107744);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(107746);
    this.zAv.a(paramb);
    AppMethodBeat.o(107746);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(107735);
    this.zAv.a(paramc);
    AppMethodBeat.o(107735);
  }
  
  public final void a(a.d paramd)
  {
    AppMethodBeat.i(107745);
    this.zAv.a(paramd);
    AppMethodBeat.o(107745);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(107737);
    int i = this.zAv.getCurrentPosition();
    AppMethodBeat.o(107737);
    return i;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(107738);
    if (this.zAv != null)
    {
      int i = this.zAv.getDuration();
      AppMethodBeat.o(107738);
      return i;
    }
    AppMethodBeat.o(107738);
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107740);
    boolean bool = this.zAv.isPlaying();
    AppMethodBeat.o(107740);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(107733);
    this.zAv.pause();
    this.jer.stopTimer();
    AppMethodBeat.o(107733);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(107742);
    this.zAv.prepareAsync();
    AppMethodBeat.o(107742);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107731);
    this.released = true;
    this.zAv.release();
    if (this.jer != null)
    {
      this.jer.stopTimer();
      this.jer.quit();
    }
    AppMethodBeat.o(107731);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(107741);
    this.zAv.seekTo(paramInt);
    AppMethodBeat.o(107741);
  }
  
  public final void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(107736);
    this.zAv.setAudioStreamType(paramInt);
    AppMethodBeat.o(107736);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(107730);
    this.zAv.setDataSource(paramString);
    AppMethodBeat.o(107730);
  }
  
  public final void setLoop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107729);
    this.zAo = paramInt1;
    this.zAp = paramInt2;
    if (this.zAv != null) {
      this.zAv.setLoop(this.zAo, this.zAp);
    }
    AppMethodBeat.o(107729);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(107743);
    this.zAv.setLooping(paramBoolean);
    AppMethodBeat.o(107743);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(107739);
    this.zAv.setSurface(paramSurface);
    AppMethodBeat.o(107739);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107732);
    this.zAv.start();
    this.jer.startTimer(30L);
    AppMethodBeat.o(107732);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107734);
    this.zAv.stop();
    this.jer.stopTimer();
    AppMethodBeat.o(107734);
  }
  
  public static abstract interface a
  {
    public abstract void QR(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.c
 * JD-Core Version:    0.7.0.1
 */