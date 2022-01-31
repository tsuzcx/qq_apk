package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class yr
  extends bvk
{
  public int jKs;
  public SKBuiltinBuffer_t wPM;
  public int wPN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80049);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80049);
        throw paramVarArgs;
      }
      if (this.wPM == null)
      {
        paramVarArgs = new b("Not all required fields were included: PackageBuf");
        AppMethodBeat.o(80049);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wPM != null)
      {
        paramVarArgs.iQ(2, this.wPM.computeSize());
        this.wPM.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.jKs);
      paramVarArgs.aO(4, this.wPN);
      AppMethodBeat.o(80049);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wPM != null) {
        i = paramInt + e.a.a.a.iP(2, this.wPM.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(3, this.jKs);
      int j = e.a.a.b.b.a.bl(4, this.wPN);
      AppMethodBeat.o(80049);
      return i + paramInt + j;
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
          AppMethodBeat.o(80049);
          throw paramVarArgs;
        }
        if (this.wPM == null)
        {
          paramVarArgs = new b("Not all required fields were included: PackageBuf");
          AppMethodBeat.o(80049);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80049);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        yr localyr = (yr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80049);
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
            localyr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80049);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localyr.wPM = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80049);
          return 0;
        case 3: 
          localyr.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80049);
          return 0;
        }
        localyr.wPN = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80049);
        return 0;
      }
      AppMethodBeat.o(80049);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yr
 * JD-Core Version:    0.7.0.1
 */