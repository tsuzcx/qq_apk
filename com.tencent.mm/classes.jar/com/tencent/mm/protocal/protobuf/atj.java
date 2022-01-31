package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class atj
  extends com.tencent.mm.bv.a
{
  public int xiC;
  public int xiD;
  public boolean xiE;
  public boolean xiF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134433);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xiC);
      paramVarArgs.aO(2, this.xiD);
      paramVarArgs.aS(3, this.xiE);
      paramVarArgs.aS(4, this.xiF);
      AppMethodBeat.o(134433);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xiC);
      int i = e.a.a.b.b.a.bl(2, this.xiD);
      int j = e.a.a.b.b.a.eW(3);
      int k = e.a.a.b.b.a.eW(4);
      AppMethodBeat.o(134433);
      return paramInt + 0 + i + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(134433);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      atj localatj = (atj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(134433);
        return -1;
      case 1: 
        localatj.xiC = locala.CLY.sl();
        AppMethodBeat.o(134433);
        return 0;
      case 2: 
        localatj.xiD = locala.CLY.sl();
        AppMethodBeat.o(134433);
        return 0;
      case 3: 
        localatj.xiE = locala.CLY.emu();
        AppMethodBeat.o(134433);
        return 0;
      }
      localatj.xiF = locala.CLY.emu();
      AppMethodBeat.o(134433);
      return 0;
    }
    AppMethodBeat.o(134433);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atj
 * JD-Core Version:    0.7.0.1
 */