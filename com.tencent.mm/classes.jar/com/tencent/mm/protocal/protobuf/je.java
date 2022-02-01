package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class je
  extends com.tencent.mm.bw.a
{
  public String HQc;
  public String KNH;
  public String KNI;
  public String KNJ;
  public boolean KNK;
  public String KNL;
  public String dDj;
  public String qcN;
  public String ynT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72419);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ynT != null) {
        paramVarArgs.e(1, this.ynT);
      }
      if (this.dDj != null) {
        paramVarArgs.e(2, this.dDj);
      }
      if (this.qcN != null) {
        paramVarArgs.e(3, this.qcN);
      }
      if (this.HQc != null) {
        paramVarArgs.e(4, this.HQc);
      }
      if (this.KNH != null) {
        paramVarArgs.e(5, this.KNH);
      }
      if (this.KNI != null) {
        paramVarArgs.e(6, this.KNI);
      }
      if (this.KNJ != null) {
        paramVarArgs.e(8, this.KNJ);
      }
      paramVarArgs.cc(9, this.KNK);
      if (this.KNL != null) {
        paramVarArgs.e(10, this.KNL);
      }
      AppMethodBeat.o(72419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ynT == null) {
        break label690;
      }
    }
    label690:
    for (int i = g.a.a.b.b.a.f(1, this.ynT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dDj != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dDj);
      }
      i = paramInt;
      if (this.qcN != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qcN);
      }
      paramInt = i;
      if (this.HQc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.HQc);
      }
      i = paramInt;
      if (this.KNH != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KNH);
      }
      paramInt = i;
      if (this.KNI != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KNI);
      }
      i = paramInt;
      if (this.KNJ != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.KNJ);
      }
      i += g.a.a.b.b.a.fS(9) + 1;
      paramInt = i;
      if (this.KNL != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KNL);
      }
      AppMethodBeat.o(72419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72419);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        je localje = (je)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          AppMethodBeat.o(72419);
          return -1;
        case 1: 
          localje.ynT = locala.UbS.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 2: 
          localje.dDj = locala.UbS.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 3: 
          localje.qcN = locala.UbS.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 4: 
          localje.HQc = locala.UbS.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 5: 
          localje.KNH = locala.UbS.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 6: 
          localje.KNI = locala.UbS.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 8: 
          localje.KNJ = locala.UbS.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 9: 
          localje.KNK = locala.UbS.yZ();
          AppMethodBeat.o(72419);
          return 0;
        }
        localje.KNL = locala.UbS.readString();
        AppMethodBeat.o(72419);
        return 0;
      }
      AppMethodBeat.o(72419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.je
 * JD-Core Version:    0.7.0.1
 */