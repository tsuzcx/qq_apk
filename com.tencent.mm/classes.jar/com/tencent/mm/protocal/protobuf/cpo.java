package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cpo
  extends cwj
{
  public String COR;
  public String CPZ;
  public String HAX;
  public String HAb;
  public String HAd;
  public btr HBA;
  public btr HBB;
  public String HBC;
  public String HBD;
  public alp HBE;
  public LinkedList<cda> HBF;
  public String HBG;
  public String HBH;
  public bup HBI;
  public String HBd;
  public String HBe;
  public String HBf;
  public int HBg;
  public LinkedList<afj> HBh;
  public int HBi;
  public LinkedList<afj> HBj;
  public afj HBk;
  public LinkedList<afj> HBl;
  public afj HBm;
  public bzv HBn;
  public String HBo;
  public int HBp;
  public String HBq;
  public int HBr;
  public boolean HBs;
  public String HBt;
  public String HBu;
  public LinkedList<cda> HBv;
  public String HBw;
  public String HBx;
  public String HBy;
  public cda HBz;
  public boolean HgN;
  public int Hro;
  public clt Hru;
  public int dOo;
  public int oGt;
  public String oGu;
  public int uIM;
  
  public cpo()
  {
    AppMethodBeat.i(91644);
    this.HBh = new LinkedList();
    this.HBj = new LinkedList();
    this.HBl = new LinkedList();
    this.HBv = new LinkedList();
    this.HBF = new LinkedList();
    AppMethodBeat.o(91644);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91645);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91645);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      paramVarArgs.aS(4, this.Hro);
      if (this.HBd != null) {
        paramVarArgs.d(5, this.HBd);
      }
      if (this.HBe != null) {
        paramVarArgs.d(6, this.HBe);
      }
      if (this.HBf != null) {
        paramVarArgs.d(7, this.HBf);
      }
      paramVarArgs.aS(8, this.HBg);
      paramVarArgs.e(9, 8, this.HBh);
      paramVarArgs.aS(10, this.dOo);
      paramVarArgs.aS(11, this.HBi);
      paramVarArgs.e(12, 8, this.HBj);
      if (this.HAb != null) {
        paramVarArgs.d(13, this.HAb);
      }
      if (this.HBk != null)
      {
        paramVarArgs.lJ(14, this.HBk.computeSize());
        this.HBk.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.HBl);
      if (this.HBm != null)
      {
        paramVarArgs.lJ(16, this.HBm.computeSize());
        this.HBm.writeFields(paramVarArgs);
      }
      if (this.HBn != null)
      {
        paramVarArgs.lJ(17, this.HBn.computeSize());
        this.HBn.writeFields(paramVarArgs);
      }
      if (this.HBo != null) {
        paramVarArgs.d(18, this.HBo);
      }
      paramVarArgs.aS(19, this.HBp);
      if (this.HBq != null) {
        paramVarArgs.d(20, this.HBq);
      }
      if (this.HAX != null) {
        paramVarArgs.d(21, this.HAX);
      }
      paramVarArgs.aS(22, this.HBr);
      paramVarArgs.bC(23, this.HBs);
      paramVarArgs.aS(24, this.uIM);
      if (this.HAd != null) {
        paramVarArgs.d(25, this.HAd);
      }
      if (this.HBt != null) {
        paramVarArgs.d(26, this.HBt);
      }
      if (this.HBu != null) {
        paramVarArgs.d(27, this.HBu);
      }
      paramVarArgs.e(28, 8, this.HBv);
      if (this.HBw != null) {
        paramVarArgs.d(29, this.HBw);
      }
      if (this.HBx != null) {
        paramVarArgs.d(30, this.HBx);
      }
      if (this.HBy != null) {
        paramVarArgs.d(31, this.HBy);
      }
      if (this.COR != null) {
        paramVarArgs.d(32, this.COR);
      }
      if (this.HBz != null)
      {
        paramVarArgs.lJ(33, this.HBz.computeSize());
        this.HBz.writeFields(paramVarArgs);
      }
      if (this.HBA != null)
      {
        paramVarArgs.lJ(34, this.HBA.computeSize());
        this.HBA.writeFields(paramVarArgs);
      }
      if (this.HBB != null)
      {
        paramVarArgs.lJ(35, this.HBB.computeSize());
        this.HBB.writeFields(paramVarArgs);
      }
      if (this.HBC != null) {
        paramVarArgs.d(36, this.HBC);
      }
      if (this.HBD != null) {
        paramVarArgs.d(37, this.HBD);
      }
      if (this.HBE != null)
      {
        paramVarArgs.lJ(38, this.HBE.computeSize());
        this.HBE.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(39, this.HgN);
      if (this.Hru != null)
      {
        paramVarArgs.lJ(40, this.Hru.computeSize());
        this.Hru.writeFields(paramVarArgs);
      }
      paramVarArgs.e(41, 8, this.HBF);
      if (this.HBG != null) {
        paramVarArgs.d(42, this.HBG);
      }
      if (this.HBH != null) {
        paramVarArgs.d(43, this.HBH);
      }
      if (this.HBI != null)
      {
        paramVarArgs.lJ(45, this.HBI.computeSize());
        this.HBI.writeFields(paramVarArgs);
      }
      if (this.CPZ != null) {
        paramVarArgs.d(100, this.CPZ);
      }
      AppMethodBeat.o(91645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label4362;
      }
    }
    label4362:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Hro);
      paramInt = i;
      if (this.HBd != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HBd);
      }
      i = paramInt;
      if (this.HBe != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HBe);
      }
      paramInt = i;
      if (this.HBf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HBf);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HBg) + f.a.a.a.c(9, 8, this.HBh) + f.a.a.b.b.a.bz(10, this.dOo) + f.a.a.b.b.a.bz(11, this.HBi) + f.a.a.a.c(12, 8, this.HBj);
      paramInt = i;
      if (this.HAb != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.HAb);
      }
      i = paramInt;
      if (this.HBk != null) {
        i = paramInt + f.a.a.a.lI(14, this.HBk.computeSize());
      }
      i += f.a.a.a.c(15, 8, this.HBl);
      paramInt = i;
      if (this.HBm != null) {
        paramInt = i + f.a.a.a.lI(16, this.HBm.computeSize());
      }
      i = paramInt;
      if (this.HBn != null) {
        i = paramInt + f.a.a.a.lI(17, this.HBn.computeSize());
      }
      paramInt = i;
      if (this.HBo != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.HBo);
      }
      i = paramInt + f.a.a.b.b.a.bz(19, this.HBp);
      paramInt = i;
      if (this.HBq != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.HBq);
      }
      i = paramInt;
      if (this.HAX != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.HAX);
      }
      i = i + f.a.a.b.b.a.bz(22, this.HBr) + f.a.a.b.b.a.amF(23) + f.a.a.b.b.a.bz(24, this.uIM);
      paramInt = i;
      if (this.HAd != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.HAd);
      }
      i = paramInt;
      if (this.HBt != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.HBt);
      }
      paramInt = i;
      if (this.HBu != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.HBu);
      }
      i = paramInt + f.a.a.a.c(28, 8, this.HBv);
      paramInt = i;
      if (this.HBw != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.HBw);
      }
      i = paramInt;
      if (this.HBx != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.HBx);
      }
      paramInt = i;
      if (this.HBy != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.HBy);
      }
      i = paramInt;
      if (this.COR != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.COR);
      }
      paramInt = i;
      if (this.HBz != null) {
        paramInt = i + f.a.a.a.lI(33, this.HBz.computeSize());
      }
      i = paramInt;
      if (this.HBA != null) {
        i = paramInt + f.a.a.a.lI(34, this.HBA.computeSize());
      }
      paramInt = i;
      if (this.HBB != null) {
        paramInt = i + f.a.a.a.lI(35, this.HBB.computeSize());
      }
      i = paramInt;
      if (this.HBC != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.HBC);
      }
      paramInt = i;
      if (this.HBD != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.HBD);
      }
      i = paramInt;
      if (this.HBE != null) {
        i = paramInt + f.a.a.a.lI(38, this.HBE.computeSize());
      }
      i += f.a.a.b.b.a.amF(39);
      paramInt = i;
      if (this.Hru != null) {
        paramInt = i + f.a.a.a.lI(40, this.Hru.computeSize());
      }
      i = paramInt + f.a.a.a.c(41, 8, this.HBF);
      paramInt = i;
      if (this.HBG != null) {
        paramInt = i + f.a.a.b.b.a.e(42, this.HBG);
      }
      i = paramInt;
      if (this.HBH != null) {
        i = paramInt + f.a.a.b.b.a.e(43, this.HBH);
      }
      paramInt = i;
      if (this.HBI != null) {
        paramInt = i + f.a.a.a.lI(45, this.HBI.computeSize());
      }
      i = paramInt;
      if (this.CPZ != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.CPZ);
      }
      AppMethodBeat.o(91645);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HBh.clear();
        this.HBj.clear();
        this.HBl.clear();
        this.HBv.clear();
        this.HBF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91645);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91645);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpo localcpo = (cpo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 44: 
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
          AppMethodBeat.o(91645);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 2: 
          localcpo.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 3: 
          localcpo.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 4: 
          localcpo.Hro = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 5: 
          localcpo.HBd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 6: 
          localcpo.HBe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 7: 
          localcpo.HBf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 8: 
          localcpo.HBg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.HBh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 10: 
          localcpo.dOo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 11: 
          localcpo.HBi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.HBj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 13: 
          localcpo.HAb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.HBk = ((afj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.HBl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.HBm = ((afj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.HBn = ((bzv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 18: 
          localcpo.HBo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 19: 
          localcpo.HBp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 20: 
          localcpo.HBq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 21: 
          localcpo.HAX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 22: 
          localcpo.HBr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 23: 
          localcpo.HBs = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91645);
          return 0;
        case 24: 
          localcpo.uIM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 25: 
          localcpo.HAd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 26: 
          localcpo.HBt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 27: 
          localcpo.HBu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cda();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cda)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.HBv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 29: 
          localcpo.HBw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 30: 
          localcpo.HBx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 31: 
          localcpo.HBy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 32: 
          localcpo.COR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cda();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cda)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.HBz = ((cda)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.HBA = ((btr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 35: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.HBB = ((btr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 36: 
          localcpo.HBC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 37: 
          localcpo.HBD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 38: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.HBE = ((alp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 39: 
          localcpo.HgN = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91645);
          return 0;
        case 40: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.Hru = ((clt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 41: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cda();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cda)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.HBF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 42: 
          localcpo.HBG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 43: 
          localcpo.HBH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 45: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bup();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bup)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpo.HBI = ((bup)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        }
        localcpo.CPZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91645);
        return 0;
      }
      AppMethodBeat.o(91645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpo
 * JD-Core Version:    0.7.0.1
 */