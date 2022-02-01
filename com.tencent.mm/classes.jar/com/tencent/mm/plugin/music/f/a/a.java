package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.NativeLibs;

public class a
{
  private static boolean aMG;
  private static c vgT;
  private static boolean vgU;
  
  static
  {
    AppMethodBeat.i(137400);
    vgT = new a.a((byte)0);
    vgU = false;
    aMG = false;
    AppMethodBeat.o(137400);
  }
  
  public static void a(c paramc)
  {
    vgT = paramc;
  }
  
  public static void djo()
  {
    AppMethodBeat.i(137398);
    ac.i("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
    AudioPlayerConfigure.setLog(new a.1());
    AudioPlayerConfigure.setSoLibraryLoader(new ISoLibraryLoader()
    {
      public final String findLibPath(String paramAnonymousString)
      {
        AppMethodBeat.i(137392);
        if (a.djq() != null)
        {
          paramAnonymousString = a.djq().findLibPath(paramAnonymousString);
          AppMethodBeat.o(137392);
          return paramAnonymousString;
        }
        AppMethodBeat.o(137392);
        return null;
      }
      
      public final boolean load(String paramAnonymousString)
      {
        AppMethodBeat.i(137391);
        if (a.djq() != null)
        {
          boolean bool = a.djq().load(paramAnonymousString);
          AppMethodBeat.o(137391);
          return bool;
        }
        AppMethodBeat.o(137391);
        return false;
      }
    });
    if ((!vgU) && (!aMG))
    {
      aMG = true;
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137393);
          a.djp();
          a.bvu();
          AppMethodBeat.o(137393);
        }
      }, "audio load NLog");
    }
    AppMethodBeat.o(137398);
  }
  
  public static boolean djp()
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137399);
        if (vgU)
        {
          bool1 = true;
          AppMethodBeat.o(137399);
          return bool1;
        }
        if (vgT == null)
        {
          AppMethodBeat.o(137399);
          continue;
        }
        vgT.load(NativeLibs.nlog.getName());
      }
      finally {}
      boolean bool2 = vgT.anI(NativeLibs.nlog.getName());
      if (bool2)
      {
        try
        {
          vgU = AudioPlayerConfigure.enableNativeLog(null);
          if (vgU) {
            ac.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog success");
          }
          bool1 = vgU;
          AppMethodBeat.o(137399);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.Audio.AudioPlayerUtils", localThrowable, "checkNLogLoad", new Object[0]);
            if (!d.la(20)) {
              break;
            }
            vgU = AudioPlayerConfigure.enableNativeLog(null);
          }
          AppMethodBeat.o(137399);
          throw localThrowable;
        }
      }
      else
      {
        ac.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog fail");
        AppMethodBeat.o(137399);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.a
 * JD-Core Version:    0.7.0.1
 */