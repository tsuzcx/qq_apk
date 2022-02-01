package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dea
  extends com.tencent.mm.cd.a
{
  public int CLe;
  public String RVH;
  public int TLA;
  public long TLB;
  public int TLC;
  public int TLD;
  public String TLE;
  public int TLI;
  public int TLw;
  public int TLx;
  public String TLy;
  public int TLz;
  public int knL;
  public String llI;
  public int tmI;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RVH != null) {
        paramVarArgs.f(1, this.RVH);
      }
      paramVarArgs.aY(2, this.TLw);
      paramVarArgs.aY(3, this.CLe);
      paramVarArgs.aY(4, this.TLx);
      paramVarArgs.aY(5, this.tmI);
      paramVarArgs.aY(6, this.type);
      if (this.llI != null) {
        paramVarArgs.f(7, this.llI);
      }
      if (this.TLy != null) {
        paramVarArgs.f(8, this.TLy);
      }
      paramVarArgs.aY(9, this.TLz);
      paramVarArgs.aY(10, this.TLA);
      paramVarArgs.aY(11, this.TLI);
      paramVarArgs.bm(12, this.TLB);
      paramVarArgs.aY(13, this.TLC);
      paramVarArgs.aY(14, this.TLD);
      if (this.TLE != null) {
        paramVarArgs.f(15, this.TLE);
      }
      paramVarArgs.aY(16, this.knL);
      AppMethodBeat.o(6416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RVH == null) {
        break label948;
      }
    }
    label948:
    for (paramInt = g.a.a.b.b.a.g(1, this.RVH) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TLw) + g.a.a.b.b.a.bM(3, this.CLe) + g.a.a.b.b.a.bM(4, this.TLx) + g.a.a.b.b.a.bM(5, this.tmI) + g.a.a.b.b.a.bM(6, this.type);
      paramInt = i;
      if (this.llI != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.llI);
      }
      i = paramInt;
      if (this.TLy != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TLy);
      }
      i = i + g.a.a.b.b.a.bM(9, this.TLz) + g.a.a.b.b.a.bM(10, this.TLA) + g.a.a.b.b.a.bM(11, this.TLI) + g.a.a.b.b.a.p(12, this.TLB) + g.a.a.b.b.a.bM(13, this.TLC) + g.a.a.b.b.a.bM(14, this.TLD);
      paramInt = i;
      if (this.TLE != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.TLE);
      }
      i = g.a.a.b.b.a.bM(16, this.knL);
      AppMethodBeat.o(6416);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(6416);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dea localdea = (dea)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6416);
          return -1;
        case 1: 
          localdea.RVH = locala.abFh.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 2: 
          localdea.TLw = locala.abFh.AK();
          AppMethodBeat.o(6416);
          return 0;
        case 3: 
          localdea.CLe = locala.abFh.AK();
          AppMethodBeat.o(6416);
          return 0;
        case 4: 
          localdea.TLx = locala.abFh.AK();
          AppMethodBeat.o(6416);
          return 0;
        case 5: 
          localdea.tmI = locala.abFh.AK();
          AppMethodBeat.o(6416);
          return 0;
        case 6: 
          localdea.type = locala.abFh.AK();
          AppMethodBeat.o(6416);
          return 0;
        case 7: 
          localdea.llI = locala.abFh.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 8: 
          localdea.TLy = locala.abFh.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 9: 
          localdea.TLz = locala.abFh.AK();
          AppMethodBeat.o(6416);
          return 0;
        case 10: 
          localdea.TLA = locala.abFh.AK();
          AppMethodBeat.o(6416);
          return 0;
        case 11: 
          localdea.TLI = locala.abFh.AK();
          AppMethodBeat.o(6416);
          return 0;
        case 12: 
          localdea.TLB = locala.abFh.AN();
          AppMethodBeat.o(6416);
          return 0;
        case 13: 
          localdea.TLC = locala.abFh.AK();
          AppMethodBeat.o(6416);
          return 0;
        case 14: 
          localdea.TLD = locala.abFh.AK();
          AppMethodBeat.o(6416);
          return 0;
        case 15: 
          localdea.TLE = locala.abFh.readString();
          AppMethodBeat.o(6416);
          return 0;
        }
        localdea.knL = locala.abFh.AK();
        AppMethodBeat.o(6416);
        return 0;
      }
      AppMethodBeat.o(6416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dea
 * JD-Core Version:    0.7.0.1
 */