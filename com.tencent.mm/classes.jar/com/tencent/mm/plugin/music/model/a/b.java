package com.tencent.mm.plugin.music.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.i;
import com.tencent.mm.plugin.music.cache.h;
import com.tencent.mm.plugin.music.h.c;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public final class b
{
  private static ag<String, String> wlb;
  private static ag<String, Long> wlc;
  
  static
  {
    AppMethodBeat.i(63047);
    wlb = new ag(20);
    wlc = new ag(20);
    AppMethodBeat.o(63047);
  }
  
  public static String asA(String paramString)
  {
    AppMethodBeat.i(63042);
    if ((!TextUtils.isEmpty(paramString)) && (wlb.aM(paramString))) {}
    for (String str = (String)wlb.get(paramString); str == null; str = null)
    {
      AppMethodBeat.o(63042);
      return paramString;
    }
    AppMethodBeat.o(63042);
    return str;
  }
  
  public static boolean asE(String paramString)
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
  
  public static String asF(String paramString)
  {
    AppMethodBeat.i(63045);
    if (asE(paramString))
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
  
  public static String asg(String paramString)
  {
    AppMethodBeat.i(63046);
    String str = asA(paramString);
    if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase(paramString)))
    {
      ad.i("MicroMsg.Music.MusicUrlParser", "use temp shake music url to play:%s", new Object[] { str });
      AppMethodBeat.o(63046);
      return str;
    }
    if (asE(paramString))
    {
      paramString = asF(str);
      ad.i("MicroMsg.Music.MusicUrlParser", "play url :%s", new Object[] { paramString });
      AppMethodBeat.o(63046);
      return paramString;
    }
    AppMethodBeat.o(63046);
    return "";
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(63043);
    if ((parama == null) || (TextUtils.isEmpty(parama.playUrl)))
    {
      AppMethodBeat.o(63043);
      return false;
    }
    if (!asE(parama.playUrl))
    {
      AppMethodBeat.o(63043);
      return false;
    }
    if (c.LD(parama.field_musicType))
    {
      if ((parama == null) || (TextUtils.isEmpty(parama.playUrl)))
      {
        i = 0;
        if ((i == 0) || (!h.asw(parama.playUrl))) {
          break label139;
        }
      }
      label139:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label238;
        }
        ad.i("MicroMsg.Music.MusicUrlParser", "qq music pieceFile cache is valid");
        AppMethodBeat.o(63043);
        return false;
        i locali = com.tencent.mm.plugin.music.cache.e.ash(com.tencent.mm.plugin.music.h.b.asP(parama.playUrl));
        if ((locali != null) && (locali.ihJ == 1))
        {
          i = 1;
          break;
        }
        i = 0;
        break;
      }
    }
    boolean bool = ay.isWifi(aj.getContext());
    if (bool) {
      if (parama.field_wifiEndFlag == 1)
      {
        i = 1;
        if ((i == 0) || (!new com.tencent.mm.vfs.e(com.tencent.mm.plugin.music.h.b.bz(parama.field_musicId, bool)).exists())) {
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
      ad.i("MicroMsg.Music.MusicUrlParser", "music cache is valid");
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
    if (!wlb.aM(parama.playUrl))
    {
      AppMethodBeat.o(63043);
      return true;
    }
    long l = 0L;
    if (wlc.aM(parama.playUrl)) {
      l = ((Long)wlc.get(parama.playUrl)).longValue();
    }
    if (System.currentTimeMillis() - l > 86400000L)
    {
      wlb.remove(parama.playUrl);
      wlc.remove(parama.playUrl);
      ad.i("MicroMsg.Music.MusicUrlParser", "shake music url in cache is timeout");
      AppMethodBeat.o(63043);
      return true;
    }
    AppMethodBeat.o(63043);
    return false;
  }
  
  public static void ij(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63041);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(63041);
      return;
    }
    wlb.put(paramString1, paramString2);
    wlc.put(paramString1, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(63041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.b
 * JD-Core Version:    0.7.0.1
 */