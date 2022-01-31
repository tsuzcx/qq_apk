package com.tencent.mm.plugin.music.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.h.c;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.io.File;

public final class b
{
  private static ae<String, String> oZK;
  private static ae<String, Long> oZL;
  
  static
  {
    AppMethodBeat.i(104916);
    oZK = new ae(20);
    oZL = new ae(20);
    AppMethodBeat.o(104916);
  }
  
  public static String Vc(String paramString)
  {
    AppMethodBeat.i(104915);
    String str = Vu(paramString);
    if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase(paramString)))
    {
      ab.i("MicroMsg.Music.MusicUrlParser", "use temp shake music url to play:%s", new Object[] { str });
      AppMethodBeat.o(104915);
      return str;
    }
    if (Vx(paramString))
    {
      paramString = Vy(str);
      ab.i("MicroMsg.Music.MusicUrlParser", "play url :%s", new Object[] { paramString });
      AppMethodBeat.o(104915);
      return paramString;
    }
    AppMethodBeat.o(104915);
    return "";
  }
  
  public static String Vu(String paramString)
  {
    AppMethodBeat.i(104911);
    if ((!TextUtils.isEmpty(paramString)) && (oZK.Z(paramString))) {}
    for (String str = (String)oZK.get(paramString); str == null; str = null)
    {
      AppMethodBeat.o(104911);
      return paramString;
    }
    AppMethodBeat.o(104911);
    return str;
  }
  
  public static boolean Vx(String paramString)
  {
    AppMethodBeat.i(104913);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(104913);
      return false;
    }
    if (paramString.contains("wxshakemusic"))
    {
      AppMethodBeat.o(104913);
      return true;
    }
    AppMethodBeat.o(104913);
    return false;
  }
  
  public static String Vy(String paramString)
  {
    AppMethodBeat.i(104914);
    if (Vx(paramString))
    {
      int i = paramString.lastIndexOf("wxshakemusic");
      if (i > 1)
      {
        paramString = paramString.substring(0, i - 1);
        AppMethodBeat.o(104914);
        return paramString;
      }
      AppMethodBeat.o(104914);
      return paramString;
    }
    AppMethodBeat.o(104914);
    return paramString;
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(104912);
    if ((parama == null) || (TextUtils.isEmpty(parama.playUrl)))
    {
      AppMethodBeat.o(104912);
      return false;
    }
    if (!Vx(parama.playUrl))
    {
      AppMethodBeat.o(104912);
      return false;
    }
    if (c.Az(parama.field_musicType))
    {
      if ((parama == null) || (TextUtils.isEmpty(parama.playUrl)))
      {
        i = 0;
        if ((i == 0) || (!com.tencent.mm.plugin.music.cache.h.Vq(parama.playUrl))) {
          break label139;
        }
      }
      label139:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label238;
        }
        ab.i("MicroMsg.Music.MusicUrlParser", "qq music pieceFile cache is valid");
        AppMethodBeat.o(104912);
        return false;
        com.tencent.mm.aw.h localh = e.Vd(com.tencent.mm.plugin.music.h.b.VH(parama.playUrl));
        if ((localh != null) && (localh.fKL == 1))
        {
          i = 1;
          break;
        }
        i = 0;
        break;
      }
    }
    boolean bool = at.isWifi(ah.getContext());
    if (bool) {
      if (parama.field_wifiEndFlag == 1)
      {
        i = 1;
        if ((i == 0) || (!new File(com.tencent.mm.plugin.music.h.b.bc(parama.field_musicId, bool)).exists())) {
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
      ab.i("MicroMsg.Music.MusicUrlParser", "music cache is valid");
      AppMethodBeat.o(104912);
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
    if (!oZK.Z(parama.playUrl))
    {
      AppMethodBeat.o(104912);
      return true;
    }
    long l = 0L;
    if (oZL.Z(parama.playUrl)) {
      l = ((Long)oZL.get(parama.playUrl)).longValue();
    }
    if (System.currentTimeMillis() - l > 86400000L)
    {
      oZK.remove(parama.playUrl);
      oZL.remove(parama.playUrl);
      ab.i("MicroMsg.Music.MusicUrlParser", "shake music url in cache is timeout");
      AppMethodBeat.o(104912);
      return true;
    }
    AppMethodBeat.o(104912);
    return false;
  }
  
  public static void fz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104910);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(104910);
      return;
    }
    oZK.put(paramString1, paramString2);
    oZL.put(paramString1, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(104910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.b
 * JD-Core Version:    0.7.0.1
 */