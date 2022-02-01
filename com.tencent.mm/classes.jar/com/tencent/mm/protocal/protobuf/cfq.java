package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cfq
  extends esc
{
  public elf YRW;
  public LinkedList<ow> YRX;
  
  public cfq()
  {
    AppMethodBeat.i(124502);
    this.YRX = new LinkedList();
    AppMethodBeat.o(124502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124503);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124503);
        throw paramVarArgs;
      }
      if (this.YRW == null)
      {
        paramVarArgs = new b("Not all required fields were included: qy_base_resp");
        AppMethodBeat.o(124503);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YRW != null)
      {
        paramVarArgs.qD(2, this.YRW.computeSize());
        this.YRW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.YRX);
      AppMethodBeat.o(124503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label632;
      }
    }
    label632:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YRW != null) {
        i = paramInt + i.a.a.a.qC(2, this.YRW.computeSize());
      }
      paramInt = i.a.a.a.c(3, 8, this.YRX);
      AppMethodBeat.o(124503);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YRX.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124503);
          throw paramVarArgs;
        }
        if (this.YRW == null)
        {
          paramVarArgs = new b("Not all required fields were included: qy_base_resp");
          AppMethodBeat.o(124503);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cfq localcfq = (cfq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124503);
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
            localcfq.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124503);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new elf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((elf)localObject2).parseFrom((byte[])localObject1);
            }
            localcfq.YRW = ((elf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124503);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ow();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ow)localObject2).parseFrom((byte[])localObject1);
          }
          localcfq.YRX.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124503);
        return 0;
      }
      AppMethodBeat.o(124503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfq
 * JD-Core Version:    0.7.0.1
 */