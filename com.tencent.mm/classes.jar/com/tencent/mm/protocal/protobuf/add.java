package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class add
  extends com.tencent.mm.bv.a
{
  public LinkedList<String> wVp;
  public LinkedList<String> wVq;
  
  public add()
  {
    AppMethodBeat.i(51421);
    this.wVp = new LinkedList();
    this.wVq = new LinkedList();
    AppMethodBeat.o(51421);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51422);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.wVp);
      paramVarArgs.e(2, 1, this.wVq);
      AppMethodBeat.o(51422);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 1, this.wVp);
      int i = e.a.a.a.c(2, 1, this.wVq);
      AppMethodBeat.o(51422);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wVp.clear();
      this.wVq.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(51422);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      add localadd = (add)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(51422);
        return -1;
      case 1: 
        localadd.wVp.add(locala.CLY.readString());
        AppMethodBeat.o(51422);
        return 0;
      }
      localadd.wVq.add(locala.CLY.readString());
      AppMethodBeat.o(51422);
      return 0;
    }
    AppMethodBeat.o(51422);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.add
 * JD-Core Version:    0.7.0.1
 */