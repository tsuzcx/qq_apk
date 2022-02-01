package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.ILog;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.NativeLibs;

public class a
{
  private static c FTl;
  private static boolean FTm;
  private static boolean aGh;
  
  static
  {
    AppMethodBeat.i(137400);
    FTl = new a.a((byte)0);
    FTm = false;
    aGh = false;
    AppMethodBeat.o(137400);
  }
  
  public static void a(c paramc)
  {
    FTl = paramc;
  }
  
  public static void ffp()
  {
    AppMethodBeat.i(137398);
    Log.i("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
    AudioPlayerConfigure.setLog(new ILog()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(137383);
        Log.d(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(137383);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(137385);
        Log.e(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(137385);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(137389);
        Log.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, new Object[0]);
        AppMethodBeat.o(137389);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(137390);
        Log.e(paramAnonymousString1, String.format(paramAnonymousString2, paramAnonymousVarArgs));
        AppMethodBeat.o(137390);
      }
      
      public final void e(String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(137388);
        Log.printErrStackTrace(paramAnonymousString, paramAnonymousThrowable, " throwable", new Object[0]);
        AppMethodBeat.o(137388);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(137386);
        Log.i(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(137386);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(137387);
        Log.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, new Object[0]);
        AppMethodBeat.o(137387);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(137384);
        Log.w(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(137384);
      }
    });
    AudioPlayerConfigure.setSoLibraryLoader(new ISoLibraryLoader()
    {
      public final String findLibPath(String paramAnonymousString)
      {
        AppMethodBeat.i(137392);
        if (a.ffr() != null)
        {
          paramAnonymousString = a.ffr().findLibPath(paramAnonymousString);
          AppMethodBeat.o(137392);
          return paramAnonymousString;
        }
        AppMethodBeat.o(137392);
        return null;
      }
      
      public final boolean load(String paramAnonymousString)
      {
        AppMethodBeat.i(137391);
        if (a.ffr() != null)
        {
          boolean bool = a.ffr().load(paramAnonymousString);
          AppMethodBeat.o(137391);
          return bool;
        }
        AppMethodBeat.o(137391);
        return false;
      }
    });
    if ((!FTm) && (!aGh))
    {
      aGh = true;
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137393);
          a.ffq();
          a.cjY();
          AppMethodBeat.o(137393);
        }
      }, "audio load NLog");
    }
    AppMethodBeat.o(137398);
  }
  
  public static boolean ffq()
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137399);
        if (FTm)
        {
          bool1 = true;
          AppMethodBeat.o(137399);
          return bool1;
        }
        if (FTl == null)
        {
          AppMethodBeat.o(137399);
          continue;
        }
        FTl.load(NativeLibs.nlog.getName());
      }
      finally {}
      FTl.load(NativeLibs.audioCommon.getName());
      boolean bool2 = FTl.aSk(NativeLibs.nlog.getName());
      if (bool2)
      {
        try
        {
          FTm = AudioPlayerConfigure.enableNativeLog(null);
          if (FTm) {
            Log.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog success");
          }
          bool1 = FTm;
          AppMethodBeat.o(137399);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Audio.AudioPlayerUtils", localThrowable, "checkNLogLoad", new Object[0]);
            if (!d.qW(20)) {
              break;
            }
            FTm = AudioPlayerConfigure.enableNativeLog(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.a
 * JD-Core Version:    0.7.0.1
 */