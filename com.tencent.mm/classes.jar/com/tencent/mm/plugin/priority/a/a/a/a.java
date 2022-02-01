package com.tencent.mm.plugin.priority.a.a.a;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.systemservicecache.NetworkCache;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;

public final class a
{
  public static final boolean aRG(String paramString)
  {
    AppMethodBeat.i(40497);
    int i;
    if ((ab.IR(paramString)) && (ab.Ja(paramString)))
    {
      i = 1;
      if ((!au.bwE(paramString)) || (ab.IZ(paramString))) {
        break label57;
      }
    }
    label57:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) && (j == 0)) {
        break label62;
      }
      AppMethodBeat.o(40497);
      return true;
      i = 0;
      break;
    }
    label62:
    AppMethodBeat.o(40497);
    return false;
  }
  
  public static final boolean gzN()
  {
    AppMethodBeat.i(40498);
    if (!gzO())
    {
      AppMethodBeat.o(40498);
      return false;
    }
    if (!gzP())
    {
      AppMethodBeat.o(40498);
      return false;
    }
    AppMethodBeat.o(40498);
    return true;
  }
  
  public static final boolean gzO()
  {
    AppMethodBeat.i(40499);
    if (!b.bHZ())
    {
      AppMethodBeat.o(40499);
      return true;
    }
    AppMethodBeat.o(40499);
    return false;
  }
  
  public static final boolean gzP()
  {
    AppMethodBeat.i(40500);
    int i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("ChatImgAutoDownload"), 1);
    if (i == 3)
    {
      Log.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
      AppMethodBeat.o(40500);
      return false;
    }
    if ((i == 2) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext())))
    {
      AppMethodBeat.o(40500);
      return false;
    }
    if (i == 1)
    {
      if (!NetworkCache.INSTANCE.isWifiFromCache(MMApplicationContext.getContext()))
      {
        boolean bool = gzQ();
        AppMethodBeat.o(40500);
        return bool;
      }
      AppMethodBeat.o(40500);
      return true;
    }
    AppMethodBeat.o(40500);
    return false;
  }
  
  private static boolean gzQ()
  {
    AppMethodBeat.i(40501);
    long l2 = Util.getInt(((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("ChatImgAutoDownloadMax"), 0);
    long l1 = Util.nullAs((Long)h.baE().ban().get(at.a.acJc, null), 0L);
    long l3 = Util.safeParseLong((String)DateFormat.format("M", System.currentTimeMillis()));
    long l4 = Util.nullAs((Long)h.baE().ban().get(at.a.acJd, null), 0L);
    Log.d("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "currentmonth " + l3 + " month " + l4 + " maxcount " + l2 + " current " + l1);
    if (l3 != l4)
    {
      Log.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "update month %d ", new Object[] { Long.valueOf(l3) });
      h.baE().ban().set(at.a.acJc, Long.valueOf(0L));
      h.baE().ban().set(at.a.acJd, Long.valueOf(l3));
      l1 = 0L;
    }
    if ((l1 > l2) && (l2 > 0L))
    {
      Log.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "this month had auto download " + l1 + " C2C image, can not auto download.");
      AppMethodBeat.o(40501);
      return false;
    }
    AppMethodBeat.o(40501);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */