package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pi
  extends com.tencent.mm.bv.a
{
  public int jJS;
  public String wGN;
  public long wGO;
  public int wGP;
  public int woF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114434);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wGN != null) {
        paramVarArgs.e(1, this.wGN);
      }
      paramVarArgs.am(2, this.wGO);
      paramVarArgs.aO(3, this.wGP);
      paramVarArgs.aO(4, this.woF);
      paramVarArgs.aO(5, this.jJS);
      AppMethodBeat.o(114434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wGN == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = e.a.a.b.b.a.f(1, this.wGN) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.p(2, this.wGO);
      int j = e.a.a.b.b.a.bl(3, this.wGP);
      int k = e.a.a.b.b.a.bl(4, this.woF);
      int m = e.a.a.b.b.a.bl(5, this.jJS);
      AppMethodBeat.o(114434);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(114434);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        pi localpi = (pi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114434);
          return -1;
        case 1: 
          localpi.wGN = locala.CLY.readString();
          AppMethodBeat.o(114434);
          return 0;
        case 2: 
          localpi.wGO = locala.CLY.sm();
          AppMethodBeat.o(114434);
          return 0;
        case 3: 
          localpi.wGP = locala.CLY.sl();
          AppMethodBeat.o(114434);
          return 0;
        case 4: 
          localpi.woF = locala.CLY.sl();
          AppMethodBeat.o(114434);
          return 0;
        }
        localpi.jJS = locala.CLY.sl();
        AppMethodBeat.o(114434);
        return 0;
      }
      AppMethodBeat.o(114434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pi
 * JD-Core Version:    0.7.0.1
 */