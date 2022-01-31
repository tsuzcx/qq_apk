package com.tencent.ttpic.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import java.io.IOException;

public class PlayerUtil
{
  private static AudioManager sManager;
  
  public static PlayerUtil.Player createPlayer(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(50285);
    if (paramString.startsWith("assets://"))
    {
      paramContext = createPlayerFromAssets(paramContext, FileUtils.getRealPath(paramString), paramBoolean);
      AppMethodBeat.o(50285);
      return paramContext;
    }
    paramContext = createPlayerFromUri(paramContext, paramString, paramBoolean);
    AppMethodBeat.o(50285);
    return paramContext;
  }
  
  public static PlayerUtil.Player createPlayerFromAssets(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(50287);
    try
    {
      localPlayer = new PlayerUtil.Player();
      destroyPlayer(paramContext);
    }
    catch (IOException paramContext)
    {
      try
      {
        paramContext = paramContext.getAssets().openFd(paramString);
        localPlayer.setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
        paramContext.close();
        preparePlayer(localPlayer, paramBoolean);
        AppMethodBeat.o(50287);
        return localPlayer;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          PlayerUtil.Player localPlayer;
          paramContext = localPlayer;
        }
      }
      paramContext = paramContext;
      paramContext = null;
    }
    AppMethodBeat.o(50287);
    return null;
  }
  
  public static PlayerUtil.Player createPlayerFromUri(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(50286);
    try
    {
      localPlayer = new PlayerUtil.Player();
      destroyPlayer(paramContext);
    }
    catch (IOException paramContext)
    {
      try
      {
        localPlayer.setDataSource(paramContext, Uri.parse(paramString));
        preparePlayer(localPlayer, paramBoolean);
        AppMethodBeat.o(50286);
        return localPlayer;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          PlayerUtil.Player localPlayer;
          paramContext = localPlayer;
        }
      }
      paramContext = paramContext;
      paramContext = null;
    }
    AppMethodBeat.o(50286);
    return null;
  }
  
  public static PlayerUtil.Recorder createRecorder(String paramString)
  {
    AppMethodBeat.i(50294);
    for (;;)
    {
      try
      {
        localRecorder = new PlayerUtil.Recorder();
        destroyRecorder(localRecorder);
      }
      catch (Exception paramString)
      {
        try
        {
          localRecorder.setOutputFile(paramString);
          localRecorder.setAudioSource(1);
          localRecorder.setAudioChannels(1);
          localRecorder.setAudioSamplingRate(44100);
          localRecorder.setAudioEncodingBitRate(96000);
          localRecorder.setOutputFormat(2);
          localRecorder.setAudioEncoder(3);
          localRecorder.setOnErrorListener(new PlayerUtil.5());
          localRecorder.prepare();
          AppMethodBeat.o(50294);
          return localRecorder;
        }
        catch (Exception paramString)
        {
          PlayerUtil.Recorder localRecorder;
          break label75;
        }
        paramString = paramString;
        localRecorder = null;
      }
      label75:
      localRecorder = null;
    }
  }
  
  public static void destroyPlayer(PlayerUtil.Player paramPlayer)
  {
    AppMethodBeat.i(50292);
    if (paramPlayer != null)
    {
      paramPlayer.stop();
      paramPlayer.reset();
      paramPlayer.release();
    }
    AppMethodBeat.o(50292);
  }
  
  public static void destroyRecorder(PlayerUtil.Recorder paramRecorder)
  {
    AppMethodBeat.i(50297);
    if (paramRecorder != null)
    {
      paramRecorder.stop();
      paramRecorder.reset();
      paramRecorder.release();
    }
    AppMethodBeat.o(50297);
  }
  
  private static AudioManager getAudioManager(Context paramContext)
  {
    AppMethodBeat.i(50302);
    if (sManager == null) {
      sManager = (AudioManager)paramContext.getSystemService("audio");
    }
    paramContext = sManager;
    AppMethodBeat.o(50302);
    return paramContext;
  }
  
  public static int getMaxVolume(Context paramContext)
  {
    AppMethodBeat.i(50300);
    int i = getAudioManager(paramContext).getStreamMaxVolume(3);
    AppMethodBeat.o(50300);
    return i;
  }
  
  public static int getVolume(Context paramContext)
  {
    AppMethodBeat.i(50299);
    int i = getAudioManager(paramContext).getStreamVolume(3);
    AppMethodBeat.o(50299);
    return i;
  }
  
  public static boolean isSilentMode(Context paramContext)
  {
    AppMethodBeat.i(50301);
    switch (getAudioManager(paramContext).getRingerMode())
    {
    default: 
      AppMethodBeat.o(50301);
      return false;
    case 2: 
      AppMethodBeat.o(50301);
      return false;
    case 0: 
      AppMethodBeat.o(50301);
      return true;
    }
    AppMethodBeat.o(50301);
    return true;
  }
  
  private boolean isSupportedAudioSamplingRate(int paramInt)
  {
    AppMethodBeat.i(50295);
    if (AudioRecord.getMinBufferSize(paramInt, 16, 2) > 0)
    {
      AppMethodBeat.o(50295);
      return true;
    }
    AppMethodBeat.o(50295);
    return false;
  }
  
  private static void preparePlayer(PlayerUtil.Player paramPlayer, boolean paramBoolean)
  {
    AppMethodBeat.i(50288);
    paramPlayer.setAudioStreamType(3);
    paramPlayer.setLooping(paramBoolean);
    paramPlayer.setOnCompletionListener(new PlayerUtil.1());
    paramPlayer.setOnErrorListener(new PlayerUtil.2());
    paramPlayer.prepare();
    AppMethodBeat.o(50288);
  }
  
  public static void seekPlayer(PlayerUtil.Player paramPlayer, int paramInt)
  {
    AppMethodBeat.i(50290);
    if (paramPlayer != null)
    {
      paramPlayer.setOnSeekCompleteListener(new PlayerUtil.4());
      paramPlayer.seekTo(paramInt);
    }
    AppMethodBeat.o(50290);
  }
  
  public static void setMute(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(50293);
    getAudioManager(paramContext).setStreamMute(3, paramBoolean);
    AppMethodBeat.o(50293);
  }
  
  public static void setVolume(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(50298);
    getAudioManager(paramContext).setStreamVolume(3, Math.min(Math.max(paramInt, 0), getMaxVolume(paramContext)), 8);
    AppMethodBeat.o(50298);
  }
  
  public static void startPlayer(PlayerUtil.Player paramPlayer, boolean paramBoolean)
  {
    AppMethodBeat.i(50289);
    if (paramPlayer != null)
    {
      if (paramBoolean)
      {
        paramPlayer.setOnSeekCompleteListener(new PlayerUtil.3());
        paramPlayer.seekTo(0);
        AppMethodBeat.o(50289);
        return;
      }
      paramPlayer.start();
    }
    AppMethodBeat.o(50289);
  }
  
  public static void startRecorder(PlayerUtil.Recorder paramRecorder)
  {
    AppMethodBeat.i(50296);
    if (paramRecorder != null) {
      paramRecorder.start();
    }
    AppMethodBeat.o(50296);
  }
  
  public static void stopPlayer(PlayerUtil.Player paramPlayer)
  {
    AppMethodBeat.i(50291);
    if (paramPlayer != null) {
      paramPlayer.pause();
    }
    AppMethodBeat.o(50291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.PlayerUtil
 * JD-Core Version:    0.7.0.1
 */