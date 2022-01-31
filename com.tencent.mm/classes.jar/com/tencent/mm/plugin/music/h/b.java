package com.tencent.mm.plugin.music.h;

import com.tencent.mm.av.e;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class b
{
  public static String JH(String paramString)
  {
    return "piece" + ad.bB(new StringBuilder().append(paramString.hashCode()).toString());
  }
  
  public static String JI(String paramString)
  {
    File localFile = new File(g.FU(), "music");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString = JH(paramString);
    localFile = new File(localFile, paramString);
    y.d("MicroMsg.Music.MusicFileUtil", "getMusicPieceFilePath music name %s path %s", new Object[] { paramString, localFile.getAbsoluteFile() });
    return localFile.getAbsolutePath();
  }
  
  public static String K(e parame)
  {
    if (parame.euv == 6) {
      return "6_" + ad.bB(parame.eux);
    }
    return "0_" + ad.bB(parame.eux);
  }
  
  public static String aN(String paramString, boolean paramBoolean)
  {
    File localFile = new File(g.FU(), "music");
    if (!localFile.exists()) {
      y.i("MicroMsg.Music.MusicFileUtil", "create file folder:%b for path:%s", new Object[] { Boolean.valueOf(localFile.mkdirs()), localFile.getAbsolutePath() });
    }
    if (paramBoolean) {}
    for (paramString = ad.bB(new StringBuilder().append(paramString).append("temp").toString()) + "-wifi";; paramString = ad.bB(paramString + "temp"))
    {
      localFile = new File(localFile, paramString);
      y.d("MicroMsg.Music.MusicFileUtil", "music name %s path %s", new Object[] { paramString, localFile.getAbsoluteFile() });
      return localFile.getAbsolutePath();
    }
  }
  
  public static String aO(String paramString, boolean paramBoolean)
  {
    return aN(paramString, false) + "-thumb-" + paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.b
 * JD-Core Version:    0.7.0.1
 */