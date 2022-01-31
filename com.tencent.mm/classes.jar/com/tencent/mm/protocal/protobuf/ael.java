package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ael
  extends com.tencent.mm.bv.a
{
  public boolean wXo;
  public boolean wXp;
  public boolean wXq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(2541);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.wXo);
      paramVarArgs.aS(2, this.wXp);
      paramVarArgs.aS(3, this.wXq);
      AppMethodBeat.o(2541);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.eW(1);
      int i = e.a.a.b.b.a.eW(2);
      int j = e.a.a.b.b.a.eW(3);
      AppMethodBeat.o(2541);
      return paramInt + 1 + 0 + (i + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(2541);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ael localael = (ael)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(2541);
        return -1;
      case 1: 
        localael.wXo = locala.CLY.emu();
        AppMethodBeat.o(2541);
        return 0;
      case 2: 
        localael.wXp = locala.CLY.emu();
        AppMethodBeat.o(2541);
        return 0;
      }
      localael.wXq = locala.CLY.emu();
      AppMethodBeat.o(2541);
      return 0;
    }
    AppMethodBeat.o(2541);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ael
 * JD-Core Version:    0.7.0.1
 */