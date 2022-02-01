package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class c
  extends com.tencent.mm.cd.a
{
  public int FlL;
  public int FlM;
  public long FlN;
  public long FlO;
  public double FlP;
  public String FlQ;
  public b FlR;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187542);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      paramVarArgs.aY(2, this.FlL);
      paramVarArgs.aY(3, this.FlM);
      paramVarArgs.bm(4, this.FlN);
      paramVarArgs.bm(5, this.FlO);
      paramVarArgs.e(6, this.FlP);
      if (this.FlQ != null) {
        paramVarArgs.f(7, this.FlQ);
      }
      if (this.FlR != null) {
        paramVarArgs.c(8, this.FlR);
      }
      AppMethodBeat.o(187542);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0 + g.a.a.b.b.a.bM(2, this.FlL) + g.a.a.b.b.a.bM(3, this.FlM) + g.a.a.b.b.a.p(4, this.FlN) + g.a.a.b.b.a.p(5, this.FlO) + (g.a.a.b.b.a.gL(6) + 8);
      paramInt = i;
      if (this.FlQ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.FlQ);
      }
      i = paramInt;
      if (this.FlR != null) {
        i = paramInt + g.a.a.b.b.a.b(8, this.FlR);
      }
      AppMethodBeat.o(187542);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(187542);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(187542);
        return -1;
      case 1: 
        localc.type = locala.abFh.AK();
        AppMethodBeat.o(187542);
        return 0;
      case 2: 
        localc.FlL = locala.abFh.AK();
        AppMethodBeat.o(187542);
        return 0;
      case 3: 
        localc.FlM = locala.abFh.AK();
        AppMethodBeat.o(187542);
        return 0;
      case 4: 
        localc.FlN = locala.abFh.AN();
        AppMethodBeat.o(187542);
        return 0;
      case 5: 
        localc.FlO = locala.abFh.AN();
        AppMethodBeat.o(187542);
        return 0;
      case 6: 
        localc.FlP = Double.longBitsToDouble(locala.abFh.AP());
        AppMethodBeat.o(187542);
        return 0;
      case 7: 
        localc.FlQ = locala.abFh.readString();
        AppMethodBeat.o(187542);
        return 0;
      }
      localc.FlR = locala.abFh.iUw();
      AppMethodBeat.o(187542);
      return 0;
    }
    AppMethodBeat.o(187542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.c
 * JD-Core Version:    0.7.0.1
 */