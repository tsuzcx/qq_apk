package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agt
  extends com.tencent.mm.bw.a
{
  public bxp EyP;
  public int EyQ;
  public int EyR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194014);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EyP != null)
      {
        paramVarArgs.ln(1, this.EyP.computeSize());
        this.EyP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.EyQ);
      paramVarArgs.aR(3, this.EyR);
      AppMethodBeat.o(194014);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EyP == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.a.lm(1, this.EyP.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.EyQ);
      int j = f.a.a.b.b.a.bx(3, this.EyR);
      AppMethodBeat.o(194014);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(194014);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agt localagt = (agt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194014);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bxp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagt.EyP = ((bxp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194014);
          return 0;
        case 2: 
          localagt.EyQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(194014);
          return 0;
        }
        localagt.EyR = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(194014);
        return 0;
      }
      AppMethodBeat.o(194014);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agt
 * JD-Core Version:    0.7.0.1
 */