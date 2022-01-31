package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class yv
  extends bvk
{
  public SKBuiltinBuffer_t pIA;
  public int pIE;
  public long pIG;
  public int pIx;
  public int pIy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50999);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(50999);
        throw paramVarArgs;
      }
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(50999);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.pIE);
      paramVarArgs.aO(3, this.pIx);
      paramVarArgs.aO(4, this.pIy);
      if (this.pIA != null)
      {
        paramVarArgs.iQ(5, this.pIA.computeSize());
        this.pIA.writeFields(paramVarArgs);
      }
      paramVarArgs.am(6, this.pIG);
      AppMethodBeat.o(50999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pIE) + e.a.a.b.b.a.bl(3, this.pIx) + e.a.a.b.b.a.bl(4, this.pIy);
      paramInt = i;
      if (this.pIA != null) {
        paramInt = i + e.a.a.a.iP(5, this.pIA.computeSize());
      }
      i = e.a.a.b.b.a.p(6, this.pIG);
      AppMethodBeat.o(50999);
      return paramInt + i;
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
          AppMethodBeat.o(50999);
          throw paramVarArgs;
        }
        if (this.pIA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(50999);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50999);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        yv localyv = (yv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50999);
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
            localyv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50999);
          return 0;
        case 2: 
          localyv.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(50999);
          return 0;
        case 3: 
          localyv.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(50999);
          return 0;
        case 4: 
          localyv.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(50999);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localyv.pIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50999);
          return 0;
        }
        localyv.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(50999);
        return 0;
      }
      AppMethodBeat.o(50999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yv
 * JD-Core Version:    0.7.0.1
 */