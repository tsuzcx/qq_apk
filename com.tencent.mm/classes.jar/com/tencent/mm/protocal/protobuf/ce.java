package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class ce
  extends com.tencent.mm.cd.a
{
  public long Crz;
  public int RHQ;
  public b RHR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125702);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RHQ);
      if (this.RHR != null) {
        paramVarArgs.c(2, this.RHR);
      }
      paramVarArgs.bm(3, this.Crz);
      AppMethodBeat.o(125702);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RHQ) + 0;
      paramInt = i;
      if (this.RHR != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.RHR);
      }
      i = g.a.a.b.b.a.p(3, this.Crz);
      AppMethodBeat.o(125702);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125702);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ce localce = (ce)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125702);
        return -1;
      case 1: 
        localce.RHQ = locala.abFh.AK();
        AppMethodBeat.o(125702);
        return 0;
      case 2: 
        localce.RHR = locala.abFh.iUw();
        AppMethodBeat.o(125702);
        return 0;
      }
      localce.Crz = locala.abFh.AN();
      AppMethodBeat.o(125702);
      return 0;
    }
    AppMethodBeat.o(125702);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ce
 * JD-Core Version:    0.7.0.1
 */