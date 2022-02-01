package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gjr
  extends com.tencent.mm.bx.a
{
  public String YPU;
  public String YPV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258228);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YPV != null) {
        paramVarArgs.g(1, this.YPV);
      }
      if (this.YPU != null) {
        paramVarArgs.g(2, this.YPU);
      }
      AppMethodBeat.o(258228);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YPV == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.YPV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YPU != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YPU);
      }
      AppMethodBeat.o(258228);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258228);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gjr localgjr = (gjr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258228);
          return -1;
        case 1: 
          localgjr.YPV = locala.ajGk.readString();
          AppMethodBeat.o(258228);
          return 0;
        }
        localgjr.YPU = locala.ajGk.readString();
        AppMethodBeat.o(258228);
        return 0;
      }
      AppMethodBeat.o(258228);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjr
 * JD-Core Version:    0.7.0.1
 */