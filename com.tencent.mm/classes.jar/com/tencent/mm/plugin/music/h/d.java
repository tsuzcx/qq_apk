package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.cache.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class d
{
  public static void N(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(137698);
    if (parame == null)
    {
      ab.e("MicroMsg.Music.MusicUrlParser", "GetShakeMusicUrl, musicWrapper is null");
      AppMethodBeat.o(137698);
      return;
    }
    boolean bool1 = at.isWifi(ah.getContext());
    boolean bool2 = at.isNetworkConnected(ah.getContext());
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
    if (bo.isNullOrNil(parame.fKp))
    {
      localObject1 = parame.fKr;
      String str4 = parame.fKq;
      str2 = e.a((String)localObject1, str4, bool1, (PBool)localObject2);
      ab.i("MicroMsg.Music.MusicUrlParser", "parsePlayUrl mSrc:%s", new Object[] { str2 });
      ab.i("MicroMsg.Music.MusicUrlParser", "songWifiUrl:%s", new Object[] { parame.fKp });
      if (!bool1) {
        break label320;
      }
      i = 1;
      if (!((PBool)localObject2).value) {
        break label325;
      }
      j = 1;
      ab.i("MicroMsg.Music.MusicUrlParser", "isWifi:%d, isQQMusic:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (!bool1) {
        break label330;
      }
      bool1 = ((PBool)localObject2).value;
      if (e.VJ(str2))
      {
        ab.i("MicroMsg.Music.MusicUrlParser", "can match shake music wifi url");
        bool1 = true;
      }
      str3 = "";
      if (bool2) {
        break label427;
      }
      ab.i("MicroMsg.Music.MusicUrlParser", "isNetConnected false, detect right Url to play");
      str1 = e.a((String)localObject1, str4, true, (PBool)localObject2);
      localObject2 = e.a((String)localObject1, str4, false, (PBool)localObject2);
      if (str1 != null)
      {
        localObject1 = str3;
        if (str1.equals(localObject2)) {}
      }
      else
      {
        if (!c.M(parame)) {
          break label335;
        }
        ab.i("MicroMsg.Music.MusicUrlParser", "use exoMusicPlayer");
        localObject1 = str3;
      }
      label259:
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals(str2))) {
        break label427;
      }
      ab.i("MicroMsg.Music.MusicUrlParser", "reset the mSrc :%s", new Object[] { localObject1 });
    }
    for (;;)
    {
      parame.playUrl = ((String)localObject1);
      g.bb((String)localObject1, bool1);
      AppMethodBeat.o(137698);
      return;
      localObject1 = parame.fKp;
      break;
      label320:
      i = 0;
      break label120;
      label325:
      j = 0;
      break label130;
      label330:
      bool1 = false;
      break label165;
      label335:
      if (c.Az(parame.fKh))
      {
        ab.i("MicroMsg.Music.MusicUrlParser", "use qqMusicPlayer");
        if (i.Vs(str1))
        {
          localObject1 = str1;
          break label259;
        }
        localObject1 = str3;
        if (!i.Vs((String)localObject2)) {
          break label259;
        }
        localObject1 = localObject2;
        break label259;
      }
      if (e(parame, true)) {
        localObject1 = str1;
      }
      for (;;)
      {
        ab.i("MicroMsg.Music.MusicUrlParser", "use musicPlayer");
        break;
        localObject1 = localObject2;
        if (!e(parame, false)) {
          localObject1 = "";
        }
      }
      label427:
      localObject1 = str2;
    }
  }
  
  private static boolean e(com.tencent.mm.aw.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(137699);
    parame = new File(b.bc(b.K(parame), paramBoolean));
    if ((parame.exists()) && (parame.length() > 0L))
    {
      AppMethodBeat.o(137699);
      return true;
    }
    AppMethodBeat.o(137699);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.h.d
 * JD-Core Version:    0.7.0.1
 */