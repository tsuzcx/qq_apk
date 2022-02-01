package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpq
  extends com.tencent.mm.cd.a
{
  public int DPO;
  public String DPP;
  public int TWA;
  public int TWB;
  public int TWC;
  public int vht;
  public String vhu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32392);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TWB);
      paramVarArgs.aY(2, this.TWC);
      paramVarArgs.aY(3, this.TWA);
      paramVarArgs.aY(4, this.vht);
      if (this.vhu != null) {
        paramVarArgs.f(5, this.vhu);
      }
      paramVarArgs.aY(6, this.DPO);
      if (this.DPP != null) {
        paramVarArgs.f(7, this.DPP);
      }
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.TWB) + 0 + g.a.a.b.b.a.bM(2, this.TWC) + g.a.a.b.b.a.bM(3, this.TWA) + g.a.a.b.b.a.bM(4, this.vht);
      paramInt = i;
      if (this.vhu != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.vhu);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.DPO);
      paramInt = i;
      if (this.DPP != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.DPP);
      }
      AppMethodBeat.o(32392);
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
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dpq localdpq = (dpq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32392);
        return -1;
      case 1: 
        localdpq.TWB = locala.abFh.AK();
        AppMethodBeat.o(32392);
        return 0;
      case 2: 
        localdpq.TWC = locala.abFh.AK();
        AppMethodBeat.o(32392);
        return 0;
      case 3: 
        localdpq.TWA = locala.abFh.AK();
        AppMethodBeat.o(32392);
        return 0;
      case 4: 
        localdpq.vht = locala.abFh.AK();
        AppMethodBeat.o(32392);
        return 0;
      case 5: 
        localdpq.vhu = locala.abFh.readString();
        AppMethodBeat.o(32392);
        return 0;
      case 6: 
        localdpq.DPO = locala.abFh.AK();
        AppMethodBeat.o(32392);
        return 0;
      }
      localdpq.DPP = locala.abFh.readString();
      AppMethodBeat.o(32392);
      return 0;
    }
    AppMethodBeat.o(32392);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpq
 * JD-Core Version:    0.7.0.1
 */