package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lt
  extends com.tencent.mm.bv.a
{
  public lu wAm;
  public String wwI;
  public int wxV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151379);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wAm != null)
      {
        paramVarArgs.iQ(1, this.wAm.computeSize());
        this.wAm.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wxV);
      if (this.wwI != null) {
        paramVarArgs.e(3, this.wwI);
      }
      AppMethodBeat.o(151379);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wAm == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = e.a.a.a.iP(1, this.wAm.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wxV);
      paramInt = i;
      if (this.wwI != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wwI);
      }
      AppMethodBeat.o(151379);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(151379);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        lt locallt = (lt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151379);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((lu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallt.wAm = ((lu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151379);
          return 0;
        case 2: 
          locallt.wxV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151379);
          return 0;
        }
        locallt.wwI = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(151379);
        return 0;
      }
      AppMethodBeat.o(151379);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lt
 * JD-Core Version:    0.7.0.1
 */