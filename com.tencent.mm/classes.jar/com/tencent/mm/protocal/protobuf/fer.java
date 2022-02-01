package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fer
  extends com.tencent.mm.cd.a
{
  public int UFh;
  public int UFi;
  public int UFj;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115903);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rWu);
      paramVarArgs.aY(2, this.UFh);
      paramVarArgs.aY(3, this.UFi);
      paramVarArgs.aY(4, this.UFj);
      AppMethodBeat.o(115903);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.rWu);
      int i = g.a.a.b.b.a.bM(2, this.UFh);
      int j = g.a.a.b.b.a.bM(3, this.UFi);
      int k = g.a.a.b.b.a.bM(4, this.UFj);
      AppMethodBeat.o(115903);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(115903);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fer localfer = (fer)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115903);
        return -1;
      case 1: 
        localfer.rWu = locala.abFh.AK();
        AppMethodBeat.o(115903);
        return 0;
      case 2: 
        localfer.UFh = locala.abFh.AK();
        AppMethodBeat.o(115903);
        return 0;
      case 3: 
        localfer.UFi = locala.abFh.AK();
        AppMethodBeat.o(115903);
        return 0;
      }
      localfer.UFj = locala.abFh.AK();
      AppMethodBeat.o(115903);
      return 0;
    }
    AppMethodBeat.o(115903);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fer
 * JD-Core Version:    0.7.0.1
 */