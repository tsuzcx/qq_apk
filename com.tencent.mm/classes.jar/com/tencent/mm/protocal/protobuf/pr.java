package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class pr
  extends dpc
{
  public int KHa;
  public int KSO;
  public String KWF;
  public long KWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(224536);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(224536);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.KWz);
      paramVarArgs.aM(3, this.KHa);
      paramVarArgs.aM(4, this.KSO);
      if (this.KWF != null) {
        paramVarArgs.e(5, this.KWF);
      }
      AppMethodBeat.o(224536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.KWz) + g.a.a.b.b.a.bu(3, this.KHa) + g.a.a.b.b.a.bu(4, this.KSO);
      paramInt = i;
      if (this.KWF != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KWF);
      }
      AppMethodBeat.o(224536);
      return paramInt;
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
          AppMethodBeat.o(224536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(224536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        pr localpr = (pr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(224536);
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
            localpr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(224536);
          return 0;
        case 2: 
          localpr.KWz = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(224536);
          return 0;
        case 3: 
          localpr.KHa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(224536);
          return 0;
        case 4: 
          localpr.KSO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(224536);
          return 0;
        }
        localpr.KWF = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(224536);
        return 0;
      }
      AppMethodBeat.o(224536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pr
 * JD-Core Version:    0.7.0.1
 */