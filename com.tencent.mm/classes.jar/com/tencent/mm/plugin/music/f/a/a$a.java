package com.tencent.mm.plugin.music.f.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;

final class a$a
  implements c
{
  private HashMap<String, Boolean> vgV;
  
  private a$a()
  {
    AppMethodBeat.i(137394);
    this.vgV = new HashMap();
    AppMethodBeat.o(137394);
  }
  
  public final boolean anI(String paramString)
  {
    AppMethodBeat.i(137397);
    if (this.vgV.containsKey(paramString))
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
    ac.i("MicroMsg.Audio.AudioPlayerUtils", "findLibPath %s", new Object[] { paramString });
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
      ac.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name is null");
      AppMethodBeat.o(137395);
      return false;
    }
    if ((this.vgV.containsKey(paramString)) && (((Boolean)this.vgV.get(paramString)).booleanValue()))
    {
      ac.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name %s is loaded", new Object[] { paramString });
      AppMethodBeat.o(137395);
      return true;
    }
    this.vgV.put(paramString, Boolean.TRUE);
    System.loadLibrary(paramString);
    AppMethodBeat.o(137395);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.a.a
 * JD-Core Version:    0.7.0.1
 */