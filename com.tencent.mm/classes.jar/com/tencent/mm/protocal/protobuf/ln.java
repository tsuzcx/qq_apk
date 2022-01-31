package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ln
  extends bvk
{
  public int fKi;
  public int jKs;
  public int wzP;
  public int wzT;
  public String wzV;
  public float wzW;
  public float wzX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11724);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(11724);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wzP);
      paramVarArgs.aO(3, this.jKs);
      if (this.wzV != null) {
        paramVarArgs.e(4, this.wzV);
      }
      paramVarArgs.aO(5, this.fKi);
      paramVarArgs.aO(6, this.wzT);
      paramVarArgs.q(7, this.wzW);
      paramVarArgs.q(8, this.wzX);
      AppMethodBeat.o(11724);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wzP) + e.a.a.b.b.a.bl(3, this.jKs);
      paramInt = i;
      if (this.wzV != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wzV);
      }
      i = e.a.a.b.b.a.bl(5, this.fKi);
      int j = e.a.a.b.b.a.bl(6, this.wzT);
      int k = e.a.a.b.b.a.eW(7);
      int m = e.a.a.b.b.a.eW(8);
      AppMethodBeat.o(11724);
      return paramInt + i + j + (k + 4) + (m + 4);
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
          AppMethodBeat.o(11724);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11724);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ln localln = (ln)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11724);
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
            localln.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11724);
          return 0;
        case 2: 
          localln.wzP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11724);
          return 0;
        case 3: 
          localln.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11724);
          return 0;
        case 4: 
          localln.wzV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11724);
          return 0;
        case 5: 
          localln.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11724);
          return 0;
        case 6: 
          localln.wzT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11724);
          return 0;
        case 7: 
          localln.wzW = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(11724);
          return 0;
        }
        localln.wzX = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
        AppMethodBeat.o(11724);
        return 0;
      }
      AppMethodBeat.o(11724);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ln
 * JD-Core Version:    0.7.0.1
 */