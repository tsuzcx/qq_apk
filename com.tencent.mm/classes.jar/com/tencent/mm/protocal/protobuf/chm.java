package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chm
  extends com.tencent.mm.cd.a
{
  public String ToP;
  public int ToQ;
  public int ToR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43097);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ToP != null) {
        paramVarArgs.f(1, this.ToP);
      }
      paramVarArgs.aY(2, this.ToQ);
      paramVarArgs.aY(3, this.ToR);
      AppMethodBeat.o(43097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ToP == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.ToP) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.ToQ);
      int j = g.a.a.b.b.a.bM(3, this.ToR);
      AppMethodBeat.o(43097);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(43097);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        chm localchm = (chm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43097);
          return -1;
        case 1: 
          localchm.ToP = locala.abFh.readString();
          AppMethodBeat.o(43097);
          return 0;
        case 2: 
          localchm.ToQ = locala.abFh.AK();
          AppMethodBeat.o(43097);
          return 0;
        }
        localchm.ToR = locala.abFh.AK();
        AppMethodBeat.o(43097);
        return 0;
      }
      AppMethodBeat.o(43097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chm
 * JD-Core Version:    0.7.0.1
 */