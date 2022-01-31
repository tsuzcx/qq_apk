package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bs
  extends com.tencent.mm.bv.a
{
  public btk wom;
  public btk won;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94501);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wom != null)
      {
        paramVarArgs.iQ(1, this.wom.computeSize());
        this.wom.writeFields(paramVarArgs);
      }
      if (this.won != null)
      {
        paramVarArgs.iQ(2, this.won.computeSize());
        this.won.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94501);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wom == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = e.a.a.a.iP(1, this.wom.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.won != null) {
        i = paramInt + e.a.a.a.iP(2, this.won.computeSize());
      }
      AppMethodBeat.o(94501);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94501);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bs localbs = (bs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94501);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btk();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbs.wom = ((btk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94501);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btk();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbs.won = ((btk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94501);
        return 0;
      }
      AppMethodBeat.o(94501);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bs
 * JD-Core Version:    0.7.0.1
 */