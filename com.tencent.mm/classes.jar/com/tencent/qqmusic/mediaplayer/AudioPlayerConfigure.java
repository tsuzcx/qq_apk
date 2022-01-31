package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;

public class AudioPlayerConfigure
{
  private static final String LIB_PREFIX = "lib";
  private static final String LIB_SUFFIX = ".so";
  private static final String TAG = "AudioPlayerConfigure";
  static ISoLibraryLoader mISoLibraryLoader = new AudioPlayerConfigure.1();
  static int minAudioTrackWaitTimeMs;
  private static boolean sIsNlogEnabled = false;
  
  static
  {
    minAudioTrackWaitTimeMs = 300;
  }
  
  public static boolean enableNativeLog(String paramString)
  {
    return enableNativeLog(NativeLibs.nlog.getName(), paramString);
  }
  
  public static boolean enableNativeLog(String paramString1, String paramString2)
  {
    if (sIsNlogEnabled) {
      return true;
    }
    String str = getSoLibraryLoader().findLibPath(paramString1);
    Logger.i("AudioPlayerConfigure", "[enableNativeLog] loading log lib: " + str);
    boolean bool;
    if (paramString2 == null)
    {
      bool = true;
      if ((!NLog.init(paramString1, paramString2, 0)) || (NativeLog.init(str) != 0)) {
        break label85;
      }
      sIsNlogEnabled = true;
      NLog.setWriteCallback(bool);
      Logger.i("AudioPlayerConfigure", "[enableNativeLog] succeed");
    }
    for (;;)
    {
      return sIsNlogEnabled;
      bool = false;
      break;
      label85:
      Logger.e("AudioPlayerConfigure", "[enableNativeLog] failed");
    }
  }
  
  private static byte[] findLibPath(byte[] paramArrayOfByte)
  {
    return mISoLibraryLoader.findLibPath(new String(paramArrayOfByte)).getBytes();
  }
  
  public static ISoLibraryLoader getSoLibraryLoader()
  {
    return mISoLibraryLoader;
  }
  
  public static void setAudioTrackMinWaitTimeMs(int paramInt)
  {
    minAudioTrackWaitTimeMs = paramInt;
  }
  
  public static void setLog(ILog paramILog)
  {
    if (paramILog != null) {
      paramILog.i("AudioPlayerConfigure", "QQMusicAudioPlayer codec version:1.0");
    }
    Logger.setLog(paramILog);
  }
  
  public static void setSoLibraryLoader(ISoLibraryLoader paramISoLibraryLoader)
  {
    if (paramISoLibraryLoader != null) {
      mISoLibraryLoader = paramISoLibraryLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure
 * JD-Core Version:    0.7.0.1
 */