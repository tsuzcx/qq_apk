package com.tencent.mm.plugin.music.model.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.h.c;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class b
{
  private static ab<String, String> mzE = new ab(20);
  private static ab<String, Long> mzF = new ab(20);
  
  private static boolean JA(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.contains("wxshakemusic")) {
      return false;
    }
    return true;
  }
  
  public static String JB(String paramString)
  {
    String str = paramString;
    if (JA(paramString))
    {
      int i = paramString.lastIndexOf("wxshakemusic");
      str = paramString;
      if (i > 1) {
        str = paramString.substring(0, i - 1);
      }
    }
    return str;
  }
  
  public static String Jf(String paramString)
  {
    String str = Jw(paramString);
    if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase(paramString)))
    {
      y.i("MicroMsg.Music.MusicUrlParser", "use temp shake music url to play:%s", new Object[] { str });
      return str;
    }
    if (JA(paramString))
    {
      paramString = JB(str);
      y.i("MicroMsg.Music.MusicUrlParser", "play url :%s", new Object[] { paramString });
      return paramString;
    }
    return "";
  }
  
  public static String Jw(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (mzE.aC(paramString))) {}
    for (String str = (String)mzE.get(paramString); str == null; str = null) {
      return paramString;
    }
    return str;
  }
  
  public static boolean b(a parama)
  {
    if ((parama == null) || (TextUtils.isEmpty(parama.playUrl))) {
      return false;
    }
    if (!JA(parama.playUrl)) {
      return false;
    }
    if (c.vb(parama.field_musicType))
    {
      if ((parama == null) || (TextUtils.isEmpty(parama.playUrl)))
      {
        i = 0;
        if ((i == 0) || (!com.tencent.mm.plugin.music.cache.h.Ju(parama.playUrl))) {
          break label119;
        }
      }
      label119:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label213;
        }
        y.i("MicroMsg.Music.MusicUrlParser", "qq music pieceFile cache is valid");
        return false;
        com.tencent.mm.av.h localh = e.Jg(com.tencent.mm.plugin.music.h.b.JH(parama.playUrl));
        if ((localh != null) && (localh.euZ == 1))
        {
          i = 1;
          break;
        }
        i = 0;
        break;
      }
    }
    boolean bool = aq.isWifi(ae.getContext());
    if (bool) {
      if (parama.field_wifiEndFlag == 1)
      {
        i = 1;
        if ((i == 0) || (!new File(com.tencent.mm.plugin.music.h.b.aN(parama.field_musicId, bool)).exists())) {
          break label208;
        }
      }
    }
    label208:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label213;
      }
      y.i("MicroMsg.Music.MusicUrlParser", "music cache is valid");
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
    label213:
    if (!mzE.aC(parama.playUrl)) {
      return true;
    }
    long l = 0L;
    if (mzF.aC(parama.playUrl)) {
      l = ((Long)mzF.get(parama.playUrl)).longValue();
    }
    if (System.currentTimeMillis() - l > 86400000L)
    {
      mzE.remove(parama.playUrl);
      mzF.remove(parama.playUrl);
      y.i("MicroMsg.Music.MusicUrlParser", "shake music url in cache is timeout");
      return true;
    }
    return false;
  }
  
  public static void ef(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    mzE.put(paramString1, paramString2);
    mzF.put(paramString1, Long.valueOf(System.currentTimeMillis()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.b
 * JD-Core Version:    0.7.0.1
 */