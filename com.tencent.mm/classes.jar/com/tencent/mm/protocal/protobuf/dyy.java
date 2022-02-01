package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyy
  extends com.tencent.mm.bx.a
{
  public int abdO;
  public int abdP;
  public String iaI;
  public String wum;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114046);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.iaI != null) {
        paramVarArgs.g(1, this.iaI);
      }
      if (this.wum != null) {
        paramVarArgs.g(2, this.wum);
      }
      paramVarArgs.bS(3, this.abdO);
      paramVarArgs.bS(4, this.abdP);
      AppMethodBeat.o(114046);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iaI == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = i.a.a.b.b.a.h(1, this.iaI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wum != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.wum);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abdO);
      int j = i.a.a.b.b.a.cJ(4, this.abdP);
      AppMethodBeat.o(114046);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114046);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dyy localdyy = (dyy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114046);
          return -1;
        case 1: 
          localdyy.iaI = locala.ajGk.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 2: 
          localdyy.wum = locala.ajGk.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 3: 
          localdyy.abdO = locala.ajGk.aar();
          AppMethodBeat.o(114046);
          return 0;
        }
        localdyy.abdP = locala.ajGk.aar();
        AppMethodBeat.o(114046);
        return 0;
      }
      AppMethodBeat.o(114046);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyy
 * JD-Core Version:    0.7.0.1
 */