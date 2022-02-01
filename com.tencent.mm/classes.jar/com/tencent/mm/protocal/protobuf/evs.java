package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class evs
  extends esc
{
  public cyx YNR;
  public cyy YNS;
  public String YNj;
  public dph YNk;
  public int abyv;
  public em abyw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32422);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.YNk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Contact");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.YNR == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.YNS == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YNk != null)
      {
        paramVarArgs.qD(2, this.YNk.computeSize());
        this.YNk.writeFields(paramVarArgs);
      }
      if (this.YNR != null)
      {
        paramVarArgs.qD(3, this.YNR.computeSize());
        this.YNR.writeFields(paramVarArgs);
      }
      if (this.YNS != null)
      {
        paramVarArgs.qD(4, this.YNS.computeSize());
        this.YNS.writeFields(paramVarArgs);
      }
      if (this.YNj != null) {
        paramVarArgs.g(5, this.YNj);
      }
      paramVarArgs.bS(6, this.abyv);
      if (this.abyw != null)
      {
        paramVarArgs.qD(7, this.abyw.computeSize());
        this.abyw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1133;
      }
    }
    label1133:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YNk != null) {
        paramInt = i + i.a.a.a.qC(2, this.YNk.computeSize());
      }
      i = paramInt;
      if (this.YNR != null) {
        i = paramInt + i.a.a.a.qC(3, this.YNR.computeSize());
      }
      paramInt = i;
      if (this.YNS != null) {
        paramInt = i + i.a.a.a.qC(4, this.YNS.computeSize());
      }
      i = paramInt;
      if (this.YNj != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YNj);
      }
      i += i.a.a.b.b.a.cJ(6, this.abyv);
      paramInt = i;
      if (this.abyw != null) {
        paramInt = i + i.a.a.a.qC(7, this.abyw.computeSize());
      }
      AppMethodBeat.o(32422);
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
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.YNk == null)
        {
          paramVarArgs = new b("Not all required fields were included: Contact");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.YNR == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.YNS == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32422);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        evs localevs = (evs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32422);
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
            localevs.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dph();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dph)localObject2).parseFrom((byte[])localObject1);
            }
            localevs.YNk = ((dph)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cyx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cyx)localObject2).parseFrom((byte[])localObject1);
            }
            localevs.YNR = ((cyx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cyy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cyy)localObject2).parseFrom((byte[])localObject1);
            }
            localevs.YNS = ((cyy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 5: 
          localevs.YNj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32422);
          return 0;
        case 6: 
          localevs.abyv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32422);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new em();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((em)localObject2).parseFrom((byte[])localObject1);
          }
          localevs.abyw = ((em)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32422);
        return 0;
      }
      AppMethodBeat.o(32422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evs
 * JD-Core Version:    0.7.0.1
 */