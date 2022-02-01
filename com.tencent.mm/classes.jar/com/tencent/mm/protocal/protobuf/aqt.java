package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class aqt
  extends esc
{
  public LinkedList<dfy> ZgM;
  public ehp ZxP;
  public String ZxQ;
  public String ZxR;
  public String ZxS;
  public String ZxT;
  public float ZxU;
  public String ZxV;
  public float ZxW;
  public String ZxX;
  public String ZxY;
  public String ZxZ;
  public String Zya;
  public ehp Zyb;
  public int zRU;
  public String zRV;
  
  public aqt()
  {
    AppMethodBeat.i(104361);
    this.ZgM = new LinkedList();
    AppMethodBeat.o(104361);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104362);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104362);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZgM);
      if (this.ZxP != null)
      {
        paramVarArgs.qD(3, this.ZxP.computeSize());
        this.ZxP.writeFields(paramVarArgs);
      }
      if (this.ZxQ != null) {
        paramVarArgs.g(4, this.ZxQ);
      }
      if (this.ZxR != null) {
        paramVarArgs.g(5, this.ZxR);
      }
      if (this.ZxS != null) {
        paramVarArgs.g(6, this.ZxS);
      }
      if (this.ZxT != null) {
        paramVarArgs.g(7, this.ZxT);
      }
      paramVarArgs.l(8, this.ZxU);
      paramVarArgs.bS(9, this.zRU);
      if (this.zRV != null) {
        paramVarArgs.g(10, this.zRV);
      }
      if (this.ZxV != null) {
        paramVarArgs.g(11, this.ZxV);
      }
      paramVarArgs.l(12, this.ZxW);
      if (this.ZxX != null) {
        paramVarArgs.g(13, this.ZxX);
      }
      if (this.ZxY != null) {
        paramVarArgs.g(14, this.ZxY);
      }
      if (this.ZxZ != null) {
        paramVarArgs.g(15, this.ZxZ);
      }
      if (this.Zya != null) {
        paramVarArgs.g(16, this.Zya);
      }
      if (this.Zyb != null)
      {
        paramVarArgs.qD(17, this.Zyb.computeSize());
        this.Zyb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1472;
      }
    }
    label1472:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZgM);
      paramInt = i;
      if (this.ZxP != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZxP.computeSize());
      }
      i = paramInt;
      if (this.ZxQ != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZxQ);
      }
      paramInt = i;
      if (this.ZxR != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZxR);
      }
      i = paramInt;
      if (this.ZxS != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZxS);
      }
      paramInt = i;
      if (this.ZxT != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZxT);
      }
      i = paramInt + (i.a.a.b.b.a.ko(8) + 4) + i.a.a.b.b.a.cJ(9, this.zRU);
      paramInt = i;
      if (this.zRV != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.zRV);
      }
      i = paramInt;
      if (this.ZxV != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ZxV);
      }
      i += i.a.a.b.b.a.ko(12) + 4;
      paramInt = i;
      if (this.ZxX != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.ZxX);
      }
      i = paramInt;
      if (this.ZxY != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.ZxY);
      }
      paramInt = i;
      if (this.ZxZ != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.ZxZ);
      }
      i = paramInt;
      if (this.Zya != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.Zya);
      }
      paramInt = i;
      if (this.Zyb != null) {
        paramInt = i + i.a.a.a.qC(17, this.Zyb.computeSize());
      }
      AppMethodBeat.o(104362);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZgM.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104362);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104362);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aqt localaqt = (aqt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104362);
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
            localaqt.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dfy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dfy)localObject2).parseFrom((byte[])localObject1);
            }
            localaqt.ZgM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehp)localObject2).parseFrom((byte[])localObject1);
            }
            localaqt.ZxP = ((ehp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 4: 
          localaqt.ZxQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 5: 
          localaqt.ZxR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 6: 
          localaqt.ZxS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 7: 
          localaqt.ZxT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 8: 
          localaqt.ZxU = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(104362);
          return 0;
        case 9: 
          localaqt.zRU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104362);
          return 0;
        case 10: 
          localaqt.zRV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 11: 
          localaqt.ZxV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 12: 
          localaqt.ZxW = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(104362);
          return 0;
        case 13: 
          localaqt.ZxX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 14: 
          localaqt.ZxY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 15: 
          localaqt.ZxZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 16: 
          localaqt.Zya = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104362);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ehp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ehp)localObject2).parseFrom((byte[])localObject1);
          }
          localaqt.Zyb = ((ehp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104362);
        return 0;
      }
      AppMethodBeat.o(104362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqt
 * JD-Core Version:    0.7.0.1
 */