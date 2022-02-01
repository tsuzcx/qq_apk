package com.tencent.mm.plugin.music.model.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.music.f.a.a;
import com.tencent.mm.plugin.music.f.a.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  implements c
{
  public final boolean asH(String paramString)
  {
    AppMethodBeat.i(63136);
    boolean bool = j.vs(paramString);
    AppMethodBeat.o(63136);
    return bool;
  }
  
  public final String findLibPath(String paramString)
  {
    AppMethodBeat.i(63135);
    String str = paramString;
    if (!paramString.startsWith("lib")) {
      str = "lib".concat(String.valueOf(paramString));
    }
    paramString = str;
    if (!str.endsWith(".so")) {
      paramString = str + ".so";
    }
    AppMethodBeat.o(63135);
    return paramString;
  }
  
  public final boolean load(String paramString)
  {
    AppMethodBeat.i(63134);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary lib_name is null");
      AppMethodBeat.o(63134);
      return false;
    }
    if (j.vs(paramString))
    {
      AppMethodBeat.o(63134);
      return true;
    }
    ad.i("MicroMsg.Music.WechatMusicLoadLibrary", "load library %s", new Object[] { paramString });
    a.class.getClassLoader();
    String str = j.vq(paramString);
    if (!TextUtils.isEmpty(str))
    {
      ad.i("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary find and load the lib %s so", new Object[] { str });
      j.vr(paramString);
      AppMethodBeat.o(63134);
      return true;
    }
    ad.e("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary can't find the lib %s so", new Object[] { paramString });
    AppMethodBeat.o(63134);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c.b
 * JD-Core Version:    0.7.0.1
 */