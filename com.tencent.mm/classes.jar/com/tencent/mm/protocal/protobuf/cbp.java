package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cbp
  extends bvk
{
  public int Ret;
  public SKBuiltinBuffer_t wtq;
  public int xMr;
  public int xMt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28649);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28649);
        throw paramVarArgs;
      }
      if (this.wtq == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(28649);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wtq != null)
      {
        paramVarArgs.iQ(2, this.wtq.computeSize());
        this.wtq.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.Ret);
      paramVarArgs.aO(4, this.xMr);
      paramVarArgs.aO(5, this.xMt);
      AppMethodBeat.o(28649);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label713;
      }
    }
    label713:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wtq != null) {
        i = paramInt + e.a.a.a.iP(2, this.wtq.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(3, this.Ret);
      int j = e.a.a.b.b.a.bl(4, this.xMr);
      int k = e.a.a.b.b.a.bl(5, this.xMt);
      AppMethodBeat.o(28649);
      return i + paramInt + j + k;
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
          AppMethodBeat.o(28649);
          throw paramVarArgs;
        }
        if (this.wtq == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(28649);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28649);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cbp localcbp = (cbp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28649);
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
            localcbp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28649);
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
            localcbp.wtq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28649);
          return 0;
        case 3: 
          localcbp.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28649);
          return 0;
        case 4: 
          localcbp.xMr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28649);
          return 0;
        }
        localcbp.xMt = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28649);
        return 0;
      }
      AppMethodBeat.o(28649);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbp
 * JD-Core Version:    0.7.0.1
 */