package com.tencent.mm.plugin.music.model.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.c;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static HashMap<Integer, Boolean> vfY;
  private static HashMap<Integer, Long> vfZ;
  
  static
  {
    AppMethodBeat.i(63133);
    vfY = new HashMap();
    vfZ = new HashMap();
    vfY.put(Integer.valueOf(0), Boolean.FALSE);
    vfY.put(Integer.valueOf(1), Boolean.FALSE);
    vfY.put(Integer.valueOf(4), Boolean.FALSE);
    vfY.put(Integer.valueOf(5), Boolean.FALSE);
    vfY.put(Integer.valueOf(6), Boolean.FALSE);
    vfY.put(Integer.valueOf(7), Boolean.FALSE);
    vfY.put(Integer.valueOf(8), Boolean.FALSE);
    vfY.put(Integer.valueOf(9), Boolean.FALSE);
    vfZ.put(Integer.valueOf(0), Long.valueOf(0L));
    vfZ.put(Integer.valueOf(1), Long.valueOf(0L));
    vfZ.put(Integer.valueOf(4), Long.valueOf(0L));
    vfZ.put(Integer.valueOf(5), Long.valueOf(0L));
    vfZ.put(Integer.valueOf(6), Long.valueOf(0L));
    vfZ.put(Integer.valueOf(7), Long.valueOf(0L));
    vfZ.put(Integer.valueOf(8), Long.valueOf(0L));
    vfZ.put(Integer.valueOf(9), Long.valueOf(0L));
    AppMethodBeat.o(63133);
  }
  
  public static boolean JI(int paramInt)
  {
    AppMethodBeat.i(63130);
    long l = System.currentTimeMillis();
    boolean bool;
    if (l - ((Long)vfZ.get(Integer.valueOf(paramInt))).longValue() < 10000L)
    {
      bool = ((Boolean)vfY.get(Integer.valueOf(paramInt))).booleanValue();
      AppMethodBeat.o(63130);
      return bool;
    }
    vfZ.put(Integer.valueOf(paramInt), Long.valueOf(l));
    c localc = com.tencent.mm.model.c.d.aAp().tJ("100283");
    if (!localc.isValid())
    {
      ac.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer item.isValid is false");
      bool = JN(paramInt);
      AppMethodBeat.o(63130);
      return bool;
    }
    Object localObject = localc.eYV();
    if (localObject == null)
    {
      ac.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer args == null");
      bool = JN(paramInt);
      AppMethodBeat.o(63130);
      return bool;
    }
    if (!((Map)localObject).containsKey("support_player_flag"))
    {
      ac.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the support_player_flag key");
      bool = JN(paramInt);
      AppMethodBeat.o(63130);
      return bool;
    }
    if (TextUtils.isEmpty((CharSequence)((Map)localObject).get("support_player_flag")))
    {
      ac.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the the value is empty");
      bool = JN(paramInt);
      AppMethodBeat.o(63130);
      return bool;
    }
    localObject = (String)((Map)localObject).get("support_player_flag");
    try
    {
      i = Integer.valueOf((String)localObject, 16).intValue();
      ac.i("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer contain support_player_flag:%s", new Object[] { localObject });
      l = ((Long)g.agR().agA().get(ah.a.GMh, Long.valueOf(0L))).longValue();
      if (l == 0L)
      {
        ac.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is 0");
        g.agR().agA().set(ah.a.GMh, Long.valueOf(localc.field_sequence));
        g.agR().agA().set(ah.a.GMg, Integer.valueOf(i));
        bool = gu(paramInt, i);
        vfY.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
        AppMethodBeat.o(63130);
        return bool;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Music.MusicPlayerSwitcher", localNumberFormatException, "supportQQMusicPlayer", new Object[0]);
        int i = 0;
        continue;
        if (l == localc.field_sequence)
        {
          ac.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is equal, check flag from local switch flag");
          bool = gu(paramInt, ((Integer)g.agR().agA().get(ah.a.GMg, Integer.valueOf(i))).intValue());
        }
        else
        {
          ac.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is diff, update local data");
          g.agR().agA().set(ah.a.GMh, Long.valueOf(localc.field_sequence));
          g.agR().agA().set(ah.a.GMg, Integer.valueOf(i));
          bool = gu(paramInt, i);
        }
      }
    }
  }
  
  private static boolean JN(int paramInt)
  {
    AppMethodBeat.i(63131);
    int i = ((Integer)g.agR().agA().get(ah.a.GMg, Integer.valueOf(0))).intValue();
    boolean bool = gu(paramInt, i);
    ac.i("MicroMsg.Music.MusicPlayerSwitcher", "checkLocalSupportPlayerFlag support_player_flag:%s", new Object[] { Integer.toHexString(i) });
    vfY.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
    AppMethodBeat.o(63131);
    return bool;
  }
  
  private static boolean gu(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(63132);
    if ((paramInt1 == 0) && ((paramInt2 & 0x1) > 0)) {
      ac.i("MicroMsg.Music.MusicPlayerSwitcher", "support CHATTING_UI");
    }
    for (;;)
    {
      AppMethodBeat.o(63132);
      return bool;
      if ((paramInt1 == 1) && ((paramInt2 & 0x2) > 0))
      {
        ac.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_TIMELINE_UI");
      }
      else if ((paramInt1 == 4) && ((paramInt2 & 0x4) > 0))
      {
        ac.i("MicroMsg.Music.MusicPlayerSwitcher", "support SHAKE_MUSIC_UI");
      }
      else if ((paramInt1 == 5) && ((paramInt2 & 0x8) > 0))
      {
        ac.i("MicroMsg.Music.MusicPlayerSwitcher", "support PRODUCT_UI");
      }
      else if ((paramInt1 == 6) && ((paramInt2 & 0x10) > 0))
      {
        ac.i("MicroMsg.Music.MusicPlayerSwitcher", "support FAVORITE_UI");
      }
      else if ((paramInt1 == 7) && ((paramInt2 & 0x20) > 0))
      {
        ac.i("MicroMsg.Music.MusicPlayerSwitcher", "support WEBVIEW_UI");
      }
      else if ((paramInt1 == 8) && ((paramInt2 & 0x40) > 0))
      {
        ac.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_USER_TIMELINE_UI");
      }
      else if ((paramInt1 == 9) && ((paramInt2 & 0x80) > 0))
      {
        ac.i("MicroMsg.Music.MusicPlayerSwitcher", "support SEARCH_TIMELINE_UI");
      }
      else
      {
        ac.i("MicroMsg.Music.MusicPlayerSwitcher", "QQMusicPlayer not support this scene %d", new Object[] { Integer.valueOf(paramInt1) });
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c.a
 * JD-Core Version:    0.7.0.1
 */