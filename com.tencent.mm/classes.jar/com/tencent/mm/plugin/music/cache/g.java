package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Map;

public final class g
{
  private static ah<String, String> wzc;
  private static ah<String, Boolean> wzd;
  private static ah<String, Integer> wze;
  private static ah<String, Integer> wzf;
  private static ah<String, Long> wzg;
  private static ah<String, String> wzh;
  private static String wzi;
  private static int wzj;
  
  static
  {
    AppMethodBeat.i(137194);
    wzc = new ah(20);
    wzd = new ah(20);
    wze = new ah(20);
    wzf = new ah(20);
    wzg = new ah(20);
    wzh = new ah(20);
    wzi = null;
    wzj = 0;
    AppMethodBeat.o(137194);
  }
  
  public static void C(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(137182);
    if (paramMap != null) {
      atD(paramString);
    }
    AppMethodBeat.o(137182);
  }
  
  public static void atB(String paramString)
  {
    AppMethodBeat.i(137176);
    if (!TextUtils.isEmpty(atC(paramString)))
    {
      AppMethodBeat.o(137176);
      return;
    }
    if (e.dvQ()) {}
    for (String str = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).atw(paramString);; str = "")
    {
      if (!TextUtils.isEmpty(str))
      {
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(str);
        new f(localArrayList).dvI();
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str))) {
          wzc.put(paramString, str);
        }
      }
      AppMethodBeat.o(137176);
      return;
      ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static String atC(String paramString)
  {
    AppMethodBeat.i(137179);
    if (wzc.aM(paramString))
    {
      paramString = (String)wzc.get(paramString);
      AppMethodBeat.o(137179);
      return paramString;
    }
    AppMethodBeat.o(137179);
    return "";
  }
  
  public static boolean atD(String paramString)
  {
    AppMethodBeat.i(137181);
    if (wzd.aM(paramString))
    {
      boolean bool = ((Boolean)wzd.get(paramString)).booleanValue();
      AppMethodBeat.o(137181);
      return bool;
    }
    AppMethodBeat.o(137181);
    return false;
  }
  
  public static String atE(String paramString)
  {
    AppMethodBeat.i(137184);
    paramString = atC(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137184);
      return null;
    }
    if (e.dvQ())
    {
      paramString = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).aty(paramString);
      AppMethodBeat.o(137184);
      return paramString;
    }
    ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137184);
    return null;
  }
  
  public static String atF(String paramString)
  {
    AppMethodBeat.i(137185);
    if (wzh.aM(paramString))
    {
      paramString = (String)wzh.get(paramString);
      AppMethodBeat.o(137185);
      return paramString;
    }
    AppMethodBeat.o(137185);
    return null;
  }
  
  public static long atG(String paramString)
  {
    AppMethodBeat.i(137186);
    if (wzg.aM(paramString))
    {
      long l = ((Long)wzg.get(paramString)).longValue();
      AppMethodBeat.o(137186);
      return l;
    }
    AppMethodBeat.o(137186);
    return -1L;
  }
  
  public static void atH(String paramString)
  {
    AppMethodBeat.i(137189);
    Logger.i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
    h.atH(com.tencent.mm.plugin.music.h.b.aud(paramString));
    AppMethodBeat.o(137189);
  }
  
  public static int atI(String paramString)
  {
    AppMethodBeat.i(137191);
    if ((paramString != null) && (wze.aM(paramString)))
    {
      int i = ((Integer)wze.get(paramString)).intValue();
      AppMethodBeat.o(137191);
      return i;
    }
    AppMethodBeat.o(137191);
    return 0;
  }
  
  public static int atJ(String paramString)
  {
    AppMethodBeat.i(137193);
    if ((paramString != null) && (wzf.aM(paramString)))
    {
      int i = ((Integer)wzf.get(paramString)).intValue();
      AppMethodBeat.o(137193);
      return i;
    }
    AppMethodBeat.o(137193);
    return 0;
  }
  
  public static void bC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137180);
    if (!TextUtils.isEmpty(paramString)) {
      wzd.put(paramString, Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(137180);
  }
  
  public static void ba(String paramString, long paramLong)
  {
    AppMethodBeat.i(137187);
    if (paramLong > 0L) {
      wzg.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(137187);
  }
  
  public static int dvK()
  {
    AppMethodBeat.i(137178);
    if (wzj != 0)
    {
      i = wzj;
      AppMethodBeat.o(137178);
      return i;
    }
    if (e.dvQ()) {}
    for (int i = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dvK();; i = 3)
    {
      wzj = i;
      ae.i("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", new Object[] { Integer.valueOf(wzj) });
      if (wzj == 0) {
        wzj = 3;
      }
      i = wzj;
      AppMethodBeat.o(137178);
      return i;
      ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
  
  public static void eE(String paramString, int paramInt)
  {
    AppMethodBeat.i(137190);
    if (paramString != null) {
      wze.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137190);
  }
  
  public static void eF(String paramString, int paramInt)
  {
    AppMethodBeat.i(137192);
    if (paramString != null) {
      wzf.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(137192);
  }
  
  public static long gE(String paramString)
  {
    AppMethodBeat.i(137188);
    long l = h.gE(paramString);
    AppMethodBeat.o(137188);
    return l;
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(137177);
    if (wzi != null)
    {
      str = wzi;
      AppMethodBeat.o(137177);
      return str;
    }
    String str = e.getAccPath();
    if (TextUtils.isEmpty(str))
    {
      ae.i("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", new Object[] { str });
      str = com.tencent.mm.loader.j.b.asj();
      AppMethodBeat.o(137177);
      return str;
    }
    ae.i("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", new Object[] { str });
    wzi = str;
    AppMethodBeat.o(137177);
    return str;
  }
  
  public static void in(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137183);
    String str = atC(paramString1);
    if (TextUtils.isEmpty(str))
    {
      ae.e("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
      AppMethodBeat.o(137183);
      return;
    }
    if (!TextUtils.isEmpty(atF(paramString1)))
    {
      AppMethodBeat.o(137183);
      return;
    }
    ae.i("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", new Object[] { paramString1, paramString2 });
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      wzh.put(paramString1, paramString2);
    }
    if (e.dvQ())
    {
      ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).il(str, paramString2);
      AppMethodBeat.o(137183);
      return;
    }
    ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    AppMethodBeat.o(137183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.g
 * JD-Core Version:    0.7.0.1
 */