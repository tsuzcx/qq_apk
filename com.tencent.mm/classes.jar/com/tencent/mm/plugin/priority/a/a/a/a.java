package com.tencent.mm.plugin.priority.a.a.a;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a
{
  public static final boolean WR(String paramString)
  {
    AppMethodBeat.i(97739);
    int i;
    if ((t.nT(paramString)) && (t.oI(paramString)))
    {
      i = 1;
      if ((!t.lA(paramString)) || (t.oH(paramString))) {
        break label57;
      }
    }
    label57:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) && (j == 0)) {
        break label62;
      }
      AppMethodBeat.o(97739);
      return true;
      i = 0;
      break;
    }
    label62:
    AppMethodBeat.o(97739);
    return false;
  }
  
  public static final boolean caM()
  {
    AppMethodBeat.i(97740);
    if (!caN())
    {
      AppMethodBeat.o(97740);
      return false;
    }
    if (!caO())
    {
      AppMethodBeat.o(97740);
      return false;
    }
    AppMethodBeat.o(97740);
    return true;
  }
  
  public static final boolean caN()
  {
    AppMethodBeat.i(97741);
    if (!b.afQ())
    {
      AppMethodBeat.o(97741);
      return true;
    }
    AppMethodBeat.o(97741);
    return false;
  }
  
  public static final boolean caO()
  {
    AppMethodBeat.i(97742);
    int i = bo.getInt(((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("ChatImgAutoDownload"), 1);
    if (i == 3)
    {
      ab.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "settings is not auto download C2C image. ChatImgAutoDownload : ".concat(String.valueOf(i)));
      AppMethodBeat.o(97742);
      return false;
    }
    if ((i == 2) && (!at.isWifi(ah.getContext())))
    {
      AppMethodBeat.o(97742);
      return false;
    }
    if (i == 1)
    {
      if (!at.isWifi(ah.getContext()))
      {
        boolean bool = caP();
        AppMethodBeat.o(97742);
        return bool;
      }
      AppMethodBeat.o(97742);
      return true;
    }
    AppMethodBeat.o(97742);
    return false;
  }
  
  private static boolean caP()
  {
    AppMethodBeat.i(97743);
    long l2 = bo.getInt(((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("ChatImgAutoDownloadMax"), 0);
    long l1 = bo.a((Long)g.RL().Ru().get(ac.a.yyI, null), 0L);
    long l3 = bo.apW((String)DateFormat.format("M", System.currentTimeMillis()));
    long l4 = bo.a((Long)g.RL().Ru().get(ac.a.yyJ, null), 0L);
    ab.d("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "currentmonth " + l3 + " month " + l4 + " maxcount " + l2 + " current " + l1);
    if (l3 != l4)
    {
      ab.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "update month %d ", new Object[] { Long.valueOf(l3) });
      g.RL().Ru().set(ac.a.yyI, Long.valueOf(0L));
      g.RL().Ru().set(ac.a.yyJ, Long.valueOf(l3));
      l1 = 0L;
    }
    if ((l1 > l2) && (l2 > 0L))
    {
      ab.i("MicroMsg.Priority.C2CMsgImgAutoDownloadControlLogic", "this month had auto download " + l1 + " C2C image, can not auto download.");
      AppMethodBeat.o(97743);
      return false;
    }
    AppMethodBeat.o(97743);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */