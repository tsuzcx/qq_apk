package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class et
  extends com.tencent.mm.cd.a
{
  public int RJD;
  public String RJE;
  public String lVG;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123539);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lVG != null) {
        paramVarArgs.f(1, this.lVG);
      }
      paramVarArgs.aY(2, this.rWu);
      paramVarArgs.aY(3, this.RJD);
      if (this.RJE != null) {
        paramVarArgs.f(4, this.RJE);
      }
      AppMethodBeat.o(123539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lVG == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.g(1, this.lVG) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWu) + g.a.a.b.b.a.bM(3, this.RJD);
      paramInt = i;
      if (this.RJE != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RJE);
      }
      AppMethodBeat.o(123539);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123539);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        et localet = (et)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123539);
          return -1;
        case 1: 
          localet.lVG = locala.abFh.readString();
          AppMethodBeat.o(123539);
          return 0;
        case 2: 
          localet.rWu = locala.abFh.AK();
          AppMethodBeat.o(123539);
          return 0;
        case 3: 
          localet.RJD = locala.abFh.AK();
          AppMethodBeat.o(123539);
          return 0;
        }
        localet.RJE = locala.abFh.readString();
        AppMethodBeat.o(123539);
        return 0;
      }
      AppMethodBeat.o(123539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.et
 * JD-Core Version:    0.7.0.1
 */