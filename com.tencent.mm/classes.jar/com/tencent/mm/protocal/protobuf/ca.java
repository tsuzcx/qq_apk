package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ca
  extends com.tencent.mm.bx.a
{
  public cte FuA;
  public cte FuB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125703);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FuA != null)
      {
        paramVarArgs.lC(1, this.FuA.computeSize());
        this.FuA.writeFields(paramVarArgs);
      }
      if (this.FuB != null)
      {
        paramVarArgs.lC(2, this.FuB.computeSize());
        this.FuB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FuA == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.lB(1, this.FuA.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FuB != null) {
        i = paramInt + f.a.a.a.lB(2, this.FuB.computeSize());
      }
      AppMethodBeat.o(125703);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ca localca = (ca)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125703);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cte();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cte)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localca.FuA = ((cte)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125703);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cte();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cte)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localca.FuB = ((cte)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125703);
        return 0;
      }
      AppMethodBeat.o(125703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ca
 * JD-Core Version:    0.7.0.1
 */