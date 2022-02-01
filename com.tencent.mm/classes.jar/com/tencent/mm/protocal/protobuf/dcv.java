package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcv
  extends com.tencent.mm.cd.a
{
  public String TKH;
  public String TKI;
  public String TKJ;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213455);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TKH != null) {
        paramVarArgs.f(1, this.TKH);
      }
      if (this.TKI != null) {
        paramVarArgs.f(2, this.TKI);
      }
      if (this.TKJ != null) {
        paramVarArgs.f(3, this.TKJ);
      }
      paramVarArgs.aY(4, this.action);
      AppMethodBeat.o(213455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TKH == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.TKH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TKI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TKI);
      }
      i = paramInt;
      if (this.TKJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TKJ);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.action);
      AppMethodBeat.o(213455);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(213455);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dcv localdcv = (dcv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(213455);
          return -1;
        case 1: 
          localdcv.TKH = locala.abFh.readString();
          AppMethodBeat.o(213455);
          return 0;
        case 2: 
          localdcv.TKI = locala.abFh.readString();
          AppMethodBeat.o(213455);
          return 0;
        case 3: 
          localdcv.TKJ = locala.abFh.readString();
          AppMethodBeat.o(213455);
          return 0;
        }
        localdcv.action = locala.abFh.AK();
        AppMethodBeat.o(213455);
        return 0;
      }
      AppMethodBeat.o(213455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcv
 * JD-Core Version:    0.7.0.1
 */