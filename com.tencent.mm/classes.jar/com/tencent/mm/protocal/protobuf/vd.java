package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vd
  extends com.tencent.mm.cd.a
{
  public int RIt;
  public String RVi;
  public long SgB;
  public int SgC;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93332);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RVi != null) {
        paramVarArgs.f(1, this.RVi);
      }
      paramVarArgs.bm(2, this.SgB);
      paramVarArgs.aY(3, this.SgC);
      paramVarArgs.aY(4, this.RIt);
      paramVarArgs.aY(5, this.rVU);
      AppMethodBeat.o(93332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RVi == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = g.a.a.b.b.a.g(1, this.RVi) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.SgB);
      int j = g.a.a.b.b.a.bM(3, this.SgC);
      int k = g.a.a.b.b.a.bM(4, this.RIt);
      int m = g.a.a.b.b.a.bM(5, this.rVU);
      AppMethodBeat.o(93332);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(93332);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        vd localvd = (vd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(93332);
          return -1;
        case 1: 
          localvd.RVi = locala.abFh.readString();
          AppMethodBeat.o(93332);
          return 0;
        case 2: 
          localvd.SgB = locala.abFh.AN();
          AppMethodBeat.o(93332);
          return 0;
        case 3: 
          localvd.SgC = locala.abFh.AK();
          AppMethodBeat.o(93332);
          return 0;
        case 4: 
          localvd.RIt = locala.abFh.AK();
          AppMethodBeat.o(93332);
          return 0;
        }
        localvd.rVU = locala.abFh.AK();
        AppMethodBeat.o(93332);
        return 0;
      }
      AppMethodBeat.o(93332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vd
 * JD-Core Version:    0.7.0.1
 */