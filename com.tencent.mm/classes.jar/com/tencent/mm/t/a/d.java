package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import java.util.LinkedList;

public final class d
  extends dpc
{
  public String gTl;
  public int gTm;
  public int gTn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194676);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(194676);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.gTl != null) {
        paramVarArgs.e(2, this.gTl);
      }
      paramVarArgs.aM(3, this.gTm);
      paramVarArgs.aM(4, this.gTn);
      AppMethodBeat.o(194676);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gTl != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.gTl);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.gTm);
      int j = g.a.a.b.b.a.bu(4, this.gTn);
      AppMethodBeat.o(194676);
      return i + paramInt + j;
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(194676);
          throw paramVarArgs;
        }
        AppMethodBeat.o(194676);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194676);
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
            locald.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194676);
          return 0;
        case 2: 
          locald.gTl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(194676);
          return 0;
        case 3: 
          locald.gTm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(194676);
          return 0;
        }
        locald.gTn = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(194676);
        return 0;
      }
      AppMethodBeat.o(194676);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.t.a.d
 * JD-Core Version:    0.7.0.1
 */