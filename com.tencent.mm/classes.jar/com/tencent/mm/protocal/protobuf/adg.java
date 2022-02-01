package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adg
  extends com.tencent.mm.cd.a
{
  public String RDj;
  public long SoQ;
  public int SpD;
  public boolean SpE;
  public int SpF;
  public boolean SpK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202940);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SoQ);
      if (this.RDj != null) {
        paramVarArgs.f(2, this.RDj);
      }
      paramVarArgs.aY(3, this.SpD);
      paramVarArgs.co(4, this.SpK);
      paramVarArgs.co(5, this.SpE);
      paramVarArgs.aY(6, this.SpF);
      AppMethodBeat.o(202940);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.SoQ) + 0;
      paramInt = i;
      if (this.RDj != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RDj);
      }
      i = g.a.a.b.b.a.bM(3, this.SpD);
      int j = g.a.a.b.b.a.gL(4);
      int k = g.a.a.b.b.a.gL(5);
      int m = g.a.a.b.b.a.bM(6, this.SpF);
      AppMethodBeat.o(202940);
      return paramInt + i + (j + 1) + (k + 1) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(202940);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      adg localadg = (adg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(202940);
        return -1;
      case 1: 
        localadg.SoQ = locala.abFh.AN();
        AppMethodBeat.o(202940);
        return 0;
      case 2: 
        localadg.RDj = locala.abFh.readString();
        AppMethodBeat.o(202940);
        return 0;
      case 3: 
        localadg.SpD = locala.abFh.AK();
        AppMethodBeat.o(202940);
        return 0;
      case 4: 
        localadg.SpK = locala.abFh.AB();
        AppMethodBeat.o(202940);
        return 0;
      case 5: 
        localadg.SpE = locala.abFh.AB();
        AppMethodBeat.o(202940);
        return 0;
      }
      localadg.SpF = locala.abFh.AK();
      AppMethodBeat.o(202940);
      return 0;
    }
    AppMethodBeat.o(202940);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adg
 * JD-Core Version:    0.7.0.1
 */