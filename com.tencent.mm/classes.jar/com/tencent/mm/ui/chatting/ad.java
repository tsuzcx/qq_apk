package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.g;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;

public final class ad
{
  public static String ck(String paramString, long paramLong)
  {
    AppMethodBeat.i(187172);
    paramString = f(q.aIX().G(paramString, paramLong));
    if (paramString != null)
    {
      AppMethodBeat.o(187172);
      return paramString;
    }
    AppMethodBeat.o(187172);
    return null;
  }
  
  public static String cl(String paramString, long paramLong)
  {
    AppMethodBeat.i(187173);
    paramString = f(q.aIX().F(paramString, paramLong));
    if (paramString != null)
    {
      AppMethodBeat.o(187173);
      return paramString;
    }
    AppMethodBeat.o(187173);
    return null;
  }
  
  public static String d(bv parambv, k.b paramb)
  {
    AppMethodBeat.i(34824);
    String str2 = "";
    String str1 = str2;
    if (paramb != null)
    {
      str1 = str2;
      if (!bu.isNullOrNil(paramb.dlu))
      {
        paramb = ao.bJV().aMZ(paramb.dlu);
        str1 = str2;
        if (paramb != null)
        {
          str1 = str2;
          if (paramb.cZe())
          {
            str1 = str2;
            if (o.fB(paramb.field_fileFullPath)) {
              str1 = paramb.field_fileFullPath;
            }
          }
        }
      }
    }
    if (!bu.isNullOrNil(str1))
    {
      ae.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", new Object[] { str1 });
      AppMethodBeat.o(34824);
      return str1;
    }
    if (parambv != null) {
      str1 = q.aIX().R(parambv.field_imgPath, true);
    }
    ae.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", new Object[] { str1 });
    AppMethodBeat.o(34824);
    return str1;
  }
  
  private static String f(g paramg)
  {
    AppMethodBeat.i(34823);
    if (paramg != null)
    {
      if (paramg.aIB())
      {
        str = paramg.ico;
        if ((str != null) && (o.fB(str)))
        {
          AppMethodBeat.o(34823);
          return str;
        }
      }
      String str = paramg.ico;
      str = q.aIX().o(str, null, null);
      if ((str != null) && (o.fB(str)))
      {
        AppMethodBeat.o(34823);
        return str;
      }
      paramg = paramg.icq;
      paramg = q.aIX().o(paramg, null, null);
      if ((paramg != null) && (o.fB(paramg)))
      {
        AppMethodBeat.o(34823);
        return paramg;
      }
    }
    AppMethodBeat.o(34823);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ad
 * JD-Core Version:    0.7.0.1
 */