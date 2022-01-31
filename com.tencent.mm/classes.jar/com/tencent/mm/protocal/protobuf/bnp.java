package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bnp
  extends bvk
{
  public String xBN;
  public String xBO;
  public String xBP;
  public String xBQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56932);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56932);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xBN != null) {
        paramVarArgs.e(2, this.xBN);
      }
      if (this.xBO != null) {
        paramVarArgs.e(3, this.xBO);
      }
      if (this.xBP != null) {
        paramVarArgs.e(4, this.xBP);
      }
      if (this.xBQ != null) {
        paramVarArgs.e(5, this.xBQ);
      }
      AppMethodBeat.o(56932);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xBN != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xBN);
      }
      i = paramInt;
      if (this.xBO != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xBO);
      }
      paramInt = i;
      if (this.xBP != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xBP);
      }
      i = paramInt;
      if (this.xBQ != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xBQ);
      }
      AppMethodBeat.o(56932);
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
          AppMethodBeat.o(56932);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56932);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bnp localbnp = (bnp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56932);
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
            localbnp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56932);
          return 0;
        case 2: 
          localbnp.xBN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56932);
          return 0;
        case 3: 
          localbnp.xBO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56932);
          return 0;
        case 4: 
          localbnp.xBP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56932);
          return 0;
        }
        localbnp.xBQ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56932);
        return 0;
      }
      AppMethodBeat.o(56932);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnp
 * JD-Core Version:    0.7.0.1
 */