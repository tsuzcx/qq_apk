package com.tencent.mm.plugin.music.model.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static HashMap<Integer, Boolean> pac;
  private static HashMap<Integer, Long> pad;
  
  static
  {
    AppMethodBeat.i(105003);
    pac = new HashMap();
    pad = new HashMap();
    pac.put(Integer.valueOf(0), Boolean.FALSE);
    pac.put(Integer.valueOf(1), Boolean.FALSE);
    pac.put(Integer.valueOf(4), Boolean.FALSE);
    pac.put(Integer.valueOf(5), Boolean.FALSE);
    pac.put(Integer.valueOf(6), Boolean.FALSE);
    pac.put(Integer.valueOf(7), Boolean.FALSE);
    pac.put(Integer.valueOf(8), Boolean.FALSE);
    pac.put(Integer.valueOf(9), Boolean.FALSE);
    pad.put(Integer.valueOf(0), Long.valueOf(0L));
    pad.put(Integer.valueOf(1), Long.valueOf(0L));
    pad.put(Integer.valueOf(4), Long.valueOf(0L));
    pad.put(Integer.valueOf(5), Long.valueOf(0L));
    pad.put(Integer.valueOf(6), Long.valueOf(0L));
    pad.put(Integer.valueOf(7), Long.valueOf(0L));
    pad.put(Integer.valueOf(8), Long.valueOf(0L));
    pad.put(Integer.valueOf(9), Long.valueOf(0L));
    AppMethodBeat.o(105003);
  }
  
  public static boolean Af(int paramInt)
  {
    AppMethodBeat.i(105000);
    long l = System.currentTimeMillis();
    boolean bool;
    if (l - ((Long)pad.get(Integer.valueOf(paramInt))).longValue() < 10000L)
    {
      bool = ((Boolean)pac.get(Integer.valueOf(paramInt))).booleanValue();
      AppMethodBeat.o(105000);
      return bool;
    }
    pad.put(Integer.valueOf(paramInt), Long.valueOf(l));
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100283");
    if (!localc.isValid())
    {
      ab.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer item.isValid is false");
      bool = Al(paramInt);
      AppMethodBeat.o(105000);
      return bool;
    }
    Object localObject = localc.dvN();
    if (localObject == null)
    {
      ab.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer args == null");
      bool = Al(paramInt);
      AppMethodBeat.o(105000);
      return bool;
    }
    if (!((Map)localObject).containsKey("support_player_flag"))
    {
      ab.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the support_player_flag key");
      bool = Al(paramInt);
      AppMethodBeat.o(105000);
      return bool;
    }
    if (TextUtils.isEmpty((CharSequence)((Map)localObject).get("support_player_flag")))
    {
      ab.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the the value is empty");
      bool = Al(paramInt);
      AppMethodBeat.o(105000);
      return bool;
    }
    localObject = (String)((Map)localObject).get("support_player_flag");
    try
    {
      i = Integer.valueOf((String)localObject, 16).intValue();
      ab.i("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer contain support_player_flag:%s", new Object[] { localObject });
      l = ((Long)g.RL().Ru().get(ac.a.yFJ, Long.valueOf(0L))).longValue();
      if (l == 0L)
      {
        ab.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is 0");
        g.RL().Ru().set(ac.a.yFJ, Long.valueOf(localc.field_sequence));
        g.RL().Ru().set(ac.a.yFI, Integer.valueOf(i));
        bool = eR(paramInt, i);
        pac.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
        AppMethodBeat.o(105000);
        return bool;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Music.MusicPlayerSwitcher", localNumberFormatException, "supportQQMusicPlayer", new Object[0]);
        int i = 0;
        continue;
        if (l == localc.field_sequence)
        {
          ab.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is equal, check flag from local switch flag");
          bool = eR(paramInt, ((Integer)g.RL().Ru().get(ac.a.yFI, Integer.valueOf(i))).intValue());
        }
        else
        {
          ab.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is diff, update local data");
          g.RL().Ru().set(ac.a.yFJ, Long.valueOf(localc.field_sequence));
          g.RL().Ru().set(ac.a.yFI, Integer.valueOf(i));
          bool = eR(paramInt, i);
        }
      }
    }
  }
  
  private static boolean Al(int paramInt)
  {
    AppMethodBeat.i(105001);
    int i = ((Integer)g.RL().Ru().get(ac.a.yFI, Integer.valueOf(0))).intValue();
    boolean bool = eR(paramInt, i);
    ab.i("MicroMsg.Music.MusicPlayerSwitcher", "checkLocalSupportPlayerFlag support_player_flag:%s", new Object[] { Integer.toHexString(i) });
    pac.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
    AppMethodBeat.o(105001);
    return bool;
  }
  
  private static boolean eR(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(105002);
    if ((paramInt1 == 0) && ((paramInt2 & 0x1) > 0)) {
      ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support CHATTING_UI");
    }
    for (;;)
    {
      AppMethodBeat.o(105002);
      return bool;
      if ((paramInt1 == 1) && ((paramInt2 & 0x2) > 0))
      {
        ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_TIMELINE_UI");
      }
      else if ((paramInt1 == 4) && ((paramInt2 & 0x4) > 0))
      {
        ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support SHAKE_MUSIC_UI");
      }
      else if ((paramInt1 == 5) && ((paramInt2 & 0x8) > 0))
      {
        ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support PRODUCT_UI");
      }
      else if ((paramInt1 == 6) && ((paramInt2 & 0x10) > 0))
      {
        ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support FAVORITE_UI");
      }
      else if ((paramInt1 == 7) && ((paramInt2 & 0x20) > 0))
      {
        ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support WEBVIEW_UI");
      }
      else if ((paramInt1 == 8) && ((paramInt2 & 0x40) > 0))
      {
        ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_USER_TIMELINE_UI");
      }
      else if ((paramInt1 == 9) && ((paramInt2 & 0x80) > 0))
      {
        ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support SEARCH_TIMELINE_UI");
      }
      else
      {
        ab.i("MicroMsg.Music.MusicPlayerSwitcher", "QQMusicPlayer not support this scene %d", new Object[] { Integer.valueOf(paramInt1) });
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c.a
 * JD-Core Version:    0.7.0.1
 */