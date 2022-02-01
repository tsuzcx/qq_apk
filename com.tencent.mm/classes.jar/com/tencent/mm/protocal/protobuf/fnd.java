package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fnd
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public int RTb;
  public int TBF;
  public int TBG;
  public String TBH;
  public int TuP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123683);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TuP);
      paramVarArgs.aY(2, this.RTb);
      paramVarArgs.aY(3, this.CPw);
      if (this.TBH != null) {
        paramVarArgs.f(4, this.TBH);
      }
      paramVarArgs.aY(5, this.TBG);
      paramVarArgs.aY(6, this.TBF);
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.TuP) + 0 + g.a.a.b.b.a.bM(2, this.RTb) + g.a.a.b.b.a.bM(3, this.CPw);
      paramInt = i;
      if (this.TBH != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TBH);
      }
      i = g.a.a.b.b.a.bM(5, this.TBG);
      int j = g.a.a.b.b.a.bM(6, this.TBF);
      AppMethodBeat.o(123683);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fnd localfnd = (fnd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123683);
        return -1;
      case 1: 
        localfnd.TuP = locala.abFh.AK();
        AppMethodBeat.o(123683);
        return 0;
      case 2: 
        localfnd.RTb = locala.abFh.AK();
        AppMethodBeat.o(123683);
        return 0;
      case 3: 
        localfnd.CPw = locala.abFh.AK();
        AppMethodBeat.o(123683);
        return 0;
      case 4: 
        localfnd.TBH = locala.abFh.readString();
        AppMethodBeat.o(123683);
        return 0;
      case 5: 
        localfnd.TBG = locala.abFh.AK();
        AppMethodBeat.o(123683);
        return 0;
      }
      localfnd.TBF = locala.abFh.AK();
      AppMethodBeat.o(123683);
      return 0;
    }
    AppMethodBeat.o(123683);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnd
 * JD-Core Version:    0.7.0.1
 */