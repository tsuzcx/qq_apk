package com.tencent.mm.plugin.mmsight.segment.a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.ae.a;

public final class c
  implements a
{
  private av hmK;
  boolean released;
  public a tHN;
  int tIe;
  int tIf;
  private a tIl;
  a.c tIm;
  private a.c tIn;
  private av.a tIo;
  
  public c()
  {
    AppMethodBeat.i(107728);
    this.tIm = null;
    this.tIn = new a.c()
    {
      public final void ds(Object paramAnonymousObject)
      {
        AppMethodBeat.i(107726);
        if (c.this.tIm != null) {
          c.this.tIm.ds(paramAnonymousObject);
        }
        AppMethodBeat.o(107726);
      }
    };
    this.tIo = new av.a()
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
          if (c.this.tHN != null) {
            c.this.tHN.GY(i);
          }
          ad.d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(c.this.tIe), Integer.valueOf(c.this.tIf), Integer.valueOf(c.this.getDuration()) });
          int j = c.this.tIf;
          if (i < j)
          {
            AppMethodBeat.o(107727);
            return true;
          }
          ad.i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", new Object[] { Integer.valueOf(c.this.tIf) });
          c.this.seekTo(c.this.tIe);
          AppMethodBeat.o(107727);
          return false;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          ad.e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", new Object[] { localIllegalStateException.getMessage() });
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
    int i = CaptureMMProxy.getInstance().getInt(ae.a.FmC, -1);
    if (i == 1)
    {
      ad.i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
      this.tIl = new d();
    }
    for (;;)
    {
      this.hmK = new av("check auto job", this.tIo, true);
      AppMethodBeat.o(107728);
      return;
      if (i == 2)
      {
        ad.i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
        this.tIl = new b();
      }
      else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer())
      {
        ad.i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
        this.tIl = new b();
      }
      else
      {
        ad.i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
        this.tIl = new d();
      }
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(107744);
    this.tIl.a(parama);
    AppMethodBeat.o(107744);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(107746);
    this.tIl.a(paramb);
    AppMethodBeat.o(107746);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(107735);
    this.tIl.a(paramc);
    AppMethodBeat.o(107735);
  }
  
  public final void a(a.d paramd)
  {
    AppMethodBeat.i(107745);
    this.tIl.a(paramd);
    AppMethodBeat.o(107745);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(107737);
    int i = this.tIl.getCurrentPosition();
    AppMethodBeat.o(107737);
    return i;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(107738);
    if (this.tIl != null)
    {
      int i = this.tIl.getDuration();
      AppMethodBeat.o(107738);
      return i;
    }
    AppMethodBeat.o(107738);
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107740);
    boolean bool = this.tIl.isPlaying();
    AppMethodBeat.o(107740);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(107733);
    this.tIl.pause();
    this.hmK.stopTimer();
    AppMethodBeat.o(107733);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(107742);
    this.tIl.prepareAsync();
    AppMethodBeat.o(107742);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107731);
    this.released = true;
    this.tIl.release();
    if (this.hmK != null)
    {
      this.hmK.stopTimer();
      this.hmK.quit();
    }
    AppMethodBeat.o(107731);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(107741);
    this.tIl.seekTo(paramInt);
    AppMethodBeat.o(107741);
  }
  
  public final void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(107736);
    this.tIl.setAudioStreamType(paramInt);
    AppMethodBeat.o(107736);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(107730);
    this.tIl.setDataSource(paramString);
    AppMethodBeat.o(107730);
  }
  
  public final void setLoop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107729);
    this.tIe = paramInt1;
    this.tIf = paramInt2;
    if (this.tIl != null) {
      this.tIl.setLoop(this.tIe, this.tIf);
    }
    AppMethodBeat.o(107729);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(107743);
    this.tIl.setLooping(paramBoolean);
    AppMethodBeat.o(107743);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(107739);
    this.tIl.setSurface(paramSurface);
    AppMethodBeat.o(107739);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107732);
    this.tIl.start();
    this.hmK.av(30L, 30L);
    AppMethodBeat.o(107732);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107734);
    this.tIl.stop();
    this.hmK.stopTimer();
    AppMethodBeat.o(107734);
  }
  
  public static abstract interface a
  {
    public abstract void GY(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.c
 * JD-Core Version:    0.7.0.1
 */