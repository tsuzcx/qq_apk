package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class rs
  extends bvk
{
  public String nul;
  public String wJS;
  public String wJT;
  public String wJU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11733);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(11733);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wJS != null) {
        paramVarArgs.e(2, this.wJS);
      }
      if (this.nul != null) {
        paramVarArgs.e(3, this.nul);
      }
      if (this.wJT != null) {
        paramVarArgs.e(4, this.wJT);
      }
      if (this.wJU != null) {
        paramVarArgs.e(5, this.wJU);
      }
      AppMethodBeat.o(11733);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label613;
      }
    }
    label613:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wJS != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wJS);
      }
      i = paramInt;
      if (this.nul != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nul);
      }
      paramInt = i;
      if (this.wJT != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wJT);
      }
      i = paramInt;
      if (this.wJU != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wJU);
      }
      AppMethodBeat.o(11733);
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
          AppMethodBeat.o(11733);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11733);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        rs localrs = (rs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11733);
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
            localrs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11733);
          return 0;
        case 2: 
          localrs.wJS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11733);
          return 0;
        case 3: 
          localrs.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11733);
          return 0;
        case 4: 
          localrs.wJT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11733);
          return 0;
        }
        localrs.wJU = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(11733);
        return 0;
      }
      AppMethodBeat.o(11733);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rs
 * JD-Core Version:    0.7.0.1
 */