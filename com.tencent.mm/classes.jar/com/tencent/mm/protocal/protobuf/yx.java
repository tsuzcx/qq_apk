package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class yx
  extends bvk
{
  public int fKi;
  public SKBuiltinBuffer_t pIA;
  public int pIE;
  public long pIG;
  public int wAr;
  public int wPU;
  public String wpS;
  public int wyT;
  public int wzS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116803);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(116803);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(116803);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.pIE);
      paramVarArgs.aO(2, this.wzS);
      paramVarArgs.aO(3, this.wyT);
      paramVarArgs.aO(5, this.wAr);
      if (this.wpS != null) {
        paramVarArgs.e(6, this.wpS);
      }
      if (this.pIA != null)
      {
        paramVarArgs.iQ(7, this.pIA.computeSize());
        this.pIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.fKi);
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(9, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(10, this.wPU);
      paramVarArgs.am(11, this.pIG);
      AppMethodBeat.o(116803);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.pIE) + 0 + e.a.a.b.b.a.bl(2, this.wzS) + e.a.a.b.b.a.bl(3, this.wyT) + e.a.a.b.b.a.bl(5, this.wAr);
      paramInt = i;
      if (this.wpS != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wpS);
      }
      i = paramInt;
      if (this.pIA != null) {
        i = paramInt + e.a.a.a.iP(7, this.pIA.computeSize());
      }
      i += e.a.a.b.b.a.bl(8, this.fKi);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + e.a.a.a.iP(9, this.BaseResponse.computeSize());
      }
      i = e.a.a.b.b.a.bl(10, this.wPU);
      int j = e.a.a.b.b.a.p(11, this.pIG);
      AppMethodBeat.o(116803);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(116803);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(116803);
        throw paramVarArgs;
      }
      AppMethodBeat.o(116803);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      yx localyx = (yx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 4: 
      default: 
        AppMethodBeat.o(116803);
        return -1;
      case 1: 
        localyx.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116803);
        return 0;
      case 2: 
        localyx.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116803);
        return 0;
      case 3: 
        localyx.wyT = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116803);
        return 0;
      case 5: 
        localyx.wAr = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116803);
        return 0;
      case 6: 
        localyx.wpS = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(116803);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localyx.pIA = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116803);
        return 0;
      case 8: 
        localyx.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116803);
        return 0;
      case 9: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new BaseResponse();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localyx.BaseResponse = ((BaseResponse)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116803);
        return 0;
      case 10: 
        localyx.wPU = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116803);
        return 0;
      }
      localyx.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
      AppMethodBeat.o(116803);
      return 0;
    }
    AppMethodBeat.o(116803);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yx
 * JD-Core Version:    0.7.0.1
 */