package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efh
  extends com.tencent.mm.bw.a
{
  public String NfC;
  public String NfD;
  public String jyH;
  public String jyI;
  public String jyJ;
  public String jyK;
  public String jyL;
  public String jyM;
  public String jyN;
  public String jyO;
  public String jyP;
  public String jyQ;
  public String jyR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152710);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jyH != null) {
        paramVarArgs.e(1, this.jyH);
      }
      if (this.jyI != null) {
        paramVarArgs.e(2, this.jyI);
      }
      if (this.jyJ != null) {
        paramVarArgs.e(3, this.jyJ);
      }
      if (this.jyK != null) {
        paramVarArgs.e(4, this.jyK);
      }
      if (this.jyL != null) {
        paramVarArgs.e(5, this.jyL);
      }
      if (this.jyM != null) {
        paramVarArgs.e(6, this.jyM);
      }
      if (this.jyN != null) {
        paramVarArgs.e(7, this.jyN);
      }
      if (this.jyO != null) {
        paramVarArgs.e(8, this.jyO);
      }
      if (this.jyP != null) {
        paramVarArgs.e(9, this.jyP);
      }
      if (this.jyQ != null) {
        paramVarArgs.e(10, this.jyQ);
      }
      if (this.jyR != null) {
        paramVarArgs.e(11, this.jyR);
      }
      if (this.NfC != null) {
        paramVarArgs.e(12, this.NfC);
      }
      if (this.NfD != null) {
        paramVarArgs.e(13, this.NfD);
      }
      AppMethodBeat.o(152710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jyH == null) {
        break label950;
      }
    }
    label950:
    for (int i = g.a.a.b.b.a.f(1, this.jyH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jyI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jyI);
      }
      i = paramInt;
      if (this.jyJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.jyJ);
      }
      paramInt = i;
      if (this.jyK != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.jyK);
      }
      i = paramInt;
      if (this.jyL != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.jyL);
      }
      paramInt = i;
      if (this.jyM != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.jyM);
      }
      i = paramInt;
      if (this.jyN != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.jyN);
      }
      paramInt = i;
      if (this.jyO != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.jyO);
      }
      i = paramInt;
      if (this.jyP != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.jyP);
      }
      paramInt = i;
      if (this.jyQ != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.jyQ);
      }
      i = paramInt;
      if (this.jyR != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.jyR);
      }
      paramInt = i;
      if (this.NfC != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.NfC);
      }
      i = paramInt;
      if (this.NfD != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.NfD);
      }
      AppMethodBeat.o(152710);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152710);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        efh localefh = (efh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152710);
          return -1;
        case 1: 
          localefh.jyH = locala.UbS.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 2: 
          localefh.jyI = locala.UbS.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 3: 
          localefh.jyJ = locala.UbS.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 4: 
          localefh.jyK = locala.UbS.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 5: 
          localefh.jyL = locala.UbS.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 6: 
          localefh.jyM = locala.UbS.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 7: 
          localefh.jyN = locala.UbS.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 8: 
          localefh.jyO = locala.UbS.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 9: 
          localefh.jyP = locala.UbS.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 10: 
          localefh.jyQ = locala.UbS.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 11: 
          localefh.jyR = locala.UbS.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 12: 
          localefh.NfC = locala.UbS.readString();
          AppMethodBeat.o(152710);
          return 0;
        }
        localefh.NfD = locala.UbS.readString();
        AppMethodBeat.o(152710);
        return 0;
      }
      AppMethodBeat.o(152710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efh
 * JD-Core Version:    0.7.0.1
 */