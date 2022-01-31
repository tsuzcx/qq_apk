package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afi
  extends bvk
{
  public int Timestamp;
  public LinkedList<com.tencent.mm.bv.b> wYE;
  public int wYF;
  public LinkedList<Integer> wYG;
  
  public afi()
  {
    AppMethodBeat.i(118198);
    this.wYE = new LinkedList();
    this.wYG = new LinkedList();
    AppMethodBeat.o(118198);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118199);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118199);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 6, this.wYE);
      paramVarArgs.aO(3, this.wYF);
      paramVarArgs.aO(4, this.Timestamp);
      paramVarArgs.e(5, 2, this.wYG);
      AppMethodBeat.o(118199);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label573;
      }
    }
    label573:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 6, this.wYE);
      int j = e.a.a.b.b.a.bl(3, this.wYF);
      int k = e.a.a.b.b.a.bl(4, this.Timestamp);
      int m = e.a.a.a.c(5, 2, this.wYG);
      AppMethodBeat.o(118199);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wYE.clear();
        this.wYG.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118199);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118199);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        afi localafi = (afi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118199);
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
            localafi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118199);
          return 0;
        case 2: 
          localafi.wYE.add(((e.a.a.a.a)localObject1).CLY.eqS());
          AppMethodBeat.o(118199);
          return 0;
        case 3: 
          localafi.wYF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(118199);
          return 0;
        case 4: 
          localafi.Timestamp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(118199);
          return 0;
        }
        localafi.wYG.add(Integer.valueOf(((e.a.a.a.a)localObject1).CLY.sl()));
        AppMethodBeat.o(118199);
        return 0;
      }
      AppMethodBeat.o(118199);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afi
 * JD-Core Version:    0.7.0.1
 */