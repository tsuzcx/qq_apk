package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnd
  extends com.tencent.mm.bx.a
{
  public int DKA;
  public String DKB;
  public int DKC;
  public int DKD;
  public String DKE;
  public int DKF;
  public int DKG;
  public String DKH;
  public int DKI;
  public int DKJ;
  public String DKK;
  public String DKL;
  public String DKM;
  public String DKN;
  public String DKw;
  public String DKx;
  public String DKy;
  public String DKz;
  public int DbN;
  public String dlB;
  public String odn;
  public int odq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152627);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      if (this.DKw != null) {
        paramVarArgs.d(20, this.DKw);
      }
      if (this.DKx != null) {
        paramVarArgs.d(21, this.DKx);
      }
      if (this.DKy != null) {
        paramVarArgs.d(22, this.DKy);
      }
      if (this.DKz != null) {
        paramVarArgs.d(23, this.DKz);
      }
      if (this.odn != null) {
        paramVarArgs.d(31, this.odn);
      }
      paramVarArgs.aR(32, this.odq);
      paramVarArgs.aR(33, this.DKA);
      if (this.DKB != null) {
        paramVarArgs.d(34, this.DKB);
      }
      paramVarArgs.aR(35, this.DKC);
      paramVarArgs.aR(36, this.DKD);
      if (this.DKE != null) {
        paramVarArgs.d(37, this.DKE);
      }
      paramVarArgs.aR(38, this.DKF);
      paramVarArgs.aR(39, this.DKG);
      if (this.DKH != null) {
        paramVarArgs.d(41, this.DKH);
      }
      paramVarArgs.aR(200, this.DKI);
      paramVarArgs.aR(201, this.DKJ);
      paramVarArgs.aR(202, this.DbN);
      if (this.DKK != null) {
        paramVarArgs.d(203, this.DKK);
      }
      if (this.DKL != null) {
        paramVarArgs.d(204, this.DKL);
      }
      if (this.DKM != null) {
        paramVarArgs.d(205, this.DKM);
      }
      if (this.DKN != null) {
        paramVarArgs.d(206, this.DKN);
      }
      AppMethodBeat.o(152627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label1462;
      }
    }
    label1462:
    for (int i = f.a.a.b.b.a.e(1, this.dlB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DKw != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.DKw);
      }
      i = paramInt;
      if (this.DKx != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.DKx);
      }
      paramInt = i;
      if (this.DKy != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.DKy);
      }
      i = paramInt;
      if (this.DKz != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.DKz);
      }
      paramInt = i;
      if (this.odn != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.odn);
      }
      i = paramInt + f.a.a.b.b.a.bA(32, this.odq) + f.a.a.b.b.a.bA(33, this.DKA);
      paramInt = i;
      if (this.DKB != null) {
        paramInt = i + f.a.a.b.b.a.e(34, this.DKB);
      }
      i = paramInt + f.a.a.b.b.a.bA(35, this.DKC) + f.a.a.b.b.a.bA(36, this.DKD);
      paramInt = i;
      if (this.DKE != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.DKE);
      }
      i = paramInt + f.a.a.b.b.a.bA(38, this.DKF) + f.a.a.b.b.a.bA(39, this.DKG);
      paramInt = i;
      if (this.DKH != null) {
        paramInt = i + f.a.a.b.b.a.e(41, this.DKH);
      }
      i = paramInt + f.a.a.b.b.a.bA(200, this.DKI) + f.a.a.b.b.a.bA(201, this.DKJ) + f.a.a.b.b.a.bA(202, this.DbN);
      paramInt = i;
      if (this.DKK != null) {
        paramInt = i + f.a.a.b.b.a.e(203, this.DKK);
      }
      i = paramInt;
      if (this.DKL != null) {
        i = paramInt + f.a.a.b.b.a.e(204, this.DKL);
      }
      paramInt = i;
      if (this.DKM != null) {
        paramInt = i + f.a.a.b.b.a.e(205, this.DKM);
      }
      i = paramInt;
      if (this.DKN != null) {
        i = paramInt + f.a.a.b.b.a.e(206, this.DKN);
      }
      AppMethodBeat.o(152627);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152627);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bnd localbnd = (bnd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152627);
          return -1;
        case 1: 
          localbnd.dlB = locala.KhF.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 20: 
          localbnd.DKw = locala.KhF.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 21: 
          localbnd.DKx = locala.KhF.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 22: 
          localbnd.DKy = locala.KhF.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 23: 
          localbnd.DKz = locala.KhF.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 31: 
          localbnd.odn = locala.KhF.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 32: 
          localbnd.odq = locala.KhF.xS();
          AppMethodBeat.o(152627);
          return 0;
        case 33: 
          localbnd.DKA = locala.KhF.xS();
          AppMethodBeat.o(152627);
          return 0;
        case 34: 
          localbnd.DKB = locala.KhF.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 35: 
          localbnd.DKC = locala.KhF.xS();
          AppMethodBeat.o(152627);
          return 0;
        case 36: 
          localbnd.DKD = locala.KhF.xS();
          AppMethodBeat.o(152627);
          return 0;
        case 37: 
          localbnd.DKE = locala.KhF.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 38: 
          localbnd.DKF = locala.KhF.xS();
          AppMethodBeat.o(152627);
          return 0;
        case 39: 
          localbnd.DKG = locala.KhF.xS();
          AppMethodBeat.o(152627);
          return 0;
        case 41: 
          localbnd.DKH = locala.KhF.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 200: 
          localbnd.DKI = locala.KhF.xS();
          AppMethodBeat.o(152627);
          return 0;
        case 201: 
          localbnd.DKJ = locala.KhF.xS();
          AppMethodBeat.o(152627);
          return 0;
        case 202: 
          localbnd.DbN = locala.KhF.xS();
          AppMethodBeat.o(152627);
          return 0;
        case 203: 
          localbnd.DKK = locala.KhF.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 204: 
          localbnd.DKL = locala.KhF.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 205: 
          localbnd.DKM = locala.KhF.readString();
          AppMethodBeat.o(152627);
          return 0;
        }
        localbnd.DKN = locala.KhF.readString();
        AppMethodBeat.o(152627);
        return 0;
      }
      AppMethodBeat.o(152627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnd
 * JD-Core Version:    0.7.0.1
 */