package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmy
  extends dpc
{
  public com.tencent.mm.bw.b LVA;
  public com.tencent.mm.bw.b LVy;
  public int LVz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152569);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152569);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.LVz);
      if (this.LVA != null) {
        paramVarArgs.c(4, this.LVA);
      }
      if (this.LVy != null) {
        paramVarArgs.c(5, this.LVy);
      }
      AppMethodBeat.o(152569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(3, this.LVz);
      paramInt = i;
      if (this.LVA != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.LVA);
      }
      i = paramInt;
      if (this.LVy != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.LVy);
      }
      AppMethodBeat.o(152569);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152569);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152569);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bmy localbmy = (bmy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(152569);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbmy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152569);
          return 0;
        case 3: 
          localbmy.LVz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152569);
          return 0;
        case 4: 
          localbmy.LVA = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(152569);
          return 0;
        }
        localbmy.LVy = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(152569);
        return 0;
      }
      AppMethodBeat.o(152569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmy
 * JD-Core Version:    0.7.0.1
 */