package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ekb
  extends esc
{
  public String Vbl;
  public String abkK;
  public String abkL;
  public efj aboA;
  public String aboB;
  public ay aboy;
  public fmt aboz;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72565);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72565);
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
      if (this.abkK != null) {
        paramVarArgs.g(4, this.abkK);
      }
      if (this.abkL != null) {
        paramVarArgs.g(5, this.abkL);
      }
      if (this.aboy != null)
      {
        paramVarArgs.qD(6, this.aboy.computeSize());
        this.aboy.writeFields(paramVarArgs);
      }
      if (this.aboz != null)
      {
        paramVarArgs.qD(7, this.aboz.computeSize());
        this.aboz.writeFields(paramVarArgs);
      }
      if (this.aboA != null)
      {
        paramVarArgs.qD(8, this.aboA.computeSize());
        this.aboA.writeFields(paramVarArgs);
      }
      if (this.aboB != null) {
        paramVarArgs.g(9, this.aboB);
      }
      if (this.Vbl != null) {
        paramVarArgs.g(100, this.Vbl);
      }
      AppMethodBeat.o(72565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1118;
      }
    }
    label1118:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.abkK != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abkK);
      }
      paramInt = i;
      if (this.abkL != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abkL);
      }
      i = paramInt;
      if (this.aboy != null) {
        i = paramInt + i.a.a.a.qC(6, this.aboy.computeSize());
      }
      paramInt = i;
      if (this.aboz != null) {
        paramInt = i + i.a.a.a.qC(7, this.aboz.computeSize());
      }
      i = paramInt;
      if (this.aboA != null) {
        i = paramInt + i.a.a.a.qC(8, this.aboA.computeSize());
      }
      paramInt = i;
      if (this.aboB != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aboB);
      }
      i = paramInt;
      if (this.Vbl != null) {
        i = paramInt + i.a.a.b.b.a.h(100, this.Vbl);
      }
      AppMethodBeat.o(72565);
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
          AppMethodBeat.o(72565);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72565);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ekb localekb = (ekb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72565);
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
            localekb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 2: 
          localekb.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72565);
          return 0;
        case 3: 
          localekb.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 4: 
          localekb.abkK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 5: 
          localekb.abkL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ay();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ay)localObject2).parseFrom((byte[])localObject1);
            }
            localekb.aboy = ((ay)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmt)localObject2).parseFrom((byte[])localObject1);
            }
            localekb.aboz = ((fmt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efj)localObject2).parseFrom((byte[])localObject1);
            }
            localekb.aboA = ((efj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 9: 
          localekb.aboB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72565);
          return 0;
        }
        localekb.Vbl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(72565);
        return 0;
      }
      AppMethodBeat.o(72565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekb
 * JD-Core Version:    0.7.0.1
 */