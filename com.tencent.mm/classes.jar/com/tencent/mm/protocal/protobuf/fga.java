package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fga
  extends com.tencent.mm.cd.a
{
  public String UGo;
  public String fuV;
  public String fuW;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147800);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fuV != null) {
        paramVarArgs.f(1, this.fuV);
      }
      if (this.fuW != null) {
        paramVarArgs.f(2, this.fuW);
      }
      if (this.UGo != null) {
        paramVarArgs.f(3, this.UGo);
      }
      paramVarArgs.bm(4, this.timestamp);
      AppMethodBeat.o(147800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fuV == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.fuV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fuW != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fuW);
      }
      i = paramInt;
      if (this.UGo != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UGo);
      }
      paramInt = g.a.a.b.b.a.p(4, this.timestamp);
      AppMethodBeat.o(147800);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(147800);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fga localfga = (fga)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147800);
          return -1;
        case 1: 
          localfga.fuV = locala.abFh.readString();
          AppMethodBeat.o(147800);
          return 0;
        case 2: 
          localfga.fuW = locala.abFh.readString();
          AppMethodBeat.o(147800);
          return 0;
        case 3: 
          localfga.UGo = locala.abFh.readString();
          AppMethodBeat.o(147800);
          return 0;
        }
        localfga.timestamp = locala.abFh.AN();
        AppMethodBeat.o(147800);
        return 0;
      }
      AppMethodBeat.o(147800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fga
 * JD-Core Version:    0.7.0.1
 */