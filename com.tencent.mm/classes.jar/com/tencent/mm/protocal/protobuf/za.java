package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class za
  extends dpc
{
  public int Lkf;
  public int Lkg;
  public int Lkh;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127629);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127629);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oUv);
      paramVarArgs.aM(3, this.Lkf);
      paramVarArgs.aM(4, this.Lkg);
      paramVarArgs.aM(5, this.Lkh);
      AppMethodBeat.o(127629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.oUv);
      int j = g.a.a.b.b.a.bu(3, this.Lkf);
      int k = g.a.a.b.b.a.bu(4, this.Lkg);
      int m = g.a.a.b.b.a.bu(5, this.Lkh);
      AppMethodBeat.o(127629);
      return paramInt + i + j + k + m;
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
          AppMethodBeat.o(127629);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        za localza = (za)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127629);
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
            localza.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127629);
          return 0;
        case 2: 
          localza.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127629);
          return 0;
        case 3: 
          localza.Lkf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127629);
          return 0;
        case 4: 
          localza.Lkg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127629);
          return 0;
        }
        localza.Lkh = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127629);
        return 0;
      }
      AppMethodBeat.o(127629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.za
 * JD-Core Version:    0.7.0.1
 */