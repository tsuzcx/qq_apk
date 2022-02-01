package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fim
  extends com.tencent.mm.cd.a
{
  public String CNP;
  public String UIn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121117);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CNP != null) {
        paramVarArgs.f(1, this.CNP);
      }
      if (this.UIn != null) {
        paramVarArgs.f(2, this.UIn);
      }
      AppMethodBeat.o(121117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNP == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.CNP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UIn != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UIn);
      }
      AppMethodBeat.o(121117);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(121117);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fim localfim = (fim)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(121117);
          return -1;
        case 1: 
          localfim.CNP = locala.abFh.readString();
          AppMethodBeat.o(121117);
          return 0;
        }
        localfim.UIn = locala.abFh.readString();
        AppMethodBeat.o(121117);
        return 0;
      }
      AppMethodBeat.o(121117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fim
 * JD-Core Version:    0.7.0.1
 */