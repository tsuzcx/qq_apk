package com.tencent.mm.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.d.a;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.api.f;
import com.tencent.mm.api.l;
import com.tencent.mm.model.cb;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ba;

public final class a
  implements l
{
  private static cm b(cm paramcm)
  {
    boolean bool = true;
    AppMethodBeat.i(35445);
    if (paramcm == null)
    {
      AppMethodBeat.o(35445);
      return null;
    }
    Object localObject = paramcm.woP;
    int i = paramcm.nqW;
    if (paramcm.woR == null) {}
    for (;;)
    {
      ab.i("FunctionMsg.FunctionMsgDispatcher", "processAddMsg, fromUser: %s, msgType: %s, content==null: %s", new Object[] { localObject, Integer.valueOf(i), Boolean.valueOf(bool) });
      localObject = bo.nullAsNil(aa.a(paramcm.woP));
      if ("readerapp".equals(localObject))
      {
        paramcm.woP = aa.wA("newsapp");
        paramcm.nqW = 12399999;
      }
      if (("blogapp".equals(localObject)) || ("newsapp".equals(localObject))) {
        paramcm.nqW = 12399999;
      }
      AppMethodBeat.o(35445);
      return paramcm;
      bool = false;
    }
  }
  
  public final void a(String paramString, f paramf, cm paramcm)
  {
    boolean bool2 = false;
    AppMethodBeat.i(35446);
    if ((paramf == null) || (paramcm == null))
    {
      if (paramf == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramcm == null) {
          bool2 = true;
        }
        ab.e("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] null == item?%s null == addMsg?%s MsgType:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramcm.nqW) });
        AppMethodBeat.o(35446);
        return;
      }
    }
    b(paramcm);
    try
    {
      d.b localb = new d.b();
      localb.ftc = paramf.field_businessInfo;
      localb.ftd = paramf.field_functionmsgid;
      if (paramf.field_actionTime == 0L) {}
      for (long l = cb.abp() / 1000L;; l = paramf.field_actionTime)
      {
        paramcm.CreateTime = ((int)l);
        paramf.field_status = 100;
        paramf.a(paramcm);
        ba localba = ba.yOa;
        ba.a(paramString, paramf);
        ab.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] item:%s CreateTime:%s", new Object[] { paramf, Integer.valueOf(paramcm.CreateTime) });
        e.d.aV(Integer.valueOf(paramcm.nqW)).b(new e.a(paramcm, localb));
        AppMethodBeat.o(35446);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(35446);
    }
  }
  
  public final void b(nf paramnf)
  {
    AppMethodBeat.i(35448);
    try
    {
      new d.b();
      d.a.aU(Long.valueOf(paramnf.wCc));
      AppMethodBeat.o(35448);
      return;
    }
    catch (Exception paramnf)
    {
      ab.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramnf, "", new Object[0]);
      AppMethodBeat.o(35448);
    }
  }
  
  public final void b(String paramString, f paramf, cm paramcm)
  {
    AppMethodBeat.i(35447);
    ab.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgDelete] item:%s", new Object[] { paramf });
    try
    {
      b(paramcm);
      paramcm.CreateTime = ((int)paramf.field_actionTime);
      paramf.a(paramcm);
      paramf.field_status = 100;
      ba localba = ba.yOa;
      ba.a(paramString, paramf);
      e.d.aV(Integer.valueOf(paramcm.nqW)).a(new e.c(paramcm, paramString));
      AppMethodBeat.o(35447);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(35447);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.s.a
 * JD-Core Version:    0.7.0.1
 */