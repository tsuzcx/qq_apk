package com.tencent.mm.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.al.f.d;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.ce;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;

public final class a
  implements q
{
  private static cs b(cs paramcs)
  {
    boolean bool = true;
    AppMethodBeat.i(114095);
    if (paramcs == null)
    {
      AppMethodBeat.o(114095);
      return null;
    }
    Object localObject = paramcs.Cxx;
    int i = paramcs.saz;
    if (paramcs.Cxz == null) {}
    for (;;)
    {
      ad.i("FunctionMsg.FunctionMsgDispatcher", "processAddMsg, fromUser: %s, msgType: %s, content==null: %s", new Object[] { localObject, Integer.valueOf(i), Boolean.valueOf(bool) });
      localObject = bt.nullAsNil(z.a(paramcs.Cxx));
      if ("readerapp".equals(localObject))
      {
        paramcs.Cxx = z.BE("newsapp");
        paramcs.saz = 12399999;
      }
      if (("blogapp".equals(localObject)) || ("newsapp".equals(localObject))) {
        paramcs.saz = 12399999;
      }
      AppMethodBeat.o(114095);
      return paramcs;
      bool = false;
    }
  }
  
  public final void a(String paramString, h paramh, cs paramcs)
  {
    boolean bool2 = false;
    AppMethodBeat.i(114096);
    if ((paramh == null) || (paramcs == null))
    {
      if (paramh == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramcs == null) {
          bool2 = true;
        }
        ad.e("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] null == item?%s null == addMsg?%s MsgType:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramcs.saz) });
        AppMethodBeat.o(114096);
        return;
      }
    }
    b(paramcs);
    try
    {
      e.b localb = new e.b();
      localb.gVe = paramh.field_businessInfo;
      localb.gVf = paramh.field_functionmsgid;
      if (paramh.field_actionTime == 0L) {}
      for (long l = ce.asQ() / 1000L;; l = paramh.field_actionTime)
      {
        paramcs.CreateTime = ((int)l);
        paramh.field_status = 100;
        paramh.a(paramcs);
        bd localbd = bd.FzL;
        bd.a(paramString, paramh);
        ad.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] item:%s CreateTime:%s", new Object[] { paramh, Integer.valueOf(paramcs.CreateTime) });
        f.d.ca(Integer.valueOf(paramcs.saz)).b(new f.a(paramcs, localb));
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
  
  public final void b(pi parampi)
  {
    AppMethodBeat.i(114098);
    try
    {
      new e.b();
      e.a.bZ(Long.valueOf(parampi.CNw));
      AppMethodBeat.o(114098);
      return;
    }
    catch (Exception parampi)
    {
      ad.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", parampi, "", new Object[0]);
      AppMethodBeat.o(114098);
    }
  }
  
  public final void b(String paramString, h paramh, cs paramcs)
  {
    AppMethodBeat.i(114097);
    ad.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgDelete] item:%s", new Object[] { paramh });
    try
    {
      b(paramcs);
      paramcs.CreateTime = ((int)paramh.field_actionTime);
      paramh.a(paramcs);
      paramh.field_status = 100;
      bd localbd = bd.FzL;
      bd.a(paramString, paramh);
      f.d.ca(Integer.valueOf(paramcs.saz)).b(new f.c(paramcs, paramString, paramh));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.s.a
 * JD-Core Version:    0.7.0.1
 */