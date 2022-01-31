package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cqf
  extends bvk
{
  public String SeriesID;
  public int xYM;
  public int xYN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56993);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56993);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SeriesID != null) {
        paramVarArgs.e(2, this.SeriesID);
      }
      paramVarArgs.aO(3, this.xYM);
      paramVarArgs.aO(4, this.xYN);
      AppMethodBeat.o(56993);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SeriesID != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.SeriesID);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xYM);
      int j = e.a.a.b.b.a.bl(4, this.xYN);
      AppMethodBeat.o(56993);
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
          AppMethodBeat.o(56993);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56993);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cqf localcqf = (cqf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56993);
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
            localcqf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56993);
          return 0;
        case 2: 
          localcqf.SeriesID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56993);
          return 0;
        case 3: 
          localcqf.xYM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56993);
          return 0;
        }
        localcqf.xYN = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56993);
        return 0;
      }
      AppMethodBeat.o(56993);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqf
 * JD-Core Version:    0.7.0.1
 */