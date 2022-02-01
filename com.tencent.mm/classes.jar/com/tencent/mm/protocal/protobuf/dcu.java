package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcu
  extends com.tencent.mm.cd.a
{
  public int TKF;
  public int TKG;
  public long lastReportTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222367);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TKF);
      paramVarArgs.bm(2, this.lastReportTime);
      paramVarArgs.aY(3, this.TKG);
      AppMethodBeat.o(222367);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.TKF);
      int i = g.a.a.b.b.a.p(2, this.lastReportTime);
      int j = g.a.a.b.b.a.bM(3, this.TKG);
      AppMethodBeat.o(222367);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(222367);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dcu localdcu = (dcu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(222367);
        return -1;
      case 1: 
        localdcu.TKF = locala.abFh.AK();
        AppMethodBeat.o(222367);
        return 0;
      case 2: 
        localdcu.lastReportTime = locala.abFh.AN();
        AppMethodBeat.o(222367);
        return 0;
      }
      localdcu.TKG = locala.abFh.AK();
      AppMethodBeat.o(222367);
      return 0;
    }
    AppMethodBeat.o(222367);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcu
 * JD-Core Version:    0.7.0.1
 */