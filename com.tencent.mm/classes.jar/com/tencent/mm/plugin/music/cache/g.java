package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Map;

public final class g
{
  private static ae<String, String> oYm;
  private static ae<String, Boolean> oYn;
  private static ae<String, Integer> oYo;
  private static ae<String, Integer> oYp;
  private static ae<String, Long> oYq;
  private static ae<String, String> oYr;
  private static String oYs;
  private static int oYt;
  
  static
  {
    AppMethodBeat.i(137444);
    oYm = new ae(20);
    oYn = new ae(20);
    oYo = new ae(20);
    oYp = new ae(20);
    oYq = new ae(20);
    oYr = new ae(20);
    oYs = null;
    oYt = 0;
    AppMethodBeat.o(137444);
  }
  
  public static void Jg(String paramString)
  {
    AppMethodBeat.i(137439);
    Logger.i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
    h.Jg(com.tencent.mm.plugin.music.h.b.VI(paramString));
    AppMethodBeat.o(137439);
  }
  
  public static void Vi(String paramString)
  {
    AppMethodBeat.i(137426);
    if (!TextUtils.isEmpty(Vj(paramString)))
    {
      AppMethodBeat.o(137426);
      return;
    }
    if (e.bVi()) {}
    for (String str = ((c)com.tencent.mm.plugin.music.f.c.b.am(c.class)).Ve(paramString);; str = "")
    {
      if (!TextUtils.isEmpty(str))
      {
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(str);
        new f(localArrayList).bVa();
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str))) {
          oYm.put(paramString, str);
        }
      }
      AppMethodBeat.o(137426);
      return;
      ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static String Vj(String paramString)
  {
    AppMethodBeat.i(137429);
    if (oYm.Z(paramString))
    {
      paramString = (String)oYm.get(paramString);
      AppMethodBeat.o(137429);
      return paramString;
    }
    AppMethodBeat.o(137429);
    return "";
  }
  
  public static boolean Vk(String paramString)
  {
    AppMethodBeat.i(137431);
    if (oYn.Z(paramString))
    {
      boolean bool = ((Boolean)oYn.get(paramString)).booleanValue();
      AppMethodBeat.o(137431);
      return bool;
    }
    AppMethodBeat.o(137431);
    return false;
  }
  
  public static String Vl(String paramString)
  {
    AppMethodBeat.i(137434);
    paramString = Vj(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137434);
      return null;
    }
    if (e.bVi())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.am(c.class)).Vg(paramString);
      AppMethodBeat.o(137434);
      return paramString;
    }
    ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137434);
    return null;
  }
  
  public static String Vm(String paramString)
  {
    AppMethodBeat.i(137435);
    if (oYr.Z(paramString))
    {
      paramString = (String)oYr.get(paramString);
      AppMethodBeat.o(137435);
      return paramString;
    }
    AppMethodBeat.o(137435);
    return null;
  }
  
  public static long Vn(String paramString)
  {
    AppMethodBeat.i(137436);
    if (oYq.Z(paramString))
    {
      long l = ((Long)oYq.get(paramString)).longValue();
      AppMethodBeat.o(137436);
      return l;
    }
    AppMethodBeat.o(137436);
    return -1L;
  }
  
  public static int Vo(String paramString)
  {
    AppMethodBeat.i(137441);
    if ((paramString != null) && (oYo.Z(paramString)))
    {
      int i = ((Integer)oYo.get(paramString)).intValue();
      AppMethodBeat.o(137441);
      return i;
    }
    AppMethodBeat.o(137441);
    return 0;
  }
  
  public static int Vp(String paramString)
  {
    AppMethodBeat.i(137443);
    if ((paramString != null) && (oYp.Z(paramString)))
    {
      int i = ((Integer)oYp.get(paramString)).intValue();
      AppMethodBeat.o(137443);
      return i;
    }
    AppMethodBeat.o(137443);
    return 0;
  }
  
  public static void ax(String paramString, long paramLong)
  {
    AppMethodBeat.i(137437);
    if (paramLong > 0L) {
      oYq.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(137437);
  }
  
  public static int bVc()
  {
    AppMethodBeat.i(137428);
    if (oYt != 0)
    {
      i = oYt;
      AppMethodBeat.o(137428);
      return i;
    }
    if (e.bVi()) {}
    for (int i = ((c)com.tencent.mm.plugin.music.f.c.b.am(c.class)).bVc();; i = 3)
    {
      oYt = i;
      ab.i("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", new Object[] { Integer.valueOf(oYt) });
      if (oYt == 0) {
        oYt = 3;
      }
      i = oYt;
      AppMethodBeat.o(137428);
      return i;
      ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static void bb(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137430);
    if (!TextUtils.isEmpty(paramString)) {
      oYn.put(paramString, Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(137430);
  }
  
  public static void cS(String paramString, int paramInt)
  {
    AppMethodBeat.i(137440);
    if (paramString != null) {
      oYo.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137440);
  }
  
  public static void cT(String paramString, int paramInt)
  {
    AppMethodBeat.i(137442);
    if (paramString != null) {
      oYp.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137442);
  }
  
  public static long eG(String paramString)
  {
    AppMethodBeat.i(137438);
    long l = h.eG(paramString);
    AppMethodBeat.o(137438);
    return l;
  }
  
  public static void fx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137433);
    String str = Vj(paramString1);
    if (TextUtils.isEmpty(str))
    {
      ab.e("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137433);
      return;
    }
    if (!TextUtils.isEmpty(Vm(paramString1)))
    {
      AppMethodBeat.o(137433);
      return;
    }
    ab.i("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", new Object[] { paramString1, paramString2 });
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      oYr.put(paramString1, paramString2);
    }
    if (e.bVi())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.am(c.class)).fv(str, paramString2);
      AppMethodBeat.o(137433);
      return;
    }
    ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137433);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137427);
    if (oYs != null)
    {
      str = oYs;
      AppMethodBeat.o(137427);
      return str;
    }
    String str = e.getAccPath();
    if (TextUtils.isEmpty(str))
    {
      ab.i("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", new Object[] { str });
      str = com.tencent.mm.loader.j.b.eQz;
      AppMethodBeat.o(137427);
      return str;
    }
    ab.i("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", new Object[] { str });
    oYs = str;
    AppMethodBeat.o(137427);
    return str;
  }
  
  public static void t(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137432);
    if ((paramMap != null) && (Vk(paramString)))
    {
      paramMap.put("Cookie", "qqmusic_fromtag=97;qqmusic_uin=1234567;qqmusic_key=;");
      paramMap.put("referer", "stream12.qqmusic.qq.com");
    }
    AppMethodBeat.o(137432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.g
 * JD-Core Version:    0.7.0.1
 */