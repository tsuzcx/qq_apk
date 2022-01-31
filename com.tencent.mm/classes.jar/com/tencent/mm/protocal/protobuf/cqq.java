package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cqq
  extends bvk
{
  public int wKy;
  public int xGN;
  public cre xGS;
  public String xZf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28700);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28700);
        throw paramVarArgs;
      }
      if (this.xGS == null)
      {
        paramVarArgs = new b("Not all required fields were included: NextPiece");
        AppMethodBeat.o(28700);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xGS != null)
      {
        paramVarArgs.iQ(2, this.xGS.computeSize());
        this.xGS.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.wKy);
      paramVarArgs.aO(4, this.xGN);
      if (this.xZf != null) {
        paramVarArgs.e(5, this.xZf);
      }
      AppMethodBeat.o(28700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label721;
      }
    }
    label721:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xGS != null) {
        i = paramInt + e.a.a.a.iP(2, this.xGS.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(3, this.wKy) + e.a.a.b.b.a.bl(4, this.xGN);
      paramInt = i;
      if (this.xZf != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xZf);
      }
      AppMethodBeat.o(28700);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28700);
          throw paramVarArgs;
        }
        if (this.xGS == null)
        {
          paramVarArgs = new b("Not all required fields were included: NextPiece");
          AppMethodBeat.o(28700);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28700);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cqq localcqq = (cqq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28700);
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
            localcqq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28700);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cre();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cre)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqq.xGS = ((cre)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28700);
          return 0;
        case 3: 
          localcqq.wKy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28700);
          return 0;
        case 4: 
          localcqq.xGN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28700);
          return 0;
        }
        localcqq.xZf = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28700);
        return 0;
      }
      AppMethodBeat.o(28700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqq
 * JD-Core Version:    0.7.0.1
 */