package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/executor/FunctionExecutorFactory;", "", "()V", "FUNCTION_MSG_OP_DELAY", "", "FUNCTION_MSG_OP_DELETE", "FUNCTION_MSG_OP_SHOW", "FUNCTION_MSG_OP_UPDATE", "FUNCTION_MSG_OP_UPDATE_BUT_NO_SHOW", "get", "Lcom/tencent/mm/executor/IOpExecutor;", "op", "plugin-functionmsg_release"})
public final class a
{
  public static final a gtp;
  
  static
  {
    AppMethodBeat.i(114128);
    gtp = new a();
    AppMethodBeat.o(114128);
  }
  
  public static b mk(int paramInt)
  {
    AppMethodBeat.i(114127);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(114127);
      return null;
    case 0: 
      localb = (b)new g();
      AppMethodBeat.o(114127);
      return localb;
    case 1: 
      localb = (b)new d();
      AppMethodBeat.o(114127);
      return localb;
    case 2: 
      localb = (b)new e();
      AppMethodBeat.o(114127);
      return localb;
    case 3: 
      localb = (b)new f();
      AppMethodBeat.o(114127);
      return localb;
    }
    b localb = (b)new c();
    AppMethodBeat.o(114127);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.v.a
 * JD-Core Version:    0.7.0.1
 */