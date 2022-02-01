package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;

public final class b
{
  public static String O(f paramf)
  {
    AppMethodBeat.i(137444);
    if (paramf.ijX == 6)
    {
      paramf = "6_" + P(paramf);
      AppMethodBeat.o(137444);
      return paramf;
    }
    paramf = "0_" + P(paramf);
    AppMethodBeat.o(137444);
    return paramf;
  }
  
  private static String P(f paramf)
  {
    AppMethodBeat.i(137445);
    if (TextUtils.isEmpty(paramf.ijZ))
    {
      AppMethodBeat.o(137445);
      return "";
    }
    paramf = aj.ej(paramf.ijZ);
    AppMethodBeat.o(137445);
    return paramf;
  }
  
  public static String auc(String paramString)
  {
    AppMethodBeat.i(137442);
    paramString = "piece" + aj.ej(new StringBuilder().append(paramString.hashCode()).toString());
    AppMethodBeat.o(137442);
    return paramString;
  }
  
  public static String aud(String paramString)
  {
    AppMethodBeat.i(137443);
    k localk = new k(g.getAccPath(), "music");
    if (!localk.exists()) {
      localk.mkdirs();
    }
    paramString = auc(paramString);
    localk = new k(localk, paramString);
    ae.d("MicroMsg.Music.MusicFileUtil", "getMusicPieceFilePath music name %s path %s", new Object[] { paramString, localk.fTi() });
    paramString = w.B(localk.fTh());
    AppMethodBeat.o(137443);
    return paramString;
  }
  
  public static String bD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137446);
    k localk = new k(g.getAccPath(), "music");
    if (!localk.exists()) {
      ae.i("MicroMsg.Music.MusicFileUtil", "create file folder:%b for path:%s", new Object[] { Boolean.valueOf(localk.mkdirs()), w.B(localk.fTh()) });
    }
    paramString = bE(paramString, paramBoolean);
    localk = new k(localk, paramString);
    ae.d("MicroMsg.Music.MusicFileUtil", "music name %s path %s", new Object[] { paramString, localk.fTi() });
    paramString = w.B(localk.fTh());
    AppMethodBeat.o(137446);
    return paramString;
  }
  
  private static String bE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137447);
    if (paramBoolean)
    {
      paramString = aj.ej(new StringBuilder().append(paramString).append("temp").toString()) + "-wifi";
      AppMethodBeat.o(137447);
      return paramString;
    }
    paramString = aj.ej(paramString + "temp");
    AppMethodBeat.o(137447);
    return paramString;
  }
  
  public static String bF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137448);
    paramString = bD(paramString, false) + "-thumb-" + paramBoolean;
    AppMethodBeat.o(137448);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.b
 * JD-Core Version:    0.7.0.1
 */