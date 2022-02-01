package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class del
  extends com.tencent.mm.cd.a
{
  public boolean TMh;
  public String TyL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194267);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TyL != null) {
        paramVarArgs.f(1, this.TyL);
      }
      paramVarArgs.co(2, this.TMh);
      AppMethodBeat.o(194267);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TyL == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.g(1, this.TyL) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.gL(2);
      AppMethodBeat.o(194267);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194267);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        del localdel = (del)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194267);
          return -1;
        case 1: 
          localdel.TyL = locala.abFh.readString();
          AppMethodBeat.o(194267);
          return 0;
        }
        localdel.TMh = locala.abFh.AB();
        AppMethodBeat.o(194267);
        return 0;
      }
      AppMethodBeat.o(194267);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.del
 * JD-Core Version:    0.7.0.1
 */