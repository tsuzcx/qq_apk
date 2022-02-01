package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Map;

public final class g
{
  private static af<String, String> veb;
  private static af<String, Boolean> vec;
  private static af<String, Integer> ved;
  private static af<String, Integer> vee;
  private static af<String, Long> vef;
  private static af<String, String> veg;
  private static String veh;
  private static int vei;
  
  static
  {
    AppMethodBeat.i(137194);
    veb = new af(20);
    vec = new af(20);
    ved = new af(20);
    vee = new af(20);
    vef = new af(20);
    veg = new af(20);
    veh = null;
    vei = 0;
    AppMethodBeat.o(137194);
  }
  
  public static void aY(String paramString, long paramLong)
  {
    AppMethodBeat.i(137187);
    if (paramLong > 0L) {
      vef.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(137187);
  }
  
  public static void ano(String paramString)
  {
    AppMethodBeat.i(137176);
    if (!TextUtils.isEmpty(anp(paramString)))
    {
      AppMethodBeat.o(137176);
      return;
    }
    if (e.dip()) {}
    for (String str = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).anj(paramString);; str = "")
    {
      if (!TextUtils.isEmpty(str))
      {
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(str);
        new f(localArrayList).dih();
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str))) {
          veb.put(paramString, str);
        }
      }
      AppMethodBeat.o(137176);
      return;
      ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static String anp(String paramString)
  {
    AppMethodBeat.i(137179);
    if (veb.aK(paramString))
    {
      paramString = (String)veb.get(paramString);
      AppMethodBeat.o(137179);
      return paramString;
    }
    AppMethodBeat.o(137179);
    return "";
  }
  
  public static boolean anq(String paramString)
  {
    AppMethodBeat.i(137181);
    if (vec.aK(paramString))
    {
      boolean bool = ((Boolean)vec.get(paramString)).booleanValue();
      AppMethodBeat.o(137181);
      return bool;
    }
    AppMethodBeat.o(137181);
    return false;
  }
  
  public static String anr(String paramString)
  {
    AppMethodBeat.i(137184);
    paramString = anp(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137184);
      return null;
    }
    if (e.dip())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).anl(paramString);
      AppMethodBeat.o(137184);
      return paramString;
    }
    ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137184);
    return null;
  }
  
  public static String ans(String paramString)
  {
    AppMethodBeat.i(137185);
    if (veg.aK(paramString))
    {
      paramString = (String)veg.get(paramString);
      AppMethodBeat.o(137185);
      return paramString;
    }
    AppMethodBeat.o(137185);
    return null;
  }
  
  public static long ant(String paramString)
  {
    AppMethodBeat.i(137186);
    if (vef.aK(paramString))
    {
      long l = ((Long)vef.get(paramString)).longValue();
      AppMethodBeat.o(137186);
      return l;
    }
    AppMethodBeat.o(137186);
    return -1L;
  }
  
  public static void anu(String paramString)
  {
    AppMethodBeat.i(137189);
    Logger.i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
    h.anu(com.tencent.mm.plugin.music.h.b.anR(paramString));
    AppMethodBeat.o(137189);
  }
  
  public static int anv(String paramString)
  {
    AppMethodBeat.i(137191);
    if ((paramString != null) && (ved.aK(paramString)))
    {
      int i = ((Integer)ved.get(paramString)).intValue();
      AppMethodBeat.o(137191);
      return i;
    }
    AppMethodBeat.o(137191);
    return 0;
  }
  
  public static int anw(String paramString)
  {
    AppMethodBeat.i(137193);
    if ((paramString != null) && (vee.aK(paramString)))
    {
      int i = ((Integer)vee.get(paramString)).intValue();
      AppMethodBeat.o(137193);
      return i;
    }
    AppMethodBeat.o(137193);
    return 0;
  }
  
  public static void br(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137180);
    if (!TextUtils.isEmpty(paramString)) {
      vec.put(paramString, Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(137180);
  }
  
  public static int dij()
  {
    AppMethodBeat.i(137178);
    if (vei != 0)
    {
      i = vei;
      AppMethodBeat.o(137178);
      return i;
    }
    if (e.dip()) {}
    for (int i = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dij();; i = 3)
    {
      vei = i;
      ac.i("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", new Object[] { Integer.valueOf(vei) });
      if (vei == 0) {
        vei = 3;
      }
      i = vei;
      AppMethodBeat.o(137178);
      return i;
      ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static void ee(String paramString, int paramInt)
  {
    AppMethodBeat.i(137190);
    if (paramString != null) {
      ved.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137190);
  }
  
  public static void ef(String paramString, int paramInt)
  {
    AppMethodBeat.i(137192);
    if (paramString != null) {
      vee.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137192);
  }
  
  public static long fD(String paramString)
  {
    AppMethodBeat.i(137188);
    long l = h.fD(paramString);
    AppMethodBeat.o(137188);
    return l;
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137177);
    if (veh != null)
    {
      str = veh;
      AppMethodBeat.o(137177);
      return str;
    }
    String str = e.getAccPath();
    if (TextUtils.isEmpty(str))
    {
      ac.i("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", new Object[] { str });
      str = com.tencent.mm.loader.j.b.aph();
      AppMethodBeat.o(137177);
      return str;
    }
    ac.i("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", new Object[] { str });
    veh = str;
    AppMethodBeat.o(137177);
    return str;
  }
  
  public static void hW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137183);
    String str = anp(paramString1);
    if (TextUtils.isEmpty(str))
    {
      ac.e("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137183);
      return;
    }
    if (!TextUtils.isEmpty(ans(paramString1)))
    {
      AppMethodBeat.o(137183);
      return;
    }
    ac.i("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", new Object[] { paramString1, paramString2 });
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      veg.put(paramString1, paramString2);
    }
    if (e.dip())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).hU(str, paramString2);
      AppMethodBeat.o(137183);
      return;
    }
    ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137183);
  }
  
  public static void z(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137182);
    if (paramMap != null) {
      anq(paramString);
    }
    AppMethodBeat.o(137182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.g
 * JD-Core Version:    0.7.0.1
 */