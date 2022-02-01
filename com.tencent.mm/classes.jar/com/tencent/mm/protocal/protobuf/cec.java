package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cec
  extends com.tencent.mm.bx.a
{
  public int YGX;
  public int aaoo;
  public String oOI;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123572);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oOI != null) {
        paramVarArgs.g(1, this.oOI);
      }
      paramVarArgs.bS(2, this.vhJ);
      paramVarArgs.bS(3, this.YGX);
      paramVarArgs.bS(4, this.aaoo);
      AppMethodBeat.o(123572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oOI == null) {
        break label346;
      }
    }
    label346:
    for (paramInt = i.a.a.b.b.a.h(1, this.oOI) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vhJ);
      int j = i.a.a.b.b.a.cJ(3, this.YGX);
      int k = i.a.a.b.b.a.cJ(4, this.aaoo);
      AppMethodBeat.o(123572);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123572);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cec localcec = (cec)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123572);
          return -1;
        case 1: 
          localcec.oOI = locala.ajGk.readString();
          AppMethodBeat.o(123572);
          return 0;
        case 2: 
          localcec.vhJ = locala.ajGk.aar();
          AppMethodBeat.o(123572);
          return 0;
        case 3: 
          localcec.YGX = locala.ajGk.aar();
          AppMethodBeat.o(123572);
          return 0;
        }
        localcec.aaoo = locala.ajGk.aar();
        AppMethodBeat.o(123572);
        return 0;
      }
      AppMethodBeat.o(123572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cec
 * JD-Core Version:    0.7.0.1
 */