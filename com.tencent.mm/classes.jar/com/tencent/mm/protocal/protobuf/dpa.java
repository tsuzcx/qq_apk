package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpa
  extends com.tencent.mm.bx.a
{
  public int OzH;
  public String YFk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138183);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFk != null) {
        paramVarArgs.g(1, this.YFk);
      }
      paramVarArgs.bS(2, this.OzH);
      AppMethodBeat.o(138183);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YFk == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.YFk) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.OzH);
      AppMethodBeat.o(138183);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(138183);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dpa localdpa = (dpa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138183);
          return -1;
        case 1: 
          localdpa.YFk = locala.ajGk.readString();
          AppMethodBeat.o(138183);
          return 0;
        }
        localdpa.OzH = locala.ajGk.aar();
        AppMethodBeat.o(138183);
        return 0;
      }
      AppMethodBeat.o(138183);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpa
 * JD-Core Version:    0.7.0.1
 */