package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hd
  extends com.tencent.mm.cd.a
{
  public int PbQ;
  public boolean RMs;
  public String RMt;
  public String fHc;
  public String fHd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19404);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.RMs);
      paramVarArgs.aY(2, this.PbQ);
      if (this.fHc != null) {
        paramVarArgs.f(3, this.fHc);
      }
      if (this.fHd != null) {
        paramVarArgs.f(4, this.fHd);
      }
      if (this.RMt != null) {
        paramVarArgs.f(5, this.RMt);
      }
      AppMethodBeat.o(19404);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0 + g.a.a.b.b.a.bM(2, this.PbQ);
      paramInt = i;
      if (this.fHc != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fHc);
      }
      i = paramInt;
      if (this.fHd != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.fHd);
      }
      paramInt = i;
      if (this.RMt != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RMt);
      }
      AppMethodBeat.o(19404);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(19404);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      hd localhd = (hd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(19404);
        return -1;
      case 1: 
        localhd.RMs = locala.abFh.AB();
        AppMethodBeat.o(19404);
        return 0;
      case 2: 
        localhd.PbQ = locala.abFh.AK();
        AppMethodBeat.o(19404);
        return 0;
      case 3: 
        localhd.fHc = locala.abFh.readString();
        AppMethodBeat.o(19404);
        return 0;
      case 4: 
        localhd.fHd = locala.abFh.readString();
        AppMethodBeat.o(19404);
        return 0;
      }
      localhd.RMt = locala.abFh.readString();
      AppMethodBeat.o(19404);
      return 0;
    }
    AppMethodBeat.o(19404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hd
 * JD-Core Version:    0.7.0.1
 */