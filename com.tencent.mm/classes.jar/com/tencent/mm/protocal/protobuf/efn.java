package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efn
  extends com.tencent.mm.bx.a
{
  public double YTc;
  public double YTd;
  public double abkT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56258);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, this.YTd);
      paramVarArgs.d(2, this.YTc);
      paramVarArgs.d(3, this.abkT);
      AppMethodBeat.o(56258);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(56258);
      return paramInt + 8 + 0 + (i + 8) + (j + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(56258);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      efn localefn = (efn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56258);
        return -1;
      case 1: 
        localefn.YTd = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(56258);
        return 0;
      case 2: 
        localefn.YTc = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(56258);
        return 0;
      }
      localefn.abkT = Double.longBitsToDouble(locala.ajGk.aay());
      AppMethodBeat.o(56258);
      return 0;
    }
    AppMethodBeat.o(56258);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efn
 * JD-Core Version:    0.7.0.1
 */