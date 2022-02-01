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
    AppMethodBeat.i(218925);
    try
    {
      super.finalize();
      AppMethodBeat.o(218925);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(218925);
    }
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(218939);
    try
    {
      int i = super.getCurrentPosition();
      AppMethodBeat.o(218939);
      return i;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(218939);
    }
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(218940);
    try
    {
      int i = super.getDuration();
      AppMethodBeat.o(218940);
      return i;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(218940);
    }
    return 0;
  }
  
  public final int getSelectedTrack(int paramInt)
  {
    AppMethodBeat.i(218941);
    try
    {
      paramInt = super.getSelectedTrack(paramInt);
      AppMethodBeat.o(218941);
      return paramInt;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(218941);
    }
    return 0;
  }
  
  public final MediaPlayer.TrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(218942);
    try
    {
      MediaPlayer.TrackInfo[] arrayOfTrackInfo = super.getTrackInfo();
      AppMethodBeat.o(218942);
      return arrayOfTrackInfo;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(218942);
    }
    return new MediaPlayer.TrackInfo[0];
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(218931);
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
    AppMethodBeat.o(218931);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(218929);
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
    AppMethodBeat.o(218929);
    return i;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(218936);
    try
    {
      super.prepare();
      AppMethodBeat.o(218936);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(218936);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(218927);
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
          AppMethodBeat.o(218927);
          return;
        }
        catch (Exception localException)
        {
          g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
          AppMethodBeat.o(218927);
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
    AppMethodBeat.i(218934);
    try
    {
      super.reset();
      AppMethodBeat.o(218934);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(218934);
    }
  }
  
  public final void setDataSource(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(218937);
    try
    {
      super.setDataSource(paramContext, paramUri);
      AppMethodBeat.o(218937);
      return;
    }
    catch (Exception paramContext)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramContext);
      AppMethodBeat.o(218937);
    }
  }
  
  public final void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    AppMethodBeat.i(218943);
    try
    {
      super.setDataSource(paramContext, paramUri, paramMap);
      AppMethodBeat.o(218943);
      return;
    }
    catch (Exception paramContext)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramContext);
      AppMethodBeat.o(218943);
    }
  }
  
  public final void setDataSource(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(218938);
    try
    {
      super.setDataSource(paramFileDescriptor);
      AppMethodBeat.o(218938);
      return;
    }
    catch (Exception paramFileDescriptor)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramFileDescriptor);
      AppMethodBeat.o(218938);
    }
  }
  
  public final void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(218928);
    try
    {
      super.setDisplay(paramSurfaceHolder);
      AppMethodBeat.o(218928);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramSurfaceHolder);
      AppMethodBeat.o(218928);
    }
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(218944);
    try
    {
      super.setLooping(paramBoolean);
      AppMethodBeat.o(218944);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(218944);
    }
  }
  
  public final void setPlaybackParams(PlaybackParams paramPlaybackParams)
  {
    AppMethodBeat.i(218946);
    try
    {
      super.setPlaybackParams(paramPlaybackParams);
      AppMethodBeat.o(218946);
      return;
    }
    catch (Exception paramPlaybackParams)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramPlaybackParams);
      AppMethodBeat.o(218946);
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(218933);
    try
    {
      super.setSurface(paramSurface);
      AppMethodBeat.o(218933);
      return;
    }
    catch (Exception paramSurface)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", paramSurface);
      AppMethodBeat.o(218933);
    }
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(218947);
    try
    {
      super.setVolume(paramFloat1, paramFloat2);
      AppMethodBeat.o(218947);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(218947);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(218935);
    try
    {
      super.stop();
      AppMethodBeat.o(218935);
      return;
    }
    catch (Exception localException)
    {
      g.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(218935);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */