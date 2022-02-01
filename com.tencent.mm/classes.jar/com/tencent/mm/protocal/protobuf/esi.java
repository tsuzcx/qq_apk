package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class esi
  extends com.tencent.mm.bx.a
{
  public String abvW;
  public int abvX;
  public int abvY;
  public int interval;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91673);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abvW != null) {
        paramVarArgs.g(1, this.abvW);
      }
      paramVarArgs.bS(2, this.interval);
      paramVarArgs.bS(3, this.abvX);
      paramVarArgs.bS(4, this.abvY);
      AppMethodBeat.o(91673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abvW == null) {
        break label346;
      }
    }
    label346:
    for (paramInt = i.a.a.b.b.a.h(1, this.abvW) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.interval);
      int j = i.a.a.b.b.a.cJ(3, this.abvX);
      int k = i.a.a.b.b.a.cJ(4, this.abvY);
      AppMethodBeat.o(91673);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91673);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        esi localesi = (esi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91673);
          return -1;
        case 1: 
          localesi.abvW = locala.ajGk.readString();
          AppMethodBeat.o(91673);
          return 0;
        case 2: 
          localesi.interval = locala.ajGk.aar();
          AppMethodBeat.o(91673);
          return 0;
        case 3: 
          localesi.abvX = locala.ajGk.aar();
          AppMethodBeat.o(91673);
          return 0;
        }
        localesi.abvY = locala.ajGk.aar();
        AppMethodBeat.o(91673);
        return 0;
      }
      AppMethodBeat.o(91673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esi
 * JD-Core Version:    0.7.0.1
 */