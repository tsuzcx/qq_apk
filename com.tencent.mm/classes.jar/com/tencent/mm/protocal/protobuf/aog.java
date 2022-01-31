package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aog
  extends bvk
{
  public int wuD;
  public String wuE;
  public String xee;
  public String xef;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56830);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56830);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xee != null) {
        paramVarArgs.e(2, this.xee);
      }
      paramVarArgs.aO(3, this.wuD);
      if (this.wuE != null) {
        paramVarArgs.e(4, this.wuE);
      }
      if (this.xef != null) {
        paramVarArgs.e(5, this.xef);
      }
      AppMethodBeat.o(56830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xee != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xee);
      }
      i += e.a.a.b.b.a.bl(3, this.wuD);
      paramInt = i;
      if (this.wuE != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wuE);
      }
      i = paramInt;
      if (this.xef != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xef);
      }
      AppMethodBeat.o(56830);
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
          AppMethodBeat.o(56830);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aog localaog = (aog)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56830);
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
            localaog.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56830);
          return 0;
        case 2: 
          localaog.xee = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56830);
          return 0;
        case 3: 
          localaog.wuD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56830);
          return 0;
        case 4: 
          localaog.wuE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56830);
          return 0;
        }
        localaog.xef = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56830);
        return 0;
      }
      AppMethodBeat.o(56830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aog
 * JD-Core Version:    0.7.0.1
 */