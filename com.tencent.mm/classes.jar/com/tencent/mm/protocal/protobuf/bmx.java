package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmx
  extends com.tencent.mm.bv.a
{
  public double wyO;
  public double wyP;
  public double xBh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113788);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.f(1, this.wyP);
      paramVarArgs.f(2, this.wyO);
      paramVarArgs.f(3, this.xBh);
      AppMethodBeat.o(113788);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.eW(1);
      int i = e.a.a.b.b.a.eW(2);
      int j = e.a.a.b.b.a.eW(3);
      AppMethodBeat.o(113788);
      return paramInt + 8 + 0 + (i + 8) + (j + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(113788);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bmx localbmx = (bmx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113788);
        return -1;
      case 1: 
        localbmx.wyP = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(113788);
        return 0;
      case 2: 
        localbmx.wyO = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(113788);
        return 0;
      }
      localbmx.xBh = Double.longBitsToDouble(locala.CLY.emy());
      AppMethodBeat.o(113788);
      return 0;
    }
    AppMethodBeat.o(113788);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmx
 * JD-Core Version:    0.7.0.1
 */