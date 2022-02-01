package com.tencent.mm.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.ce;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bg;

public final class a
  implements q
{
  private static cu b(cu paramcu)
  {
    boolean bool = true;
    AppMethodBeat.i(114095);
    if (paramcu == null)
    {
      AppMethodBeat.o(114095);
      return null;
    }
    Object localObject = paramcu.DPT;
    int i = paramcu.tit;
    if (paramcu.DPV == null) {}
    for (;;)
    {
      ac.i("FunctionMsg.FunctionMsgDispatcher", "processAddMsg, fromUser: %s, msgType: %s, content==null: %s", new Object[] { localObject, Integer.valueOf(i), Boolean.valueOf(bool) });
      localObject = bs.nullAsNil(z.a(paramcu.DPT));
      if ("readerapp".equals(localObject))
      {
        paramcu.DPT = z.FI("newsapp");
        paramcu.tit = 12399999;
      }
      if (("blogapp".equals(localObject)) || ("newsapp".equals(localObject))) {
        paramcu.tit = 12399999;
      }
      AppMethodBeat.o(114095);
      return paramcu;
      bool = false;
    }
  }
  
  public final void a(String paramString, h paramh, cu paramcu)
  {
    boolean bool2 = false;
    AppMethodBeat.i(114096);
    if ((paramh == null) || (paramcu == null))
    {
      if (paramh == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramcu == null) {
          bool2 = true;
        }
        ac.e("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] null == item?%s null == addMsg?%s MsgType:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramcu.tit) });
        AppMethodBeat.o(114096);
        return;
      }
    }
    b(paramcu);
    try
    {
      e.b localb = new e.b();
      localb.hvD = paramh.field_businessInfo;
      localb.hvE = paramh.field_functionmsgid;
      if (paramh.field_actionTime == 0L) {}
      for (long l = ce.azH() / 1000L;; l = paramh.field_actionTime)
      {
        paramcu.CreateTime = ((int)l);
        paramh.field_status = 100;
        paramh.a(paramcu);
        bg localbg = bg.GYN;
        bg.a(paramString, paramh);
        ac.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] item:%s CreateTime:%s", new Object[] { paramh, Integer.valueOf(paramcu.CreateTime) });
        f.d.bY(Integer.valueOf(paramcu.tit)).b(new f.a(paramcu, localb));
        AppMethodBeat.o(114096);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(114096);
    }
  }
  
  public final void b(pp parampp)
  {
    AppMethodBeat.i(114098);
    try
    {
      new e.b();
      e.a.bX(Long.valueOf(parampp.EfY));
      AppMethodBeat.o(114098);
      return;
    }
    catch (Exception parampp)
    {
      ac.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", parampp, "", new Object[0]);
      AppMethodBeat.o(114098);
    }
  }
  
  public final void b(String paramString, h paramh, cu paramcu)
  {
    AppMethodBeat.i(114097);
    ac.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgDelete] item:%s", new Object[] { paramh });
    try
    {
      b(paramcu);
      paramcu.CreateTime = ((int)paramh.field_actionTime);
      paramh.a(paramcu);
      paramh.field_status = 100;
      bg localbg = bg.GYN;
      bg.a(paramString, paramh);
      f.d.bY(Integer.valueOf(paramcu.tit)).b(new f.c(paramcu, paramString, paramh));
      AppMethodBeat.o(114097);
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(114097);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.s.a
 * JD-Core Version:    0.7.0.1
 */