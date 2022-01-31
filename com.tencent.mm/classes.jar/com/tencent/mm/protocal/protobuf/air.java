package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class air
  extends com.tencent.mm.bv.a
{
  public int woW;
  public bwc xap;
  public int xaq;
  public int xar;
  public int xas = 1;
  public int xat;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5580);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xap == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatroomId");
        AppMethodBeat.o(5580);
        throw paramVarArgs;
      }
      if (this.xap != null)
      {
        paramVarArgs.iQ(1, this.xap.computeSize());
        this.xap.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.woW);
      paramVarArgs.aO(3, this.xaq);
      paramVarArgs.aO(4, this.xar);
      paramVarArgs.aO(5, this.xas);
      paramVarArgs.aO(6, this.xat);
      AppMethodBeat.o(5580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xap == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = e.a.a.a.iP(1, this.xap.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.woW);
      int j = e.a.a.b.b.a.bl(3, this.xaq);
      int k = e.a.a.b.b.a.bl(4, this.xar);
      int m = e.a.a.b.b.a.bl(5, this.xas);
      int n = e.a.a.b.b.a.bl(6, this.xat);
      AppMethodBeat.o(5580);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xap == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatroomId");
          AppMethodBeat.o(5580);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5580);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        air localair = (air)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5580);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localair.xap = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5580);
          return 0;
        case 2: 
          localair.woW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5580);
          return 0;
        case 3: 
          localair.xaq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5580);
          return 0;
        case 4: 
          localair.xar = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5580);
          return 0;
        case 5: 
          localair.xas = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5580);
          return 0;
        }
        localair.xat = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5580);
        return 0;
      }
      AppMethodBeat.o(5580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.air
 * JD-Core Version:    0.7.0.1
 */