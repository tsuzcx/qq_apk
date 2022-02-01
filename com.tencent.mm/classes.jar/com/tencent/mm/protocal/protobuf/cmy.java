package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmy
  extends com.tencent.mm.cd.a
{
  public int SZd;
  public int TuA;
  public int Tuy;
  public int Tuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152617);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SZd);
      paramVarArgs.aY(2, this.Tuy);
      paramVarArgs.aY(3, this.Tuz);
      paramVarArgs.aY(4, this.TuA);
      AppMethodBeat.o(152617);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SZd);
      int i = g.a.a.b.b.a.bM(2, this.Tuy);
      int j = g.a.a.b.b.a.bM(3, this.Tuz);
      int k = g.a.a.b.b.a.bM(4, this.TuA);
      AppMethodBeat.o(152617);
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
      AppMethodBeat.o(152617);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cmy localcmy = (cmy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152617);
        return -1;
      case 1: 
        localcmy.SZd = locala.abFh.AK();
        AppMethodBeat.o(152617);
        return 0;
      case 2: 
        localcmy.Tuy = locala.abFh.AK();
        AppMethodBeat.o(152617);
        return 0;
      case 3: 
        localcmy.Tuz = locala.abFh.AK();
        AppMethodBeat.o(152617);
        return 0;
      }
      localcmy.TuA = locala.abFh.AK();
      AppMethodBeat.o(152617);
      return 0;
    }
    AppMethodBeat.o(152617);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmy
 * JD-Core Version:    0.7.0.1
 */