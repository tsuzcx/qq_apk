package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ay
  extends com.tencent.mm.bv.a
{
  public boolean wmV;
  public boolean wmW;
  public int wmX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96189);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.wmV);
      paramVarArgs.aS(2, this.wmW);
      paramVarArgs.aO(3, this.wmX);
      AppMethodBeat.o(96189);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.eW(1);
      int i = e.a.a.b.b.a.eW(2);
      int j = e.a.a.b.b.a.bl(3, this.wmX);
      AppMethodBeat.o(96189);
      return paramInt + 1 + 0 + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(96189);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ay localay = (ay)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(96189);
        return -1;
      case 1: 
        localay.wmV = locala.CLY.emu();
        AppMethodBeat.o(96189);
        return 0;
      case 2: 
        localay.wmW = locala.CLY.emu();
        AppMethodBeat.o(96189);
        return 0;
      }
      localay.wmX = locala.CLY.sl();
      AppMethodBeat.o(96189);
      return 0;
    }
    AppMethodBeat.o(96189);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ay
 * JD-Core Version:    0.7.0.1
 */