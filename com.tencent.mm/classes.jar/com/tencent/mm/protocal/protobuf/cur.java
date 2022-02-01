package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cur
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public long TCs;
  public long TCt;
  public int TCu;
  public String Tkw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117877);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CPw);
      if (this.Tkw != null) {
        paramVarArgs.f(2, this.Tkw);
      }
      paramVarArgs.bm(3, this.TCt);
      paramVarArgs.bm(4, this.TCs);
      paramVarArgs.aY(5, this.TCu);
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CPw) + 0;
      paramInt = i;
      if (this.Tkw != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tkw);
      }
      i = g.a.a.b.b.a.p(3, this.TCt);
      int j = g.a.a.b.b.a.p(4, this.TCs);
      int k = g.a.a.b.b.a.bM(5, this.TCu);
      AppMethodBeat.o(117877);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cur localcur = (cur)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117877);
        return -1;
      case 1: 
        localcur.CPw = locala.abFh.AK();
        AppMethodBeat.o(117877);
        return 0;
      case 2: 
        localcur.Tkw = locala.abFh.readString();
        AppMethodBeat.o(117877);
        return 0;
      case 3: 
        localcur.TCt = locala.abFh.AN();
        AppMethodBeat.o(117877);
        return 0;
      case 4: 
        localcur.TCs = locala.abFh.AN();
        AppMethodBeat.o(117877);
        return 0;
      }
      localcur.TCu = locala.abFh.AK();
      AppMethodBeat.o(117877);
      return 0;
    }
    AppMethodBeat.o(117877);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cur
 * JD-Core Version:    0.7.0.1
 */