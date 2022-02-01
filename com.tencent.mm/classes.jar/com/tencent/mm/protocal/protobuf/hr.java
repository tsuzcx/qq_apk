package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hr
  extends com.tencent.mm.cd.a
{
  public String Id;
  public String RMW;
  public String RMX;
  public int RMY;
  public long RMZ;
  public int RNa;
  public long RNb;
  public long RNc;
  public long RNd;
  public String RNe;
  public long RNf;
  public double RNg;
  public int RNh;
  public String RNi;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87872);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.f(1, this.Id);
      }
      if (this.RMW != null) {
        paramVarArgs.f(2, this.RMW);
      }
      if (this.RMX != null) {
        paramVarArgs.f(3, this.RMX);
      }
      paramVarArgs.aY(4, this.RMY);
      paramVarArgs.bm(5, this.RMZ);
      paramVarArgs.aY(6, this.RNa);
      paramVarArgs.aY(7, this.rVU);
      paramVarArgs.bm(8, this.RNb);
      paramVarArgs.bm(9, this.RNc);
      paramVarArgs.bm(10, this.RNd);
      if (this.RNe != null) {
        paramVarArgs.f(11, this.RNe);
      }
      paramVarArgs.bm(12, this.RNf);
      paramVarArgs.e(13, this.RNg);
      paramVarArgs.aY(14, this.RNh);
      if (this.RNi != null) {
        paramVarArgs.f(15, this.RNi);
      }
      AppMethodBeat.o(87872);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label901;
      }
    }
    label901:
    for (int i = g.a.a.b.b.a.g(1, this.Id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RMW != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RMW);
      }
      i = paramInt;
      if (this.RMX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RMX);
      }
      i = i + g.a.a.b.b.a.bM(4, this.RMY) + g.a.a.b.b.a.p(5, this.RMZ) + g.a.a.b.b.a.bM(6, this.RNa) + g.a.a.b.b.a.bM(7, this.rVU) + g.a.a.b.b.a.p(8, this.RNb) + g.a.a.b.b.a.p(9, this.RNc) + g.a.a.b.b.a.p(10, this.RNd);
      paramInt = i;
      if (this.RNe != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.RNe);
      }
      i = paramInt + g.a.a.b.b.a.p(12, this.RNf) + (g.a.a.b.b.a.gL(13) + 8) + g.a.a.b.b.a.bM(14, this.RNh);
      paramInt = i;
      if (this.RNi != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.RNi);
      }
      AppMethodBeat.o(87872);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(87872);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        hr localhr = (hr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87872);
          return -1;
        case 1: 
          localhr.Id = locala.abFh.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 2: 
          localhr.RMW = locala.abFh.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 3: 
          localhr.RMX = locala.abFh.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 4: 
          localhr.RMY = locala.abFh.AK();
          AppMethodBeat.o(87872);
          return 0;
        case 5: 
          localhr.RMZ = locala.abFh.AN();
          AppMethodBeat.o(87872);
          return 0;
        case 6: 
          localhr.RNa = locala.abFh.AK();
          AppMethodBeat.o(87872);
          return 0;
        case 7: 
          localhr.rVU = locala.abFh.AK();
          AppMethodBeat.o(87872);
          return 0;
        case 8: 
          localhr.RNb = locala.abFh.AN();
          AppMethodBeat.o(87872);
          return 0;
        case 9: 
          localhr.RNc = locala.abFh.AN();
          AppMethodBeat.o(87872);
          return 0;
        case 10: 
          localhr.RNd = locala.abFh.AN();
          AppMethodBeat.o(87872);
          return 0;
        case 11: 
          localhr.RNe = locala.abFh.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 12: 
          localhr.RNf = locala.abFh.AN();
          AppMethodBeat.o(87872);
          return 0;
        case 13: 
          localhr.RNg = Double.longBitsToDouble(locala.abFh.AP());
          AppMethodBeat.o(87872);
          return 0;
        case 14: 
          localhr.RNh = locala.abFh.AK();
          AppMethodBeat.o(87872);
          return 0;
        }
        localhr.RNi = locala.abFh.readString();
        AppMethodBeat.o(87872);
        return 0;
      }
      AppMethodBeat.o(87872);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hr
 * JD-Core Version:    0.7.0.1
 */