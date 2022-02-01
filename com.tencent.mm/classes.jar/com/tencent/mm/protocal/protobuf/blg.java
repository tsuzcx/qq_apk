package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blg
  extends cwj
{
  public dyf Gqs;
  public cqe Gqu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32292);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32292);
        throw paramVarArgs;
      }
      if (this.Gqs == null)
      {
        paramVarArgs = new b("Not all required fields were included: TransRes");
        AppMethodBeat.o(32292);
        throw paramVarArgs;
      }
      if (this.Gqu == null)
      {
        paramVarArgs = new b("Not all required fields were included: QueryCtx");
        AppMethodBeat.o(32292);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Gqs != null)
      {
        paramVarArgs.lJ(2, this.Gqs.computeSize());
        this.Gqs.writeFields(paramVarArgs);
      }
      if (this.Gqu != null)
      {
        paramVarArgs.lJ(3, this.Gqu.computeSize());
        this.Gqu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32292);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label779;
      }
    }
    label779:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gqs != null) {
        paramInt = i + f.a.a.a.lI(2, this.Gqs.computeSize());
      }
      i = paramInt;
      if (this.Gqu != null) {
        i = paramInt + f.a.a.a.lI(3, this.Gqu.computeSize());
      }
      AppMethodBeat.o(32292);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32292);
          throw paramVarArgs;
        }
        if (this.Gqs == null)
        {
          paramVarArgs = new b("Not all required fields were included: TransRes");
          AppMethodBeat.o(32292);
          throw paramVarArgs;
        }
        if (this.Gqu == null)
        {
          paramVarArgs = new b("Not all required fields were included: QueryCtx");
          AppMethodBeat.o(32292);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32292);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blg localblg = (blg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32292);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32292);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblg.Gqs = ((dyf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32292);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localblg.Gqu = ((cqe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32292);
        return 0;
      }
      AppMethodBeat.o(32292);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blg
 * JD-Core Version:    0.7.0.1
 */