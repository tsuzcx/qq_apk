package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bv.a
{
  public int wjH;
  public int wjI;
  public LinkedList<n> wjJ;
  
  public m()
  {
    AppMethodBeat.i(72832);
    this.wjJ = new LinkedList();
    AppMethodBeat.o(72832);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72833);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wjH);
      paramVarArgs.aO(2, this.wjI);
      paramVarArgs.e(3, 8, this.wjJ);
      AppMethodBeat.o(72833);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wjH);
      i = e.a.a.b.b.a.bl(2, this.wjI);
      int j = e.a.a.a.c(3, 8, this.wjJ);
      AppMethodBeat.o(72833);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wjJ.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72833);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72833);
        return -1;
      case 1: 
        localm.wjH = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72833);
        return 0;
      case 2: 
        localm.wjI = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72833);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new n();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localm.wjJ.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(72833);
      return 0;
    }
    AppMethodBeat.o(72833);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.m
 * JD-Core Version:    0.7.0.1
 */