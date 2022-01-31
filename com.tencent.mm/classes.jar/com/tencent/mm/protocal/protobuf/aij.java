package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aij
  extends bvk
{
  public String koi;
  public String kpP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89088);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(89088);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.koi != null) {
        paramVarArgs.e(2, this.koi);
      }
      if (this.kpP != null) {
        paramVarArgs.e(3, this.kpP);
      }
      AppMethodBeat.o(89088);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label478;
      }
    }
    label478:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.koi != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.koi);
      }
      i = paramInt;
      if (this.kpP != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kpP);
      }
      AppMethodBeat.o(89088);
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
          AppMethodBeat.o(89088);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89088);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aij localaij = (aij)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89088);
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
            localaij.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89088);
          return 0;
        case 2: 
          localaij.koi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89088);
          return 0;
        }
        localaij.kpP = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89088);
        return 0;
      }
      AppMethodBeat.o(89088);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aij
 * JD-Core Version:    0.7.0.1
 */