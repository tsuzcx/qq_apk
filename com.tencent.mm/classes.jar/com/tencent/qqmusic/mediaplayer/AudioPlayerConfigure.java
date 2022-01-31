package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class AudioPlayerConfigure
{
  private static final String LIB_PREFIX = "lib";
  private static final String LIB_SUFFIX = ".so";
  private static final String TAG = "AudioPlayerConfigure";
  static ISoLibraryLoader mISoLibraryLoader;
  static int minAudioTrackWaitTimeMs;
  private static boolean sIsNlogEnabled;
  
  static
  {
    AppMethodBeat.i(128352);
    sIsNlogEnabled = false;
    minAudioTrackWaitTimeMs = 300;
    mISoLibraryLoader = new AudioPlayerConfigure.1();
    AppMethodBeat.o(128352);
  }
  
  public static boolean enableNativeLog(String paramString)
  {
    AppMethodBeat.i(128350);
    boolean bool = enableNativeLog(NativeLibs.nlog.getName(), paramString);
    AppMethodBeat.o(128350);
    return bool;
  }
  
  public static boolean enableNativeLog(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128351);
    if (sIsNlogEnabled)
    {
      AppMethodBeat.o(128351);
      return true;
    }
    String str = getSoLibraryLoader().findLibPath(paramString1);
    Logger.i("AudioPlayerConfigure", "[enableNativeLog] loading log lib: ".concat(String.valueOf(str)));
    boolean bool;
    if (paramString2 == null)
    {
      bool = true;
      if ((!NLog.init(paramString1, paramString2, 0)) || (NativeLog.init(str) != 0)) {
        break label95;
      }
      sIsNlogEnabled = true;
      NLog.setWriteCallback(bool);
      Logger.i("AudioPlayerConfigure", "[enableNativeLog] succeed");
    }
    for (;;)
    {
      bool = sIsNlogEnabled;
      AppMethodBeat.o(128351);
      return bool;
      bool = false;
      break;
      label95:
      Logger.e("AudioPlayerConfigure", "[enableNativeLog] failed");
    }
  }
  
  private static byte[] findLibPath(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128348);
    paramArrayOfByte = mISoLibraryLoader.findLibPath(new String(paramArrayOfByte)).getBytes();
    AppMethodBeat.o(128348);
    return paramArrayOfByte;
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
    AppMethodBeat.i(128349);
    if (paramILog != null) {
      paramILog.i("AudioPlayerConfigure", "QQMusicAudioPlayer codec version:1.2");
    }
    Logger.setLog(paramILog);
    AppMethodBeat.o(128349);
  }
  
  public static void setSoLibraryLoader(ISoLibraryLoader paramISoLibraryLoader)
  {
    if (paramISoLibraryLoader != null) {
      mISoLibraryLoader = paramISoLibraryLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure
 * JD-Core Version:    0.7.0.1
 */