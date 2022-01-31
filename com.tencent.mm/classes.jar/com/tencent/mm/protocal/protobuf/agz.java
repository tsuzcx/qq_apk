package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agz
  extends bvk
{
  public long wZC;
  public com.tencent.mm.bv.b wZD;
  public bfu wZE;
  public jz wZF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(846);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(846);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.am(2, this.wZC);
      if (this.wZD != null) {
        paramVarArgs.c(3, this.wZD);
      }
      if (this.wZE != null)
      {
        paramVarArgs.iQ(4, this.wZE.computeSize());
        this.wZE.writeFields(paramVarArgs);
      }
      if (this.wZF != null)
      {
        paramVarArgs.iQ(5, this.wZF.computeSize());
        this.wZF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label785;
      }
    }
    label785:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.wZC);
      paramInt = i;
      if (this.wZD != null) {
        paramInt = i + e.a.a.b.b.a.b(3, this.wZD);
      }
      i = paramInt;
      if (this.wZE != null) {
        i = paramInt + e.a.a.a.iP(4, this.wZE.computeSize());
      }
      paramInt = i;
      if (this.wZF != null) {
        paramInt = i + e.a.a.a.iP(5, this.wZF.computeSize());
      }
      AppMethodBeat.o(846);
      return paramInt;
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
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(846);
          throw paramVarArgs;
        }
        AppMethodBeat.o(846);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        agz localagz = (agz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(846);
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
            localagz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(846);
          return 0;
        case 2: 
          localagz.wZC = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(846);
          return 0;
        case 3: 
          localagz.wZD = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(846);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localagz.wZE = ((bfu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(846);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new jz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((jz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localagz.wZF = ((jz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(846);
        return 0;
      }
      AppMethodBeat.o(846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agz
 * JD-Core Version:    0.7.0.1
 */