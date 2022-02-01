package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class glk
  extends com.tencent.mm.bx.a
{
  public boolean acgV;
  public int acgW;
  public double acgX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50121);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.acgV);
      paramVarArgs.bS(2, this.acgW);
      paramVarArgs.d(3, this.acgX);
      AppMethodBeat.o(50121);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.cJ(2, this.acgW);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(50121);
      return paramInt + 1 + 0 + i + (j + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(50121);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      glk localglk = (glk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50121);
        return -1;
      case 1: 
        localglk.acgV = locala.ajGk.aai();
        AppMethodBeat.o(50121);
        return 0;
      case 2: 
        localglk.acgW = locala.ajGk.aar();
        AppMethodBeat.o(50121);
        return 0;
      }
      localglk.acgX = Double.longBitsToDouble(locala.ajGk.aay());
      AppMethodBeat.o(50121);
      return 0;
    }
    AppMethodBeat.o(50121);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.glk
 * JD-Core Version:    0.7.0.1
 */