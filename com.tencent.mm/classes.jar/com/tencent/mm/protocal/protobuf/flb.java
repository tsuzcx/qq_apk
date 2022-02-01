package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class flb
  extends com.tencent.mm.bx.a
{
  public String IcT;
  public String aaLU;
  public int abLC;
  public int abLD;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153306);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaLU != null) {
        paramVarArgs.g(1, this.aaLU);
      }
      paramVarArgs.bS(2, this.abLC);
      paramVarArgs.bS(3, this.abLD);
      if (this.IcT != null) {
        paramVarArgs.g(4, this.IcT);
      }
      if (this.oOI != null) {
        paramVarArgs.g(5, this.oOI);
      }
      AppMethodBeat.o(153306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaLU == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaLU) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abLC) + i.a.a.b.b.a.cJ(3, this.abLD);
      paramInt = i;
      if (this.IcT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IcT);
      }
      i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.oOI);
      }
      AppMethodBeat.o(153306);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153306);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        flb localflb = (flb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153306);
          return -1;
        case 1: 
          localflb.aaLU = locala.ajGk.readString();
          AppMethodBeat.o(153306);
          return 0;
        case 2: 
          localflb.abLC = locala.ajGk.aar();
          AppMethodBeat.o(153306);
          return 0;
        case 3: 
          localflb.abLD = locala.ajGk.aar();
          AppMethodBeat.o(153306);
          return 0;
        case 4: 
          localflb.IcT = locala.ajGk.readString();
          AppMethodBeat.o(153306);
          return 0;
        }
        localflb.oOI = locala.ajGk.readString();
        AppMethodBeat.o(153306);
        return 0;
      }
      AppMethodBeat.o(153306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flb
 * JD-Core Version:    0.7.0.1
 */