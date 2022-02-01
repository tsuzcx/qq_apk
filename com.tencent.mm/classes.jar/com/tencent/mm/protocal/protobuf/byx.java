package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byx
  extends com.tencent.mm.cd.a
{
  public String RHW;
  public String ThW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125734);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RHW != null) {
        paramVarArgs.f(1, this.RHW);
      }
      if (this.ThW != null) {
        paramVarArgs.f(2, this.ThW);
      }
      AppMethodBeat.o(125734);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RHW == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.RHW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ThW != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.ThW);
      }
      AppMethodBeat.o(125734);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125734);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        byx localbyx = (byx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125734);
          return -1;
        case 1: 
          localbyx.RHW = locala.abFh.readString();
          AppMethodBeat.o(125734);
          return 0;
        }
        localbyx.ThW = locala.abFh.readString();
        AppMethodBeat.o(125734);
        return 0;
      }
      AppMethodBeat.o(125734);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byx
 * JD-Core Version:    0.7.0.1
 */