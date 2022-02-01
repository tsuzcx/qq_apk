package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class by
  extends com.tencent.mm.bw.a
{
  public long deP;
  public long kzj;
  public long msgId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43276);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.msgId);
      paramVarArgs.aZ(2, this.kzj);
      paramVarArgs.aZ(3, this.deP);
      AppMethodBeat.o(43276);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.msgId);
      int i = f.a.a.b.b.a.p(2, this.kzj);
      int j = f.a.a.b.b.a.p(3, this.deP);
      AppMethodBeat.o(43276);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(43276);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      by localby = (by)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43276);
        return -1;
      case 1: 
        localby.msgId = locala.OmT.zd();
        AppMethodBeat.o(43276);
        return 0;
      case 2: 
        localby.kzj = locala.OmT.zd();
        AppMethodBeat.o(43276);
        return 0;
      }
      localby.deP = locala.OmT.zd();
      AppMethodBeat.o(43276);
      return 0;
    }
    AppMethodBeat.o(43276);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.by
 * JD-Core Version:    0.7.0.1
 */