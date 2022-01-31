package com.tencent.ttpic.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.net.Uri;
import java.io.IOException;

public class AudioUtils
{
  private static AudioManager sManager;
  
  public static AudioUtils.Player createPlayer(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramString.startsWith("assets://")) {
      return createPlayerFromAssets(paramContext, VideoUtil.getRealPath(paramString), paramBoolean);
    }
    return createPlayerFromUri(paramContext, paramString, paramBoolean);
  }
  
  public static AudioUtils.Player createPlayerFromAssets(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      localPlayer = new AudioUtils.Player();
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
        return localPlayer;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          AudioUtils.Player localPlayer;
          paramContext = localPlayer;
        }
      }
      paramContext = paramContext;
      paramContext = null;
    }
    return null;
  }
  
  public static AudioUtils.Player createPlayerFromUri(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      localPlayer = new AudioUtils.Player();
      destroyPlayer(paramContext);
    }
    catch (IOException paramContext)
    {
      try
      {
        localPlayer.setDataSource(paramContext, Uri.parse(paramString));
        preparePlayer(localPlayer, paramBoolean);
        return localPlayer;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          AudioUtils.Player localPlayer;
          paramContext = localPlayer;
        }
      }
      paramContext = paramContext;
      paramContext = null;
    }
    return null;
  }
  
  public static AudioUtils.Recorder createRecorder(String paramString)
  {
    try
    {
      localRecorder = new AudioUtils.Recorder();
      destroyRecorder(paramString);
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
        localRecorder.setOnErrorListener(new AudioUtils.5());
        localRecorder.prepare();
        return localRecorder;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          AudioUtils.Recorder localRecorder;
          paramString = localRecorder;
        }
      }
      paramString = paramString;
      paramString = null;
    }
    return null;
  }
  
  public static void destroyPlayer(AudioUtils.Player paramPlayer)
  {
    if (paramPlayer != null)
    {
      paramPlayer.stop();
      paramPlayer.reset();
      paramPlayer.release();
    }
  }
  
  public static void destroyRecorder(AudioUtils.Recorder paramRecorder)
  {
    if (paramRecorder != null)
    {
      paramRecorder.stop();
      paramRecorder.reset();
      paramRecorder.release();
    }
  }
  
  private static AudioManager getAudioManager(Context paramContext)
  {
    if (sManager == null) {
      sManager = (AudioManager)paramContext.getSystemService("audio");
    }
    return sManager;
  }
  
  public static int getMaxVolume(Context paramContext)
  {
    return getAudioManager(paramContext).getStreamMaxVolume(3);
  }
  
  public static int getVolume(Context paramContext)
  {
    return getAudioManager(paramContext).getStreamVolume(3);
  }
  
  public static boolean isSilentMode(Context paramContext)
  {
    switch (getAudioManager(paramContext).getRingerMode())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      return true;
    }
    return true;
  }
  
  private boolean isSupportedAudioSamplingRate(int paramInt)
  {
    return AudioRecord.getMinBufferSize(paramInt, 16, 2) > 0;
  }
  
  private static void preparePlayer(AudioUtils.Player paramPlayer, boolean paramBoolean)
  {
    paramPlayer.setAudioStreamType(3);
    paramPlayer.setLooping(paramBoolean);
    paramPlayer.setOnCompletionListener(new AudioUtils.1());
    paramPlayer.setOnErrorListener(new AudioUtils.2());
    paramPlayer.prepare();
  }
  
  public static void seekPlayer(AudioUtils.Player paramPlayer, int paramInt)
  {
    if (paramPlayer != null)
    {
      paramPlayer.setOnSeekCompleteListener(new AudioUtils.4());
      paramPlayer.seekTo(paramInt);
    }
  }
  
  public static void setMute(Context paramContext, boolean paramBoolean)
  {
    getAudioManager(paramContext).setStreamMute(3, paramBoolean);
  }
  
  public static void setVolume(Context paramContext, int paramInt)
  {
    getAudioManager(paramContext).setStreamVolume(3, Math.min(Math.max(paramInt, 0), getMaxVolume(paramContext)), 8);
  }
  
  public static void startPlayer(AudioUtils.Player paramPlayer, boolean paramBoolean)
  {
    if (paramPlayer != null)
    {
      if (paramBoolean)
      {
        paramPlayer.setOnSeekCompleteListener(new AudioUtils.3());
        paramPlayer.seekTo(0);
      }
    }
    else {
      return;
    }
    paramPlayer.start();
  }
  
  public static void startRecorder(AudioUtils.Recorder paramRecorder)
  {
    if (paramRecorder != null) {
      paramRecorder.start();
    }
  }
  
  public static void stopPlayer(AudioUtils.Player paramPlayer)
  {
    if (paramPlayer != null) {
      paramPlayer.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.AudioUtils
 * JD-Core Version:    0.7.0.1
 */