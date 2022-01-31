package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aos
  extends bvk
{
  public SKBuiltinBuffer_t xeA;
  public String xeB;
  public String xeC;
  public String xeD;
  public int xez;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80096);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80096);
        throw paramVarArgs;
      }
      if (this.xeA == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCode");
        AppMethodBeat.o(80096);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xeA != null)
      {
        paramVarArgs.iQ(2, this.xeA.computeSize());
        this.xeA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.xez);
      if (this.xeB != null) {
        paramVarArgs.e(6, this.xeB);
      }
      if (this.xeC != null) {
        paramVarArgs.e(7, this.xeC);
      }
      if (this.xeD != null) {
        paramVarArgs.e(8, this.xeD);
      }
      AppMethodBeat.o(80096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xeA != null) {
        i = paramInt + e.a.a.a.iP(2, this.xeA.computeSize());
      }
      i += e.a.a.b.b.a.bl(5, this.xez);
      paramInt = i;
      if (this.xeB != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xeB);
      }
      i = paramInt;
      if (this.xeC != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xeC);
      }
      paramInt = i;
      if (this.xeD != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xeD);
      }
      AppMethodBeat.o(80096);
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
          AppMethodBeat.o(80096);
          throw paramVarArgs;
        }
        if (this.xeA == null)
        {
          paramVarArgs = new b("Not all required fields were included: QRCode");
          AppMethodBeat.o(80096);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80096);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aos localaos = (aos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(80096);
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
            localaos.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80096);
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
            localaos.xeA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80096);
          return 0;
        case 5: 
          localaos.xez = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80096);
          return 0;
        case 6: 
          localaos.xeB = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80096);
          return 0;
        case 7: 
          localaos.xeC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80096);
          return 0;
        }
        localaos.xeD = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80096);
        return 0;
      }
      AppMethodBeat.o(80096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aos
 * JD-Core Version:    0.7.0.1
 */