package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sq
  extends com.tencent.mm.bx.a
{
  public sp CUA;
  public sp CUB;
  public sp CUx;
  public sp CUy;
  public sp CUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113984);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CUx != null)
      {
        paramVarArgs.kX(1, this.CUx.computeSize());
        this.CUx.writeFields(paramVarArgs);
      }
      if (this.CUy != null)
      {
        paramVarArgs.kX(2, this.CUy.computeSize());
        this.CUy.writeFields(paramVarArgs);
      }
      if (this.CUz != null)
      {
        paramVarArgs.kX(3, this.CUz.computeSize());
        this.CUz.writeFields(paramVarArgs);
      }
      if (this.CUA != null)
      {
        paramVarArgs.kX(4, this.CUA.computeSize());
        this.CUA.writeFields(paramVarArgs);
      }
      if (this.CUB != null)
      {
        paramVarArgs.kX(5, this.CUB.computeSize());
        this.CUB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113984);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CUx == null) {
        break label926;
      }
    }
    label926:
    for (int i = f.a.a.a.kW(1, this.CUx.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CUy != null) {
        paramInt = i + f.a.a.a.kW(2, this.CUy.computeSize());
      }
      i = paramInt;
      if (this.CUz != null) {
        i = paramInt + f.a.a.a.kW(3, this.CUz.computeSize());
      }
      paramInt = i;
      if (this.CUA != null) {
        paramInt = i + f.a.a.a.kW(4, this.CUA.computeSize());
      }
      i = paramInt;
      if (this.CUB != null) {
        i = paramInt + f.a.a.a.kW(5, this.CUB.computeSize());
      }
      AppMethodBeat.o(113984);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113984);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sq localsq = (sq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113984);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsq.CUx = ((sp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsq.CUy = ((sp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsq.CUz = ((sp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsq.CUA = ((sp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsq.CUB = ((sp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113984);
        return 0;
      }
      AppMethodBeat.o(113984);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sq
 * JD-Core Version:    0.7.0.1
 */