package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwg
  extends com.tencent.mm.bx.a
{
  public int GQA;
  public String GQB;
  public String GQC;
  public String GQD;
  public String GQE;
  public String GQn;
  public String GQo;
  public String GQp;
  public String GQq;
  public int GQr;
  public String GQs;
  public int GQt;
  public int GQu;
  public String GQv;
  public int GQw;
  public int GQx;
  public String GQy;
  public int GQz;
  public int Gcn;
  public String duW;
  public String pkq;
  public int pkt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152627);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duW != null) {
        paramVarArgs.d(1, this.duW);
      }
      if (this.GQn != null) {
        paramVarArgs.d(20, this.GQn);
      }
      if (this.GQo != null) {
        paramVarArgs.d(21, this.GQo);
      }
      if (this.GQp != null) {
        paramVarArgs.d(22, this.GQp);
      }
      if (this.GQq != null) {
        paramVarArgs.d(23, this.GQq);
      }
      if (this.pkq != null) {
        paramVarArgs.d(31, this.pkq);
      }
      paramVarArgs.aS(32, this.pkt);
      paramVarArgs.aS(33, this.GQr);
      if (this.GQs != null) {
        paramVarArgs.d(34, this.GQs);
      }
      paramVarArgs.aS(35, this.GQt);
      paramVarArgs.aS(36, this.GQu);
      if (this.GQv != null) {
        paramVarArgs.d(37, this.GQv);
      }
      paramVarArgs.aS(38, this.GQw);
      paramVarArgs.aS(39, this.GQx);
      if (this.GQy != null) {
        paramVarArgs.d(41, this.GQy);
      }
      paramVarArgs.aS(200, this.GQz);
      paramVarArgs.aS(201, this.GQA);
      paramVarArgs.aS(202, this.Gcn);
      if (this.GQB != null) {
        paramVarArgs.d(203, this.GQB);
      }
      if (this.GQC != null) {
        paramVarArgs.d(204, this.GQC);
      }
      if (this.GQD != null) {
        paramVarArgs.d(205, this.GQD);
      }
      if (this.GQE != null) {
        paramVarArgs.d(206, this.GQE);
      }
      AppMethodBeat.o(152627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duW == null) {
        break label1462;
      }
    }
    label1462:
    for (int i = f.a.a.b.b.a.e(1, this.duW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GQn != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.GQn);
      }
      i = paramInt;
      if (this.GQo != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.GQo);
      }
      paramInt = i;
      if (this.GQp != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.GQp);
      }
      i = paramInt;
      if (this.GQq != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.GQq);
      }
      paramInt = i;
      if (this.pkq != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.pkq);
      }
      i = paramInt + f.a.a.b.b.a.bz(32, this.pkt) + f.a.a.b.b.a.bz(33, this.GQr);
      paramInt = i;
      if (this.GQs != null) {
        paramInt = i + f.a.a.b.b.a.e(34, this.GQs);
      }
      i = paramInt + f.a.a.b.b.a.bz(35, this.GQt) + f.a.a.b.b.a.bz(36, this.GQu);
      paramInt = i;
      if (this.GQv != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.GQv);
      }
      i = paramInt + f.a.a.b.b.a.bz(38, this.GQw) + f.a.a.b.b.a.bz(39, this.GQx);
      paramInt = i;
      if (this.GQy != null) {
        paramInt = i + f.a.a.b.b.a.e(41, this.GQy);
      }
      i = paramInt + f.a.a.b.b.a.bz(200, this.GQz) + f.a.a.b.b.a.bz(201, this.GQA) + f.a.a.b.b.a.bz(202, this.Gcn);
      paramInt = i;
      if (this.GQB != null) {
        paramInt = i + f.a.a.b.b.a.e(203, this.GQB);
      }
      i = paramInt;
      if (this.GQC != null) {
        i = paramInt + f.a.a.b.b.a.e(204, this.GQC);
      }
      paramInt = i;
      if (this.GQD != null) {
        paramInt = i + f.a.a.b.b.a.e(205, this.GQD);
      }
      i = paramInt;
      if (this.GQE != null) {
        i = paramInt + f.a.a.b.b.a.e(206, this.GQE);
      }
      AppMethodBeat.o(152627);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152627);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bwg localbwg = (bwg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152627);
          return -1;
        case 1: 
          localbwg.duW = locala.NPN.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 20: 
          localbwg.GQn = locala.NPN.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 21: 
          localbwg.GQo = locala.NPN.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 22: 
          localbwg.GQp = locala.NPN.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 23: 
          localbwg.GQq = locala.NPN.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 31: 
          localbwg.pkq = locala.NPN.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 32: 
          localbwg.pkt = locala.NPN.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 33: 
          localbwg.GQr = locala.NPN.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 34: 
          localbwg.GQs = locala.NPN.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 35: 
          localbwg.GQt = locala.NPN.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 36: 
          localbwg.GQu = locala.NPN.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 37: 
          localbwg.GQv = locala.NPN.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 38: 
          localbwg.GQw = locala.NPN.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 39: 
          localbwg.GQx = locala.NPN.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 41: 
          localbwg.GQy = locala.NPN.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 200: 
          localbwg.GQz = locala.NPN.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 201: 
          localbwg.GQA = locala.NPN.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 202: 
          localbwg.Gcn = locala.NPN.zc();
          AppMethodBeat.o(152627);
          return 0;
        case 203: 
          localbwg.GQB = locala.NPN.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 204: 
          localbwg.GQC = locala.NPN.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 205: 
          localbwg.GQD = locala.NPN.readString();
          AppMethodBeat.o(152627);
          return 0;
        }
        localbwg.GQE = locala.NPN.readString();
        AppMethodBeat.o(152627);
        return 0;
      }
      AppMethodBeat.o(152627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwg
 * JD-Core Version:    0.7.0.1
 */