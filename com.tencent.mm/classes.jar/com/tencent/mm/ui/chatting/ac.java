package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.g;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;

public final class ac
{
  public static String cj(String paramString, long paramLong)
  {
    AppMethodBeat.i(193866);
    paramString = f(q.aIF().G(paramString, paramLong));
    if (paramString != null)
    {
      AppMethodBeat.o(193866);
      return paramString;
    }
    AppMethodBeat.o(193866);
    return null;
  }
  
  public static String ck(String paramString, long paramLong)
  {
    AppMethodBeat.i(193867);
    paramString = f(q.aIF().F(paramString, paramLong));
    if (paramString != null)
    {
      AppMethodBeat.o(193867);
      return paramString;
    }
    AppMethodBeat.o(193867);
    return null;
  }
  
  public static String d(bu parambu, k.b paramb)
  {
    AppMethodBeat.i(34824);
    String str2 = "";
    String str1 = str2;
    if (paramb != null)
    {
      str1 = str2;
      if (!bt.isNullOrNil(paramb.dks))
      {
        paramb = ao.bIX().aLD(paramb.dks);
        str1 = str2;
        if (paramb != null)
        {
          str1 = str2;
          if (paramb.cWz())
          {
            str1 = str2;
            if (com.tencent.mm.vfs.i.fv(paramb.field_fileFullPath)) {
              str1 = paramb.field_fileFullPath;
            }
          }
        }
      }
    }
    if (!bt.isNullOrNil(str1))
    {
      ad.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", new Object[] { str1 });
      AppMethodBeat.o(34824);
      return str1;
    }
    if (parambu != null) {
      str1 = q.aIF().R(parambu.field_imgPath, true);
    }
    ad.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", new Object[] { str1 });
    AppMethodBeat.o(34824);
    return str1;
  }
  
  private static String f(g paramg)
  {
    AppMethodBeat.i(34823);
    if (paramg != null)
    {
      if (paramg.aIj())
      {
        str = paramg.hZw;
        if ((str != null) && (com.tencent.mm.vfs.i.fv(str)))
        {
          AppMethodBeat.o(34823);
          return str;
        }
      }
      String str = paramg.hZw;
      str = q.aIF().o(str, null, null);
      if ((str != null) && (com.tencent.mm.vfs.i.fv(str)))
      {
        AppMethodBeat.o(34823);
        return str;
      }
      paramg = paramg.hZy;
      paramg = q.aIF().o(paramg, null, null);
      if ((paramg != null) && (com.tencent.mm.vfs.i.fv(paramg)))
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
 * Qualified Name:     com.tencent.mm.ui.chatting.ac
 * JD-Core Version:    0.7.0.1
 */