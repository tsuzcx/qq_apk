package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ewm
  extends esc
{
  public cyx YNR;
  public cyy YNS;
  public String YNj;
  public dph YNk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32424);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32424);
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
      AppMethodBeat.o(32424);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label801;
      }
    }
    label801:
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
      AppMethodBeat.o(32424);
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
          AppMethodBeat.o(32424);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32424);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ewm localewm = (ewm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32424);
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
            localewm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32424);
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
            localewm.YNk = ((dph)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32424);
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
            localewm.YNR = ((cyx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32424);
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
            localewm.YNS = ((cyy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32424);
          return 0;
        }
        localewm.YNj = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32424);
        return 0;
      }
      AppMethodBeat.o(32424);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewm
 * JD-Core Version:    0.7.0.1
 */