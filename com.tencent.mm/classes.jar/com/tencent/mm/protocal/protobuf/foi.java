package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class foi
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public int RTb;
  public int TBF;
  public int TBG;
  public int TuP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50118);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TuP);
      paramVarArgs.aY(2, this.RTb);
      paramVarArgs.aY(3, this.CPw);
      paramVarArgs.aY(5, this.TBG);
      paramVarArgs.aY(6, this.TBF);
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.TuP);
      int i = g.a.a.b.b.a.bM(2, this.RTb);
      int j = g.a.a.b.b.a.bM(3, this.CPw);
      int k = g.a.a.b.b.a.bM(5, this.TBG);
      int m = g.a.a.b.b.a.bM(6, this.TBF);
      AppMethodBeat.o(50118);
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
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      foi localfoi = (foi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      default: 
        AppMethodBeat.o(50118);
        return -1;
      case 1: 
        localfoi.TuP = locala.abFh.AK();
        AppMethodBeat.o(50118);
        return 0;
      case 2: 
        localfoi.RTb = locala.abFh.AK();
        AppMethodBeat.o(50118);
        return 0;
      case 3: 
        localfoi.CPw = locala.abFh.AK();
        AppMethodBeat.o(50118);
        return 0;
      case 5: 
        localfoi.TBG = locala.abFh.AK();
        AppMethodBeat.o(50118);
        return 0;
      }
      localfoi.TBF = locala.abFh.AK();
      AppMethodBeat.o(50118);
      return 0;
    }
    AppMethodBeat.o(50118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.foi
 * JD-Core Version:    0.7.0.1
 */