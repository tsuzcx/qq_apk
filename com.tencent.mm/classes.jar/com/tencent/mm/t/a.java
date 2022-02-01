package com.tencent.mm.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.d.a;
import com.tencent.mm.al.d.b;
import com.tencent.mm.al.e;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.e.d;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.cf;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bm;

public final class a
  implements q
{
  private static cv b(cv paramcv)
  {
    boolean bool = true;
    AppMethodBeat.i(114095);
    if (paramcv == null)
    {
      AppMethodBeat.o(114095);
      return null;
    }
    Object localObject = paramcv.Fvi;
    int i = paramcv.ugm;
    if (paramcv.Fvk == null) {}
    for (;;)
    {
      ad.i("FunctionMsg.FunctionMsgDispatcher", "processAddMsg, fromUser: %s, msgType: %s, content==null: %s", new Object[] { localObject, Integer.valueOf(i), Boolean.valueOf(bool) });
      localObject = bt.nullAsNil(z.a(paramcv.Fvi));
      if ("readerapp".equals(localObject))
      {
        paramcv.Fvi = z.IX("newsapp");
        paramcv.ugm = 12399999;
      }
      if (("blogapp".equals(localObject)) || ("newsapp".equals(localObject))) {
        paramcv.ugm = 12399999;
      }
      AppMethodBeat.o(114095);
      return paramcv;
      bool = false;
    }
  }
  
  public final void a(String paramString, h paramh, cv paramcv)
  {
    boolean bool2 = false;
    AppMethodBeat.i(114096);
    if ((paramh == null) || (paramcv == null))
    {
      if (paramh == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramcv == null) {
          bool2 = true;
        }
        ad.e("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] null == item?%s null == addMsg?%s MsgType:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramcv.ugm) });
        AppMethodBeat.o(114096);
        return;
      }
    }
    b(paramcv);
    try
    {
      d.b localb = new d.b();
      localb.hNS = paramh.field_businessInfo;
      localb.hNT = paramh.field_functionmsgid;
      if (paramh.field_actionTime == 0L) {}
      for (long l = cf.aCK() / 1000L;; l = paramh.field_actionTime)
      {
        paramcv.CreateTime = ((int)l);
        paramh.field_status = 100;
        paramh.a(paramcv);
        bm localbm = bm.IMc;
        bm.a(paramString, paramh);
        ad.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] item:%s CreateTime:%s", new Object[] { paramh, Integer.valueOf(paramcv.CreateTime) });
        e.d.ca(Integer.valueOf(paramcv.ugm)).b(new e.a(paramcv, localb));
        AppMethodBeat.o(114096);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(114096);
    }
  }
  
  public final void b(qu paramqu)
  {
    AppMethodBeat.i(114098);
    try
    {
      new d.b();
      d.a.bZ(Long.valueOf(paramqu.FMx));
      AppMethodBeat.o(114098);
      return;
    }
    catch (Exception paramqu)
    {
      ad.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramqu, "", new Object[0]);
      AppMethodBeat.o(114098);
    }
  }
  
  public final void b(String paramString, h paramh, cv paramcv)
  {
    AppMethodBeat.i(114097);
    ad.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgDelete] item:%s", new Object[] { paramh });
    try
    {
      b(paramcv);
      paramcv.CreateTime = ((int)paramh.field_actionTime);
      paramh.a(paramcv);
      paramh.field_status = 100;
      bm localbm = bm.IMc;
      bm.a(paramString, paramh);
      e.d.ca(Integer.valueOf(paramcv.ugm)).b(new e.c(paramcv, paramString, paramh));
      AppMethodBeat.o(114097);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(114097);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.t.a
 * JD-Core Version:    0.7.0.1
 */