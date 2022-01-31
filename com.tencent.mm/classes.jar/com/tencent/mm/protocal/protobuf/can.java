package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class can
  extends bvk
{
  public ky wZL;
  public bqx wyn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11807);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(11807);
        throw paramVarArgs;
      }
      if (this.wyn == null)
      {
        paramVarArgs = new b("Not all required fields were included: qy_base_resp");
        AppMethodBeat.o(11807);
        throw paramVarArgs;
      }
      if (this.wZL == null)
      {
        paramVarArgs = new b("Not all required fields were included: attr");
        AppMethodBeat.o(11807);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wyn != null)
      {
        paramVarArgs.iQ(2, this.wyn.computeSize());
        this.wyn.writeFields(paramVarArgs);
      }
      if (this.wZL != null)
      {
        paramVarArgs.iQ(3, this.wZL.computeSize());
        this.wZL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(11807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label779;
      }
    }
    label779:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wyn != null) {
        paramInt = i + e.a.a.a.iP(2, this.wyn.computeSize());
      }
      i = paramInt;
      if (this.wZL != null) {
        i = paramInt + e.a.a.a.iP(3, this.wZL.computeSize());
      }
      AppMethodBeat.o(11807);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(11807);
          throw paramVarArgs;
        }
        if (this.wyn == null)
        {
          paramVarArgs = new b("Not all required fields were included: qy_base_resp");
          AppMethodBeat.o(11807);
          throw paramVarArgs;
        }
        if (this.wZL == null)
        {
          paramVarArgs = new b("Not all required fields were included: attr");
          AppMethodBeat.o(11807);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        can localcan = (can)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11807);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcan.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11807);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcan.wyn = ((bqx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11807);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ky();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ky)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcan.wZL = ((ky)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(11807);
        return 0;
      }
      AppMethodBeat.o(11807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.can
 * JD-Core Version:    0.7.0.1
 */