package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.g;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;

public final class ad
{
  public static String b(ca paramca, k.b paramb)
  {
    AppMethodBeat.i(34824);
    String str2 = "";
    String str1 = str2;
    if (paramb != null)
    {
      str1 = str2;
      if (!Util.isNullOrNil(paramb.dCK))
      {
        paramb = ao.cgO().bdx(paramb.dCK);
        str1 = str2;
        if (paramb != null)
        {
          str1 = str2;
          if (paramb.deQ())
          {
            str1 = str2;
            if (s.YS(paramb.field_fileFullPath)) {
              str1 = paramb.field_fileFullPath;
            }
          }
        }
      }
    }
    if (!Util.isNullOrNil(str1))
    {
      Log.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", new Object[] { str1 });
      AppMethodBeat.o(34824);
      return str1;
    }
    if (paramca != null) {
      str1 = q.bcR().R(paramca.field_imgPath, true);
    }
    Log.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", new Object[] { str1 });
    AppMethodBeat.o(34824);
    return str1;
  }
  
  public static String cf(String paramString, long paramLong)
  {
    AppMethodBeat.i(232912);
    paramString = f(q.bcR().H(paramString, paramLong));
    if (paramString != null)
    {
      AppMethodBeat.o(232912);
      return paramString;
    }
    AppMethodBeat.o(232912);
    return null;
  }
  
  public static String cg(String paramString, long paramLong)
  {
    AppMethodBeat.i(232913);
    paramString = f(q.bcR().G(paramString, paramLong));
    if (paramString != null)
    {
      AppMethodBeat.o(232913);
      return paramString;
    }
    AppMethodBeat.o(232913);
    return null;
  }
  
  private static String f(g paramg)
  {
    AppMethodBeat.i(34823);
    if (paramg != null)
    {
      if (paramg.bcv())
      {
        str = paramg.iXm;
        if ((str != null) && (s.YS(str)))
        {
          AppMethodBeat.o(34823);
          return str;
        }
      }
      String str = paramg.iXm;
      str = q.bcR().o(str, null, null);
      if ((str != null) && (s.YS(str)))
      {
        AppMethodBeat.o(34823);
        return str;
      }
      paramg = paramg.iXo;
      paramg = q.bcR().o(paramg, null, null);
      if ((paramg != null) && (s.YS(paramg)))
      {
        AppMethodBeat.o(34823);
        return paramg;
      }
    }
    AppMethodBeat.o(34823);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ad
 * JD-Core Version:    0.7.0.1
 */