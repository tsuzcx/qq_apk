package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aij
  extends com.tencent.mm.bx.a
{
  public int Dla;
  public int Dlb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168955);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dla);
      paramVarArgs.aR(2, this.Dlb);
      AppMethodBeat.o(168955);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.Dla);
      int i = f.a.a.b.b.a.bA(2, this.Dlb);
      AppMethodBeat.o(168955);
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
      AppMethodBeat.o(168955);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aij localaij = (aij)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168955);
        return -1;
      case 1: 
        localaij.Dla = locala.KhF.xS();
        AppMethodBeat.o(168955);
        return 0;
      }
      localaij.Dlb = locala.KhF.xS();
      AppMethodBeat.o(168955);
      return 0;
    }
    AppMethodBeat.o(168955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aij
 * JD-Core Version:    0.7.0.1
 */