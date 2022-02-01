package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amh
  extends com.tencent.mm.bx.a
{
  public long axI;
  public long start;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257569);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.start);
      paramVarArgs.bv(2, this.axI);
      AppMethodBeat.o(257569);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.start);
      int i = i.a.a.b.b.a.q(2, this.axI);
      AppMethodBeat.o(257569);
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
      AppMethodBeat.o(257569);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      amh localamh = (amh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257569);
        return -1;
      case 1: 
        localamh.start = locala.ajGk.aaw();
        AppMethodBeat.o(257569);
        return 0;
      }
      localamh.axI = locala.ajGk.aaw();
      AppMethodBeat.o(257569);
      return 0;
    }
    AppMethodBeat.o(257569);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amh
 * JD-Core Version:    0.7.0.1
 */