package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class bjq
  extends com.tencent.mm.bv.a
{
  public int jJu;
  public LinkedList<Integer> xaU;
  public LinkedList<bjn> xxY;
  
  public bjq()
  {
    AppMethodBeat.i(60059);
    this.xaU = new LinkedList();
    this.xxY = new LinkedList();
    AppMethodBeat.o(60059);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60060);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jJu);
      paramVarArgs.f(2, 2, this.xaU);
      paramVarArgs.e(3, 8, this.xxY);
      AppMethodBeat.o(60060);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.jJu);
      i = e.a.a.a.d(2, 2, this.xaU);
      int j = e.a.a.a.c(3, 8, this.xxY);
      AppMethodBeat.o(60060);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xaU.clear();
      this.xxY.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(60060);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bjq localbjq = (bjq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(60060);
        return -1;
      case 1: 
        localbjq.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60060);
        return 0;
      case 2: 
        localbjq.xaU = new e.a.a.a.a(((e.a.a.a.a)localObject1).CLY.eqS().pW, unknownTagHandler).CLY.eqR();
        AppMethodBeat.o(60060);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bjn();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bjn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbjq.xxY.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(60060);
      return 0;
    }
    AppMethodBeat.o(60060);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjq
 * JD-Core Version:    0.7.0.1
 */