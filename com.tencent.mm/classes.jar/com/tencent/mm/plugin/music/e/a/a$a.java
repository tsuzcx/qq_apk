package com.tencent.mm.plugin.music.e.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

final class a$a
  implements c
{
  private HashMap<String, Boolean> LOj;
  
  private a$a()
  {
    AppMethodBeat.i(137394);
    this.LOj = new HashMap();
    AppMethodBeat.o(137394);
  }
  
  public final boolean aPe(String paramString)
  {
    AppMethodBeat.i(137397);
    if (this.LOj.containsKey(paramString))
    {
      AppMethodBeat.o(137397);
      return true;
    }
    AppMethodBeat.o(137397);
    return false;
  }
  
  public final String findLibPath(String paramString)
  {
    AppMethodBeat.i(137396);
    Log.i("MicroMsg.Audio.AudioPlayerUtils", "findLibPath %s", new Object[] { paramString });
    String str = paramString;
    if (!paramString.startsWith("lib")) {
      str = "lib".concat(String.valueOf(paramString));
    }
    paramString = str;
    if (!str.endsWith(".so")) {
      paramString = str + ".so";
    }
    AppMethodBeat.o(137396);
    return paramString;
  }
  
  public final boolean load(String paramString)
  {
    AppMethodBeat.i(137395);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name is null");
      AppMethodBeat.o(137395);
      return false;
    }
    if ((this.LOj.containsKey(paramString)) && (((Boolean)this.LOj.get(paramString)).booleanValue()))
    {
      Log.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name %s is loaded", new Object[] { paramString });
      AppMethodBeat.o(137395);
      return true;
    }
    this.LOj.put(paramString, Boolean.TRUE);
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramString.aYi(), "com/tencent/mm/plugin/music/player/base/AudioPlayerUtils$DefaultMusicLoadLibrary", "load", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/music/player/base/AudioPlayerUtils$DefaultMusicLoadLibrary", "load", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(137395);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.a.a.a
 * JD-Core Version:    0.7.0.1
 */