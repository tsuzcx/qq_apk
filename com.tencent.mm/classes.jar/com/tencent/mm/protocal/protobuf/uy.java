package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uy
  extends com.tencent.mm.bv.a
{
  public long wMX;
  public long wNz;
  public LinkedList<ux> wpb;
  
  public uy()
  {
    AppMethodBeat.i(135601);
    this.wpb = new LinkedList();
    AppMethodBeat.o(135601);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135602);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.wNz);
      paramVarArgs.am(2, this.wMX);
      paramVarArgs.e(3, 8, this.wpb);
      AppMethodBeat.o(135602);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.wNz);
      i = e.a.a.b.b.a.p(2, this.wMX);
      int j = e.a.a.a.c(3, 8, this.wpb);
      AppMethodBeat.o(135602);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wpb.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(135602);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      uy localuy = (uy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(135602);
        return -1;
      case 1: 
        localuy.wNz = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(135602);
        return 0;
      case 2: 
        localuy.wMX = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(135602);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ux();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ux)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localuy.wpb.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(135602);
      return 0;
    }
    AppMethodBeat.o(135602);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uy
 * JD-Core Version:    0.7.0.1
 */