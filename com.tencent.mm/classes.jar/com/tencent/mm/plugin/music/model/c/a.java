package com.tencent.mm.plugin.music.model.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.c;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static HashMap<Integer, Boolean> tXm;
  private static HashMap<Integer, Long> tXn;
  
  static
  {
    AppMethodBeat.i(63133);
    tXm = new HashMap();
    tXn = new HashMap();
    tXm.put(Integer.valueOf(0), Boolean.FALSE);
    tXm.put(Integer.valueOf(1), Boolean.FALSE);
    tXm.put(Integer.valueOf(4), Boolean.FALSE);
    tXm.put(Integer.valueOf(5), Boolean.FALSE);
    tXm.put(Integer.valueOf(6), Boolean.FALSE);
    tXm.put(Integer.valueOf(7), Boolean.FALSE);
    tXm.put(Integer.valueOf(8), Boolean.FALSE);
    tXm.put(Integer.valueOf(9), Boolean.FALSE);
    tXn.put(Integer.valueOf(0), Long.valueOf(0L));
    tXn.put(Integer.valueOf(1), Long.valueOf(0L));
    tXn.put(Integer.valueOf(4), Long.valueOf(0L));
    tXn.put(Integer.valueOf(5), Long.valueOf(0L));
    tXn.put(Integer.valueOf(6), Long.valueOf(0L));
    tXn.put(Integer.valueOf(7), Long.valueOf(0L));
    tXn.put(Integer.valueOf(8), Long.valueOf(0L));
    tXn.put(Integer.valueOf(9), Long.valueOf(0L));
    AppMethodBeat.o(63133);
  }
  
  public static boolean HJ(int paramInt)
  {
    AppMethodBeat.i(63130);
    long l = System.currentTimeMillis();
    boolean bool;
    if (l - ((Long)tXn.get(Integer.valueOf(paramInt))).longValue() < 10000L)
    {
      bool = ((Boolean)tXm.get(Integer.valueOf(paramInt))).booleanValue();
      AppMethodBeat.o(63130);
      return bool;
    }
    tXn.put(Integer.valueOf(paramInt), Long.valueOf(l));
    c localc = com.tencent.mm.model.c.d.aty().qu("100283");
    if (!localc.isValid())
    {
      ad.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer item.isValid is false");
      bool = HO(paramInt);
      AppMethodBeat.o(63130);
      return bool;
    }
    Object localObject = localc.eJy();
    if (localObject == null)
    {
      ad.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer args == null");
      bool = HO(paramInt);
      AppMethodBeat.o(63130);
      return bool;
    }
    if (!((Map)localObject).containsKey("support_player_flag"))
    {
      ad.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the support_player_flag key");
      bool = HO(paramInt);
      AppMethodBeat.o(63130);
      return bool;
    }
    if (TextUtils.isEmpty((CharSequence)((Map)localObject).get("support_player_flag")))
    {
      ad.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the the value is empty");
      bool = HO(paramInt);
      AppMethodBeat.o(63130);
      return bool;
    }
    localObject = (String)((Map)localObject).get("support_player_flag");
    try
    {
      i = Integer.valueOf((String)localObject, 16).intValue();
      ad.i("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer contain support_player_flag:%s", new Object[] { localObject });
      l = ((Long)g.afB().afk().get(ae.a.Fos, Long.valueOf(0L))).longValue();
      if (l == 0L)
      {
        ad.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is 0");
        g.afB().afk().set(ae.a.Fos, Long.valueOf(localc.field_sequence));
        g.afB().afk().set(ae.a.For, Integer.valueOf(i));
        bool = gn(paramInt, i);
        tXm.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
        AppMethodBeat.o(63130);
        return bool;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Music.MusicPlayerSwitcher", localNumberFormatException, "supportQQMusicPlayer", new Object[0]);
        int i = 0;
        continue;
        if (l == localc.field_sequence)
        {
          ad.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is equal, check flag from local switch flag");
          bool = gn(paramInt, ((Integer)g.afB().afk().get(ae.a.For, Integer.valueOf(i))).intValue());
        }
        else
        {
          ad.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is diff, update local data");
          g.afB().afk().set(ae.a.Fos, Long.valueOf(localc.field_sequence));
          g.afB().afk().set(ae.a.For, Integer.valueOf(i));
          bool = gn(paramInt, i);
        }
      }
    }
  }
  
  private static boolean HO(int paramInt)
  {
    AppMethodBeat.i(63131);
    int i = ((Integer)g.afB().afk().get(ae.a.For, Integer.valueOf(0))).intValue();
    boolean bool = gn(paramInt, i);
    ad.i("MicroMsg.Music.MusicPlayerSwitcher", "checkLocalSupportPlayerFlag support_player_flag:%s", new Object[] { Integer.toHexString(i) });
    tXm.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
    AppMethodBeat.o(63131);
    return bool;
  }
  
  private static boolean gn(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(63132);
    if ((paramInt1 == 0) && ((paramInt2 & 0x1) > 0)) {
      ad.i("MicroMsg.Music.MusicPlayerSwitcher", "support CHATTING_UI");
    }
    for (;;)
    {
      AppMethodBeat.o(63132);
      return bool;
      if ((paramInt1 == 1) && ((paramInt2 & 0x2) > 0))
      {
        ad.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_TIMELINE_UI");
      }
      else if ((paramInt1 == 4) && ((paramInt2 & 0x4) > 0))
      {
        ad.i("MicroMsg.Music.MusicPlayerSwitcher", "support SHAKE_MUSIC_UI");
      }
      else if ((paramInt1 == 5) && ((paramInt2 & 0x8) > 0))
      {
        ad.i("MicroMsg.Music.MusicPlayerSwitcher", "support PRODUCT_UI");
      }
      else if ((paramInt1 == 6) && ((paramInt2 & 0x10) > 0))
      {
        ad.i("MicroMsg.Music.MusicPlayerSwitcher", "support FAVORITE_UI");
      }
      else if ((paramInt1 == 7) && ((paramInt2 & 0x20) > 0))
      {
        ad.i("MicroMsg.Music.MusicPlayerSwitcher", "support WEBVIEW_UI");
      }
      else if ((paramInt1 == 8) && ((paramInt2 & 0x40) > 0))
      {
        ad.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_USER_TIMELINE_UI");
      }
      else if ((paramInt1 == 9) && ((paramInt2 & 0x80) > 0))
      {
        ad.i("MicroMsg.Music.MusicPlayerSwitcher", "support SEARCH_TIMELINE_UI");
      }
      else
      {
        ad.i("MicroMsg.Music.MusicPlayerSwitcher", "QQMusicPlayer not support this scene %d", new Object[] { Integer.valueOf(paramInt1) });
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c.a
 * JD-Core Version:    0.7.0.1
 */