package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cdx
  extends bvk
{
  public int jKs;
  public int pIx;
  public int pIy;
  public SKBuiltinBuffer_t wtq;
  public String xOt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94574);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(94574);
        throw paramVarArgs;
      }
      if (this.wtq == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(94574);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.pIy);
      paramVarArgs.aO(3, this.pIx);
      if (this.wtq != null)
      {
        paramVarArgs.iQ(4, this.wtq.computeSize());
        this.wtq.writeFields(paramVarArgs);
      }
      if (this.xOt != null) {
        paramVarArgs.e(5, this.xOt);
      }
      paramVarArgs.aO(6, this.jKs);
      AppMethodBeat.o(94574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pIy) + e.a.a.b.b.a.bl(3, this.pIx);
      paramInt = i;
      if (this.wtq != null) {
        paramInt = i + e.a.a.a.iP(4, this.wtq.computeSize());
      }
      i = paramInt;
      if (this.xOt != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xOt);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.jKs);
      AppMethodBeat.o(94574);
      return i + paramInt;
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
          AppMethodBeat.o(94574);
          throw paramVarArgs;
        }
        if (this.wtq == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(94574);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94574);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cdx localcdx = (cdx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94574);
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
            localcdx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94574);
          return 0;
        case 2: 
          localcdx.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94574);
          return 0;
        case 3: 
          localcdx.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94574);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcdx.wtq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94574);
          return 0;
        case 5: 
          localcdx.xOt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94574);
          return 0;
        }
        localcdx.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94574);
        return 0;
      }
      AppMethodBeat.o(94574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdx
 * JD-Core Version:    0.7.0.1
 */