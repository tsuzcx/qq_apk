package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ejz
  extends esc
{
  public String Vbl;
  public int abou;
  public String abov;
  public String abow;
  public cya abox;
  public dkf ifY;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91642);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91642);
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
      paramVarArgs.bS(4, this.abou);
      if (this.abov != null) {
        paramVarArgs.g(5, this.abov);
      }
      if (this.abow != null) {
        paramVarArgs.g(6, this.abow);
      }
      if (this.abox != null)
      {
        paramVarArgs.qD(7, this.abox.computeSize());
        this.abox.writeFields(paramVarArgs);
      }
      if (this.ifY != null)
      {
        paramVarArgs.qD(99, this.ifY.computeSize());
        this.ifY.writeFields(paramVarArgs);
      }
      if (this.Vbl != null) {
        paramVarArgs.g(100, this.Vbl);
      }
      AppMethodBeat.o(91642);
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
      i = paramInt + i.a.a.b.b.a.cJ(4, this.abou);
      paramInt = i;
      if (this.abov != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abov);
      }
      i = paramInt;
      if (this.abow != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abow);
      }
      paramInt = i;
      if (this.abox != null) {
        paramInt = i + i.a.a.a.qC(7, this.abox.computeSize());
      }
      i = paramInt;
      if (this.ifY != null) {
        i = paramInt + i.a.a.a.qC(99, this.ifY.computeSize());
      }
      paramInt = i;
      if (this.Vbl != null) {
        paramInt = i + i.a.a.b.b.a.h(100, this.Vbl);
      }
      AppMethodBeat.o(91642);
      return paramInt;
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
          AppMethodBeat.o(91642);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91642);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ejz localejz = (ejz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91642);
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
            localejz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
          return 0;
        case 2: 
          localejz.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91642);
          return 0;
        case 3: 
          localejz.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 4: 
          localejz.abou = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91642);
          return 0;
        case 5: 
          localejz.abov = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 6: 
          localejz.abow = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cya();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cya)localObject2).parseFrom((byte[])localObject1);
            }
            localejz.abox = ((cya)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
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
            localejz.ifY = ((dkf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
          return 0;
        }
        localejz.Vbl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91642);
        return 0;
      }
      AppMethodBeat.o(91642);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejz
 * JD-Core Version:    0.7.0.1
 */