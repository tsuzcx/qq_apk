package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfk
  extends com.tencent.mm.bx.a
{
  public String CBj;
  public String CEQ;
  public String DCD;
  public String DCE;
  public int DCF;
  public int DCG;
  public int DCH;
  public int DCI;
  public String DCJ;
  public String DCK;
  public String DCL;
  public String DCM;
  public int DCN;
  public String IconUrl;
  public int eKr;
  public long eKs;
  public String eKt;
  public String eKu;
  public String eKv;
  public String eKw;
  public String ijR;
  public String rZo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DCD != null) {
        paramVarArgs.d(1, this.DCD);
      }
      if (this.CBj != null) {
        paramVarArgs.d(2, this.CBj);
      }
      if (this.CEQ != null) {
        paramVarArgs.d(3, this.CEQ);
      }
      if (this.DCE != null) {
        paramVarArgs.d(4, this.DCE);
      }
      paramVarArgs.aR(5, this.DCF);
      paramVarArgs.aR(6, this.DCG);
      paramVarArgs.aR(7, this.DCH);
      paramVarArgs.aR(8, this.DCI);
      if (this.DCJ != null) {
        paramVarArgs.d(9, this.DCJ);
      }
      if (this.ijR != null) {
        paramVarArgs.d(10, this.ijR);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(11, this.IconUrl);
      }
      if (this.rZo != null) {
        paramVarArgs.d(12, this.rZo);
      }
      if (this.DCK != null) {
        paramVarArgs.d(13, this.DCK);
      }
      if (this.DCL != null) {
        paramVarArgs.d(14, this.DCL);
      }
      if (this.DCM != null) {
        paramVarArgs.d(15, this.DCM);
      }
      paramVarArgs.aR(16, this.DCN);
      paramVarArgs.aR(17, this.eKr);
      paramVarArgs.aG(18, this.eKs);
      if (this.eKt != null) {
        paramVarArgs.d(19, this.eKt);
      }
      if (this.eKu != null) {
        paramVarArgs.d(20, this.eKu);
      }
      if (this.eKv != null) {
        paramVarArgs.d(21, this.eKv);
      }
      if (this.eKw != null) {
        paramVarArgs.d(22, this.eKw);
      }
      AppMethodBeat.o(82425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DCD == null) {
        break label1386;
      }
    }
    label1386:
    for (int i = f.a.a.b.b.a.e(1, this.DCD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CBj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CBj);
      }
      i = paramInt;
      if (this.CEQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CEQ);
      }
      paramInt = i;
      if (this.DCE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DCE);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.DCF) + f.a.a.b.b.a.bA(6, this.DCG) + f.a.a.b.b.a.bA(7, this.DCH) + f.a.a.b.b.a.bA(8, this.DCI);
      paramInt = i;
      if (this.DCJ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DCJ);
      }
      i = paramInt;
      if (this.ijR != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.ijR);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.IconUrl);
      }
      i = paramInt;
      if (this.rZo != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.rZo);
      }
      paramInt = i;
      if (this.DCK != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DCK);
      }
      i = paramInt;
      if (this.DCL != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.DCL);
      }
      paramInt = i;
      if (this.DCM != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.DCM);
      }
      i = paramInt + f.a.a.b.b.a.bA(16, this.DCN) + f.a.a.b.b.a.bA(17, this.eKr) + f.a.a.b.b.a.q(18, this.eKs);
      paramInt = i;
      if (this.eKt != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.eKt);
      }
      i = paramInt;
      if (this.eKu != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.eKu);
      }
      paramInt = i;
      if (this.eKv != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.eKv);
      }
      i = paramInt;
      if (this.eKw != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.eKw);
      }
      AppMethodBeat.o(82425);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82425);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bfk localbfk = (bfk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82425);
          return -1;
        case 1: 
          localbfk.DCD = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 2: 
          localbfk.CBj = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 3: 
          localbfk.CEQ = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 4: 
          localbfk.DCE = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 5: 
          localbfk.DCF = locala.KhF.xS();
          AppMethodBeat.o(82425);
          return 0;
        case 6: 
          localbfk.DCG = locala.KhF.xS();
          AppMethodBeat.o(82425);
          return 0;
        case 7: 
          localbfk.DCH = locala.KhF.xS();
          AppMethodBeat.o(82425);
          return 0;
        case 8: 
          localbfk.DCI = locala.KhF.xS();
          AppMethodBeat.o(82425);
          return 0;
        case 9: 
          localbfk.DCJ = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 10: 
          localbfk.ijR = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 11: 
          localbfk.IconUrl = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 12: 
          localbfk.rZo = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 13: 
          localbfk.DCK = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 14: 
          localbfk.DCL = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 15: 
          localbfk.DCM = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 16: 
          localbfk.DCN = locala.KhF.xS();
          AppMethodBeat.o(82425);
          return 0;
        case 17: 
          localbfk.eKr = locala.KhF.xS();
          AppMethodBeat.o(82425);
          return 0;
        case 18: 
          localbfk.eKs = locala.KhF.xT();
          AppMethodBeat.o(82425);
          return 0;
        case 19: 
          localbfk.eKt = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 20: 
          localbfk.eKu = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        case 21: 
          localbfk.eKv = locala.KhF.readString();
          AppMethodBeat.o(82425);
          return 0;
        }
        localbfk.eKw = locala.KhF.readString();
        AppMethodBeat.o(82425);
        return 0;
      }
      AppMethodBeat.o(82425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfk
 * JD-Core Version:    0.7.0.1
 */