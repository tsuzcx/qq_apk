package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fxo
  extends com.tencent.mm.bx.a
{
  public String YQV;
  public int YQW;
  public int YQX;
  public int YQY;
  public String YRk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258015);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YQV != null) {
        paramVarArgs.g(1, this.YQV);
      }
      paramVarArgs.bS(2, this.YQW);
      paramVarArgs.bS(3, this.YQX);
      paramVarArgs.bS(4, this.YQY);
      if (this.YRk != null) {
        paramVarArgs.g(5, this.YRk);
      }
      AppMethodBeat.o(258015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YQV == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = i.a.a.b.b.a.h(1, this.YQV) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YQW) + i.a.a.b.b.a.cJ(3, this.YQX) + i.a.a.b.b.a.cJ(4, this.YQY);
      paramInt = i;
      if (this.YRk != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YRk);
      }
      AppMethodBeat.o(258015);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258015);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fxo localfxo = (fxo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258015);
          return -1;
        case 1: 
          localfxo.YQV = locala.ajGk.readString();
          AppMethodBeat.o(258015);
          return 0;
        case 2: 
          localfxo.YQW = locala.ajGk.aar();
          AppMethodBeat.o(258015);
          return 0;
        case 3: 
          localfxo.YQX = locala.ajGk.aar();
          AppMethodBeat.o(258015);
          return 0;
        case 4: 
          localfxo.YQY = locala.ajGk.aar();
          AppMethodBeat.o(258015);
          return 0;
        }
        localfxo.YRk = locala.ajGk.readString();
        AppMethodBeat.o(258015);
        return 0;
      }
      AppMethodBeat.o(258015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxo
 * JD-Core Version:    0.7.0.1
 */