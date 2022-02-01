package com.tencent.mm.plugin.music.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.NativeLibs;

public class a
{
  private static c LOh;
  private static boolean LOi;
  private static boolean loading;
  
  static
  {
    AppMethodBeat.i(137400);
    LOh = new a.a((byte)0);
    LOi = false;
    loading = false;
    AppMethodBeat.o(137400);
  }
  
  public static void a(c paramc)
  {
    LOh = paramc;
  }
  
  public static void goy()
  {
    AppMethodBeat.i(137398);
    Log.i("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
    AudioPlayerConfigure.setLog(new a.1());
    AudioPlayerConfigure.setSoLibraryLoader(new ISoLibraryLoader()
    {
      public final String findLibPath(String paramAnonymousString)
      {
        AppMethodBeat.i(137392);
        if (a.goA() != null)
        {
          paramAnonymousString = a.goA().findLibPath(paramAnonymousString);
          AppMethodBeat.o(137392);
          return paramAnonymousString;
        }
        AppMethodBeat.o(137392);
        return null;
      }
      
      public final boolean load(String paramAnonymousString)
      {
        AppMethodBeat.i(137391);
        if (a.goA() != null)
        {
          boolean bool = a.goA().load(paramAnonymousString);
          AppMethodBeat.o(137391);
          return bool;
        }
        AppMethodBeat.o(137391);
        return false;
      }
    });
    if ((!LOi) && (!loading))
    {
      loading = true;
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137393);
          a.goz();
          a.cth();
          AppMethodBeat.o(137393);
        }
      }, "audio load NLog");
    }
    AppMethodBeat.o(137398);
  }
  
  public static boolean goz()
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137399);
        if (LOi)
        {
          bool1 = true;
          AppMethodBeat.o(137399);
          return bool1;
        }
        if (LOh == null)
        {
          AppMethodBeat.o(137399);
          continue;
        }
        LOh.load(NativeLibs.nlog.getName());
      }
      finally {}
      LOh.load(NativeLibs.audioCommon.getName());
      boolean bool2 = LOh.aPe(NativeLibs.nlog.getName());
      if (bool2) {}
      try
      {
        LOi = AudioPlayerConfigure.enableNativeLog(null);
        if (LOi) {
          Log.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog success");
        }
        bool1 = LOi;
        AppMethodBeat.o(137399);
      }
      finally
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Audio.AudioPlayerUtils", localThrowable, "checkNLogLoad", new Object[0]);
          if (!d.rc(20)) {
            break;
          }
          LOi = AudioPlayerConfigure.enableNativeLog(null);
        }
        AppMethodBeat.o(137399);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.a.a
 * JD-Core Version:    0.7.0.1
 */