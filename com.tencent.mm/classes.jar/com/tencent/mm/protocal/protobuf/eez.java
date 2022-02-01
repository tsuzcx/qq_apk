package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eez
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public int vgN;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259733);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGU != null) {
        paramVarArgs.g(1, this.IGU);
      }
      paramVarArgs.bS(2, this.vgN);
      paramVarArgs.bS(3, this.vhJ);
      AppMethodBeat.o(259733);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGU == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.IGU) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vgN);
      int j = i.a.a.b.b.a.cJ(3, this.vhJ);
      AppMethodBeat.o(259733);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259733);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eez localeez = (eez)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259733);
          return -1;
        case 1: 
          localeez.IGU = locala.ajGk.readString();
          AppMethodBeat.o(259733);
          return 0;
        case 2: 
          localeez.vgN = locala.ajGk.aar();
          AppMethodBeat.o(259733);
          return 0;
        }
        localeez.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(259733);
        return 0;
      }
      AppMethodBeat.o(259733);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eez
 * JD-Core Version:    0.7.0.1
 */