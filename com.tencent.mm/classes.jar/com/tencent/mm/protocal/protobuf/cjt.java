package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cjt
  extends bvk
{
  public int xAw;
  public String xAx;
  public SKBuiltinBuffer_t xkL;
  public int xkM;
  public String xkN;
  public int xkO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56988);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56988);
        throw paramVarArgs;
      }
      if (this.xkL == null)
      {
        paramVarArgs = new b("Not all required fields were included: RetText");
        AppMethodBeat.o(56988);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xkL != null)
      {
        paramVarArgs.iQ(2, this.xkL.computeSize());
        this.xkL.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.xkM);
      if (this.xkN != null) {
        paramVarArgs.e(4, this.xkN);
      }
      paramVarArgs.aO(5, this.xkO);
      paramVarArgs.aO(6, this.xAw);
      if (this.xAx != null) {
        paramVarArgs.e(7, this.xAx);
      }
      AppMethodBeat.o(56988);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xkL != null) {
        i = paramInt + e.a.a.a.iP(2, this.xkL.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.xkM);
      paramInt = i;
      if (this.xkN != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xkN);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xkO) + e.a.a.b.b.a.bl(6, this.xAw);
      paramInt = i;
      if (this.xAx != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xAx);
      }
      AppMethodBeat.o(56988);
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
          AppMethodBeat.o(56988);
          throw paramVarArgs;
        }
        if (this.xkL == null)
        {
          paramVarArgs = new b("Not all required fields were included: RetText");
          AppMethodBeat.o(56988);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56988);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cjt localcjt = (cjt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56988);
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
            localcjt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56988);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcjt.xkL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56988);
          return 0;
        case 3: 
          localcjt.xkM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56988);
          return 0;
        case 4: 
          localcjt.xkN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56988);
          return 0;
        case 5: 
          localcjt.xkO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56988);
          return 0;
        case 6: 
          localcjt.xAw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56988);
          return 0;
        }
        localcjt.xAx = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56988);
        return 0;
      }
      AppMethodBeat.o(56988);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjt
 * JD-Core Version:    0.7.0.1
 */