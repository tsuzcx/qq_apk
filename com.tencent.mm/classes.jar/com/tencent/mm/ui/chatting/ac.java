package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.e;
import com.tencent.mm.av.g;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;

public final class ac
{
  public static String AZ(long paramLong)
  {
    AppMethodBeat.i(34821);
    String str = j(o.aFx().qg(paramLong));
    if (str != null)
    {
      AppMethodBeat.o(34821);
      return str;
    }
    AppMethodBeat.o(34821);
    return null;
  }
  
  public static String Ba(long paramLong)
  {
    AppMethodBeat.i(34822);
    String str = j(o.aFx().qf(paramLong));
    if (str != null)
    {
      AppMethodBeat.o(34822);
      return str;
    }
    AppMethodBeat.o(34822);
    return null;
  }
  
  public static String b(bo parambo, k.b paramb)
  {
    AppMethodBeat.i(34824);
    String str2 = "";
    String str1 = str2;
    if (paramb != null)
    {
      str1 = str2;
      if (!bs.isNullOrNil(paramb.cZa))
      {
        paramb = ap.bEO().aGd(paramb.cZa);
        str1 = str2;
        if (paramb != null)
        {
          str1 = str2;
          if (paramb.cOg())
          {
            str1 = str2;
            if (i.eA(paramb.field_fileFullPath)) {
              str1 = paramb.field_fileFullPath;
            }
          }
        }
      }
    }
    if (!bs.isNullOrNil(str1))
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", new Object[] { str1 });
      AppMethodBeat.o(34824);
      return str1;
    }
    if (parambo != null) {
      str1 = o.aFx().R(parambo.field_imgPath, true);
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", new Object[] { str1 });
    AppMethodBeat.o(34824);
    return str1;
  }
  
  private static String j(e parame)
  {
    AppMethodBeat.i(34823);
    if (parame != null)
    {
      if (parame.aFa())
      {
        str = parame.hGM;
        if ((str != null) && (i.eA(str)))
        {
          AppMethodBeat.o(34823);
          return str;
        }
      }
      String str = parame.hGM;
      str = o.aFx().p(str, null, null);
      if ((str != null) && (i.eA(str)))
      {
        AppMethodBeat.o(34823);
        return str;
      }
      parame = parame.hGO;
      parame = o.aFx().p(parame, null, null);
      if ((parame != null) && (i.eA(parame)))
      {
        AppMethodBeat.o(34823);
        return parame;
      }
    }
    AppMethodBeat.o(34823);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ac
 * JD-Core Version:    0.7.0.1
 */