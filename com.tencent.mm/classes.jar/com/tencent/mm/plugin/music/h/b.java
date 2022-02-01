package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class b
{
  public static String O(f paramf)
  {
    AppMethodBeat.i(137444);
    if (paramf.hNQ == 6)
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
    if (TextUtils.isEmpty(paramf.hNS))
    {
      AppMethodBeat.o(137445);
      return "";
    }
    paramf = ah.dg(paramf.hNS);
    AppMethodBeat.o(137445);
    return paramf;
  }
  
  public static String anQ(String paramString)
  {
    AppMethodBeat.i(137442);
    paramString = "piece" + ah.dg(new StringBuilder().append(paramString.hashCode()).toString());
    AppMethodBeat.o(137442);
    return paramString;
  }
  
  public static String anR(String paramString)
  {
    AppMethodBeat.i(137443);
    e locale = new e(g.getAccPath(), "music");
    if (!locale.exists()) {
      locale.mkdirs();
    }
    paramString = anQ(paramString);
    locale = new e(locale, paramString);
    ac.d("MicroMsg.Music.MusicFileUtil", "getMusicPieceFilePath music name %s path %s", new Object[] { paramString, locale.fxW() });
    paramString = q.B(locale.fxV());
    AppMethodBeat.o(137443);
    return paramString;
  }
  
  public static String bs(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137446);
    e locale = new e(g.getAccPath(), "music");
    if (!locale.exists()) {
      ac.i("MicroMsg.Music.MusicFileUtil", "create file folder:%b for path:%s", new Object[] { Boolean.valueOf(locale.mkdirs()), q.B(locale.fxV()) });
    }
    paramString = bt(paramString, paramBoolean);
    locale = new e(locale, paramString);
    ac.d("MicroMsg.Music.MusicFileUtil", "music name %s path %s", new Object[] { paramString, locale.fxW() });
    paramString = q.B(locale.fxV());
    AppMethodBeat.o(137446);
    return paramString;
  }
  
  private static String bt(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137447);
    if (paramBoolean)
    {
      paramString = ah.dg(new StringBuilder().append(paramString).append("temp").toString()) + "-wifi";
      AppMethodBeat.o(137447);
      return paramString;
    }
    paramString = ah.dg(paramString + "temp");
    AppMethodBeat.o(137447);
    return paramString;
  }
  
  public static String bu(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137448);
    paramString = bs(paramString, false) + "-thumb-" + paramBoolean;
    AppMethodBeat.o(137448);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.b
 * JD-Core Version:    0.7.0.1
 */