package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class no
  extends com.tencent.mm.bx.a
{
  public int YPD;
  public String mdG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258585);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.mdG != null) {
        paramVarArgs.g(1, this.mdG);
      }
      paramVarArgs.bS(2, this.YPD);
      AppMethodBeat.o(258585);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mdG == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.mdG) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.YPD);
      AppMethodBeat.o(258585);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258585);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        no localno = (no)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258585);
          return -1;
        case 1: 
          localno.mdG = locala.ajGk.readString();
          AppMethodBeat.o(258585);
          return 0;
        }
        localno.YPD = locala.ajGk.aar();
        AppMethodBeat.o(258585);
        return 0;
      }
      AppMethodBeat.o(258585);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.no
 * JD-Core Version:    0.7.0.1
 */