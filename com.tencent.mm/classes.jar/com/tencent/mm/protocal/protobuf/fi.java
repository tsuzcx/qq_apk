package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fi
  extends com.tencent.mm.cd.a
{
  public boolean RKq;
  public boolean RKr;
  public int RKs;
  public int RKt;
  public int RKu;
  public int RKv;
  public int RKw;
  public boolean RKx;
  public boolean RKy;
  public boolean RKz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124386);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.RKq);
      paramVarArgs.co(2, this.RKr);
      paramVarArgs.aY(3, this.RKs);
      paramVarArgs.aY(4, this.RKt);
      paramVarArgs.aY(5, this.RKu);
      paramVarArgs.aY(6, this.RKv);
      paramVarArgs.aY(7, this.RKw);
      paramVarArgs.co(8, this.RKx);
      paramVarArgs.co(9, this.RKy);
      paramVarArgs.co(10, this.RKz);
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.gL(1);
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.bM(3, this.RKs);
      int k = g.a.a.b.b.a.bM(4, this.RKt);
      int m = g.a.a.b.b.a.bM(5, this.RKu);
      int n = g.a.a.b.b.a.bM(6, this.RKv);
      int i1 = g.a.a.b.b.a.bM(7, this.RKw);
      int i2 = g.a.a.b.b.a.gL(8);
      int i3 = g.a.a.b.b.a.gL(9);
      int i4 = g.a.a.b.b.a.gL(10);
      AppMethodBeat.o(124386);
      return paramInt + 1 + 0 + (i + 1) + j + k + m + n + i1 + (i2 + 1) + (i3 + 1) + (i4 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fi localfi = (fi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124386);
        return -1;
      case 1: 
        localfi.RKq = locala.abFh.AB();
        AppMethodBeat.o(124386);
        return 0;
      case 2: 
        localfi.RKr = locala.abFh.AB();
        AppMethodBeat.o(124386);
        return 0;
      case 3: 
        localfi.RKs = locala.abFh.AK();
        AppMethodBeat.o(124386);
        return 0;
      case 4: 
        localfi.RKt = locala.abFh.AK();
        AppMethodBeat.o(124386);
        return 0;
      case 5: 
        localfi.RKu = locala.abFh.AK();
        AppMethodBeat.o(124386);
        return 0;
      case 6: 
        localfi.RKv = locala.abFh.AK();
        AppMethodBeat.o(124386);
        return 0;
      case 7: 
        localfi.RKw = locala.abFh.AK();
        AppMethodBeat.o(124386);
        return 0;
      case 8: 
        localfi.RKx = locala.abFh.AB();
        AppMethodBeat.o(124386);
        return 0;
      case 9: 
        localfi.RKy = locala.abFh.AB();
        AppMethodBeat.o(124386);
        return 0;
      }
      localfi.RKz = locala.abFh.AB();
      AppMethodBeat.o(124386);
      return 0;
    }
    AppMethodBeat.o(124386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fi
 * JD-Core Version:    0.7.0.1
 */