package com.tencent.mm.plugin.music.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.i;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.cache.h;
import com.tencent.mm.plugin.music.h.c;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.vfs.k;

public final class b
{
  private static ah<String, String> wAK;
  private static ah<String, Long> wAL;
  
  static
  {
    AppMethodBeat.i(63047);
    wAK = new ah(20);
    wAL = new ah(20);
    AppMethodBeat.o(63047);
  }
  
  public static String YI(String paramString)
  {
    AppMethodBeat.i(63042);
    if ((!TextUtils.isEmpty(paramString)) && (wAK.aM(paramString))) {}
    for (String str = (String)wAK.get(paramString); str == null; str = null)
    {
      AppMethodBeat.o(63042);
      return paramString;
    }
    AppMethodBeat.o(63042);
    return str;
  }
  
  public static boolean atR(String paramString)
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
  
  public static String atS(String paramString)
  {
    AppMethodBeat.i(63045);
    if (atR(paramString))
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
  
  public static String atu(String paramString)
  {
    AppMethodBeat.i(63046);
    String str = YI(paramString);
    if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase(paramString)))
    {
      ae.i("MicroMsg.Music.MusicUrlParser", "use temp shake music url to play:%s", new Object[] { str });
      AppMethodBeat.o(63046);
      return str;
    }
    if (atR(paramString))
    {
      paramString = atS(str);
      ae.i("MicroMsg.Music.MusicUrlParser", "play url :%s", new Object[] { paramString });
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
    if (!atR(parama.playUrl))
    {
      AppMethodBeat.o(63043);
      return false;
    }
    if (c.Mi(parama.field_musicType))
    {
      if ((parama == null) || (TextUtils.isEmpty(parama.playUrl)))
      {
        i = 0;
        if ((i == 0) || (!h.atK(parama.playUrl))) {
          break label139;
        }
      }
      label139:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label238;
        }
        ae.i("MicroMsg.Music.MusicUrlParser", "qq music pieceFile cache is valid");
        AppMethodBeat.o(63043);
        return false;
        i locali = e.atv(com.tencent.mm.plugin.music.h.b.auc(parama.playUrl));
        if ((locali != null) && (locali.ikC == 1))
        {
          i = 1;
          break;
        }
        i = 0;
        break;
      }
    }
    boolean bool = az.isWifi(ak.getContext());
    if (bool) {
      if (parama.field_wifiEndFlag == 1)
      {
        i = 1;
        if ((i == 0) || (!new k(com.tencent.mm.plugin.music.h.b.bD(parama.field_musicId, bool)).exists())) {
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
      ae.i("MicroMsg.Music.MusicUrlParser", "music cache is valid");
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
    if (!wAK.aM(parama.playUrl))
    {
      AppMethodBeat.o(63043);
      return true;
    }
    long l = 0L;
    if (wAL.aM(parama.playUrl)) {
      l = ((Long)wAL.get(parama.playUrl)).longValue();
    }
    if (System.currentTimeMillis() - l > 86400000L)
    {
      wAK.remove(parama.playUrl);
      wAL.remove(parama.playUrl);
      ae.i("MicroMsg.Music.MusicUrlParser", "shake music url in cache is timeout");
      AppMethodBeat.o(63043);
      return true;
    }
    AppMethodBeat.o(63043);
    return false;
  }
  
  public static void ip(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63041);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(63041);
      return;
    }
    wAK.put(paramString1, paramString2);
    wAL.put(paramString1, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(63041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.b
 * JD-Core Version:    0.7.0.1
 */