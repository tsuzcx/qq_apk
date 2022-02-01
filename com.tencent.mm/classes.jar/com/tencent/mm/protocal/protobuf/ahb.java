package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahb
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> DiQ;
  public LinkedList<String> DiR;
  
  public ahb()
  {
    AppMethodBeat.i(127490);
    this.DiQ = new LinkedList();
    this.DiR = new LinkedList();
    AppMethodBeat.o(127490);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.DiQ);
      paramVarArgs.e(2, 1, this.DiR);
      AppMethodBeat.o(127491);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.DiQ);
      int i = f.a.a.a.c(2, 1, this.DiR);
      AppMethodBeat.o(127491);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DiQ.clear();
      this.DiR.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(127491);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahb localahb = (ahb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127491);
        return -1;
      case 1: 
        localahb.DiQ.add(locala.KhF.readString());
        AppMethodBeat.o(127491);
        return 0;
      }
      localahb.DiR.add(locala.KhF.readString());
      AppMethodBeat.o(127491);
      return 0;
    }
    AppMethodBeat.o(127491);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahb
 * JD-Core Version:    0.7.0.1
 */