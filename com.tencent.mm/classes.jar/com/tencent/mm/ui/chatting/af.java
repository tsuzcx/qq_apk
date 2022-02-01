package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.modelimage.h;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;

public final class af
{
  public static String c(cc paramcc, k.b paramb)
  {
    AppMethodBeat.i(34824);
    String str2 = "";
    String str1 = str2;
    if (paramb != null)
    {
      str1 = str2;
      if (!Util.isNullOrNil(paramb.hzM))
      {
        paramb = as.cWJ().bpI(paramb.hzM);
        str1 = str2;
        if (paramb != null)
        {
          str1 = str2;
          if (paramb.efT())
          {
            str1 = str2;
            if (y.ZC(paramb.field_fileFullPath)) {
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
    if (paramcc != null) {
      str1 = r.bKa().X(paramcc.field_imgPath, true);
    }
    Log.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", new Object[] { str1 });
    AppMethodBeat.o(34824);
    return str1;
  }
  
  public static String cy(String paramString, long paramLong)
  {
    AppMethodBeat.i(253776);
    paramString = r.bKa().H(paramString, paramLong);
    if (paramString != null)
    {
      paramString = g(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(253776);
        return paramString;
      }
    }
    AppMethodBeat.o(253776);
    return null;
  }
  
  public static String cz(String paramString, long paramLong)
  {
    AppMethodBeat.i(253781);
    paramString = r.bKa().G(paramString, paramLong);
    if (paramString != null)
    {
      paramString = g(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(253781);
        return paramString;
      }
    }
    AppMethodBeat.o(253781);
    return null;
  }
  
  private static String g(h paramh)
  {
    AppMethodBeat.i(34823);
    if (paramh != null)
    {
      if (paramh.bJE())
      {
        str = paramh.oGr;
        if ((str != null) && (y.ZC(str)))
        {
          AppMethodBeat.o(34823);
          return str;
        }
      }
      String str = paramh.oGr;
      str = r.bKa().v(str, null, null);
      if ((str != null) && (y.ZC(str)))
      {
        AppMethodBeat.o(34823);
        return str;
      }
      paramh = paramh.oGt;
      paramh = r.bKa().v(paramh, null, null);
      if ((paramh != null) && (y.ZC(paramh)))
      {
        AppMethodBeat.o(34823);
        return paramh;
      }
    }
    AppMethodBeat.o(34823);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.af
 * JD-Core Version:    0.7.0.1
 */