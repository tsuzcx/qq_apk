package com.tencent.mm.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.g;
import com.tencent.mm.an.g.a;
import com.tencent.mm.an.g.b;
import com.tencent.mm.an.h;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.an.h.d;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.model.cm;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bs;
import java.util.Iterator;
import java.util.List;

public final class a
  implements s
{
  private static db b(db paramdb)
  {
    boolean bool = true;
    AppMethodBeat.i(114095);
    if (paramdb == null)
    {
      AppMethodBeat.o(114095);
      return null;
    }
    Object localObject = paramdb.RID;
    int i = paramdb.COi;
    if (paramdb.RIF == null) {}
    for (;;)
    {
      Log.i("FunctionMsg.FunctionMsgDispatcher", "processAddMsg, fromUser: %s, msgType: %s, content==null: %s", new Object[] { localObject, Integer.valueOf(i), Boolean.valueOf(bool) });
      localObject = Util.nullAsNil(z.a(paramdb.RID));
      if ("readerapp".equals(localObject))
      {
        paramdb.RID = z.ZW("newsapp");
        paramdb.COi = 12399999;
      }
      if (("blogapp".equals(localObject)) || ("newsapp".equals(localObject))) {
        paramdb.COi = 12399999;
      }
      AppMethodBeat.o(114095);
      return paramdb;
      bool = false;
    }
  }
  
  public final void a(String paramString, i parami, db paramdb)
  {
    AppMethodBeat.i(114097);
    Log.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgDelete] item:%s", new Object[] { parami });
    try
    {
      b(paramdb);
      paramdb.CreateTime = ((int)parami.field_actionTime);
      parami.a(paramdb);
      parami.field_status = 100;
      bs localbs = bs.VGw;
      bs.a(paramString, parami);
      h.d.cj(Integer.valueOf(paramdb.COi)).b(new h.c(paramdb, paramString, parami));
      AppMethodBeat.o(114097);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(114097);
    }
  }
  
  public final void a(String paramString, i parami, db paramdb, List<db> paramList)
  {
    AppMethodBeat.i(258347);
    Object localObject;
    for (;;)
    {
      try
      {
        b(paramdb);
        if (parami.field_businessInfo != null)
        {
          localObject = g.a.Gp(parami.field_businessInfo.Saw);
          if (localObject != null) {
            ((g)localObject).aAs();
          }
        }
        localObject = new g.b();
        ((g.b)localObject).lCa = parami.field_businessInfo;
        ((g.b)localObject).lCb = parami.field_functionmsgid;
        if (parami.field_actionTime == 0L)
        {
          l = cm.bfC() / 1000L;
          paramdb.CreateTime = ((int)l);
          parami.field_status = 100;
          parami.a(paramdb);
          bs localbs = bs.VGw;
          bs.a(paramString, parami);
          Log.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] item:%s CreateTime:%s", new Object[] { parami, Integer.valueOf(paramdb.CreateTime) });
          if ((paramList == null) || (paramList.size() <= 0)) {
            break label312;
          }
          Log.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] addMsgList.size:%s ", new Object[] { Integer.valueOf(paramList.size()) });
          paramString = paramList.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          paramdb = (db)paramString.next();
          if (paramdb.CreateTime <= 0L)
          {
            if (parami.field_actionTime != 0L) {
              break label297;
            }
            l = cm.bfC() / 1000L;
            paramdb.CreateTime = ((int)l);
          }
          h.d.cj(Integer.valueOf(paramdb.COi)).b(new h.a(paramdb, localObject));
          continue;
        }
        l = parami.field_actionTime;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
        AppMethodBeat.o(258347);
        return;
      }
      continue;
      label297:
      long l = parami.field_actionTime;
    }
    AppMethodBeat.o(258347);
    return;
    label312:
    paramString = h.d.cj(Integer.valueOf(paramdb.COi));
    if (paramString != null) {
      paramString.b(new h.a(paramdb, localObject));
    }
    AppMethodBeat.o(258347);
  }
  
  public final void a(String paramString, rq paramrq)
  {
    AppMethodBeat.i(258350);
    try
    {
      g.b localb = new g.b();
      localb.lCb = paramString;
      localb.lCa = paramrq;
      if (paramrq != null)
      {
        paramString = g.a.Gp((int)paramrq.Saw);
        if (paramString != null)
        {
          paramString.a(localb);
          paramrq.Sax = localb.lCa.Sax;
        }
      }
      AppMethodBeat.o(258350);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(258350);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.r.a
 * JD-Core Version:    0.7.0.1
 */