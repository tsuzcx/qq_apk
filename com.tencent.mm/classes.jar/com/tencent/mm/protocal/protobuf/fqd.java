package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class fqd
  extends com.tencent.mm.bx.a
{
  public int abPQ;
  public b abPR;
  public b abPS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257544);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abPQ);
      if (this.abPR != null) {
        paramVarArgs.d(2, this.abPR);
      }
      if (this.abPS != null) {
        paramVarArgs.d(3, this.abPS);
      }
      AppMethodBeat.o(257544);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abPQ) + 0;
      paramInt = i;
      if (this.abPR != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.abPR);
      }
      i = paramInt;
      if (this.abPS != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.abPS);
      }
      AppMethodBeat.o(257544);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257544);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fqd localfqd = (fqd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257544);
        return -1;
      case 1: 
        localfqd.abPQ = locala.ajGk.aar();
        AppMethodBeat.o(257544);
        return 0;
      case 2: 
        localfqd.abPR = locala.ajGk.kFX();
        AppMethodBeat.o(257544);
        return 0;
      }
      localfqd.abPS = locala.ajGk.kFX();
      AppMethodBeat.o(257544);
      return 0;
    }
    AppMethodBeat.o(257544);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqd
 * JD-Core Version:    0.7.0.1
 */