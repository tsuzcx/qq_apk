package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag
  extends com.tencent.mm.cd.a
{
  public String REl;
  public int REm;
  public int REn;
  public int REo;
  public int REp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143961);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.REl != null) {
        paramVarArgs.f(1, this.REl);
      }
      paramVarArgs.aY(2, this.REm);
      paramVarArgs.aY(3, this.REn);
      paramVarArgs.aY(4, this.REo);
      paramVarArgs.aY(5, this.REp);
      AppMethodBeat.o(143961);
      return 0;
    }
    if (paramInt == 1) {
      if (this.REl == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = g.a.a.b.b.a.g(1, this.REl) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.REm);
      int j = g.a.a.b.b.a.bM(3, this.REn);
      int k = g.a.a.b.b.a.bM(4, this.REo);
      int m = g.a.a.b.b.a.bM(5, this.REp);
      AppMethodBeat.o(143961);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(143961);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ag localag = (ag)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(143961);
          return -1;
        case 1: 
          localag.REl = locala.abFh.readString();
          AppMethodBeat.o(143961);
          return 0;
        case 2: 
          localag.REm = locala.abFh.AK();
          AppMethodBeat.o(143961);
          return 0;
        case 3: 
          localag.REn = locala.abFh.AK();
          AppMethodBeat.o(143961);
          return 0;
        case 4: 
          localag.REo = locala.abFh.AK();
          AppMethodBeat.o(143961);
          return 0;
        }
        localag.REp = locala.abFh.AK();
        AppMethodBeat.o(143961);
        return 0;
      }
      AppMethodBeat.o(143961);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ag
 * JD-Core Version:    0.7.0.1
 */