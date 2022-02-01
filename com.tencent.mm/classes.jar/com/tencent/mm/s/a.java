package com.tencent.mm.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.ch;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bn;

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
    Object localObject = paramcv.FNG;
    int i = paramcv.urJ;
    if (paramcv.FNI == null) {}
    for (;;)
    {
      ae.i("FunctionMsg.FunctionMsgDispatcher", "processAddMsg, fromUser: %s, msgType: %s, content==null: %s", new Object[] { localObject, Integer.valueOf(i), Boolean.valueOf(bool) });
      localObject = bu.nullAsNil(z.a(paramcv.FNG));
      if ("readerapp".equals(localObject))
      {
        paramcv.FNG = z.Jw("newsapp");
        paramcv.urJ = 12399999;
      }
      if (("blogapp".equals(localObject)) || ("newsapp".equals(localObject))) {
        paramcv.urJ = 12399999;
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
        ae.e("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] null == item?%s null == addMsg?%s MsgType:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramcv.urJ) });
        AppMethodBeat.o(114096);
        return;
      }
    }
    b(paramcv);
    try
    {
      d.b localb = new d.b();
      localb.hQL = paramh.field_businessInfo;
      localb.hQM = paramh.field_functionmsgid;
      if (paramh.field_actionTime == 0L) {}
      for (long l = ch.aDa() / 1000L;; l = paramh.field_actionTime)
      {
        paramcv.CreateTime = ((int)l);
        paramh.field_status = 100;
        paramh.a(paramcv);
        bn localbn = bn.JgJ;
        bn.a(paramString, paramh);
        ae.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] item:%s CreateTime:%s", new Object[] { paramh, Integer.valueOf(paramcv.CreateTime) });
        e.d.ca(Integer.valueOf(paramcv.urJ)).b(new e.a(paramcv, localb));
        AppMethodBeat.o(114096);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(114096);
    }
  }
  
  public final void b(qw paramqw)
  {
    AppMethodBeat.i(114098);
    try
    {
      new d.b();
      d.a.bZ(Long.valueOf(paramqw.GeW));
      AppMethodBeat.o(114098);
      return;
    }
    catch (Exception paramqw)
    {
      ae.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramqw, "", new Object[0]);
      AppMethodBeat.o(114098);
    }
  }
  
  public final void b(String paramString, h paramh, cv paramcv)
  {
    AppMethodBeat.i(114097);
    ae.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgDelete] item:%s", new Object[] { paramh });
    try
    {
      b(paramcv);
      paramcv.CreateTime = ((int)paramh.field_actionTime);
      paramh.a(paramcv);
      paramh.field_status = 100;
      bn localbn = bn.JgJ;
      bn.a(paramString, paramh);
      e.d.ca(Integer.valueOf(paramcv.urJ)).b(new e.c(paramcv, paramString, paramh));
      AppMethodBeat.o(114097);
      return;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(114097);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.s.a
 * JD-Core Version:    0.7.0.1
 */