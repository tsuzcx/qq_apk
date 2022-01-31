package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adk
  extends com.tencent.mm.bv.a
{
  public long endTime = 0L;
  public long startTime = 0L;
  public int wWw = 0;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73649);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.startTime);
      paramVarArgs.am(2, this.endTime);
      paramVarArgs.aO(3, this.wWw);
      AppMethodBeat.o(73649);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.startTime);
      int i = e.a.a.b.b.a.p(2, this.endTime);
      int j = e.a.a.b.b.a.bl(3, this.wWw);
      AppMethodBeat.o(73649);
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
      AppMethodBeat.o(73649);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      adk localadk = (adk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(73649);
        return -1;
      case 1: 
        localadk.startTime = locala.CLY.sm();
        AppMethodBeat.o(73649);
        return 0;
      case 2: 
        localadk.endTime = locala.CLY.sm();
        AppMethodBeat.o(73649);
        return 0;
      }
      localadk.wWw = locala.CLY.sl();
      AppMethodBeat.o(73649);
      return 0;
    }
    AppMethodBeat.o(73649);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adk
 * JD-Core Version:    0.7.0.1
 */