package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfp
  extends com.tencent.mm.cd.a
{
  public int SEk;
  public String myd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152647);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.myd != null) {
        paramVarArgs.f(1, this.myd);
      }
      paramVarArgs.aY(2, this.SEk);
      AppMethodBeat.o(152647);
      return 0;
    }
    if (paramInt == 1) {
      if (this.myd == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.g(1, this.myd) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.SEk);
      AppMethodBeat.o(152647);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152647);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dfp localdfp = (dfp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152647);
          return -1;
        case 1: 
          localdfp.myd = locala.abFh.readString();
          AppMethodBeat.o(152647);
          return 0;
        }
        localdfp.SEk = locala.abFh.AK();
        AppMethodBeat.o(152647);
        return 0;
      }
      AppMethodBeat.o(152647);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfp
 * JD-Core Version:    0.7.0.1
 */