package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.NativeLibs;

public class a
{
  private static boolean aLQ;
  private static c tYg;
  private static boolean tYh;
  
  static
  {
    AppMethodBeat.i(137400);
    tYg = new a.a((byte)0);
    tYh = false;
    aLQ = false;
    AppMethodBeat.o(137400);
  }
  
  public static void a(c paramc)
  {
    tYg = paramc;
  }
  
  public static void cVI()
  {
    AppMethodBeat.i(137398);
    ad.i("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
    AudioPlayerConfigure.setLog(new a.1());
    AudioPlayerConfigure.setSoLibraryLoader(new ISoLibraryLoader()
    {
      public final String findLibPath(String paramAnonymousString)
      {
        AppMethodBeat.i(137392);
        if (a.cVK() != null)
        {
          paramAnonymousString = a.cVK().findLibPath(paramAnonymousString);
          AppMethodBeat.o(137392);
          return paramAnonymousString;
        }
        AppMethodBeat.o(137392);
        return null;
      }
      
      public final boolean load(String paramAnonymousString)
      {
        AppMethodBeat.i(137391);
        if (a.cVK() != null)
        {
          boolean bool = a.cVK().load(paramAnonymousString);
          AppMethodBeat.o(137391);
          return bool;
        }
        AppMethodBeat.o(137391);
        return false;
      }
    });
    if ((!tYh) && (!aLQ))
    {
      aLQ = true;
      b.c(new a.3(), "audio load NLog");
    }
    AppMethodBeat.o(137398);
  }
  
  public static boolean cVJ()
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137399);
        if (tYh)
        {
          bool1 = true;
          AppMethodBeat.o(137399);
          return bool1;
        }
        if (tYg == null)
        {
          AppMethodBeat.o(137399);
          continue;
        }
        tYg.load(NativeLibs.nlog.getName());
      }
      finally {}
      boolean bool2 = tYg.aiN(NativeLibs.nlog.getName());
      if (bool2)
      {
        try
        {
          tYh = AudioPlayerConfigure.enableNativeLog(null);
          if (tYh) {
            ad.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog success");
          }
          bool1 = tYh;
          AppMethodBeat.o(137399);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Audio.AudioPlayerUtils", localThrowable, "checkNLogLoad", new Object[0]);
            if (!d.lg(20)) {
              break;
            }
            tYh = AudioPlayerConfigure.enableNativeLog(null);
          }
          AppMethodBeat.o(137399);
          throw localThrowable;
        }
      }
      else
      {
        ad.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog fail");
        AppMethodBeat.o(137399);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.a
 * JD-Core Version:    0.7.0.1
 */