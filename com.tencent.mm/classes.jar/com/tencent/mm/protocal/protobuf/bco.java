package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bco
  extends bvk
{
  public int xrB;
  public int xrE;
  public int xrN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28549);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28549);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xrB);
      paramVarArgs.aO(3, this.xrE);
      paramVarArgs.aO(4, this.xrN);
      AppMethodBeat.o(28549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label508;
      }
    }
    label508:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xrB);
      int j = e.a.a.b.b.a.bl(3, this.xrE);
      int k = e.a.a.b.b.a.bl(4, this.xrN);
      AppMethodBeat.o(28549);
      return paramInt + i + j + k;
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
          AppMethodBeat.o(28549);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bco localbco = (bco)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28549);
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
            localbco.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28549);
          return 0;
        case 2: 
          localbco.xrB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28549);
          return 0;
        case 3: 
          localbco.xrE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28549);
          return 0;
        }
        localbco.xrN = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28549);
        return 0;
      }
      AppMethodBeat.o(28549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bco
 * JD-Core Version:    0.7.0.1
 */