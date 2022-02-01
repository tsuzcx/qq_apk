package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxa
  extends com.tencent.mm.bw.a
{
  public int GuU;
  public String HjO;
  public String HjP;
  public String HjQ;
  public String HjR;
  public int HjS;
  public String HjT;
  public int HjU;
  public int HjV;
  public String HjW;
  public int HjX;
  public int HjY;
  public String HjZ;
  public int Hka;
  public int Hkb;
  public String Hkc;
  public String Hkd;
  public String Hke;
  public String Hkf;
  public String dwb;
  public String pqV;
  public int pqY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152627);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwb != null) {
        paramVarArgs.d(1, this.dwb);
      }
      if (this.HjO != null) {
        paramVarArgs.d(20, this.HjO);
      }
      if (this.HjP != null) {
        paramVarArgs.d(21, this.HjP);
      }
      if (this.HjQ != null) {
        paramVarArgs.d(22, this.HjQ);
      }
      if (this.HjR != null) {
        paramVarArgs.d(23, this.HjR);
      }
      if (this.pqV != null) {
        paramVarArgs.d(31, this.pqV);
      }
      paramVarArgs.aS(32, this.pqY);
      paramVarArgs.aS(33, this.HjS);
      if (this.HjT != null) {
        paramVarArgs.d(34, this.HjT);
      }
      paramVarArgs.aS(35, this.HjU);
      paramVarArgs.aS(36, this.HjV);
      if (this.HjW != null) {
        paramVarArgs.d(37, this.HjW);
      }
      paramVarArgs.aS(38, this.HjX);
      paramVarArgs.aS(39, this.HjY);
      if (this.HjZ != null) {
        paramVarArgs.d(41, this.HjZ);
      }
      paramVarArgs.aS(200, this.Hka);
      paramVarArgs.aS(201, this.Hkb);
      paramVarArgs.aS(202, this.GuU);
      if (this.Hkc != null) {
        paramVarArgs.d(203, this.Hkc);
      }
      if (this.Hkd != null) {
        paramVarArgs.d(204, this.Hkd);
      }
      if (this.Hke != null) {
        paramVarArgs.d(205, this.Hke);
      }
      if (this.Hkf != null) {
        paramVarArgs.d(206, this.Hkf);
      }
      AppMethodBeat.o(152627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwb == null) {
        break label1462;
      }
    }
    label1462:
    for (int i = f.a.a.b.b.a.e(1, this.dwb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HjO != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.HjO);
      }
      i = paramInt;
      if (this.HjP != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.HjP);
      }
      paramInt = i;
      if (this.HjQ != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.HjQ);
      }
      i = paramInt;
      if (this.HjR != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.HjR);
      }
      paramInt = i;
      if (this.pqV != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.pqV);
      }
      i = paramInt + f.a.a.b.b.a.bz(32, this.pqY) + f.a.a.b.b.a.bz(33, this.HjS);
      paramInt = i;
      if (this.HjT != null) {
        paramInt = i + f.a.a.b.b.a.e(34, this.HjT);
      }
      i = paramInt + f.a.a.b.b.a.bz(35, this.HjU) + f.a.a.b.b.a.bz(36, this.HjV);
      paramInt = i;
      if (this.HjW != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.HjW);
      }
      i = paramInt + f.a.a.b.b.a.bz(38, this.HjX) + f.a.a.b.b.a.bz(39, this.HjY);
      paramInt = i;
      if (this.HjZ != null) {
        paramInt = i + f.a.a.b.b.a.e(41, this.HjZ);
      }
      i = paramInt + f.a.a.b.b.a.bz(200, this.Hka) + f.a.a.b.b.a.bz(201, this.Hkb) + f.a.a.b.b.a.bz(202, this.GuU);
      paramInt = i;
      if (this.Hkc != null) {
        paramInt = i + f.a.a.b.b.a.e(203, this.Hkc);
      }
      i = paramInt;
      if (this.Hkd != null) {
        i = paramInt + f.a.a.b.b.a.e(204, this.Hkd);
      }
      paramInt = i;
      if (this.Hke != null) {
        paramInt = i + f.a.a.b.b.a.e(205, this.Hke);
      }
      i = paramInt;
      if (this.Hkf != null) {
        i = paramInt + f.a.a.b.b.a.e(206, this.Hkf);
      }
      AppMethodBeat.o(152627);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152627);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxa localbxa = (bxa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152627);
          return -1;
        case 1: 
          localbxa.dwb = locala.OmT.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 20: 
          localbxa.HjO = locala.OmT.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 21: 
          localbxa.HjP = locala.OmT.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 22: 
          localbxa.HjQ = locala.OmT.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 23: 
          localbxa.HjR = locala.OmT.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 31: 
          localbxa.pqV = locala.OmT.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 32: 
          localbxa.pqY = locala.OmT.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 33: 
          localbxa.HjS = locala.OmT.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 34: 
          localbxa.HjT = locala.OmT.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 35: 
          localbxa.HjU = locala.OmT.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 36: 
          localbxa.HjV = locala.OmT.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 37: 
          localbxa.HjW = locala.OmT.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 38: 
          localbxa.HjX = locala.OmT.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 39: 
          localbxa.HjY = locala.OmT.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 41: 
          localbxa.HjZ = locala.OmT.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 200: 
          localbxa.Hka = locala.OmT.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 201: 
          localbxa.Hkb = locala.OmT.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 202: 
          localbxa.GuU = locala.OmT.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 203: 
          localbxa.Hkc = locala.OmT.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 204: 
          localbxa.Hkd = locala.OmT.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 205: 
          localbxa.Hke = locala.OmT.readString();
          AppMethodBeat.o(152627);
          return 0;
        }
        localbxa.Hkf = locala.OmT.readString();
        AppMethodBeat.o(152627);
        return 0;
      }
      AppMethodBeat.o(152627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxa
 * JD-Core Version:    0.7.0.1
 */