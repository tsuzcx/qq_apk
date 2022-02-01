package com.tencent.mm.plugin.music.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.i;
import com.tencent.mm.plugin.music.cache.h;
import com.tencent.mm.plugin.music.h.c;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;

public final class b
{
  private static af<String, String> vfG;
  private static af<String, Long> vfH;
  
  static
  {
    AppMethodBeat.i(63047);
    vfG = new af(20);
    vfH = new af(20);
    AppMethodBeat.o(63047);
  }
  
  public static String anB(String paramString)
  {
    AppMethodBeat.i(63042);
    if ((!TextUtils.isEmpty(paramString)) && (vfG.aK(paramString))) {}
    for (String str = (String)vfG.get(paramString); str == null; str = null)
    {
      AppMethodBeat.o(63042);
      return paramString;
    }
    AppMethodBeat.o(63042);
    return str;
  }
  
  public static boolean anF(String paramString)
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
  
  public static String anG(String paramString)
  {
    AppMethodBeat.i(63045);
    if (anF(paramString))
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
  
  public static String anh(String paramString)
  {
    AppMethodBeat.i(63046);
    String str = anB(paramString);
    if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase(paramString)))
    {
      ac.i("MicroMsg.Music.MusicUrlParser", "use temp shake music url to play:%s", new Object[] { str });
      AppMethodBeat.o(63046);
      return str;
    }
    if (anF(paramString))
    {
      paramString = anG(str);
      ac.i("MicroMsg.Music.MusicUrlParser", "play url :%s", new Object[] { paramString });
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
    if (!anF(parama.playUrl))
    {
      AppMethodBeat.o(63043);
      return false;
    }
    if (c.Kb(parama.field_musicType))
    {
      if ((parama == null) || (TextUtils.isEmpty(parama.playUrl)))
      {
        i = 0;
        if ((i == 0) || (!h.anx(parama.playUrl))) {
          break label139;
        }
      }
      label139:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label238;
        }
        ac.i("MicroMsg.Music.MusicUrlParser", "qq music pieceFile cache is valid");
        AppMethodBeat.o(63043);
        return false;
        i locali = com.tencent.mm.plugin.music.cache.e.ani(com.tencent.mm.plugin.music.h.b.anQ(parama.playUrl));
        if ((locali != null) && (locali.hOv == 1))
        {
          i = 1;
          break;
        }
        i = 0;
        break;
      }
    }
    boolean bool = ax.isWifi(ai.getContext());
    if (bool) {
      if (parama.field_wifiEndFlag == 1)
      {
        i = 1;
        if ((i == 0) || (!new com.tencent.mm.vfs.e(com.tencent.mm.plugin.music.h.b.bs(parama.field_musicId, bool)).exists())) {
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
      ac.i("MicroMsg.Music.MusicUrlParser", "music cache is valid");
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
    if (!vfG.aK(parama.playUrl))
    {
      AppMethodBeat.o(63043);
      return true;
    }
    long l = 0L;
    if (vfH.aK(parama.playUrl)) {
      l = ((Long)vfH.get(parama.playUrl)).longValue();
    }
    if (System.currentTimeMillis() - l > 86400000L)
    {
      vfG.remove(parama.playUrl);
      vfH.remove(parama.playUrl);
      ac.i("MicroMsg.Music.MusicUrlParser", "shake music url in cache is timeout");
      AppMethodBeat.o(63043);
      return true;
    }
    AppMethodBeat.o(63043);
    return false;
  }
  
  public static void hY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63041);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(63041);
      return;
    }
    vfG.put(paramString1, paramString2);
    vfH.put(paramString1, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(63041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.b
 * JD-Core Version:    0.7.0.1
 */