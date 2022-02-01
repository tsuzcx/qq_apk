package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agl
  extends com.tencent.mm.bx.a
{
  public double x;
  public double y;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118409);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, this.x);
      paramVarArgs.d(2, this.y);
      AppMethodBeat.o(118409);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(118409);
      return paramInt + 8 + 0 + (i + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(118409);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      agl localagl = (agl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118409);
        return -1;
      case 1: 
        localagl.x = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(118409);
        return 0;
      }
      localagl.y = Double.longBitsToDouble(locala.ajGk.aay());
      AppMethodBeat.o(118409);
      return 0;
    }
    AppMethodBeat.o(118409);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agl
 * JD-Core Version:    0.7.0.1
 */