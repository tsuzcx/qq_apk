package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class wg
  extends com.tencent.mm.bv.a
{
  public b wOQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151640);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOQ != null) {
        paramVarArgs.c(1, this.wOQ);
      }
      AppMethodBeat.o(151640);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wOQ == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = e.a.a.b.b.a.b(1, this.wOQ) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(151640);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(151640);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        wg localwg = (wg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(151640);
          return -1;
        }
        localwg.wOQ = locala.CLY.eqS();
        AppMethodBeat.o(151640);
        return 0;
      }
      AppMethodBeat.o(151640);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wg
 * JD-Core Version:    0.7.0.1
 */