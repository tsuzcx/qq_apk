package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edt
  extends com.tencent.mm.bw.a
{
  public String Id;
  public int Mcw;
  public int MsA;
  public int MsK;
  public long MsL;
  public String MsM;
  public int MsN;
  public String MsO;
  public String MsP;
  public int MsQ;
  public String MsR;
  public String MsS;
  public String Msz;
  public float Ned;
  public String Url;
  public int ecf;
  public String md5;
  public int oUv;
  public int subType;
  public String taskId;
  public String viB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118454);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.e(1, this.Id);
      }
      paramVarArgs.aM(2, this.oUv);
      if (this.Url != null) {
        paramVarArgs.e(3, this.Url);
      }
      paramVarArgs.aM(4, this.Mcw);
      if (this.Msz != null) {
        paramVarArgs.e(5, this.Msz);
      }
      paramVarArgs.aM(6, this.MsA);
      paramVarArgs.aM(7, this.subType);
      if (this.md5 != null) {
        paramVarArgs.e(8, this.md5);
      }
      if (this.MsS != null) {
        paramVarArgs.e(9, this.MsS);
      }
      paramVarArgs.aM(10, this.ecf);
      paramVarArgs.aM(11, this.MsK);
      paramVarArgs.bb(12, this.MsL);
      if (this.MsM != null) {
        paramVarArgs.e(13, this.MsM);
      }
      if (this.viB != null) {
        paramVarArgs.e(14, this.viB);
      }
      paramVarArgs.aM(15, this.MsN);
      if (this.MsO != null) {
        paramVarArgs.e(16, this.MsO);
      }
      if (this.MsP != null) {
        paramVarArgs.e(17, this.MsP);
      }
      paramVarArgs.aM(18, this.MsQ);
      if (this.MsR != null) {
        paramVarArgs.e(19, this.MsR);
      }
      paramVarArgs.E(20, this.Ned);
      if (this.taskId != null) {
        paramVarArgs.e(21, this.taskId);
      }
      AppMethodBeat.o(118454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label1281;
      }
    }
    label1281:
    for (paramInt = g.a.a.b.b.a.f(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUv);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Url);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.Mcw);
      paramInt = i;
      if (this.Msz != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Msz);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.MsA) + g.a.a.b.b.a.bu(7, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.md5);
      }
      i = paramInt;
      if (this.MsS != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.MsS);
      }
      i = i + g.a.a.b.b.a.bu(10, this.ecf) + g.a.a.b.b.a.bu(11, this.MsK) + g.a.a.b.b.a.r(12, this.MsL);
      paramInt = i;
      if (this.MsM != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.MsM);
      }
      i = paramInt;
      if (this.viB != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.viB);
      }
      i += g.a.a.b.b.a.bu(15, this.MsN);
      paramInt = i;
      if (this.MsO != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.MsO);
      }
      i = paramInt;
      if (this.MsP != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.MsP);
      }
      i += g.a.a.b.b.a.bu(18, this.MsQ);
      paramInt = i;
      if (this.MsR != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.MsR);
      }
      i = paramInt + (g.a.a.b.b.a.fS(20) + 4);
      paramInt = i;
      if (this.taskId != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.taskId);
      }
      AppMethodBeat.o(118454);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(118454);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        edt localedt = (edt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118454);
          return -1;
        case 1: 
          localedt.Id = locala.UbS.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 2: 
          localedt.oUv = locala.UbS.zi();
          AppMethodBeat.o(118454);
          return 0;
        case 3: 
          localedt.Url = locala.UbS.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 4: 
          localedt.Mcw = locala.UbS.zi();
          AppMethodBeat.o(118454);
          return 0;
        case 5: 
          localedt.Msz = locala.UbS.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 6: 
          localedt.MsA = locala.UbS.zi();
          AppMethodBeat.o(118454);
          return 0;
        case 7: 
          localedt.subType = locala.UbS.zi();
          AppMethodBeat.o(118454);
          return 0;
        case 8: 
          localedt.md5 = locala.UbS.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 9: 
          localedt.MsS = locala.UbS.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 10: 
          localedt.ecf = locala.UbS.zi();
          AppMethodBeat.o(118454);
          return 0;
        case 11: 
          localedt.MsK = locala.UbS.zi();
          AppMethodBeat.o(118454);
          return 0;
        case 12: 
          localedt.MsL = locala.UbS.zl();
          AppMethodBeat.o(118454);
          return 0;
        case 13: 
          localedt.MsM = locala.UbS.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 14: 
          localedt.viB = locala.UbS.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 15: 
          localedt.MsN = locala.UbS.zi();
          AppMethodBeat.o(118454);
          return 0;
        case 16: 
          localedt.MsO = locala.UbS.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 17: 
          localedt.MsP = locala.UbS.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 18: 
          localedt.MsQ = locala.UbS.zi();
          AppMethodBeat.o(118454);
          return 0;
        case 19: 
          localedt.MsR = locala.UbS.readString();
          AppMethodBeat.o(118454);
          return 0;
        case 20: 
          localedt.Ned = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(118454);
          return 0;
        }
        localedt.taskId = locala.UbS.readString();
        AppMethodBeat.o(118454);
        return 0;
      }
      AppMethodBeat.o(118454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edt
 * JD-Core Version:    0.7.0.1
 */