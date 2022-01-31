package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class wz
  extends com.tencent.mm.bv.a
{
  public bwc wOY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5576);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOY == null)
      {
        paramVarArgs = new b("Not all required fields were included: MemberName");
        AppMethodBeat.o(5576);
        throw paramVarArgs;
      }
      if (this.wOY != null)
      {
        paramVarArgs.iQ(1, this.wOY.computeSize());
        this.wOY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(5576);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wOY == null) {
        break label369;
      }
    }
    label369:
    for (paramInt = e.a.a.a.iP(1, this.wOY.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(5576);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOY == null)
        {
          paramVarArgs = new b("Not all required fields were included: MemberName");
          AppMethodBeat.o(5576);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5576);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        wz localwz = (wz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5576);
          return -1;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localwz.wOY = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(5576);
        return 0;
      }
      AppMethodBeat.o(5576);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wz
 * JD-Core Version:    0.7.0.1
 */