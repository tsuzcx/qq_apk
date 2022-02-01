package com.tencent.mm.plugin.music.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.j;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.cache.h;
import com.tencent.mm.plugin.music.h.c;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.vfs.o;

public final class b
{
  private static LruCache<String, String> AkR;
  private static LruCache<String, Long> AkS;
  
  static
  {
    AppMethodBeat.i(63047);
    AkR = new LruCache(20);
    AkS = new LruCache(20);
    AppMethodBeat.o(63047);
  }
  
  public static boolean aHR(String paramString)
  {
    AppMethodBeat.i(63044);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(63044);
      return false;
    }
    if (paramString.contains("wxshakemusic"))
    {
      AppMethodBeat.o(63044);
      return true;
    }
    AppMethodBeat.o(63044);
    return false;
  }
  
  public static String aHS(String paramString)
  {
    AppMethodBeat.i(63045);
    if (aHR(paramString))
    {
      int i = paramString.lastIndexOf("wxshakemusic");
      if (i > 1)
      {
        paramString = paramString.substring(0, i - 1);
        AppMethodBeat.o(63045);
        return paramString;
      }
      AppMethodBeat.o(63045);
      return paramString;
    }
    AppMethodBeat.o(63045);
    return paramString;
  }
  
  public static String aHr(String paramString)
  {
    AppMethodBeat.i(63046);
    String str = aiK(paramString);
    if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase(paramString)))
    {
      Log.i("MicroMsg.Music.MusicUrlParser", "use temp shake music url to play:%s", new Object[] { str });
      AppMethodBeat.o(63046);
      return str;
    }
    if (aHR(paramString))
    {
      paramString = aHS(str);
      Log.i("MicroMsg.Music.MusicUrlParser", "play url :%s", new Object[] { paramString });
      AppMethodBeat.o(63046);
      return paramString;
    }
    AppMethodBeat.o(63046);
    return "";
  }
  
  public static String aiK(String paramString)
  {
    AppMethodBeat.i(63042);
    if ((!TextUtils.isEmpty(paramString)) && (AkR.check(paramString))) {}
    for (String str = (String)AkR.get(paramString); str == null; str = null)
    {
      AppMethodBeat.o(63042);
      return paramString;
    }
    AppMethodBeat.o(63042);
    return str;
  }
  
  public static boolean c(a parama)
  {
    AppMethodBeat.i(63043);
    if ((parama == null) || (TextUtils.isEmpty(parama.playUrl)))
    {
      AppMethodBeat.o(63043);
      return false;
    }
    if (!aHR(parama.playUrl))
    {
      AppMethodBeat.o(63043);
      return false;
    }
    if (c.Th(parama.field_musicType))
    {
      if ((parama == null) || (TextUtils.isEmpty(parama.playUrl)))
      {
        i = 0;
        if ((i == 0) || (!h.aHG(parama.playUrl))) {
          break label139;
        }
      }
      label139:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label238;
        }
        Log.i("MicroMsg.Music.MusicUrlParser", "qq music pieceFile cache is valid");
        AppMethodBeat.o(63043);
        return false;
        j localj = e.aHs(com.tencent.mm.plugin.music.h.b.aId(parama.playUrl));
        if ((localj != null) && (localj.jfB == 1))
        {
          i = 1;
          break;
        }
        i = 0;
        break;
      }
    }
    boolean bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
    if (bool) {
      if (parama.field_wifiEndFlag == 1)
      {
        i = 1;
        if ((i == 0) || (!new o(com.tencent.mm.plugin.music.h.b.bT(parama.field_musicId, bool)).exists())) {
          break label233;
        }
      }
    }
    label233:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label238;
      }
      Log.i("MicroMsg.Music.MusicUrlParser", "music cache is valid");
      AppMethodBeat.o(63043);
      return false;
      i = 0;
      break;
      if (parama.field_endFlag == 1)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
    }
    label238:
    if (!AkR.check(parama.playUrl))
    {
      AppMethodBeat.o(63043);
      return true;
    }
    long l = 0L;
    if (AkS.check(parama.playUrl)) {
      l = ((Long)AkS.get(parama.playUrl)).longValue();
    }
    if (System.currentTimeMillis() - l > 86400000L)
    {
      AkR.remove(parama.playUrl);
      AkS.remove(parama.playUrl);
      Log.i("MicroMsg.Music.MusicUrlParser", "shake music url in cache is timeout");
      AppMethodBeat.o(63043);
      return true;
    }
    AppMethodBeat.o(63043);
    return false;
  }
  
  public static void ja(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63041);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(63041);
      return;
    }
    AkR.put(paramString1, paramString2);
    AkS.put(paramString1, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(63041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.b
 * JD-Core Version:    0.7.0.1
 */