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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class a
{
  public static final boolean auu(String paramString)
  {
    AppMethodBeat.i(40497);
    int i;
    if ((w.zD(paramString)) && (w.Au(paramString)))
    {
      i = 1;
      if ((!w.vF(paramString)) || (w.At(paramString))) {
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
  
  public static final boolean dzi()
  {
    AppMethodBeat.i(40498);
    if (!dzj())
    {
      AppMethodBeat.o(40498);
      return false;
    }
    if (!dzk())
    {
      AppMethodBeat.o(40498);
      return false;
    }
    AppMethodBeat.o(40498);
    return true;
  }
  
  public static final boolean dzj()
  {
    AppMethodBeat.i(40499);
    if (!b.aGK())
    {
      AppMethodBeat.o(40499);
      return true;
    }
    AppMethodBeat.o(40499);
    return false;
  }
  
  public static final boolean dzk()
  {
    AppMethodBeat.i(40500);
    int i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("ChatImgAutoDownload"), 1);
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
        boolean bool = dzl();
        AppMethodBeat.o(40500);
        return bool;
      }
      AppMethodBeat.o(40500);
      return true;
    }
    AppMethodBeat.o(40500);
    return false;
  }
  
  private static boolean dzl()
  {
    AppMethodBeat.i(40501);
    long l2 = bt.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("ChatImgAutoDownloadMax"), 0);
    long l1 = bt.a((Long)g.ajC().ajl().get(al.a.Irk, null), 0L);
    long l3 = bt.aRf((String)DateFormat.format("M", System.currentTimeMillis()));
    long l4 = bt.a((Long)g.ajC().ajl().get(al.a.Irl, null), 0L);
    ad.d("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "currentmonth " + l3 + " month " + l4 + " maxcount " + l2 + " current " + l1);
    if (l3 != l4)
    {
      ad.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "update month %d ", new Object[] { Long.valueOf(l3) });
      g.ajC().ajl().set(al.a.Irk, Long.valueOf(0L));
      g.ajC().ajl().set(al.a.Irl, Long.valueOf(l3));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */