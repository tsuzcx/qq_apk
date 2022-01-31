package com.tencent.mm.plugin.music.f.a;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class a$a
  implements c
{
  private HashMap<String, Boolean> mAQ = new HashMap();
  
  public final String findLibPath(String paramString)
  {
    y.i("MicroMsg.Audio.AudioPlayerUtils", "findLibPath %s", new Object[] { paramString });
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
      y.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name is null");
      return false;
    }
    if ((this.mAQ.containsKey(paramString)) && (((Boolean)this.mAQ.get(paramString)).booleanValue()))
    {
      y.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name %s is loaded", new Object[] { paramString });
      return true;
    }
    this.mAQ.put(paramString, Boolean.valueOf(true));
    System.loadLibrary(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.a.a
 * JD-Core Version:    0.7.0.1
 */