package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dja
  extends com.tencent.mm.bx.a
{
  public String aaNt;
  public int aaOW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260006);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaNt != null) {
        paramVarArgs.g(1, this.aaNt);
      }
      paramVarArgs.bS(2, this.aaOW);
      AppMethodBeat.o(260006);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaNt == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaNt) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aaOW);
      AppMethodBeat.o(260006);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260006);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dja localdja = (dja)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260006);
          return -1;
        case 1: 
          localdja.aaNt = locala.ajGk.readString();
          AppMethodBeat.o(260006);
          return 0;
        }
        localdja.aaOW = locala.ajGk.aar();
        AppMethodBeat.o(260006);
        return 0;
      }
      AppMethodBeat.o(260006);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dja
 * JD-Core Version:    0.7.0.1
 */