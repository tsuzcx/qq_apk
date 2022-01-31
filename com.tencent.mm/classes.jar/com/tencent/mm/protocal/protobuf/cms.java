package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cms
  extends buy
{
  public azf xWs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28678);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xWs == null)
      {
        paramVarArgs = new b("Not all required fields were included: LabelPair");
        AppMethodBeat.o(28678);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xWs != null)
      {
        paramVarArgs.iQ(2, this.xWs.computeSize());
        this.xWs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xWs != null) {
        i = paramInt + e.a.a.a.iP(2, this.xWs.computeSize());
      }
      AppMethodBeat.o(28678);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xWs == null)
        {
          paramVarArgs = new b("Not all required fields were included: LabelPair");
          AppMethodBeat.o(28678);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28678);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cms localcms = (cms)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28678);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcms.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28678);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azf();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcms.xWs = ((azf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28678);
        return 0;
      }
      AppMethodBeat.o(28678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cms
 * JD-Core Version:    0.7.0.1
 */