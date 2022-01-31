package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class lh
  extends com.tencent.mm.bv.a
{
  public b wzC;
  public int wzD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151375);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wzC != null) {
        paramVarArgs.c(1, this.wzC);
      }
      paramVarArgs.aO(2, this.wzD);
      AppMethodBeat.o(151375);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wzC == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = e.a.a.b.b.a.b(1, this.wzC) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wzD);
      AppMethodBeat.o(151375);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(151375);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        lh locallh = (lh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(151375);
          return -1;
        case 1: 
          locallh.wzC = locala.CLY.eqS();
          AppMethodBeat.o(151375);
          return 0;
        }
        locallh.wzD = locala.CLY.sl();
        AppMethodBeat.o(151375);
        return 0;
      }
      AppMethodBeat.o(151375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lh
 * JD-Core Version:    0.7.0.1
 */