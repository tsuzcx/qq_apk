package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eo
  extends com.tencent.mm.bx.a
{
  public int YGE;
  public int YGF;
  public String YGG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258925);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YGE);
      paramVarArgs.bS(2, this.YGF);
      if (this.YGG != null) {
        paramVarArgs.g(3, this.YGG);
      }
      AppMethodBeat.o(258925);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YGE) + 0 + i.a.a.b.b.a.cJ(2, this.YGF);
      paramInt = i;
      if (this.YGG != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YGG);
      }
      AppMethodBeat.o(258925);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258925);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eo localeo = (eo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258925);
        return -1;
      case 1: 
        localeo.YGE = locala.ajGk.aar();
        AppMethodBeat.o(258925);
        return 0;
      case 2: 
        localeo.YGF = locala.ajGk.aar();
        AppMethodBeat.o(258925);
        return 0;
      }
      localeo.YGG = locala.ajGk.readString();
      AppMethodBeat.o(258925);
      return 0;
    }
    AppMethodBeat.o(258925);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eo
 * JD-Core Version:    0.7.0.1
 */