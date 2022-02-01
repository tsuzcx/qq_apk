package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.NativeLibs;

public class a
{
  private static c Ame;
  private static boolean Amf;
  private static boolean aWP;
  
  static
  {
    AppMethodBeat.i(137400);
    Ame = new a.a((byte)0);
    Amf = false;
    aWP = false;
    AppMethodBeat.o(137400);
  }
  
  public static void a(c paramc)
  {
    Ame = paramc;
  }
  
  public static void euV()
  {
    AppMethodBeat.i(137398);
    Log.i("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
    AudioPlayerConfigure.setLog(new a.1());
    AudioPlayerConfigure.setSoLibraryLoader(new ISoLibraryLoader()
    {
      public final String findLibPath(String paramAnonymousString)
      {
        AppMethodBeat.i(137392);
        if (a.euX() != null)
        {
          paramAnonymousString = a.euX().findLibPath(paramAnonymousString);
          AppMethodBeat.o(137392);
          return paramAnonymousString;
        }
        AppMethodBeat.o(137392);
        return null;
      }
      
      public final boolean load(String paramAnonymousString)
      {
        AppMethodBeat.i(137391);
        if (a.euX() != null)
        {
          boolean bool = a.euX().load(paramAnonymousString);
          AppMethodBeat.o(137391);
          return bool;
        }
        AppMethodBeat.o(137391);
        return false;
      }
    });
    if ((!Amf) && (!aWP))
    {
      aWP = true;
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137393);
          a.euW();
          a.bXt();
          AppMethodBeat.o(137393);
        }
      }, "audio load NLog");
    }
    AppMethodBeat.o(137398);
  }
  
  public static boolean euW()
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137399);
        if (Amf)
        {
          bool1 = true;
          AppMethodBeat.o(137399);
          return bool1;
        }
        if (Ame == null)
        {
          AppMethodBeat.o(137399);
          continue;
        }
        Ame.load(NativeLibs.nlog.getName());
      }
      finally {}
      Ame.load(NativeLibs.audioCommon.getName());
      boolean bool2 = Ame.aHU(NativeLibs.nlog.getName());
      if (bool2)
      {
        try
        {
          Amf = AudioPlayerConfigure.enableNativeLog(null);
          if (Amf) {
            Log.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog success");
          }
          bool1 = Amf;
          AppMethodBeat.o(137399);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Audio.AudioPlayerUtils", localThrowable, "checkNLogLoad", new Object[0]);
            if (!d.oE(20)) {
              break;
            }
            Amf = AudioPlayerConfigure.enableNativeLog(null);
          }
          AppMethodBeat.o(137399);
          throw localThrowable;
        }
      }
      else
      {
        Log.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog fail");
        AppMethodBeat.o(137399);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.a
 * JD-Core Version:    0.7.0.1
 */