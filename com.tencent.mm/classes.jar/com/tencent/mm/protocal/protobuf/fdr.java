package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdr
  extends com.tencent.mm.bw.a
{
  public fdq Nzl;
  public ys Nzm;
  public int dIZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225306);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nzl != null)
      {
        paramVarArgs.ni(1, this.Nzl.computeSize());
        this.Nzl.writeFields(paramVarArgs);
      }
      if (this.Nzm != null)
      {
        paramVarArgs.ni(2, this.Nzm.computeSize());
        this.Nzm.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.dIZ);
      AppMethodBeat.o(225306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nzl == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.a.nh(1, this.Nzl.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Nzm != null) {
        i = paramInt + g.a.a.a.nh(2, this.Nzm.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(3, this.dIZ);
      AppMethodBeat.o(225306);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(225306);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fdr localfdr = (fdr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(225306);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fdq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fdq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfdr.Nzl = ((fdq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(225306);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ys();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ys)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfdr.Nzm = ((ys)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(225306);
          return 0;
        }
        localfdr.dIZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(225306);
        return 0;
      }
      AppMethodBeat.o(225306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdr
 * JD-Core Version:    0.7.0.1
 */