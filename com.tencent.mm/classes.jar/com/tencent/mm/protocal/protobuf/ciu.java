package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ciu
  extends esc
{
  public ana aarp;
  public anl aarq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104790);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104790);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aarp != null)
      {
        paramVarArgs.qD(2, this.aarp.computeSize());
        this.aarp.writeFields(paramVarArgs);
      }
      if (this.aarq != null)
      {
        paramVarArgs.qD(3, this.aarq.computeSize());
        this.aarq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104790);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label596;
      }
    }
    label596:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aarp != null) {
        paramInt = i + i.a.a.a.qC(2, this.aarp.computeSize());
      }
      i = paramInt;
      if (this.aarq != null) {
        i = paramInt + i.a.a.a.qC(3, this.aarq.computeSize());
      }
      AppMethodBeat.o(104790);
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
          AppMethodBeat.o(104790);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104790);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ciu localciu = (ciu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104790);
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
            localciu.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104790);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ana();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ana)localObject2).parseFrom((byte[])localObject1);
            }
            localciu.aarp = ((ana)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104790);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new anl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((anl)localObject2).parseFrom((byte[])localObject1);
          }
          localciu.aarq = ((anl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104790);
        return 0;
      }
      AppMethodBeat.o(104790);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciu
 * JD-Core Version:    0.7.0.1
 */