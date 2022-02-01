package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import java.util.LinkedList;

public final class fg
  extends com.tencent.mm.bx.a
{
  public p CzV;
  public long lastUpdateTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124387);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CzV != null)
      {
        paramVarArgs.kX(1, this.CzV.computeSize());
        this.CzV.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.lastUpdateTime);
      AppMethodBeat.o(124387);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CzV == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = f.a.a.a.kW(1, this.CzV.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.q(2, this.lastUpdateTime);
      AppMethodBeat.o(124387);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124387);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fg localfg = (fg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124387);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new p();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.CzV = ((p)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124387);
          return 0;
        }
        localfg.lastUpdateTime = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(124387);
        return 0;
      }
      AppMethodBeat.o(124387);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fg
 * JD-Core Version:    0.7.0.1
 */