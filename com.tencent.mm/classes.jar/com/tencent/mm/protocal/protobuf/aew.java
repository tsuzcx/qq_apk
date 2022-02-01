package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class aew
  extends com.tencent.mm.bx.a
{
  public b vgA;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260256);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      if (this.vgA != null) {
        paramVarArgs.d(2, this.vgA);
      }
      AppMethodBeat.o(260256);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0;
      paramInt = i;
      if (this.vgA != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.vgA);
      }
      AppMethodBeat.o(260256);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260256);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aew localaew = (aew)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260256);
        return -1;
      case 1: 
        localaew.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(260256);
        return 0;
      }
      localaew.vgA = locala.ajGk.kFX();
      AppMethodBeat.o(260256);
      return 0;
    }
    AppMethodBeat.o(260256);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aew
 * JD-Core Version:    0.7.0.1
 */