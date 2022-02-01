package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.NativeLibs;

public class a
{
  private static boolean aWX;
  private static c wBX;
  private static boolean wBY;
  
  static
  {
    AppMethodBeat.i(137400);
    wBX = new a.a((byte)0);
    wBY = false;
    aWX = false;
    AppMethodBeat.o(137400);
  }
  
  public static void a(c paramc)
  {
    wBX = paramc;
  }
  
  public static void dwP()
  {
    AppMethodBeat.i(137398);
    ae.i("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
    AudioPlayerConfigure.setLog(new a.1());
    AudioPlayerConfigure.setSoLibraryLoader(new ISoLibraryLoader()
    {
      public final String findLibPath(String paramAnonymousString)
      {
        AppMethodBeat.i(137392);
        if (a.dwR() != null)
        {
          paramAnonymousString = a.dwR().findLibPath(paramAnonymousString);
          AppMethodBeat.o(137392);
          return paramAnonymousString;
        }
        AppMethodBeat.o(137392);
        return null;
      }
      
      public final boolean load(String paramAnonymousString)
      {
        AppMethodBeat.i(137391);
        if (a.dwR() != null)
        {
          boolean bool = a.dwR().load(paramAnonymousString);
          AppMethodBeat.o(137391);
          return bool;
        }
        AppMethodBeat.o(137391);
        return false;
      }
    });
    if ((!wBY) && (!aWX))
    {
      aWX = true;
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137393);
          a.dwQ();
          a.bAv();
          AppMethodBeat.o(137393);
        }
      }, "audio load NLog");
    }
    AppMethodBeat.o(137398);
  }
  
  public static boolean dwQ()
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137399);
        if (wBY)
        {
          bool1 = true;
          AppMethodBeat.o(137399);
          return bool1;
        }
        if (wBX == null)
        {
          AppMethodBeat.o(137399);
          continue;
        }
        wBX.load(NativeLibs.nlog.getName());
      }
      finally {}
      wBX.load(NativeLibs.audioCommon.getName());
      boolean bool2 = wBX.atU(NativeLibs.nlog.getName());
      if (bool2)
      {
        try
        {
          wBY = AudioPlayerConfigure.enableNativeLog(null);
          if (wBY) {
            ae.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog success");
          }
          bool1 = wBY;
          AppMethodBeat.o(137399);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.Audio.AudioPlayerUtils", localThrowable, "checkNLogLoad", new Object[0]);
            if (!d.lB(20)) {
              break;
            }
            wBY = AudioPlayerConfigure.enableNativeLog(null);
          }
          AppMethodBeat.o(137399);
          throw localThrowable;
        }
      }
      else
      {
        ae.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog fail");
        AppMethodBeat.o(137399);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.a
 * JD-Core Version:    0.7.0.1
 */