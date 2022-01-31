package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agy
  extends buy
{
  public int Scene;
  public int jKs;
  public String wZA;
  public int wZB;
  public SKBuiltinBuffer_t wvN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(845);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jKs);
      paramVarArgs.aO(3, this.Scene);
      if (this.wZA != null) {
        paramVarArgs.e(4, this.wZA);
      }
      if (this.wvN != null)
      {
        paramVarArgs.iQ(5, this.wvN.computeSize());
        this.wvN.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.wZB);
      AppMethodBeat.o(845);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKs) + e.a.a.b.b.a.bl(3, this.Scene);
      paramInt = i;
      if (this.wZA != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wZA);
      }
      i = paramInt;
      if (this.wvN != null) {
        i = paramInt + e.a.a.a.iP(5, this.wvN.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(6, this.wZB);
      AppMethodBeat.o(845);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(845);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        agy localagy = (agy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(845);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localagy.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(845);
          return 0;
        case 2: 
          localagy.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(845);
          return 0;
        case 3: 
          localagy.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(845);
          return 0;
        case 4: 
          localagy.wZA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(845);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localagy.wvN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(845);
          return 0;
        }
        localagy.wZB = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(845);
        return 0;
      }
      AppMethodBeat.o(845);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agy
 * JD-Core Version:    0.7.0.1
 */