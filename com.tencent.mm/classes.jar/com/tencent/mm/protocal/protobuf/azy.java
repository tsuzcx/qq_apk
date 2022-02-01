package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azy
  extends com.tencent.mm.bx.a
{
  public double FIb;
  public double FIc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32236);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.FIb);
      paramVarArgs.e(2, this.FIc);
      AppMethodBeat.o(32236);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alT(1);
      int i = f.a.a.b.b.a.alT(2);
      AppMethodBeat.o(32236);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32236);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      azy localazy = (azy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32236);
        return -1;
      case 1: 
        localazy.FIb = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(32236);
        return 0;
      }
      localazy.FIc = Double.longBitsToDouble(locala.NPN.grA());
      AppMethodBeat.o(32236);
      return 0;
    }
    AppMethodBeat.o(32236);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azy
 * JD-Core Version:    0.7.0.1
 */