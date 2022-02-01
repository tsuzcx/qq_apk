package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dal
  extends com.tencent.mm.cd.a
{
  public String FHt;
  public long Qoz;
  public String THF;
  public boolean THG;
  public String THH;
  public boolean THI;
  public boolean THJ;
  public int THK;
  public String nWv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205501);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.THF != null) {
        paramVarArgs.f(1, this.THF);
      }
      if (this.nWv != null) {
        paramVarArgs.f(2, this.nWv);
      }
      paramVarArgs.co(3, this.THG);
      if (this.THH != null) {
        paramVarArgs.f(4, this.THH);
      }
      if (this.FHt != null) {
        paramVarArgs.f(5, this.FHt);
      }
      paramVarArgs.co(6, this.THI);
      paramVarArgs.co(7, this.THJ);
      paramVarArgs.aY(8, this.THK);
      paramVarArgs.bm(9, this.Qoz);
      AppMethodBeat.o(205501);
      return 0;
    }
    if (paramInt == 1) {
      if (this.THF == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = g.a.a.b.b.a.g(1, this.THF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nWv != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.nWv);
      }
      i += g.a.a.b.b.a.gL(3) + 1;
      paramInt = i;
      if (this.THH != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.THH);
      }
      i = paramInt;
      if (this.FHt != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.FHt);
      }
      paramInt = g.a.a.b.b.a.gL(6);
      int j = g.a.a.b.b.a.gL(7);
      int k = g.a.a.b.b.a.bM(8, this.THK);
      int m = g.a.a.b.b.a.p(9, this.Qoz);
      AppMethodBeat.o(205501);
      return i + (paramInt + 1) + (j + 1) + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205501);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dal localdal = (dal)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205501);
          return -1;
        case 1: 
          localdal.THF = locala.abFh.readString();
          AppMethodBeat.o(205501);
          return 0;
        case 2: 
          localdal.nWv = locala.abFh.readString();
          AppMethodBeat.o(205501);
          return 0;
        case 3: 
          localdal.THG = locala.abFh.AB();
          AppMethodBeat.o(205501);
          return 0;
        case 4: 
          localdal.THH = locala.abFh.readString();
          AppMethodBeat.o(205501);
          return 0;
        case 5: 
          localdal.FHt = locala.abFh.readString();
          AppMethodBeat.o(205501);
          return 0;
        case 6: 
          localdal.THI = locala.abFh.AB();
          AppMethodBeat.o(205501);
          return 0;
        case 7: 
          localdal.THJ = locala.abFh.AB();
          AppMethodBeat.o(205501);
          return 0;
        case 8: 
          localdal.THK = locala.abFh.AK();
          AppMethodBeat.o(205501);
          return 0;
        }
        localdal.Qoz = locala.abFh.AN();
        AppMethodBeat.o(205501);
        return 0;
      }
      AppMethodBeat.o(205501);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dal
 * JD-Core Version:    0.7.0.1
 */