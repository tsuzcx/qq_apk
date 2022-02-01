package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/executor/FunctionExecutorFactory;", "", "()V", "FUNCTION_MSG_OP_DELAY", "", "FUNCTION_MSG_OP_DELETE", "FUNCTION_MSG_OP_SHOW", "FUNCTION_MSG_OP_UPDATE", "FUNCTION_MSG_OP_UPDATE_BUT_NO_SHOW", "get", "Lcom/tencent/mm/executor/IOpExecutor;", "op", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a mqa;
  
  static
  {
    AppMethodBeat.i(114128);
    mqa = new a();
    AppMethodBeat.o(114128);
  }
  
  public static b rS(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.a
 * JD-Core Version:    0.7.0.1
 */