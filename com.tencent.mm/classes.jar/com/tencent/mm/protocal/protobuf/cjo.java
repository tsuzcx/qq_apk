package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjo
  extends com.tencent.mm.bx.a
{
  public int DYI;
  public int EeI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117899);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EeI);
      paramVarArgs.aR(2, this.DYI);
      AppMethodBeat.o(117899);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.EeI);
      int i = f.a.a.b.b.a.bA(2, this.DYI);
      AppMethodBeat.o(117899);
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
      AppMethodBeat.o(117899);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cjo localcjo = (cjo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117899);
        return -1;
      case 1: 
        localcjo.EeI = locala.KhF.xS();
        AppMethodBeat.o(117899);
        return 0;
      }
      localcjo.DYI = locala.KhF.xS();
      AppMethodBeat.o(117899);
      return 0;
    }
    AppMethodBeat.o(117899);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjo
 * JD-Core Version:    0.7.0.1
 */