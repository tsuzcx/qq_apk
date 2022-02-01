package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ekd
  extends esc
{
  public int JaC;
  public String UZW;
  public String Vbl;
  public boolean aaLz;
  public String aaMM;
  public String aaMN;
  public efi abce;
  public String aboC;
  public String aboD;
  public String aboE;
  public int aboF;
  public LinkedList<aku> aboG;
  public int aboH;
  public LinkedList<aku> aboI;
  public aku aboJ;
  public LinkedList<aku> aboK;
  public aku aboL;
  public dor aboM;
  public String aboN;
  public int aboO;
  public String aboP;
  public int aboQ;
  public boolean aboR;
  public String aboS;
  public String aboT;
  public LinkedList<dtx> aboU;
  public String aboV;
  public String aboW;
  public String aboX;
  public dtx aboY;
  public dgj aboZ;
  public String abow;
  public dgj abpa;
  public String abpb;
  public String abpc;
  public asz abpd;
  public LinkedList<dtx> abpe;
  public String abpf;
  public String abpg;
  public dtx abph;
  public dhk abpi;
  public dtx abpj;
  public dtx abpk;
  public boolean abpl;
  public boolean abpm;
  public aey abpn;
  public efh abpo;
  public int ftr;
  public dkf ifY;
  public int igI;
  public String wuA;
  public int wuz;
  
  public ekd()
  {
    AppMethodBeat.i(91644);
    this.aboG = new LinkedList();
    this.aboI = new LinkedList();
    this.aboK = new LinkedList();
    this.aboU = new LinkedList();
    this.abpe = new LinkedList();
    AppMethodBeat.o(91644);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91645);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91645);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      paramVarArgs.bS(4, this.ftr);
      if (this.aboC != null) {
        paramVarArgs.g(5, this.aboC);
      }
      if (this.aboD != null) {
        paramVarArgs.g(6, this.aboD);
      }
      if (this.aboE != null) {
        paramVarArgs.g(7, this.aboE);
      }
      paramVarArgs.bS(8, this.aboF);
      paramVarArgs.e(9, 8, this.aboG);
      paramVarArgs.bS(10, this.igI);
      paramVarArgs.bS(11, this.aboH);
      paramVarArgs.e(12, 8, this.aboI);
      if (this.aaMN != null) {
        paramVarArgs.g(13, this.aaMN);
      }
      if (this.aboJ != null)
      {
        paramVarArgs.qD(14, this.aboJ.computeSize());
        this.aboJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.aboK);
      if (this.aboL != null)
      {
        paramVarArgs.qD(16, this.aboL.computeSize());
        this.aboL.writeFields(paramVarArgs);
      }
      if (this.aboM != null)
      {
        paramVarArgs.qD(17, this.aboM.computeSize());
        this.aboM.writeFields(paramVarArgs);
      }
      if (this.aboN != null) {
        paramVarArgs.g(18, this.aboN);
      }
      paramVarArgs.bS(19, this.aboO);
      if (this.aboP != null) {
        paramVarArgs.g(20, this.aboP);
      }
      if (this.abow != null) {
        paramVarArgs.g(21, this.abow);
      }
      paramVarArgs.bS(22, this.aboQ);
      paramVarArgs.di(23, this.aboR);
      paramVarArgs.bS(24, this.JaC);
      if (this.aaMM != null) {
        paramVarArgs.g(25, this.aaMM);
      }
      if (this.aboS != null) {
        paramVarArgs.g(26, this.aboS);
      }
      if (this.aboT != null) {
        paramVarArgs.g(27, this.aboT);
      }
      paramVarArgs.e(28, 8, this.aboU);
      if (this.aboV != null) {
        paramVarArgs.g(29, this.aboV);
      }
      if (this.aboW != null) {
        paramVarArgs.g(30, this.aboW);
      }
      if (this.aboX != null) {
        paramVarArgs.g(31, this.aboX);
      }
      if (this.UZW != null) {
        paramVarArgs.g(32, this.UZW);
      }
      if (this.aboY != null)
      {
        paramVarArgs.qD(33, this.aboY.computeSize());
        this.aboY.writeFields(paramVarArgs);
      }
      if (this.aboZ != null)
      {
        paramVarArgs.qD(34, this.aboZ.computeSize());
        this.aboZ.writeFields(paramVarArgs);
      }
      if (this.abpa != null)
      {
        paramVarArgs.qD(35, this.abpa.computeSize());
        this.abpa.writeFields(paramVarArgs);
      }
      if (this.abpb != null) {
        paramVarArgs.g(36, this.abpb);
      }
      if (this.abpc != null) {
        paramVarArgs.g(37, this.abpc);
      }
      if (this.abpd != null)
      {
        paramVarArgs.qD(38, this.abpd.computeSize());
        this.abpd.writeFields(paramVarArgs);
      }
      paramVarArgs.di(39, this.aaLz);
      if (this.abce != null)
      {
        paramVarArgs.qD(40, this.abce.computeSize());
        this.abce.writeFields(paramVarArgs);
      }
      paramVarArgs.e(41, 8, this.abpe);
      if (this.abpf != null) {
        paramVarArgs.g(42, this.abpf);
      }
      if (this.abpg != null) {
        paramVarArgs.g(43, this.abpg);
      }
      if (this.abph != null)
      {
        paramVarArgs.qD(44, this.abph.computeSize());
        this.abph.writeFields(paramVarArgs);
      }
      if (this.abpi != null)
      {
        paramVarArgs.qD(45, this.abpi.computeSize());
        this.abpi.writeFields(paramVarArgs);
      }
      if (this.abpj != null)
      {
        paramVarArgs.qD(46, this.abpj.computeSize());
        this.abpj.writeFields(paramVarArgs);
      }
      if (this.abpk != null)
      {
        paramVarArgs.qD(47, this.abpk.computeSize());
        this.abpk.writeFields(paramVarArgs);
      }
      paramVarArgs.di(48, this.abpl);
      paramVarArgs.di(49, this.abpm);
      if (this.abpn != null)
      {
        paramVarArgs.qD(50, this.abpn.computeSize());
        this.abpn.writeFields(paramVarArgs);
      }
      if (this.ifY != null)
      {
        paramVarArgs.qD(99, this.ifY.computeSize());
        this.ifY.writeFields(paramVarArgs);
      }
      if (this.Vbl != null) {
        paramVarArgs.g(100, this.Vbl);
      }
      if (this.abpo != null)
      {
        paramVarArgs.qD(101, this.abpo.computeSize());
        this.abpo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label4896;
      }
    }
    label4896:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.ftr);
      paramInt = i;
      if (this.aboC != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aboC);
      }
      i = paramInt;
      if (this.aboD != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aboD);
      }
      paramInt = i;
      if (this.aboE != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aboE);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.aboF) + i.a.a.a.c(9, 8, this.aboG) + i.a.a.b.b.a.cJ(10, this.igI) + i.a.a.b.b.a.cJ(11, this.aboH) + i.a.a.a.c(12, 8, this.aboI);
      paramInt = i;
      if (this.aaMN != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.aaMN);
      }
      i = paramInt;
      if (this.aboJ != null) {
        i = paramInt + i.a.a.a.qC(14, this.aboJ.computeSize());
      }
      i += i.a.a.a.c(15, 8, this.aboK);
      paramInt = i;
      if (this.aboL != null) {
        paramInt = i + i.a.a.a.qC(16, this.aboL.computeSize());
      }
      i = paramInt;
      if (this.aboM != null) {
        i = paramInt + i.a.a.a.qC(17, this.aboM.computeSize());
      }
      paramInt = i;
      if (this.aboN != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.aboN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(19, this.aboO);
      paramInt = i;
      if (this.aboP != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.aboP);
      }
      i = paramInt;
      if (this.abow != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.abow);
      }
      i = i + i.a.a.b.b.a.cJ(22, this.aboQ) + (i.a.a.b.b.a.ko(23) + 1) + i.a.a.b.b.a.cJ(24, this.JaC);
      paramInt = i;
      if (this.aaMM != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.aaMM);
      }
      i = paramInt;
      if (this.aboS != null) {
        i = paramInt + i.a.a.b.b.a.h(26, this.aboS);
      }
      paramInt = i;
      if (this.aboT != null) {
        paramInt = i + i.a.a.b.b.a.h(27, this.aboT);
      }
      i = paramInt + i.a.a.a.c(28, 8, this.aboU);
      paramInt = i;
      if (this.aboV != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.aboV);
      }
      i = paramInt;
      if (this.aboW != null) {
        i = paramInt + i.a.a.b.b.a.h(30, this.aboW);
      }
      paramInt = i;
      if (this.aboX != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.aboX);
      }
      i = paramInt;
      if (this.UZW != null) {
        i = paramInt + i.a.a.b.b.a.h(32, this.UZW);
      }
      paramInt = i;
      if (this.aboY != null) {
        paramInt = i + i.a.a.a.qC(33, this.aboY.computeSize());
      }
      i = paramInt;
      if (this.aboZ != null) {
        i = paramInt + i.a.a.a.qC(34, this.aboZ.computeSize());
      }
      paramInt = i;
      if (this.abpa != null) {
        paramInt = i + i.a.a.a.qC(35, this.abpa.computeSize());
      }
      i = paramInt;
      if (this.abpb != null) {
        i = paramInt + i.a.a.b.b.a.h(36, this.abpb);
      }
      paramInt = i;
      if (this.abpc != null) {
        paramInt = i + i.a.a.b.b.a.h(37, this.abpc);
      }
      i = paramInt;
      if (this.abpd != null) {
        i = paramInt + i.a.a.a.qC(38, this.abpd.computeSize());
      }
      i += i.a.a.b.b.a.ko(39) + 1;
      paramInt = i;
      if (this.abce != null) {
        paramInt = i + i.a.a.a.qC(40, this.abce.computeSize());
      }
      i = paramInt + i.a.a.a.c(41, 8, this.abpe);
      paramInt = i;
      if (this.abpf != null) {
        paramInt = i + i.a.a.b.b.a.h(42, this.abpf);
      }
      i = paramInt;
      if (this.abpg != null) {
        i = paramInt + i.a.a.b.b.a.h(43, this.abpg);
      }
      paramInt = i;
      if (this.abph != null) {
        paramInt = i + i.a.a.a.qC(44, this.abph.computeSize());
      }
      i = paramInt;
      if (this.abpi != null) {
        i = paramInt + i.a.a.a.qC(45, this.abpi.computeSize());
      }
      paramInt = i;
      if (this.abpj != null) {
        paramInt = i + i.a.a.a.qC(46, this.abpj.computeSize());
      }
      i = paramInt;
      if (this.abpk != null) {
        i = paramInt + i.a.a.a.qC(47, this.abpk.computeSize());
      }
      i = i + (i.a.a.b.b.a.ko(48) + 1) + (i.a.a.b.b.a.ko(49) + 1);
      paramInt = i;
      if (this.abpn != null) {
        paramInt = i + i.a.a.a.qC(50, this.abpn.computeSize());
      }
      i = paramInt;
      if (this.ifY != null) {
        i = paramInt + i.a.a.a.qC(99, this.ifY.computeSize());
      }
      paramInt = i;
      if (this.Vbl != null) {
        paramInt = i + i.a.a.b.b.a.h(100, this.Vbl);
      }
      i = paramInt;
      if (this.abpo != null) {
        i = paramInt + i.a.a.a.qC(101, this.abpo.computeSize());
      }
      AppMethodBeat.o(91645);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aboG.clear();
        this.aboI.clear();
        this.aboK.clear();
        this.aboU.clear();
        this.abpe.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ekd localekd = (ekd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
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
        default: 
          AppMethodBeat.o(91645);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 2: 
          localekd.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91645);
          return 0;
        case 3: 
          localekd.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 4: 
          localekd.ftr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91645);
          return 0;
        case 5: 
          localekd.aboC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 6: 
          localekd.aboD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 7: 
          localekd.aboE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 8: 
          localekd.aboF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91645);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aku)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.aboG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 10: 
          localekd.igI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91645);
          return 0;
        case 11: 
          localekd.aboH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91645);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aku)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.aboI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 13: 
          localekd.aaMN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aku)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.aboJ = ((aku)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aku)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.aboK.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aku)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.aboL = ((aku)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dor();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dor)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.aboM = ((dor)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 18: 
          localekd.aboN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 19: 
          localekd.aboO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91645);
          return 0;
        case 20: 
          localekd.aboP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 21: 
          localekd.abow = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 22: 
          localekd.aboQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91645);
          return 0;
        case 23: 
          localekd.aboR = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91645);
          return 0;
        case 24: 
          localekd.JaC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91645);
          return 0;
        case 25: 
          localekd.aaMM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 26: 
          localekd.aboS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 27: 
          localekd.aboT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 28: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtx)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.aboU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 29: 
          localekd.aboV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 30: 
          localekd.aboW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 31: 
          localekd.aboX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 32: 
          localekd.UZW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 33: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtx)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.aboY = ((dtx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 34: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dgj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dgj)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.aboZ = ((dgj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 35: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dgj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dgj)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.abpa = ((dgj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 36: 
          localekd.abpb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 37: 
          localekd.abpc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 38: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new asz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((asz)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.abpd = ((asz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 39: 
          localekd.aaLz = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91645);
          return 0;
        case 40: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efi)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.abce = ((efi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 41: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtx)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.abpe.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 42: 
          localekd.abpf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 43: 
          localekd.abpg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 44: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtx)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.abph = ((dtx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 45: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhk)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.abpi = ((dhk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 46: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtx)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.abpj = ((dtx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 47: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtx)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.abpk = ((dtx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 48: 
          localekd.abpl = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91645);
          return 0;
        case 49: 
          localekd.abpm = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91645);
          return 0;
        case 50: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aey();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aey)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.abpn = ((aey)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 99: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dkf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dkf)localObject2).parseFrom((byte[])localObject1);
            }
            localekd.ifY = ((dkf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 100: 
          localekd.Vbl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91645);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new efh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((efh)localObject2).parseFrom((byte[])localObject1);
          }
          localekd.abpo = ((efh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91645);
        return 0;
      }
      AppMethodBeat.o(91645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekd
 * JD-Core Version:    0.7.0.1
 */