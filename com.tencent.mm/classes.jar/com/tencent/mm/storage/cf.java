package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cf
  extends com.tencent.mm.bx.a
{
  public long addTime;
  public long msgId;
  public long rCW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43276);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.msgId);
      paramVarArgs.bv(2, this.rCW);
      paramVarArgs.bv(3, this.addTime);
      AppMethodBeat.o(43276);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.msgId);
      int i = i.a.a.b.b.a.q(2, this.rCW);
      int j = i.a.a.b.b.a.q(3, this.addTime);
      AppMethodBeat.o(43276);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(43276);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cf localcf = (cf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43276);
        return -1;
      case 1: 
        localcf.msgId = locala.ajGk.aaw();
        AppMethodBeat.o(43276);
        return 0;
      case 2: 
        localcf.rCW = locala.ajGk.aaw();
        AppMethodBeat.o(43276);
        return 0;
      }
      localcf.addTime = locala.ajGk.aaw();
      AppMethodBeat.o(43276);
      return 0;
    }
    AppMethodBeat.o(43276);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.cf
 * JD-Core Version:    0.7.0.1
 */