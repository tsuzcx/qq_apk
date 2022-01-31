package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Map;

public final class g
{
  private static ab<String, String> myf = new ab(20);
  private static ab<String, Boolean> myg = new ab(20);
  private static ab<String, Integer> myh = new ab(20);
  private static ab<String, Integer> myi = new ab(20);
  private static ab<String, Long> myj = new ab(20);
  private static ab<String, String> myk = new ab(20);
  private static String myl = null;
  private static int mym = 0;
  
  public static String FU()
  {
    if (myl != null) {
      return myl;
    }
    String str = e.FU();
    if (TextUtils.isEmpty(str))
    {
      y.i("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", new Object[] { str });
      return com.tencent.mm.loader.a.b.bkH;
    }
    y.i("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", new Object[] { str });
    myl = str;
    return str;
  }
  
  public static void Jl(String paramString)
  {
    if (!TextUtils.isEmpty(Jm(paramString))) {}
    label102:
    for (;;)
    {
      return;
      if (e.bmM()) {}
      for (String str = ((c)com.tencent.mm.plugin.music.f.c.b.Q(c.class)).Jh(paramString);; str = "")
      {
        if (TextUtils.isEmpty(str)) {
          break label102;
        }
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(str);
        new f(localArrayList).bmH();
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str))) {
          break;
        }
        myf.put(paramString, str);
        return;
        y.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
      }
    }
  }
  
  public static String Jm(String paramString)
  {
    if (myf.aC(paramString)) {
      return (String)myf.get(paramString);
    }
    return "";
  }
  
  public static boolean Jn(String paramString)
  {
    if (myg.aC(paramString)) {
      return ((Boolean)myg.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public static String Jo(String paramString)
  {
    paramString = Jm(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
      return null;
    }
    if (e.bmM()) {
      return ((c)com.tencent.mm.plugin.music.f.c.b.Q(c.class)).Jj(paramString);
    }
    y.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    return null;
  }
  
  public static String Jp(String paramString)
  {
    if (myk.aC(paramString)) {
      return (String)myk.get(paramString);
    }
    return null;
  }
  
  public static long Jq(String paramString)
  {
    if (myj.aC(paramString)) {
      return ((Long)myj.get(paramString)).longValue();
    }
    return -1L;
  }
  
  public static long Jr(String paramString)
  {
    return h.Jr(paramString);
  }
  
  public static int Js(String paramString)
  {
    if ((paramString != null) && (myh.aC(paramString))) {
      return ((Integer)myh.get(paramString)).intValue();
    }
    return 0;
  }
  
  public static int Jt(String paramString)
  {
    if ((paramString != null) && (myi.aC(paramString))) {
      return ((Integer)myi.get(paramString)).intValue();
    }
    return 0;
  }
  
  public static void aM(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {
      myg.put(paramString, Boolean.valueOf(paramBoolean));
    }
  }
  
  public static void ae(String paramString, long paramLong)
  {
    if (paramLong > 0L) {
      myj.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public static int bmJ()
  {
    if (mym != 0) {
      return mym;
    }
    if (e.bmM()) {}
    for (int i = ((c)com.tencent.mm.plugin.music.f.c.b.Q(c.class)).bmJ();; i = 3)
    {
      mym = i;
      y.i("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", new Object[] { Integer.valueOf(mym) });
      if (mym == 0) {
        mym = 3;
      }
      return mym;
      y.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static void ca(String paramString, int paramInt)
  {
    if (paramString != null) {
      myh.put(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public static void cb(String paramString, int paramInt)
  {
    if (paramString != null) {
      myi.put(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public static void deleteFile(String paramString)
  {
    Logger.i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
    h.deleteFile(com.tencent.mm.plugin.music.h.b.JI(paramString));
  }
  
  public static void ed(String paramString1, String paramString2)
  {
    String str = Jm(paramString1);
    if (TextUtils.isEmpty(str)) {
      y.e("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
    }
    while (!TextUtils.isEmpty(Jp(paramString1))) {
      return;
    }
    y.i("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", new Object[] { paramString1, paramString2 });
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      myk.put(paramString1, paramString2);
    }
    if (e.bmM())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.Q(c.class)).eb(str, paramString2);
      return;
    }
    y.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
  }
  
  public static void n(String paramString, Map<String, String> paramMap)
  {
    if ((paramMap != null) && (Jn(paramString)))
    {
      paramMap.put("Cookie", "qqmusic_fromtag=97;qqmusic_uin=1234567;qqmusic_key=;");
      paramMap.put("referer", "stream12.qqmusic.qq.com");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.g
 * JD-Core Version:    0.7.0.1
 */