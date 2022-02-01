package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxb
  extends com.tencent.mm.cd.a
{
  public int GQB;
  public int TFC;
  public int TFD;
  public int TFE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116472);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TFC);
      paramVarArgs.aY(2, this.TFD);
      paramVarArgs.aY(3, this.TFE);
      paramVarArgs.aY(4, this.GQB);
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.TFC);
      int i = g.a.a.b.b.a.bM(2, this.TFD);
      int j = g.a.a.b.b.a.bM(3, this.TFE);
      int k = g.a.a.b.b.a.bM(4, this.GQB);
      AppMethodBeat.o(116472);
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
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cxb localcxb = (cxb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116472);
        return -1;
      case 1: 
        localcxb.TFC = locala.abFh.AK();
        AppMethodBeat.o(116472);
        return 0;
      case 2: 
        localcxb.TFD = locala.abFh.AK();
        AppMethodBeat.o(116472);
        return 0;
      case 3: 
        localcxb.TFE = locala.abFh.AK();
        AppMethodBeat.o(116472);
        return 0;
      }
      localcxb.GQB = locala.abFh.AK();
      AppMethodBeat.o(116472);
      return 0;
    }
    AppMethodBeat.o(116472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxb
 * JD-Core Version:    0.7.0.1
 */