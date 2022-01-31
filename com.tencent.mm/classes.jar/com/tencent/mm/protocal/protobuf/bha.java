package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bha
  extends com.tencent.mm.bv.a
{
  public int nox;
  public String wyW;
  public int xwe;
  public int xwf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14733);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wyW != null) {
        paramVarArgs.e(1, this.wyW);
      }
      paramVarArgs.aO(2, this.xwe);
      paramVarArgs.aO(3, this.nox);
      paramVarArgs.aO(4, this.xwf);
      AppMethodBeat.o(14733);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wyW == null) {
        break label360;
      }
    }
    label360:
    for (paramInt = e.a.a.b.b.a.f(1, this.wyW) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xwe);
      int j = e.a.a.b.b.a.bl(3, this.nox);
      int k = e.a.a.b.b.a.bl(4, this.xwf);
      AppMethodBeat.o(14733);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14733);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bha localbha = (bha)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(14733);
          return -1;
        case 1: 
          localbha.wyW = locala.CLY.readString();
          AppMethodBeat.o(14733);
          return 0;
        case 2: 
          localbha.xwe = locala.CLY.sl();
          AppMethodBeat.o(14733);
          return 0;
        case 3: 
          localbha.nox = locala.CLY.sl();
          AppMethodBeat.o(14733);
          return 0;
        }
        localbha.xwf = locala.CLY.sl();
        AppMethodBeat.o(14733);
        return 0;
      }
      AppMethodBeat.o(14733);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bha
 * JD-Core Version:    0.7.0.1
 */