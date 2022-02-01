package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yv
  extends com.tencent.mm.bw.a
{
  public LinkedList<yu> DQg;
  public long Esr;
  public long Ess;
  
  public yv()
  {
    AppMethodBeat.i(90962);
    this.DQg = new LinkedList();
    AppMethodBeat.o(90962);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90963);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Esr);
      paramVarArgs.aO(2, this.Ess);
      paramVarArgs.e(3, 8, this.DQg);
      AppMethodBeat.o(90963);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.Esr);
      i = f.a.a.b.b.a.p(2, this.Ess);
      int j = f.a.a.a.c(3, 8, this.DQg);
      AppMethodBeat.o(90963);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DQg.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(90963);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      yv localyv = (yv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90963);
        return -1;
      case 1: 
        localyv.Esr = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(90963);
        return 0;
      case 2: 
        localyv.Ess = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(90963);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new yu();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((yu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localyv.DQg.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(90963);
      return 0;
    }
    AppMethodBeat.o(90963);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yv
 * JD-Core Version:    0.7.0.1
 */