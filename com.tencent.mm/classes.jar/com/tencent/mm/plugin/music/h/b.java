package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;

public final class b
{
  public static String Y(f paramf)
  {
    AppMethodBeat.i(137444);
    if (paramf.oOt == 6)
    {
      paramf = "6_" + Z(paramf);
      AppMethodBeat.o(137444);
      return paramf;
    }
    paramf = "0_" + Z(paramf);
    AppMethodBeat.o(137444);
    return paramf;
  }
  
  private static String Z(f paramf)
  {
    AppMethodBeat.i(137445);
    if (TextUtils.isEmpty(paramf.oOv))
    {
      AppMethodBeat.o(137445);
      return "";
    }
    paramf = MD5Util.getMD5String(paramf.oOv);
    AppMethodBeat.o(137445);
    return paramf;
  }
  
  public static String aPn(String paramString)
  {
    AppMethodBeat.i(137442);
    paramString = "piece" + MD5Util.getMD5String(new StringBuilder().append(paramString.hashCode()).toString());
    AppMethodBeat.o(137442);
    return paramString;
  }
  
  public static String aPo(String paramString)
  {
    AppMethodBeat.i(137443);
    u localu = new u(g.getAccPath(), "music");
    if (!localu.jKS()) {
      localu.jKY();
    }
    paramString = aPn(paramString);
    localu = new u(localu, paramString);
    Log.d("MicroMsg.Music.MusicFileUtil", "getMusicPieceFilePath music name %s path %s", new Object[] { paramString, localu.jKU() });
    paramString = ah.v(localu.jKT());
    AppMethodBeat.o(137443);
    return paramString;
  }
  
  public static String aPp(String paramString)
  {
    AppMethodBeat.i(270846);
    paramString = cy(paramString.hashCode(), false);
    AppMethodBeat.o(270846);
    return paramString;
  }
  
  public static String cA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137448);
    paramString = cy(paramString, false) + "-thumb-" + paramBoolean;
    AppMethodBeat.o(137448);
    return paramString;
  }
  
  public static String cy(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137446);
    u localu = new u(g.getAccPath(), "music");
    if (!localu.jKS()) {
      Log.i("MicroMsg.Music.MusicFileUtil", "create file folder:%b for path:%s", new Object[] { Boolean.valueOf(localu.jKY()), ah.v(localu.jKT()) });
    }
    paramString = cz(paramString, paramBoolean);
    localu = new u(localu, paramString);
    Log.d("MicroMsg.Music.MusicFileUtil", "music name %s path %s", new Object[] { paramString, localu.jKU() });
    paramString = ah.v(localu.jKT());
    AppMethodBeat.o(137446);
    return paramString;
  }
  
  private static String cz(String paramString, boolean paramBoolean)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.b
 * JD-Core Version:    0.7.0.1
 */