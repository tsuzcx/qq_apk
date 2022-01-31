package com.tencent.mm.plugin.music.model.c;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.music.f.a.a;
import com.tencent.mm.plugin.music.f.a.c;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  implements c
{
  public final String findLibPath(String paramString)
  {
    y.i("MicroMsg.Music.WechatMusicLoadLibrary", "findLibPath %s", new Object[] { paramString });
    String str = paramString;
    if (!paramString.startsWith("lib")) {
      str = "lib" + paramString;
    }
    paramString = str;
    if (!str.endsWith(".so")) {
      paramString = str + ".so";
    }
    return paramString;
  }
  
  public final boolean load(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary lib_name is null");
      return false;
    }
    if (k.fd(paramString)) {
      return true;
    }
    y.i("MicroMsg.Music.WechatMusicLoadLibrary", "load library %s", new Object[] { paramString });
    ClassLoader localClassLoader = a.class.getClassLoader();
    String str = k.fe(paramString);
    if (!TextUtils.isEmpty(str))
    {
      y.i("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary find and load the lib %s so", new Object[] { str });
      k.b(paramString, localClassLoader);
      return true;
    }
    y.e("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary can't find the lib %s so", new Object[] { paramString });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c.b
 * JD-Core Version:    0.7.0.1
 */