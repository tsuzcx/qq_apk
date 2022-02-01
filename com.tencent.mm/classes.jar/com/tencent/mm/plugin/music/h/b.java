package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class b
{
  public static String S(f paramf)
  {
    AppMethodBeat.i(137444);
    if (paramf.jeT == 6)
    {
      paramf = "6_" + T(paramf);
      AppMethodBeat.o(137444);
      return paramf;
    }
    paramf = "0_" + T(paramf);
    AppMethodBeat.o(137444);
    return paramf;
  }
  
  private static String T(f paramf)
  {
    AppMethodBeat.i(137445);
    if (TextUtils.isEmpty(paramf.jeV))
    {
      AppMethodBeat.o(137445);
      return "";
    }
    paramf = MD5Util.getMD5String(paramf.jeV);
    AppMethodBeat.o(137445);
    return paramf;
  }
  
  public static String aId(String paramString)
  {
    AppMethodBeat.i(137442);
    paramString = "piece" + MD5Util.getMD5String(new StringBuilder().append(paramString.hashCode()).toString());
    AppMethodBeat.o(137442);
    return paramString;
  }
  
  public static String aIe(String paramString)
  {
    AppMethodBeat.i(137443);
    o localo = new o(g.getAccPath(), "music");
    if (!localo.exists()) {
      localo.mkdirs();
    }
    paramString = aId(paramString);
    localo = new o(localo, paramString);
    Log.d("MicroMsg.Music.MusicFileUtil", "getMusicPieceFilePath music name %s path %s", new Object[] { paramString, localo.hes() });
    paramString = aa.z(localo.her());
    AppMethodBeat.o(137443);
    return paramString;
  }
  
  public static String aIf(String paramString)
  {
    AppMethodBeat.i(198193);
    paramString = bT(paramString.hashCode(), false);
    AppMethodBeat.o(198193);
    return paramString;
  }
  
  public static String bT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137446);
    o localo = new o(g.getAccPath(), "music");
    if (!localo.exists()) {
      Log.i("MicroMsg.Music.MusicFileUtil", "create file folder:%b for path:%s", new Object[] { Boolean.valueOf(localo.mkdirs()), aa.z(localo.her()) });
    }
    paramString = bU(paramString, paramBoolean);
    localo = new o(localo, paramString);
    Log.d("MicroMsg.Music.MusicFileUtil", "music name %s path %s", new Object[] { paramString, localo.hes() });
    paramString = aa.z(localo.her());
    AppMethodBeat.o(137446);
    return paramString;
  }
  
  private static String bU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137447);
    if (paramBoolean)
    {
      paramString = MD5Util.getMD5String(new StringBuilder().append(paramString).append("temp").toString()) + "-wifi";
      AppMethodBeat.o(137447);
      return paramString;
    }
    paramString = MD5Util.getMD5String(paramString + "temp");
    AppMethodBeat.o(137447);
    return paramString;
  }
  
  public static String bV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137448);
    paramString = bT(paramString, false) + "-thumb-" + paramBoolean;
    AppMethodBeat.o(137448);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.b
 * JD-Core Version:    0.7.0.1
 */