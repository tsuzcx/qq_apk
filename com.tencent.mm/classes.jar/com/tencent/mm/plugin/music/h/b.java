package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.q;

public final class b
{
  public static String S(f paramf)
  {
    AppMethodBeat.i(137444);
    if (paramf.lVr == 6)
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
    if (TextUtils.isEmpty(paramf.lVt))
    {
      AppMethodBeat.o(137445);
      return "";
    }
    paramf = MD5Util.getMD5String(paramf.lVt);
    AppMethodBeat.o(137445);
    return paramf;
  }
  
  public static String aSt(String paramString)
  {
    AppMethodBeat.i(137442);
    paramString = "piece" + MD5Util.getMD5String(new StringBuilder().append(paramString.hashCode()).toString());
    AppMethodBeat.o(137442);
    return paramString;
  }
  
  public static String aSu(String paramString)
  {
    AppMethodBeat.i(137443);
    q localq = new q(g.getAccPath(), "music");
    if (!localq.ifE()) {
      localq.ifL();
    }
    paramString = aSt(paramString);
    localq = new q(localq, paramString);
    Log.d("MicroMsg.Music.MusicFileUtil", "getMusicPieceFilePath music name %s path %s", new Object[] { paramString, localq.ifG() });
    paramString = localq.bOF();
    AppMethodBeat.o(137443);
    return paramString;
  }
  
  public static String aSv(String paramString)
  {
    AppMethodBeat.i(257242);
    paramString = cc(paramString.hashCode(), false);
    AppMethodBeat.o(257242);
    return paramString;
  }
  
  public static String cc(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137446);
    q localq = new q(g.getAccPath(), "music");
    if (!localq.ifE()) {
      Log.i("MicroMsg.Music.MusicFileUtil", "create file folder:%b for path:%s", new Object[] { Boolean.valueOf(localq.ifL()), localq.bOF() });
    }
    paramString = cd(paramString, paramBoolean);
    localq = new q(localq, paramString);
    Log.d("MicroMsg.Music.MusicFileUtil", "music name %s path %s", new Object[] { paramString, localq.ifG() });
    paramString = localq.bOF();
    AppMethodBeat.o(137446);
    return paramString;
  }
  
  private static String cd(String paramString, boolean paramBoolean)
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
  
  public static String ce(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137448);
    paramString = cc(paramString, false) + "-thumb-" + paramBoolean;
    AppMethodBeat.o(137448);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.b
 * JD-Core Version:    0.7.0.1
 */