package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bv.a
{
  public LinkedList<e> rlM;
  public LinkedList<e> rlN;
  public LinkedList<e> rlO;
  public LinkedList<e> rlP;
  public LinkedList<f> rlQ;
  public LinkedList<f> rlR;
  
  public d()
  {
    AppMethodBeat.i(36826);
    this.rlM = new LinkedList();
    this.rlN = new LinkedList();
    this.rlO = new LinkedList();
    this.rlP = new LinkedList();
    this.rlQ = new LinkedList();
    this.rlR = new LinkedList();
    AppMethodBeat.o(36826);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(36827);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.rlM);
      paramVarArgs.e(2, 8, this.rlN);
      paramVarArgs.e(3, 8, this.rlO);
      paramVarArgs.e(4, 8, this.rlP);
      paramVarArgs.e(5, 8, this.rlQ);
      paramVarArgs.e(6, 8, this.rlR);
      AppMethodBeat.o(36827);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 8, this.rlM);
      i = e.a.a.a.c(2, 8, this.rlN);
      int j = e.a.a.a.c(3, 8, this.rlO);
      int k = e.a.a.a.c(4, 8, this.rlP);
      int m = e.a.a.a.c(5, 8, this.rlQ);
      int n = e.a.a.a.c(6, 8, this.rlR);
      AppMethodBeat.o(36827);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.rlM.clear();
      this.rlN.clear();
      this.rlO.clear();
      this.rlP.clear();
      this.rlQ.clear();
      this.rlR.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(36827);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(36827);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locald.rlM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(36827);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locald.rlN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(36827);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locald.rlO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(36827);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locald.rlP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(36827);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locald.rlQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(36827);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new f();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        locald.rlR.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(36827);
      return 0;
    }
    AppMethodBeat.o(36827);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.d
 * JD-Core Version:    0.7.0.1
 */