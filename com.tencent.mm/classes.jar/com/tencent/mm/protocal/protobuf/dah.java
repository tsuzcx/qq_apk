package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dah
  extends com.tencent.mm.bv.a
{
  public int woF;
  public int xqO;
  public int ygN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96340);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xqO);
      paramVarArgs.aO(2, this.woF);
      paramVarArgs.aO(3, this.ygN);
      AppMethodBeat.o(96340);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xqO);
      int i = e.a.a.b.b.a.bl(2, this.woF);
      int j = e.a.a.b.b.a.bl(3, this.ygN);
      AppMethodBeat.o(96340);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(96340);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dah localdah = (dah)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(96340);
        return -1;
      case 1: 
        localdah.xqO = locala.CLY.sl();
        AppMethodBeat.o(96340);
        return 0;
      case 2: 
        localdah.woF = locala.CLY.sl();
        AppMethodBeat.o(96340);
        return 0;
      }
      localdah.ygN = locala.CLY.sl();
      AppMethodBeat.o(96340);
      return 0;
    }
    AppMethodBeat.o(96340);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dah
 * JD-Core Version:    0.7.0.1
 */