package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eky
  extends esc
{
  public etg YCV;
  public flm abpO;
  public gfc abpP;
  public long abpQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91654);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91654);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abpO != null)
      {
        paramVarArgs.qD(2, this.abpO.computeSize());
        this.abpO.writeFields(paramVarArgs);
      }
      if (this.YCV != null)
      {
        paramVarArgs.qD(3, this.YCV.computeSize());
        this.YCV.writeFields(paramVarArgs);
      }
      if (this.abpP != null)
      {
        paramVarArgs.qD(4, this.abpP.computeSize());
        this.abpP.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(5, this.abpQ);
      AppMethodBeat.o(91654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label774;
      }
    }
    label774:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abpO != null) {
        paramInt = i + i.a.a.a.qC(2, this.abpO.computeSize());
      }
      i = paramInt;
      if (this.YCV != null) {
        i = paramInt + i.a.a.a.qC(3, this.YCV.computeSize());
      }
      paramInt = i;
      if (this.abpP != null) {
        paramInt = i + i.a.a.a.qC(4, this.abpP.computeSize());
      }
      i = i.a.a.b.b.a.q(5, this.abpQ);
      AppMethodBeat.o(91654);
      return paramInt + i;
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
          AppMethodBeat.o(91654);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91654);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eky localeky = (eky)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91654);
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
            localeky.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new flm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((flm)localObject2).parseFrom((byte[])localObject1);
            }
            localeky.abpO = ((flm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etg)localObject2).parseFrom((byte[])localObject1);
            }
            localeky.YCV = ((etg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gfc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gfc)localObject2).parseFrom((byte[])localObject1);
            }
            localeky.abpP = ((gfc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        }
        localeky.abpQ = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(91654);
        return 0;
      }
      AppMethodBeat.o(91654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eky
 * JD-Core Version:    0.7.0.1
 */