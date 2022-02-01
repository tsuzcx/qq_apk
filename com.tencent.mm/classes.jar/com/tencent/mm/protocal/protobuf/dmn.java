package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmn
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public int rVx;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205194);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMP != null) {
        paramVarArgs.f(1, this.CMP);
      }
      paramVarArgs.aY(2, this.rVx);
      paramVarArgs.aY(3, this.rWu);
      AppMethodBeat.o(205194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMP == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.CMP) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.rVx);
      int j = g.a.a.b.b.a.bM(3, this.rWu);
      AppMethodBeat.o(205194);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205194);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dmn localdmn = (dmn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205194);
          return -1;
        case 1: 
          localdmn.CMP = locala.abFh.readString();
          AppMethodBeat.o(205194);
          return 0;
        case 2: 
          localdmn.rVx = locala.abFh.AK();
          AppMethodBeat.o(205194);
          return 0;
        }
        localdmn.rWu = locala.abFh.AK();
        AppMethodBeat.o(205194);
        return 0;
      }
      AppMethodBeat.o(205194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmn
 * JD-Core Version:    0.7.0.1
 */