package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class st
  extends com.tencent.mm.cd.a
{
  public String Scc;
  public String fQR;
  public String fQb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72426);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Scc != null) {
        paramVarArgs.f(1, this.Scc);
      }
      if (this.fQb != null) {
        paramVarArgs.f(2, this.fQb);
      }
      if (this.fQR != null) {
        paramVarArgs.f(3, this.fQR);
      }
      AppMethodBeat.o(72426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Scc == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.Scc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fQb != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fQb);
      }
      i = paramInt;
      if (this.fQR != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fQR);
      }
      AppMethodBeat.o(72426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72426);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        st localst = (st)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72426);
          return -1;
        case 1: 
          localst.Scc = locala.abFh.readString();
          AppMethodBeat.o(72426);
          return 0;
        case 2: 
          localst.fQb = locala.abFh.readString();
          AppMethodBeat.o(72426);
          return 0;
        }
        localst.fQR = locala.abFh.readString();
        AppMethodBeat.o(72426);
        return 0;
      }
      AppMethodBeat.o(72426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.st
 * JD-Core Version:    0.7.0.1
 */