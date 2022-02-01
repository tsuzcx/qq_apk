package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yr
  extends com.tencent.mm.bw.a
{
  public long Ess;
  public acn Esv;
  public acq Esw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90958);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Ess);
      if (this.Esv != null)
      {
        paramVarArgs.ln(2, this.Esv.computeSize());
        this.Esv.writeFields(paramVarArgs);
      }
      if (this.Esw != null)
      {
        paramVarArgs.ln(3, this.Esw.computeSize());
        this.Esw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Ess) + 0;
      paramInt = i;
      if (this.Esv != null) {
        paramInt = i + f.a.a.a.lm(2, this.Esv.computeSize());
      }
      i = paramInt;
      if (this.Esw != null) {
        i = paramInt + f.a.a.a.lm(3, this.Esw.computeSize());
      }
      AppMethodBeat.o(90958);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      yr localyr = (yr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90958);
        return -1;
      case 1: 
        localyr.Ess = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(90958);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyr.Esv = ((acn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90958);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new acq();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((acq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localyr.Esw = ((acq)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    AppMethodBeat.o(90958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yr
 * JD-Core Version:    0.7.0.1
 */