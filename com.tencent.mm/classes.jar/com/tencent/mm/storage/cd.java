package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cd
  extends com.tencent.mm.bw.a
{
  public long addTime;
  public long lDC;
  public long msgId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43276);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.msgId);
      paramVarArgs.bb(2, this.lDC);
      paramVarArgs.bb(3, this.addTime);
      AppMethodBeat.o(43276);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.msgId);
      int i = g.a.a.b.b.a.r(2, this.lDC);
      int j = g.a.a.b.b.a.r(3, this.addTime);
      AppMethodBeat.o(43276);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(43276);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cd localcd = (cd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43276);
        return -1;
      case 1: 
        localcd.msgId = locala.UbS.zl();
        AppMethodBeat.o(43276);
        return 0;
      case 2: 
        localcd.lDC = locala.UbS.zl();
        AppMethodBeat.o(43276);
        return 0;
      }
      localcd.addTime = locala.UbS.zl();
      AppMethodBeat.o(43276);
      return 0;
    }
    AppMethodBeat.o(43276);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.cd
 * JD-Core Version:    0.7.0.1
 */