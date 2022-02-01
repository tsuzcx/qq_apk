package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yo
  extends com.tencent.mm.bx.a
{
  public double x;
  public double y;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118409);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.x);
      paramVarArgs.e(2, this.y);
      AppMethodBeat.o(118409);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(1);
      int i = f.a.a.b.b.a.fY(2);
      AppMethodBeat.o(118409);
      return paramInt + 8 + 0 + (i + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(118409);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      yo localyo = (yo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118409);
        return -1;
      case 1: 
        localyo.x = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(118409);
        return 0;
      }
      localyo.y = Double.longBitsToDouble(locala.KhF.fHy());
      AppMethodBeat.o(118409);
      return 0;
    }
    AppMethodBeat.o(118409);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yo
 * JD-Core Version:    0.7.0.1
 */