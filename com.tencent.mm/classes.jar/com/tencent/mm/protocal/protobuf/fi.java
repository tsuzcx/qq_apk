package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.p;
import java.util.LinkedList;

public final class fi
  extends com.tencent.mm.bw.a
{
  public p DSr;
  public long lastUpdateTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124387);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DSr != null)
      {
        paramVarArgs.ln(1, this.DSr.computeSize());
        this.DSr.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.lastUpdateTime);
      AppMethodBeat.o(124387);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DSr == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = f.a.a.a.lm(1, this.DSr.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.lastUpdateTime);
      AppMethodBeat.o(124387);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124387);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fi localfi = (fi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124387);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new p();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfi.DSr = ((p)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124387);
          return 0;
        }
        localfi.lastUpdateTime = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(124387);
        return 0;
      }
      AppMethodBeat.o(124387);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fi
 * JD-Core Version:    0.7.0.1
 */