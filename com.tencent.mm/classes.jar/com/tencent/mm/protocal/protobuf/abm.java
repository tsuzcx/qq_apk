package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class abm
  extends com.tencent.mm.bw.a
{
  public int KXj;
  public b Lmq;
  public dbg Lmr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91422);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KXj);
      if (this.Lmq != null) {
        paramVarArgs.c(2, this.Lmq);
      }
      if (this.Lmr != null)
      {
        paramVarArgs.ni(3, this.Lmr.computeSize());
        this.Lmr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.KXj) + 0;
      paramInt = i;
      if (this.Lmq != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.Lmq);
      }
      i = paramInt;
      if (this.Lmr != null) {
        i = paramInt + g.a.a.a.nh(3, this.Lmr.computeSize());
      }
      AppMethodBeat.o(91422);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      abm localabm = (abm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91422);
        return -1;
      case 1: 
        localabm.KXj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91422);
        return 0;
      case 2: 
        localabm.Lmq = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(91422);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dbg();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dbg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localabm.Lmr = ((dbg)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    AppMethodBeat.o(91422);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abm
 * JD-Core Version:    0.7.0.1
 */