package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbl
  extends com.tencent.mm.bv.a
{
  public dbg yhA;
  public String yhN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115021);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yhA != null)
      {
        paramVarArgs.iQ(1, this.yhA.computeSize());
        this.yhA.writeFields(paramVarArgs);
      }
      if (this.yhN != null) {
        paramVarArgs.e(2, this.yhN);
      }
      AppMethodBeat.o(115021);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yhA == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = e.a.a.a.iP(1, this.yhA.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yhN != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.yhN);
      }
      AppMethodBeat.o(115021);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(115021);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        dbl localdbl = (dbl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115021);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dbg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdbl.yhA = ((dbg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115021);
          return 0;
        }
        localdbl.yhN = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(115021);
        return 0;
      }
      AppMethodBeat.o(115021);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbl
 * JD-Core Version:    0.7.0.1
 */