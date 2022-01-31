package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dan
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public int wwX;
  public int xmQ;
  public int xqL;
  public int xqM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143700);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xmQ);
      paramVarArgs.aO(2, this.wwX);
      paramVarArgs.aO(3, this.Scene);
      paramVarArgs.aO(5, this.xqM);
      paramVarArgs.aO(6, this.xqL);
      AppMethodBeat.o(143700);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xmQ);
      int i = e.a.a.b.b.a.bl(2, this.wwX);
      int j = e.a.a.b.b.a.bl(3, this.Scene);
      int k = e.a.a.b.b.a.bl(5, this.xqM);
      int m = e.a.a.b.b.a.bl(6, this.xqL);
      AppMethodBeat.o(143700);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(143700);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dan localdan = (dan)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      default: 
        AppMethodBeat.o(143700);
        return -1;
      case 1: 
        localdan.xmQ = locala.CLY.sl();
        AppMethodBeat.o(143700);
        return 0;
      case 2: 
        localdan.wwX = locala.CLY.sl();
        AppMethodBeat.o(143700);
        return 0;
      case 3: 
        localdan.Scene = locala.CLY.sl();
        AppMethodBeat.o(143700);
        return 0;
      case 5: 
        localdan.xqM = locala.CLY.sl();
        AppMethodBeat.o(143700);
        return 0;
      }
      localdan.xqL = locala.CLY.sl();
      AppMethodBeat.o(143700);
      return 0;
    }
    AppMethodBeat.o(143700);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dan
 * JD-Core Version:    0.7.0.1
 */