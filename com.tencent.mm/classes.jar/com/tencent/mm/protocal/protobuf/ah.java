package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah
  extends com.tencent.mm.bx.a
{
  public int CtN;
  public int CtO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143962);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CtN);
      paramVarArgs.aR(2, this.CtO);
      AppMethodBeat.o(143962);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.CtN);
      int i = f.a.a.b.b.a.bA(2, this.CtO);
      AppMethodBeat.o(143962);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(143962);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ah localah = (ah)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143962);
        return -1;
      case 1: 
        localah.CtN = locala.KhF.xS();
        AppMethodBeat.o(143962);
        return 0;
      }
      localah.CtO = locala.KhF.xS();
      AppMethodBeat.o(143962);
      return 0;
    }
    AppMethodBeat.o(143962);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ah
 * JD-Core Version:    0.7.0.1
 */