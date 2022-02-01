package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bde
  extends com.tencent.mm.cd.a
{
  public int SNC;
  public String SOp;
  public int time_limit;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199927);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SOp != null) {
        paramVarArgs.f(1, this.SOp);
      }
      paramVarArgs.aY(2, this.time_limit);
      paramVarArgs.aY(3, this.SNC);
      AppMethodBeat.o(199927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SOp == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.SOp) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.time_limit);
      int j = g.a.a.b.b.a.bM(3, this.SNC);
      AppMethodBeat.o(199927);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199927);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bde localbde = (bde)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(199927);
          return -1;
        case 1: 
          localbde.SOp = locala.abFh.readString();
          AppMethodBeat.o(199927);
          return 0;
        case 2: 
          localbde.time_limit = locala.abFh.AK();
          AppMethodBeat.o(199927);
          return 0;
        }
        localbde.SNC = locala.abFh.AK();
        AppMethodBeat.o(199927);
        return 0;
      }
      AppMethodBeat.o(199927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bde
 * JD-Core Version:    0.7.0.1
 */