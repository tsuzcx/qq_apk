package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cpu
  extends bvk
{
  public int lGK;
  public String lGL;
  public LinkedList<String> xYC;
  
  public cpu()
  {
    AppMethodBeat.i(10247);
    this.xYC = new LinkedList();
    AppMethodBeat.o(10247);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10248);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(10248);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.lGK);
      if (this.lGL != null) {
        paramVarArgs.e(3, this.lGL);
      }
      paramVarArgs.e(4, 1, this.xYC);
      AppMethodBeat.o(10248);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label532;
      }
    }
    label532:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.lGK);
      paramInt = i;
      if (this.lGL != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.lGL);
      }
      i = e.a.a.a.c(4, 1, this.xYC);
      AppMethodBeat.o(10248);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xYC.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(10248);
          throw paramVarArgs;
        }
        AppMethodBeat.o(10248);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cpu localcpu = (cpu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10248);
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
            localcpu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10248);
          return 0;
        case 2: 
          localcpu.lGK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(10248);
          return 0;
        case 3: 
          localcpu.lGL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10248);
          return 0;
        }
        localcpu.xYC.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(10248);
        return 0;
      }
      AppMethodBeat.o(10248);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpu
 * JD-Core Version:    0.7.0.1
 */