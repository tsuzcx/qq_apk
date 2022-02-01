package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvy
  extends com.tencent.mm.bx.a
{
  public String ADE;
  public int Caf;
  public int ZVE;
  public long abbA;
  public int abbB;
  public String abbC;
  public int abbD;
  public int abbE;
  public int abbF;
  public int abbJ;
  public int abbv;
  public int abbw;
  public String abbx;
  public int abby;
  public int abbz;
  public int mRN;
  public String nQG;
  public int type;
  public int wri;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6416);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ADE != null) {
        paramVarArgs.g(1, this.ADE);
      }
      paramVarArgs.bS(2, this.abbv);
      paramVarArgs.bS(3, this.Caf);
      paramVarArgs.bS(4, this.abbw);
      paramVarArgs.bS(5, this.wri);
      paramVarArgs.bS(6, this.type);
      if (this.nQG != null) {
        paramVarArgs.g(7, this.nQG);
      }
      if (this.abbx != null) {
        paramVarArgs.g(8, this.abbx);
      }
      paramVarArgs.bS(9, this.abby);
      paramVarArgs.bS(10, this.abbz);
      paramVarArgs.bS(11, this.abbJ);
      paramVarArgs.bv(12, this.abbA);
      paramVarArgs.bS(13, this.abbB);
      paramVarArgs.bS(14, this.ZVE);
      if (this.abbC != null) {
        paramVarArgs.g(15, this.abbC);
      }
      paramVarArgs.bS(16, this.mRN);
      paramVarArgs.bS(17, this.abbD);
      paramVarArgs.bS(18, this.abbE);
      paramVarArgs.bS(19, this.abbF);
      AppMethodBeat.o(6416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ADE == null) {
        break label1091;
      }
    }
    label1091:
    for (paramInt = i.a.a.b.b.a.h(1, this.ADE) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abbv) + i.a.a.b.b.a.cJ(3, this.Caf) + i.a.a.b.b.a.cJ(4, this.abbw) + i.a.a.b.b.a.cJ(5, this.wri) + i.a.a.b.b.a.cJ(6, this.type);
      paramInt = i;
      if (this.nQG != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.nQG);
      }
      i = paramInt;
      if (this.abbx != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abbx);
      }
      i = i + i.a.a.b.b.a.cJ(9, this.abby) + i.a.a.b.b.a.cJ(10, this.abbz) + i.a.a.b.b.a.cJ(11, this.abbJ) + i.a.a.b.b.a.q(12, this.abbA) + i.a.a.b.b.a.cJ(13, this.abbB) + i.a.a.b.b.a.cJ(14, this.ZVE);
      paramInt = i;
      if (this.abbC != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.abbC);
      }
      i = i.a.a.b.b.a.cJ(16, this.mRN);
      int j = i.a.a.b.b.a.cJ(17, this.abbD);
      int k = i.a.a.b.b.a.cJ(18, this.abbE);
      int m = i.a.a.b.b.a.cJ(19, this.abbF);
      AppMethodBeat.o(6416);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(6416);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dvy localdvy = (dvy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6416);
          return -1;
        case 1: 
          localdvy.ADE = locala.ajGk.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 2: 
          localdvy.abbv = locala.ajGk.aar();
          AppMethodBeat.o(6416);
          return 0;
        case 3: 
          localdvy.Caf = locala.ajGk.aar();
          AppMethodBeat.o(6416);
          return 0;
        case 4: 
          localdvy.abbw = locala.ajGk.aar();
          AppMethodBeat.o(6416);
          return 0;
        case 5: 
          localdvy.wri = locala.ajGk.aar();
          AppMethodBeat.o(6416);
          return 0;
        case 6: 
          localdvy.type = locala.ajGk.aar();
          AppMethodBeat.o(6416);
          return 0;
        case 7: 
          localdvy.nQG = locala.ajGk.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 8: 
          localdvy.abbx = locala.ajGk.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 9: 
          localdvy.abby = locala.ajGk.aar();
          AppMethodBeat.o(6416);
          return 0;
        case 10: 
          localdvy.abbz = locala.ajGk.aar();
          AppMethodBeat.o(6416);
          return 0;
        case 11: 
          localdvy.abbJ = locala.ajGk.aar();
          AppMethodBeat.o(6416);
          return 0;
        case 12: 
          localdvy.abbA = locala.ajGk.aaw();
          AppMethodBeat.o(6416);
          return 0;
        case 13: 
          localdvy.abbB = locala.ajGk.aar();
          AppMethodBeat.o(6416);
          return 0;
        case 14: 
          localdvy.ZVE = locala.ajGk.aar();
          AppMethodBeat.o(6416);
          return 0;
        case 15: 
          localdvy.abbC = locala.ajGk.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 16: 
          localdvy.mRN = locala.ajGk.aar();
          AppMethodBeat.o(6416);
          return 0;
        case 17: 
          localdvy.abbD = locala.ajGk.aar();
          AppMethodBeat.o(6416);
          return 0;
        case 18: 
          localdvy.abbE = locala.ajGk.aar();
          AppMethodBeat.o(6416);
          return 0;
        }
        localdvy.abbF = locala.ajGk.aar();
        AppMethodBeat.o(6416);
        return 0;
      }
      AppMethodBeat.o(6416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvy
 * JD-Core Version:    0.7.0.1
 */