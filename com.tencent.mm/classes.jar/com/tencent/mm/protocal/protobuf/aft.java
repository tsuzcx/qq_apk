package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aft
  extends com.tencent.mm.bv.a
{
  public String fKw;
  public int jKs;
  public int wYU;
  public int wpF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96220);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.fKw != null) {
        paramVarArgs.e(1, this.fKw);
      }
      paramVarArgs.aO(2, this.jKs);
      paramVarArgs.aO(3, this.wpF);
      paramVarArgs.aO(4, this.wYU);
      AppMethodBeat.o(96220);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fKw == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = e.a.a.b.b.a.f(1, this.fKw) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.jKs);
      int j = e.a.a.b.b.a.bl(3, this.wpF);
      int k = e.a.a.b.b.a.bl(4, this.wYU);
      AppMethodBeat.o(96220);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96220);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aft localaft = (aft)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96220);
          return -1;
        case 1: 
          localaft.fKw = locala.CLY.readString();
          AppMethodBeat.o(96220);
          return 0;
        case 2: 
          localaft.jKs = locala.CLY.sl();
          AppMethodBeat.o(96220);
          return 0;
        case 3: 
          localaft.wpF = locala.CLY.sl();
          AppMethodBeat.o(96220);
          return 0;
        }
        localaft.wYU = locala.CLY.sl();
        AppMethodBeat.o(96220);
        return 0;
      }
      AppMethodBeat.o(96220);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aft
 * JD-Core Version:    0.7.0.1
 */