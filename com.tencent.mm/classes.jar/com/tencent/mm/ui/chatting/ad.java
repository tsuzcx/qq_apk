package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;

public final class ad
{
  public static String c(ca paramca, k.b paramb)
  {
    AppMethodBeat.i(34824);
    String str2 = "";
    String str1 = str2;
    if (paramb != null)
    {
      str1 = str2;
      if (!Util.isNullOrNil(paramb.fvr))
      {
        paramb = ao.ctZ().bpR(paramb.fvr);
        str1 = str2;
        if (paramb != null)
        {
          str1 = str2;
          if (paramb.evg())
          {
            str1 = str2;
            if (u.agG(paramb.field_fileFullPath)) {
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
      str1 = q.bmh().T(paramca.field_imgPath, true);
    }
    Log.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", new Object[] { str1 });
    AppMethodBeat.o(34824);
    return str1;
  }
  
  public static String cm(String paramString, long paramLong)
  {
    AppMethodBeat.i(271118);
    paramString = f(q.bmh().D(paramString, paramLong));
    if (paramString != null)
    {
      AppMethodBeat.o(271118);
      return paramString;
    }
    AppMethodBeat.o(271118);
    return null;
  }
  
  public static String cn(String paramString, long paramLong)
  {
    AppMethodBeat.i(271120);
    paramString = f(q.bmh().C(paramString, paramLong));
    if (paramString != null)
    {
      AppMethodBeat.o(271120);
      return paramString;
    }
    AppMethodBeat.o(271120);
    return null;
  }
  
  private static String f(g paramg)
  {
    AppMethodBeat.i(34823);
    if (paramg != null)
    {
      if (paramg.blK())
      {
        str = paramg.lNH;
        if ((str != null) && (u.agG(str)))
        {
          AppMethodBeat.o(34823);
          return str;
        }
      }
      String str = paramg.lNH;
      str = q.bmh().r(str, null, null);
      if ((str != null) && (u.agG(str)))
      {
        AppMethodBeat.o(34823);
        return str;
      }
      paramg = paramg.lNJ;
      paramg = q.bmh().r(paramg, null, null);
      if ((paramg != null) && (u.agG(paramg)))
      {
        AppMethodBeat.o(34823);
        return paramg;
      }
    }
    AppMethodBeat.o(34823);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ad
 * JD-Core Version:    0.7.0.1
 */