package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkc
  extends com.tencent.mm.bv.a
{
  public int xyB;
  public int xyC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96280);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xyB);
      paramVarArgs.aO(2, this.xyC);
      AppMethodBeat.o(96280);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xyB);
      int i = e.a.a.b.b.a.bl(2, this.xyC);
      AppMethodBeat.o(96280);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(96280);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bkc localbkc = (bkc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(96280);
        return -1;
      case 1: 
        localbkc.xyB = locala.CLY.sl();
        AppMethodBeat.o(96280);
        return 0;
      }
      localbkc.xyC = locala.CLY.sl();
      AppMethodBeat.o(96280);
      return 0;
    }
    AppMethodBeat.o(96280);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkc
 * JD-Core Version:    0.7.0.1
 */