package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvi
  extends com.tencent.mm.bw.a
{
  public blc FGj;
  public long FGk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110910);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FGj != null)
      {
        paramVarArgs.ln(1, this.FGj.computeSize());
        this.FGj.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.FGk);
      AppMethodBeat.o(110910);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FGj == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = f.a.a.a.lm(1, this.FGj.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.FGk);
      AppMethodBeat.o(110910);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(110910);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvi localcvi = (cvi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110910);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((blc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvi.FGj = ((blc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110910);
          return 0;
        }
        localcvi.FGk = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110910);
        return 0;
      }
      AppMethodBeat.o(110910);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvi
 * JD-Core Version:    0.7.0.1
 */