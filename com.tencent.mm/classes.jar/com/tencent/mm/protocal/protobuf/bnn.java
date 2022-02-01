package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bnn
  extends dpc
{
  public long KHg;
  public int LVZ;
  public int LWa;
  public int LWb;
  public long oTV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127496);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127496);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.KHg);
      paramVarArgs.bb(3, this.oTV);
      paramVarArgs.aM(4, this.LVZ);
      paramVarArgs.aM(5, this.LWa);
      paramVarArgs.aM(6, this.LWb);
      AppMethodBeat.o(127496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.KHg);
      int j = g.a.a.b.b.a.r(3, this.oTV);
      int k = g.a.a.b.b.a.bu(4, this.LVZ);
      int m = g.a.a.b.b.a.bu(5, this.LWa);
      int n = g.a.a.b.b.a.bu(6, this.LWb);
      AppMethodBeat.o(127496);
      return paramInt + i + j + k + m + n;
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
          AppMethodBeat.o(127496);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bnn localbnn = (bnn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127496);
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
            localbnn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127496);
          return 0;
        case 2: 
          localbnn.KHg = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(127496);
          return 0;
        case 3: 
          localbnn.oTV = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(127496);
          return 0;
        case 4: 
          localbnn.LVZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127496);
          return 0;
        case 5: 
          localbnn.LWa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127496);
          return 0;
        }
        localbnn.LWb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127496);
        return 0;
      }
      AppMethodBeat.o(127496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnn
 * JD-Core Version:    0.7.0.1
 */