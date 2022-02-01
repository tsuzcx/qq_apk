package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class nf
  extends esc
{
  public cyx YNR;
  public cyy YNS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82395);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82395);
        throw paramVarArgs;
      }
      if (this.YNR == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(82395);
        throw paramVarArgs;
      }
      if (this.YNS == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
        AppMethodBeat.o(82395);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YNR != null)
      {
        paramVarArgs.qD(2, this.YNR.computeSize());
        this.YNR.writeFields(paramVarArgs);
      }
      if (this.YNS != null)
      {
        paramVarArgs.qD(3, this.YNS.computeSize());
        this.YNS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label692;
      }
    }
    label692:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YNR != null) {
        paramInt = i + i.a.a.a.qC(2, this.YNR.computeSize());
      }
      i = paramInt;
      if (this.YNS != null) {
        i = paramInt + i.a.a.a.qC(3, this.YNS.computeSize());
      }
      AppMethodBeat.o(82395);
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
          AppMethodBeat.o(82395);
          throw paramVarArgs;
        }
        if (this.YNR == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(82395);
          throw paramVarArgs;
        }
        if (this.YNS == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
          AppMethodBeat.o(82395);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        nf localnf = (nf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82395);
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
            localnf.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82395);
          return 0;
        case 2: 
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
            localnf.YNR = ((cyx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82395);
          return 0;
        }
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
          localnf.YNS = ((cyy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82395);
        return 0;
      }
      AppMethodBeat.o(82395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nf
 * JD-Core Version:    0.7.0.1
 */