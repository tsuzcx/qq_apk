package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqf
  extends com.tencent.mm.bw.a
{
  public blc Ert;
  public long FXq;
  public double FXr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110916);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.FXq);
      paramVarArgs.e(2, this.FXr);
      if (this.Ert != null)
      {
        paramVarArgs.ln(3, this.Ert.computeSize());
        this.Ert.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FXq) + 0 + (f.a.a.b.b.a.fK(2) + 8);
      paramInt = i;
      if (this.Ert != null) {
        paramInt = i + f.a.a.a.lm(3, this.Ert.computeSize());
      }
      AppMethodBeat.o(110916);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dqf localdqf = (dqf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110916);
        return -1;
      case 1: 
        localdqf.FXq = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110916);
        return 0;
      case 2: 
        localdqf.FXr = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
        AppMethodBeat.o(110916);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new blc();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((blc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdqf.Ert = ((blc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(110916);
      return 0;
    }
    AppMethodBeat.o(110916);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqf
 * JD-Core Version:    0.7.0.1
 */