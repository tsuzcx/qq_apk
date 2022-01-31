package com.tencent.mm.plugin.music.model.c;

import android.text.TextUtils;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static HashMap<Integer, Boolean> mzW = new HashMap();
  private static HashMap<Integer, Long> mzX = new HashMap();
  
  static
  {
    mzW.put(Integer.valueOf(0), Boolean.valueOf(false));
    mzW.put(Integer.valueOf(1), Boolean.valueOf(false));
    mzW.put(Integer.valueOf(4), Boolean.valueOf(false));
    mzW.put(Integer.valueOf(5), Boolean.valueOf(false));
    mzW.put(Integer.valueOf(6), Boolean.valueOf(false));
    mzW.put(Integer.valueOf(7), Boolean.valueOf(false));
    mzW.put(Integer.valueOf(8), Boolean.valueOf(false));
    mzW.put(Integer.valueOf(9), Boolean.valueOf(false));
    mzX.put(Integer.valueOf(0), Long.valueOf(0L));
    mzX.put(Integer.valueOf(1), Long.valueOf(0L));
    mzX.put(Integer.valueOf(4), Long.valueOf(0L));
    mzX.put(Integer.valueOf(5), Long.valueOf(0L));
    mzX.put(Integer.valueOf(6), Long.valueOf(0L));
    mzX.put(Integer.valueOf(7), Long.valueOf(0L));
    mzX.put(Integer.valueOf(8), Long.valueOf(0L));
    mzX.put(Integer.valueOf(9), Long.valueOf(0L));
  }
  
  private static boolean dr(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && ((paramInt2 & 0x1) > 0))
    {
      y.i("MicroMsg.Music.MusicPlayerSwitcher", "support CHATTING_UI");
      return true;
    }
    if ((paramInt1 == 1) && ((paramInt2 & 0x2) > 0))
    {
      y.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_TIMELINE_UI");
      return true;
    }
    if ((paramInt1 == 4) && ((paramInt2 & 0x4) > 0))
    {
      y.i("MicroMsg.Music.MusicPlayerSwitcher", "support SHAKE_MUSIC_UI");
      return true;
    }
    if ((paramInt1 == 5) && ((paramInt2 & 0x8) > 0))
    {
      y.i("MicroMsg.Music.MusicPlayerSwitcher", "support PRODUCT_UI");
      return true;
    }
    if ((paramInt1 == 6) && ((paramInt2 & 0x10) > 0))
    {
      y.i("MicroMsg.Music.MusicPlayerSwitcher", "support FAVORITE_UI");
      return true;
    }
    if ((paramInt1 == 7) && ((paramInt2 & 0x20) > 0))
    {
      y.i("MicroMsg.Music.MusicPlayerSwitcher", "support WEBVIEW_UI");
      return true;
    }
    if ((paramInt1 == 8) && ((paramInt2 & 0x40) > 0))
    {
      y.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_USER_TIMELINE_UI");
      return true;
    }
    if ((paramInt1 == 9) && ((paramInt2 & 0x80) > 0))
    {
      y.i("MicroMsg.Music.MusicPlayerSwitcher", "support SEARCH_TIMELINE_UI");
      return true;
    }
    y.i("MicroMsg.Music.MusicPlayerSwitcher", "QQMusicPlayer not support this scene %d", new Object[] { Integer.valueOf(paramInt1) });
    return false;
  }
  
  public static boolean uJ(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - ((Long)mzX.get(Integer.valueOf(paramInt))).longValue() < 10000L) {
      return ((Boolean)mzW.get(Integer.valueOf(paramInt))).booleanValue();
    }
    mzX.put(Integer.valueOf(paramInt), Long.valueOf(l));
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100283");
    if (!localc.isValid())
    {
      y.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer item.isValid is false");
      return uO(paramInt);
    }
    Object localObject = localc.ctr();
    if (localObject == null)
    {
      y.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer args == null");
      return uO(paramInt);
    }
    if (!((Map)localObject).containsKey("support_player_flag"))
    {
      y.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the support_player_flag key");
      return uO(paramInt);
    }
    if (TextUtils.isEmpty((CharSequence)((Map)localObject).get("support_player_flag")))
    {
      y.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the the value is empty");
      return uO(paramInt);
    }
    localObject = (String)((Map)localObject).get("support_player_flag");
    try
    {
      i = Integer.valueOf((String)localObject, 16).intValue();
      y.i("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer contain support_player_flag:%s", new Object[] { localObject });
      l = ((Long)g.DP().Dz().get(ac.a.uvC, Long.valueOf(0L))).longValue();
      if (l == 0L)
      {
        y.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is 0");
        g.DP().Dz().c(ac.a.uvC, Long.valueOf(localc.field_sequence));
        g.DP().Dz().c(ac.a.uvB, Integer.valueOf(i));
        bool = dr(paramInt, i);
        mzW.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
        return bool;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        boolean bool;
        y.printErrStackTrace("MicroMsg.Music.MusicPlayerSwitcher", localNumberFormatException, "supportQQMusicPlayer", new Object[0]);
        int i = 0;
        continue;
        if (l == localc.field_sequence)
        {
          y.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is equal, check flag from local switch flag");
          bool = dr(paramInt, ((Integer)g.DP().Dz().get(ac.a.uvB, Integer.valueOf(i))).intValue());
        }
        else
        {
          y.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is diff, update local data");
          g.DP().Dz().c(ac.a.uvC, Long.valueOf(localc.field_sequence));
          g.DP().Dz().c(ac.a.uvB, Integer.valueOf(i));
          bool = dr(paramInt, i);
        }
      }
    }
  }
  
  private static boolean uO(int paramInt)
  {
    int i = ((Integer)g.DP().Dz().get(ac.a.uvB, Integer.valueOf(0))).intValue();
    boolean bool = dr(paramInt, i);
    y.i("MicroMsg.Music.MusicPlayerSwitcher", "checkLocalSupportPlayerFlag support_player_flag:%s", new Object[] { Integer.toHexString(i) });
    mzW.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c.a
 * JD-Core Version:    0.7.0.1
 */