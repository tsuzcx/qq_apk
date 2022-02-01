package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uj
  extends com.tencent.mm.bx.a
{
  public String YZU;
  public String hVW;
  public String hWO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72426);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YZU != null) {
        paramVarArgs.g(1, this.YZU);
      }
      if (this.hVW != null) {
        paramVarArgs.g(2, this.hVW);
      }
      if (this.hWO != null) {
        paramVarArgs.g(3, this.hWO);
      }
      AppMethodBeat.o(72426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YZU == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.YZU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hVW != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hVW);
      }
      i = paramInt;
      if (this.hWO != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hWO);
      }
      AppMethodBeat.o(72426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72426);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        uj localuj = (uj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72426);
          return -1;
        case 1: 
          localuj.YZU = locala.ajGk.readString();
          AppMethodBeat.o(72426);
          return 0;
        case 2: 
          localuj.hVW = locala.ajGk.readString();
          AppMethodBeat.o(72426);
          return 0;
        }
        localuj.hWO = locala.ajGk.readString();
        AppMethodBeat.o(72426);
        return 0;
      }
      AppMethodBeat.o(72426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uj
 * JD-Core Version:    0.7.0.1
 */