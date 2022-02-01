package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qa
  extends com.tencent.mm.bw.a
{
  public int GdD;
  public int GdE;
  public int GdF;
  public int dEu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91367);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dEu);
      paramVarArgs.aS(2, this.GdD);
      paramVarArgs.aS(3, this.GdE);
      paramVarArgs.aS(4, this.GdF);
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.dEu);
      int i = f.a.a.b.b.a.bz(2, this.GdD);
      int j = f.a.a.b.b.a.bz(3, this.GdE);
      int k = f.a.a.b.b.a.bz(4, this.GdF);
      AppMethodBeat.o(91367);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      qa localqa = (qa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91367);
        return -1;
      case 1: 
        localqa.dEu = locala.OmT.zc();
        AppMethodBeat.o(91367);
        return 0;
      case 2: 
        localqa.GdD = locala.OmT.zc();
        AppMethodBeat.o(91367);
        return 0;
      case 3: 
        localqa.GdE = locala.OmT.zc();
        AppMethodBeat.o(91367);
        return 0;
      }
      localqa.GdF = locala.OmT.zc();
      AppMethodBeat.o(91367);
      return 0;
    }
    AppMethodBeat.o(91367);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qa
 * JD-Core Version:    0.7.0.1
 */