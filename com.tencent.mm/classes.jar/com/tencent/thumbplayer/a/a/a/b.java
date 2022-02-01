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
    AppMethodBeat.i(188748);
    try
    {
      super.finalize();
      AppMethodBeat.o(188748);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(188748);
    }
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(188759);
    try
    {
      int i = super.getCurrentPosition();
      AppMethodBeat.o(188759);
      return i;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(188759);
    }
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(188760);
    try
    {
      int i = super.getDuration();
      AppMethodBeat.o(188760);
      return i;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(188760);
    }
    return 0;
  }
  
  public final int getSelectedTrack(int paramInt)
  {
    AppMethodBeat.i(188761);
    try
    {
      paramInt = super.getSelectedTrack(paramInt);
      AppMethodBeat.o(188761);
      return paramInt;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(188761);
    }
    return 0;
  }
  
  public final MediaPlayer.TrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(188762);
    try
    {
      MediaPlayer.TrackInfo[] arrayOfTrackInfo = super.getTrackInfo();
      AppMethodBeat.o(188762);
      return arrayOfTrackInfo;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(188762);
    }
    return new MediaPlayer.TrackInfo[0];
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(188752);
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
    AppMethodBeat.o(188752);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(188751);
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
    AppMethodBeat.o(188751);
    return i;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(188756);
    try
    {
      super.prepare();
      AppMethodBeat.o(188756);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(188756);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(188749);
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
          AppMethodBeat.o(188749);
          return;
        }
        catch (Exception localException)
        {
          g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
          AppMethodBeat.o(188749);
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
    AppMethodBeat.i(188754);
    try
    {
      super.reset();
      AppMethodBeat.o(188754);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(188754);
    }
  }
  
  public final void setDataSource(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(188757);
    try
    {
      super.setDataSource(paramContext, paramUri);
      AppMethodBeat.o(188757);
      return;
    }
    catch (Exception paramContext)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramContext);
      AppMethodBeat.o(188757);
    }
  }
  
  public final void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188763);
    try
    {
      super.setDataSource(paramContext, paramUri, paramMap);
      AppMethodBeat.o(188763);
      return;
    }
    catch (Exception paramContext)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramContext);
      AppMethodBeat.o(188763);
    }
  }
  
  public final void setDataSource(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(188758);
    try
    {
      super.setDataSource(paramFileDescriptor);
      AppMethodBeat.o(188758);
      return;
    }
    catch (Exception paramFileDescriptor)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramFileDescriptor);
      AppMethodBeat.o(188758);
    }
  }
  
  public final void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(188750);
    try
    {
      super.setDisplay(paramSurfaceHolder);
      AppMethodBeat.o(188750);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramSurfaceHolder);
      AppMethodBeat.o(188750);
    }
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(188764);
    try
    {
      super.setLooping(paramBoolean);
      AppMethodBeat.o(188764);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(188764);
    }
  }
  
  public final void setPlaybackParams(PlaybackParams paramPlaybackParams)
  {
    AppMethodBeat.i(188765);
    try
    {
      super.setPlaybackParams(paramPlaybackParams);
      AppMethodBeat.o(188765);
      return;
    }
    catch (Exception paramPlaybackParams)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramPlaybackParams);
      AppMethodBeat.o(188765);
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(188753);
    try
    {
      super.setSurface(paramSurface);
      AppMethodBeat.o(188753);
      return;
    }
    catch (Exception paramSurface)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramSurface);
      AppMethodBeat.o(188753);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(188766);
    try
    {
      super.setVolume(paramFloat1, paramFloat2);
      AppMethodBeat.o(188766);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(188766);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(188755);
    try
    {
      super.stop();
      AppMethodBeat.o(188755);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(188755);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */