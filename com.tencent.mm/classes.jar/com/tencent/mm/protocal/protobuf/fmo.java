package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fmo
  extends com.tencent.mm.cd.a
{
  public String RJK;
  public String ULm;
  public String ULn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199946);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ULm != null) {
        paramVarArgs.f(1, this.ULm);
      }
      if (this.ULn != null) {
        paramVarArgs.f(2, this.ULn);
      }
      if (this.RJK != null) {
        paramVarArgs.f(3, this.RJK);
      }
      AppMethodBeat.o(199946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ULm == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.ULm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ULn != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ULn);
      }
      i = paramInt;
      if (this.RJK != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RJK);
      }
      AppMethodBeat.o(199946);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199946);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fmo localfmo = (fmo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(199946);
          return -1;
        case 1: 
          localfmo.ULm = locala.abFh.readString();
          AppMethodBeat.o(199946);
          return 0;
        case 2: 
          localfmo.ULn = locala.abFh.readString();
          AppMethodBeat.o(199946);
          return 0;
        }
        localfmo.RJK = locala.abFh.readString();
        AppMethodBeat.o(199946);
        return 0;
      }
      AppMethodBeat.o(199946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmo
 * JD-Core Version:    0.7.0.1
 */