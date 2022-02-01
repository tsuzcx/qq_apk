package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class oj
  extends com.tencent.mm.cd.a
{
  public String RTk;
  public int RVC;
  public int RVD;
  public long RVE;
  public String RVF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124433);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RVC);
      paramVarArgs.aY(2, this.RVD);
      paramVarArgs.bm(3, this.RVE);
      if (this.RVF != null) {
        paramVarArgs.f(4, this.RVF);
      }
      if (this.RTk != null) {
        paramVarArgs.f(5, this.RTk);
      }
      AppMethodBeat.o(124433);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RVC) + 0 + g.a.a.b.b.a.bM(2, this.RVD) + g.a.a.b.b.a.p(3, this.RVE);
      paramInt = i;
      if (this.RVF != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RVF);
      }
      i = paramInt;
      if (this.RTk != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RTk);
      }
      AppMethodBeat.o(124433);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(124433);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      oj localoj = (oj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124433);
        return -1;
      case 1: 
        localoj.RVC = locala.abFh.AK();
        AppMethodBeat.o(124433);
        return 0;
      case 2: 
        localoj.RVD = locala.abFh.AK();
        AppMethodBeat.o(124433);
        return 0;
      case 3: 
        localoj.RVE = locala.abFh.AN();
        AppMethodBeat.o(124433);
        return 0;
      case 4: 
        localoj.RVF = locala.abFh.readString();
        AppMethodBeat.o(124433);
        return 0;
      }
      localoj.RTk = locala.abFh.readString();
      AppMethodBeat.o(124433);
      return 0;
    }
    AppMethodBeat.o(124433);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oj
 * JD-Core Version:    0.7.0.1
 */