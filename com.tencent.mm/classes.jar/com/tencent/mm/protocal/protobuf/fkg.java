package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fkg
  extends com.tencent.mm.bx.a
{
  public String aaQP;
  public int abKF;
  public int abKI;
  public int abKx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152709);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaQP != null) {
        paramVarArgs.g(1, this.aaQP);
      }
      paramVarArgs.bS(2, this.abKx);
      paramVarArgs.bS(3, this.abKF);
      paramVarArgs.bS(4, this.abKI);
      AppMethodBeat.o(152709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaQP == null) {
        break label346;
      }
    }
    label346:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaQP) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abKx);
      int j = i.a.a.b.b.a.cJ(3, this.abKF);
      int k = i.a.a.b.b.a.cJ(4, this.abKI);
      AppMethodBeat.o(152709);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152709);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fkg localfkg = (fkg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152709);
          return -1;
        case 1: 
          localfkg.aaQP = locala.ajGk.readString();
          AppMethodBeat.o(152709);
          return 0;
        case 2: 
          localfkg.abKx = locala.ajGk.aar();
          AppMethodBeat.o(152709);
          return 0;
        case 3: 
          localfkg.abKF = locala.ajGk.aar();
          AppMethodBeat.o(152709);
          return 0;
        }
        localfkg.abKI = locala.ajGk.aar();
        AppMethodBeat.o(152709);
        return 0;
      }
      AppMethodBeat.o(152709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkg
 * JD-Core Version:    0.7.0.1
 */