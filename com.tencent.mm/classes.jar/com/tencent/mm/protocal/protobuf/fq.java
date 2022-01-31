package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class fq
  extends com.tencent.mm.bv.a
{
  public String ProductID;
  public String wll;
  public EmotionPrice wrG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62509);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(62509);
        throw paramVarArgs;
      }
      if (this.wrG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Price");
        AppMethodBeat.o(62509);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.e(1, this.ProductID);
      }
      if (this.wrG != null)
      {
        paramVarArgs.iQ(2, this.wrG.computeSize());
        this.wrG.writeFields(paramVarArgs);
      }
      if (this.wll != null) {
        paramVarArgs.e(3, this.wll);
      }
      AppMethodBeat.o(62509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label526;
      }
    }
    label526:
    for (int i = e.a.a.b.b.a.f(1, this.ProductID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wrG != null) {
        paramInt = i + e.a.a.a.iP(2, this.wrG.computeSize());
      }
      i = paramInt;
      if (this.wll != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wll);
      }
      AppMethodBeat.o(62509);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ProductID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductID");
          AppMethodBeat.o(62509);
          throw paramVarArgs;
        }
        if (this.wrG == null)
        {
          paramVarArgs = new b("Not all required fields were included: Price");
          AppMethodBeat.o(62509);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        fq localfq = (fq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(62509);
          return -1;
        case 1: 
          localfq.ProductID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62509);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionPrice();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((EmotionPrice)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localfq.wrG = ((EmotionPrice)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62509);
          return 0;
        }
        localfq.wll = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(62509);
        return 0;
      }
      AppMethodBeat.o(62509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fq
 * JD-Core Version:    0.7.0.1
 */