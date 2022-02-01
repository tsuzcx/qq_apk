package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyq
  extends com.tencent.mm.bx.a
{
  public String IcK;
  public int YHq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125753);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YHq);
      if (this.IcK != null) {
        paramVarArgs.g(2, this.IcK);
      }
      AppMethodBeat.o(125753);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YHq) + 0;
      paramInt = i;
      if (this.IcK != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IcK);
      }
      AppMethodBeat.o(125753);
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
      AppMethodBeat.o(125753);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dyq localdyq = (dyq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125753);
        return -1;
      case 1: 
        localdyq.YHq = locala.ajGk.aar();
        AppMethodBeat.o(125753);
        return 0;
      }
      localdyq.IcK = locala.ajGk.readString();
      AppMethodBeat.o(125753);
      return 0;
    }
    AppMethodBeat.o(125753);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyq
 * JD-Core Version:    0.7.0.1
 */