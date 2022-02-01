package com.tencent.mm.plugin.priority.a.a.a;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class a
{
  public static final boolean apo(String paramString)
  {
    AppMethodBeat.i(40497);
    int i;
    if ((w.wG(paramString)) && (w.xw(paramString)))
    {
      i = 1;
      if ((!w.sQ(paramString)) || (w.xv(paramString))) {
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
  
  public static final boolean doG()
  {
    AppMethodBeat.i(40498);
    if (!doH())
    {
      AppMethodBeat.o(40498);
      return false;
    }
    if (!doI())
    {
      AppMethodBeat.o(40498);
      return false;
    }
    AppMethodBeat.o(40498);
    return true;
  }
  
  public static final boolean doH()
  {
    AppMethodBeat.i(40499);
    if (!b.aDF())
    {
      AppMethodBeat.o(40499);
      return true;
    }
    AppMethodBeat.o(40499);
    return false;
  }
  
  public static final boolean doI()
  {
    AppMethodBeat.i(40500);
    int i = bs.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("ChatImgAutoDownload"), 1);
    if (i == 3)
    {
      ac.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
      AppMethodBeat.o(40500);
      return false;
    }
    if ((i == 2) && (!ax.isWifi(ai.getContext())))
    {
      AppMethodBeat.o(40500);
      return false;
    }
    if (i == 1)
    {
      if (!ax.isWifi(ai.getContext()))
      {
        boolean bool = doJ();
        AppMethodBeat.o(40500);
        return bool;
      }
      AppMethodBeat.o(40500);
      return true;
    }
    AppMethodBeat.o(40500);
    return false;
  }
  
  private static boolean doJ()
  {
    AppMethodBeat.i(40501);
    long l2 = bs.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("ChatImgAutoDownloadMax"), 0);
    long l1 = bs.a((Long)g.agR().agA().get(ah.a.GER, null), 0L);
    long l3 = bs.aLz((String)DateFormat.format("M", System.currentTimeMillis()));
    long l4 = bs.a((Long)g.agR().agA().get(ah.a.GES, null), 0L);
    ac.d("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "currentmonth " + l3 + " month " + l4 + " maxcount " + l2 + " current " + l1);
    if (l3 != l4)
    {
      ac.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "update month %d ", new Object[] { Long.valueOf(l3) });
      g.agR().agA().set(ah.a.GER, Long.valueOf(0L));
      g.agR().agA().set(ah.a.GES, Long.valueOf(l3));
      l1 = 0L;
    }
    if ((l1 > l2) && (l2 > 0L))
    {
      ac.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "this month had auto download " + l1 + " C2C image, can not auto download.");
      AppMethodBeat.o(40501);
      return false;
    }
    AppMethodBeat.o(40501);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */