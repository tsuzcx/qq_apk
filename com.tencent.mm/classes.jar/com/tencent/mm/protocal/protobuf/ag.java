package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.bv.a
{
  public int wlA;
  public int wlB;
  public LinkedList<ae> wlC;
  public int wlD;
  public LinkedList<ae> wlE;
  public int wlz;
  
  public ag()
  {
    AppMethodBeat.i(72839);
    this.wlC = new LinkedList();
    this.wlE = new LinkedList();
    AppMethodBeat.o(72839);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72840);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wlz);
      paramVarArgs.aO(2, this.wlB);
      paramVarArgs.e(3, 8, this.wlC);
      paramVarArgs.aO(4, this.wlA);
      paramVarArgs.aO(5, this.wlD);
      paramVarArgs.e(6, 8, this.wlE);
      AppMethodBeat.o(72840);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wlz);
      i = e.a.a.b.b.a.bl(2, this.wlB);
      int j = e.a.a.a.c(3, 8, this.wlC);
      int k = e.a.a.b.b.a.bl(4, this.wlA);
      int m = e.a.a.b.b.a.bl(5, this.wlD);
      int n = e.a.a.a.c(6, 8, this.wlE);
      AppMethodBeat.o(72840);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wlC.clear();
      this.wlE.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72840);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      ag localag = (ag)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72840);
        return -1;
      case 1: 
        localag.wlz = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72840);
        return 0;
      case 2: 
        localag.wlB = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72840);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ae();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ae)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localag.wlC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72840);
        return 0;
      case 4: 
        localag.wlA = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72840);
        return 0;
      case 5: 
        localag.wlD = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72840);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ae();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ae)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localag.wlE.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(72840);
      return 0;
    }
    AppMethodBeat.o(72840);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ag
 * JD-Core Version:    0.7.0.1
 */