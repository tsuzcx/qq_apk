package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class csn
  extends bvk
{
  public int wQP;
  public long wQQ;
  public int xCv;
  public int xvA;
  public int ybe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5243);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(5243);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wQP);
      paramVarArgs.am(3, this.wQQ);
      paramVarArgs.aO(4, this.xCv);
      paramVarArgs.aO(5, this.xvA);
      paramVarArgs.aO(6, this.ybe);
      AppMethodBeat.o(5243);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wQP);
      int j = e.a.a.b.b.a.p(3, this.wQQ);
      int k = e.a.a.b.b.a.bl(4, this.xCv);
      int m = e.a.a.b.b.a.bl(5, this.xvA);
      int n = e.a.a.b.b.a.bl(6, this.ybe);
      AppMethodBeat.o(5243);
      return paramInt + i + j + k + m + n;
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
          AppMethodBeat.o(5243);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5243);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        csn localcsn = (csn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5243);
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
            localcsn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5243);
          return 0;
        case 2: 
          localcsn.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5243);
          return 0;
        case 3: 
          localcsn.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5243);
          return 0;
        case 4: 
          localcsn.xCv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5243);
          return 0;
        case 5: 
          localcsn.xvA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5243);
          return 0;
        }
        localcsn.ybe = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5243);
        return 0;
      }
      AppMethodBeat.o(5243);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csn
 * JD-Core Version:    0.7.0.1
 */