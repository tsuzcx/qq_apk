package com.tencent.mm.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g.a;
import com.tencent.mm.ak.g.b;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bs;

public final class a
  implements s
{
  private static de b(de paramde)
  {
    boolean bool = true;
    AppMethodBeat.i(114095);
    if (paramde == null)
    {
      AppMethodBeat.o(114095);
      return null;
    }
    Object localObject = paramde.KHl;
    int i = paramde.xKb;
    if (paramde.KHn == null) {}
    for (;;)
    {
      Log.i("FunctionMsg.FunctionMsgDispatcher", "processAddMsg, fromUser: %s, msgType: %s, content==null: %s", new Object[] { localObject, Integer.valueOf(i), Boolean.valueOf(bool) });
      localObject = Util.nullAsNil(z.a(paramde.KHl));
      if ("readerapp".equals(localObject))
      {
        paramde.KHl = z.Su("newsapp");
        paramde.xKb = 12399999;
      }
      if (("blogapp".equals(localObject)) || ("newsapp".equals(localObject))) {
        paramde.xKb = 12399999;
      }
      AppMethodBeat.o(114095);
      return paramde;
      bool = false;
    }
  }
  
  public final void a(String paramString, i parami, de paramde)
  {
    boolean bool2 = false;
    AppMethodBeat.i(114096);
    if ((parami == null) || (paramde == null))
    {
      if (parami == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramde == null) {
          bool2 = true;
        }
        Log.e("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] null == item?%s null == addMsg?%s MsgType:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramde.xKb) });
        AppMethodBeat.o(114096);
        return;
      }
    }
    b(paramde);
    try
    {
      g.b localb = new g.b();
      localb.iLT = parami.field_businessInfo;
      localb.iLU = parami.field_functionmsgid;
      if (parami.field_actionTime == 0L) {}
      for (long l = cl.aWy() / 1000L;; l = parami.field_actionTime)
      {
        paramde.CreateTime = ((int)l);
        parami.field_status = 100;
        parami.a(paramde);
        bs localbs = bs.OqA;
        bs.a(paramString, parami);
        Log.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] item:%s CreateTime:%s", new Object[] { parami, Integer.valueOf(paramde.CreateTime) });
        h.d.ck(Integer.valueOf(paramde.xKb)).b(new h.a(paramde, localb));
        AppMethodBeat.o(114096);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(114096);
    }
  }
  
  public final void b(rx paramrx)
  {
    AppMethodBeat.i(114098);
    try
    {
      new g.b();
      g.a.cj(Long.valueOf(paramrx.KZn));
      AppMethodBeat.o(114098);
      return;
    }
    catch (Exception paramrx)
    {
      Log.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramrx, "", new Object[0]);
      AppMethodBeat.o(114098);
    }
  }
  
  public final void b(String paramString, i parami, de paramde)
  {
    AppMethodBeat.i(114097);
    Log.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgDelete] item:%s", new Object[] { parami });
    try
    {
      b(paramde);
      paramde.CreateTime = ((int)parami.field_actionTime);
      parami.a(paramde);
      parami.field_status = 100;
      bs localbs = bs.OqA;
      bs.a(paramString, parami);
      h.d.ck(Integer.valueOf(paramde.xKb)).b(new h.c(paramde, paramString, parami));
      AppMethodBeat.o(114097);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(114097);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.r.a
 * JD-Core Version:    0.7.0.1
 */