package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fea
  extends com.tencent.mm.bw.a
{
  public String NyR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123708);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NyR != null) {
        paramVarArgs.e(1, this.NyR);
      }
      AppMethodBeat.o(123708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NyR == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.f(1, this.NyR) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(123708);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123708);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fea localfea = (fea)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123708);
          return -1;
        }
        localfea.NyR = locala.UbS.readString();
        AppMethodBeat.o(123708);
        return 0;
      }
      AppMethodBeat.o(123708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fea
 * JD-Core Version:    0.7.0.1
 */