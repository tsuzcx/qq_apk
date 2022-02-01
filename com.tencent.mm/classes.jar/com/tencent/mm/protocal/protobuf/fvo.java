package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fvo
  extends com.tencent.mm.bx.a
{
  public int ZVE;
  public int abTI;
  public int abTJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258633);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abTI);
      paramVarArgs.bS(2, this.abTJ);
      paramVarArgs.bS(3, this.ZVE);
      AppMethodBeat.o(258633);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abTI);
      int i = i.a.a.b.b.a.cJ(2, this.abTJ);
      int j = i.a.a.b.b.a.cJ(3, this.ZVE);
      AppMethodBeat.o(258633);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258633);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fvo localfvo = (fvo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258633);
        return -1;
      case 1: 
        localfvo.abTI = locala.ajGk.aar();
        AppMethodBeat.o(258633);
        return 0;
      case 2: 
        localfvo.abTJ = locala.ajGk.aar();
        AppMethodBeat.o(258633);
        return 0;
      }
      localfvo.ZVE = locala.ajGk.aar();
      AppMethodBeat.o(258633);
      return 0;
    }
    AppMethodBeat.o(258633);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvo
 * JD-Core Version:    0.7.0.1
 */