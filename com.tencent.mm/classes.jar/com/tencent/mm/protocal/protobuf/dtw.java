package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtw
  extends com.tencent.mm.bx.a
{
  public String FDu;
  public cww FEh;
  public String FVo;
  public String FVp;
  public int Fsl;
  public bug FvA;
  public dhg GOa;
  public String GUX;
  public String GUt;
  public String GUu;
  public int Gua;
  public int HGA;
  public String HGB;
  public int HGC;
  public cwt HGD;
  public int HGE;
  public String HGF;
  public String HGG;
  public String HGH;
  public String HGI;
  public String HGJ;
  public cij HGK;
  public String HGL;
  public int HGM;
  public long HGN;
  public String HGO;
  public dkd HGP;
  public long HGQ;
  public int HGR;
  public String HGS;
  public String HGT;
  public String HGw;
  public String HGx;
  public int HGy;
  public int HGz;
  public int Hgy;
  public int Hqw;
  public String ePI;
  public String jdm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134260);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GOa == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
        AppMethodBeat.o(134260);
        throw paramVarArgs;
      }
      if (this.GOa != null)
      {
        paramVarArgs.lC(1, this.GOa.computeSize());
        this.GOa.writeFields(paramVarArgs);
      }
      if (this.jdm != null) {
        paramVarArgs.d(2, this.jdm);
      }
      if (this.HGw != null) {
        paramVarArgs.d(3, this.HGw);
      }
      if (this.HGx != null) {
        paramVarArgs.d(4, this.HGx);
      }
      paramVarArgs.aS(5, this.HGy);
      paramVarArgs.aS(6, this.HGz);
      paramVarArgs.aS(7, this.HGA);
      if (this.HGB != null) {
        paramVarArgs.d(8, this.HGB);
      }
      if (this.FVo != null) {
        paramVarArgs.d(9, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(10, this.FVp);
      }
      paramVarArgs.aS(11, this.HGC);
      if (this.HGD != null)
      {
        paramVarArgs.lC(12, this.HGD.computeSize());
        this.HGD.writeFields(paramVarArgs);
      }
      if (this.FEh != null)
      {
        paramVarArgs.lC(13, this.FEh.computeSize());
        this.FEh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.Fsl);
      paramVarArgs.aS(15, this.HGE);
      if (this.FDu != null) {
        paramVarArgs.d(16, this.FDu);
      }
      if (this.GUt != null) {
        paramVarArgs.d(17, this.GUt);
      }
      if (this.GUu != null) {
        paramVarArgs.d(18, this.GUu);
      }
      if (this.HGF != null) {
        paramVarArgs.d(19, this.HGF);
      }
      if (this.HGG != null) {
        paramVarArgs.d(20, this.HGG);
      }
      if (this.HGH != null) {
        paramVarArgs.d(21, this.HGH);
      }
      if (this.HGI != null) {
        paramVarArgs.d(22, this.HGI);
      }
      if (this.FvA != null)
      {
        paramVarArgs.lC(23, this.FvA.computeSize());
        this.FvA.writeFields(paramVarArgs);
      }
      if (this.HGJ != null) {
        paramVarArgs.d(24, this.HGJ);
      }
      if (this.HGK != null)
      {
        paramVarArgs.lC(25, this.HGK.computeSize());
        this.HGK.writeFields(paramVarArgs);
      }
      if (this.HGL != null) {
        paramVarArgs.d(26, this.HGL);
      }
      paramVarArgs.aS(27, this.HGM);
      if (this.ePI != null) {
        paramVarArgs.d(28, this.ePI);
      }
      paramVarArgs.aS(29, this.Gua);
      paramVarArgs.aY(30, this.HGN);
      if (this.HGO != null) {
        paramVarArgs.d(31, this.HGO);
      }
      paramVarArgs.aS(32, this.Hgy);
      if (this.HGP != null)
      {
        paramVarArgs.lC(33, this.HGP.computeSize());
        this.HGP.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(34, this.HGQ);
      paramVarArgs.aS(35, this.HGR);
      if (this.HGS != null) {
        paramVarArgs.d(36, this.HGS);
      }
      if (this.HGT != null) {
        paramVarArgs.d(37, this.HGT);
      }
      if (this.GUX != null) {
        paramVarArgs.d(38, this.GUX);
      }
      paramVarArgs.aS(39, this.Hqw);
      AppMethodBeat.o(134260);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GOa == null) {
        break label2958;
      }
    }
    label2958:
    for (int i = f.a.a.a.lB(1, this.GOa.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jdm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jdm);
      }
      i = paramInt;
      if (this.HGw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HGw);
      }
      paramInt = i;
      if (this.HGx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HGx);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HGy) + f.a.a.b.b.a.bz(6, this.HGz) + f.a.a.b.b.a.bz(7, this.HGA);
      paramInt = i;
      if (this.HGB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HGB);
      }
      i = paramInt;
      if (this.FVo != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FVo);
      }
      paramInt = i;
      if (this.FVp != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FVp);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.HGC);
      paramInt = i;
      if (this.HGD != null) {
        paramInt = i + f.a.a.a.lB(12, this.HGD.computeSize());
      }
      i = paramInt;
      if (this.FEh != null) {
        i = paramInt + f.a.a.a.lB(13, this.FEh.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(14, this.Fsl) + f.a.a.b.b.a.bz(15, this.HGE);
      paramInt = i;
      if (this.FDu != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FDu);
      }
      i = paramInt;
      if (this.GUt != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.GUt);
      }
      paramInt = i;
      if (this.GUu != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.GUu);
      }
      i = paramInt;
      if (this.HGF != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.HGF);
      }
      paramInt = i;
      if (this.HGG != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.HGG);
      }
      i = paramInt;
      if (this.HGH != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.HGH);
      }
      paramInt = i;
      if (this.HGI != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.HGI);
      }
      i = paramInt;
      if (this.FvA != null) {
        i = paramInt + f.a.a.a.lB(23, this.FvA.computeSize());
      }
      paramInt = i;
      if (this.HGJ != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.HGJ);
      }
      i = paramInt;
      if (this.HGK != null) {
        i = paramInt + f.a.a.a.lB(25, this.HGK.computeSize());
      }
      paramInt = i;
      if (this.HGL != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.HGL);
      }
      i = paramInt + f.a.a.b.b.a.bz(27, this.HGM);
      paramInt = i;
      if (this.ePI != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.ePI);
      }
      i = paramInt + f.a.a.b.b.a.bz(29, this.Gua) + f.a.a.b.b.a.p(30, this.HGN);
      paramInt = i;
      if (this.HGO != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.HGO);
      }
      i = paramInt + f.a.a.b.b.a.bz(32, this.Hgy);
      paramInt = i;
      if (this.HGP != null) {
        paramInt = i + f.a.a.a.lB(33, this.HGP.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(34, this.HGQ) + f.a.a.b.b.a.bz(35, this.HGR);
      paramInt = i;
      if (this.HGS != null) {
        paramInt = i + f.a.a.b.b.a.e(36, this.HGS);
      }
      i = paramInt;
      if (this.HGT != null) {
        i = paramInt + f.a.a.b.b.a.e(37, this.HGT);
      }
      paramInt = i;
      if (this.GUX != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.GUX);
      }
      i = f.a.a.b.b.a.bz(39, this.Hqw);
      AppMethodBeat.o(134260);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GOa == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
          AppMethodBeat.o(134260);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtw localdtw = (dtw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134260);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtw.GOa = ((dhg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 2: 
          localdtw.jdm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 3: 
          localdtw.HGw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 4: 
          localdtw.HGx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 5: 
          localdtw.HGy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 6: 
          localdtw.HGz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 7: 
          localdtw.HGA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 8: 
          localdtw.HGB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 9: 
          localdtw.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 10: 
          localdtw.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 11: 
          localdtw.HGC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtw.HGD = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cww();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtw.FEh = ((cww)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 14: 
          localdtw.Fsl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 15: 
          localdtw.HGE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 16: 
          localdtw.FDu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 17: 
          localdtw.GUt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 18: 
          localdtw.GUu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 19: 
          localdtw.HGF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 20: 
          localdtw.HGG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 21: 
          localdtw.HGH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 22: 
          localdtw.HGI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bug();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bug)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtw.FvA = ((bug)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 24: 
          localdtw.HGJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cij();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cij)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtw.HGK = ((cij)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 26: 
          localdtw.HGL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 27: 
          localdtw.HGM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 28: 
          localdtw.ePI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 29: 
          localdtw.Gua = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 30: 
          localdtw.HGN = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(134260);
          return 0;
        case 31: 
          localdtw.HGO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 32: 
          localdtw.Hgy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtw.HGP = ((dkd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 34: 
          localdtw.HGQ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(134260);
          return 0;
        case 35: 
          localdtw.HGR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134260);
          return 0;
        case 36: 
          localdtw.HGS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 37: 
          localdtw.HGT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 38: 
          localdtw.GUX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134260);
          return 0;
        }
        localdtw.Hqw = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(134260);
        return 0;
      }
      AppMethodBeat.o(134260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtw
 * JD-Core Version:    0.7.0.1
 */