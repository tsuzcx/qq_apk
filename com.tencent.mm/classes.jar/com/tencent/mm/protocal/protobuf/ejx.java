package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ejx
  extends esc
{
  public boolean aaFF;
  public dac aaFG;
  public uj aatd;
  public dah aatf;
  public String abiA;
  public String abiB;
  public dus ign;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72563);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72563);
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
      if (this.aatf != null)
      {
        paramVarArgs.qD(4, this.aatf.computeSize());
        this.aatf.writeFields(paramVarArgs);
      }
      if (this.abiA != null) {
        paramVarArgs.g(5, this.abiA);
      }
      if (this.abiB != null) {
        paramVarArgs.g(6, this.abiB);
      }
      if (this.aatd != null)
      {
        paramVarArgs.qD(7, this.aatd.computeSize());
        this.aatd.writeFields(paramVarArgs);
      }
      if (this.ign != null)
      {
        paramVarArgs.qD(8, this.ign.computeSize());
        this.ign.writeFields(paramVarArgs);
      }
      paramVarArgs.di(9, this.aaFF);
      if (this.aaFG != null)
      {
        paramVarArgs.qD(10, this.aaFG.computeSize());
        this.aaFG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72563);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1136;
      }
    }
    label1136:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.aatf != null) {
        i = paramInt + i.a.a.a.qC(4, this.aatf.computeSize());
      }
      paramInt = i;
      if (this.abiA != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abiA);
      }
      i = paramInt;
      if (this.abiB != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abiB);
      }
      paramInt = i;
      if (this.aatd != null) {
        paramInt = i + i.a.a.a.qC(7, this.aatd.computeSize());
      }
      i = paramInt;
      if (this.ign != null) {
        i = paramInt + i.a.a.a.qC(8, this.ign.computeSize());
      }
      i += i.a.a.b.b.a.ko(9) + 1;
      paramInt = i;
      if (this.aaFG != null) {
        paramInt = i + i.a.a.a.qC(10, this.aaFG.computeSize());
      }
      AppMethodBeat.o(72563);
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
          AppMethodBeat.o(72563);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ejx localejx = (ejx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72563);
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
            localejx.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 2: 
          localejx.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72563);
          return 0;
        case 3: 
          localejx.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dah();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dah)localObject2).parseFrom((byte[])localObject1);
            }
            localejx.aatf = ((dah)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 5: 
          localejx.abiA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 6: 
          localejx.abiB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uj)localObject2).parseFrom((byte[])localObject1);
            }
            localejx.aatd = ((uj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dus();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dus)localObject2).parseFrom((byte[])localObject1);
            }
            localejx.ign = ((dus)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 9: 
          localejx.aaFF = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(72563);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dac();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dac)localObject2).parseFrom((byte[])localObject1);
          }
          localejx.aaFG = ((dac)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      AppMethodBeat.o(72563);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejx
 * JD-Core Version:    0.7.0.1
 */