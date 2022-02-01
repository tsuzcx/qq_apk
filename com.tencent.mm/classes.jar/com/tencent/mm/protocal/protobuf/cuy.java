package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuy
  extends com.tencent.mm.bw.a
{
  public eih LOX;
  public int flags;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122519);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LOX != null)
      {
        paramVarArgs.ni(1, this.LOX.computeSize());
        this.LOX.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.flags);
      AppMethodBeat.o(122519);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LOX == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = g.a.a.a.nh(1, this.LOX.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.flags);
      AppMethodBeat.o(122519);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122519);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cuy localcuy = (cuy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122519);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eih();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eih)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcuy.LOX = ((eih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122519);
          return 0;
        }
        localcuy.flags = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(122519);
        return 0;
      }
      AppMethodBeat.o(122519);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuy
 * JD-Core Version:    0.7.0.1
 */