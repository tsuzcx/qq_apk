package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cty
  extends com.tencent.mm.bv.a
{
  public String ycS;
  public int ycT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102403);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ycS != null) {
        paramVarArgs.e(1, this.ycS);
      }
      paramVarArgs.aO(2, this.ycT);
      AppMethodBeat.o(102403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ycS == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = e.a.a.b.b.a.f(1, this.ycS) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.ycT);
      AppMethodBeat.o(102403);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(102403);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cty localcty = (cty)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(102403);
          return -1;
        case 1: 
          localcty.ycS = locala.CLY.readString();
          AppMethodBeat.o(102403);
          return 0;
        }
        localcty.ycT = locala.CLY.sl();
        AppMethodBeat.o(102403);
        return 0;
      }
      AppMethodBeat.o(102403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cty
 * JD-Core Version:    0.7.0.1
 */