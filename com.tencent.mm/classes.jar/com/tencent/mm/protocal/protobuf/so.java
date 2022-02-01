package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class so
  extends com.tencent.mm.bw.a
{
  public String GhA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125714);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GhA != null) {
        paramVarArgs.d(1, this.GhA);
      }
      AppMethodBeat.o(125714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GhA == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.GhA) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(125714);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125714);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        so localso = (so)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125714);
          return -1;
        }
        localso.GhA = locala.OmT.readString();
        AppMethodBeat.o(125714);
        return 0;
      }
      AppMethodBeat.o(125714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.so
 * JD-Core Version:    0.7.0.1
 */