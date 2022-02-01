package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amj
  extends com.tencent.mm.bx.a
{
  public float aBi;
  public int centerX;
  public int centerY;
  public float scale;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257604);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.centerX);
      paramVarArgs.bS(2, this.centerY);
      paramVarArgs.l(3, this.scale);
      paramVarArgs.l(4, this.aBi);
      AppMethodBeat.o(257604);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.centerX);
      int i = i.a.a.b.b.a.cJ(2, this.centerY);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(257604);
      return paramInt + 0 + i + (j + 4) + (k + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257604);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      amj localamj = (amj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257604);
        return -1;
      case 1: 
        localamj.centerX = locala.ajGk.aar();
        AppMethodBeat.o(257604);
        return 0;
      case 2: 
        localamj.centerY = locala.ajGk.aar();
        AppMethodBeat.o(257604);
        return 0;
      case 3: 
        localamj.scale = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(257604);
        return 0;
      }
      localamj.aBi = Float.intBitsToFloat(locala.ajGk.aax());
      AppMethodBeat.o(257604);
      return 0;
    }
    AppMethodBeat.o(257604);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amj
 * JD-Core Version:    0.7.0.1
 */