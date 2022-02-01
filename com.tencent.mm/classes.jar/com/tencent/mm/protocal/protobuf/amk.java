package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amk
  extends com.tencent.mm.bx.a
{
  public long endTimeMs;
  public long startTimeMs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257637);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.startTimeMs);
      paramVarArgs.bv(2, this.endTimeMs);
      AppMethodBeat.o(257637);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.startTimeMs);
      int i = i.a.a.b.b.a.q(2, this.endTimeMs);
      AppMethodBeat.o(257637);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257637);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      amk localamk = (amk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257637);
        return -1;
      case 1: 
        localamk.startTimeMs = locala.ajGk.aaw();
        AppMethodBeat.o(257637);
        return 0;
      }
      localamk.endTimeMs = locala.ajGk.aaw();
      AppMethodBeat.o(257637);
      return 0;
    }
    AppMethodBeat.o(257637);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amk
 * JD-Core Version:    0.7.0.1
 */