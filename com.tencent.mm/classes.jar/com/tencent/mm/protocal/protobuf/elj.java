package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class elj
  extends com.tencent.mm.cd.a
{
  public int Unw;
  public int Unx;
  public int mVJ;
  public String mVK;
  public long mVL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43131);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.mVJ);
      if (this.mVK != null) {
        paramVarArgs.f(2, this.mVK);
      }
      paramVarArgs.bm(3, this.mVL);
      paramVarArgs.aY(4, this.Unw);
      paramVarArgs.aY(5, this.Unx);
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.mVJ) + 0;
      paramInt = i;
      if (this.mVK != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.mVK);
      }
      i = g.a.a.b.b.a.p(3, this.mVL);
      int j = g.a.a.b.b.a.bM(4, this.Unw);
      int k = g.a.a.b.b.a.bM(5, this.Unx);
      AppMethodBeat.o(43131);
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
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      elj localelj = (elj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43131);
        return -1;
      case 1: 
        localelj.mVJ = locala.abFh.AK();
        AppMethodBeat.o(43131);
        return 0;
      case 2: 
        localelj.mVK = locala.abFh.readString();
        AppMethodBeat.o(43131);
        return 0;
      case 3: 
        localelj.mVL = locala.abFh.AN();
        AppMethodBeat.o(43131);
        return 0;
      case 4: 
        localelj.Unw = locala.abFh.AK();
        AppMethodBeat.o(43131);
        return 0;
      }
      localelj.Unx = locala.abFh.AK();
      AppMethodBeat.o(43131);
      return 0;
    }
    AppMethodBeat.o(43131);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elj
 * JD-Core Version:    0.7.0.1
 */