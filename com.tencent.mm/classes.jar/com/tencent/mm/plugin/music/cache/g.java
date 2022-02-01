package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Map;

public final class g
{
  private static LruCache<String, String> FPH;
  private static LruCache<String, Boolean> FPI;
  private static LruCache<String, Integer> FPJ;
  private static LruCache<String, Integer> FPK;
  private static LruCache<String, Long> FPL;
  private static LruCache<String, String> FPM;
  private static LruCache<String, Boolean> FPN;
  private static String FPO;
  private static int FPP;
  
  static
  {
    AppMethodBeat.i(137194);
    FPH = new LruCache(20);
    FPI = new LruCache(20);
    FPJ = new LruCache(20);
    FPK = new LruCache(20);
    FPL = new LruCache(20);
    FPM = new LruCache(20);
    FPN = new LruCache(20);
    FPO = null;
    FPP = 0;
    AppMethodBeat.o(137194);
  }
  
  public static void J(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137182);
    if (paramMap != null) {
      aRN(paramString);
    }
    AppMethodBeat.o(137182);
  }
  
  public static void aRL(String paramString)
  {
    AppMethodBeat.i(137176);
    if (!TextUtils.isEmpty(aRM(paramString)))
    {
      AppMethodBeat.o(137176);
      return;
    }
    if (e.fdV()) {}
    for (String str = ((c)com.tencent.mm.plugin.music.f.c.b.bm(c.class)).aRH(paramString);; str = "")
    {
      if (!TextUtils.isEmpty(str))
      {
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(str);
        new f(localArrayList).fdP();
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str))) {
          FPH.put(paramString, str);
        }
      }
      AppMethodBeat.o(137176);
      return;
      Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static String aRM(String paramString)
  {
    AppMethodBeat.i(137179);
    if (FPH.check(paramString))
    {
      paramString = (String)FPH.get(paramString);
      AppMethodBeat.o(137179);
      return paramString;
    }
    AppMethodBeat.o(137179);
    return "";
  }
  
  public static boolean aRN(String paramString)
  {
    AppMethodBeat.i(137181);
    if (FPI.check(paramString))
    {
      boolean bool = ((Boolean)FPI.get(paramString)).booleanValue();
      AppMethodBeat.o(137181);
      return bool;
    }
    AppMethodBeat.o(137181);
    return false;
  }
  
  public static String aRO(String paramString)
  {
    AppMethodBeat.i(137184);
    paramString = aRM(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137184);
      return null;
    }
    if (e.fdV())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.bm(c.class)).aRJ(paramString);
      AppMethodBeat.o(137184);
      return paramString;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137184);
    return null;
  }
  
  public static String aRP(String paramString)
  {
    AppMethodBeat.i(137185);
    if (FPM.check(paramString))
    {
      paramString = (String)FPM.get(paramString);
      AppMethodBeat.o(137185);
      return paramString;
    }
    AppMethodBeat.o(137185);
    return null;
  }
  
  public static long aRQ(String paramString)
  {
    AppMethodBeat.i(137186);
    if (FPL.check(paramString))
    {
      long l = ((Long)FPL.get(paramString)).longValue();
      AppMethodBeat.o(137186);
      return l;
    }
    AppMethodBeat.o(137186);
    return -1L;
  }
  
  public static void aRR(String paramString)
  {
    AppMethodBeat.i(137189);
    Logger.i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
    h.aRR(com.tencent.mm.plugin.music.h.b.aSu(paramString));
    AppMethodBeat.o(137189);
  }
  
  public static int aRS(String paramString)
  {
    AppMethodBeat.i(137191);
    if ((paramString != null) && (FPJ.check(paramString)))
    {
      int i = ((Integer)FPJ.get(paramString)).intValue();
      AppMethodBeat.o(137191);
      return i;
    }
    AppMethodBeat.o(137191);
    return 0;
  }
  
  public static int aRT(String paramString)
  {
    AppMethodBeat.i(137193);
    if ((paramString != null) && (FPK.check(paramString)))
    {
      int i = ((Integer)FPK.get(paramString)).intValue();
      AppMethodBeat.o(137193);
      return i;
    }
    AppMethodBeat.o(137193);
    return 0;
  }
  
  public static boolean aRU(String paramString)
  {
    AppMethodBeat.i(257098);
    if (FPN.check(paramString))
    {
      boolean bool = ((Boolean)FPN.get(paramString)).booleanValue();
      AppMethodBeat.o(257098);
      return bool;
    }
    AppMethodBeat.o(257098);
    return false;
  }
  
  public static void bZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137180);
    if (!TextUtils.isEmpty(paramString)) {
      FPI.put(paramString, Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(137180);
  }
  
  public static void bd(String paramString, long paramLong)
  {
    AppMethodBeat.i(137187);
    if (paramLong > 0L) {
      FPL.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(137187);
  }
  
  public static void ca(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(257095);
    if (!TextUtils.isEmpty(paramString)) {
      FPN.put(paramString, Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(257095);
  }
  
  public static int fdR()
  {
    AppMethodBeat.i(137178);
    if (FPP != 0)
    {
      i = FPP;
      AppMethodBeat.o(137178);
      return i;
    }
    if (e.fdV()) {}
    for (int i = ((c)com.tencent.mm.plugin.music.f.c.b.bm(c.class)).fdR();; i = 3)
    {
      FPP = i;
      Log.i("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", new Object[] { Integer.valueOf(FPP) });
      if (FPP == 0) {
        FPP = 3;
      }
      i = FPP;
      AppMethodBeat.o(137178);
      return i;
      Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static void fu(String paramString, int paramInt)
  {
    AppMethodBeat.i(137190);
    if (paramString != null) {
      FPJ.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137190);
  }
  
  public static void fv(String paramString, int paramInt)
  {
    AppMethodBeat.i(137192);
    if (paramString != null) {
      FPK.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137192);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137177);
    if (FPO != null)
    {
      str = FPO;
      AppMethodBeat.o(137177);
      return str;
    }
    String str = e.getAccPath();
    if (TextUtils.isEmpty(str))
    {
      Log.i("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", new Object[] { str });
      str = com.tencent.mm.loader.j.b.aSL();
      AppMethodBeat.o(137177);
      return str;
    }
    Log.i("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", new Object[] { str });
    FPO = str;
    AppMethodBeat.o(137177);
    return str;
  }
  
  public static long ij(String paramString)
  {
    AppMethodBeat.i(137188);
    long l = h.ij(paramString);
    AppMethodBeat.o(137188);
    return l;
  }
  
  public static void jg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137183);
    String str = aRM(paramString1);
    if (TextUtils.isEmpty(str))
    {
      Log.e("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137183);
      return;
    }
    if (!TextUtils.isEmpty(aRP(paramString1)))
    {
      AppMethodBeat.o(137183);
      return;
    }
    Log.i("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", new Object[] { paramString1, paramString2 });
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      FPM.put(paramString1, paramString2);
    }
    if (e.fdV())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.bm(c.class)).je(str, paramString2);
      AppMethodBeat.o(137183);
      return;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.g
 * JD-Core Version:    0.7.0.1
 */