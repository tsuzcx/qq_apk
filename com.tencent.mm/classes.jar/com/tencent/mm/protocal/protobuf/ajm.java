package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajm
  extends com.tencent.mm.bv.a
{
  public double wyO;
  public double wyP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28432);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.f(1, this.wyO);
      paramVarArgs.f(2, this.wyP);
      AppMethodBeat.o(28432);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.eW(1);
      int i = e.a.a.b.b.a.eW(2);
      AppMethodBeat.o(28432);
      return paramInt + 8 + 0 + (i + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28432);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ajm localajm = (ajm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28432);
        return -1;
      case 1: 
        localajm.wyO = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(28432);
        return 0;
      }
      localajm.wyP = Double.longBitsToDouble(locala.CLY.emy());
      AppMethodBeat.o(28432);
      return 0;
    }
    AppMethodBeat.o(28432);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajm
 * JD-Core Version:    0.7.0.1
 */