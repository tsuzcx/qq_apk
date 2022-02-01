package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cuj
  extends com.tencent.mm.bw.a
{
  public String MzD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125751);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MzD != null) {
        paramVarArgs.e(1, this.MzD);
      }
      AppMethodBeat.o(125751);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MzD == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.f(1, this.MzD) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(125751);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125751);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cuj localcuj = (cuj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125751);
          return -1;
        }
        localcuj.MzD = locala.UbS.readString();
        AppMethodBeat.o(125751);
        return 0;
      }
      AppMethodBeat.o(125751);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuj
 * JD-Core Version:    0.7.0.1
 */