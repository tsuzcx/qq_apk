package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cnr
  extends esc
{
  public int aaqL;
  public ean aauW;
  public eao aauX;
  public eao aauY;
  public eap aauZ;
  public String wuA;
  public int wuz;
  public int xlj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114033);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114033);
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
      paramVarArgs.bS(4, this.xlj);
      paramVarArgs.bS(5, this.aaqL);
      if (this.aauW != null)
      {
        paramVarArgs.qD(6, this.aauW.computeSize());
        this.aauW.writeFields(paramVarArgs);
      }
      if (this.aauX != null)
      {
        paramVarArgs.qD(7, this.aauX.computeSize());
        this.aauX.writeFields(paramVarArgs);
      }
      if (this.aauY != null)
      {
        paramVarArgs.qD(8, this.aauY.computeSize());
        this.aauY.writeFields(paramVarArgs);
      }
      if (this.aauZ != null)
      {
        paramVarArgs.qD(9, this.aauZ.computeSize());
        this.aauZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114033);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1060;
      }
    }
    label1060:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.xlj) + i.a.a.b.b.a.cJ(5, this.aaqL);
      paramInt = i;
      if (this.aauW != null) {
        paramInt = i + i.a.a.a.qC(6, this.aauW.computeSize());
      }
      i = paramInt;
      if (this.aauX != null) {
        i = paramInt + i.a.a.a.qC(7, this.aauX.computeSize());
      }
      paramInt = i;
      if (this.aauY != null) {
        paramInt = i + i.a.a.a.qC(8, this.aauY.computeSize());
      }
      i = paramInt;
      if (this.aauZ != null) {
        i = paramInt + i.a.a.a.qC(9, this.aauZ.computeSize());
      }
      AppMethodBeat.o(114033);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114033);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114033);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cnr localcnr = (cnr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114033);
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
            localcnr.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        case 2: 
          localcnr.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114033);
          return 0;
        case 3: 
          localcnr.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114033);
          return 0;
        case 4: 
          localcnr.xlj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114033);
          return 0;
        case 5: 
          localcnr.aaqL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114033);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ean();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ean)localObject2).parseFrom((byte[])localObject1);
            }
            localcnr.aauW = ((ean)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eao();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eao)localObject2).parseFrom((byte[])localObject1);
            }
            localcnr.aauX = ((eao)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eao();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eao)localObject2).parseFrom((byte[])localObject1);
            }
            localcnr.aauY = ((eao)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eap();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eap)localObject2).parseFrom((byte[])localObject1);
          }
          localcnr.aauZ = ((eap)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114033);
        return 0;
      }
      AppMethodBeat.o(114033);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnr
 * JD-Core Version:    0.7.0.1
 */