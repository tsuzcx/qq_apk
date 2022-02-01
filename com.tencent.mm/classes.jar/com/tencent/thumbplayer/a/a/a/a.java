package com.tencent.thumbplayer.a.a.a;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.d;
import java.lang.reflect.Field;

public final class a
  extends MediaPlayer
{
  protected final void finalize()
  {
    AppMethodBeat.i(194334);
    try
    {
      super.finalize();
      AppMethodBeat.o(194334);
      return;
    }
    catch (Exception localException)
    {
      d.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      AppMethodBeat.o(194334);
    }
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(194338);
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
        d.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      }
    }
    AppMethodBeat.o(194338);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(194337);
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
        d.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
      }
    }
    AppMethodBeat.o(194337);
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(194335);
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
          AppMethodBeat.o(194335);
          return;
        }
        catch (Exception localException)
        {
          d.e("TPThumbPlayer[TPMediaPlayer.java]", localException);
          AppMethodBeat.o(194335);
        }
        localNoSuchFieldException = localNoSuchFieldException;
        d.e("TPThumbPlayer[TPMediaPlayer.java]", localNoSuchFieldException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        d.e("TPThumbPlayer[TPMediaPlayer.java]", localIllegalAccessException);
      }
    }
  }
  
  public final void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(194336);
    try
    {
      super.setDisplay(paramSurfaceHolder);
      AppMethodBeat.o(194336);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      d.e("TPThumbPlayer[TPMediaPlayer.java]", paramSurfaceHolder);
      AppMethodBeat.o(194336);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */