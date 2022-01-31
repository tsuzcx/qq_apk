package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbk
  extends com.tencent.mm.bv.a
{
  public dbg yhA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115020);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yhA != null)
      {
        paramVarArgs.iQ(1, this.yhA.computeSize());
        this.yhA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115020);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yhA == null) {
        break label310;
      }
    }
    label310:
    for (paramInt = e.a.a.a.iP(1, this.yhA.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(115020);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(115020);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        dbk localdbk = (dbk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115020);
          return -1;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbg();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dbg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localdbk.yhA = ((dbg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115020);
        return 0;
      }
      AppMethodBeat.o(115020);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbk
 * JD-Core Version:    0.7.0.1
 */