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
  private static LruCache<String, String> LKD;
  private static LruCache<String, Boolean> LKE;
  private static LruCache<String, Integer> LKF;
  private static LruCache<String, Integer> LKG;
  private static LruCache<String, Long> LKH;
  private static LruCache<String, String> LKI;
  private static LruCache<String, Boolean> LKJ;
  private static String LKK;
  private static int LKL;
  
  static
  {
    AppMethodBeat.i(137194);
    LKD = new LruCache(20);
    LKE = new LruCache(20);
    LKF = new LruCache(20);
    LKG = new LruCache(20);
    LKH = new LruCache(20);
    LKI = new LruCache(20);
    LKJ = new LruCache(20);
    LKK = null;
    LKL = 0;
    AppMethodBeat.o(137194);
  }
  
  public static void R(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137182);
    if (paramMap != null) {
      aOF(paramString);
    }
    AppMethodBeat.o(137182);
  }
  
  public static void aOD(String paramString)
  {
    AppMethodBeat.i(137176);
    if (!TextUtils.isEmpty(aOE(paramString)))
    {
      AppMethodBeat.o(137176);
      return;
    }
    if (e.gmX()) {}
    for (String str = ((c)com.tencent.mm.plugin.music.e.c.b.bU(c.class)).aOz(paramString);; str = "")
    {
      if (!TextUtils.isEmpty(str))
      {
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(str);
        new f(localArrayList).gmQ();
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str))) {
          LKD.put(paramString, str);
        }
      }
      AppMethodBeat.o(137176);
      return;
      Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static String aOE(String paramString)
  {
    AppMethodBeat.i(137179);
    if (LKD.check(paramString))
    {
      paramString = (String)LKD.get(paramString);
      AppMethodBeat.o(137179);
      return paramString;
    }
    AppMethodBeat.o(137179);
    return "";
  }
  
  public static boolean aOF(String paramString)
  {
    AppMethodBeat.i(137181);
    if (LKE.check(paramString))
    {
      boolean bool = ((Boolean)LKE.get(paramString)).booleanValue();
      AppMethodBeat.o(137181);
      return bool;
    }
    AppMethodBeat.o(137181);
    return false;
  }
  
  public static String aOG(String paramString)
  {
    AppMethodBeat.i(137184);
    paramString = aOE(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137184);
      return null;
    }
    if (e.gmX())
    {
      paramString = ((c)com.tencent.mm.plugin.music.e.c.b.bU(c.class)).aOB(paramString);
      AppMethodBeat.o(137184);
      return paramString;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137184);
    return null;
  }
  
  public static String aOH(String paramString)
  {
    AppMethodBeat.i(137185);
    if (LKI.check(paramString))
    {
      paramString = (String)LKI.get(paramString);
      AppMethodBeat.o(137185);
      return paramString;
    }
    AppMethodBeat.o(137185);
    return null;
  }
  
  public static long aOI(String paramString)
  {
    AppMethodBeat.i(137186);
    if (LKH.check(paramString))
    {
      long l = ((Long)LKH.get(paramString)).longValue();
      AppMethodBeat.o(137186);
      return l;
    }
    AppMethodBeat.o(137186);
    return -1L;
  }
  
  public static void aOJ(String paramString)
  {
    AppMethodBeat.i(137189);
    Logger.i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
    h.aOJ(com.tencent.mm.plugin.music.h.b.aPo(paramString));
    AppMethodBeat.o(137189);
  }
  
  public static int aOK(String paramString)
  {
    AppMethodBeat.i(137191);
    if ((paramString != null) && (LKF.check(paramString)))
    {
      int i = ((Integer)LKF.get(paramString)).intValue();
      AppMethodBeat.o(137191);
      return i;
    }
    AppMethodBeat.o(137191);
    return 0;
  }
  
  public static int aOL(String paramString)
  {
    AppMethodBeat.i(137193);
    if ((paramString != null) && (LKG.check(paramString)))
    {
      int i = ((Integer)LKG.get(paramString)).intValue();
      AppMethodBeat.o(137193);
      return i;
    }
    AppMethodBeat.o(137193);
    return 0;
  }
  
  public static boolean aOM(String paramString)
  {
    AppMethodBeat.i(270908);
    if (LKJ.check(paramString))
    {
      boolean bool = ((Boolean)LKJ.get(paramString)).booleanValue();
      AppMethodBeat.o(270908);
      return bool;
    }
    AppMethodBeat.o(270908);
    return false;
  }
  
  public static void bn(String paramString, long paramLong)
  {
    AppMethodBeat.i(137187);
    if (paramLong > 0L) {
      LKH.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(137187);
  }
  
  public static void cv(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137180);
    if (!TextUtils.isEmpty(paramString)) {
      LKE.put(paramString, Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(137180);
  }
  
  public static void cw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(270906);
    if (!TextUtils.isEmpty(paramString)) {
      LKJ.put(paramString, Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(270906);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137177);
    if (LKK != null)
    {
      str = LKK;
      AppMethodBeat.o(137177);
      return str;
    }
    String str = e.getAccPath();
    if (TextUtils.isEmpty(str))
    {
      Log.i("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", new Object[] { str });
      str = com.tencent.mm.loader.i.b.bmz();
      AppMethodBeat.o(137177);
      return str;
    }
    Log.i("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", new Object[] { str });
    LKK = str;
    AppMethodBeat.o(137177);
    return str;
  }
  
  public static int gmS()
  {
    AppMethodBeat.i(137178);
    if (LKL != 0)
    {
      i = LKL;
      AppMethodBeat.o(137178);
      return i;
    }
    if (e.gmX()) {}
    for (int i = ((c)com.tencent.mm.plugin.music.e.c.b.bU(c.class)).gmS();; i = 3)
    {
      LKL = i;
      Log.i("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", new Object[] { Integer.valueOf(LKL) });
      if (LKL == 0) {
        LKL = 3;
      }
      i = LKL;
      AppMethodBeat.o(137178);
      return i;
      Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static void gn(String paramString, int paramInt)
  {
    AppMethodBeat.i(137190);
    if (paramString != null) {
      LKF.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137190);
  }
  
  public static void go(String paramString, int paramInt)
  {
    AppMethodBeat.i(137192);
    if (paramString != null) {
      LKG.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137192);
  }
  
  public static long jK(String paramString)
  {
    AppMethodBeat.i(137188);
    long l = h.jK(paramString);
    AppMethodBeat.o(137188);
    return l;
  }
  
  public static void kv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137183);
    String str = aOE(paramString1);
    if (TextUtils.isEmpty(str))
    {
      Log.e("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137183);
      return;
    }
    if (!TextUtils.isEmpty(aOH(paramString1)))
    {
      AppMethodBeat.o(137183);
      return;
    }
    Log.i("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", new Object[] { paramString1, paramString2 });
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      LKI.put(paramString1, paramString2);
    }
    if (e.gmX())
    {
      ((c)com.tencent.mm.plugin.music.e.c.b.bU(c.class)).kt(str, paramString2);
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