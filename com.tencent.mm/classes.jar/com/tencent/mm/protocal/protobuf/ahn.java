package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahn
  extends com.tencent.mm.cd.a
{
  public int Ssj;
  public int fSM;
  public int fps;
  public int height;
  public int jqA;
  public int jqz;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90965);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.jqz);
      paramVarArgs.aY(2, this.fps);
      paramVarArgs.aY(3, this.jqA);
      paramVarArgs.aY(4, this.Ssj);
      paramVarArgs.aY(5, this.fSM);
      paramVarArgs.aY(6, this.width);
      paramVarArgs.aY(7, this.height);
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.jqz);
      int i = g.a.a.b.b.a.bM(2, this.fps);
      int j = g.a.a.b.b.a.bM(3, this.jqA);
      int k = g.a.a.b.b.a.bM(4, this.Ssj);
      int m = g.a.a.b.b.a.bM(5, this.fSM);
      int n = g.a.a.b.b.a.bM(6, this.width);
      int i1 = g.a.a.b.b.a.bM(7, this.height);
      AppMethodBeat.o(90965);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ahn localahn = (ahn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90965);
        return -1;
      case 1: 
        localahn.jqz = locala.abFh.AK();
        AppMethodBeat.o(90965);
        return 0;
      case 2: 
        localahn.fps = locala.abFh.AK();
        AppMethodBeat.o(90965);
        return 0;
      case 3: 
        localahn.jqA = locala.abFh.AK();
        AppMethodBeat.o(90965);
        return 0;
      case 4: 
        localahn.Ssj = locala.abFh.AK();
        AppMethodBeat.o(90965);
        return 0;
      case 5: 
        localahn.fSM = locala.abFh.AK();
        AppMethodBeat.o(90965);
        return 0;
      case 6: 
        localahn.width = locala.abFh.AK();
        AppMethodBeat.o(90965);
        return 0;
      }
      localahn.height = locala.abFh.AK();
      AppMethodBeat.o(90965);
      return 0;
    }
    AppMethodBeat.o(90965);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahn
 * JD-Core Version:    0.7.0.1
 */