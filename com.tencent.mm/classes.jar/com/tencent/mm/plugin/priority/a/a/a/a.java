package com.tencent.mm.plugin.priority.a.a.a;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class a
{
  public static final boolean avJ(String paramString)
  {
    AppMethodBeat.i(40497);
    int i;
    if ((x.An(paramString)) && (x.Be(paramString)))
    {
      i = 1;
      if ((!x.wb(paramString)) || (x.Bd(paramString))) {
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
  
  public static final boolean dCA()
  {
    AppMethodBeat.i(40499);
    if (!b.aHb())
    {
      AppMethodBeat.o(40499);
      return true;
    }
    AppMethodBeat.o(40499);
    return false;
  }
  
  public static final boolean dCB()
  {
    AppMethodBeat.i(40500);
    int i = bu.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("ChatImgAutoDownload"), 1);
    if (i == 3)
    {
      ae.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
      AppMethodBeat.o(40500);
      return false;
    }
    if ((i == 2) && (!az.isWifi(ak.getContext())))
    {
      AppMethodBeat.o(40500);
      return false;
    }
    if (i == 1)
    {
      if (!az.isWifi(ak.getContext()))
      {
        boolean bool = dCC();
        AppMethodBeat.o(40500);
        return bool;
      }
      AppMethodBeat.o(40500);
      return true;
    }
    AppMethodBeat.o(40500);
    return false;
  }
  
  private static boolean dCC()
  {
    AppMethodBeat.i(40501);
    long l2 = bu.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("ChatImgAutoDownloadMax"), 0);
    long l1 = bu.a((Long)g.ajR().ajA().get(am.a.ILG, null), 0L);
    long l3 = bu.aSC((String)DateFormat.format("M", System.currentTimeMillis()));
    long l4 = bu.a((Long)g.ajR().ajA().get(am.a.ILH, null), 0L);
    ae.d("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "currentmonth " + l3 + " month " + l4 + " maxcount " + l2 + " current " + l1);
    if (l3 != l4)
    {
      ae.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "update month %d ", new Object[] { Long.valueOf(l3) });
      g.ajR().ajA().set(am.a.ILG, Long.valueOf(0L));
      g.ajR().ajA().set(am.a.ILH, Long.valueOf(l3));
      l1 = 0L;
    }
    if ((l1 > l2) && (l2 > 0L))
    {
      ae.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "this month had auto download " + l1 + " C2C image, can not auto download.");
      AppMethodBeat.o(40501);
      return false;
    }
    AppMethodBeat.o(40501);
    return true;
  }
  
  public static final boolean dCz()
  {
    AppMethodBeat.i(40498);
    if (!dCA())
    {
      AppMethodBeat.o(40498);
      return false;
    }
    if (!dCB())
    {
      AppMethodBeat.o(40498);
      return false;
    }
    AppMethodBeat.o(40498);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */