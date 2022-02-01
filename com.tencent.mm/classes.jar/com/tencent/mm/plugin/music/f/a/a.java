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
  private static boolean aWX;
  private static c wmo;
  private static boolean wmp;
  
  static
  {
    AppMethodBeat.i(137400);
    wmo = new a.a((byte)0);
    wmp = false;
    aWX = false;
    AppMethodBeat.o(137400);
  }
  
  public static void a(c paramc)
  {
    wmo = paramc;
  }
  
  public static void dtA()
  {
    AppMethodBeat.i(137398);
    ad.i("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
    AudioPlayerConfigure.setLog(new a.1());
    AudioPlayerConfigure.setSoLibraryLoader(new ISoLibraryLoader()
    {
      public final String findLibPath(String paramAnonymousString)
      {
        AppMethodBeat.i(137392);
        if (a.dtC() != null)
        {
          paramAnonymousString = a.dtC().findLibPath(paramAnonymousString);
          AppMethodBeat.o(137392);
          return paramAnonymousString;
        }
        AppMethodBeat.o(137392);
        return null;
      }
      
      public final boolean load(String paramAnonymousString)
      {
        AppMethodBeat.i(137391);
        if (a.dtC() != null)
        {
          boolean bool = a.dtC().load(paramAnonymousString);
          AppMethodBeat.o(137391);
          return bool;
        }
        AppMethodBeat.o(137391);
        return false;
      }
    });
    if ((!wmp) && (!aWX))
    {
      aWX = true;
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137393);
          a.dtB();
          a.bzA();
          AppMethodBeat.o(137393);
        }
      }, "audio load NLog");
    }
    AppMethodBeat.o(137398);
  }
  
  public static boolean dtB()
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137399);
        if (wmp)
        {
          bool1 = true;
          AppMethodBeat.o(137399);
          return bool1;
        }
        if (wmo == null)
        {
          AppMethodBeat.o(137399);
          continue;
        }
        wmo.load(NativeLibs.nlog.getName());
      }
      finally {}
      wmo.load(NativeLibs.audioCommon.getName());
      boolean bool2 = wmo.asH(NativeLibs.nlog.getName());
      if (bool2)
      {
        try
        {
          wmp = AudioPlayerConfigure.enableNativeLog(null);
          if (wmp) {
            ad.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog success");
          }
          bool1 = wmp;
          AppMethodBeat.o(137399);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Audio.AudioPlayerUtils", localThrowable, "checkNLogLoad", new Object[0]);
            if (!d.lz(20)) {
              break;
            }
            wmp = AudioPlayerConfigure.enableNativeLog(null);
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