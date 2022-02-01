package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.cache.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;

public final class d
{
  public static void V(f paramf)
  {
    AppMethodBeat.i(137451);
    if (paramf == null)
    {
      Log.e("MicroMsg.Music.MusicUrlParser", "GetShakeMusicUrl, musicWrapper is null");
      AppMethodBeat.o(137451);
      return;
    }
    boolean bool1 = NetStatusUtil.isWifi(MMApplicationContext.getContext());
    boolean bool2 = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
    Object localObject2 = new PBool();
    Object localObject1;
    String str2;
    int i;
    label120:
    int j;
    label130:
    label165:
    String str3;
    String str1;
    if (Util.isNullOrNil(paramf.jfb))
    {
      localObject1 = paramf.jfd;
      String str4 = paramf.jfc;
      str2 = e.a((String)localObject1, str4, bool1, (PBool)localObject2);
      Log.i("MicroMsg.Music.MusicUrlParser", "parsePlayUrl mSrc:%s", new Object[] { str2 });
      Log.i("MicroMsg.Music.MusicUrlParser", "songWifiUrl:%s", new Object[] { paramf.jfb });
      if (!bool1) {
        break label303;
      }
      i = 1;
      if (!((PBool)localObject2).value) {
        break label308;
      }
      j = 1;
      Log.i("MicroMsg.Music.MusicUrlParser", "isWifi:%d, isQQMusic:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (!bool1) {
        break label313;
      }
      bool1 = ((PBool)localObject2).value;
      str3 = "";
      if (bool2) {
        break label410;
      }
      Log.i("MicroMsg.Music.MusicUrlParser", "isNetConnected false, detect right Url to play");
      str1 = e.a((String)localObject1, str4, true, (PBool)localObject2);
      localObject2 = e.a((String)localObject1, str4, false, (PBool)localObject2);
      if (str1 != null)
      {
        localObject1 = str3;
        if (str1.equals(localObject2)) {}
      }
      else
      {
        if (!c.U(paramf)) {
          break label318;
        }
        Log.i("MicroMsg.Music.MusicUrlParser", "use exoMusicPlayer");
        localObject1 = str3;
      }
      label242:
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals(str2))) {
        break label410;
      }
      Log.i("MicroMsg.Music.MusicUrlParser", "reset the mSrc :%s", new Object[] { localObject1 });
    }
    for (;;)
    {
      paramf.playUrl = ((String)localObject1);
      g.bS((String)localObject1, bool1);
      AppMethodBeat.o(137451);
      return;
      localObject1 = paramf.jfb;
      break;
      label303:
      i = 0;
      break label120;
      label308:
      j = 0;
      break label130;
      label313:
      bool1 = false;
      break label165;
      label318:
      if (c.Th(paramf.jeT))
      {
        Log.i("MicroMsg.Music.MusicUrlParser", "use qqMusicPlayer");
        if (i.aHH(str1))
        {
          localObject1 = str1;
          break label242;
        }
        localObject1 = str3;
        if (!i.aHH((String)localObject2)) {
          break label242;
        }
        localObject1 = localObject2;
        break label242;
      }
      if (e(paramf, true)) {
        localObject1 = str1;
      }
      for (;;)
      {
        Log.i("MicroMsg.Music.MusicUrlParser", "use musicPlayer");
        break;
        localObject1 = localObject2;
        if (!e(paramf, false)) {
          localObject1 = "";
        }
      }
      label410:
      localObject1 = str2;
    }
  }
  
  private static boolean e(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(137452);
    paramf = new o(b.bT(b.S(paramf), paramBoolean));
    if ((paramf.exists()) && (paramf.length() > 0L))
    {
      AppMethodBeat.o(137452);
      return true;
    }
    AppMethodBeat.o(137452);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.d
 * JD-Core Version:    0.7.0.1
 */