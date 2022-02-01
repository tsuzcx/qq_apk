package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class oo
  extends com.tencent.mm.bx.a
{
  public String YRE;
  public int YRF;
  public String YRG;
  public int YRH;
  public int YRI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124415);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRE != null) {
        paramVarArgs.g(1, this.YRE);
      }
      paramVarArgs.bS(2, this.YRF);
      if (this.YRG != null) {
        paramVarArgs.g(3, this.YRG);
      }
      paramVarArgs.bS(4, this.YRH);
      paramVarArgs.bS(5, this.YRI);
      AppMethodBeat.o(124415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YRE == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = i.a.a.b.b.a.h(1, this.YRE) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YRF);
      paramInt = i;
      if (this.YRG != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YRG);
      }
      i = i.a.a.b.b.a.cJ(4, this.YRH);
      int j = i.a.a.b.b.a.cJ(5, this.YRI);
      AppMethodBeat.o(124415);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124415);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        oo localoo = (oo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124415);
          return -1;
        case 1: 
          localoo.YRE = locala.ajGk.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 2: 
          localoo.YRF = locala.ajGk.aar();
          AppMethodBeat.o(124415);
          return 0;
        case 3: 
          localoo.YRG = locala.ajGk.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 4: 
          localoo.YRH = locala.ajGk.aar();
          AppMethodBeat.o(124415);
          return 0;
        }
        localoo.YRI = locala.ajGk.aar();
        AppMethodBeat.o(124415);
        return 0;
      }
      AppMethodBeat.o(124415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oo
 * JD-Core Version:    0.7.0.1
 */