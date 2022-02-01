package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdc
  extends com.tencent.mm.bw.a
{
  public cde FrJ;
  public cdd FrK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117886);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FrJ != null)
      {
        paramVarArgs.ln(1, this.FrJ.computeSize());
        this.FrJ.writeFields(paramVarArgs);
      }
      if (this.FrK != null)
      {
        paramVarArgs.ln(2, this.FrK.computeSize());
        this.FrK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117886);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FrJ == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.lm(1, this.FrJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FrK != null) {
        i = paramInt + f.a.a.a.lm(2, this.FrK.computeSize());
      }
      AppMethodBeat.o(117886);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117886);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdc localcdc = (cdc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117886);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cde();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cde)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdc.FrJ = ((cde)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117886);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdc.FrK = ((cdd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117886);
        return 0;
      }
      AppMethodBeat.o(117886);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdc
 * JD-Core Version:    0.7.0.1
 */