package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxi
  extends com.tencent.mm.bv.a
{
  public LinkedList<Integer> yeQ;
  public boolean yeR;
  
  public cxi()
  {
    AppMethodBeat.i(28744);
    this.yeQ = new LinkedList();
    AppMethodBeat.o(28744);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28745);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 2, this.yeQ);
      paramVarArgs.aS(2, this.yeR);
      AppMethodBeat.o(28745);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 2, this.yeQ);
      int i = e.a.a.b.b.a.eW(2);
      AppMethodBeat.o(28745);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.yeQ.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28745);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cxi localcxi = (cxi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28745);
        return -1;
      case 1: 
        localcxi.yeQ.add(Integer.valueOf(locala.CLY.sl()));
        AppMethodBeat.o(28745);
        return 0;
      }
      localcxi.yeR = locala.CLY.emu();
      AppMethodBeat.o(28745);
      return 0;
    }
    AppMethodBeat.o(28745);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxi
 * JD-Core Version:    0.7.0.1
 */