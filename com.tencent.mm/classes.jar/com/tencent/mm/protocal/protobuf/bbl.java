package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbl
  extends com.tencent.mm.cd.a
{
  public long SNg;
  public int SNh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203613);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SNg);
      paramVarArgs.aY(2, this.SNh);
      AppMethodBeat.o(203613);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.SNg);
      int i = g.a.a.b.b.a.bM(2, this.SNh);
      AppMethodBeat.o(203613);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203613);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bbl localbbl = (bbl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203613);
        return -1;
      case 1: 
        localbbl.SNg = locala.abFh.AN();
        AppMethodBeat.o(203613);
        return 0;
      }
      localbbl.SNh = locala.abFh.AK();
      AppMethodBeat.o(203613);
      return 0;
    }
    AppMethodBeat.o(203613);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbl
 * JD-Core Version:    0.7.0.1
 */