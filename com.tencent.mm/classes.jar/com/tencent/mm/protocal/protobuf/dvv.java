package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvv
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
  public int abbv;
  public int abbw;
  public String abbx;
  public int abby;
  public int abbz;
  public int mRN;
  public String nQG;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6412);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ADE != null) {
        paramVarArgs.g(1, this.ADE);
      }
      paramVarArgs.bS(2, this.abbv);
      paramVarArgs.bS(3, this.Caf);
      paramVarArgs.bS(4, this.abbw);
      paramVarArgs.bS(5, this.type);
      if (this.nQG != null) {
        paramVarArgs.g(6, this.nQG);
      }
      if (this.abbx != null) {
        paramVarArgs.g(7, this.abbx);
      }
      paramVarArgs.bS(8, this.abby);
      paramVarArgs.bS(9, this.abbz);
      paramVarArgs.bv(10, this.abbA);
      paramVarArgs.bS(11, this.abbB);
      paramVarArgs.bS(12, this.ZVE);
      if (this.abbC != null) {
        paramVarArgs.g(13, this.abbC);
      }
      paramVarArgs.bS(14, this.mRN);
      paramVarArgs.bS(15, this.abbD);
      paramVarArgs.bS(16, this.abbE);
      paramVarArgs.bS(17, this.abbF);
      AppMethodBeat.o(6412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ADE == null) {
        break label1001;
      }
    }
    label1001:
    for (paramInt = i.a.a.b.b.a.h(1, this.ADE) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abbv) + i.a.a.b.b.a.cJ(3, this.Caf) + i.a.a.b.b.a.cJ(4, this.abbw) + i.a.a.b.b.a.cJ(5, this.type);
      paramInt = i;
      if (this.nQG != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.nQG);
      }
      i = paramInt;
      if (this.abbx != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abbx);
      }
      i = i + i.a.a.b.b.a.cJ(8, this.abby) + i.a.a.b.b.a.cJ(9, this.abbz) + i.a.a.b.b.a.q(10, this.abbA) + i.a.a.b.b.a.cJ(11, this.abbB) + i.a.a.b.b.a.cJ(12, this.ZVE);
      paramInt = i;
      if (this.abbC != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.abbC);
      }
      i = i.a.a.b.b.a.cJ(14, this.mRN);
      int j = i.a.a.b.b.a.cJ(15, this.abbD);
      int k = i.a.a.b.b.a.cJ(16, this.abbE);
      int m = i.a.a.b.b.a.cJ(17, this.abbF);
      AppMethodBeat.o(6412);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(6412);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dvv localdvv = (dvv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6412);
          return -1;
        case 1: 
          localdvv.ADE = locala.ajGk.readString();
          AppMethodBeat.o(6412);
          return 0;
        case 2: 
          localdvv.abbv = locala.ajGk.aar();
          AppMethodBeat.o(6412);
          return 0;
        case 3: 
          localdvv.Caf = locala.ajGk.aar();
          AppMethodBeat.o(6412);
          return 0;
        case 4: 
          localdvv.abbw = locala.ajGk.aar();
          AppMethodBeat.o(6412);
          return 0;
        case 5: 
          localdvv.type = locala.ajGk.aar();
          AppMethodBeat.o(6412);
          return 0;
        case 6: 
          localdvv.nQG = locala.ajGk.readString();
          AppMethodBeat.o(6412);
          return 0;
        case 7: 
          localdvv.abbx = locala.ajGk.readString();
          AppMethodBeat.o(6412);
          return 0;
        case 8: 
          localdvv.abby = locala.ajGk.aar();
          AppMethodBeat.o(6412);
          return 0;
        case 9: 
          localdvv.abbz = locala.ajGk.aar();
          AppMethodBeat.o(6412);
          return 0;
        case 10: 
          localdvv.abbA = locala.ajGk.aaw();
          AppMethodBeat.o(6412);
          return 0;
        case 11: 
          localdvv.abbB = locala.ajGk.aar();
          AppMethodBeat.o(6412);
          return 0;
        case 12: 
          localdvv.ZVE = locala.ajGk.aar();
          AppMethodBeat.o(6412);
          return 0;
        case 13: 
          localdvv.abbC = locala.ajGk.readString();
          AppMethodBeat.o(6412);
          return 0;
        case 14: 
          localdvv.mRN = locala.ajGk.aar();
          AppMethodBeat.o(6412);
          return 0;
        case 15: 
          localdvv.abbD = locala.ajGk.aar();
          AppMethodBeat.o(6412);
          return 0;
        case 16: 
          localdvv.abbE = locala.ajGk.aar();
          AppMethodBeat.o(6412);
          return 0;
        }
        localdvv.abbF = locala.ajGk.aar();
        AppMethodBeat.o(6412);
        return 0;
      }
      AppMethodBeat.o(6412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvv
 * JD-Core Version:    0.7.0.1
 */