package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class ac
{
  public static String a(bi parambi, j.b paramb)
  {
    AppMethodBeat.i(30944);
    String str2 = "";
    String str1 = str2;
    if (paramb != null)
    {
      str1 = str2;
      if (!bo.isNullOrNil(paramb.cmN))
      {
        paramb = al.aUJ().alo(paramb.cmN);
        str1 = str2;
        if (paramb != null)
        {
          str1 = str2;
          if (paramb.bEL())
          {
            str1 = str2;
            if (com.tencent.mm.vfs.e.cN(paramb.field_fileFullPath)) {
              str1 = paramb.field_fileFullPath;
            }
          }
        }
      }
    }
    if (!bo.isNullOrNil(str1))
    {
      ab.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", new Object[] { str1 });
      AppMethodBeat.o(30944);
      return str1;
    }
    if (parambi != null) {
      str1 = o.ahC().J(parambi.field_imgPath, true);
    }
    ab.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", new Object[] { str1 });
    AppMethodBeat.o(30944);
    return str1;
  }
  
  private static String h(com.tencent.mm.at.e parame)
  {
    AppMethodBeat.i(30943);
    if (parame != null)
    {
      if (parame.ahh())
      {
        str = parame.fDM;
        if ((str != null) && (com.tencent.mm.vfs.e.cN(str)))
        {
          AppMethodBeat.o(30943);
          return str;
        }
      }
      String str = parame.fDM;
      str = o.ahC().q(str, null, null);
      if ((str != null) && (com.tencent.mm.vfs.e.cN(str)))
      {
        AppMethodBeat.o(30943);
        return str;
      }
      parame = parame.fDO;
      parame = o.ahC().q(parame, null, null);
      if ((parame != null) && (com.tencent.mm.vfs.e.cN(parame)))
      {
        AppMethodBeat.o(30943);
        return parame;
      }
    }
    AppMethodBeat.o(30943);
    return null;
  }
  
  public static String oy(long paramLong)
  {
    AppMethodBeat.i(30941);
    String str = h(o.ahC().gT(paramLong));
    if (str != null)
    {
      AppMethodBeat.o(30941);
      return str;
    }
    AppMethodBeat.o(30941);
    return null;
  }
  
  public static String oz(long paramLong)
  {
    AppMethodBeat.i(30942);
    String str = h(o.ahC().gS(paramLong));
    if (str != null)
    {
      AppMethodBeat.o(30942);
      return str;
    }
    AppMethodBeat.o(30942);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ac
 * JD-Core Version:    0.7.0.1
 */