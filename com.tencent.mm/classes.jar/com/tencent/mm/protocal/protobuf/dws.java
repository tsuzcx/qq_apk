package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dws
  extends com.tencent.mm.cd.a
{
  public int CRl;
  public String RTS;
  public boolean UcA;
  public boolean UcB;
  public int UcC;
  public boolean UcD;
  public long Ucy;
  public int Ucz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124546);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RTS != null) {
        paramVarArgs.f(1, this.RTS);
      }
      paramVarArgs.bm(2, this.Ucy);
      paramVarArgs.aY(3, this.Ucz);
      paramVarArgs.co(4, this.UcA);
      paramVarArgs.co(5, this.UcB);
      paramVarArgs.aY(6, this.UcC);
      paramVarArgs.aY(7, this.CRl);
      paramVarArgs.co(8, this.UcD);
      AppMethodBeat.o(124546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RTS == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = g.a.a.b.b.a.g(1, this.RTS) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.Ucy);
      int j = g.a.a.b.b.a.bM(3, this.Ucz);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.gL(5);
      int n = g.a.a.b.b.a.bM(6, this.UcC);
      int i1 = g.a.a.b.b.a.bM(7, this.CRl);
      int i2 = g.a.a.b.b.a.gL(8);
      AppMethodBeat.o(124546);
      return paramInt + i + j + (k + 1) + (m + 1) + n + i1 + (i2 + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124546);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dws localdws = (dws)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124546);
          return -1;
        case 1: 
          localdws.RTS = locala.abFh.readString();
          AppMethodBeat.o(124546);
          return 0;
        case 2: 
          localdws.Ucy = locala.abFh.AN();
          AppMethodBeat.o(124546);
          return 0;
        case 3: 
          localdws.Ucz = locala.abFh.AK();
          AppMethodBeat.o(124546);
          return 0;
        case 4: 
          localdws.UcA = locala.abFh.AB();
          AppMethodBeat.o(124546);
          return 0;
        case 5: 
          localdws.UcB = locala.abFh.AB();
          AppMethodBeat.o(124546);
          return 0;
        case 6: 
          localdws.UcC = locala.abFh.AK();
          AppMethodBeat.o(124546);
          return 0;
        case 7: 
          localdws.CRl = locala.abFh.AK();
          AppMethodBeat.o(124546);
          return 0;
        }
        localdws.UcD = locala.abFh.AB();
        AppMethodBeat.o(124546);
        return 0;
      }
      AppMethodBeat.o(124546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dws
 * JD-Core Version:    0.7.0.1
 */