package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class sm
  extends bvk
{
  public int Scene;
  public String fKj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(105145);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(105145);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.fKj != null) {
        paramVarArgs.e(2, this.fKj);
      }
      paramVarArgs.aO(3, this.Scene);
      AppMethodBeat.o(105145);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fKj != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.fKj);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.Scene);
      AppMethodBeat.o(105145);
      return i + paramInt;
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
          AppMethodBeat.o(105145);
          throw paramVarArgs;
        }
        AppMethodBeat.o(105145);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        sm localsm = (sm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(105145);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localsm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(105145);
          return 0;
        case 2: 
          localsm.fKj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(105145);
          return 0;
        }
        localsm.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(105145);
        return 0;
      }
      AppMethodBeat.o(105145);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sm
 * JD-Core Version:    0.7.0.1
 */