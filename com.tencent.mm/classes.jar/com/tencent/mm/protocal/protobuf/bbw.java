package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bbw
  extends bvk
{
  public String wAa;
  public int xqW;
  public String xqX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124326);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wAa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Json");
        AppMethodBeat.o(124326);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wAa != null) {
        paramVarArgs.e(2, this.wAa);
      }
      paramVarArgs.aO(3, this.xqW);
      if (this.xqX != null) {
        paramVarArgs.e(4, this.xqX);
      }
      AppMethodBeat.o(124326);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wAa != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wAa);
      }
      i += e.a.a.b.b.a.bl(3, this.xqW);
      paramInt = i;
      if (this.xqX != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xqX);
      }
      AppMethodBeat.o(124326);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wAa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Json");
          AppMethodBeat.o(124326);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124326);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bbw localbbw = (bbw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124326);
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
            localbbw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124326);
          return 0;
        case 2: 
          localbbw.wAa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124326);
          return 0;
        case 3: 
          localbbw.xqW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124326);
          return 0;
        }
        localbbw.xqX = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124326);
        return 0;
      }
      AppMethodBeat.o(124326);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbw
 * JD-Core Version:    0.7.0.1
 */