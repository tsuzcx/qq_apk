package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acd
  extends com.tencent.mm.bx.a
{
  public byh GbH;
  public cse GbI;
  public cse GbJ;
  public cse GbK;
  public cse GbL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215803);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbH != null)
      {
        paramVarArgs.lC(1, this.GbH.computeSize());
        this.GbH.writeFields(paramVarArgs);
      }
      if (this.GbI != null)
      {
        paramVarArgs.lC(2, this.GbI.computeSize());
        this.GbI.writeFields(paramVarArgs);
      }
      if (this.GbJ != null)
      {
        paramVarArgs.lC(3, this.GbJ.computeSize());
        this.GbJ.writeFields(paramVarArgs);
      }
      if (this.GbK != null)
      {
        paramVarArgs.lC(4, this.GbK.computeSize());
        this.GbK.writeFields(paramVarArgs);
      }
      if (this.GbL != null)
      {
        paramVarArgs.lC(5, this.GbL.computeSize());
        this.GbL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(215803);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbH == null) {
        break label926;
      }
    }
    label926:
    for (int i = f.a.a.a.lB(1, this.GbH.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GbI != null) {
        paramInt = i + f.a.a.a.lB(2, this.GbI.computeSize());
      }
      i = paramInt;
      if (this.GbJ != null) {
        i = paramInt + f.a.a.a.lB(3, this.GbJ.computeSize());
      }
      paramInt = i;
      if (this.GbK != null) {
        paramInt = i + f.a.a.a.lB(4, this.GbK.computeSize());
      }
      i = paramInt;
      if (this.GbL != null) {
        i = paramInt + f.a.a.a.lB(5, this.GbL.computeSize());
      }
      AppMethodBeat.o(215803);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(215803);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acd localacd = (acd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215803);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacd.GbH = ((byh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215803);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacd.GbI = ((cse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215803);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacd.GbJ = ((cse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215803);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacd.GbK = ((cse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215803);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cse();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localacd.GbL = ((cse)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215803);
        return 0;
      }
      AppMethodBeat.o(215803);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acd
 * JD-Core Version:    0.7.0.1
 */