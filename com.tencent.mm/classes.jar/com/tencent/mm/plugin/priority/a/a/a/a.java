package com.tencent.mm.plugin.priority.a.a.a;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class a
{
  public static final boolean akp(String paramString)
  {
    AppMethodBeat.i(40497);
    int i;
    if ((w.sD(paramString)) && (w.tt(paramString)))
    {
      i = 1;
      if ((!w.pF(paramString)) || (w.ts(paramString))) {
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
  
  public static final boolean daY()
  {
    AppMethodBeat.i(40498);
    if (!daZ())
    {
      AppMethodBeat.o(40498);
      return false;
    }
    if (!dba())
    {
      AppMethodBeat.o(40498);
      return false;
    }
    AppMethodBeat.o(40498);
    return true;
  }
  
  public static final boolean daZ()
  {
    AppMethodBeat.i(40499);
    if (!b.awN())
    {
      AppMethodBeat.o(40499);
      return true;
    }
    AppMethodBeat.o(40499);
    return false;
  }
  
  public static final boolean dba()
  {
    AppMethodBeat.i(40500);
    int i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("ChatImgAutoDownload"), 1);
    if (i == 3)
    {
      ad.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
      AppMethodBeat.o(40500);
      return false;
    }
    if ((i == 2) && (!ay.isWifi(aj.getContext())))
    {
      AppMethodBeat.o(40500);
      return false;
    }
    if (i == 1)
    {
      if (!ay.isWifi(aj.getContext()))
      {
        boolean bool = dbb();
        AppMethodBeat.o(40500);
        return bool;
      }
      AppMethodBeat.o(40500);
      return true;
    }
    AppMethodBeat.o(40500);
    return false;
  }
  
  private static boolean dbb()
  {
    AppMethodBeat.i(40501);
    long l2 = bt.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("ChatImgAutoDownloadMax"), 0);
    long l1 = bt.a((Long)g.afB().afk().get(ae.a.Fhd, null), 0L);
    long l3 = bt.aGi((String)DateFormat.format("M", System.currentTimeMillis()));
    long l4 = bt.a((Long)g.afB().afk().get(ae.a.Fhe, null), 0L);
    ad.d("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "currentmonth " + l3 + " month " + l4 + " maxcount " + l2 + " current " + l1);
    if (l3 != l4)
    {
      ad.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "update month %d ", new Object[] { Long.valueOf(l3) });
      g.afB().afk().set(ae.a.Fhd, Long.valueOf(0L));
      g.afB().afk().set(ae.a.Fhe, Long.valueOf(l3));
      l1 = 0L;
    }
    if ((l1 > l2) && (l2 > 0L))
    {
      ad.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "this month had auto download " + l1 + " C2C image, can not auto download.");
      AppMethodBeat.o(40501);
      return false;
    }
    AppMethodBeat.o(40501);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */