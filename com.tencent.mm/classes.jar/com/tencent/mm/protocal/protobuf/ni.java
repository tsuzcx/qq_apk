package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ni
  extends com.tencent.mm.cd.a
{
  public String RUd;
  public int RUe;
  public String RUf;
  public int RUg;
  public int RUh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124415);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RUd != null) {
        paramVarArgs.f(1, this.RUd);
      }
      paramVarArgs.aY(2, this.RUe);
      if (this.RUf != null) {
        paramVarArgs.f(3, this.RUf);
      }
      paramVarArgs.aY(4, this.RUg);
      paramVarArgs.aY(5, this.RUh);
      AppMethodBeat.o(124415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RUd == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = g.a.a.b.b.a.g(1, this.RUd) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RUe);
      paramInt = i;
      if (this.RUf != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RUf);
      }
      i = g.a.a.b.b.a.bM(4, this.RUg);
      int j = g.a.a.b.b.a.bM(5, this.RUh);
      AppMethodBeat.o(124415);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124415);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ni localni = (ni)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124415);
          return -1;
        case 1: 
          localni.RUd = locala.abFh.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 2: 
          localni.RUe = locala.abFh.AK();
          AppMethodBeat.o(124415);
          return 0;
        case 3: 
          localni.RUf = locala.abFh.readString();
          AppMethodBeat.o(124415);
          return 0;
        case 4: 
          localni.RUg = locala.abFh.AK();
          AppMethodBeat.o(124415);
          return 0;
        }
        localni.RUh = locala.abFh.AK();
        AppMethodBeat.o(124415);
        return 0;
      }
      AppMethodBeat.o(124415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ni
 * JD-Core Version:    0.7.0.1
 */