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
  private static ag<String, Integer> wjA;
  private static ag<String, Long> wjB;
  private static ag<String, String> wjC;
  private static String wjD;
  private static int wjE;
  private static ag<String, String> wjx;
  private static ag<String, Boolean> wjy;
  private static ag<String, Integer> wjz;
  
  static
  {
    AppMethodBeat.i(137194);
    wjx = new ag(20);
    wjy = new ag(20);
    wjz = new ag(20);
    wjA = new ag(20);
    wjB = new ag(20);
    wjC = new ag(20);
    wjD = null;
    wjE = 0;
    AppMethodBeat.o(137194);
  }
  
  public static void B(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137182);
    if (paramMap != null) {
      asp(paramString);
    }
    AppMethodBeat.o(137182);
  }
  
  public static void aZ(String paramString, long paramLong)
  {
    AppMethodBeat.i(137187);
    if (paramLong > 0L) {
      wjB.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(137187);
  }
  
  public static void asn(String paramString)
  {
    AppMethodBeat.i(137176);
    if (!TextUtils.isEmpty(aso(paramString)))
    {
      AppMethodBeat.o(137176);
      return;
    }
    if (e.dsB()) {}
    for (String str = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).asi(paramString);; str = "")
    {
      if (!TextUtils.isEmpty(str))
      {
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(str);
        new f(localArrayList).dst();
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str))) {
          wjx.put(paramString, str);
        }
      }
      AppMethodBeat.o(137176);
      return;
      ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static String aso(String paramString)
  {
    AppMethodBeat.i(137179);
    if (wjx.aM(paramString))
    {
      paramString = (String)wjx.get(paramString);
      AppMethodBeat.o(137179);
      return paramString;
    }
    AppMethodBeat.o(137179);
    return "";
  }
  
  public static boolean asp(String paramString)
  {
    AppMethodBeat.i(137181);
    if (wjy.aM(paramString))
    {
      boolean bool = ((Boolean)wjy.get(paramString)).booleanValue();
      AppMethodBeat.o(137181);
      return bool;
    }
    AppMethodBeat.o(137181);
    return false;
  }
  
  public static String asq(String paramString)
  {
    AppMethodBeat.i(137184);
    paramString = aso(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137184);
      return null;
    }
    if (e.dsB())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).ask(paramString);
      AppMethodBeat.o(137184);
      return paramString;
    }
    ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137184);
    return null;
  }
  
  public static String asr(String paramString)
  {
    AppMethodBeat.i(137185);
    if (wjC.aM(paramString))
    {
      paramString = (String)wjC.get(paramString);
      AppMethodBeat.o(137185);
      return paramString;
    }
    AppMethodBeat.o(137185);
    return null;
  }
  
  public static long ass(String paramString)
  {
    AppMethodBeat.i(137186);
    if (wjB.aM(paramString))
    {
      long l = ((Long)wjB.get(paramString)).longValue();
      AppMethodBeat.o(137186);
      return l;
    }
    AppMethodBeat.o(137186);
    return -1L;
  }
  
  public static void ast(String paramString)
  {
    AppMethodBeat.i(137189);
    Logger.i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
    h.ast(com.tencent.mm.plugin.music.h.b.asQ(paramString));
    AppMethodBeat.o(137189);
  }
  
  public static int asu(String paramString)
  {
    AppMethodBeat.i(137191);
    if ((paramString != null) && (wjz.aM(paramString)))
    {
      int i = ((Integer)wjz.get(paramString)).intValue();
      AppMethodBeat.o(137191);
      return i;
    }
    AppMethodBeat.o(137191);
    return 0;
  }
  
  public static int asv(String paramString)
  {
    AppMethodBeat.i(137193);
    if ((paramString != null) && (wjA.aM(paramString)))
    {
      int i = ((Integer)wjA.get(paramString)).intValue();
      AppMethodBeat.o(137193);
      return i;
    }
    AppMethodBeat.o(137193);
    return 0;
  }
  
  public static void by(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137180);
    if (!TextUtils.isEmpty(paramString)) {
      wjy.put(paramString, Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(137180);
  }
  
  public static int dsv()
  {
    AppMethodBeat.i(137178);
    if (wjE != 0)
    {
      i = wjE;
      AppMethodBeat.o(137178);
      return i;
    }
    if (e.dsB()) {}
    for (int i = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dsv();; i = 3)
    {
      wjE = i;
      ad.i("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", new Object[] { Integer.valueOf(wjE) });
      if (wjE == 0) {
        wjE = 3;
      }
      i = wjE;
      AppMethodBeat.o(137178);
      return i;
      ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static void ew(String paramString, int paramInt)
  {
    AppMethodBeat.i(137190);
    if (paramString != null) {
      wjz.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137190);
  }
  
  public static void ex(String paramString, int paramInt)
  {
    AppMethodBeat.i(137192);
    if (paramString != null) {
      wjA.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137192);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137177);
    if (wjD != null)
    {
      str = wjD;
      AppMethodBeat.o(137177);
      return str;
    }
    String str = e.getAccPath();
    if (TextUtils.isEmpty(str))
    {
      ad.i("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", new Object[] { str });
      str = com.tencent.mm.loader.j.b.arU();
      AppMethodBeat.o(137177);
      return str;
    }
    ad.i("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", new Object[] { str });
    wjD = str;
    AppMethodBeat.o(137177);
    return str;
  }
  
  public static long gy(String paramString)
  {
    AppMethodBeat.i(137188);
    long l = h.gy(paramString);
    AppMethodBeat.o(137188);
    return l;
  }
  
  public static void ih(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137183);
    String str = aso(paramString1);
    if (TextUtils.isEmpty(str))
    {
      ad.e("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137183);
      return;
    }
    if (!TextUtils.isEmpty(asr(paramString1)))
    {
      AppMethodBeat.o(137183);
      return;
    }
    ad.i("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", new Object[] { paramString1, paramString2 });
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      wjC.put(paramString1, paramString2);
    }
    if (e.dsB())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).jdMethod_if(str, paramString2);
      AppMethodBeat.o(137183);
      return;
    }
    ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.g
 * JD-Core Version:    0.7.0.1
 */