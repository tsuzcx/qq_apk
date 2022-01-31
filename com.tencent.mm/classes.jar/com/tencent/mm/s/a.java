package com.tencent.mm.s;

import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.d.b;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.e.d;
import com.tencent.mm.api.k;
import com.tencent.mm.model.bz;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.kt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ba;

public final class a
  implements k
{
  private static cd b(cd paramcd)
  {
    boolean bool = true;
    if (paramcd == null)
    {
      localObject = null;
      return localObject;
    }
    Object localObject = paramcd.svF;
    int i = paramcd.kSW;
    if (paramcd.svH == null) {}
    for (;;)
    {
      y.i("FunctionMsg.FunctionMsgDispatcher", "processAddMsg, fromUser: %s, msgType: %s, content==null: %s", new Object[] { localObject, Integer.valueOf(i), Boolean.valueOf(bool) });
      String str = bk.pm(aa.a(paramcd.svF));
      if ("readerapp".equals(str))
      {
        paramcd.svF = aa.pj("newsapp");
        paramcd.kSW = 12399999;
      }
      if (!"blogapp".equals(str))
      {
        localObject = paramcd;
        if (!"newsapp".equals(str)) {
          break;
        }
      }
      paramcd.kSW = 12399999;
      return paramcd;
      bool = false;
    }
  }
  
  public final void a(String paramString, com.tencent.mm.api.e parame, cd paramcd)
  {
    boolean bool2 = false;
    if ((parame == null) || (paramcd == null))
    {
      if (parame == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramcd == null) {
          bool2 = true;
        }
        y.e("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] null == item?%s null == addMsg?%s MsgType:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramcd.kSW) });
        return;
      }
    }
    b(paramcd);
    y.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgAdd] item:%s", new Object[] { parame });
    for (;;)
    {
      try
      {
        d.b localb = new d.b();
        localb.ecQ = parame.field_businessInfo;
        localb.ecR = parame.field_functionmsgid;
        if (parame.field_actionTime == 0L)
        {
          l = bz.Is() / 1000L;
          paramcd.mPL = ((int)l);
          parame.field_status = 100;
          parame.a(paramcd);
          ba localba = ba.uBO;
          ba.a(paramString, parame);
          e.d.aB(Integer.valueOf(paramcd.kSW)).b(new e.a(paramcd, localb));
          return;
        }
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramString, "", new Object[0]);
        return;
      }
      long l = parame.field_actionTime;
    }
  }
  
  public final void b(kt paramkt)
  {
    try
    {
      new d.b();
      d.a.aA(Long.valueOf(paramkt.sFI));
      return;
    }
    catch (Exception paramkt)
    {
      y.printErrStackTrace("FunctionMsg.FunctionMsgDispatcher", paramkt, "", new Object[0]);
    }
  }
  
  public final void b(String paramString, com.tencent.mm.api.e parame, cd paramcd)
  {
    y.i("FunctionMsg.FunctionMsgDispatcher", "[onFunctionMsgDelete] item:%s", new Object[] { parame });
    b(paramcd);
    paramcd.mPL = ((int)parame.field_actionTime);
    parame.a(paramcd);
    parame.field_status = 100;
    ba localba = ba.uBO;
    ba.a(paramString, parame);
    e.d.aB(Integer.valueOf(paramcd.kSW)).a(new e.c(paramcd, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.s.a
 * JD-Core Version:    0.7.0.1
 */