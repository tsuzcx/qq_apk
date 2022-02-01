package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgr
  extends com.tencent.mm.cd.a
{
  public int TNv;
  public int TNw;
  public String fUL;
  public String tpN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114046);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fUL != null) {
        paramVarArgs.f(1, this.fUL);
      }
      if (this.tpN != null) {
        paramVarArgs.f(2, this.tpN);
      }
      paramVarArgs.aY(3, this.TNv);
      paramVarArgs.aY(4, this.TNw);
      AppMethodBeat.o(114046);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fUL == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.g(1, this.fUL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tpN != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.tpN);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.TNv);
      int j = g.a.a.b.b.a.bM(4, this.TNw);
      AppMethodBeat.o(114046);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114046);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dgr localdgr = (dgr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114046);
          return -1;
        case 1: 
          localdgr.fUL = locala.abFh.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 2: 
          localdgr.tpN = locala.abFh.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 3: 
          localdgr.TNv = locala.abFh.AK();
          AppMethodBeat.o(114046);
          return 0;
        }
        localdgr.TNw = locala.abFh.AK();
        AppMethodBeat.o(114046);
        return 0;
      }
      AppMethodBeat.o(114046);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgr
 * JD-Core Version:    0.7.0.1
 */