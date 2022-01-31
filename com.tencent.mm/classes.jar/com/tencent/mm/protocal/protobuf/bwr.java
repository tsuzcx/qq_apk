package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bwr
  extends buy
{
  public int Scene;
  public bmw xJU;
  public float xJV;
  public float xJW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80173);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xJU == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserPos");
        AppMethodBeat.o(80173);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xJU != null)
      {
        paramVarArgs.iQ(2, this.xJU.computeSize());
        this.xJU.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.Scene);
      paramVarArgs.q(4, this.xJV);
      paramVarArgs.q(5, this.xJW);
      AppMethodBeat.o(80173);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label652;
      }
    }
    label652:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xJU != null) {
        i = paramInt + e.a.a.a.iP(2, this.xJU.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(3, this.Scene);
      int j = e.a.a.b.b.a.eW(4);
      int k = e.a.a.b.b.a.eW(5);
      AppMethodBeat.o(80173);
      return i + paramInt + (j + 4) + (k + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xJU == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserPos");
          AppMethodBeat.o(80173);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80173);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bwr localbwr = (bwr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80173);
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
            localbwr.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80173);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbwr.xJU = ((bmw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80173);
          return 0;
        case 3: 
          localbwr.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80173);
          return 0;
        case 4: 
          localbwr.xJV = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(80173);
          return 0;
        }
        localbwr.xJW = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
        AppMethodBeat.o(80173);
        return 0;
      }
      AppMethodBeat.o(80173);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwr
 * JD-Core Version:    0.7.0.1
 */