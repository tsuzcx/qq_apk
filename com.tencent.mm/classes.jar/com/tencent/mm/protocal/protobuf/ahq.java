package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahq
  extends com.tencent.mm.bw.a
{
  public int GuP;
  public int priority;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153144);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GuP);
      paramVarArgs.aS(2, this.priority);
      AppMethodBeat.o(153144);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GuP);
      int i = f.a.a.b.b.a.bz(2, this.priority);
      AppMethodBeat.o(153144);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(153144);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahq localahq = (ahq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153144);
        return -1;
      case 1: 
        localahq.GuP = locala.OmT.zc();
        AppMethodBeat.o(153144);
        return 0;
      }
      localahq.priority = locala.OmT.zc();
      AppMethodBeat.o(153144);
      return 0;
    }
    AppMethodBeat.o(153144);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahq
 * JD-Core Version:    0.7.0.1
 */