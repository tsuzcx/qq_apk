package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mj
  extends com.tencent.mm.bv.a
{
  public int bsY;
  public int wAP;
  public int wAQ;
  public int wAR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(141126);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.bsY);
      paramVarArgs.aO(2, this.wAP);
      paramVarArgs.aO(3, this.wAQ);
      paramVarArgs.aO(4, this.wAR);
      AppMethodBeat.o(141126);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.bsY);
      int i = e.a.a.b.b.a.bl(2, this.wAP);
      int j = e.a.a.b.b.a.bl(3, this.wAQ);
      int k = e.a.a.b.b.a.bl(4, this.wAR);
      AppMethodBeat.o(141126);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(141126);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      mj localmj = (mj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(141126);
        return -1;
      case 1: 
        localmj.bsY = locala.CLY.sl();
        AppMethodBeat.o(141126);
        return 0;
      case 2: 
        localmj.wAP = locala.CLY.sl();
        AppMethodBeat.o(141126);
        return 0;
      case 3: 
        localmj.wAQ = locala.CLY.sl();
        AppMethodBeat.o(141126);
        return 0;
      }
      localmj.wAR = locala.CLY.sl();
      AppMethodBeat.o(141126);
      return 0;
    }
    AppMethodBeat.o(141126);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mj
 * JD-Core Version:    0.7.0.1
 */