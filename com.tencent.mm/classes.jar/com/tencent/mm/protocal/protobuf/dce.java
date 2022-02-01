package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dce
  extends com.tencent.mm.cd.a
{
  public int COi;
  public String CRQ;
  public String CRR;
  public int HlE;
  public long HlH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43113);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CRR != null) {
        paramVarArgs.f(1, this.CRR);
      }
      if (this.CRQ != null) {
        paramVarArgs.f(2, this.CRQ);
      }
      paramVarArgs.aY(3, this.HlE);
      paramVarArgs.aY(4, this.COi);
      paramVarArgs.bm(5, this.HlH);
      AppMethodBeat.o(43113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CRR == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = g.a.a.b.b.a.g(1, this.CRR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CRQ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CRQ);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.HlE);
      int j = g.a.a.b.b.a.bM(4, this.COi);
      int k = g.a.a.b.b.a.p(5, this.HlH);
      AppMethodBeat.o(43113);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(43113);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dce localdce = (dce)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43113);
          return -1;
        case 1: 
          localdce.CRR = locala.abFh.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 2: 
          localdce.CRQ = locala.abFh.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 3: 
          localdce.HlE = locala.abFh.AK();
          AppMethodBeat.o(43113);
          return 0;
        case 4: 
          localdce.COi = locala.abFh.AK();
          AppMethodBeat.o(43113);
          return 0;
        }
        localdce.HlH = locala.abFh.AN();
        AppMethodBeat.o(43113);
        return 0;
      }
      AppMethodBeat.o(43113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dce
 * JD-Core Version:    0.7.0.1
 */