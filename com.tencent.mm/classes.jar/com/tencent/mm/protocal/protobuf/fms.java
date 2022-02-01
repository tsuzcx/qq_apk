package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fms
  extends com.tencent.mm.bx.a
{
  public String abMV;
  public String abMW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258612);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abMV != null) {
        paramVarArgs.g(1, this.abMV);
      }
      if (this.abMW != null) {
        paramVarArgs.g(2, this.abMW);
      }
      AppMethodBeat.o(258612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abMV == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.abMV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abMW != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abMW);
      }
      AppMethodBeat.o(258612);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258612);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fms localfms = (fms)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258612);
          return -1;
        case 1: 
          localfms.abMV = locala.ajGk.readString();
          AppMethodBeat.o(258612);
          return 0;
        }
        localfms.abMW = locala.ajGk.readString();
        AppMethodBeat.o(258612);
        return 0;
      }
      AppMethodBeat.o(258612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fms
 * JD-Core Version:    0.7.0.1
 */