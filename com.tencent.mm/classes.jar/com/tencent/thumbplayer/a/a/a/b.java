package com.tencent.thumbplayer.a.a.a;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.TrackInfo;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.g;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends MediaPlayer
{
  protected final void finalize()
  {
    AppMethodBeat.i(228628);
    try
    {
      super.finalize();
      AppMethodBeat.o(228628);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(228628);
    }
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(228695);
    try
    {
      int i = super.getCurrentPosition();
      AppMethodBeat.o(228695);
      return i;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(228695);
    }
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(228703);
    try
    {
      int i = super.getDuration();
      AppMethodBeat.o(228703);
      return i;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(228703);
    }
    return 0;
  }
  
  public final int getSelectedTrack(int paramInt)
  {
    AppMethodBeat.i(228710);
    try
    {
      paramInt = super.getSelectedTrack(paramInt);
      AppMethodBeat.o(228710);
      return paramInt;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(228710);
    }
    return 0;
  }
  
  public final MediaPlayer.TrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(228715);
    try
    {
      MediaPlayer.TrackInfo[] arrayOfTrackInfo = super.getTrackInfo();
      AppMethodBeat.o(228715);
      return arrayOfTrackInfo;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(228715);
    }
    return new MediaPlayer.TrackInfo[0];
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(228652);
    int i = 0;
    try
    {
      int j = super.getVideoHeight();
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      }
    }
    AppMethodBeat.o(228652);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(228645);
    int i = 0;
    try
    {
      int j = super.getVideoWidth();
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      }
    }
    AppMethodBeat.o(228645);
    return i;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(228672);
    try
    {
      super.prepare();
      AppMethodBeat.o(228672);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(228672);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(228636);
    try
    {
      if (("N1W".equalsIgnoreCase(Build.MODEL)) || ("X909T".equalsIgnoreCase(Build.MODEL)) || ("X909".equalsIgnoreCase(Build.MODEL)) || ("N1T".equalsIgnoreCase(Build.MODEL)))
      {
        super.setOnPreparedListener(null);
        super.setOnCompletionListener(null);
        super.setOnErrorListener(null);
        super.setOnInfoListener(null);
        super.setOnBufferingUpdateListener(null);
        super.setOnSeekCompleteListener(null);
        super.setOnVideoSizeChangedListener(null);
        ((Handler)super.getClass().getDeclaredField("mA2dpHandler").get(this)).removeCallbacksAndMessages(null);
      }
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          super.release();
          AppMethodBeat.o(228636);
          return;
        }
        catch (Exception localException)
        {
          g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
          AppMethodBeat.o(228636);
        }
        localNoSuchFieldException = localNoSuchFieldException;
        g.e("TPThumbPlayer[TPMediaPlayer.java]", localNoSuchFieldException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        g.e("TPThumbPlayer[TPMediaPlayer.java]", localIllegalAccessException);
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(228663);
    try
    {
      super.reset();
      AppMethodBeat.o(228663);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(228663);
    }
  }
  
  public final void setDataSource(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(228681);
    try
    {
      super.setDataSource(paramContext, paramUri);
      AppMethodBeat.o(228681);
      return;
    }
    catch (Exception paramContext)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramContext);
      AppMethodBeat.o(228681);
    }
  }
  
  public final void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    AppMethodBeat.i(228721);
    try
    {
      super.setDataSource(paramContext, paramUri, paramMap);
      AppMethodBeat.o(228721);
      return;
    }
    catch (Exception paramContext)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramContext);
      AppMethodBeat.o(228721);
    }
  }
  
  public final void setDataSource(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(228688);
    try
    {
      super.setDataSource(paramFileDescriptor);
      AppMethodBeat.o(228688);
      return;
    }
    catch (Exception paramFileDescriptor)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramFileDescriptor);
      AppMethodBeat.o(228688);
    }
  }
  
  public final void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(228641);
    try
    {
      super.setDisplay(paramSurfaceHolder);
      AppMethodBeat.o(228641);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramSurfaceHolder);
      AppMethodBeat.o(228641);
    }
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(228727);
    try
    {
      super.setLooping(paramBoolean);
      AppMethodBeat.o(228727);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(228727);
    }
  }
  
  public final void setPlaybackParams(PlaybackParams paramPlaybackParams)
  {
    AppMethodBeat.i(228734);
    try
    {
      super.setPlaybackParams(paramPlaybackParams);
      AppMethodBeat.o(228734);
      return;
    }
    catch (Exception paramPlaybackParams)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramPlaybackParams);
      AppMethodBeat.o(228734);
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(228657);
    try
    {
      super.setSurface(paramSurface);
      AppMethodBeat.o(228657);
      return;
    }
    catch (Exception paramSurface)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramSurface);
      AppMethodBeat.o(228657);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(228739);
    try
    {
      super.setVolume(paramFloat1, paramFloat2);
      AppMethodBeat.o(228739);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(228739);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(228668);
    try
    {
      super.stop();
      AppMethodBeat.o(228668);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(228668);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */