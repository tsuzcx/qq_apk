package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dra
  extends com.tencent.mm.bx.a
{
  public int aaBP;
  public String aazm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123629);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aazm != null) {
        paramVarArgs.g(1, this.aazm);
      }
      paramVarArgs.bS(2, this.aaBP);
      AppMethodBeat.o(123629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aazm == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.aazm) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aaBP);
      AppMethodBeat.o(123629);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123629);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dra localdra = (dra)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123629);
          return -1;
        case 1: 
          localdra.aazm = locala.ajGk.readString();
          AppMethodBeat.o(123629);
          return 0;
        }
        localdra.aaBP = locala.ajGk.aar();
        AppMethodBeat.o(123629);
        return 0;
      }
      AppMethodBeat.o(123629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dra
 * JD-Core Version:    0.7.0.1
 */