package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bqq
  extends erp
{
  public String EIo;
  public atz YIY;
  public aur ZDQ;
  public b ZEQ;
  public int ZER;
  public LinkedList<byg> ZHF;
  public bgc ZKD;
  public bcl ZKE;
  public bte ZKF;
  public bfu ZKH;
  public bwt ZNq;
  public LinkedList<dmk> ZNr;
  public int ZNt;
  public long ZNu;
  public LinkedList<age> ZYA;
  public int Zpm;
  public int iaK;
  public float latitude;
  public float longitude;
  
  public bqq()
  {
    AppMethodBeat.i(257596);
    this.ZNr = new LinkedList();
    this.ZHF = new LinkedList();
    this.ZYA = new LinkedList();
    AppMethodBeat.o(257596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257607);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(3, this.ZEQ);
      }
      paramVarArgs.l(4, this.longitude);
      paramVarArgs.l(5, this.latitude);
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(6, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      if (this.ZKD != null)
      {
        paramVarArgs.qD(7, this.ZKD.computeSize());
        this.ZKD.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.ZER);
      if (this.ZNq != null)
      {
        paramVarArgs.qD(9, this.ZNq.computeSize());
        this.ZNq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.ZNr);
      paramVarArgs.e(11, 8, this.ZHF);
      paramVarArgs.bS(12, this.iaK);
      if (this.ZKE != null)
      {
        paramVarArgs.qD(13, this.ZKE.computeSize());
        this.ZKE.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.ZNt);
      if (this.ZKF != null)
      {
        paramVarArgs.qD(15, this.ZKF.computeSize());
        this.ZKF.writeFields(paramVarArgs);
      }
      if (this.EIo != null) {
        paramVarArgs.g(16, this.EIo);
      }
      if (this.ZKH != null)
      {
        paramVarArgs.qD(17, this.ZKH.computeSize());
        this.ZKH.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(18, this.Zpm);
      paramVarArgs.bv(19, this.ZNu);
      paramVarArgs.e(20, 8, this.ZYA);
      AppMethodBeat.o(257607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2022;
      }
    }
    label2022:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZEQ);
      }
      i = i + (i.a.a.b.b.a.ko(4) + 4) + (i.a.a.b.b.a.ko(5) + 4);
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZDQ.computeSize());
      }
      i = paramInt;
      if (this.ZKD != null) {
        i = paramInt + i.a.a.a.qC(7, this.ZKD.computeSize());
      }
      i += i.a.a.b.b.a.cJ(8, this.ZER);
      paramInt = i;
      if (this.ZNq != null) {
        paramInt = i + i.a.a.a.qC(9, this.ZNq.computeSize());
      }
      i = paramInt + i.a.a.a.c(10, 8, this.ZNr) + i.a.a.a.c(11, 8, this.ZHF) + i.a.a.b.b.a.cJ(12, this.iaK);
      paramInt = i;
      if (this.ZKE != null) {
        paramInt = i + i.a.a.a.qC(13, this.ZKE.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.ZNt);
      paramInt = i;
      if (this.ZKF != null) {
        paramInt = i + i.a.a.a.qC(15, this.ZKF.computeSize());
      }
      i = paramInt;
      if (this.EIo != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.EIo);
      }
      paramInt = i;
      if (this.ZKH != null) {
        paramInt = i + i.a.a.a.qC(17, this.ZKH.computeSize());
      }
      i = i.a.a.b.b.a.cJ(18, this.Zpm);
      int j = i.a.a.b.b.a.q(19, this.ZNu);
      int k = i.a.a.a.c(20, 8, this.ZYA);
      AppMethodBeat.o(257607);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZNr.clear();
        this.ZHF.clear();
        this.ZYA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bqq localbqq = (bqq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257607);
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
            localbqq.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257607);
          return 0;
        case 2: 
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
            localbqq.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257607);
          return 0;
        case 3: 
          localbqq.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257607);
          return 0;
        case 4: 
          localbqq.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(257607);
          return 0;
        case 5: 
          localbqq.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(257607);
          return 0;
        case 6: 
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
            localbqq.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257607);
          return 0;
        case 7: 
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
            localbqq.ZKD = ((bgc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257607);
          return 0;
        case 8: 
          localbqq.ZER = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257607);
          return 0;
        case 9: 
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
            localbqq.ZNq = ((bwt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257607);
          return 0;
        case 10: 
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
            localbqq.ZNr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257607);
          return 0;
        case 11: 
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
            localbqq.ZHF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257607);
          return 0;
        case 12: 
          localbqq.iaK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257607);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcl)localObject2).parseFrom((byte[])localObject1);
            }
            localbqq.ZKE = ((bcl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257607);
          return 0;
        case 14: 
          localbqq.ZNt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257607);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bte();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bte)localObject2).parseFrom((byte[])localObject1);
            }
            localbqq.ZKF = ((bte)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257607);
          return 0;
        case 16: 
          localbqq.EIo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257607);
          return 0;
        case 17: 
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
            localbqq.ZKH = ((bfu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257607);
          return 0;
        case 18: 
          localbqq.Zpm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257607);
          return 0;
        case 19: 
          localbqq.ZNu = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257607);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new age();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((age)localObject2).parseFrom((byte[])localObject1);
          }
          localbqq.ZYA.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257607);
        return 0;
      }
      AppMethodBeat.o(257607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqq
 * JD-Core Version:    0.7.0.1
 */