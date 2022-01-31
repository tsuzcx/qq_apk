package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bpw
  extends bvk
{
  public int cMb;
  public int koj;
  public String kok;
  public String tMu;
  public String tNy;
  public int wMx;
  public String xCP;
  public String xCR;
  public String xDJ;
  public String xDL;
  public String xDM;
  public String xDN;
  public int xDO;
  public LinkedList<yp> xDP;
  public int xDQ;
  public LinkedList<yp> xDR;
  public yp xDS;
  public LinkedList<yp> xDT;
  public yp xDU;
  public bdf xDV;
  public String xDW;
  public int xDX;
  public String xDY;
  public int xDZ;
  public boolean xEa;
  public String xEb;
  public String xEc;
  public LinkedList<bfx> xEd;
  public String xEe;
  public String xEf;
  public String xEg;
  public bfx xEh;
  public aze xEi;
  public aze xEj;
  public String xEk;
  public String xEl;
  public adq xEm;
  public LinkedList<bfx> xEn;
  public String xEo;
  public boolean xoA;
  public int xwl;
  public bmv xwr;
  
  public bpw()
  {
    AppMethodBeat.i(56941);
    this.xDP = new LinkedList();
    this.xDR = new LinkedList();
    this.xDT = new LinkedList();
    this.xEd = new LinkedList();
    this.xEn = new LinkedList();
    AppMethodBeat.o(56941);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56942);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56942);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      paramVarArgs.aO(4, this.xwl);
      if (this.xDL != null) {
        paramVarArgs.e(5, this.xDL);
      }
      if (this.xDM != null) {
        paramVarArgs.e(6, this.xDM);
      }
      if (this.xDN != null) {
        paramVarArgs.e(7, this.xDN);
      }
      paramVarArgs.aO(8, this.xDO);
      paramVarArgs.e(9, 8, this.xDP);
      paramVarArgs.aO(10, this.cMb);
      paramVarArgs.aO(11, this.xDQ);
      paramVarArgs.e(12, 8, this.xDR);
      if (this.xCP != null) {
        paramVarArgs.e(13, this.xCP);
      }
      if (this.xDS != null)
      {
        paramVarArgs.iQ(14, this.xDS.computeSize());
        this.xDS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.xDT);
      if (this.xDU != null)
      {
        paramVarArgs.iQ(16, this.xDU.computeSize());
        this.xDU.writeFields(paramVarArgs);
      }
      if (this.xDV != null)
      {
        paramVarArgs.iQ(17, this.xDV.computeSize());
        this.xDV.writeFields(paramVarArgs);
      }
      if (this.xDW != null) {
        paramVarArgs.e(18, this.xDW);
      }
      paramVarArgs.aO(19, this.xDX);
      if (this.xDY != null) {
        paramVarArgs.e(20, this.xDY);
      }
      if (this.xDJ != null) {
        paramVarArgs.e(21, this.xDJ);
      }
      paramVarArgs.aO(22, this.xDZ);
      paramVarArgs.aS(23, this.xEa);
      paramVarArgs.aO(24, this.wMx);
      if (this.xCR != null) {
        paramVarArgs.e(25, this.xCR);
      }
      if (this.xEb != null) {
        paramVarArgs.e(26, this.xEb);
      }
      if (this.xEc != null) {
        paramVarArgs.e(27, this.xEc);
      }
      paramVarArgs.e(28, 8, this.xEd);
      if (this.xEe != null) {
        paramVarArgs.e(29, this.xEe);
      }
      if (this.xEf != null) {
        paramVarArgs.e(30, this.xEf);
      }
      if (this.xEg != null) {
        paramVarArgs.e(31, this.xEg);
      }
      if (this.tMu != null) {
        paramVarArgs.e(32, this.tMu);
      }
      if (this.xEh != null)
      {
        paramVarArgs.iQ(33, this.xEh.computeSize());
        this.xEh.writeFields(paramVarArgs);
      }
      if (this.xEi != null)
      {
        paramVarArgs.iQ(34, this.xEi.computeSize());
        this.xEi.writeFields(paramVarArgs);
      }
      if (this.xEj != null)
      {
        paramVarArgs.iQ(35, this.xEj.computeSize());
        this.xEj.writeFields(paramVarArgs);
      }
      if (this.xEk != null) {
        paramVarArgs.e(36, this.xEk);
      }
      if (this.xEl != null) {
        paramVarArgs.e(37, this.xEl);
      }
      if (this.xEm != null)
      {
        paramVarArgs.iQ(38, this.xEm.computeSize());
        this.xEm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(39, this.xoA);
      if (this.xwr != null)
      {
        paramVarArgs.iQ(40, this.xwr.computeSize());
        this.xwr.writeFields(paramVarArgs);
      }
      paramVarArgs.e(41, 8, this.xEn);
      if (this.xEo != null) {
        paramVarArgs.e(42, this.xEo);
      }
      if (this.tNy != null) {
        paramVarArgs.e(100, this.tNy);
      }
      AppMethodBeat.o(56942);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label4154;
      }
    }
    label4154:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.xwl);
      paramInt = i;
      if (this.xDL != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xDL);
      }
      i = paramInt;
      if (this.xDM != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xDM);
      }
      paramInt = i;
      if (this.xDN != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xDN);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.xDO) + e.a.a.a.c(9, 8, this.xDP) + e.a.a.b.b.a.bl(10, this.cMb) + e.a.a.b.b.a.bl(11, this.xDQ) + e.a.a.a.c(12, 8, this.xDR);
      paramInt = i;
      if (this.xCP != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.xCP);
      }
      i = paramInt;
      if (this.xDS != null) {
        i = paramInt + e.a.a.a.iP(14, this.xDS.computeSize());
      }
      i += e.a.a.a.c(15, 8, this.xDT);
      paramInt = i;
      if (this.xDU != null) {
        paramInt = i + e.a.a.a.iP(16, this.xDU.computeSize());
      }
      i = paramInt;
      if (this.xDV != null) {
        i = paramInt + e.a.a.a.iP(17, this.xDV.computeSize());
      }
      paramInt = i;
      if (this.xDW != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.xDW);
      }
      i = paramInt + e.a.a.b.b.a.bl(19, this.xDX);
      paramInt = i;
      if (this.xDY != null) {
        paramInt = i + e.a.a.b.b.a.f(20, this.xDY);
      }
      i = paramInt;
      if (this.xDJ != null) {
        i = paramInt + e.a.a.b.b.a.f(21, this.xDJ);
      }
      i = i + e.a.a.b.b.a.bl(22, this.xDZ) + (e.a.a.b.b.a.eW(23) + 1) + e.a.a.b.b.a.bl(24, this.wMx);
      paramInt = i;
      if (this.xCR != null) {
        paramInt = i + e.a.a.b.b.a.f(25, this.xCR);
      }
      i = paramInt;
      if (this.xEb != null) {
        i = paramInt + e.a.a.b.b.a.f(26, this.xEb);
      }
      paramInt = i;
      if (this.xEc != null) {
        paramInt = i + e.a.a.b.b.a.f(27, this.xEc);
      }
      i = paramInt + e.a.a.a.c(28, 8, this.xEd);
      paramInt = i;
      if (this.xEe != null) {
        paramInt = i + e.a.a.b.b.a.f(29, this.xEe);
      }
      i = paramInt;
      if (this.xEf != null) {
        i = paramInt + e.a.a.b.b.a.f(30, this.xEf);
      }
      paramInt = i;
      if (this.xEg != null) {
        paramInt = i + e.a.a.b.b.a.f(31, this.xEg);
      }
      i = paramInt;
      if (this.tMu != null) {
        i = paramInt + e.a.a.b.b.a.f(32, this.tMu);
      }
      paramInt = i;
      if (this.xEh != null) {
        paramInt = i + e.a.a.a.iP(33, this.xEh.computeSize());
      }
      i = paramInt;
      if (this.xEi != null) {
        i = paramInt + e.a.a.a.iP(34, this.xEi.computeSize());
      }
      paramInt = i;
      if (this.xEj != null) {
        paramInt = i + e.a.a.a.iP(35, this.xEj.computeSize());
      }
      i = paramInt;
      if (this.xEk != null) {
        i = paramInt + e.a.a.b.b.a.f(36, this.xEk);
      }
      paramInt = i;
      if (this.xEl != null) {
        paramInt = i + e.a.a.b.b.a.f(37, this.xEl);
      }
      i = paramInt;
      if (this.xEm != null) {
        i = paramInt + e.a.a.a.iP(38, this.xEm.computeSize());
      }
      i += e.a.a.b.b.a.eW(39) + 1;
      paramInt = i;
      if (this.xwr != null) {
        paramInt = i + e.a.a.a.iP(40, this.xwr.computeSize());
      }
      i = paramInt + e.a.a.a.c(41, 8, this.xEn);
      paramInt = i;
      if (this.xEo != null) {
        paramInt = i + e.a.a.b.b.a.f(42, this.xEo);
      }
      i = paramInt;
      if (this.tNy != null) {
        i = paramInt + e.a.a.b.b.a.f(100, this.tNy);
      }
      AppMethodBeat.o(56942);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xDP.clear();
        this.xDR.clear();
        this.xDT.clear();
        this.xEd.clear();
        this.xEn.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56942);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56942);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bpw localbpw = (bpw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 43: 
        case 44: 
        case 45: 
        case 46: 
        case 47: 
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 52: 
        case 53: 
        case 54: 
        case 55: 
        case 56: 
        case 57: 
        case 58: 
        case 59: 
        case 60: 
        case 61: 
        case 62: 
        case 63: 
        case 64: 
        case 65: 
        case 66: 
        case 67: 
        case 68: 
        case 69: 
        case 70: 
        case 71: 
        case 72: 
        case 73: 
        case 74: 
        case 75: 
        case 76: 
        case 77: 
        case 78: 
        case 79: 
        case 80: 
        case 81: 
        case 82: 
        case 83: 
        case 84: 
        case 85: 
        case 86: 
        case 87: 
        case 88: 
        case 89: 
        case 90: 
        case 91: 
        case 92: 
        case 93: 
        case 94: 
        case 95: 
        case 96: 
        case 97: 
        case 98: 
        case 99: 
        default: 
          AppMethodBeat.o(56942);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 2: 
          localbpw.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56942);
          return 0;
        case 3: 
          localbpw.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 4: 
          localbpw.xwl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56942);
          return 0;
        case 5: 
          localbpw.xDL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 6: 
          localbpw.xDM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 7: 
          localbpw.xDN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 8: 
          localbpw.xDO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56942);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.xDP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 10: 
          localbpw.cMb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56942);
          return 0;
        case 11: 
          localbpw.xDQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56942);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.xDR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 13: 
          localbpw.xCP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 14: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.xDS = ((yp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 15: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.xDT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 16: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.xDU = ((yp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 17: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.xDV = ((bdf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 18: 
          localbpw.xDW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 19: 
          localbpw.xDX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56942);
          return 0;
        case 20: 
          localbpw.xDY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 21: 
          localbpw.xDJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 22: 
          localbpw.xDZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56942);
          return 0;
        case 23: 
          localbpw.xEa = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56942);
          return 0;
        case 24: 
          localbpw.wMx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56942);
          return 0;
        case 25: 
          localbpw.xCR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 26: 
          localbpw.xEb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 27: 
          localbpw.xEc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 28: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.xEd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 29: 
          localbpw.xEe = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 30: 
          localbpw.xEf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 31: 
          localbpw.xEg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 32: 
          localbpw.tMu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 33: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.xEh = ((bfx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 34: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aze();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aze)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.xEi = ((aze)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 35: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aze();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aze)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.xEj = ((aze)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 36: 
          localbpw.xEk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 37: 
          localbpw.xEl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        case 38: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.xEm = ((adq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 39: 
          localbpw.xoA = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56942);
          return 0;
        case 40: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.xwr = ((bmv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 41: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpw.xEn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56942);
          return 0;
        case 42: 
          localbpw.xEo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56942);
          return 0;
        }
        localbpw.tNy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56942);
        return 0;
      }
      AppMethodBeat.o(56942);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpw
 * JD-Core Version:    0.7.0.1
 */