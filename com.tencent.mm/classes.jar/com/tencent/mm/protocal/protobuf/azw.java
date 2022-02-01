package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class azw
  extends erp
{
  public String EIo;
  public atz YIY;
  public aur ZDQ;
  public b ZEQ;
  public int ZER;
  public LinkedList<fhp> ZHE;
  public String ZJK;
  public bgc ZKD;
  public bcl ZKE;
  public bte ZKF;
  public avb ZKG;
  public bfu ZKH;
  public LinkedList<bly> ZKI;
  public int ZKJ;
  public LinkedList<Long> ZKK;
  public b ZKL;
  public b ZKM;
  public float latitude;
  public float longitude;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  
  public azw()
  {
    AppMethodBeat.i(258920);
    this.ZHE = new LinkedList();
    this.ZKI = new LinkedList();
    this.ZKK = new LinkedList();
    AppMethodBeat.o(258920);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258930);
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
      if (this.object_nonce_id != null) {
        paramVarArgs.g(5, this.object_nonce_id);
      }
      paramVarArgs.l(6, this.longitude);
      paramVarArgs.l(7, this.latitude);
      paramVarArgs.bS(8, this.scene);
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(9, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      if (this.ZKD != null)
      {
        paramVarArgs.qD(10, this.ZKD.computeSize());
        this.ZKD.writeFields(paramVarArgs);
      }
      if (this.ZJK != null) {
        paramVarArgs.g(11, this.ZJK);
      }
      if (this.ZKE != null)
      {
        paramVarArgs.qD(12, this.ZKE.computeSize());
        this.ZKE.writeFields(paramVarArgs);
      }
      if (this.ZKF != null)
      {
        paramVarArgs.qD(13, this.ZKF.computeSize());
        this.ZKF.writeFields(paramVarArgs);
      }
      if (this.EIo != null) {
        paramVarArgs.g(14, this.EIo);
      }
      if (this.ZKG != null)
      {
        paramVarArgs.qD(16, this.ZKG.computeSize());
        this.ZKG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.ZHE);
      paramVarArgs.bS(18, this.ZER);
      if (this.ZKH != null)
      {
        paramVarArgs.qD(19, this.ZKH.computeSize());
        this.ZKH.writeFields(paramVarArgs);
      }
      paramVarArgs.e(20, 8, this.ZKI);
      paramVarArgs.bS(21, this.ZKJ);
      paramVarArgs.e(22, 3, this.ZKK);
      if (this.ZKL != null) {
        paramVarArgs.d(23, this.ZKL);
      }
      if (this.ZKM != null) {
        paramVarArgs.d(24, this.ZKM);
      }
      AppMethodBeat.o(258930);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2163;
      }
    }
    label2163:
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
      i += i.a.a.b.b.a.q(4, this.object_id);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.object_nonce_id);
      }
      i = paramInt + (i.a.a.b.b.a.ko(6) + 4) + (i.a.a.b.b.a.ko(7) + 4) + i.a.a.b.b.a.cJ(8, this.scene);
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(9, this.ZDQ.computeSize());
      }
      i = paramInt;
      if (this.ZKD != null) {
        i = paramInt + i.a.a.a.qC(10, this.ZKD.computeSize());
      }
      paramInt = i;
      if (this.ZJK != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZJK);
      }
      i = paramInt;
      if (this.ZKE != null) {
        i = paramInt + i.a.a.a.qC(12, this.ZKE.computeSize());
      }
      paramInt = i;
      if (this.ZKF != null) {
        paramInt = i + i.a.a.a.qC(13, this.ZKF.computeSize());
      }
      i = paramInt;
      if (this.EIo != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.EIo);
      }
      paramInt = i;
      if (this.ZKG != null) {
        paramInt = i + i.a.a.a.qC(16, this.ZKG.computeSize());
      }
      i = paramInt + i.a.a.a.c(17, 8, this.ZHE) + i.a.a.b.b.a.cJ(18, this.ZER);
      paramInt = i;
      if (this.ZKH != null) {
        paramInt = i + i.a.a.a.qC(19, this.ZKH.computeSize());
      }
      i = paramInt + i.a.a.a.c(20, 8, this.ZKI) + i.a.a.b.b.a.cJ(21, this.ZKJ) + i.a.a.a.c(22, 3, this.ZKK);
      paramInt = i;
      if (this.ZKL != null) {
        paramInt = i + i.a.a.b.b.a.c(23, this.ZKL);
      }
      i = paramInt;
      if (this.ZKM != null) {
        i = paramInt + i.a.a.b.b.a.c(24, this.ZKM);
      }
      AppMethodBeat.o(258930);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZHE.clear();
        this.ZKI.clear();
        this.ZKK.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258930);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azw localazw = (azw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 15: 
        default: 
          AppMethodBeat.o(258930);
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
            localazw.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258930);
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
            localazw.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258930);
          return 0;
        case 3: 
          localazw.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258930);
          return 0;
        case 4: 
          localazw.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258930);
          return 0;
        case 5: 
          localazw.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258930);
          return 0;
        case 6: 
          localazw.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(258930);
          return 0;
        case 7: 
          localazw.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(258930);
          return 0;
        case 8: 
          localazw.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258930);
          return 0;
        case 9: 
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
            localazw.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258930);
          return 0;
        case 10: 
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
            localazw.ZKD = ((bgc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258930);
          return 0;
        case 11: 
          localazw.ZJK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258930);
          return 0;
        case 12: 
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
            localazw.ZKE = ((bcl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258930);
          return 0;
        case 13: 
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
            localazw.ZKF = ((bte)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258930);
          return 0;
        case 14: 
          localazw.EIo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258930);
          return 0;
        case 16: 
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
            localazw.ZKG = ((avb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258930);
          return 0;
        case 17: 
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
            localazw.ZHE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258930);
          return 0;
        case 18: 
          localazw.ZER = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258930);
          return 0;
        case 19: 
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
            localazw.ZKH = ((bfu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258930);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bly();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bly)localObject2).parseFrom((byte[])localObject1);
            }
            localazw.ZKI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258930);
          return 0;
        case 21: 
          localazw.ZKJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258930);
          return 0;
        case 22: 
          localazw.ZKK.add(Long.valueOf(((i.a.a.a.a)localObject1).ajGk.aaw()));
          AppMethodBeat.o(258930);
          return 0;
        case 23: 
          localazw.ZKL = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258930);
          return 0;
        }
        localazw.ZKM = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(258930);
        return 0;
      }
      AppMethodBeat.o(258930);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azw
 * JD-Core Version:    0.7.0.1
 */