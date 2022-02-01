package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class fon
  extends com.tencent.mm.bx.a
{
  public b YXN;
  public int YXO;
  public int abOX;
  public int abOY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91718);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(7, this.abOX);
      if (this.YXN != null) {
        paramVarArgs.d(8, this.YXN);
      }
      paramVarArgs.bS(9, this.YXO);
      paramVarArgs.bS(10, this.abOY);
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(7, this.abOX) + 0;
      paramInt = i;
      if (this.YXN != null) {
        paramInt = i + i.a.a.b.b.a.c(8, this.YXN);
      }
      i = i.a.a.b.b.a.cJ(9, this.YXO);
      int j = i.a.a.b.b.a.cJ(10, this.abOY);
      AppMethodBeat.o(91718);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fon localfon = (fon)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91718);
        return -1;
      case 7: 
        localfon.abOX = locala.ajGk.aar();
        AppMethodBeat.o(91718);
        return 0;
      case 8: 
        localfon.YXN = locala.ajGk.kFX();
        AppMethodBeat.o(91718);
        return 0;
      case 9: 
        localfon.YXO = locala.ajGk.aar();
        AppMethodBeat.o(91718);
        return 0;
      }
      localfon.abOY = locala.ajGk.aar();
      AppMethodBeat.o(91718);
      return 0;
    }
    AppMethodBeat.o(91718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fon
 * JD-Core Version:    0.7.0.1
 */