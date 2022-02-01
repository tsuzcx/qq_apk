package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckw
  extends com.tencent.mm.cd.a
{
  public int Tso;
  public int Tsp;
  public int Tsq;
  public int Tsr;
  public int Tss;
  public int Tst;
  public int Tsu;
  public int fwq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143981);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Tso);
      paramVarArgs.aY(2, this.fwq);
      paramVarArgs.aY(3, this.Tsp);
      paramVarArgs.aY(4, this.Tsq);
      paramVarArgs.aY(5, this.Tsr);
      paramVarArgs.aY(6, this.Tss);
      paramVarArgs.aY(7, this.Tst);
      paramVarArgs.aY(8, this.Tsu);
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.Tso);
      int i = g.a.a.b.b.a.bM(2, this.fwq);
      int j = g.a.a.b.b.a.bM(3, this.Tsp);
      int k = g.a.a.b.b.a.bM(4, this.Tsq);
      int m = g.a.a.b.b.a.bM(5, this.Tsr);
      int n = g.a.a.b.b.a.bM(6, this.Tss);
      int i1 = g.a.a.b.b.a.bM(7, this.Tst);
      int i2 = g.a.a.b.b.a.bM(8, this.Tsu);
      AppMethodBeat.o(143981);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ckw localckw = (ckw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143981);
        return -1;
      case 1: 
        localckw.Tso = locala.abFh.AK();
        AppMethodBeat.o(143981);
        return 0;
      case 2: 
        localckw.fwq = locala.abFh.AK();
        AppMethodBeat.o(143981);
        return 0;
      case 3: 
        localckw.Tsp = locala.abFh.AK();
        AppMethodBeat.o(143981);
        return 0;
      case 4: 
        localckw.Tsq = locala.abFh.AK();
        AppMethodBeat.o(143981);
        return 0;
      case 5: 
        localckw.Tsr = locala.abFh.AK();
        AppMethodBeat.o(143981);
        return 0;
      case 6: 
        localckw.Tss = locala.abFh.AK();
        AppMethodBeat.o(143981);
        return 0;
      case 7: 
        localckw.Tst = locala.abFh.AK();
        AppMethodBeat.o(143981);
        return 0;
      }
      localckw.Tsu = locala.abFh.AK();
      AppMethodBeat.o(143981);
      return 0;
    }
    AppMethodBeat.o(143981);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckw
 * JD-Core Version:    0.7.0.1
 */