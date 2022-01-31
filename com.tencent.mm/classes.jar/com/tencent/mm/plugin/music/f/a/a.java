package com.tencent.mm.plugin.music.f.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import java.util.HashMap;

public class a
{
  private static boolean are;
  private static c paT;
  private static boolean paU;
  
  static
  {
    AppMethodBeat.i(137648);
    paT = new a((byte)0);
    paU = false;
    are = false;
    AppMethodBeat.o(137648);
  }
  
  public static void a(c paramc)
  {
    paT = paramc;
  }
  
  public static void bWg()
  {
    AppMethodBeat.i(137646);
    ab.i("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
    AudioPlayerConfigure.setLog(new a.1());
    AudioPlayerConfigure.setSoLibraryLoader(new a.2());
    if ((!paU) && (!are))
    {
      are = true;
      com.tencent.mm.sdk.g.d.post(new a.3(), "audio load NLog");
    }
    AppMethodBeat.o(137646);
  }
  
  public static boolean bWh()
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137647);
        if (paU)
        {
          bool1 = true;
          AppMethodBeat.o(137647);
          return bool1;
        }
        if (paT == null)
        {
          AppMethodBeat.o(137647);
          continue;
        }
        paT.load(NativeLibs.nlog.getName());
      }
      finally {}
      boolean bool2 = paT.VA(NativeLibs.nlog.getName());
      if (bool2)
      {
        try
        {
          paU = AudioPlayerConfigure.enableNativeLog(null);
          if (paU) {
            ab.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog success");
          }
          bool1 = paU;
          AppMethodBeat.o(137647);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.Audio.AudioPlayerUtils", localThrowable, "checkNLogLoad", new Object[0]);
            if (!com.tencent.mm.compatible.util.d.fw(20)) {
              break;
            }
            paU = AudioPlayerConfigure.enableNativeLog(null);
          }
          AppMethodBeat.o(137647);
          throw localThrowable;
        }
      }
      else
      {
        ab.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog fail");
        AppMethodBeat.o(137647);
      }
    }
  }
  
  static final class a
    implements c
  {
    private HashMap<String, Boolean> paV;
    
    private a()
    {
      AppMethodBeat.i(137642);
      this.paV = new HashMap();
      AppMethodBeat.o(137642);
    }
    
    public final boolean VA(String paramString)
    {
      AppMethodBeat.i(137645);
      if (this.paV.containsKey(paramString))
      {
        AppMethodBeat.o(137645);
        return true;
      }
      AppMethodBeat.o(137645);
      return false;
    }
    
    public final String findLibPath(String paramString)
    {
      AppMethodBeat.i(137644);
      ab.i("MicroMsg.Audio.AudioPlayerUtils", "findLibPath %s", new Object[] { paramString });
      String str = paramString;
      if (!paramString.startsWith("lib")) {
        str = "lib".concat(String.valueOf(paramString));
      }
      paramString = str;
      if (!str.endsWith(".so")) {
        paramString = str + ".so";
      }
      AppMethodBeat.o(137644);
      return paramString;
    }
    
    public final boolean load(String paramString)
    {
      AppMethodBeat.i(137643);
      if (TextUtils.isEmpty(paramString))
      {
        ab.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name is null");
        AppMethodBeat.o(137643);
        return false;
      }
      if ((this.paV.containsKey(paramString)) && (((Boolean)this.paV.get(paramString)).booleanValue()))
      {
        ab.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name %s is loaded", new Object[] { paramString });
        AppMethodBeat.o(137643);
        return true;
      }
      this.paV.put(paramString, Boolean.TRUE);
      System.loadLibrary(paramString);
      AppMethodBeat.o(137643);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.a
 * JD-Core Version:    0.7.0.1
 */