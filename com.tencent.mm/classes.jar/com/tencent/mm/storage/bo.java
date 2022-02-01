package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bo
  extends com.tencent.mm.bx.a
{
  public long cVb;
  public long jBc;
  public long msgId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43276);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.msgId);
      paramVarArgs.aG(2, this.jBc);
      paramVarArgs.aG(3, this.cVb);
      AppMethodBeat.o(43276);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.msgId);
      int i = f.a.a.b.b.a.q(2, this.jBc);
      int j = f.a.a.b.b.a.q(3, this.cVb);
      AppMethodBeat.o(43276);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(43276);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bo localbo = (bo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43276);
        return -1;
      case 1: 
        localbo.msgId = locala.KhF.xT();
        AppMethodBeat.o(43276);
        return 0;
      case 2: 
        localbo.jBc = locala.KhF.xT();
        AppMethodBeat.o(43276);
        return 0;
      }
      localbo.cVb = locala.KhF.xT();
      AppMethodBeat.o(43276);
      return 0;
    }
    AppMethodBeat.o(43276);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.bo
 * JD-Core Version:    0.7.0.1
 */