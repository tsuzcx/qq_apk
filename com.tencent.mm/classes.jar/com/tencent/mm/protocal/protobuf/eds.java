package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eds
  extends esc
{
  public long UZv;
  public String UZw;
  public String UZy;
  public String UZz;
  public LinkedList<edt> abiO;
  public js abiP;
  public int abiQ;
  public String wuA;
  public int wuz;
  
  public eds()
  {
    AppMethodBeat.i(91616);
    this.abiO = new LinkedList();
    AppMethodBeat.o(91616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91617);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91617);
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
      paramVarArgs.e(4, 8, this.abiO);
      paramVarArgs.bv(5, this.UZv);
      if (this.UZw != null) {
        paramVarArgs.g(6, this.UZw);
      }
      if (this.abiP != null)
      {
        paramVarArgs.qD(7, this.abiP.computeSize());
        this.abiP.writeFields(paramVarArgs);
      }
      if (this.UZy != null) {
        paramVarArgs.g(8, this.UZy);
      }
      if (this.UZz != null) {
        paramVarArgs.g(9, this.UZz);
      }
      paramVarArgs.bS(10, this.abiQ);
      AppMethodBeat.o(91617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label964;
      }
    }
    label964:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.a.c(4, 8, this.abiO) + i.a.a.b.b.a.q(5, this.UZv);
      paramInt = i;
      if (this.UZw != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.UZw);
      }
      i = paramInt;
      if (this.abiP != null) {
        i = paramInt + i.a.a.a.qC(7, this.abiP.computeSize());
      }
      paramInt = i;
      if (this.UZy != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.UZy);
      }
      i = paramInt;
      if (this.UZz != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.UZz);
      }
      paramInt = i.a.a.b.b.a.cJ(10, this.abiQ);
      AppMethodBeat.o(91617);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abiO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eds localeds = (eds)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91617);
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
            localeds.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 2: 
          localeds.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91617);
          return 0;
        case 3: 
          localeds.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new edt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((edt)localObject2).parseFrom((byte[])localObject1);
            }
            localeds.abiO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 5: 
          localeds.UZv = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91617);
          return 0;
        case 6: 
          localeds.UZw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new js();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((js)localObject2).parseFrom((byte[])localObject1);
            }
            localeds.abiP = ((js)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 8: 
          localeds.UZy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 9: 
          localeds.UZz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91617);
          return 0;
        }
        localeds.abiQ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91617);
        return 0;
      }
      AppMethodBeat.o(91617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eds
 * JD-Core Version:    0.7.0.1
 */