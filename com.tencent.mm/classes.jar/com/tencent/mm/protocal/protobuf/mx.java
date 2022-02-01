package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mx
  extends com.tencent.mm.cd.a
{
  public int CreateTime;
  public int RIt;
  public int RTg;
  public int RTh;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124398);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RTg);
      paramVarArgs.aY(2, this.CreateTime);
      paramVarArgs.aY(3, this.RIt);
      paramVarArgs.aY(4, this.rWu);
      paramVarArgs.aY(5, this.RTh);
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.RTg);
      int i = g.a.a.b.b.a.bM(2, this.CreateTime);
      int j = g.a.a.b.b.a.bM(3, this.RIt);
      int k = g.a.a.b.b.a.bM(4, this.rWu);
      int m = g.a.a.b.b.a.bM(5, this.RTh);
      AppMethodBeat.o(124398);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      mx localmx = (mx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124398);
        return -1;
      case 1: 
        localmx.RTg = locala.abFh.AK();
        AppMethodBeat.o(124398);
        return 0;
      case 2: 
        localmx.CreateTime = locala.abFh.AK();
        AppMethodBeat.o(124398);
        return 0;
      case 3: 
        localmx.RIt = locala.abFh.AK();
        AppMethodBeat.o(124398);
        return 0;
      case 4: 
        localmx.rWu = locala.abFh.AK();
        AppMethodBeat.o(124398);
        return 0;
      }
      localmx.RTh = locala.abFh.AK();
      AppMethodBeat.o(124398);
      return 0;
    }
    AppMethodBeat.o(124398);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mx
 * JD-Core Version:    0.7.0.1
 */