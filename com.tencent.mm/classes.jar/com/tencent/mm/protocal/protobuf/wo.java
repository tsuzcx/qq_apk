package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wo
  extends com.tencent.mm.bx.a
{
  public String ZdA;
  public int Zdy;
  public int Zdz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113972);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zdy);
      paramVarArgs.bS(2, this.Zdz);
      if (this.ZdA != null) {
        paramVarArgs.g(3, this.ZdA);
      }
      AppMethodBeat.o(113972);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Zdy) + 0 + i.a.a.b.b.a.cJ(2, this.Zdz);
      paramInt = i;
      if (this.ZdA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZdA);
      }
      AppMethodBeat.o(113972);
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
      AppMethodBeat.o(113972);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      wo localwo = (wo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113972);
        return -1;
      case 1: 
        localwo.Zdy = locala.ajGk.aar();
        AppMethodBeat.o(113972);
        return 0;
      case 2: 
        localwo.Zdz = locala.ajGk.aar();
        AppMethodBeat.o(113972);
        return 0;
      }
      localwo.ZdA = locala.ajGk.readString();
      AppMethodBeat.o(113972);
      return 0;
    }
    AppMethodBeat.o(113972);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wo
 * JD-Core Version:    0.7.0.1
 */