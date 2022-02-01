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
  private static LruCache<String, String> AiK;
  private static LruCache<String, Boolean> AiL;
  private static LruCache<String, Integer> AiM;
  private static LruCache<String, Integer> AiN;
  private static LruCache<String, Long> AiO;
  private static LruCache<String, String> AiP;
  private static String AiQ;
  private static int AiR;
  
  static
  {
    AppMethodBeat.i(137194);
    AiK = new LruCache(20);
    AiL = new LruCache(20);
    AiM = new LruCache(20);
    AiN = new LruCache(20);
    AiO = new LruCache(20);
    AiP = new LruCache(20);
    AiQ = null;
    AiR = 0;
    AppMethodBeat.o(137194);
  }
  
  public static void H(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137182);
    if (paramMap != null) {
      aHz(paramString);
    }
    AppMethodBeat.o(137182);
  }
  
  public static String aHA(String paramString)
  {
    AppMethodBeat.i(137184);
    paramString = aHy(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137184);
      return null;
    }
    if (e.etK())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.aS(c.class)).aHv(paramString);
      AppMethodBeat.o(137184);
      return paramString;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137184);
    return null;
  }
  
  public static String aHB(String paramString)
  {
    AppMethodBeat.i(137185);
    if (AiP.check(paramString))
    {
      paramString = (String)AiP.get(paramString);
      AppMethodBeat.o(137185);
      return paramString;
    }
    AppMethodBeat.o(137185);
    return null;
  }
  
  public static long aHC(String paramString)
  {
    AppMethodBeat.i(137186);
    if (AiO.check(paramString))
    {
      long l = ((Long)AiO.get(paramString)).longValue();
      AppMethodBeat.o(137186);
      return l;
    }
    AppMethodBeat.o(137186);
    return -1L;
  }
  
  public static void aHD(String paramString)
  {
    AppMethodBeat.i(137189);
    Logger.i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
    h.aHD(com.tencent.mm.plugin.music.h.b.aIe(paramString));
    AppMethodBeat.o(137189);
  }
  
  public static int aHE(String paramString)
  {
    AppMethodBeat.i(137191);
    if ((paramString != null) && (AiM.check(paramString)))
    {
      int i = ((Integer)AiM.get(paramString)).intValue();
      AppMethodBeat.o(137191);
      return i;
    }
    AppMethodBeat.o(137191);
    return 0;
  }
  
  public static int aHF(String paramString)
  {
    AppMethodBeat.i(137193);
    if ((paramString != null) && (AiN.check(paramString)))
    {
      int i = ((Integer)AiN.get(paramString)).intValue();
      AppMethodBeat.o(137193);
      return i;
    }
    AppMethodBeat.o(137193);
    return 0;
  }
  
  public static void aHx(String paramString)
  {
    AppMethodBeat.i(137176);
    if (!TextUtils.isEmpty(aHy(paramString)))
    {
      AppMethodBeat.o(137176);
      return;
    }
    if (e.etK()) {}
    for (String str = ((c)com.tencent.mm.plugin.music.f.c.b.aS(c.class)).aHt(paramString);; str = "")
    {
      if (!TextUtils.isEmpty(str))
      {
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(str);
        new f(localArrayList).etC();
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str))) {
          AiK.put(paramString, str);
        }
      }
      AppMethodBeat.o(137176);
      return;
      Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static String aHy(String paramString)
  {
    AppMethodBeat.i(137179);
    if (AiK.check(paramString))
    {
      paramString = (String)AiK.get(paramString);
      AppMethodBeat.o(137179);
      return paramString;
    }
    AppMethodBeat.o(137179);
    return "";
  }
  
  public static boolean aHz(String paramString)
  {
    AppMethodBeat.i(137181);
    if (AiL.check(paramString))
    {
      boolean bool = ((Boolean)AiL.get(paramString)).booleanValue();
      AppMethodBeat.o(137181);
      return bool;
    }
    AppMethodBeat.o(137181);
    return false;
  }
  
  public static void bS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137180);
    if (!TextUtils.isEmpty(paramString)) {
      AiL.put(paramString, Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(137180);
  }
  
  public static void bc(String paramString, long paramLong)
  {
    AppMethodBeat.i(137187);
    if (paramLong > 0L) {
      AiO.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(137187);
  }
  
  public static void eT(String paramString, int paramInt)
  {
    AppMethodBeat.i(137190);
    if (paramString != null) {
      AiM.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137190);
  }
  
  public static void eU(String paramString, int paramInt)
  {
    AppMethodBeat.i(137192);
    if (paramString != null) {
      AiN.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137192);
  }
  
  public static int etE()
  {
    AppMethodBeat.i(137178);
    if (AiR != 0)
    {
      i = AiR;
      AppMethodBeat.o(137178);
      return i;
    }
    if (e.etK()) {}
    for (int i = ((c)com.tencent.mm.plugin.music.f.c.b.aS(c.class)).etE();; i = 3)
    {
      AiR = i;
      Log.i("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", new Object[] { Integer.valueOf(AiR) });
      if (AiR == 0) {
        AiR = 3;
      }
      i = AiR;
      AppMethodBeat.o(137178);
      return i;
      Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137177);
    if (AiQ != null)
    {
      str = AiQ;
      AppMethodBeat.o(137177);
      return str;
    }
    String str = e.getAccPath();
    if (TextUtils.isEmpty(str))
    {
      Log.i("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", new Object[] { str });
      str = com.tencent.mm.loader.j.b.aKJ();
      AppMethodBeat.o(137177);
      return str;
    }
    Log.i("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", new Object[] { str });
    AiQ = str;
    AppMethodBeat.o(137177);
    return str;
  }
  
  public static long hv(String paramString)
  {
    AppMethodBeat.i(137188);
    long l = h.hv(paramString);
    AppMethodBeat.o(137188);
    return l;
  }
  
  public static void iW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137183);
    String str = aHy(paramString1);
    if (TextUtils.isEmpty(str))
    {
      Log.e("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137183);
      return;
    }
    if (!TextUtils.isEmpty(aHB(paramString1)))
    {
      AppMethodBeat.o(137183);
      return;
    }
    Log.i("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", new Object[] { paramString1, paramString2 });
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      AiP.put(paramString1, paramString2);
    }
    if (e.etK())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.aS(c.class)).iU(str, paramString2);
      AppMethodBeat.o(137183);
      return;
    }
    Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.g
 * JD-Core Version:    0.7.0.1
 */