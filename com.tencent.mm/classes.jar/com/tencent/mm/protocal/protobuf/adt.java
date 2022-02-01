package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adt
  extends com.tencent.mm.bw.a
{
  public double x;
  public double y;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118409);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.x);
      paramVarArgs.e(2, this.y);
      AppMethodBeat.o(118409);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      AppMethodBeat.o(118409);
      return paramInt + 8 + 0 + (i + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(118409);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      adt localadt = (adt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118409);
        return -1;
      case 1: 
        localadt.x = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(118409);
        return 0;
      }
      localadt.y = Double.longBitsToDouble(locala.UbS.zn());
      AppMethodBeat.o(118409);
      return 0;
    }
    AppMethodBeat.o(118409);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adt
 * JD-Core Version:    0.7.0.1
 */