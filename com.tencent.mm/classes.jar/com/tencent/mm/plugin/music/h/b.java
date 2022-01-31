package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import java.io.File;

public final class b
{
  public static String K(e parame)
  {
    AppMethodBeat.i(137692);
    if (parame.fKh == 6)
    {
      parame = "6_" + L(parame);
      AppMethodBeat.o(137692);
      return parame;
    }
    parame = "0_" + L(parame);
    AppMethodBeat.o(137692);
    return parame;
  }
  
  private static String L(e parame)
  {
    AppMethodBeat.i(141843);
    if (TextUtils.isEmpty(parame.fKj))
    {
      AppMethodBeat.o(141843);
      return "";
    }
    parame = ag.cE(parame.fKj);
    AppMethodBeat.o(141843);
    return parame;
  }
  
  public static String VH(String paramString)
  {
    AppMethodBeat.i(137690);
    paramString = "piece" + ag.cE(new StringBuilder().append(paramString.hashCode()).toString());
    AppMethodBeat.o(137690);
    return paramString;
  }
  
  public static String VI(String paramString)
  {
    AppMethodBeat.i(137691);
    File localFile = new File(g.getAccPath(), "music");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString = VH(paramString);
    localFile = new File(localFile, paramString);
    ab.d("MicroMsg.Music.MusicFileUtil", "getMusicPieceFilePath music name %s path %s", new Object[] { paramString, localFile.getAbsoluteFile() });
    paramString = localFile.getAbsolutePath();
    AppMethodBeat.o(137691);
    return paramString;
  }
  
  public static String bc(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137693);
    File localFile = new File(g.getAccPath(), "music");
    if (!localFile.exists()) {
      ab.i("MicroMsg.Music.MusicFileUtil", "create file folder:%b for path:%s", new Object[] { Boolean.valueOf(localFile.mkdirs()), localFile.getAbsolutePath() });
    }
    paramString = bd(paramString, paramBoolean);
    localFile = new File(localFile, paramString);
    ab.d("MicroMsg.Music.MusicFileUtil", "music name %s path %s", new Object[] { paramString, localFile.getAbsoluteFile() });
    paramString = localFile.getAbsolutePath();
    AppMethodBeat.o(137693);
    return paramString;
  }
  
  private static String bd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137694);
    if (paramBoolean)
    {
      paramString = ag.cE(new StringBuilder().append(paramString).append("temp").toString()) + "-wifi";
      AppMethodBeat.o(137694);
      return paramString;
    }
    paramString = ag.cE(paramString + "temp");
    AppMethodBeat.o(137694);
    return paramString;
  }
  
  public static String be(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137695);
    paramString = bc(paramString, false) + "-thumb-" + paramBoolean;
    AppMethodBeat.o(137695);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.b
 * JD-Core Version:    0.7.0.1
 */