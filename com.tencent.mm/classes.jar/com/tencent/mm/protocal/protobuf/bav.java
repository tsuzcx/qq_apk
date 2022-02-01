package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bav
  extends erp
{
  public bve ACr;
  public b AEn;
  public chq BfT;
  public aur ZDQ;
  public atz ZEc;
  public LinkedList<fhp> ZHE;
  public bgc ZKD;
  public bfu ZKH;
  public String ZLB;
  public String ZLC;
  public auj ZLD;
  public bau ZLE;
  public String ZLF;
  public b ZLG;
  public fkp ZLH;
  public crk ZLI;
  public int hJx;
  public long hKN;
  public String hgk;
  public String hgl;
  public b lastBuffer;
  public float latitude;
  public float longitude;
  public String objectNonceId;
  public int scene;
  
  public bav()
  {
    AppMethodBeat.i(260020);
    this.ZHE = new LinkedList();
    AppMethodBeat.o(260020);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260032);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZEc != null)
      {
        paramVarArgs.qD(2, this.ZEc.computeSize());
        this.ZEc.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.d(3, this.lastBuffer);
      }
      paramVarArgs.bv(4, this.hKN);
      paramVarArgs.bS(5, this.hJx);
      paramVarArgs.l(6, this.longitude);
      paramVarArgs.l(7, this.latitude);
      if (this.objectNonceId != null) {
        paramVarArgs.g(8, this.objectNonceId);
      }
      if (this.ZLB != null) {
        paramVarArgs.g(9, this.ZLB);
      }
      paramVarArgs.bS(10, this.scene);
      if (this.ZLC != null) {
        paramVarArgs.g(11, this.ZLC);
      }
      if (this.ACr != null)
      {
        paramVarArgs.qD(12, this.ACr.computeSize());
        this.ACr.writeFields(paramVarArgs);
      }
      if (this.ZLD != null)
      {
        paramVarArgs.qD(13, this.ZLD.computeSize());
        this.ZLD.writeFields(paramVarArgs);
      }
      if (this.AEn != null) {
        paramVarArgs.d(14, this.AEn);
      }
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(15, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      if (this.hgk != null) {
        paramVarArgs.g(16, this.hgk);
      }
      if (this.hgl != null) {
        paramVarArgs.g(17, this.hgl);
      }
      if (this.ZLE != null)
      {
        paramVarArgs.qD(18, this.ZLE.computeSize());
        this.ZLE.writeFields(paramVarArgs);
      }
      if (this.ZLF != null) {
        paramVarArgs.g(19, this.ZLF);
      }
      if (this.ZLG != null) {
        paramVarArgs.d(20, this.ZLG);
      }
      if (this.ZLH != null)
      {
        paramVarArgs.qD(21, this.ZLH.computeSize());
        this.ZLH.writeFields(paramVarArgs);
      }
      if (this.BfT != null)
      {
        paramVarArgs.qD(22, this.BfT.computeSize());
        this.BfT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 8, this.ZHE);
      if (this.ZLI != null)
      {
        paramVarArgs.qD(24, this.ZLI.computeSize());
        this.ZLI.writeFields(paramVarArgs);
      }
      if (this.ZKD != null)
      {
        paramVarArgs.qD(25, this.ZKD.computeSize());
        this.ZKD.writeFields(paramVarArgs);
      }
      if (this.ZKH != null)
      {
        paramVarArgs.qD(26, this.ZKH.computeSize());
        this.ZKH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260032);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2524;
      }
    }
    label2524:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZEc != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.lastBuffer);
      }
      i = i + i.a.a.b.b.a.q(4, this.hKN) + i.a.a.b.b.a.cJ(5, this.hJx) + (i.a.a.b.b.a.ko(6) + 4) + (i.a.a.b.b.a.ko(7) + 4);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.objectNonceId);
      }
      i = paramInt;
      if (this.ZLB != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZLB);
      }
      i += i.a.a.b.b.a.cJ(10, this.scene);
      paramInt = i;
      if (this.ZLC != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZLC);
      }
      i = paramInt;
      if (this.ACr != null) {
        i = paramInt + i.a.a.a.qC(12, this.ACr.computeSize());
      }
      paramInt = i;
      if (this.ZLD != null) {
        paramInt = i + i.a.a.a.qC(13, this.ZLD.computeSize());
      }
      i = paramInt;
      if (this.AEn != null) {
        i = paramInt + i.a.a.b.b.a.c(14, this.AEn);
      }
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(15, this.ZDQ.computeSize());
      }
      i = paramInt;
      if (this.hgk != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.hgk);
      }
      paramInt = i;
      if (this.hgl != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.hgl);
      }
      i = paramInt;
      if (this.ZLE != null) {
        i = paramInt + i.a.a.a.qC(18, this.ZLE.computeSize());
      }
      paramInt = i;
      if (this.ZLF != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.ZLF);
      }
      i = paramInt;
      if (this.ZLG != null) {
        i = paramInt + i.a.a.b.b.a.c(20, this.ZLG);
      }
      paramInt = i;
      if (this.ZLH != null) {
        paramInt = i + i.a.a.a.qC(21, this.ZLH.computeSize());
      }
      i = paramInt;
      if (this.BfT != null) {
        i = paramInt + i.a.a.a.qC(22, this.BfT.computeSize());
      }
      i += i.a.a.a.c(23, 8, this.ZHE);
      paramInt = i;
      if (this.ZLI != null) {
        paramInt = i + i.a.a.a.qC(24, this.ZLI.computeSize());
      }
      i = paramInt;
      if (this.ZKD != null) {
        i = paramInt + i.a.a.a.qC(25, this.ZKD.computeSize());
      }
      paramInt = i;
      if (this.ZKH != null) {
        paramInt = i + i.a.a.a.qC(26, this.ZKH.computeSize());
      }
      AppMethodBeat.o(260032);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZHE.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260032);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bav localbav = (bav)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260032);
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
            localbav.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260032);
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
            localbav.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260032);
          return 0;
        case 3: 
          localbav.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(260032);
          return 0;
        case 4: 
          localbav.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260032);
          return 0;
        case 5: 
          localbav.hJx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260032);
          return 0;
        case 6: 
          localbav.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(260032);
          return 0;
        case 7: 
          localbav.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(260032);
          return 0;
        case 8: 
          localbav.objectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260032);
          return 0;
        case 9: 
          localbav.ZLB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260032);
          return 0;
        case 10: 
          localbav.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260032);
          return 0;
        case 11: 
          localbav.ZLC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260032);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bve();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bve)localObject2).parseFrom((byte[])localObject1);
            }
            localbav.ACr = ((bve)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260032);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new auj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((auj)localObject2).parseFrom((byte[])localObject1);
            }
            localbav.ZLD = ((auj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260032);
          return 0;
        case 14: 
          localbav.AEn = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(260032);
          return 0;
        case 15: 
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
            localbav.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260032);
          return 0;
        case 16: 
          localbav.hgk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260032);
          return 0;
        case 17: 
          localbav.hgl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260032);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bau();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bau)localObject2).parseFrom((byte[])localObject1);
            }
            localbav.ZLE = ((bau)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260032);
          return 0;
        case 19: 
          localbav.ZLF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260032);
          return 0;
        case 20: 
          localbav.ZLG = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(260032);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fkp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fkp)localObject2).parseFrom((byte[])localObject1);
            }
            localbav.ZLH = ((fkp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260032);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new chq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((chq)localObject2).parseFrom((byte[])localObject1);
            }
            localbav.BfT = ((chq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260032);
          return 0;
        case 23: 
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
            localbav.ZHE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260032);
          return 0;
        case 24: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new crk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((crk)localObject2).parseFrom((byte[])localObject1);
            }
            localbav.ZLI = ((crk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260032);
          return 0;
        case 25: 
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
            localbav.ZKD = ((bgc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260032);
          return 0;
        }
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
          localbav.ZKH = ((bfu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260032);
        return 0;
      }
      AppMethodBeat.o(260032);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bav
 * JD-Core Version:    0.7.0.1
 */