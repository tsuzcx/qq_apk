package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class bwh
  extends erp
{
  public b AEA;
  public atz CJv;
  public long EWw;
  public aur ZDQ;
  public LinkedList<fhp> ZHE;
  public avb ZKG;
  public bfu ZKH;
  public bwt ZNq;
  public String ZNx;
  public LinkedList<dmk> ZXp;
  public int aaeM;
  public String aaeN;
  public long aaeO;
  public LinkedList<byg> aaeP;
  public int aaeQ;
  public String aaeR;
  public bgc aaeS;
  public int aaeT;
  public long aaeU;
  public LinkedList<bwl> aaeV;
  public int aaeW;
  public String aaeX;
  public bwj aaeY;
  public bwg aaeZ;
  public String finderUsername;
  public int hJx;
  public b lastBuffer;
  public float latitude;
  public float longitude;
  public int pullType;
  public String sessionId;
  public b tabTipsByPassInfo;
  
  public bwh()
  {
    AppMethodBeat.i(184211);
    this.ZXp = new LinkedList();
    this.ZHE = new LinkedList();
    this.aaeP = new LinkedList();
    this.aaeV = new LinkedList();
    AppMethodBeat.o(184211);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169056);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.d(3, this.lastBuffer);
      }
      if (this.finderUsername != null) {
        paramVarArgs.g(4, this.finderUsername);
      }
      paramVarArgs.bS(5, this.pullType);
      if (this.CJv != null)
      {
        paramVarArgs.qD(6, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      paramVarArgs.l(7, this.longitude);
      paramVarArgs.l(8, this.latitude);
      if (this.sessionId != null) {
        paramVarArgs.g(9, this.sessionId);
      }
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(10, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.ZXp);
      paramVarArgs.bS(12, this.aaeM);
      paramVarArgs.bS(13, this.hJx);
      paramVarArgs.bv(14, this.EWw);
      if (this.aaeN != null) {
        paramVarArgs.g(15, this.aaeN);
      }
      paramVarArgs.e(16, 8, this.ZHE);
      paramVarArgs.bv(17, this.aaeO);
      paramVarArgs.e(18, 8, this.aaeP);
      if (this.AEA != null) {
        paramVarArgs.d(19, this.AEA);
      }
      paramVarArgs.bS(20, this.aaeQ);
      if (this.aaeR != null) {
        paramVarArgs.g(21, this.aaeR);
      }
      if (this.tabTipsByPassInfo != null) {
        paramVarArgs.d(22, this.tabTipsByPassInfo);
      }
      if (this.aaeS != null)
      {
        paramVarArgs.qD(23, this.aaeS.computeSize());
        this.aaeS.writeFields(paramVarArgs);
      }
      if (this.ZNx != null) {
        paramVarArgs.g(24, this.ZNx);
      }
      paramVarArgs.bS(25, this.aaeT);
      if (this.ZNq != null)
      {
        paramVarArgs.qD(26, this.ZNq.computeSize());
        this.ZNq.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(27, this.aaeU);
      paramVarArgs.e(28, 8, this.aaeV);
      paramVarArgs.bS(29, this.aaeW);
      if (this.aaeX != null) {
        paramVarArgs.g(30, this.aaeX);
      }
      if (this.ZKG != null)
      {
        paramVarArgs.qD(32, this.ZKG.computeSize());
        this.ZKG.writeFields(paramVarArgs);
      }
      if (this.aaeY != null)
      {
        paramVarArgs.qD(33, this.aaeY.computeSize());
        this.aaeY.writeFields(paramVarArgs);
      }
      if (this.ZKH != null)
      {
        paramVarArgs.qD(34, this.ZKH.computeSize());
        this.ZKH.writeFields(paramVarArgs);
      }
      if (this.aaeZ != null)
      {
        paramVarArgs.qD(36, this.aaeZ.computeSize());
        this.aaeZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169056);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2890;
      }
    }
    label2890:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.finderUsername);
      }
      i += i.a.a.b.b.a.cJ(5, this.pullType);
      paramInt = i;
      if (this.CJv != null) {
        paramInt = i + i.a.a.a.qC(6, this.CJv.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(7) + 4) + (i.a.a.b.b.a.ko(8) + 4);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.sessionId);
      }
      i = paramInt;
      if (this.ZDQ != null) {
        i = paramInt + i.a.a.a.qC(10, this.ZDQ.computeSize());
      }
      i = i + i.a.a.a.c(11, 8, this.ZXp) + i.a.a.b.b.a.cJ(12, this.aaeM) + i.a.a.b.b.a.cJ(13, this.hJx) + i.a.a.b.b.a.q(14, this.EWw);
      paramInt = i;
      if (this.aaeN != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.aaeN);
      }
      i = paramInt + i.a.a.a.c(16, 8, this.ZHE) + i.a.a.b.b.a.q(17, this.aaeO) + i.a.a.a.c(18, 8, this.aaeP);
      paramInt = i;
      if (this.AEA != null) {
        paramInt = i + i.a.a.b.b.a.c(19, this.AEA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(20, this.aaeQ);
      paramInt = i;
      if (this.aaeR != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.aaeR);
      }
      i = paramInt;
      if (this.tabTipsByPassInfo != null) {
        i = paramInt + i.a.a.b.b.a.c(22, this.tabTipsByPassInfo);
      }
      paramInt = i;
      if (this.aaeS != null) {
        paramInt = i + i.a.a.a.qC(23, this.aaeS.computeSize());
      }
      i = paramInt;
      if (this.ZNx != null) {
        i = paramInt + i.a.a.b.b.a.h(24, this.ZNx);
      }
      i += i.a.a.b.b.a.cJ(25, this.aaeT);
      paramInt = i;
      if (this.ZNq != null) {
        paramInt = i + i.a.a.a.qC(26, this.ZNq.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(27, this.aaeU) + i.a.a.a.c(28, 8, this.aaeV) + i.a.a.b.b.a.cJ(29, this.aaeW);
      paramInt = i;
      if (this.aaeX != null) {
        paramInt = i + i.a.a.b.b.a.h(30, this.aaeX);
      }
      i = paramInt;
      if (this.ZKG != null) {
        i = paramInt + i.a.a.a.qC(32, this.ZKG.computeSize());
      }
      paramInt = i;
      if (this.aaeY != null) {
        paramInt = i + i.a.a.a.qC(33, this.aaeY.computeSize());
      }
      i = paramInt;
      if (this.ZKH != null) {
        i = paramInt + i.a.a.a.qC(34, this.ZKH.computeSize());
      }
      paramInt = i;
      if (this.aaeZ != null) {
        paramInt = i + i.a.a.a.qC(36, this.aaeZ.computeSize());
      }
      AppMethodBeat.o(169056);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZXp.clear();
        this.ZHE.clear();
        this.aaeP.clear();
        this.aaeV.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169056);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bwh localbwh = (bwh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 2: 
        case 31: 
        case 35: 
        default: 
          AppMethodBeat.o(169056);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbwh.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 3: 
          localbwh.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(169056);
          return 0;
        case 4: 
          localbwh.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 5: 
          localbwh.pullType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169056);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbwh.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 7: 
          localbwh.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169056);
          return 0;
        case 8: 
          localbwh.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(169056);
          return 0;
        case 9: 
          localbwh.sessionId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aur();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aur)localObject2).parseFrom((byte[])localObject1);
            }
            localbwh.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmk)localObject2).parseFrom((byte[])localObject1);
            }
            localbwh.ZXp.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 12: 
          localbwh.aaeM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169056);
          return 0;
        case 13: 
          localbwh.hJx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169056);
          return 0;
        case 14: 
          localbwh.EWw = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169056);
          return 0;
        case 15: 
          localbwh.aaeN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhp)localObject2).parseFrom((byte[])localObject1);
            }
            localbwh.ZHE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 17: 
          localbwh.aaeO = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169056);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new byg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((byg)localObject2).parseFrom((byte[])localObject1);
            }
            localbwh.aaeP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 19: 
          localbwh.AEA = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(169056);
          return 0;
        case 20: 
          localbwh.aaeQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169056);
          return 0;
        case 21: 
          localbwh.aaeR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 22: 
          localbwh.tabTipsByPassInfo = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(169056);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgc)localObject2).parseFrom((byte[])localObject1);
            }
            localbwh.aaeS = ((bgc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 24: 
          localbwh.ZNx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 25: 
          localbwh.aaeT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169056);
          return 0;
        case 26: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bwt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bwt)localObject2).parseFrom((byte[])localObject1);
            }
            localbwh.ZNq = ((bwt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 27: 
          localbwh.aaeU = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169056);
          return 0;
        case 28: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bwl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bwl)localObject2).parseFrom((byte[])localObject1);
            }
            localbwh.aaeV.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 29: 
          localbwh.aaeW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169056);
          return 0;
        case 30: 
          localbwh.aaeX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 32: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avb)localObject2).parseFrom((byte[])localObject1);
            }
            localbwh.ZKG = ((avb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 33: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bwj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bwj)localObject2).parseFrom((byte[])localObject1);
            }
            localbwh.aaeY = ((bwj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 34: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfu)localObject2).parseFrom((byte[])localObject1);
            }
            localbwh.ZKH = ((bfu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bwg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bwg)localObject2).parseFrom((byte[])localObject1);
          }
          localbwh.aaeZ = ((bwg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169056);
        return 0;
      }
      AppMethodBeat.o(169056);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwh
 * JD-Core Version:    0.7.0.1
 */