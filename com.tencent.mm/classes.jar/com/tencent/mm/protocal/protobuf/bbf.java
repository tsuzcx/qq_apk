package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bbf
  extends erp
{
  public bve ACr;
  public long ADo;
  public int Auy;
  public long Avd;
  public int Bbt;
  public String Bbz;
  public aur ZDQ;
  public b ZEQ;
  public b ZFs;
  public atz ZHY;
  public fok ZLV;
  public b ZLW;
  public int fromType;
  public int hJx;
  public float latitude;
  public float longitude;
  public String topic;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168990);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZHY != null)
      {
        paramVarArgs.qD(2, this.ZHY.computeSize());
        this.ZHY.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(3, this.ZEQ);
      }
      paramVarArgs.bS(4, this.Auy);
      if (this.topic != null) {
        paramVarArgs.g(5, this.topic);
      }
      paramVarArgs.l(6, this.longitude);
      paramVarArgs.l(7, this.latitude);
      paramVarArgs.bv(8, this.Avd);
      paramVarArgs.bS(9, this.hJx);
      if (this.ZLV != null)
      {
        paramVarArgs.qD(10, this.ZLV.computeSize());
        this.ZLV.writeFields(paramVarArgs);
      }
      if (this.ACr != null)
      {
        paramVarArgs.qD(11, this.ACr.computeSize());
        this.ACr.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.fromType);
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(13, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(14, this.ADo);
      if (this.ZLW != null) {
        paramVarArgs.d(15, this.ZLW);
      }
      if (this.Bbz != null) {
        paramVarArgs.g(16, this.Bbz);
      }
      paramVarArgs.bS(17, this.Bbt);
      if (this.ZFs != null) {
        paramVarArgs.d(18, this.ZFs);
      }
      AppMethodBeat.o(168990);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1486;
      }
    }
    label1486:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZHY != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZHY.computeSize());
      }
      i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZEQ);
      }
      i += i.a.a.b.b.a.cJ(4, this.Auy);
      paramInt = i;
      if (this.topic != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.topic);
      }
      i = paramInt + (i.a.a.b.b.a.ko(6) + 4) + (i.a.a.b.b.a.ko(7) + 4) + i.a.a.b.b.a.q(8, this.Avd) + i.a.a.b.b.a.cJ(9, this.hJx);
      paramInt = i;
      if (this.ZLV != null) {
        paramInt = i + i.a.a.a.qC(10, this.ZLV.computeSize());
      }
      i = paramInt;
      if (this.ACr != null) {
        i = paramInt + i.a.a.a.qC(11, this.ACr.computeSize());
      }
      i += i.a.a.b.b.a.cJ(12, this.fromType);
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(13, this.ZDQ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(14, this.ADo);
      paramInt = i;
      if (this.ZLW != null) {
        paramInt = i + i.a.a.b.b.a.c(15, this.ZLW);
      }
      i = paramInt;
      if (this.Bbz != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.Bbz);
      }
      i += i.a.a.b.b.a.cJ(17, this.Bbt);
      paramInt = i;
      if (this.ZFs != null) {
        paramInt = i + i.a.a.b.b.a.c(18, this.ZFs);
      }
      AppMethodBeat.o(168990);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168990);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bbf localbbf = (bbf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168990);
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
            localbbf.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
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
            localbbf.ZHY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 3: 
          localbbf.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168990);
          return 0;
        case 4: 
          localbbf.Auy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168990);
          return 0;
        case 5: 
          localbbf.topic = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168990);
          return 0;
        case 6: 
          localbbf.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(168990);
          return 0;
        case 7: 
          localbbf.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(168990);
          return 0;
        case 8: 
          localbbf.Avd = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168990);
          return 0;
        case 9: 
          localbbf.hJx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168990);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fok();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fok)localObject2).parseFrom((byte[])localObject1);
            }
            localbbf.ZLV = ((fok)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 11: 
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
            localbbf.ACr = ((bve)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 12: 
          localbbf.fromType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168990);
          return 0;
        case 13: 
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
            localbbf.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 14: 
          localbbf.ADo = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168990);
          return 0;
        case 15: 
          localbbf.ZLW = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168990);
          return 0;
        case 16: 
          localbbf.Bbz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168990);
          return 0;
        case 17: 
          localbbf.Bbt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168990);
          return 0;
        }
        localbbf.ZFs = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(168990);
        return 0;
      }
      AppMethodBeat.o(168990);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbf
 * JD-Core Version:    0.7.0.1
 */