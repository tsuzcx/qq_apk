package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dsq
  extends erp
{
  public chq BfT;
  public atz YIY;
  public aur ZDQ;
  public b ZEQ;
  public b ZFz;
  public int ZHD;
  public LinkedList<fhp> ZHE;
  public bgc ZKD;
  public bau ZLE;
  public b ZLG;
  public fkp ZLH;
  public crk ZLI;
  public String aaYk;
  public bve aaYl;
  public auj aaYm;
  public String aaYn;
  public String from_username;
  public float latitude;
  public float longitude;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  public String source;
  public String waL;
  
  public dsq()
  {
    AppMethodBeat.i(259589);
    this.ZHE = new LinkedList();
    AppMethodBeat.o(259589);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259603);
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
      paramVarArgs.bv(4, this.object_id);
      paramVarArgs.l(6, this.longitude);
      paramVarArgs.l(7, this.latitude);
      paramVarArgs.bS(5, this.ZHD);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(8, this.object_nonce_id);
      }
      if (this.aaYk != null) {
        paramVarArgs.g(9, this.aaYk);
      }
      paramVarArgs.bS(10, this.scene);
      if (this.source != null) {
        paramVarArgs.g(11, this.source);
      }
      if (this.aaYl != null)
      {
        paramVarArgs.qD(12, this.aaYl.computeSize());
        this.aaYl.writeFields(paramVarArgs);
      }
      if (this.aaYm != null)
      {
        paramVarArgs.qD(13, this.aaYm.computeSize());
        this.aaYm.writeFields(paramVarArgs);
      }
      if (this.ZFz != null) {
        paramVarArgs.d(14, this.ZFz);
      }
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(15, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      if (this.from_username != null) {
        paramVarArgs.g(16, this.from_username);
      }
      if (this.waL != null) {
        paramVarArgs.g(17, this.waL);
      }
      if (this.ZLE != null)
      {
        paramVarArgs.qD(18, this.ZLE.computeSize());
        this.ZLE.writeFields(paramVarArgs);
      }
      if (this.aaYn != null) {
        paramVarArgs.g(19, this.aaYn);
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
      AppMethodBeat.o(259603);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2390;
      }
    }
    label2390:
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
      i = i + i.a.a.b.b.a.q(4, this.object_id) + (i.a.a.b.b.a.ko(6) + 4) + (i.a.a.b.b.a.ko(7) + 4) + i.a.a.b.b.a.cJ(5, this.ZHD);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.object_nonce_id);
      }
      i = paramInt;
      if (this.aaYk != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.aaYk);
      }
      i += i.a.a.b.b.a.cJ(10, this.scene);
      paramInt = i;
      if (this.source != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.source);
      }
      i = paramInt;
      if (this.aaYl != null) {
        i = paramInt + i.a.a.a.qC(12, this.aaYl.computeSize());
      }
      paramInt = i;
      if (this.aaYm != null) {
        paramInt = i + i.a.a.a.qC(13, this.aaYm.computeSize());
      }
      i = paramInt;
      if (this.ZFz != null) {
        i = paramInt + i.a.a.b.b.a.c(14, this.ZFz);
      }
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(15, this.ZDQ.computeSize());
      }
      i = paramInt;
      if (this.from_username != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.from_username);
      }
      paramInt = i;
      if (this.waL != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.waL);
      }
      i = paramInt;
      if (this.ZLE != null) {
        i = paramInt + i.a.a.a.qC(18, this.ZLE.computeSize());
      }
      paramInt = i;
      if (this.aaYn != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.aaYn);
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
      AppMethodBeat.o(259603);
      return i;
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
        AppMethodBeat.o(259603);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dsq localdsq = (dsq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259603);
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
            localdsq.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259603);
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
            localdsq.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259603);
          return 0;
        case 3: 
          localdsq.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259603);
          return 0;
        case 4: 
          localdsq.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259603);
          return 0;
        case 6: 
          localdsq.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(259603);
          return 0;
        case 7: 
          localdsq.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(259603);
          return 0;
        case 5: 
          localdsq.ZHD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259603);
          return 0;
        case 8: 
          localdsq.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259603);
          return 0;
        case 9: 
          localdsq.aaYk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259603);
          return 0;
        case 10: 
          localdsq.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259603);
          return 0;
        case 11: 
          localdsq.source = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259603);
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
            localdsq.aaYl = ((bve)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259603);
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
            localdsq.aaYm = ((auj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259603);
          return 0;
        case 14: 
          localdsq.ZFz = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259603);
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
            localdsq.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259603);
          return 0;
        case 16: 
          localdsq.from_username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259603);
          return 0;
        case 17: 
          localdsq.waL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259603);
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
            localdsq.ZLE = ((bau)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259603);
          return 0;
        case 19: 
          localdsq.aaYn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259603);
          return 0;
        case 20: 
          localdsq.ZLG = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259603);
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
            localdsq.ZLH = ((fkp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259603);
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
            localdsq.BfT = ((chq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259603);
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
            localdsq.ZHE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259603);
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
            localdsq.ZLI = ((crk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259603);
          return 0;
        }
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
          localdsq.ZKD = ((bgc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259603);
        return 0;
      }
      AppMethodBeat.o(259603);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsq
 * JD-Core Version:    0.7.0.1
 */