package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cep
  extends bvk
{
  public SnsObject xNM;
  public String xsE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94597);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(94597);
        throw paramVarArgs;
      }
      if (this.xNM == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsObject");
        AppMethodBeat.o(94597);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xNM != null)
      {
        paramVarArgs.iQ(2, this.xNM.computeSize());
        this.xNM.writeFields(paramVarArgs);
      }
      if (this.xsE != null) {
        paramVarArgs.e(3, this.xsE);
      }
      AppMethodBeat.o(94597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label622;
      }
    }
    label622:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xNM != null) {
        paramInt = i + e.a.a.a.iP(2, this.xNM.computeSize());
      }
      i = paramInt;
      if (this.xsE != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xsE);
      }
      AppMethodBeat.o(94597);
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
          AppMethodBeat.o(94597);
          throw paramVarArgs;
        }
        if (this.xNM == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsObject");
          AppMethodBeat.o(94597);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cep localcep = (cep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94597);
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
            localcep.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94597);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcep.xNM = ((SnsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94597);
          return 0;
        }
        localcep.xsE = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94597);
        return 0;
      }
      AppMethodBeat.o(94597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cep
 * JD-Core Version:    0.7.0.1
 */