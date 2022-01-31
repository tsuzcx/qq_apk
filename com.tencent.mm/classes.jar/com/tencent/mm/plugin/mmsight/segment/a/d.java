package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;

public final class d
  implements a
{
  private MediaPlayer gaO;
  
  public d()
  {
    AppMethodBeat.i(3749);
    this.gaO = new k();
    AppMethodBeat.o(3749);
  }
  
  public final void a(final a.a parama)
  {
    AppMethodBeat.i(3766);
    if (parama == null)
    {
      this.gaO.setOnErrorListener(null);
      AppMethodBeat.o(3766);
      return;
    }
    this.gaO.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(3748);
        boolean bool = parama.eH(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(3748);
        return bool;
      }
    });
    AppMethodBeat.o(3766);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(3763);
    if (paramb == null)
    {
      this.gaO.setOnPreparedListener(null);
      AppMethodBeat.o(3763);
      return;
    }
    this.gaO.setOnPreparedListener(new d.1(this, paramb));
    AppMethodBeat.o(3763);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(3764);
    if (paramc == null)
    {
      this.gaO.setOnSeekCompleteListener(null);
      AppMethodBeat.o(3764);
      return;
    }
    this.gaO.setOnSeekCompleteListener(new d.2(this, paramc));
    AppMethodBeat.o(3764);
  }
  
  public final void a(a.d paramd)
  {
    AppMethodBeat.i(3765);
    if (paramd == null)
    {
      this.gaO.setOnVideoSizeChangedListener(null);
      AppMethodBeat.o(3765);
      return;
    }
    this.gaO.setOnVideoSizeChangedListener(new d.3(this, paramd));
    AppMethodBeat.o(3765);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(3758);
    int i = this.gaO.getCurrentPosition();
    AppMethodBeat.o(3758);
    return i;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(3759);
    int i = this.gaO.getDuration();
    AppMethodBeat.o(3759);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(3756);
    boolean bool = this.gaO.isPlaying();
    AppMethodBeat.o(3756);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(3755);
    this.gaO.pause();
    AppMethodBeat.o(3755);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(3752);
    this.gaO.prepareAsync();
    AppMethodBeat.o(3752);
  }
  
  public final void release()
  {
    AppMethodBeat.i(3760);
    this.gaO.release();
    AppMethodBeat.o(3760);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(3757);
    this.gaO.seekTo(paramInt);
    AppMethodBeat.o(3757);
  }
  
  public final void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(3761);
    this.gaO.setAudioStreamType(paramInt);
    AppMethodBeat.o(3761);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(3751);
    this.gaO.setDataSource(paramString);
    AppMethodBeat.o(3751);
  }
  
  public final void setLoop(int paramInt1, int paramInt2) {}
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(3762);
    this.gaO.setLooping(paramBoolean);
    AppMethodBeat.o(3762);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(3750);
    this.gaO.setSurface(paramSurface);
    AppMethodBeat.o(3750);
  }
  
  public final void start()
  {
    AppMethodBeat.i(3753);
    this.gaO.start();
    AppMethodBeat.o(3753);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(3754);
    this.gaO.stop();
    AppMethodBeat.o(3754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.d
 * JD-Core Version:    0.7.0.1
 */