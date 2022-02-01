package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyh
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public int RKi;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6427);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.f(1, this.Url);
      }
      paramVarArgs.aY(2, this.RKi);
      paramVarArgs.aY(3, this.CPw);
      AppMethodBeat.o(6427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label315;
      }
    }
    label315:
    for (paramInt = g.a.a.b.b.a.g(1, this.Url) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.RKi);
      int j = g.a.a.b.b.a.bM(3, this.CPw);
      AppMethodBeat.o(6427);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(6427);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dyh localdyh = (dyh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6427);
          return -1;
        case 1: 
          localdyh.Url = locala.abFh.readString();
          AppMethodBeat.o(6427);
          return 0;
        case 2: 
          localdyh.RKi = locala.abFh.AK();
          AppMethodBeat.o(6427);
          return 0;
        }
        localdyh.CPw = locala.abFh.AK();
        AppMethodBeat.o(6427);
        return 0;
      }
      AppMethodBeat.o(6427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyh
 * JD-Core Version:    0.7.0.1
 */