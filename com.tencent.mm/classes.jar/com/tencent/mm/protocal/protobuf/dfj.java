package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfj
  extends com.tencent.mm.bw.a
{
  public boolean HMt = false;
  public boolean HMu = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147779);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.HMt);
      paramVarArgs.bC(2, this.HMu);
      AppMethodBeat.o(147779);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amF(1);
      int i = f.a.a.b.b.a.amF(2);
      AppMethodBeat.o(147779);
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
      AppMethodBeat.o(147779);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dfj localdfj = (dfj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147779);
        return -1;
      case 1: 
        localdfj.HMt = locala.OmT.gvY();
        AppMethodBeat.o(147779);
        return 0;
      }
      localdfj.HMu = locala.OmT.gvY();
      AppMethodBeat.o(147779);
      return 0;
    }
    AppMethodBeat.o(147779);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfj
 * JD-Core Version:    0.7.0.1
 */