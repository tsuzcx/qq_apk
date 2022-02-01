package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcp
  extends com.tencent.mm.cd.a
{
  public int TKu;
  public int TKv;
  public int TKw;
  public int TKx;
  public int TKy;
  public int TKz;
  public int Twy;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143985);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Twy);
      paramVarArgs.aY(2, this.TKu);
      paramVarArgs.aY(3, this.TKv);
      paramVarArgs.aY(4, this.TKw);
      paramVarArgs.aY(5, this.TKx);
      paramVarArgs.aY(6, this.TKy);
      paramVarArgs.aY(7, this.TKz);
      paramVarArgs.aY(8, this.rWu);
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.Twy);
      int i = g.a.a.b.b.a.bM(2, this.TKu);
      int j = g.a.a.b.b.a.bM(3, this.TKv);
      int k = g.a.a.b.b.a.bM(4, this.TKw);
      int m = g.a.a.b.b.a.bM(5, this.TKx);
      int n = g.a.a.b.b.a.bM(6, this.TKy);
      int i1 = g.a.a.b.b.a.bM(7, this.TKz);
      int i2 = g.a.a.b.b.a.bM(8, this.rWu);
      AppMethodBeat.o(143985);
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
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dcp localdcp = (dcp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143985);
        return -1;
      case 1: 
        localdcp.Twy = locala.abFh.AK();
        AppMethodBeat.o(143985);
        return 0;
      case 2: 
        localdcp.TKu = locala.abFh.AK();
        AppMethodBeat.o(143985);
        return 0;
      case 3: 
        localdcp.TKv = locala.abFh.AK();
        AppMethodBeat.o(143985);
        return 0;
      case 4: 
        localdcp.TKw = locala.abFh.AK();
        AppMethodBeat.o(143985);
        return 0;
      case 5: 
        localdcp.TKx = locala.abFh.AK();
        AppMethodBeat.o(143985);
        return 0;
      case 6: 
        localdcp.TKy = locala.abFh.AK();
        AppMethodBeat.o(143985);
        return 0;
      case 7: 
        localdcp.TKz = locala.abFh.AK();
        AppMethodBeat.o(143985);
        return 0;
      }
      localdcp.rWu = locala.abFh.AK();
      AppMethodBeat.o(143985);
      return 0;
    }
    AppMethodBeat.o(143985);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcp
 * JD-Core Version:    0.7.0.1
 */