package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Map;

public final class g
{
  private static int tVA;
  private static ag<String, String> tVt;
  private static ag<String, Boolean> tVu;
  private static ag<String, Integer> tVv;
  private static ag<String, Integer> tVw;
  private static ag<String, Long> tVx;
  private static ag<String, String> tVy;
  private static String tVz;
  
  static
  {
    AppMethodBeat.i(137194);
    tVt = new ag(20);
    tVu = new ag(20);
    tVv = new ag(20);
    tVw = new ag(20);
    tVx = new ag(20);
    tVy = new ag(20);
    tVz = null;
    tVA = 0;
    AppMethodBeat.o(137194);
  }
  
  public static void aW(String paramString, long paramLong)
  {
    AppMethodBeat.i(137187);
    if (paramLong > 0L) {
      tVx.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(137187);
  }
  
  public static int aiA(String paramString)
  {
    AppMethodBeat.i(137191);
    if ((paramString != null) && (tVv.aN(paramString)))
    {
      int i = ((Integer)tVv.get(paramString)).intValue();
      AppMethodBeat.o(137191);
      return i;
    }
    AppMethodBeat.o(137191);
    return 0;
  }
  
  public static int aiB(String paramString)
  {
    AppMethodBeat.i(137193);
    if ((paramString != null) && (tVw.aN(paramString)))
    {
      int i = ((Integer)tVw.get(paramString)).intValue();
      AppMethodBeat.o(137193);
      return i;
    }
    AppMethodBeat.o(137193);
    return 0;
  }
  
  public static void ait(String paramString)
  {
    AppMethodBeat.i(137176);
    if (!TextUtils.isEmpty(aiu(paramString)))
    {
      AppMethodBeat.o(137176);
      return;
    }
    if (e.cUJ()) {}
    for (String str = ((c)com.tencent.mm.plugin.music.f.c.b.aP(c.class)).aio(paramString);; str = "")
    {
      if (!TextUtils.isEmpty(str))
      {
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(str);
        new f(localArrayList).cUB();
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str))) {
          tVt.put(paramString, str);
        }
      }
      AppMethodBeat.o(137176);
      return;
      ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static String aiu(String paramString)
  {
    AppMethodBeat.i(137179);
    if (tVt.aN(paramString))
    {
      paramString = (String)tVt.get(paramString);
      AppMethodBeat.o(137179);
      return paramString;
    }
    AppMethodBeat.o(137179);
    return "";
  }
  
  public static boolean aiv(String paramString)
  {
    AppMethodBeat.i(137181);
    if (tVu.aN(paramString))
    {
      boolean bool = ((Boolean)tVu.get(paramString)).booleanValue();
      AppMethodBeat.o(137181);
      return bool;
    }
    AppMethodBeat.o(137181);
    return false;
  }
  
  public static String aiw(String paramString)
  {
    AppMethodBeat.i(137184);
    paramString = aiu(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137184);
      return null;
    }
    if (e.cUJ())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.aP(c.class)).aiq(paramString);
      AppMethodBeat.o(137184);
      return paramString;
    }
    ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137184);
    return null;
  }
  
  public static String aix(String paramString)
  {
    AppMethodBeat.i(137185);
    if (tVy.aN(paramString))
    {
      paramString = (String)tVy.get(paramString);
      AppMethodBeat.o(137185);
      return paramString;
    }
    AppMethodBeat.o(137185);
    return null;
  }
  
  public static long aiy(String paramString)
  {
    AppMethodBeat.i(137186);
    if (tVx.aN(paramString))
    {
      long l = ((Long)tVx.get(paramString)).longValue();
      AppMethodBeat.o(137186);
      return l;
    }
    AppMethodBeat.o(137186);
    return -1L;
  }
  
  public static void aiz(String paramString)
  {
    AppMethodBeat.i(137189);
    Logger.i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
    h.aiz(com.tencent.mm.plugin.music.h.b.aiV(paramString));
    AppMethodBeat.o(137189);
  }
  
  public static void bk(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137180);
    if (!TextUtils.isEmpty(paramString)) {
      tVu.put(paramString, Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(137180);
  }
  
  public static int cUD()
  {
    AppMethodBeat.i(137178);
    if (tVA != 0)
    {
      i = tVA;
      AppMethodBeat.o(137178);
      return i;
    }
    if (e.cUJ()) {}
    for (int i = ((c)com.tencent.mm.plugin.music.f.c.b.aP(c.class)).cUD();; i = 3)
    {
      tVA = i;
      ad.i("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", new Object[] { Integer.valueOf(tVA) });
      if (tVA == 0) {
        tVA = 3;
      }
      i = tVA;
      AppMethodBeat.o(137178);
      return i;
      ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static void dX(String paramString, int paramInt)
  {
    AppMethodBeat.i(137190);
    if (paramString != null) {
      tVv.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137190);
  }
  
  public static void dY(String paramString, int paramInt)
  {
    AppMethodBeat.i(137192);
    if (paramString != null) {
      tVw.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137192);
  }
  
  public static long fN(String paramString)
  {
    AppMethodBeat.i(137188);
    long l = h.fN(paramString);
    AppMethodBeat.o(137188);
    return l;
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137177);
    if (tVz != null)
    {
      str = tVz;
      AppMethodBeat.o(137177);
      return str;
    }
    String str = e.getAccPath();
    if (TextUtils.isEmpty(str))
    {
      ad.i("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", new Object[] { str });
      str = com.tencent.mm.loader.j.b.aih();
      AppMethodBeat.o(137177);
      return str;
    }
    ad.i("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", new Object[] { str });
    tVz = str;
    AppMethodBeat.o(137177);
    return str;
  }
  
  public static void hD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137183);
    String str = aiu(paramString1);
    if (TextUtils.isEmpty(str))
    {
      ad.e("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137183);
      return;
    }
    if (!TextUtils.isEmpty(aix(paramString1)))
    {
      AppMethodBeat.o(137183);
      return;
    }
    ad.i("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", new Object[] { paramString1, paramString2 });
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      tVy.put(paramString1, paramString2);
    }
    if (e.cUJ())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.aP(c.class)).hB(str, paramString2);
      AppMethodBeat.o(137183);
      return;
    }
    ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137183);
  }
  
  public static void y(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137182);
    if (paramMap != null) {
      aiv(paramString);
    }
    AppMethodBeat.o(137182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.g
 * JD-Core Version:    0.7.0.1
 */