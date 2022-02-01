package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;

public final class d
  implements a
{
  private MediaPlayer peU;
  
  public d()
  {
    AppMethodBeat.i(107751);
    this.peU = new k();
    AppMethodBeat.o(107751);
  }
  
  public final void a(final a.a parama)
  {
    AppMethodBeat.i(107768);
    if (parama == null)
    {
      this.peU.setOnErrorListener(null);
      AppMethodBeat.o(107768);
      return;
    }
    this.peU.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(107750);
        boolean bool = parama.jL(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(107750);
        return bool;
      }
    });
    AppMethodBeat.o(107768);
  }
  
  public final void a(final a.b paramb)
  {
    AppMethodBeat.i(107765);
    if (paramb == null)
    {
      this.peU.setOnPreparedListener(null);
      AppMethodBeat.o(107765);
      return;
    }
    this.peU.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(107747);
        paramb.fX(paramAnonymousMediaPlayer);
        AppMethodBeat.o(107747);
      }
    });
    AppMethodBeat.o(107765);
  }
  
  public final void a(final a.c paramc)
  {
    AppMethodBeat.i(107766);
    if (paramc == null)
    {
      this.peU.setOnSeekCompleteListener(null);
      AppMethodBeat.o(107766);
      return;
    }
    this.peU.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
    {
      public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(107748);
        paramc.fY(paramAnonymousMediaPlayer);
        AppMethodBeat.o(107748);
      }
    });
    AppMethodBeat.o(107766);
  }
  
  public final void a(final a.d paramd)
  {
    AppMethodBeat.i(107767);
    if (paramd == null)
    {
      this.peU.setOnVideoSizeChangedListener(null);
      AppMethodBeat.o(107767);
      return;
    }
    this.peU.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(107749);
        paramd.aS(paramAnonymousInt1, paramAnonymousInt2, 0);
        AppMethodBeat.o(107749);
      }
    });
    AppMethodBeat.o(107767);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(107760);
    int i = this.peU.getCurrentPosition();
    AppMethodBeat.o(107760);
    return i;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(107761);
    int i = this.peU.getDuration();
    AppMethodBeat.o(107761);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(107758);
    boolean bool = this.peU.isPlaying();
    AppMethodBeat.o(107758);
    return bool;
  }
  
  public final void jM(int paramInt1, int paramInt2) {}
  
  public final void pause()
  {
    AppMethodBeat.i(107757);
    this.peU.pause();
    AppMethodBeat.o(107757);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(107754);
    this.peU.prepareAsync();
    AppMethodBeat.o(107754);
  }
  
  public final void release()
  {
    AppMethodBeat.i(107762);
    this.peU.release();
    AppMethodBeat.o(107762);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(107759);
    this.peU.seekTo(paramInt);
    AppMethodBeat.o(107759);
  }
  
  public final void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(107763);
    this.peU.setAudioStreamType(paramInt);
    AppMethodBeat.o(107763);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(107753);
    this.peU.setDataSource(paramString);
    AppMethodBeat.o(107753);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(107764);
    this.peU.setLooping(paramBoolean);
    AppMethodBeat.o(107764);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(107752);
    this.peU.setSurface(paramSurface);
    AppMethodBeat.o(107752);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107755);
    this.peU.start();
    AppMethodBeat.o(107755);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(107756);
    this.peU.stop();
    AppMethodBeat.o(107756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.d
 * JD-Core Version:    0.7.0.1
 */