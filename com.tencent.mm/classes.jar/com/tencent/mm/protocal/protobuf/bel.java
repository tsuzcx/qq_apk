package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bel
  extends com.tencent.mm.bv.a
{
  public String xtI;
  public int xtX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60050);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xtI != null) {
        paramVarArgs.e(1, this.xtI);
      }
      paramVarArgs.aO(2, this.xtX);
      AppMethodBeat.o(60050);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xtI == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = e.a.a.b.b.a.f(1, this.xtI) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xtX);
      AppMethodBeat.o(60050);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(60050);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bel localbel = (bel)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(60050);
          return -1;
        case 1: 
          localbel.xtI = locala.CLY.readString();
          AppMethodBeat.o(60050);
          return 0;
        }
        localbel.xtX = locala.CLY.sl();
        AppMethodBeat.o(60050);
        return 0;
      }
      AppMethodBeat.o(60050);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bel
 * JD-Core Version:    0.7.0.1
 */