package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class qj
  extends bvk
{
  public String kNv;
  public String wIL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56759);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56759);
        throw paramVarArgs;
      }
      if (this.wIL == null)
      {
        paramVarArgs = new b("Not all required fields were included: retcode");
        AppMethodBeat.o(56759);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wIL != null) {
        paramVarArgs.e(2, this.wIL);
      }
      if (this.kNv != null) {
        paramVarArgs.e(3, this.kNv);
      }
      AppMethodBeat.o(56759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label526;
      }
    }
    label526:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wIL != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wIL);
      }
      i = paramInt;
      if (this.kNv != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kNv);
      }
      AppMethodBeat.o(56759);
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
          AppMethodBeat.o(56759);
          throw paramVarArgs;
        }
        if (this.wIL == null)
        {
          paramVarArgs = new b("Not all required fields were included: retcode");
          AppMethodBeat.o(56759);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qj localqj = (qj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56759);
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
            localqj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56759);
          return 0;
        case 2: 
          localqj.wIL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56759);
          return 0;
        }
        localqj.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56759);
        return 0;
      }
      AppMethodBeat.o(56759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qj
 * JD-Core Version:    0.7.0.1
 */