package com.tencent.mm.plugin.music.model.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.c;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static HashMap<Integer, Boolean> wBc;
  private static HashMap<Integer, Long> wBd;
  
  static
  {
    AppMethodBeat.i(63133);
    wBc = new HashMap();
    wBd = new HashMap();
    wBc.put(Integer.valueOf(0), Boolean.FALSE);
    wBc.put(Integer.valueOf(1), Boolean.FALSE);
    wBc.put(Integer.valueOf(4), Boolean.FALSE);
    wBc.put(Integer.valueOf(5), Boolean.FALSE);
    wBc.put(Integer.valueOf(6), Boolean.FALSE);
    wBc.put(Integer.valueOf(7), Boolean.FALSE);
    wBc.put(Integer.valueOf(8), Boolean.FALSE);
    wBc.put(Integer.valueOf(9), Boolean.FALSE);
    wBd.put(Integer.valueOf(0), Long.valueOf(0L));
    wBd.put(Integer.valueOf(1), Long.valueOf(0L));
    wBd.put(Integer.valueOf(4), Long.valueOf(0L));
    wBd.put(Integer.valueOf(5), Long.valueOf(0L));
    wBd.put(Integer.valueOf(6), Long.valueOf(0L));
    wBd.put(Integer.valueOf(7), Long.valueOf(0L));
    wBd.put(Integer.valueOf(8), Long.valueOf(0L));
    wBd.put(Integer.valueOf(9), Long.valueOf(0L));
    AppMethodBeat.o(63133);
  }
  
  public static boolean LP(int paramInt)
  {
    AppMethodBeat.i(63130);
    long l = System.currentTimeMillis();
    boolean bool;
    if (l - ((Long)wBd.get(Integer.valueOf(paramInt))).longValue() < 10000L)
    {
      bool = ((Boolean)wBc.get(Integer.valueOf(paramInt))).booleanValue();
      AppMethodBeat.o(63130);
      return bool;
    }
    wBd.put(Integer.valueOf(paramInt), Long.valueOf(l));
    c localc = com.tencent.mm.model.c.d.aDI().xi("100283");
    if (!localc.isValid())
    {
      ae.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer item.isValid is false");
      bool = LU(paramInt);
      AppMethodBeat.o(63130);
      return bool;
    }
    Object localObject = localc.fsy();
    if (localObject == null)
    {
      ae.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer args == null");
      bool = LU(paramInt);
      AppMethodBeat.o(63130);
      return bool;
    }
    if (!((Map)localObject).containsKey("support_player_flag"))
    {
      ae.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the support_player_flag key");
      bool = LU(paramInt);
      AppMethodBeat.o(63130);
      return bool;
    }
    if (TextUtils.isEmpty((CharSequence)((Map)localObject).get("support_player_flag")))
    {
      ae.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the the value is empty");
      bool = LU(paramInt);
      AppMethodBeat.o(63130);
      return bool;
    }
    localObject = (String)((Map)localObject).get("support_player_flag");
    try
    {
      i = Integer.valueOf((String)localObject, 16).intValue();
      ae.i("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer contain support_player_flag:%s", new Object[] { localObject });
      l = ((Long)g.ajR().ajA().get(am.a.ISX, Long.valueOf(0L))).longValue();
      if (l == 0L)
      {
        ae.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is 0");
        g.ajR().ajA().set(am.a.ISX, Long.valueOf(localc.field_sequence));
        g.ajR().ajA().set(am.a.ISW, Integer.valueOf(i));
        bool = gN(paramInt, i);
        wBc.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
        AppMethodBeat.o(63130);
        return bool;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Music.MusicPlayerSwitcher", localNumberFormatException, "supportQQMusicPlayer", new Object[0]);
        int i = 0;
        continue;
        if (l == localc.field_sequence)
        {
          ae.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is equal, check flag from local switch flag");
          bool = gN(paramInt, ((Integer)g.ajR().ajA().get(am.a.ISW, Integer.valueOf(i))).intValue());
        }
        else
        {
          ae.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is diff, update local data");
          g.ajR().ajA().set(am.a.ISX, Long.valueOf(localc.field_sequence));
          g.ajR().ajA().set(am.a.ISW, Integer.valueOf(i));
          bool = gN(paramInt, i);
        }
      }
    }
  }
  
  private static boolean LU(int paramInt)
  {
    AppMethodBeat.i(63131);
    int i = ((Integer)g.ajR().ajA().get(am.a.ISW, Integer.valueOf(0))).intValue();
    boolean bool = gN(paramInt, i);
    ae.i("MicroMsg.Music.MusicPlayerSwitcher", "checkLocalSupportPlayerFlag support_player_flag:%s", new Object[] { Integer.toHexString(i) });
    wBc.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
    AppMethodBeat.o(63131);
    return bool;
  }
  
  private static boolean gN(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(63132);
    if ((paramInt1 == 0) && ((paramInt2 & 0x1) > 0)) {
      ae.i("MicroMsg.Music.MusicPlayerSwitcher", "support CHATTING_UI");
    }
    for (;;)
    {
      AppMethodBeat.o(63132);
      return bool;
      if ((paramInt1 == 1) && ((paramInt2 & 0x2) > 0))
      {
        ae.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_TIMELINE_UI");
      }
      else if ((paramInt1 == 4) && ((paramInt2 & 0x4) > 0))
      {
        ae.i("MicroMsg.Music.MusicPlayerSwitcher", "support SHAKE_MUSIC_UI");
      }
      else if ((paramInt1 == 5) && ((paramInt2 & 0x8) > 0))
      {
        ae.i("MicroMsg.Music.MusicPlayerSwitcher", "support PRODUCT_UI");
      }
      else if ((paramInt1 == 6) && ((paramInt2 & 0x10) > 0))
      {
        ae.i("MicroMsg.Music.MusicPlayerSwitcher", "support FAVORITE_UI");
      }
      else if ((paramInt1 == 7) && ((paramInt2 & 0x20) > 0))
      {
        ae.i("MicroMsg.Music.MusicPlayerSwitcher", "support WEBVIEW_UI");
      }
      else if ((paramInt1 == 8) && ((paramInt2 & 0x40) > 0))
      {
        ae.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_USER_TIMELINE_UI");
      }
      else if ((paramInt1 == 9) && ((paramInt2 & 0x80) > 0))
      {
        ae.i("MicroMsg.Music.MusicPlayerSwitcher", "support SEARCH_TIMELINE_UI");
      }
      else
      {
        ae.i("MicroMsg.Music.MusicPlayerSwitcher", "QQMusicPlayer not support this scene %d", new Object[] { Integer.valueOf(paramInt1) });
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c.a
 * JD-Core Version:    0.7.0.1
 */